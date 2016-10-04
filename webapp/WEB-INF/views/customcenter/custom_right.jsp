<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>smartcan_right</title>
<link href="/smartcan/assets/css/customboard.css" rel="stylesheet"
	type="text/css">

</head>
<body>

	<div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
		<div id="content">
			<div id="customBoard_main">

				<div id="right">
					<div id="risk">
						<img src="/smartcan/assets/images/customcenter/risk.png">
					</div>
					<p class="list-right">
						읽을 권한이 없습니다. <br> 
						<a href="/smartcan/custom/list" id="list-return">리스트로 돌아가기</a>
					</p>

				</div>

			</div>
		</div>
		<jsp:include page="/WEB-INF/views/include/footer.jsp" />

	</div>

</body>
</html>