import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebFilter(urlPatterns = "/login")
public class filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        HttpServletResponse resp=(HttpServletResponse) servletResponse;
        String email=req.getParameter("email");
        String pass=req.getParameter("password");
        Connection connection=jdbc.getConnection();
        String sql = "SELECT * FROM login WHERE email = ? AND pass = ?";
        String emailsql=null;
        String passsql=null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, pass);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                System.out.println("No data found.");
            } else {
                // Process the data
                do {
                  emailsql = rs.getString("email");
                   passsql  = rs.getString("pass");
                    System.out.println("Name: " + emailsql+ " " + passsql);
                } while (rs.next());
            }
            rs.close();
            stmt.close();
        }catch (Exception e){
e.printStackTrace();
            resp.sendRedirect("./notsucc.html"); // Redirect to an error page in case of issues
            return;
        }
//        HttpSession session=req.getSession(false);
//        Boolean islogin=(session!=null&&session.getAttribute("email")!=null);
        if (email.equals(emailsql) && pass.equals(passsql)){

            filterChain.doFilter(servletRequest, servletResponse);
        } else {

            System.out.println("not avilable any data ");
            resp.sendRedirect("notsucc.html");
        }

    }

    @Override
    public void destroy() {

    }
}
