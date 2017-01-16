/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Model;
import entities.OrderDate;
import entities.OrderFurniture;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.ModelFacade;
import session.OrderFurnitureFacade;
import util.DateMyFormat;

/**
 *
 * @author pupil
 */
@WebServlet(name = "OrderController", urlPatterns = {"/order", "/create_order", "/load", "/delete"})
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
        String msg = ""; // Информационное сообщение, которое будет выводится на страничке
        DateMyFormat dateMyFormat = new DateMyFormat();
        List<String> curentDate = new ArrayList<>();
        curentDate.add(dateMyFormat.getCurentWeek().toString());
        curentDate.add(dateMyFormat.getCurentMonth().toString());
        curentDate.add(dateMyFormat.getCurentYear().toString());
        String userPath = request.getServletPath();
        if ("/order".equals(userPath)) {
            getServletContext().setAttribute("curentDate", curentDate);
            getServletContext().setAttribute("orders", orderFurnitureFacade.oderByTodey());
            getServletContext().setAttribute("models", modelFacade.findAll());
            request.getRequestDispatcher("/order.jsp").forward(request, response);
        } else if ("/create_order".equals(userPath)) {
            if (request.getParameter("add") != null) {
//            Получаем данные из формы
                String week = request.getParameter("select_week");
                String month = request.getParameter("select_month");
                String year = request.getParameter("select_year");
                String orderName = request.getParameter("order_name");
                Map<Model, Integer> models = new HashMap<>();
                Model model = new Model();
                for (Integer i = 1; i < 6; i++) {
                    if (!"".equals(request.getParameter("model_name" + i.toString()))) {
                        model = modelFacade.find(Long.decode(request.getParameter("model_name" + i.toString())));
                        models.put(model, Integer.decode(request.getParameter("model_count" + i.toString())));
                    }
                }
//              Инициируем дату выполнения ордера
                OrderDate orderDate = new OrderDate();
                orderDate.setWeek_(Integer.parseInt(week));
                orderDate.setMonth_(Integer.parseInt(month));
                orderDate.setYear_(Integer.parseInt(year));
//                Инициируем заказ
                OrderFurniture orderFurniture = new OrderFurniture();
                orderFurniture.setModels(models);
                orderFurniture.setName(orderName);
                orderFurniture.setOrderDate(orderDate);
                try {
                    orderFurnitureFacade.create(orderFurniture);
                    msg = "Ордер добавлен.";
                } catch (Exception e) {
                    msg = "Ордер добавть не удалось.";
                    request.setAttribute("infoMassage", msg);
                    getServletContext().setAttribute("curentDate", curentDate);
                    getServletContext().setAttribute("orders", orderFurnitureFacade.oderByTodey());
                    getServletContext().setAttribute("models", modelFacade.findAll());
                    request.getRequestDispatcher("/order.jsp").forward(request, response);
                }

                request.setAttribute("infoMassage", msg);
                getServletContext().setAttribute("curentDate", curentDate);
                getServletContext().setAttribute("orders", orderFurnitureFacade.oderByTodey());
                getServletContext().setAttribute("models", modelFacade.findAll());
                request.getRequestDispatcher("/order.jsp").forward(request, response);
            }
            if (request.getParameter("update") != null) {

            }
        } else if ("/load".equals(userPath)) {
            OrderFurniture orderFurniture = null;
            try {
                String orderId = request.getParameter("load_order_id");
                orderFurniture = orderFurnitureFacade.find(Long.decode(orderId));

            } catch (Exception e) {
                msg = "Ордер ${orderFurniture.name} не был прочитан";
            }

        } else if ("/delete".equals(userPath)) {
            OrderFurniture orderFurniture = null;
            try {
                String orderId = request.getParameter("delete_order_id");
                orderFurniture = orderFurnitureFacade.find(Long.decode(orderId));
                orderFurnitureFacade.remove(orderFurniture);
                msg = "Ордер ${orderFurniture.name} удален!";
                request.setAttribute("infoMassage", msg);
                getServletContext().setAttribute("curentDate", curentDate);
                getServletContext().setAttribute("orders", orderFurnitureFacade.oderByTodey());
                getServletContext().setAttribute("models", modelFacade.findAll());
                request.getRequestDispatcher("/order.jsp").forward(request, response);
            } catch (Exception e) {
                msg = "Ордер ${orderFurniture.name} удалить не удалось";
                request.setAttribute("infoMassage", msg);
                getServletContext().setAttribute("curentDate", curentDate);
                getServletContext().setAttribute("orders", orderFurnitureFacade.oderByTodey());
                getServletContext().setAttribute("models", modelFacade.findAll());
                request.getRequestDispatcher("/order.jsp").forward(request, response);
            }
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
