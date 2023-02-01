package com.crud.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.db.cons.conn.connectiondb;

public class querycrud {
	
	public static void insertdata(int id,String name,double mark) throws Exception		//insert
	{
		Connection con=connectiondb.getconnection();
		PreparedStatement pstmt= con.prepareStatement("insert into student values (?,?,?)");
		
		pstmt.setInt(1,id);
		pstmt.setString(2,name);
		pstmt.setDouble(3,mark);
		int nora=pstmt.executeUpdate();
		if(nora!=0)
		{
			System.out.println("Successfully data inserted...!!!");
		}
		else 
		{
			System.out.println("Something went wrong pls check...!!!");
		}
		
		if(con!=null)
		{
			con.close();
		}
		
		}
		
	
	public static void deletedata(int id) throws Exception							//delete
	{
		Connection con=connectiondb.getconnection();
		PreparedStatement pstmt=con.prepareStatement("delete from student where sid=?");
		pstmt.setInt(1, id);
		int nora=pstmt.executeUpdate();
		if(nora!=0)
		{
			System.out.println("Successfully deleted...!!!");
		}
		else 
		{
			System.out.println("Something went wrong...pls check!!!");
		}
		
		if(con!=null)
		{
			con.close();
		}
		
	}
	
	public static void updatenull(int id,String name,double mark) throws Exception 		//update
	{
		Connection con=connectiondb.getconnection();
		Statement stmt=con.createStatement();
		String uquery=("update student set sname='"+name+"'where sid="+id);
		String u1query=("update student set sperc="+mark+"where sid="+id);
		int  nora=stmt.executeUpdate(uquery);
		int nori=stmt.executeUpdate(u1query);
		if(nora!=0 && nori!=0)
		{
		System.out.println("successfully Sname & mark updated null...!!!");
		}
		else if(nora==0 && nori==0)
		{
		System.out.println("Error...this id is not present in Student table...!!!");
		}
	
		if(con!=null) {
			con.close();
		}
		if(stmt!=null) {
			stmt.close();
	}
	}
	public static void updatename(int id,String name) throws Exception 			//update
	{
		Connection con=connectiondb.getconnection();
		PreparedStatement pstmt=con.prepareStatement("update student set sname=? where sid=?");
		pstmt.setString(1, name);
		pstmt.setInt(2, id);
		int nora=pstmt.executeUpdate();
		if(nora!=0)
		{
		System.out.println("Successfully Sname updated...!!!");
		}
		else
		{
			
		System.out.println("Error...this id is not present in Student table...!!!");
		}
		
		
		if(con!=null)
		{
			con.close();
		}
	}
	public static void updatenameandmark(int id,String name,double mark) throws Exception 
	{
		Connection con=connectiondb.getconnection();
		PreparedStatement pstmt=con.prepareStatement("update student set sname=?,sperc=? where sid=?");
		pstmt.setString(1, name);
		pstmt.setDouble(2, mark);
		pstmt.setInt(3, id);
		int nora=pstmt.executeUpdate();
		if(nora!=0)
		{
		System.out.println("successfully Sname & mark updated...!!!");
		}
		else
		{
		System.out.println("Error...this id is not present in Student table...!!!");
		}
	
		if(con!=null) {
			con.close();
		}
	}
	public static void updatemark(int id,double mark) throws Exception 
	{
		Connection con=connectiondb.getconnection();
		PreparedStatement pstmt=con.prepareStatement("update student set sperc=? where sid=?");
		pstmt.setDouble(1, mark);
		pstmt.setInt(2, id);
		int nora=pstmt.executeUpdate();
		if(nora!=0)
		{
		System.out.println("successfully Sperc updated...!!!");
		}
		else
		{
		System.out.println("Error...this id is not present in Student table...!!!");	
		}
		
		
		if(con!=null)
		{
			con.close();
		}
		
	}
	public static void searchdata(int id) throws Exception						//search
	{
		Connection con=connectiondb.getconnection();
		PreparedStatement pstmt=con.prepareStatement("select * from student where sid=?");
		pstmt.setInt(1, id);
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next())
		{
			int sid=rs.getInt(1);
			String sname=rs.getString(2);
			double sperc=rs.getDouble(3);
			System.out.println(sid+"\t"+sname+"\t\t"+sperc);
		}
		
		if(con!=null)
		{
			con.close();
		}
	}
	
	public static void displayalldata() throws Exception				//display
	{
		Connection con=connectiondb.getconnection();
		PreparedStatement pstmt=con.prepareStatement("select * from student");
	
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next())
		{
			int sid=rs.getInt(1);
			String sname=rs.getString(2);
			double sperc=rs.getDouble(3);
			System.out.println(sid+"\t"+sname+"\t\t\t"+sperc);
		}
		if(con!=null)
		{
			con.close();
		}
		
	}

}
