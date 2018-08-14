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
import javax.servlet.http.HttpSession;

import beans.Usuario;
import utils.DBUtils;
import utils.MyUtils;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public LoginServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
 
        dispatcher.forward(request, response);
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String manterLogadoString = request.getParameter("manterLogado");
        boolean manterLogado = "S".equals(manterLogadoString);
 
        Usuario usuario = null;
        boolean hasError = false;
        String errorString = null;
 
        if (login == null || senha == null || login.isEmpty() || senha.isEmpty()) {
            hasError = true;
            errorString = "Login e senha obrigatórios!";
        } else {
            Connection conn = MyUtils.getStoredConnection(request);
            try {
                usuario = DBUtils.findUsuario(conn, login, senha);
 
                if (usuario == null) {
                    hasError = true;
                    errorString = "Login ou senha inválidos";
                }
            } catch (SQLException e) {
                e.printStackTrace();
                hasError = true;
                errorString = e.getMessage();
            }
        }
        if (hasError) {
            usuario = new Usuario();
            usuario.setLogin(login);
            usuario.setSenha(senha);
 
            request.setAttribute("errorString", errorString);
            request.setAttribute("usuario", usuario);
 
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
 
            dispatcher.forward(request, response);
        } else {
            HttpSession session = request.getSession();
            MyUtils.storeLoginedUser(session, usuario);
 
            if (manterLogado)
            	MyUtils.storeUserCookie(response, usuario);
            else
            	MyUtils.deleteUserCookie(response);
            
            response.sendRedirect(request.getContextPath() + "/informacoesConta");
        }
    }
 
}