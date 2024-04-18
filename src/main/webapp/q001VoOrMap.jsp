<%@page import="java.util.HashMap"%>
<%@page import="dao.EmpDAO"%>
<%@page import="vo.Emp"%>
<%@page import="vo.Dept"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	ArrayList<Dept> deptList = DeptDAO.selectDeptList();
	ArrayList<Emp> empList = EmpDAO.selectEmpList();
	ArrayList<HashMap<String, Object>> deptOnOffLIst = DeptDAO.selectDeptOnOffList();
	ArrayList<HashMap<String, Object>> empAndDeptLIst = EmpDAO.selectEmpAndDeptList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Dept List</h1>
	<table border="1">
		<tr>
			<th>dpetNo</th>
			<th>dname</th>
			<th>loc</th>
		</tr>
		<%
			for(Dept d : deptList){
		%>
				<tr>
					<td><%=d.deptNo %></td>
					<td><%=d.dname %></td>
					<td><%=d.loc %></td>
				</tr>
		<%
			}
		%>
	</table>
	
	<h1>Emp List</h1>
	<table border="1">
		<tr>
			<th>empNo</th>
			<th>ename</th>
			<th>sal</th>
		</tr>
		<%
			for(Emp e : empList){
		%>
				<tr>
					<td><%=e.empNo %></td>
					<td><%=e.ename %></td>
					<td><%=e.sal %></td>
				</tr>
		<%
			}
		%>
	</table>
	<h1>Dept OnOff List</h1>
	<table border="1">
		<tr>
			<th>empNo</th>
			<th>ename</th>
			<th>sal</th>
			<th>onOff</th>
		</tr>
		<%
			for(HashMap<String, Object> m : deptOnOffLIst){
		%>
				<tr>
					<td><%=m.get("deptNo") %></td>
					<td><%=m.get("dname") %></td>
					<td><%=m.get("loc") %></td>
					<td><%=m.get("onOff") %></td>
				</tr>
		<%
			}
		%>
	</table>
	
		</table>
	<h1>Emp Dept List</h1>
	<table border="1">
		<tr>
			<th>empNo</th>
			<th>ename</th>
			<th>deptNo</th>
			<th>dname</th>
		</tr>
		<%
			for(HashMap<String, Object> m : empAndDeptLIst){
		%>
				<tr>
					<td><%=m.get("empNo") %></td>
					<td><%=m.get("ename") %></td>
					<td><%=m.get("deptNo") %></td>
					<td><%=m.get("dname") %></td>
				</tr>
		<%
			}
		%>
	</table>
</body>
</html>