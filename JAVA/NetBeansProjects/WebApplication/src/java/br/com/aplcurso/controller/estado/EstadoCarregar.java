package br.com.aplcurso.controller.estado;

import br.com.aplcurso.dao.EstadoDAO;
import br.com.aplcurso.model.Estado;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EstadoCarregar", urlPatterns = {"/EstadoCarregar"})
public class EstadoCarregar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            EstadoDAO estadoDAO = new EstadoDAO();
            Estado estado = (Estado) estadoDAO.carregar(id);
            
            request.setAttribute("estado", estado);
            request.getRequestDispatcher("/cadastros/estados/estadoCadastrar.jsp").forward(request, response);
            
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar estado! Erro: " + ex.getMessage());
            request.setAttribute("mensagem", "Erro ao carregar estado: " + ex.getMessage());
            request.getRequestDispatcher("/EstadoListar").forward(request, response);
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
}