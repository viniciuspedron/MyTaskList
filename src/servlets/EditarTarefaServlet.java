package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Tarefa;
import utils.DBUtils;
import utils.MyUtils;

@WebServlet(urlPatterns = { "/editarTarefa" })
public class EditarTarefaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public EditarTarefaServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String id = (String) request.getParameter("id");
 
        Tarefa tarefa = null;
 
        String errorString = null;
 
        try {
        	tarefa = DBUtils.findTarefa(conn, Integer.parseInt(id));
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        if (errorString != null && tarefa == null) {
            response.sendRedirect(request.getServletPath() + "/listaTarefas");
            return;
        }
 
        request.setAttribute("errorString", errorString);
        request.setAttribute("tarefa", tarefa);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/editarTarefaView.jsp");
        dispatcher.forward(request, response);
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String id = (String) request.getParameter("id");
        String titulo = (String) request.getParameter("titulo");
        String descricao = (String) request.getParameter("descricao");
        String status = (String) request.getParameter("status");
        
        Tarefa tarefa = new Tarefa(titulo, descricao, status);
        tarefa.setId(Integer.parseInt(id));

        String errorString = null;
 
        try {
            DBUtils.updateTarefa(conn, tarefa);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        request.setAttribute("errorString", errorString);
        request.setAttribute("tarefa", tarefa);
 
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/editarTarefaView.jsp");
            dispatcher.forward(request, response);
        }
        
        else {
            response.sendRedirect(request.getContextPath() + "/listaTarefas");
        }
    }
 
}