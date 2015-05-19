<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Dream Hotel</title>
</head>
<body>
	<h1>
		Danh sách phòng: 
	</h1>
	<table>
		<thead>
			<tr>
				<th>Số phòng</th>
				<th>Loại phòng</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${displayRoom}" var="room">
			<tr>
				<td><c:out value="${room.number}" /></td>
				<td><c:out value="${room.type}" /></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
