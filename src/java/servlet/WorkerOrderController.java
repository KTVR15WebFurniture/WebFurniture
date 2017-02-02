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
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.ejb.EJB;
import javax.management.ObjectName;
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
            Integer week = today.get(Calendar.WEEK_OF_YEAR) - 1; //Integer.parseInt(request.getParameter("week"));
            Integer month = today.get(Calendar.MONTH) + 1; //Integer.parseInt(request.getParameter("month"));
            Integer year = today.get(Calendar.YEAR);//Integer.parseInt(request.getParameter("year"));
            getServletContext().setAttribute("week", week);
            getServletContext().setAttribute("month", month);
            getServletContext().setAttribute("year", year);
            List<Worker> workers = workerFacade.findAll();
            Collections
                    .sort(workers, new Comparator<Worker>() {
                        @Override
                        public int compare(Worker o1, Worker o2) {
                            return o1.getLastname().compareTo(o2.getLastname());
                        }
                    });
            getServletContext().setAttribute("workers", workers);
            if (week != 0 && month != 0 && year != 0) {
               
               Integer currentWeek = 0;
               Integer currentYear = 0;
               Integer currentMonth = 0;
               if(request.getParameter("currentWeek") != null) {
                   currentWeek = Integer.parseInt(request.getParameter("currentWeek"));
               }
               if(week != currentWeek && currentWeek != 0){
                   week = currentWeek;
               }
               
               
               if(request.getParameter("currentMonth") != null) {
                   currentMonth = Integer.parseInt(request.getParameter("currentMonth"));
               }
               if(month != currentMonth && currentMonth != 0){
                   month = currentMonth;
               }
               
               
               if(request.getParameter("currentYear") != null) {
                   currentYear = Integer.parseInt(request.getParameter("currentYear"));
               }
               if(year != currentYear && currentYear != 0){
                   year = currentYear;
               }

                List<OrderFurniture> orderFurnitures = orderFacade.ordersByDate(week, month, year);
                getServletContext().setAttribute("orders", orderFurnitures);
                
                getServletContext().removeAttribute("week");
                getServletContext().setAttribute("week", week);
                getServletContext().removeAttribute("month");
                getServletContext().setAttribute("month", month);
                getServletContext().removeAttribute("year");
                getServletContext().setAttribute("year", year);
            }
            if (request.getParameter("workerId") != null && !"".equals(request.getParameter("workerId"))) {
                Long workerId = Long.parseLong(request.getParameter("workerId"));
                Worker selectedWorker = workerFacade.find(workerId);
                getServletContext().setAttribute("selectedWorker", selectedWorker);
                List<DoneWork> doneWorks = doneWorkFacade.doneWorkByWorkerAndDate(month, year, selectedWorker);
                for (DoneWork doneWork : doneWorks) {
                    if (Objects.equals(workerId, doneWork.getWorker().getId())) {
                        
                        profit += doneWork.getPart().getPrice() * doneWork.getDone();
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
            if (request.getParameter("orderId") != null && !"".equals(request.getParameter("orderId")) && request.getParameter("modelId") != null
                    && !"".equals(request.getParameter("modelId")) && request.getParameter("operationId") != null && !"".equals(request.getParameter("operationId"))
                    && request.getParameter("workerId") != null && !"".equals(request.getParameter("workerId"))) {

                Long orderId = Long.parseLong(request.getParameter("orderId"));
                OrderFurniture order = orderFacade.find(orderId);
                Long selectedModelId = Long.parseLong(request.getParameter("modelId"));
                Model selectedModel = modelFacade.find(selectedModelId);

                Long selectedPartId = Long.parseLong(request.getParameter("operationId"));
                Part selectedPart = partFacade.find(selectedPartId);

                List<DoneWork> doneWorks = doneWorkFacade.listDoneWork(order, selectedModel, selectedPart);
                Integer ammountForPart = 0;
                for (DoneWork doneWork : doneWorks) {                   
                        ammountForPart += doneWork.getDone();
                }
                
                List<Integer> ammounts = new ArrayList<>();
                if (order.getModels().get(selectedModel) - ammountForPart != 0) {
                    for (int i = 1; i <= order.getModels().get(selectedModel) - ammountForPart; i++) {
                        ammounts.add(i);
                    }
                }

                getServletContext().setAttribute("ammounts", ammounts);
            }
            if (week != 0 && month != 0 && year != 0 && request.getParameter("orderId") != null && !"".equals(request.getParameter("orderId"))
                    && request.getParameter("modelId") != null && !"".equals(request.getParameter("modelId")) && request.getParameter("operationId") != null
                    && !"".equals(request.getParameter("operationId")) && request.getParameter("workerId") != null && !"".equals(request.getParameter("workerId"))
                    && request.getParameter("quantity") != null && !"".equals(request.getParameter("quantity"))) {
                Long orderId = Long.parseLong(request.getParameter("orderId"));
                Long modelId = Long.parseLong(request.getParameter("modelId"));
                Long partId = Long.parseLong(request.getParameter("operationId"));
                Long workerId = Long.parseLong(request.getParameter("workerId"));
                Integer ammount = Integer.parseInt(request.getParameter("quantity"));
                OrderFurniture order = orderFacade.find(orderId);
                Model model = modelFacade.find(modelId);
                Part part = partFacade.find(partId);
                Worker worker = workerFacade.find(workerId);
                DoneWork doneWork = new DoneWork(week, month, year, order, model, part, worker);
                doneWork.setDone(ammount);
                doneWorkFacade.create(doneWork);

                getServletContext().removeAttribute("selectedOrder");
                getServletContext().removeAttribute("selectedModel");
                getServletContext().removeAttribute("selectedPart");
                getServletContext().removeAttribute("profit");
                getServletContext().removeAttribute("quantity");
                getServletContext().removeAttribute("selectedWorker");

            }

            request.getRequestDispatcher("order_selection.jsp").forward(request, response);
        }
        if ("/deleteWork".equals(request.getServletPath())) {
            Long doneWorkId = Long.parseLong(request.getParameter("doneWorkId"));
            doneWorkFacade.remove(doneWorkFacade.find(doneWorkId));
            getServletContext().removeAttribute("selectedOrder");
            getServletContext().removeAttribute("selectedModel");
            getServletContext().removeAttribute("selectedPart");
            getServletContext().removeAttribute("profit");
            getServletContext().removeAttribute("quantity");
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
