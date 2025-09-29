package br.com.aplcurso.controller.estado;

import br.com.aplcurso.dao.EstadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EstadoExcluir", urlPatterns = {"/EstadoExcluir"})
public class EstadoExcluir extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=iso-8859-1");
        PrintWriter out = response.getWriter();
        
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            EstadoDAO estadoDAO = new EstadoDAO();
            
            if (estadoDAO.excluir(id)) {
                out.print("1"); // Sucesso
            } else {
                out.print("2"); // Erro
            }
            
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir estado! Erro: " + ex.getMessage());
            out.print("3"); // Erro geral
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