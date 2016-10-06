<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/smartcan/assets/css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/smartcan/js/jquery/jquery-1.9.0.js"></script>
<script src="/gs25/assets/js/sweetalert.min.js"></script> 
<link rel="stylesheet" type="text/css" href="/gs25/assets/css/sweetalert.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp" />
	<div class="container">
		<h3 id="tlt1">Smart Can</h3>
		<div id="contents">
			<div id="user">
				<div id="log-border">
					<p id="title"><em>Smart Can</em> <em style="color: blue">로그인</em></p>
					<p id="intro">Smart Can에 가입하신<br> 아이디와 비밀번호로 로그인 하실 수 있습니다.</p>
					<form class="login-form" name="loginform" method="post"  >
					<ul>
						<li><input id="email" name="email" class="form-control" type="text" value="" placeholder="이메일"></li>
						<li><input id="password" name="password" type="password" class="form-control" value="" placeholder="비밀번호"></li>
					</ul>
						<button class="btn btn-primary btn-block" type="button" id="btn_Login">로그인</button>
					</form>
				</div>
			</div>
			<div id="findMember">
				<div id="joincan">
					<p>회원가입을 하시면 다양한 혜택을 이용하실 수 있습니다.</p>
					<a href="/smartcan/user/joinform" class="btn btn_arr wt" id="canbtn1">회원가입</a>
				</div>
				<div id="findcan">
					<p>아이디 및 비밀번호를 잊으셨나요?<br>아이디 찾기와 비밀번호 찾기를 이용해 주세요.</p>
					<a href="/smartcan/user/findInfo"><input type="button" class="btn btn_arr wt" id="canbtn2" value="아이디/비밀번호 찾기"/></a>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />

</body>
<script>
$(function() {	
 	//로그인 가능 여부 (아디 & 비번  일치 여부)
	 $("#btn_Login").on("click", function(){
		if($("#email").val() == ""){
			sweetAlert("아이디를 입력해주십시오.", "Something went wrong!", "error");
			$("#email").focus();
			return false;
			}
		
		if($("#password").val() == ""){
			sweetAlert("비밀번호를 입력해주십시오.", "Something went wrong!", "error");
			$("#password").focus();
			return false;
			}
		
		var email = $("#email").val();
		var password = $("#password").val();	
	
		$.ajax({	
			url: "checkLogin",
			type: "POST",
			data: {"email": email, "password": password},
			dataType: "text",
			success: function(result){	//비동기식으로 진행되어 결과와 상관 없이 submit되므로 계속 refres됨(따로 동기식으로 변경해야함)
				console.log(result);
				if(result == "false"){
					console.log(result);
					sweetAlert("유효하지 않는 로그인입니다.", "다시 시도해주세요.", "error");
					return false;
				}
				
				 if(result == "true"){
					location.href='/smartcan/main';
				} 
			},
			
			error: function(jsXHR, status, e){
				console.error("error:"+status+":"+e);
			}
		});
	});
});
</script>
</html>