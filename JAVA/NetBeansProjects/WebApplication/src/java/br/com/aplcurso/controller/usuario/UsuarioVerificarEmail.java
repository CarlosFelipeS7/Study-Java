package br.com.aplcurso.controller.usuario;

import br.com.aplcurso.dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuarioVerificarEmail", urlPatterns = {"/UsuarioVerificarEmail"})
public class UsuarioVerificarEmail extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=iso-8859-1");
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            String email = request.getParameter("email");
            response.setContentType("application/json");
            if (usuarioDAO.emailExiste(email)) {
                response.getWriter().write("1"); // Já existe
            } else {
                response.getWriter().write("0"); // Não existe
            }

        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao validar e-mail de usuário! Erro: " + ex.getMessage());
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
        return "Servlet para verificar duplicidade de e-mail de usuário";
    }
}
