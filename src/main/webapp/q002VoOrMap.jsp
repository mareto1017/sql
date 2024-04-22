<%@page import="java.util.HashMap"%>
<%@page import="dao.EmpDAO"%>
<%@page import="vo.Emp"%>
<%@page import="vo.Dept"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Integer> deptNoList = EmpDAO.selectDeptNoList();
	ArrayList<HashMap<String, Integer>> deptNoAndCountList = EmpDAO.selectDeptNoAndCountList();
	ArrayList<HashMap<String, String>> jobCaseList = EmpDAO.selectJobCaseList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<select name="deptno">
		<optiom value="">:::선택:::</optiom>
		<%
			for(int i : deptNoList){
		%>
				<option vaule=<%=i %>><%=i %></option>
		<%
			}
		%>
	</select>
	
	<h1>DISTINCT대신 GROUP BY를 사용해야만 하는 경우</h1>
	<table border="1">
		<tr>
			<th>detpNo</th>
			<th>cnt</th>
		</tr>
		<%
			for(HashMap<String, Integer> m : deptNoAndCountList){
		%>
				<tr>
					<td><%=m.get("deptNo") %></td>
					<td><%=m.get("cnt") %></td>
				</tr>
		<%
			}
		%>
	</table>
	
	<h1>Job Case List</h1>
	<table border="1">
		<tr>
			<th>ename</th>
			<th>job</th>
			<th>color</th>
		</tr>
		<%
			for(HashMap<String, String> m : jobCaseList){
		%>
				<tr>
					<td><%=m.get("ename") %></td>
					<td><%=m.get("job") %></td>
					<td><%=m.get("color") %></td>
				</tr>
		<%
			}
		%>
	</table>
</body>
</html>