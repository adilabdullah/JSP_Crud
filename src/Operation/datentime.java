package Operation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Backend.Bean;
import oracle.jdbc.OraclePreparedStatement;

/**
 * Servlet implementation class datentime
 */
@WebServlet("/datentime")
public class datentime extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Date dNow = new Date( );
    SimpleDateFormat ft=new SimpleDateFormat ("dd-M-yyyy");
    SimpleDateFormat fs=new SimpleDateFormat ("hh:mm:a");   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public datentime() {
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
	response.setContentType("text/HTML");
	PrintWriter out=response.getWriter();
		String hdate=request.getParameter("hdate");
	String htime=request.getParameter("htime");
	try{
		Connection cons=Bean.Conn();
		String sql="insert into times values('02-09-1990','11:45:pm','12-08-1993','03:50:am')";
		  OraclePreparedStatement pst=(OraclePreparedStatement)cons.prepareStatement(sql);
		  pst.execute();
out.println("Date:"+ft.format(dNow));
out.println("Time:"+fs.format(dNow));
	}
/*	catch(SQLException se)
	{se.printStackTrace();
	out.println(se.getMessage());
	} */
	catch(Exception ee)
	{ee.printStackTrace();
	out.println(ee.getMessage());}
	}

}
