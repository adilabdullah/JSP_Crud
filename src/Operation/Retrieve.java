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

import Backend.Bean;

/**
 * Servlet implementation class Retrieve
 */
@WebServlet("/Retrieve")
public class Retrieve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       int i=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Retrieve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	//	String update=request.getParameter("update").toString();
		try{
			Connection connection=Bean.Conn();
			String sql="select * from person_info where name='adil'";
			OraclePreparedStatement pst=(OraclePreparedStatement)connection.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
			 out.println("<form>");
			 out.println("<input type='text' name='sno' id='sno' value="+rs.getString("sno").toString()+"/>");
			 out.println("<input type='text' name='name' id='name' value="+rs.getString("name").toString()+"/>");
			 out.println("<input type='text' name='father' id='father' value="+rs.getString("father").toString()+"/>");
			 out.println("<input type='text' name='age' id='age' value="+rs.getString("age").toString()+"/>");
			 out.println("<input type='text' name='sex' id='sex' value="+rs.getString("sex").toString()+"/>");
			 out.println("<input type='text' name='addr' id='addr' value="+rs.getString("address").toString()+"/>");
			 out.println("<input type='text' name='cnic' id='cnic' value="+rs.getString("cnic").toString()+"/>");
			 out.println("<input type='text' name='cell' id='cell' value="+rs.getString("cell").toString()+"/>");
			 out.println("<input type='text' name='dob' id='dob' value="+rs.getString("dob").toString()+"/>");
			 out.println("<input type='submit' value='submit'/>");
			 out.println("</form>");
			}
		}
		catch(Exception ex)
		{ex.printStackTrace();
		out.println(ex.getMessage());}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	//	RequestDispatcher rd=request.getRequestDispatcher("challan.jsp");
	//	rd.include(request,response);
//		String search=request.getParameter("search").toString();
//	out.println(""+search);
		out.println("<table border='1' cellspacing='1'cellpadding='1'>");
		out.println("<thead>");
		out.println("<tr>");
	        out.println("<th>Sno</th>");
	        out.println("<th>Name</th>");
	        out.println("<th>Father</th>");
	        out.println("<th>Age</th>");
	        out.println("<th>Sex</th>");
	        out.println("<th>Address</th>");
	        out.println("<th>CNIC</th>");
	        out.println("<th>Cell</th>");
	        out.println("<th>Dob</th>");
	        out.println("<th>Edit</th>");
	        out.println("<th>Delete</th>");
	        out.println("<th>Index</th>");
	    out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
/*	if(search.equalsIgnoreCase(""))
		{    */
		try{
			Connection connection=Bean.Conn();
			String sql="select * from person_info";
		//	String sql="select * from challan";
			OraclePreparedStatement pst=(OraclePreparedStatement)connection.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
			 out.println("<tr>");
		        out.println("<td>"+rs.getString("sno").toString()+"</td>");
		        out.println("<td>"+rs.getString("name").toString()+"</td>");
		        out.println("<td>"+rs.getString("father").toString()+"</td>");
		        out.println("<td>"+rs.getString("age").toString()+"</td>");
		        out.println("<td>"+rs.getString("sex").toString()+"</td>");
		        out.println("<td>"+rs.getString("address").toString()+"</td>");
		        out.println("<td>"+rs.getString("cnic").toString()+"</td>");
		        out.println("<td>"+rs.getString("cell").toString()+"</td>");
		        out.println("<td>"+rs.getString("dob").toString()+"</td>");   
		        out.println("<td><input type='submit' value='delete' id='del'/></td>");
		    out.println("<td><button id='edt'>Edit</button></td>");
		    out.println("<td><input type='text' id='ind"+i+"' value='"+i+"'/></td>");
		    out.println("</tr>");
		    i++;
			}
		}
		catch(Exception ex)
		{ex.printStackTrace();
		out.println(ex.getMessage());}
		
	
	/*	else
		{
			try{
				Connection connection=Bean.Conn();
				String sql="select * from person_info where name='"+search+"'";
				OraclePreparedStatement pst=(OraclePreparedStatement)connection.prepareStatement(sql);
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
				 out.println("<tr>");
			        out.println("<td>"+rs.getString("sno").toString()+"</td>");
			        out.println("<td>"+rs.getString("name").toString()+"</td>");
			        out.println("<td>"+rs.getString("father").toString()+"</td>");
			        out.println("<td>"+rs.getString("age").toString()+"</td>");
			        out.println("<td>"+rs.getString("sex").toString()+"</td>");
			        out.println("<td>"+rs.getString("address").toString()+"</td>");
			        out.println("<td>"+rs.getString("cnic").toString()+"</td>");
			        out.println("<td>"+rs.getString("cell").toString()+"</td>");
			        out.println("<td>"+rs.getString("dob").toString()+"</td>");   
			        out.println("<td><input type='submit' value='delete' id='del'/></td>");
			    out.println("<td><button id='edt'>Edit</button></td>");
			    out.println("<td><input type='text' id='ind"+i+"' value='"+i+"'/></td>");
			    out.println("</tr>");
			    i++;
				}
			}
			catch(Exception ex)
			{ex.printStackTrace();
			out.println(ex.getMessage());}	 
		}  */  
		out.println("</tbody>");
		out.println("</html>");
	}
	
}
