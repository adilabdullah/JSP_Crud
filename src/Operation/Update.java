package Operation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.OraclePreparedStatement;
import Backend.Bean;
import Backend.Updation;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String update=request.getParameter("update").toString();
		try{
			Connection connection=Bean.Conn();
			String sql="select * from person_info where name='"+update+"'";
			OraclePreparedStatement pst=(OraclePreparedStatement)connection.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
//		while(rs.next())
//		{
	//		Updation upd=new Updation(rs.getString("sno").toString(),rs.getString("name").toString(),rs.getString("father").toString(),
					rs.getString("age").toString(),rs.getString("sex").toString(),rs.getString("addr").toString(),rs.getString("cnic").toString(),
					rs.getString("cell").toString(),rs.getString("dob").toString());
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		request.setAttribute("upd",upd);
		rd.forward(request, response);	
		
			/*	out.println("<form>");
			out.println("<input type='text' name='sno' id='sno' value='"+rs.getString("sno").toString()+"'/>");
			out.println("<input type='text' name='name' id='name' value='"+rs.getString("name").toString()+"'/>");
			out.println("<input type='text' name='father' id='father' value='"+rs.getString("father").toString()+"'/>");
			out.println("<input type='text' name='age' id='age' value='"+rs.getString("age").toString()+"'/>");
			out.println("<input type='text' name='sex' id='sex' value='"+rs.getString("sex").toString()+"'/>");
			out.println("<input type='text' name='addr' id='addr' value='"+rs.getString("addr").toString()+"'/>");
			out.println("<input type='text' name='cnic' id='cnic' value='"+rs.getString("cnic").toString()+"'/>");
			out.println("<input type='text' name='cell' id='cell' value='"+rs.getString("cell").toString()+"'/>");
			out.println("<input type='text' name='dob' id='dob' value='"+rs.getString("dob").toString()+"'/>");
			out.println("<input type='submit' value='submit'/>");
			out.println("</form>");  */
			
		}
		catch(Exception ex)
		{ex.printStackTrace();
		out.println(ex.getMessage());}
	}

}
