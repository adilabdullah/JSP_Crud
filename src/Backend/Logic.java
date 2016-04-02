package Backend;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.OraclePreparedStatement;

public class Logic {
//Connection conn=null;

	Connection conn=null;
	ArrayList<Updation> arr=new ArrayList<Updation>();
/*public int insert(Object obj)
	{
		try
		{		 

		String sql="insert into person_info (sno,name,father,age,sex,address,cnic,cell,dob) values (person_sequence.nextval,?,?,?,"
				+ "?,?,?,?,?)";
			  OraclePreparedStatement pst=(OraclePreparedStatement)conn.prepareStatement(sql);
			  pst.setString(1,"name");
			  pst.setString(2,"father");
			  pst.setString(3,"age");
			  pst.setString(4,"sex");
			  pst.setString(5,"addr");
			  pst.setString(6,"cnic");
			  pst.setString(7,"cell");
			  pst.setString(8,"dob");
			  pst.execute();
			  return 1;
		}
		catch(Exception ex)
		{ex.printStackTrace();}
		return 0;
	}  */
	
	public ArrayList<Updation> displayAll()
	{
		conn=Bean.Conn();
		
		String sql="select * from person_info";
		try{
		OraclePreparedStatement pst=(OraclePreparedStatement)conn.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			Updation upd=new Updation();
			upd.setSno(rs.getString("sno").toString());
			upd.setName(rs.getString("name").toString());
			upd.setAge(rs.getInt("age"));
			upd.setFather(rs.getString("father").toString());
			upd.setSex(rs.getString("sex").toString());
			upd.setCnic(rs.getString("cnic").toString());
			upd.setAddr(rs.getString("address").toString());
			upd.setCell(rs.getString("cell").toString());
			upd.setDob(rs.getString("dob").toString());
			arr.add(upd);
		}
		}
		catch(SQLException se)
		{se.printStackTrace();}
		catch(Exception e)
		{e.printStackTrace();}
		return arr;
	}
	
	public ArrayList<Updation> displaySearch(String search)
	{
		conn=Bean.Conn();
		
		String sql="select * from person_info where name='"+search+"' or father='"+search+"' or cnic='"+search+"'";
		try{
		OraclePreparedStatement pst=(OraclePreparedStatement)conn.prepareStatement(sql);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			Updation upd=new Updation();
			upd.setSno(rs.getString("sno").toString());
		  upd.setName(rs.getString("name").toString());
		  upd.setAge(rs.getInt("age"));
		  upd.setFather(rs.getString("father").toString());
		  upd.setSex(rs.getString("sex").toString());
		  upd.setCnic(rs.getString("cnic").toString());
		  upd.setAddr(rs.getString("address").toString());
		  upd.setCell(rs.getString("cell").toString());
		  upd.setDob(rs.getString("dob").toString());
		  arr.add(upd);
		}
		}
		catch(SQLException se)
		{se.printStackTrace();}
		catch(Exception e)
		{e.printStackTrace();}
		return arr;
	}	
	
	public void deleteRecord(int sno)
	{
		conn=Bean.Conn();
		try{
			String sql="select from person_info where sno='"+sno+"'";
			  OraclePreparedStatement pst=(OraclePreparedStatement)conn.prepareStatement(sql);
pst.execute();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception ex)
		{ex.printStackTrace();}
	}
}
