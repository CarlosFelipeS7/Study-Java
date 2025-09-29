package br.com.aplcurso.dao;

import br.com.aplcurso.model.Estado;
import br.com.aplcurso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO implements GenericDAO {
    
    private Connection conexao;
    
    public EstadoDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Estado oEstado = (Estado) objeto;
        Boolean retorno = false;
        if(oEstado.getId() == 0){
            retorno = this.inserir(oEstado);
        } else {
            retorno = this.alterar(oEstado);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Estado oEstado = (Estado) objeto;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO estado (nomeestado, siglaestado) VALUES (?, ?)";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oEstado.getNomeEstado().toUpperCase());
            stmt.setString(2, oEstado.getSiglaEstado().toUpperCase());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar Estado! Erro: " + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean alterar(Object objeto) {
        Estado oEstado = (Estado) objeto;
        PreparedStatement stmt = null;
        String sql = "UPDATE estado SET nomeestado = ?, siglaestado = ? WHERE id = ?";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oEstado.getNomeEstado().toUpperCase());
            stmt.setString(2, oEstado.getSiglaEstado().toUpperCase());
            stmt.setInt(3, oEstado.getId());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar Estado! Erro: " + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean excluir(int numero) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM estado WHERE id = ?";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, numero);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao excluir Estado! Erro: " + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Object carregar(int numero) {
        String sql = "SELECT * FROM estado WHERE id = ?";
        Estado oEstado = null;
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, numero);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                oEstado = new Estado();
                oEstado.setId(rs.getInt("id"));
                oEstado.setNomeEstado(rs.getString("nomeestado"));
                oEstado.setSiglaEstado(rs.getString("siglaestado"));
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao carregar estado: " + ex.getMessage());
            ex.printStackTrace();
        }
        return oEstado;
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        String sql = "SELECT * FROM estado ORDER BY nomeestado";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Estado oEstado = new Estado();
                oEstado.setId(rs.getInt("id"));
                oEstado.setNomeEstado(rs.getString("nomeestado"));
                oEstado.setSiglaEstado(rs.getString("siglaestado"));
                resultado.add(oEstado);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar estados: " + ex.getMessage());
            ex.printStackTrace();
        }
        return resultado;
    }
    
    // Método para verificar duplicidade da sigla (para inclusão)
    public boolean siglaExiste(String sigla) {
        String sql = "SELECT COUNT(*) FROM estado WHERE UPPER(siglaestado) = UPPER(?)";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, sigla);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao verificar sigla: " + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }
    
    // Método para verificar duplicidade da sigla (para edição - excluindo o próprio estado)
    public boolean siglaExiste(String sigla, int idEstado) {
        String sql = "SELECT COUNT(*) FROM estado WHERE UPPER(siglaestado) = UPPER(?) AND id != ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, sigla);
            stmt.setInt(2, idEstado);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao verificar sigla: " + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }
    
    // Método para verificar duplicidade do nome (opcional)
    public boolean nomeExiste(String nome) {
        String sql = "SELECT COUNT(*) FROM estado WHERE UPPER(nomeestado) = UPPER(?)";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao verificar nome: " + ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }
}