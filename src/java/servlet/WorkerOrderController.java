/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entities.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.DoneWorkFacade;
import session.ModelFacade;
import session.OrderDateFacade;
import session.OrderFurnitureFacade;
import session.PartFacade;
import session.WorkerFacade;

/**
 *
 * @author pupil
 */
@WebServlet(name = "WorkerController", urlPatterns = {"/addWork", "/deleteWork"})
public class WorkerOrderController extends HttpServlet {

    @EJB
    ModelFacade modelFacade;
    @EJB
    PartFacade partFacade;
    @EJB
    OrderFurnitureFacade orderFacade;
    @EJB
    OrderDateFacade orderDateFacade;
    @EJB
    DoneWorkFacade doneWorkFacade;
    @EJB
    WorkerFacade workerFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if ("/addWork".equals(request.getServletPath())) {
//            Worker worker = new Worker("ivan", "ivanov", "39212234556", "ivan@mail.ee", "53596251");
//        Part part = new Part("46131", "4 legs", 20, 20);
//        List<Part> parts = new ArrayList<>();
//        parts.add(part);
//        Model model = new Model("chair", parts);
//        Map<Model,Integer> models = new HashMap<>();
//        models.put(model, 4);
//        OrderDate orderDate = new OrderDate(4, 1, 2017);
//        OrderFurniture orderFurniture = new OrderFurniture("kichen", models, orderDate);
//        workerFacade.create(worker);
//        orderFacade.create(orderFurniture);
            Integer profit = 0;
            Calendar today = Calendar.getInstance();
            Integer week = today.get(Calendar.WEEK_OF_YEAR); //Integer.parseInt(request.getParameter("week"));
            Integer month = today.get(Calendar.MONTH) + 1; //Integer.parseInt(request.getParameter("month"));
            Integer year = today.get(Calendar.YEAR);//Integer.parseInt(request.getParameter("year"));
            getServletContext().setAttribute("week", week);
            getServletContext().setAttribute("month", month);
            getServletContext().setAttribute("year", year);
            getServletContext().setAttribute("workers", workerFacade.findAll());
            if (week != 0 && month != 0 && year != 0) {

                List<OrderFurniture> orderFurnitures = orderFacade.findAll();
                List<OrderFurniture> orders = new ArrayList<>();
                for (OrderFurniture furniture : orderFurnitures) {
                    if (Objects.equals(furniture.getOrderDate().getWeek(), week) && Objects.equals(furniture.getOrderDate().getMonth(), month) && Objects.equals(furniture.getOrderDate().getYear(), year)) {
                        orders.add(furniture);
                    }
                }
                getServletContext().setAttribute("orders", orders);
            }
            if (request.getParameter("workerId") != null && !"".equals(request.getParameter("workerId"))) {
                Long workerId = Long.parseLong(request.getParameter("workerId"));
                OrderFurniture selectedWorker = orderFacade.find(workerId);
                getServletContext().setAttribute("selectedWorker", selectedWorker);
                List<DoneWork> doneWorks1 = doneWorkFacade.findAll(); //DoneWorkByWorkerForWeek(week, month, year, workerId);
                List<DoneWork> doneWorks = new ArrayList<>();
                for (DoneWork doneWork : doneWorks1) {
                    if (Objects.equals(week, doneWork.getWeek()) && Objects.equals(month, doneWork.getMonth()) && Objects.equals(year, doneWork.getYear()) && Objects.equals(workerId, doneWork.getWorker().getId())) {
                        doneWorks.add(doneWork);
                        profit += doneWork.getPart().getPrice();
                    }
                }
                getServletContext().setAttribute("doneWorks", doneWorks);
                getServletContext().setAttribute("profit", profit);
            }
            if (request.getParameter("orderId") != null && !"".equals(request.getParameter("orderId"))) {
                Long orderId = Long.parseLong(request.getParameter("orderId"));
                OrderFurniture selectedOrder = orderFacade.find(orderId);
                getServletContext().setAttribute("selectedOrder", selectedOrder);

            }
            if (request.getParameter("modelId") != null && !"".equals(request.getParameter("modelId"))) {
                Long modelId = Long.parseLong(request.getParameter("modelId"));
                Model selectedModel = modelFacade.find(modelId);

                getServletContext().setAttribute("selectedModel", selectedModel);
            }
            if (request.getParameter("operationId") != null && !"".equals(request.getParameter("operationId"))) {
                Long partId = Long.parseLong(request.getParameter("operationId"));
                Part selectedPart = partFacade.find(partId);
                getServletContext().setAttribute("selectedPart", selectedPart);
            }
            if(request.getParameter("orderId") != null && !"".equals(request.getParameter("orderId")) && request.getParameter("modelId") != null 
                    && !"".equals(request.getParameter("modelId")) && request.getParameter("operationId") != null && !"".equals(request.getParameter("operationId")) 
                    && request.getParameter("workerId") != null && !"".equals(request.getParameter("workerId"))){
                
                Long orderId = Long.parseLong(request.getParameter("orderId"));
                OrderFurniture order = orderFacade.find(orderId);
                Long modelId = Long.parseLong(request.getParameter("modelId"));
                Model model = modelFacade.find(modelId);
                Long partId = Long.parseLong(request.getParameter("operationId"));
                Part part = partFacade.find(partId);
                List<DoneWork> doneWorks = doneWorkFacade.listDoneWork(order, model, part);
                Integer ammountForPart = 0;
                for(DoneWork doneWork : doneWorks){
                        ammountForPart += doneWork.getDone();
                }
                List<Integer> ammounts = new ArrayList<>();
                for(int i = 1; i <= order.getModels().get(model) - ammountForPart; i++){
                    ammounts.add(i);
                }
                
                getServletContext().setAttribute("ammounts", ammounts);
            }
            if (week != 0 && month != 0 && year != 0 && request.getParameter("orderId") != null && !"".equals(request.getParameter("orderId"))
                    && request.getParameter("modelId") != null && !"".equals(request.getParameter("modelId")) && request.getParameter("operationId") != null
                    && !"".equals(request.getParameter("operationId")) && request.getParameter("workerId") != null && !"".equals(request.getParameter("workerId")) 
                            && request.getParameter("ammount") != null && !"".equals(request.getParameter("ammount"))) {
                Long orderId = Long.parseLong(request.getParameter("orderId"));
                Long modelId = Long.parseLong(request.getParameter("modelId"));
                Long partId = Long.parseLong(request.getParameter("operationId"));
                Long workerId = Long.parseLong(request.getParameter("workerId"));
                Integer ammount = Integer.parseInt(request.getParameter("ammount"));
                OrderFurniture order = orderFacade.find(orderId);
                Model model = modelFacade.find(modelId);
                Part part = partFacade.find(partId);
                Worker worker = workerFacade.find(workerId);
                DoneWork doneWork = new DoneWork(week, month, year, order, model, part, worker);
                doneWork.setDone(ammount);
                doneWorkFacade.create(doneWork);

                getServletContext().removeAttribute("profit");
                getServletContext().removeAttribute("selectedModel");
                getServletContext().removeAttribute("selectedOrder");
                getServletContext().removeAttribute("selectedPart");
                getServletContext().removeAttribute("doneWorks");
                getServletContext().removeAttribute("selectedWorker");

            }

            request.getRequestDispatcher("order_selection.jsp").forward(request, response);
        }
        if ("/deleteWork".equals(request.getServletPath())) {
            Long partId = Long.parseLong(request.getParameter("parTID"));
            Long workerId = Long.parseLong(request.getParameter("workeRID"));
            List<DoneWork> doneWorks = doneWorkFacade.findAll();
            for (DoneWork doneWork : doneWorks) {
                if (Objects.equals(partId, doneWork.getPart().getId()) && Objects.equals(workerId, doneWork.getWorker().getId())) {
                    doneWorkFacade.remove(doneWorkFacade.find(doneWork.getId()));
                }
            }
            getServletContext().removeAttribute("profit");
            getServletContext().removeAttribute("selectedModel");
            getServletContext().removeAttribute("selectedOrder");
            getServletContext().removeAttribute("selectedPart");
            getServletContext().removeAttribute("doneWorks");
            getServletContext().removeAttribute("selectedWorker");
            response.sendRedirect("addWork");
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
