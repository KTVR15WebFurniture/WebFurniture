package controller;

import entities.Worker;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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

    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("workers", workerFacade.findAll());
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Worker worker=new Worker();
        String userPath = request.getServletPath();

        if ("/worker".equals(userPath)) {
            getServletContext().setAttribute("workers", workerFacade.findAll());
            response.sendRedirect("worker.jsp");
            return;
        } else if ("/forWorker".equals(userPath)) {
            //добываем параметры из запроса
            String firstname = "";
            String lastname = "";
            String isikukood = "";
            String mail = "";
            String telephon = "";
            String status = "";
            Worker worker = new Worker();
            if (request.getParameter("add") != null
                    || request.getParameter("update") != null
                    || request.getParameter("remove") != null) {
                firstname = request.getParameter("firstname");
                lastname = request.getParameter("lastname");
                isikukood = request.getParameter("isikukood");
                mail = request.getParameter("mail");
                telephon = request.getParameter("telephon");
                status = request.getParameter("status");
//                if (firstname != "" && lastname != "" && isikukood != "" && mail != "" && telephon != "" && status != "" 
//                        && firstname != null && lastname != null && isikukood != null && mail != null && telephon != null && status != null) {
//                   worker = new Worker(status, firstname, lastname, isikukood, mail, telephon);
////                } else {
////                  
//                }
            }
            if (request.getParameter("add") != null) {

                workerFacade.create(worker);

            } else if (request.getParameter("update") != null) {

                workerFacade.edit(worker);
            } else if (request.getParameter("remove") != null) {

                workerFacade.remove(worker);
            }
//            String idWorker = request.getParameter("id");
//            worker = workerFacade.find(idWorker);
//            request.setAttribute("worker", worker);
            request.setAttribute("workers", workerFacade.findAll());
            request.getRequestDispatcher("/worker.jsp").forward(request, response);
        } else if ("/selectWorker".equals(userPath)) {
            Long idWorker = Long.parseLong(request.getParameter("selectWorker"));
            Worker worker = workerFacade.find(idWorker);
            request.setAttribute("worker", worker);
            request.setAttribute("workers", workerFacade.findAll());
            request.getRequestDispatcher("/worker.jsp").forward(request, response);
//            response.sendRedirect("worker.jsp");
//            return;
        }

//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet WorkerController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet WorkerController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
