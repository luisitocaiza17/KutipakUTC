/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocios;

import com.datos.DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.ezmorph.Morpher;
import persistencia.tables.records.UsuarioRecord;

/**
 *
 * @author luisito
 */
@WebServlet(name = "Login_Servlet", urlPatterns = {"/Login_Servlet"})
public class Login_Servlet extends HttpServlet {

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
        try{
        JSONObject result = new JSONObject();
        try{
        processRequest(request, response);
        System.out.println("si entro");
        String usuario = request.getParameter("usuario") == null ? "" : request.getParameter("usuario");
        String clave = request.getParameter("contrasenia") == null ? "" : request.getParameter("contrasenia");
        System.out.println("usu: "+usuario+" clave :"+clave);
        /*PAGINA DE LOGUE DE ADMINISTRADORES*/
        
                       
        if(usuario.equals(null) || usuario.equals(""))
            usuario = "";
        if(clave.equals(null) || clave.equals(""))
            clave="";
        /*Proceso de busqueda de Usuario y contraseña*/
        UsuarioDAO existe = new UsuarioDAO();
        UsuarioRecord usuarioR = new UsuarioRecord();
        usuarioR.setNombreusuario(usuario);
        usuarioR.setContrasenia(clave);
        try {
            JSONObject planJSONObject = new JSONObject();
            JSONArray planJSONArray = new JSONArray();
            List<UsuarioRecord> results=existe.ConsultarUsuariosEspecificos(usuarioR);
            int contadorUsuarios=0;
            for(UsuarioRecord rs : results){
                planJSONObject.put("Personaid", rs.getPersonaid());
                planJSONObject.put("Nombre", rs.getNombreusuario());
                planJSONObject.put("contrasenia", rs.getContrasenia());
                planJSONArray.add(planJSONObject);
                contadorUsuarios++;
            }
            if(contadorUsuarios>1){
                result.put("listadoAsientos", planJSONArray);
                result.put("success", Boolean.TRUE);
            }else{
                result.put("success", Boolean.FALSE);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Login_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Login_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
      }catch(Exception e){
            e.printStackTrace();
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
