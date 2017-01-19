package controller;

import entities.Worker;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.WorkerFacade;

@WebServlet(name = "WorkerController", urlPatterns = {"/worker", "/forWorker", "/selectWorker"})
public class WorkerController extends HttpServlet {

    @EJB
    WorkerFacade workerFacade;
//    @EJB
//    WorkerFacade forWorkerFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String msg=""; // Информационное сообщение, которое будет выводится на страничке
        // Worker worker=new Worker();
        String userPath = request.getServletPath();
        if ("/worker".equals(userPath)) {
            getServletContext().setAttribute("workers", workerFacade.findAll());
            request.getRequestDispatcher("/worker.jsp").forward(request, response);
        } else if ("/forWorker".equals(userPath)) {

            String firstname = "";
            String lastname = "";
            String isikukood = "";
            String mail = "";
            String telephon = "";
            String status = "";
            Worker worker = new Worker();
            if (request.getParameter("add") != null) {
                //добываем параметры из запроса
                firstname = request.getParameter("firstname");
                lastname = request.getParameter("lastname");
                isikukood = request.getParameter("isikukood");
                mail = request.getParameter("mail");
                telephon = request.getParameter("telephon");
                status = request.getParameter("status");
                //проверяем на пустоту параметра и инициируем объект энтити worker (без параметра id)
                if (firstname != "" && lastname != "" && isikukood != "" && mail != "" && telephon != "" && status != ""
                        && firstname != null && lastname != null && isikukood != null && mail != null && telephon != null && status != null) {
                    worker = new Worker(status, firstname, lastname, isikukood, mail, telephon);
                }
                try {
                    workerFacade.create(worker);
                    //т.к. работник успешно добавлен, то сообщаем об этом на страничке
                    msg = "Работник добавлен!";
                    
                } catch (Exception e) {
                    //т.к. работник не добавлен, то сообщаем об этом на страничке
                    msg = "Не добавлено. Такой работник существует";
                    request.setAttribute("infoMassage", msg);
                    // также сообщаем страничке введенные пользователем данные
                    request.setAttribute("worker", worker);
                }
            } else if (request.getParameter("update") != null) {
                //пользователь нажал кнопку "Изменить"
                Long id = null;
                if (request.getParameter("id") != null) {
                    id = Long.decode(request.getParameter("id"));
                }
                //находим по id работника в базе
                worker = workerFacade.find(id);
                //изменяем ему состояние, которое берем из формы странички
                worker.setFirstname(request.getParameter("firstname"));
                worker.setLastname(request.getParameter("lastname"));
                worker.setIsikukood(request.getParameter("isikukood"));
                worker.setMail(request.getParameter("mail"));
                worker.setTelephon(request.getParameter("telephon"));
                worker.setStatus(request.getParameter("status"));
                //Записываем новое состояние работника
                try {
                    workerFacade.edit(worker);
                    msg = "Обновлено!";
                } catch (Exception e) {
                    msg = "Необновлено!";
                }
                request.setAttribute("worker", worker);
            } else if (request.getParameter("remove") != null) {
                //пользователь нажал кнопку "Удалить"
                Long id = null;
                if (request.getParameter("id") != null) {
                    id = Long.decode(request.getParameter("id"));
                }
                worker = workerFacade.find(id);
                try {
                    workerFacade.remove(worker);
                    msg = "Работник удален!";
                } catch (Exception e) {
                    msg = "Не удален.";
                    request.setAttribute("worker", worker);
                }
            }
            request.setAttribute("infoMassage", msg);
            request.setAttribute("workers", workerFacade.findAll());
            request.getRequestDispatcher("/worker.jsp").forward(request, response);
        } else if ("/selectWorker".equals(userPath)) {
            Long idWorker = Long.parseLong(request.getParameter("selectWorker"));
            Worker worker = workerFacade.find(idWorker);
            request.setAttribute("worker", worker);
            request.setAttribute("workers", workerFacade.findAll());
            request.getRequestDispatcher("/worker.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

