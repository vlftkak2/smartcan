<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/gs25/assets/css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/gs25/assets/js/jquery/jquery-1.9.0.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp" />
		<div class="container">
		<div id="title1">
			<h3>GS25 편의점 회원정보 수정 완료</h3>
		</div>
		<div id ="title1_p">
			<p><em id="emphasis">회원정보가 성공적으로 수정되었습니다.</em>&nbsp;고객과 함께 내일을 꿈꾸며,
			<br>새로운 삶의 가치를 창조하는 GS25 편의점은 회원님을 위해 보다 열심히 일하겠습니다.</p>
		</div>
		<div id="contents">
			<div id="join-succ">
				<div id="goMain">
					<ul>
						<li id="line"><h3 class="lineM"><a href="/gs25/main">메인페이지 이동</a></h3></li>
						<li id="line"><h3 class="lineL"><a href="/gs25/user/loginform">로그인하기</a></h3></li>
					</ul>
				</div>	
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
</html>