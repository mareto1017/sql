package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import vo.Dept;
import vo.Emp;

public class EmpDAO {

	public static void main(String[] args) throws Exception{
		//System.out.println(EmpDAO.selectEmptList());
		System.out.println(EmpDAO.selectEmpAndDeptList());
	}

	public static ArrayList<Emp> selectEmpList() throws Exception{
		ArrayList<Emp> list = new ArrayList<>();
		
		String sql = "SELECT empno, ename, sal FROM emp";
		Connection conn = DBHelper.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Emp e = new Emp();
			e.setEmpNo(rs.getInt("empno"));
			e.setEname(rs.getString("ename"));
			e.setSal(rs.getDouble("sal"));
			list.add(e);
		}
		
		return list;
	}
	
	public static ArrayList<HashMap<String, Object>> selectEmpAndDeptList() throws Exception{
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		
		String sql = "SELECT emp.empno empNo, emp.ename ename, emp.deptno deptNo, dept.dname dname FROM emp INNER JOIN dept ON emp.deptno = dept.deptno";
		Connection conn = DBHelper.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			HashMap<String, Object> m = new HashMap<>();
			m.put("empNo", rs.getInt("empNo"));
			m.put("ename", rs.getString("ename"));
			m.put("deptNo", rs.getInt("deptNo"));
			m.put("dname", rs.getString("dname"));
			list.add(m);
		}
		
		return list;
	}
	
	public static ArrayList<Integer> selectDeptNoList() throws Exception {
		ArrayList<Integer> list = new ArrayList<>();
		
		String sql = "SELECT DISTINCT deptno deptNo "
				+ "FROM emp "
				+ "WHERE deptno IS NOT NULL "
				+ "ORDER BY deptno ASC";
		Connection conn = DBHelper.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			list.add(rs.getInt("deptNo"));
		}
		
		return list;
	}
	
	public static ArrayList<HashMap<String, Integer>> selectDeptNoAndCountList() throws Exception {
		ArrayList<HashMap<String, Integer>> list = new ArrayList<>();
		
		String sql = "SELECT deptno deptNo, count(*) cnt "
				+ "FROM emp "
				+ "WHERE deptno IS NOT NULL "
				+ "GROUP BY deptno "
				+ "ORDER BY deptno ASC";
		Connection conn = DBHelper.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			HashMap<String, Integer> m = new HashMap<>();
			m.put("deptNo", rs.getInt("deptNo"));
			m.put("cnt", rs.getInt("cnt"));
			list.add(m);
		}
		
		return list;
	}
	

	public static ArrayList<HashMap<String, String>> selectJobCaseList() throws Exception{
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		String sql = "SELECT ename, "
		        + "job, "
		        + "CASE "
		        + "WHEN job = 'PRESIDENT' Then '빨강' "
		        + "WHEN job = 'MANAGER' THEN '주황' "
		        + "WHEN job = 'ANALYST' THEN '노랑' "
		        + "WHEN job = 'CLERK' THEN '초록' "
		        + "ELSE '파랑' END color "
		        + "FROM emp "
		        + "ORDER BY (CASE " 
		        + "WHEN color = '빨강' THEN 1 "
		        + "WHEN color = '주황' THEN 2 "
		        + "WHEN color = '노랑' THEN 3 "
		        + "WHEN color = '초록' THEN 4 "
		        + "ELSE 5 END) ASC";
		Connection conn = DBHelper.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			HashMap<String, String> m = new HashMap<>();
			m.put("ename", rs.getString("ename"));
			m.put("job", rs.getString("job"));
			m.put("color", rs.getString("color"));
			list.add(m);
		}
		
		return list;
	}
}
