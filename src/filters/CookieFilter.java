package filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.Usuario;
import utils.DBUtils;
import utils.MyUtils;

@WebFilter(filterName = "cookieFilter", urlPatterns = { "/*" })
public class CookieFilter implements Filter {
 
    public CookieFilter() {
    }
 
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
 
    }
 
    @Override
    public void destroy() {
 
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession sessao = req.getSession();
 
        Usuario usuarioEmSessao = MyUtils.getLoginedUser(sessao);
        if (usuarioEmSessao != null) {
        	sessao.setAttribute("COOKIE_CHECKED", "CHECKED");
            chain.doFilter(request, response);
            return;
        }
 
        Connection conn = MyUtils.getStoredConnection(request);
 
        String checked = (String) sessao.getAttribute("COOKIE_CHECKED");
        if (checked == null && conn != null) {
            String userName = MyUtils.getUserNameInCookie(req);
            try {
                Usuario usuario = DBUtils.findUsuario(conn, userName);
                MyUtils.storeLoginedUser(sessao, usuario);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sessao.setAttribute("COOKIE_CHECKED", "CHECKED");
        }
 
        chain.doFilter(request, response);
    }
 
}