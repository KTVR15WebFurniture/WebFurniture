/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Model;
import entities.Part;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.ModelFacade;
import session.PartFacade;

/**
 *
 * @author pupil
 */
@WebServlet(name = "Controller", urlPatterns = {"/models"})
public class ModelController extends HttpServlet {

    @EJB
    ModelFacade modelFacade;
    PartFacade partFacade;

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

        String userPath = request.getServletPath();
        if ("/models".equals(userPath)) {

            String newmodel = request.getParameter("newmodel");

            if (newmodel != null) {
                getServletContext().setAttribute("newmodel", newmodel);
            }

            String newpartname = request.getParameter("newpartname");
            String newpartdescription = request.getParameter("newpartdescription");
            String newpartprice = request.getParameter("newpartprice");
            String newparttime = request.getParameter("newparttime");

            if (newpartname != null && newpartdescription != null && newpartprice != null && newparttime != null) {
                getServletContext().setAttribute("newpartname", newpartname);
                getServletContext().setAttribute("newpartdescription", newpartdescription);
                getServletContext().setAttribute("newpartprice", newpartprice);
                getServletContext().setAttribute("newparttime", newparttime);
            }

            Long modelId = Long.parseLong(request.getParameter("model"));
            Long partId = Long.parseLong(request.getParameter("operation"));

            if (modelId != 0L) {
                Model selectedModel = modelFacade.find(modelId);
                getServletContext().setAttribute("selectedModel", selectedModel);
            }

            if (partId != 0L) {
                Part selectedPart = partFacade.find(partId);
                getServletContext().setAttribute("selectedPart", selectedPart);
            }

            List<Model> models = modelFacade.findAll();
            getServletContext().setAttribute("models", models);

            List<Part> parts = partFacade.findAll();
            getServletContext().setAttribute("parts", parts);

        }
        request.getRequestDispatcher("/WEB-INF" + userPath + ".jsp").forward(request, response);
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
