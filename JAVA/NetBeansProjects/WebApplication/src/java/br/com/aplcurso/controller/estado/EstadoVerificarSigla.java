/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.aplcurso.controller.estado;


import br.com.aplcurso.dao.EstadoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EstadoVerificarSigla", urlPatterns = {"/EstadoVerificarSigla"})
public class EstadoVerificarSigla extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=iso-8859-1");
        try {
            EstadoDAO estadoDAO = new EstadoDAO();
            String sigla = request.getParameter("sigla");
            String id = request.getParameter("id");
            
            response.setContentType("application/json");
            
            boolean existe;
            
            if (id != null && !id.isEmpty() && !id.equals("0")) {
                // Verificação para edição (exclui o próprio estado)
                int idEstado = Integer.parseInt(id);
                existe = estadoDAO.siglaExiste(sigla, idEstado);
            } else {
                // Verificação para inclusão
                existe = estadoDAO.siglaExiste(sigla);
            }
            
            if (existe) {
                response.getWriter().write("1"); // Já existe
            } else {
                response.getWriter().write("0"); // Não existe
            }
            
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao validar sigla do estado! Erro: " + ex.getMessage());
            response.getWriter().write("2"); // Erro
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet para verificar duplicidade de sigla de estado";
    }
}