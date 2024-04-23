<%@page import="java.util.HashMap"%>
<%@page import="dao.EmpDAO"%>
<%@page import="vo.Emp"%>
<%@page import="vo.Dept"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Emp> list = null;
	String[] ck = request.getParameterValues("ck");
	if(ck == null) {
		System.out.println(ck + "<-- ck");
	} else {
		System.out.println(ck.length + "<-- ck.length");
		ArrayList<Integer> ckList = new ArrayList<>();
		for(String s : ck){
			ckList.add(Integer.parseInt(s));
		}
		list = EmpDAO.selectEmpListByGrade(ckList);
		System.out.println(list.size() + "<-- list.size");
	}
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EMP GRADE 검색</h1>
	<form action="./q003VoOrMap.jsp" method="post">
		GRADE : 
		<%
			for(int i = 1; i < 6; i++){
		%>
				<input name="ck" type="checkbox" value="<%=i %>"><%=i %>
		<%
			}
		%>
		<br>
		<button type="submit">검색</button>
	</form>
	
	<hr>
	
	<h1>결과</h1>
	<%
		if(ck == null){
			return;
		}
	%>
	<table border="1">
		<tr>
			<th>ename</th>
			<th>grade</th>
		</tr>
		<%
			for(Emp e : list){
		%>
				<tr>
					<td><%=e.getEname() %></td>
					<td><%=e.getGrade() %></td>
				</tr>
		<%
			}
		%>
	</table>
</body>
</html>