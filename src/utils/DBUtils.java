package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Tarefa;
import beans.Usuario;

public class DBUtils {
	 
    public static Usuario findUsuario(Connection conn, String login, String senha) throws SQLException {
 
        String sql = "Select a.login, a.senha from usuario a where a.login = ? and a.senha= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, login);
        pstm.setString(2, senha);
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            Usuario user = new Usuario();
            user.setLogin(login);
            user.setSenha(senha);
            return user;
        }
        return null;
    }
 
    public static Usuario findUsuario(Connection conn, String login) throws SQLException {
 
    	 String sql = "Select a.login, a.senha from usuario a where a.login = ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, login);
 
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String senha = rs.getString("senha");
            Usuario user = new Usuario();
            user.setLogin(login);
            user.setSenha(senha);
            return user;
        }
        return null;
    }
 
    public static List<Tarefa> queryTarefas(Connection conn) throws SQLException {
        String sql = "Select a.id, a.titulo, a.descricao, a.status from tarefa a";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Tarefa> tarefas = new ArrayList<Tarefa>();
        while (rs.next()) {
        	int id = rs.getInt("id");
            String titulo = rs.getString("titulo");
            String descricao = rs.getString("descricao");
            String status = rs.getString("status");
            
            Tarefa tarefa = new Tarefa();
            tarefa.setId(id);
            tarefa.setTitulo(titulo);
            tarefa.setDescricao(descricao);
            tarefa.setStatus(status);
            
            tarefas.add(tarefa);
        }
        return tarefas;
    }
 
    public static Tarefa findTarefa(Connection conn, int id) throws SQLException {
    	String sql = "Select a.titulo, a.descricao, a.status from tarefa a where a.id = ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
        	String titulo = rs.getString("titulo");
            String descricao = rs.getString("descricao");
            String status = rs.getString("status");
            
            Tarefa tarefa = new Tarefa(titulo, descricao, status);    
            tarefa.setId(id);
            return tarefa;
        }
        return null;
    }
 
    public static void updateTarefa(Connection conn, Tarefa tarefa) throws SQLException {
        String sql = "Update tarefa set titulo=?, descricao=?, status=? where id=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, tarefa.getTitulo());
        pstm.setString(2, tarefa.getDescricao());
        pstm.setString(3, tarefa.getStatus());
        pstm.setInt(4, tarefa.getId());
        pstm.executeUpdate();
    }
 
    public static void insertTarefa(Connection conn, Tarefa tarefa) throws SQLException {
        String sql = "Insert into tarefa(titulo, descricao, status) values (?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, tarefa.getTitulo());
        pstm.setString(2, tarefa.getDescricao());
        pstm.setString(3, tarefa.getStatus());
 
        pstm.executeUpdate();
    }
 
    public static void deleteTarefa(Connection conn, int id) throws SQLException {
        String sql = "Delete From tarefa where id= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, id);
 
        pstm.executeUpdate();
    }
 
}
