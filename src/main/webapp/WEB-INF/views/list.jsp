<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>## LeeHaeRi Profile ##</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/span.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/table.css">
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<center>
	<table class="t-type01" width="75%" border="0" cellpadding="20" cellspacing="0">
		<tr>
			<td><span class="title01">개발자 이해리의 홈페이지</span></td>
		</tr>
		<tr>
			<td><span class="title02">저는 개발직을 원하는 개발자 이해리입니다. 연락주세요!</span></td>
		</tr>
		<tr>
		
			<!-- 중간 -->
			<table width="70%" border="0" cellpadding="10" cellspacing="0">
				<tr>
					<td height="500" bgcolor="#D5D5D5" align="center">
						<table border="0" cellpadding="10" cellspacing="0">
							<tr>
								<td class="td-type04">번호</td>
								<td class="td-type04">내용</td>
								<td class="td-type04">이름</td>
								<td class="td-type04">아이디</td>
								<td class="td-type04">글쓴 날짜</td>
							</tr>	
							<c:forEach items="${list }" var="dto">
							<tr>
								<td class="td-type05">${dto.qnum }</td>
								<td class="td-type05" width="300" ><a href="qview?qnum=${dto.qnum }">
								<c:choose>
									<c:when test="${fn:length(dto.qcontent) > 25 }">
										<c:out value="${fn:substring(dto.qcontent,0,24)}" />....
									</c:when>
									<c:otherwise>
										<c:out value="${dto.qcontent }"/>
									</c:otherwise>
								</c:choose>
								</a></td>
								<td class="td-type05">${dto.qname }</td>
								<td class="td-type05">${dto.qid }</td>
								<td class="td-type05">
									<c:out value="${fn:substring(dto.qdate,0,16) }"></c:out>
								</td>
							</tr>		
							</c:forEach>
							<tr>
								<td colspan="5" align="right">
									<input id="button01" type="button" value="질문하기" onclick="javascript:window.location='question'">
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</tr>
	</table>

	<%@ include file="include/footer.jsp" %>
</body>
</html>
