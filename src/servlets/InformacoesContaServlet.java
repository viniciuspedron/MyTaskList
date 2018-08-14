package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Usuario;
import utils.MyUtils;

@WebServlet(urlPatterns = { "/informacoesConta" })
public class InformacoesContaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public InformacoesContaServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
 
        Usuario usuarioLogado = MyUtils.getLoginedUser(sessao);
 
        if (usuarioLogado == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        request.setAttribute("usuario", usuarioLogado);
 
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/informacoesContaView.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}
