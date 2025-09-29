/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.aplcurso.controller.estado;


import br.com.aplcurso.dao.EstadoDAO;
import br.com.aplcurso.model.Estado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EstadoCadastrar", urlPatterns = {"/EstadoCadastrar"})
public class EstadoCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=iso-8859-1");
        PrintWriter out = response.getWriter();
        
        try {
            String idStr = request.getParameter("id");
            String nomeEstado = request.getParameter("nomeEstado");
            String siglaEstado = request.getParameter("siglaEstado");
            
            int id = (idStr != null && !idStr.isEmpty()) ? Integer.parseInt(idStr) : 0;
            
            // Validar campos obrigatórios
            if (nomeEstado == null || nomeEstado.trim().isEmpty() || 
                siglaEstado == null || siglaEstado.trim().isEmpty()) {
                out.print("5"); // Dados em branco
                return;
            }
            
            // Validar tamanho da sigla
            if (siglaEstado.length() != 2) {
                out.print("7"); // Sigla deve ter 2 caracteres
                return;
            }
            
            EstadoDAO estadoDAO = new EstadoDAO();
            
            // Verificar duplicidade da sigla
            if (id == 0) {
                // Inclusão - verificar se sigla já existe
                if (estadoDAO.siglaExiste(siglaEstado)) {
                    out.print("6"); // Sigla já existe
                    return;
                }
            } else {
                // Edição - verificar se sigla já existe em outro estado
                if (estadoDAO.siglaExiste(siglaEstado, id)) {
                    out.print("6"); // Sigla já existe
                    return;
                }
            }
            
            Estado estado = new Estado();
            estado.setId(id);
            estado.setNomeEstado(nomeEstado);
            estado.setSiglaEstado(siglaEstado);
            
            if (estadoDAO.cadastrar(estado)) {
                out.print("1"); // Sucesso
            } else {
                out.print("2"); // Erro ao cadastrar
            }
            
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar estado! Erro: " + ex.getMessage());
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

    @Override
    public String getServletInfo() {
        return "Servlet para cadastrar e alterar estados";
    }
}