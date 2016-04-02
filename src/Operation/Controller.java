package Operation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import javax.servlet.http.HttpSession;

import oracle.jdbc.OraclePreparedStatement;
import oracle.net.aso.e;
import Backend.Bean;
import Backend.Logic;
import Backend.Updation;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Updation upd=new Updation();
    Logic log=new Logic();
	
	
       Connection conn=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=(Connection)Bean.Conn();
		response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			/* HttpSession session=request.getSession(); 
			String name=(String)session.getAttribute("name");  
			String father=(String)session.getAttribute("father");  
out.println("<h1>Welcome to"+name+"</h1>");*/
		//	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		//	rd.include(request,response);
			String sno=request.getParameter("sno").toString();
			String doss=request.getParameter("dos").toString();
			if(doss.equalsIgnoreCase("update"))
			{
				try{
				String sql="select * from person_info where sno='"+sno+"'";
	    		OraclePreparedStatement pst=(OraclePreparedStatement)conn.prepareStatement(sql);
	    		ResultSet rs=pst.executeQuery();
	        	while(rs.next())
	        	{
				 out.println("<form action='Controller' method='post'>");
				 out.println("<input type='text' name='serial' value='"+rs.getString("sno").toString()+"'><br>");
				 out.println("<input type='text' name='nam' value='"+rs.getString("name").toString()+"' placeholder='Enter new name'><br>");
				 out.println("<input type='text' name='fat' value='"+rs.getString("father").toString()+"' placeholder='Enter new father name'><br>");
				 out.println("<input type='number' name='age' value='"+rs.getString("age").toString()+"' placeholder='Enter new age'><br>");
				 out.println("Male:<input type='radio' name='sex' value='male'>");
				 out.println("Female:<input type='radio' name='sex' value='female'><br>");
				 out.println("<input type='text' name='add' value='"+rs.getString("address").toString()+"' placeholder='Enter new address'><br>");
				 out.println("<input type='text' name='cni' value='"+rs.getString("cnic").toString()+"' placeholder='Enter new cnic'><br>");
				 out.println("<input type='text' name='cel' value='"+rs.getString("cell").toString()+"' placeholder='Enter new cell'><br>");
				 out.println("<input type='date' value='"+rs.getString("dob").toString()+"' name='dat'><br>");
				 out.println("<input type='submit' name='ups' value='update'>");
				 out.println("</form>");
	        	}
				}
				catch(SQLException se)
				{se.printStackTrace();
				out.println(se.getMessage());}
				catch(Exception ee)
				{ee.printStackTrace();
				out.println(ee.getMessage());}
				
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.include(request,response);
				try
				{
					String sql="delete from person_info where sno='"+sno+"'";
					OraclePreparedStatement pst=(OraclePreparedStatement)conn.prepareStatement(sql);
					  pst.execute();
					  out.println("Record deleted successfully");
				}
				catch(SQLException se)
				{se.printStackTrace();
				out.println(se.getMessage());}
				catch(Exception ee)
				{ee.printStackTrace();
				out.println(ee.getMessage());} 
			}
		
		}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	HttpSession session = request.getSession();
	PrintWriter out=response.getWriter();
	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.include(request,response);
if(request.getParameter("frmsubmit")!=null)
{
		String name=request.getParameter("name").toString();
		  String father=request.getParameter("father").toString();
		  int age=Integer.parseInt(request.getParameter("age").toString());
		  String sex=request.getParameter("sex").toString();
		  String addr=request.getParameter("address").toString();
		  String cnic=request.getParameter("cnic").toString();
		  String cell=request.getParameter("cell").toString();
		  String dob=request.getParameter("dob").toString();
	       Updation upd=new Updation(age,name,father,sex,cnic,addr,cell,dob);
		  try{
			  Connection cons=Bean.Conn();
		  String sql="insert into person_info (sno,name,father,age,sex,address,cnic,cell,dob) values (person_sequence.nextval,'"+
		  upd.getName()+"','"+upd.getFather()+"','"+upd.getAge()+"','"+upd.getSex()+"','"+upd.getAddr()+"','"+upd.getCnic()+"','"+upd.getCell()+"','"+upd.getDob()+"')";	  
		  OraclePreparedStatement pst=(OraclePreparedStatement)cons.prepareStatement(sql);
		  pst.execute();
			  out.println("Data inserted");
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
else if(request.getParameter("retrieve")!=null)
{
	out.println("<html>");
	out.println("<head>");
	out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js'></script>");
/*	out.println("<script type='text/javascript' src='js/jquery-latest.js'></script> ");
	out.println("<script type='text/javascript' src='js/jquery.tablesorter.js'></script>"); */
	out.println("<script type='text/javascript' src='js/sorttable.js'></script>");
	
/*	out.println("$(document).ready(function() {"+ 
   "$('#myTable').tablesorter(); });");
 
    out.println("$(document).ready(function(){"+
    "$('#myTable').tablesorter( {sortList: [[0,0], [1,0]]} );});");  */
    
	out.println("</head>");
	Connection cons=Bean.Conn();
		String search=request.getParameter("search").toString();
		out.println("<table border='1' cellpadding='2' cellspacing='2' class='sortable'>");
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
	        out.println("<th>Date Of Birth</th>");
	    out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		
	//	Logic log=new Logic();
        if(search.equalsIgnoreCase(""))
        {
        	try
        	{
    		String sql="select * from person_info";
    		OraclePreparedStatement pst=(OraclePreparedStatement)cons.prepareStatement(sql);
    		ResultSet rs=pst.executeQuery();
        	while(rs.next())
        	{
        		out.println("<tr>");
        		String ser=rs.getString("sno").toString();
        		out.println("<td>"+ser+"</td>");
        		out.println("<td>"+rs.getString("name").toString()+"</td>");
        		out.println("<td>"+rs.getString("father").toString()+"</td>");
        		out.println("<td>"+rs.getString("age").toString()+"</td>");
        		out.println("<td>"+rs.getString("sex").toString()+"</td>");
        		out.println("<td>"+rs.getString("address").toString()+"</td>");
        		out.println("<td>"+rs.getString("cnic").toString()+"</td>");
        		out.println("<td>"+rs.getString("cell").toString()+"</td>");
        		out.println("<td>"+rs.getString("dob").toString()+"</td>");
        		session.setAttribute("serial",rs.getString("sno").toString());
			    out.println("<td><a href='Controller?sno="+ser+"&dos=update'>Edit</a></td>");
     out.println("<td><a href='Controller?sno="+ser+"&dos=delete'>Delete</a></td>");
        		out.println("</tr>");
        	}
        	}
        	catch(SQLException se)
        	{out.println(se.getMessage());
        	se.printStackTrace();}
        	catch(Exception e)
        	{out.println(e.getMessage());
        	e.printStackTrace();}
        	out.println("</tbody>");
    		out.println("</table>");
        }        
        else
        {
    //    	ArrayList<Updation> asl=log.displaySearch(search);
       	try {

        		String sql="select * from person_info where name='"+search+"' or father='"+search+"' or cnic='"+search+"'";
        		OraclePreparedStatement pst=(OraclePreparedStatement)cons.prepareStatement(sql);
        		ResultSet rs=pst.executeQuery();
				while(rs.next())  {
				 out.println("<tr>");
				 String ser=rs.getString("sno").toString();
				 out.println("<td>"+ser+"</td>");
	        		out.println("<td>"+rs.getString("name").toString()+"</td>");
	        		out.println("<td>"+rs.getString("father").toString()+"</td>");
	        		out.println("<td>"+rs.getString("age").toString()+"</td>");
	        		out.println("<td>"+rs.getString("sex").toString()+"</td>");
	        		out.println("<td>"+rs.getString("address").toString()+"</td>");
	        		out.println("<td>"+rs.getString("cnic").toString()+"</td>");
	        		out.println("<td>"+rs.getString("cell").toString()+"</td>");
	        		out.println("<td>"+rs.getString("dob").toString()+"</td>");
	        		session.setAttribute("serial",ser);
				    out.println("<td><a href='Controller?sno="+ser+"&dos=update'>Edit</a></td>");
         out.println("<td><a href='Controller?sno="+ser+"&dos=delete'>Delete</a></td>");
				// out.println("<td><input type='text' id='ind"+i+"' name='ind' value='"+rs.getString("chalan_no").toString()+"'/></td>");		
         out.println("</tr>");
				}
		}
       	catch (SQLException se) {
			out.println(se.getMessage());
       		se.printStackTrace();
		}  
       	catch (Exception e) {
       		out.println(e.getMessage());
       		e.printStackTrace();
		}  
       	
        	out.println("</tbody>");
        	out.println("</table>");
        }
        out.println("</html>");
}
else if(request.getParameter("ups")!=null)
{
	String sn=request.getParameter("serial").toString();
        	String nam=request.getParameter("nam").toString();
        	String fat=request.getParameter("fat").toString();
        	String age=request.getParameter("age").toString();
        	String sex=request.getParameter("sex").toString();
        	String add=request.getParameter("add").toString();
        	String cni=request.getParameter("cni").toString();
        	String cel=request.getParameter("cel").toString();
        	String dat=request.getParameter("dat").toString();
        	try
        	{
        		Connection cons=Bean.Conn();
        		String sql="update person_info set name='"+nam+"',father='"+fat+"',age='"+
        				age+"',sex='"+sex+"',address='"+add+"',cnic='"+cni+"',cell='"+cel+"',dob='"+dat+"' where sno='"+sn+"'";
        		OraclePreparedStatement pst=(OraclePreparedStatement)cons.prepareStatement(sql);
      		  pst.executeUpdate();
      		  out.println("Record updated successfully");
        	}
        	catch(SQLException se)
        	{se.printStackTrace();
        	out.println(se.getMessage());}
        	catch(Exception ee)
        	{ee.printStackTrace();
        	out.println(ee.getMessage());}
}		
else
{
out.println("Unavailable option");	
}
        
}
}