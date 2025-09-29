/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.aplcurso.controller.usuario;

import br.com.aplcurso.dao.UsuarioDAO;
import br.com.aplcurso.model.Usuario;
import br.com.aplcurso.utils.DocumentoValidador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ccfel
 */@WebServlet(name = "UsuarioCadastrar", urlPatterns = {"/UsuarioCadastrar"})
public class UsuarioCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=iso-8859-1");
        try {
            UsuarioDAO dao = new UsuarioDAO();

            int id = Integer.parseInt(request.getParameter("id"));
            String nome = request.getParameter("nome");
            Date dataNascimento = java.sql.Date.valueOf(request.getParameter("datanascimento"));
            String cpf = request.getParameter("cpf");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            // tratamento para o campo salário
            String salarioStr = request.getParameter("salario");
            salarioStr = salarioStr.replace("R$", "")
                                   .replace(".", "")
                                   .replace(",", ".")
                                   .trim();
            double salario = Double.parseDouble(salarioStr);

            // validações
            if (!DocumentoValidador.isDocumentoValido(cpf)) {
                response.getWriter().write("3"); // CPF inválido
            } else if (dao.cpfExiste(cpf) && id == 0) {
                response.getWriter().write("4"); // CPF já cadastrado
            } else if (dao.emailExiste(email) && id == 0) {
                response.getWriter().write("6"); // E-mail já cadastrado
            } else if (nome.isEmpty() || nome.isBlank() ||
                       salario <= 0 || email.isBlank() ||
                       email.isEmpty() || senha.isBlank() || senha.isEmpty()) {
                response.getWriter().write("5"); // campos em branco
            } else {
                // passou nas validações - grava dados
                Usuario oUsuario = new Usuario();
                oUsuario.setId(id);
                oUsuario.setNome(nome);
                oUsuario.setCpf(cpf);
                oUsuario.setDataNascimento(dataNascimento);
                oUsuario.setEmail(email);
                oUsuario.setSenha(senha);
                oUsuario.setSalario(salario);

                if (dao.cadastrar(oUsuario)) {
                    response.getWriter().write("1"); // sucesso
                } else {
                    response.getWriter().write("0"); // erro ao gravar
                }
            }

        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao cadastrar Usuario! Erro: " + ex.getMessage());
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
        return "Servlet para cadastrar usuário";
    }
}
