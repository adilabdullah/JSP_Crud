package Operation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.jdbc.OraclePreparedStatement;
import Backend.Bean;

/**
 * Servlet implementation class log
 */
@WebServlet("/log")
public class log extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public log() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/HTML");
		String first=request.getParameter("fname").toString();
		String last=request.getParameter("lname").toString();
		String age=request.getParameter("age").toString();
		String cell=request.getParameter("cell").toString();
		String sex=request.getParameter("sex").toString();
		String occupation=request.getParameter("occupation").toString();
		String email=request.getParameter("email").toString();
		String password=request.getParameter("password").toString();
		 try{
			  Connection cons=Bean.Conn();
		  String sql="insert into person_list (firstname,lastname,age,cell,sex,occupation,email,password) values ('"+first+"','"+last
				 +"','"+age+"','"+cell+"','"+sex+"','"+occupation+"','"+email+"','"+password+"')";	  
		  OraclePreparedStatement pst=(OraclePreparedStatement)cons.prepareStatement(sql);
		  pst.execute();
		  RequestDispatcher res=request.getRequestDispatcher("login.jsp");
			res.forward(request,response);		
		  }
		  catch(SQLException se)
		  {
			out.println(se.getMessage());
		  }
		  catch(Exception e)
		  {
			out.println(e.getMessage());
		  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Connection conn=Bean.Conn();	
		PrintWriter out=response.getWriter();
		response.setContentType("text/HTML");
		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		rd.include(request,response);
		
		
		if(request.getParameter("siin")!=null)
		{
			String email=request.getParameter("email").toString();
			String password=request.getParameter("password").toString();	
			 try{
			     
			      String sql="select * from person_list where email='"+email+"' and password='"+password+"'";
					OraclePreparedStatement pst=(OraclePreparedStatement)conn.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					if(rs.next())
					{
						RequestDispatcher res=request.getRequestDispatcher("index.jsp");
						res.forward(request,response);					
						HttpSession session=request.getSession();  
				        session.setAttribute("name",rs.getString("firstname").toString());
				        session.setAttribute("father",rs.getString("lastname").toString());  
					}
					else
					{ 
						out.println("Email and password does not exist");
					}
			      }
			 catch(SQLException se)
		      {se.printStackTrace();
		      out.println(se.getMessage());}
			      catch(Exception ee)
			      {ee.printStackTrace();
			      out.println(ee.getMessage());}
		}
		else if(request.getParameter("siup")!=null)
		{
			 out.println("<form action='log' method='get'>");
			 out.println("<input type='text' name='fname' placeholder='Enter first name'><br>");
			 out.println("<input type='text' name='lname' placeholder='Enter last name'><br>");
			 out.println("<input type='text' name='cell' placeholder='Enter cell number'><br>");
			 out.println("<input type='number' name='age' placeholder='Enter age'><br>");
			 out.println("Male:<input type='radio' name='sex' value='male'>");
			 out.println("Female:<input type='radio' name='sex' value='female'><br>");
			 out.println("Student:<input type='radio' name='occupation' value='student'><br>");
			 out.println("Business:<input type='radio' name='occupation' value='bussiness'><br>");
			 out.println("Job:<input type='radio' name='occupation' value='job'><br>");
			 out.println("Professional:<input type='radio' name='occupation' value='professional'><br>");
			 out.println("<input type='email' name='email' placeholder='Enter email'><br>");
			 out.println("<input type='password' name='password' placeholder='Enter password'><br>");
			 out.println("<input type='submit' name='create' value='Create Account'>");
			 out.println("</form>");
		}
		else
		{
			out.println("Invalid options");
		}
		
	}

}
