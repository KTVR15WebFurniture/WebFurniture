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
import java.util.List;
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
@WebServlet(name = "WorkerController", urlPatterns = {"/addWork"})
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
            Calendar today = Calendar.getInstance();
            Integer week = today.get(Calendar.WEEK_OF_YEAR) - 1; //Integer.parseInt(request.getParameter("week"));
            Integer month = today.get(Calendar.MONTH) + 1; //Integer.parseInt(request.getParameter("month"));
            Integer year = today.get(Calendar.YEAR);//Integer.parseInt(request.getParameter("year"));
            Integer profit = 0;
            List<DoneWork> done_Works = new ArrayList<>();
//            Worker worker = new Worker("ivan", "ivanov", "39212234556", "iban@mail.ee", "53596251");
//            Part part = new Part("46131", "leg", 20, 20);
//            List<Part> parts = new ArrayList<>();
//            parts.add(part);
//            Model model = new Model("chair", parts);
//            List<Model> models = new ArrayList<>();
//            models.add(model);
            OrderDate orderDate = new OrderDate(week, month, year);
//            OrderFurniture orderFurniture = new OrderFurniture("kichen", models, orderDate);
//            workerFacade.create(worker);
//            orderFacade.create(orderFurniture);

            getServletContext().setAttribute("orderDate", orderDate);
            getServletContext().setAttribute("workers", workerFacade.findAll());

            if (orderDate.getWeek() != 0 && orderDate.getMonth() != 0 && orderDate.getYear() != 0) {

                List<OrderFurniture> orderFurnitures = orderFacade.findAll();
                List<OrderFurniture> orders = new ArrayList<>();
                for (OrderFurniture furniture : orderFurnitures) {
                    if (Objects.equals(furniture.getOrderDate().getWeek(), week) && Objects.equals(furniture.getOrderDate().getMonth(), month) && Objects.equals(furniture.getOrderDate().getYear(), year)) {
                        orders.add(furniture);
                    }
                }
                getServletContext().setAttribute("orders", orders);
            }
            if (request.getParameter("workerId") != null) {
                Long workerId = Long.parseLong(request.getParameter("workerId"));
                getServletContext().setAttribute("workerId", workerId);
                Worker selectedWorker = workerFacade.find(workerId);
                getServletContext().setAttribute("selectedWorker", selectedWorker);
                List<DoneWork> doneWorks = doneWorkFacade.findAll();
                getServletContext().setAttribute("doneWorks", doneWorks);
                for(DoneWork dw : doneWorks){
                    if(Objects.equals(dw.getWorker().getId(), workerId)){
                        profit += dw.getPart().getPrice();
                    }
                    if(Objects.equals(dw.getOrderDate().getWeek(), orderDate.getWeek()) && Objects.equals(dw.getOrderDate().getMonth(), orderDate.getMonth()) && Objects.equals(dw.getOrderDate().getYear(), orderDate.getYear()) && Objects.equals(dw.getWorker().getId(), workerId)){
                        done_Works.add(dw);
                    }
                }
                getServletContext().setAttribute("profit", profit);
                getServletContext().setAttribute("doneWorks", done_Works);
            }
            if (request.getParameter("orderId") != null) {
                Long orderId = Long.parseLong(request.getParameter("orderId"));
                OrderFurniture selectedOrder = orderFacade.find(orderId);
                getServletContext().setAttribute("selectedOrder", selectedOrder);

            }
            if (request.getParameter("modelId") != null) {
                Long modelId = Long.parseLong(request.getParameter("modelId"));
                Model selectedModel = modelFacade.find(modelId);
                getServletContext().setAttribute("selectedModel", selectedModel);
            }
            if (request.getParameter("operationId") != null) {
                Long partId = Long.parseLong(request.getParameter("operationId"));
                Part selectedPart = partFacade.find(partId);
                getServletContext().setAttribute("selectedPart", selectedPart);
            }
            if (request.getParameter("week") != null && request.getParameter("month") != null && request.getParameter("year") != null && request.getParameter("orderId") != null && !"0".equals(request.getParameter("orderId")) && request.getParameter("modelId") != null && !"0".equals(request.getParameter("modelId")) && request.getParameter("operationId") != null && !"0".equals(request.getParameter("operationId")) && request.getParameter("workerId") != null && !"0".equals(request.getParameter("workerId"))) {
                Long orderId = Long.parseLong(request.getParameter("orderId"));
                Long modelId = Long.parseLong(request.getParameter("modelId"));
                Long partId = Long.parseLong(request.getParameter("operationId"));
                Long workerId = Long.parseLong(request.getParameter("workerId"));
                OrderFurniture order = orderFacade.find(orderId);
                Model model = modelFacade.find(modelId);
                Part part = partFacade.find(partId);
                Worker worker = workerFacade.find(workerId);
                orderDate = orderDateFacade.find(order.getOrderDate().getId());
                DoneWork doneWork = new DoneWork(orderDate, order, model, part, worker);
                doneWorkFacade.create(doneWork);

            }

            request.getRequestDispatcher("WEB-INF/order_selection.jsp").forward(request, response);
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
