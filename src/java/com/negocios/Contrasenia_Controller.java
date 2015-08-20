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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import persistencia.tables.records.UsuarioRecord;


/**
 *
 * @author luisito
 */
@WebServlet(name = "Contrasenia_Controller", urlPatterns = {"/Contrasenia_Controller"})
public class Contrasenia_Controller extends HttpServlet {

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
        //response.setContentType("text/html;charset=UTF-8");
        
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
        //processRequest(request, response);
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
        
        /*las secciones no se toman si existe este parametro 
        *** processRequest(request, response);
        */
        
        try{
            HttpSession sesion = request.getSession(true);
            System.out.println(sesion);
            String usuario = ""+sesion.getAttribute("usuario");
            String nombre = ""+sesion.getAttribute("nombre");
            String contraseniaActual = request.getParameter("contraseniaActual") == null ? "" : request.getParameter("contraseniaActual");
            String contraseniaNueva = request.getParameter("contraseniaNueva") == null ? "" : request.getParameter("contraseniaNueva");
            String repitaContraseniaNueva = request.getParameter("repitaContraseniaNueva") == null ? "" : request.getParameter("repitaContraseniaNueva");
            
            try{
                String contraseñaExisten="";
                UsuarioRecord usuarioActual= new UsuarioRecord();
                usuarioActual.setUsuarioid(Integer.parseInt(usuario));
                
                UsuarioDAO usu = new UsuarioDAO();
                List<UsuarioRecord> results=usu.ConsultarUsuariosEspecificos(usuarioActual);
                
                int contador=0;
                for(UsuarioRecord rs : results){
                    contraseñaExisten=""+rs.getContrasenia();
                    contador++;
                }
                if(contador>0){
                    if(contraseñaExisten.equals(contraseniaActual)){
                        usuarioActual.setContrasenia(repitaContraseniaNueva);
                        usuarioActual.setNombreusuario(nombre);
                        usu.ActualizarUsuarios(usuarioActual);
                        PrintWriter out = response.getWriter();
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('CAMBIO DE CONTRASEÑA CORRECTO :D ');");
                        out.println("location='jsp/cambioContrasenia.jsp';");
                        out.println("</script>");
                    }
                    else{
                         PrintWriter out = response.getWriter();
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert(error contraseñs no coninciden');");
                        out.println("location='jsp/cambioContrasenia.jsp';");
                        out.println("</script>");
                    }
                    
                }
                
            }catch(Exception e){
                 PrintWriter out = response.getWriter();
                   out.println("<script type=\"text/javascript\">");
                   out.println("alert('Error inesperador: '"+e+");");
                   out.println("location='jsp/cambioContrasenia.jsp';");
                   out.println("</script>");
                e.printStackTrace();
            }
                        
        }catch(Exception e){
            PrintWriter out = response.getWriter();
                   out.println("<script type=\"text/javascript\">");
                   out.println("alert('Ocurrio un error Inesperado "+e+"');");
                   out.println("location='jsp/cambioContrasenia.jsp';");
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
