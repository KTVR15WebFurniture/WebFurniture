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
public class WorkerController extends HttpServlet {

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
//            Long orderId = Long.parseLong(request.getParameter("order"));
//            Long modelId = Long.parseLong(request.getParameter("model"));
//            Long partId = Long.parseLong(request.getParameter("operation"));
            String workerFirstname = request.getParameter("firstname");
            String workerLastname = request.getParameter("lastname");
            Integer profit = 0;
            getServletContext().setAttribute("week", week);
            getServletContext().setAttribute("month", month);
            getServletContext().setAttribute("year", year);
            
            
            if (week != 0 && month != 0 && year != 0) {
                
                List<OrderFurniture> orderFurnitures = orderFacade.findAll();
                List<OrderFurniture> orders = new ArrayList<>();
                for(OrderFurniture furniture : orderFurnitures){
                    if(furniture.getOrderDate().getWeek() == week && furniture.getOrderDate().getMonth() == month && furniture.getOrderDate().getYear() == year){
                        orders.add(furniture);
                    }
                }
                getServletContext().setAttribute("orders", orders);
            }
            if (workerFirstname != null && workerLastname != null) {
                getServletContext().setAttribute("workerFirstname", workerFirstname);
                getServletContext().setAttribute("workerLastname", workerLastname);

            }
//            if (orderId != 0) {
//                OrderFurniture selectedOrder = orderFacade.find(orderId);
//                getServletContext().setAttribute("selectedOrder", selectedOrder);
//
//            }
//            if (modelId != 0) {
//                Model selectedModel = modelFacade.find(modelId);
//                getServletContext().setAttribute("selectedModel", selectedModel);
//            }
//            if (partId != 0) {
//                Part selectedPart = partFacade.find(partId);
//                getServletContext().setAttribute("selectedPart", selectedPart);
//            }
//            if (week != 0 && month != 0 && year != 0 && orderId != 0 && modelId != 0 && partId != 0 && workerFirstname != null && workerLastname != null) {
//                OrderFurniture order = orderFacade.find(orderId);
//                Model model = modelFacade.find(modelId);
//                Part part = partFacade.find(partId);
//                List<Worker> workers = workerFacade.findAll();
//                for (Worker worker : workers) {
//                    if (worker.getFirstname().equals(workerFirstname) && worker.getLastname().equals(workerLastname)) {
//                        Worker selectedWorker = workerFacade.find(worker.getId());
//                        DoneWork doneWork = new DoneWork(week, month, year, order, model, part, selectedWorker);
//                        doneWorkFacade.create(doneWork);
//                        break;
//                    }
//                }
//
//                profit += part.getPrice();
//                getServletContext().setAttribute("profit", profit);
//                getServletContext().setAttribute("doneWorks", doneWorkFacade.findAll());
//
//            }

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
