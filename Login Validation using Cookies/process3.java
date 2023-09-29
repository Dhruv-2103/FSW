package demoServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Cookie;

/**
 * Servlet implementation class process3
 */
@WebServlet("/process3")
public class process3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public process3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		response.setContentType("text/html");
		String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Replace with your own validation logic
        if (isValidUser(username, password)) {
            // Set username as a cookie
            Cookie usernameCookie = new Cookie("username", username);
            usernameCookie.setMaxAge(60 * 60 * 24); // Cookie expires in 24 hours
            response.addCookie(usernameCookie);

            // Redirect to a welcome page
            response.sendRedirect("index.jsp");
        } else {
            PrintWriter out = response.getWriter();
            out.print("<h1>Invalid username or password</h1>");
        }
    }

    // Replace this method with your own user validation logic
    private boolean isValidUser(String username, String password) {
        // You can check the username and password against a database or a hardcoded list
        // For this example, let's assume "user123" and "password123" are valid
        return "user123".equals(username) && "password123".equals(password);
	}

}
