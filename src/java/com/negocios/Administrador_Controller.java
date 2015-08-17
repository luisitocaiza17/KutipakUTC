/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocios;

import com.datos.DAO.TiposPalabrasDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import persistencia.tables.records.TipospalabrasRecord;

/**
 *
 * @author luisito
 */
@WebServlet(name = "Administrador_Controller", urlPatterns = {"/Administrador_Controller"})
public class Administrador_Controller extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Administrador_Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Administrador_Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
        
       JSONObject result = new JSONObject();
		try {
                    
                        JSONObject planJSONObject = new JSONObject();
                        String tipoConsulta = request.getParameter("tipoConsulta") == null ? "" : request.getParameter("tipoConsulta");
			String operacion = request.getParameter("operacion") == null ? "" : request.getParameter("operacion");
			
                        if(tipoConsulta.equals("TodosTipos")){
                             TiposPalabrasDAO tiposPalabras = new TiposPalabrasDAO();
                             List<TipospalabrasRecord> results = tiposPalabras.ConsultarTiposPalabras();
                             JSONArray JSONArrayTipos = new JSONArray();  
                             for(TipospalabrasRecord rs : results){
                                 planJSONObject.put("tipo", rs.getNombretipo());
                                 planJSONObject.put("nemotecnico", rs.getNemotecnico());
                                 planJSONObject.put("id", rs.getTipoid());
                                 JSONArrayTipos.add(planJSONObject);
                             }
                             result.put("listadoTipos", JSONArrayTipos);
                             result.put("success", Boolean.TRUE);
                         }
                        
                        /*procesos con los datos*/
                        if(operacion.toUpperCase().equals("INSERTAR")){
                            String nombrePalabra = request.getParameter("nombrePalabra") == null ? "" : request.getParameter("nombrePalabra");
			    String nemotecnico = request.getParameter("nemotecnico") == null ? "" : request.getParameter("nemotecnico");
			    TipospalabrasRecord tipoPalabras= new TipospalabrasRecord();
                            tipoPalabras.setNombretipo(nombrePalabra.toUpperCase());
                            tipoPalabras.setNemotecnico(nemotecnico.toUpperCase());
                            TiposPalabrasDAO tiposPalabrasProcesos = new TiposPalabrasDAO();
                            tiposPalabrasProcesos.grabartiposPalabras(tipoPalabras);
                            result.put("success", Boolean.TRUE);
                            result.put("mensaje", "GUARDADO CORRECTO");
                        }
                       
                         response.setContentType("application/json; charset=ISO-8859-1"); 
                         result.write(response.getWriter());
                    } catch (Exception e) {
                        e.printStackTrace();
			result.put("success", Boolean.FALSE);
			result.put("mensaje",e);
			response.setContentType("application/json; charset=ISO-8859-1"); 
			result.write(response.getWriter());
                       
                }
                
        
        
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
