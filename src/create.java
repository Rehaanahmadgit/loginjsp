import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/create")

public class create extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("first_name");
        String lastname = req.getParameter("last_name");
        String email = req.getParameter("email");
        String pass = req.getParameter("confirm_password");
        String pass2=req.getParameter("password");
        PrintWriter out=resp.getWriter();
        if (!pass2.equals(pass)){

            out.println(" your password not match in confirm passord");
//            resp.sendRedirect("creatacc.html"); // Redirect to an error page in case of issues
            return;
        }
        System.out.println(firstname);
        System.out.println("i am post method before the calling");

        insertvalus(firstname, lastname, email, pass);
        HttpSession session = req.getSession();

        System.out.println("i am the post method after the calling" +
                "");
//        String fullname = firstname + lastname;
//        System.out.println(fullname);
        session.setAttribute("name", firstname);
        session.setAttribute("email", email);
        session.setAttribute("pass", pass);
        session.setAttribute("lastname", lastname);

        InputStream inputStream = getServletContext().getResourceAsStream("/succces.html");
        if (inputStream == null) {
            out.println("File not found.");
            return;
        }


        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            out.println(line);
        }
        reader.close();
    }

    void insertvalus(String fastname, String lastname, String emal, String pass) {
//        encapsulation encapsulation = new encapsulation(fastname, lastname, emal, pass);
        try {
            String sql = "INSERT INTO login (firstname, lastname, email, pass) VALUES (?, ?, ?, ?)";
            Connection connection=jdbc.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, fastname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, emal);
            preparedStatement.setString(4, pass);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Insert good successful");
            } else {
                System.out.println("Insert failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
