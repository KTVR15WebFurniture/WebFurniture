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
@WebServlet(name = "Controller", urlPatterns = {"/models", "/editmodel", "/addmodelname", "/part", "/deletePart", "/editPart"})
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

        } else if ("/editmodel".equals(userPath)) {
            Model selectedModel = new Model();

            if (request.getParameter("model") != null) {
                Long modelId = Long.parseLong(request.getParameter("model"));
                selectedModel = modelFacade.find(modelId);
                getServletContext().setAttribute("selectedModel", selectedModel);
                request.getRequestDispatcher("/models.jsp").forward(request, response);

                if (request.getParameter("save") != null) {
                    if (request.getParameter("part_name") != "" && request.getParameter("part_description") != ""
                            && request.getParameter("part_price") != "" && request.getParameter("part_duration") != "") {
                        String newpartname = request.getParameter("part_name");
                        String newpartdescription = request.getParameter("part_description");
                        Integer newpartprice = Integer.parseInt(request.getParameter("part_price"));
                        Integer newpartduration = Integer.parseInt(request.getParameter("part_duration"));
                        Part newPart = new Part(newpartname, newpartdescription, newpartprice, newpartduration);
                        selectedModel.getParts().add(newPart);

                        modelFacade.edit(selectedModel);
                        getServletContext().setAttribute("models", modelFacade.findAll());
                        request.getRequestDispatcher("/models.jsp").forward(request, response);
                    }
                }
                if (request.getParameter("update") != null) {
                    if (request.getParameter("part_id") != null) {
                        Part oldPart = new Part();
                        Long oldPartId = Long.parseLong(request.getParameter("part_id"));
                        List<Part> parts = selectedModel.getParts();
                        for (Part p : parts) {
                            if (p.getId() == oldPartId) {
                                oldPart = p;
                            }
                        }
                        if (request.getParameter("part_id") != null && request.getParameter("part_name") != "" && request.getParameter("part_description") != ""
                                && request.getParameter("part_price") != "" && request.getParameter("part_duration") != "") {

                            String editedpartname = request.getParameter("part_name");
                            String editedpartdescription = request.getParameter("part_description");
                            Integer editedpartprice = Integer.parseInt(request.getParameter("part_price"));
                            Integer editedpartduration = Integer.parseInt(request.getParameter("part_duration"));
                            Part editedPart = new Part(editedpartname, editedpartdescription, editedpartprice, editedpartduration);

                            selectedModel.getParts().add(editedPart);
                            selectedModel.getParts().remove(oldPart);
                            modelFacade.edit(selectedModel);

                            getServletContext().setAttribute("models", modelFacade.findAll());                            
                            request.getRequestDispatcher("/models.jps").forward(request, response);

                        }
                    }
                }
            }

        } else if ("/deletePart".equals(userPath)) {
            Part partToDelete = new Part();
            Model selectedModel = new Model();

            if (request.getParameter("delete_part_id") != null) {
                Long partToDeleteId = Long.parseLong(request.getParameter("delete_part_id"));
                Long modelId = Long.parseLong(request.getParameter("selected_model_id"));
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

        } else if ("/editPart".equals(userPath)) {
            Part partToEdit = new Part();
            Model selectedModel = new Model();

            if (request.getParameter("edit_part_id") != null) {
                Long partToEditId = Long.parseLong(request.getParameter("edit_part_id"));
                Long modelId = Long.parseLong(request.getParameter("selected_model_id"));
                selectedModel = modelFacade.find(modelId);
                List<Part> parts = selectedModel.getParts();
                for (Part p : parts) {
                    if (p.getId() == partToEditId) {
                        partToEdit = p;
                    }
                }

                getServletContext().setAttribute("partToEdit", partToEdit);
                getServletContext().setAttribute("models", modelFacade.findAll());
                getServletContext().setAttribute("selectedModel", selectedModel);
                request.getRequestDispatcher("/models.jsp").forward(request, response);
                getServletContext().setAttribute("partToEdit", null);
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
