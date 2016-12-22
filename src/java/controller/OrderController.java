package controller;

import entities.Model;
import entities.OrderDate;
import entities.OrderFurniture;
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
import session.ModelFacade;
import session.OrderDateFacade;
import session.OrderFurnitureFacade;

@WebServlet(name = "OrderController", urlPatterns = {"/order", "/workers", "/bookkeeper"})
public class OrderController extends HttpServlet {

    @EJB
    OrderFurnitureFacade orderFurnitureFacade;
    @EJB
    ModelFacade modelFacade;

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

        if ("/OrderFurniture".equals(request.getServletPath())) {
            
            getServletContext().setAttribute("models", modelFacade.findAll());
            getServletContext().setAttribute("orders", orderFurnitureFacade.findAll());
            if (request.getParameter("orderName") != null && request.getParameter("model1") != null && request.getParameter("qt1") != null && request.getParameter("weekend") != null && request.getParameter("month") != null && request.getParameter("yearo") != null) {
                String orderName = request.getParameter("orderName");
                Long model1 = Long.parseLong(request.getParameter("model1"));
                Integer qt1 = Integer.parseInt(request.getParameter("qt1"));
                Integer weekend = Integer.parseInt(request.getParameter("weekend"));
                Integer month = Integer.parseInt(request.getParameter("month"));
                Integer yearo = Integer.parseInt(request.getParameter("yearo"));

                List<Model> models = new ArrayList<>();
                
                if(model1 != 0){
                    Model selectedModel = modelFacade.find(model1);
                    for(Integer i = 1;i <= qt1; i++){
                        selectedModel.setName(getServletName() + " " + i);
                        models.add(selectedModel);
                    }
                }
                
                if(Long.parseLong(request.getParameter("model2")) != 0){
                    Long model2 = Long.parseLong(request.getParameter("model2"));
                    Integer qt2 = Integer.parseInt(request.getParameter("qt2"));
                
                    Model selectedModel = modelFacade.find(model2);
                    for(Integer i = 1;i <= qt2; i++){
                        selectedModel.setName(getServletName() + " " + i);
                        models.add(selectedModel);
                    }
                }
                if(Long.parseLong(request.getParameter("model3")) != 0){
                    Long model3 = Long.parseLong(request.getParameter("model3"));
                    Integer qt3 = Integer.parseInt(request.getParameter("qt3"));
                
                    Model selectedModel = modelFacade.find(model3);
                    for(Integer i = 1;i <= qt3; i++){
                        selectedModel.setName(getServletName() + " " + i);
                        models.add(selectedModel);
                    }
                }
                if(Long.parseLong(request.getParameter("model4")) != 0){
                    Long model4 = Long.parseLong(request.getParameter("model4"));
                    Integer qt4 = Integer.parseInt(request.getParameter("qt4"));
                
                    Model selectedModel = modelFacade.find(model4);
                    for(Integer i = 1;i <= qt4; i++){
                        selectedModel.setName(getServletName() + " " + i);
                        models.add(selectedModel);
                    }
                }
                if(Long.parseLong(request.getParameter("model5")) != 0){
                    Long model5 = Long.parseLong(request.getParameter("model5"));
                    Integer qt5 = Integer.parseInt(request.getParameter("qt5"));
                    Model selectedModel = modelFacade.find(model5);
                    for(Integer i = 1;i <= qt5; i++){
                        selectedModel.setName(getServletName() + " " + i);
                        models.add(selectedModel);
                    }
                }
                
                OrderDate orderDate = new OrderDate(weekend, month, yearo);

                OrderFurniture orderFurniture = new OrderFurniture(orderName, models, orderDate);

                orderFurnitureFacade.create(orderFurniture);

            }
            request.getRequestDispatcher("order.jsp").forward(request, response);

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
