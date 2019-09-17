<%@page import="kr.or.ddit.lprod.model.Lprod"%>
<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<%@include file="/WEB-INF/views/commonjsp/basicLib.jsp" %>

<title>Jsp-basicLib</title>
<script>
	$(document).ready(function(){
		$(".prodTr").on("click", function(){
			
			var dataValue = $(this).data("lprodgu");
			
		
			$("#prod").val(dataValue);
			$("#frm").submit();
		});
		
	});
</script>
</head>
<body>
<form id = "frm" action="${cp }/prod" method = "get">
	<input type = "hidden" id = "prod" name = "prod"/>
</form>

	<!-- header -->
	<%@include file="/WEB-INF/views/commonjsp/header.jsp" %>
	

<div class="container-fluid">
		<div class="row">
			
<div class="col-sm-3 col-md-2 sidebar">
	<!-- left -->
	<%@include file="/WEB-INF/views/commonjsp/left.jsp" %>
</div><div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">제품리스트</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>제품번호</th>
					<th>제품코드</th>
					<th>제품명</th>
				</tr>
	
			<%-- 	<%
					List<Lprod> list = (List<Lprod>) request.getAttribute("list");
						for(Lprod lp : list){
				%>
					<tr>
						<td><%=lp.getLprod_id() %></td>
						<td><%=lp.getLprod_gu() %></td>
						<td><%=lp.getLprod_nm() %></td>
					</tr>
					
				<%		
						}
				%> --%>
				
				<c:forEach items="${lprodList }" var="lprod">
					<tr class = "prodTr" data-lprodGu="${lprod.lprod_gu }">
						<td>${lprod.lprod_id}</td>
						<td>${lprod.lprod_gu}</td>
						<td>${lprod.lprod_nm}</td>
					</tr>
				</c:forEach>
				
			</table>
		</div>

		<a class="btn btn-default pull-right">사용자 등록</a>

		<div class="text-center">
			<ul class="pagination">
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>