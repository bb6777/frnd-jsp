

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Frndjspchk
 */
@WebServlet("/Frndjspchk")
public class Frndjspchk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String csid = request.getParameter("ctid");
		
		try {
		
		
		
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
		//String query = "SELECT * FROM INVOICE";
		String query = "SELECT customer.city as stay, sum(invoice.total) AS amount, customer.firstname as who, customer.lastname, invoice.customerid\r\n" + 
				"FROM customer\r\n" + 
				"INNER JOIN invoice ON customer.id = invoice.customerid\r\n" + 
				"WHERE invoice.customerid="+csid+"\r\n" + 
				"GROUP BY customerid, id\r\n";
				
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
		//	System.out.println("Amount Total:" + rs.getString("amount"));
		//	System.out.println("City:" + rs.getString("stay"));
		//	System.out.println("Who:" + rs.getString("who"));
		String amnt = rs.getString("amount");
		
		request.getSession().setAttribute("tount", amnt);
		response.sendRedirect("/frnd-jsp2.jsp");
		}
		
		//request.getSession().setAttribute("amount", amnt);
		//response.sendRedirect("/frnd-jsp2.jsp");
		
		
		}
		
		
		catch (SQLException e) {
			System.err.println(e);;
		}
		
		
	
	}

}
