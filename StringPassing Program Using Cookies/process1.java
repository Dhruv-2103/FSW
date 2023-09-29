package demoServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class process1
 */
@WebServlet("/process1")
public class process1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public process1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		response.setContentType("text/html");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");

        // Store the first name and last name in separate cookies
        Cookie fnameCookie = new Cookie("fname", fname);
        fnameCookie.setMaxAge(60 * 60 * 24); // Cookie expires in 24 hours
        response.addCookie(fnameCookie);

        Cookie lnameCookie = new Cookie("lname", lname);
        lnameCookie.setMaxAge(60 * 60 * 24); // Cookie expires in 24 hours
        response.addCookie(lnameCookie);

        PrintWriter out = response.getWriter();
        out.print("<h1>First Name: " + fname + "</h1>");
        out.print("<h1>Last Name: " + lname + "</h1>");
	}
}
