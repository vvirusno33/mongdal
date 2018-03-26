<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>메일수신</title>
</head>
<body>
	<h1>
		메일수신 결과  
	</h1>
	
	<P>${mailVo.title}</P>
	<P>${mailVo.contents}</P>
	<P>${mailVo.sender}</P>
	<P>${mailVo.receiver}</P>
</body>
</html>
