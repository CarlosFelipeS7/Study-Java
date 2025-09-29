/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.aplcurso.controller.estado;


import br.com.aplcurso.dao.EstadoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EstadoListar", urlPatterns = {"/EstadoListar"})
public class EstadoListar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            EstadoDAO estadoDAO = new EstadoDAO();
            List<Object> estados = estadoDAO.listar();
            
            request.setAttribute("estados", estados);
request.getRequestDispatcher("/cadastros/estados/estadosListar.jsp").forward(request, response);
            
        } catch (Exception ex) {
            System.out.println("Problemas ao listar estados! Erro: " + ex.getMessage());
            request.setAttribute("mensagem", "Erro ao listar estados: " + ex.getMessage());
           request.getRequestDispatcher("/cadastros/estados/estadosListar.jsp").forward(request, response);
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
        return "Servlet para listar estados";
    }
}