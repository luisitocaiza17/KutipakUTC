/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocios;

import com.datos.DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;
import net.sf.ezmorph.Morpher;
import persistencia.tables.records.UsuarioRecord;
/**
 *
 * @author luisito
 */
@WebServlet(name = "Login_Controller", urlPatterns = {"/Login_Controller"})
public class Login_Controller extends HttpServlet {

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
       // response.setContentType("text/html;charset=UTF-8");
       
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
       // processRequest(request, response);
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
        
        HttpSession session = request.getSession(true);
       try{
             
             String usuario = request.getParameter("usuario") == null ? "" : request.getParameter("usuario");
             String clave = request.getParameter("contrasenia") == null ? "" : request.getParameter("contrasenia");
             UsuarioRecord UsuarioVerifica= new UsuarioRecord();
             UsuarioVerifica.setNombreusuario(usuario);
             UsuarioVerifica.setContrasenia(clave);
             System.out.println(""+usuario+" : "+clave);
             List<UsuarioRecord> results =UsuarioDAO.ConsultarUsuariosEspecificosexistente(UsuarioVerifica);
             int contador=0;
             	
             for(UsuarioRecord rs : results){
                 contador++;
                 session.setAttribute("usuario", rs.getUsuarioid());
                 session.setAttribute("nombre", rs.getNombreusuario());
             }
             if(contador>0){
                  response.sendRedirect("jsp/administradorPrincipal.jsp");
             }
             else{ 
                 PrintWriter out = response.getWriter();
                   out.println("<script type=\"text/javascript\">");
                   out.println("alert('Usuario o Contraseña Incorrecta vuelva a Intentarlo');");
                   out.println("location='jsp/login.jsp';");
                   out.println("</script>");
                 
             }
             return;
             
          }catch(Exception e){
             e.printStackTrace();
             PrintWriter out = response.getWriter();
                   out.println("<script type=\"text/javascript\">");
                   out.println("alert('Usuario o Contraseña Incorrecta vuelva a Intentarlo');");
                   out.println("location='jsp/login.jsp';");
                   out.println("</script>");
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
