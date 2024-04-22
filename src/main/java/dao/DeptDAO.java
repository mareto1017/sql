package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import vo.Dept;

public class DeptDAO {
	
	public static void main(String[] args) throws Exception {
		//System.out.println(DeptDAO.selectDeptList());
		//System.out.println(DeptDAO.selectDeptOnOffList());
	}
	
	public static ArrayList<Dept> selectDeptList() throws Exception{
		ArrayList<Dept> list = new ArrayList<>();
		
		String sql = "SELECT deptno, dname, loc FROM dept";
		Connection conn = DBHelper.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Dept d = new Dept();
			d.setDeptNo(rs.getInt("deptno"));
			d.setDname(rs.getString("dname"));
			d.setLoc(rs.getString("loc"));
			list.add(d);
		}
		
		return list;
	}
	
	public static ArrayList<HashMap<String, Object>> selectDeptOnOffList() throws Exception {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		
		String sql = "SELECT deptno, dname, loc, 'ON' onOff FROM dept";
		Connection conn = DBHelper.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			HashMap<String, Object> d = new HashMap<>();
			d.put("deptNo",rs.getInt("deptno"));
			d.put("dname",rs.getString("dname"));
			d.put("loc",rs.getString("loc"));
			d.put("onOff", rs.getString("onOff"));
			list.add(d);
		}
		
		return list;
		
	}
	
	
}
