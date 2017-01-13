/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Model;
import entities.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
@WebServlet(name = "Controller", urlPatterns = {"/models", "/addmodel", "/addmodelname", "/part", "/deletePart"})
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
            getServletContext().setAttribute("models", modelFacade.findAll());

            Model selectedModel = new Model();
            if (request.getParameter("model") != null) {
                Long modelId = Long.parseLong(request.getParameter("model"));
                selectedModel = modelFacade.find(modelId);
                getServletContext().setAttribute("model", modelFacade.findAll());
            }
            request.getRequestDispatcher("/models.jsp").forward(request, response);

        } else if ("/addmodelname".equals(userPath)) {
            String newmodelname = request.getParameter("newmodel");
            Model newModel = new Model(newmodelname, new ArrayList<Part>());
            modelFacade.create(newModel);
            getServletContext().setAttribute("models", modelFacade.findAll());
            response.sendRedirect("models.jsp");
            return;

        } else if ("/addmodel".equals(userPath)) {
            Model selectedModel = new Model();

            if (request.getParameter("model") != null) {
                Long modelId = Long.parseLong(request.getParameter("model"));
                selectedModel = modelFacade.find(modelId);
                getServletContext().setAttribute("selectedModel", selectedModel);
                request.getRequestDispatcher("/models.jsp").forward(request, response);
            }

            if (request.getParameter("newpartname") != "" && request.getParameter("newpartdescription") != ""
                    && request.getParameter("newpartprice") != "" && request.getParameter("newpartduration") != "") {
                String newpartname = request.getParameter("newpartname");
                String newpartdescription = request.getParameter("newpartdescription");
                Integer newpartprice = Integer.parseInt(request.getParameter("newpartprice"));
                Integer newpartduration = Integer.parseInt(request.getParameter("newpartduration"));
                Part newPart = new Part(newpartname, newpartdescription, newpartprice, newpartduration);
                selectedModel.getParts().add(newPart);
                modelFacade.edit(selectedModel);
                getServletContext().setAttribute("models", modelFacade.findAll());
                request.getRequestDispatcher("/models.jsp").forward(request, response);
            }

        } else if ("/deletePart".equals(userPath)) {
            Part partToDelete = new Part();
            Model selectedModel = new Model();

            if (request.getParameter("delete-part-id") != null) {
                Long partToDeleteId = Long.parseLong(request.getParameter("delete-part-id"));
                Long modelId = Long.parseLong(request.getParameter("selected-model-id"));
                selectedModel = modelFacade.find(modelId);
                List<Part> parts = selectedModel.getParts();
                for (Part p : parts) {
                    if (p.getId() == partToDeleteId) {
                        partToDelete = p;
                    }
                }
                selectedModel.getParts().remove(partToDelete);
                modelFacade.edit(selectedModel);
                getServletContext().setAttribute("models", modelFacade.findAll());
                request.getRequestDispatcher("/models.jsp").forward(request, response);
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
