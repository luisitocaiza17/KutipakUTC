/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocios;

import com.datos.DAO.TiemposDAO;
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
import persistencia.tables.records.TiemposRecord;

/**
 *
 * @author luisito
 */
@WebServlet(name = "Tiempos_Controller", urlPatterns = {"/Tiempos_Controller"})
public class Tiempos_Controller extends HttpServlet {

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
        JSONObject result = new JSONObject();
		try {
                    
                        JSONObject planJSONObject = new JSONObject();
                        String tipoConsulta = request.getParameter("tipoConsulta") == null ? "" : request.getParameter("tipoConsulta");
			String operacion = request.getParameter("operacion") == null ? "" : request.getParameter("operacion");
			String idTiempo = request.getParameter("idTiempo") == null ? "" : request.getParameter("idTiempo");
			
                        
                        if(tipoConsulta.equals("TodosTipos")){
                             TiemposDAO TodoTiempos = new TiemposDAO();
                             List<TiemposRecord> results = TodoTiempos.ConsultarTiempos();
                             JSONArray JSONArrayTipos = new JSONArray();  
                             for(TiemposRecord rs : results){
                                 planJSONObject.put("tiempo", rs.getNombretiempo());
                                 planJSONObject.put("nemotecnico", rs.getNemotecnicotiempo());
                                 planJSONObject.put("id", rs.getTiemposid());
                                 JSONArrayTipos.add(planJSONObject);
                             }
                             result.put("listadoTiempos", JSONArrayTipos);
                             result.put("success", Boolean.TRUE);
                         }
                        
                        /*procesos con los datos*/
                        if(operacion.toUpperCase().equals("INSERTAR")&& idTiempo.equals("")){
                            
                            String tiempo = request.getParameter("tiempo") == null ? "" : request.getParameter("tiempo");
			    String nemotecnico = request.getParameter("nemotecnico") == null ? "" : request.getParameter("nemotecnico");
			    
                            TiemposRecord elTiempo= new TiemposRecord();
                            elTiempo.setNombretiempo(tiempo.toUpperCase());
                            elTiempo.setNemotecnicotiempo(nemotecnico.toUpperCase());
                            TiemposDAO TiempoProceso = new TiemposDAO();
                            
                            List<TiemposRecord> results =TiempoProceso.ConsultarTiemposEspecifico(elTiempo);
                            int existe=0;
                            for(TiemposRecord rs : results){
                                existe++;
                            }
                            if(existe==0){
                                TiempoProceso.grabarTiempo(elTiempo);
                                result.put("success", Boolean.TRUE);
                                result.put("mensaje", "GUARDADO CORRECTO");
                            }else{
                                result.put("success", Boolean.FALSE);
                                result.put("mensaje", "TIPO DE PALABRA DUPLICADA, YA EXISTE!!");
                            }
                            
                        }
                        if(operacion.toUpperCase().equals("ACTUALIZAR") && !idTiempo.equals("")){
                            String tiempo = request.getParameter("tiempo") == null ? "" : request.getParameter("tiempo");
			    String nemotecnico = request.getParameter("nemotecnico") == null ? "" : request.getParameter("nemotecnico");
			    
                            TiemposRecord elTiempo= new TiemposRecord();
                            elTiempo.setNombretiempo(tiempo.toUpperCase());
                            elTiempo.setNemotecnicotiempo(nemotecnico.toUpperCase());
                            elTiempo.setTiemposid(Integer.parseInt(idTiempo));
                            TiemposDAO TiemposProcesos = new TiemposDAO();
                            TiemposProcesos.ActualizarTiempo(elTiempo);
                            
                            result.put("success", Boolean.TRUE);
                            result.put("mensaje", "ACTUALIZADO CORRECTO");
                        }
                        
                        if(operacion.toUpperCase().equals("ELIMINAR")){
                            TiemposRecord elTiempo= new TiemposRecord();
                            elTiempo.setTiemposid(Integer.parseInt(idTiempo));
                            TiemposDAO tiposPalabrasProcesos = new TiemposDAO();
                            tiposPalabrasProcesos.EliminarTiempos(elTiempo);
                            result.put("success", Boolean.TRUE);
                            result.put("mensaje", "ELIMINACION DE REGISTRO CORRECTA");
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
