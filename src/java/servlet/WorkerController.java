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
            Integer profit = 0;
            getServletContext().setAttribute("week", week);
            getServletContext().setAttribute("month", month);
            getServletContext().setAttribute("year", year);

            if (week != 0 && month != 0 && year != 0) {

                List<OrderFurniture> orderFurnitures = orderFacade.findAll();
                List<OrderFurniture> orders = new ArrayList<>();
                for (OrderFurniture furniture : orderFurnitures) {
                    if (furniture.getOrderDate().getWeek() == week && furniture.getOrderDate().getMonth() == month && furniture.getOrderDate().getYear() == year) {
                        orders.add(furniture);
                    }
                }
                getServletContext().setAttribute("orders", orders);
            }
            if (request.getParameter("workerId") != null) {
                Long workerId = Long.parseLong(request.getParameter("workerId"));
                OrderFurniture selectedWorker = orderFacade.find(workerId);
                getServletContext().setAttribute("selectedWorker", selectedWorker);
                List<DoneWork> doneWorks = new ArrayList<>();
                List<DoneWork> doneWorka = doneWorkFacade.findAll();
                for(DoneWork doneWork : doneWorka){
                    if(doneWork.getWorker().getId() == workerId){
                        doneWorks.add(doneWork);
                    }
                }
                getServletContext().setAttribute("doneWorks", doneWorks);
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
            if (week != 0 && month != 0 && year != 0 && request.getParameter("orderId") != null && request.getParameter("modelId") != null && request.getParameter("operationId") != null && request.getParameter("workerId") != null) {
                Long orderId = Long.parseLong(request.getParameter("orderId"));
                Long modelId = Long.parseLong(request.getParameter("modelId"));
                Long partId = Long.parseLong(request.getParameter("operationId"));
                Long workerId = Long.parseLong(request.getParameter("workerId"));
                OrderFurniture order = orderFacade.find(orderId);
                Model model = modelFacade.find(modelId);
                Part part = partFacade.find(partId);
                Worker worker = workerFacade.find(workerId);
                DoneWork doneWork = new DoneWork(week, month, year, order, model, part, worker);
                doneWorkFacade.create(doneWork);

                profit += part.getPrice();
                getServletContext().setAttribute("profit", profit);

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
