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
<script type="text/javascript" src="/smartcan/assets/js/jquery/jquery-1.9.0.js"></script>
<script src="/gs25/assets/js/sweetalert.min.js"></script> 
<link rel="stylesheet" type="text/css" href="/gs25/assets/css/sweetalert.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp" />
	<div class="container">
		<div id="title1">
			<h3>Smart Can 신규 회원가입</h3>
		</div>
		<div id ="title1_p">
			<p>사용자와 함께 내일을 꿈꾸며, 새로운 삶의 가치를 창조하는 Smart Can 회원가입을 환영합니다.</p>
			<p>Smart Can 회원에 가입하시면, <em id="emphasis">smartcan</em> 홈페이지를 이용하실 수 있습니다.</p>
		</div>
		<div id="block">
			<h4 id="tlt2_p0">입력 사항</h4>
			<div id="signup">
				<form id="join-form" name="joinForm" method="post" action="/smartcan/user/join">
					<div id="brdwrap2">
						<h5 id="tit">기본사항</h5>
						<div class="tblwrap">
							<table class="tbl_wtype1">
								<tbody>
									<tr>
										<th scope="row"><strong class="reqd" title="필수항목">*</strong>이름</th>
										<td><input id="name" name="name" type="text" value=""></td>
										<th scope="row" id="tit2"><strong class="reqd" title="필수항목">*</strong>성별</th>
										<td>
											<input type="radio" name="gender" value="MALE" checked="checked"><label id="labelM">남</label>
											<input type="radio" name="gender" value="FEMALE"><label id="labelM">여</label>
										</td>
									</tr>
									<tr>
										<th scope="row" class=""><strong class="reqd" title="필수항목">*</strong>생년월일</th>
										<td><input id="birth" name="birth" type="text" value="" placeholder="Ex.19901212"></td>
										<th scope="row" id="tit2"><strong class="reqd" title="필수항목">*</strong>휴대폰</th>
										<td>
											<input id="phone" name="phone" type="text" value="" placeholder="'-'제외하고 숫자만 입력">
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				<div id="brdwrap2">
					<h5 id="tit">필수입력</h5>
					<div class="tblwrap">
						<p class="reqd_box"><strong class="reqd">*</strong> 필수 입력사항</p>
					 	<table class="tbl_wtype1">
							<tbody>
								<tr>
									<th scope="row"><label for="web_pwd1">이용등급 <strong class="reqd" title="필수항목">*</strong></label></th>
									<td>
										<div id="sel2_lt">
											<input type="radio" name="position" id="customer" value="CUSTOMER" checked />
											<label class="labelM" class="mr20">고객</label>
										</div>
									</td>
								</tr>
							
								<tr>
									<th scope="row"><label>아이디 (이메일)<strong class="reqd" title="필수항목">*</strong></label></th>
									<td>
										<input type="text" id="email" name="email" value=""/>
										<input type="button" class="btn banner" id="btn-checkEmail" value="ID 중복확인"/>
										<font id="msg_email"></font>
										<font  id="emailCheck"></font>
									</td>
								</tr>
								<tr>
									<th scope="row"><label>비밀번호 <strong class="reqd" title="필수항목">*</strong></label></th>
									<td>
										<input id="password" name="password" type="password" value="">
									</td>
								</tr>
								<tr>
									<th scope="row"><label>비밀번호 재확인<strong class="reqd" title="필수항목">*</strong></label></th>
									<td>
										<input id="repassword" name="repassword" type="password" value="">
										<font name="passCheck" id="passCheck"></font>
									</td>
								</tr>
								<tr>
									<th scope="row"><label>주소<strong class="reqd" title="필수항목">*</strong></label></th>
									<td>
										<input id="address" name="address" type="text" value="">
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					</div>
					<div id="brdwrap2">
						<h5 id="tit">개인정보 수집, 이용 동의</h5>
						<div class="brdwrap scl_box" tabindex="0">
							<div class="agree_tbox ch_view">
								<div>
								<EM>개인정보의 수집 및 이용목적</EM> 
								<P>회사는 서비스 제공을 위하여 필요한 최소한의 범위 내에서 다음 각 항목과 같은 목적으로 개인정보를 수집하고 있습니다.</P><br>
								<TABLE>
								<CAPTION>개인정보의 수집 및 이용목적</CAPTION>
								<COLGROUP>
								<COL width=300>
								<COL width=340>
								<COL></COLGROUP>
								<THEAD>
								<TR>
								<TH scope=col>개인정보 수집항목</TH>
								<TH scope=col>수집 목적</TH>
								<TH scope=col>보유 및 이용기간</TH></TR></THEAD>
								<TBODY>
								<TR>
								<TD>
								<P>성명, ID, 비밀번호, 생년월일, 성별, 이동전화 번호, &nbsp;</P>
								<P>I-PIN정보, 이메일&nbsp;&nbsp;</P></TD>
								<TD>회원제 서비스에 따른 본인 식별을 위해 사용 </TD>
								<TD class=other rowSpan=5>
								<P>회원탈퇴 시까지&nbsp;</P>
								<P>(기타 선택항목: 서비스 이용시까지)</P></TD></TR>
								<TR>
								<TD>
								<UL>
								<LI>- 공지, 불만처리 등을 위한 원활한 의사소통의 전달</LI>
								<LI>- 새로운 서비스 및 정보 제공</LI>
								<LI>- 서비스 홍보를 위한 TM자료 활용 </LI></UL></TD></TR>
								<TR>
								<TD>주소</TD>
								</TR>
								<TR>
								<TD>기타 선택항목(직장명,직장주소,부서명,생일)</TD>
								<TD>회원별 맞춤 서비스를 제공하기 위한 선택 입력</TD></TR></TBODY></TABLE>
								<P>그 밖에 인권침해 및 사생활 침해가 우려되는 개인정보는 일체 수집하지 않습니다.</P>
								<P>※ smartcan 어플의 간편 로그인 회원의 경우 최초 회원 가입 시 핸드폰 번호와 기기번호를 수집하며 프로모션 응모 및 모바일 커머스 이용 시 추가적인 정보가 수집됩니다.</P>
								<P>&nbsp;</P>
								</div>
							</div>
						</div>
						<fieldset id="agreeF">
							<legend>약관동의</legend>
							<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
							<label>서비스 약관에 동의합니다.(필수)</label>
						</fieldset>
					</div>
					<input class="btn btn-primary btn-register" type="submit" value="가입하기">
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</body>
<script>
	$(function() {
		$('#password').change(function() {
			$('font[name=passCheck]').text('');
			$('#repassword').val('');
		}); //#password.keyup
		$('#repassword').keyup(function() {
			if ($('#password').val() != $('#repassword').val()) {
				$('font[name=passCheck]').text('');
				$('font[name=passCheck]').html("암호틀림");
			} else {
				$('font[name=passCheck]').text('');
				$('font[name=passCheck]').html("암호맞음");
				swal("Good job!", "You clicked the button!", "success");
			}
		});
		
		$("#join-form").submit(function(){
			console.log("form check");
			//이름 체크
			if($("#name").val() == ""){
			sweetAlert("이름은 필수 입력 항목입니다. ","Something went wrong" ,"error");
			$("#name").focus();
			return false;
			}
			//생년월일
			var regBirth = /^(19|20)\d{2}([0][1-9]|1[012])(0[1-9]|[12][0-9]|3[01])$/;	//정규식
			if($("#birth").val() == ""){
				sweetAlert("생년월일은 필수 입력 항목입니다.","Something went wrong", "error");
				$("#birth").focus();
				return false;
			} else {
				if(!regBirth.test($("#birth").val())) {
					sweetAlert("생년월일 입력 형식이 잘못되었습니다.","Something went wrong", "error");
				    $("#birth").focus();
				    return false;  
				}
			}
			//휴대폰
			var regPhone = /^((01[0|1|6|7|8|9])[1-9]+[0-9]{6,7})|(010[1-9][0-9]{7})$/;
			if($("#phone").val() == ""){
				sweetAlert("휴대폰 번호는 필수 입력 항목입니다.","Something went wrong", "error");
				$("#phone").focus();
				return false;
			} else { 	//휴대폰 유효성 검사
				if(!regPhone.test($("#phone").val())) {  
					sweetAlert("휴대폰 번호 입력된 내용이 잘못된 형식입니다.","Something went wrong", "error");
				    $("#phone").focus();
				    return false;  
				}
			}
			//이메일
			if($("#email").val() == ""){
				sweetAlert("아이디 필수 입력 항목입니다.","Something went wrong", "error");
				$("#email").focus();
				return false;
			} 
			//중복검사
			if($("#emailCheck").val('') == "check"){
				sweetAlert("중복검사를 해주세요!","Something went wrong", "error");
				console.log($("#emailCheck").val(''));
				return false;
			}
		
			//패스워드
			if($("#password").val() == ""){
				sweetAlert("비밀번호는 필수 입력 항목입니다.","Something went wrong", "error");
				$("#password").focus();
				return false;
				}
			
			//재 패스워드
			if($("#repassword").val() == ""){
				sweetAlert("비밀번호 재입력은 필수 입력 항목입니다.","Something went wrong", "error");
				$("#repassword").focus();
				return false;
				}
			//주소
			if($("#address").val() == ""){
				sweetAlert("주소는 필수 입력 항목입니다.","Something went wrong", "error");
				$("#address").focus();
				return false;
				}
			
			//약관동의
			if($("#agree-prov").is(':checked') == false ) {
				sweetAlert("약관 동의가 필요합니다.","Something went wrong", "error");
		         return false;
		     }
		return true;
		
		});
		$("#email").change(function(){
			$("#emailCheck").text('');
			$("#emailCheck").val('');
			$("#btn-checkEmail").show();
		});
		
		$("#btn-checkEmail").click(function(){
			var email = $("#email").val();
			if(email == ""){
				return;
			}
		});
		//이메일 유효성 검사
		var regEmail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		$("#btn-checkEmail").click(function(){
			var email = $("#email").val();
			if(email == ""){
				sweetAlert("이메일을 입력하시지 않으셨습니다.","Something went wrong", "error");
				return false;
			} else {  //이메일 유효성 검사
			   	if(!regEmail.test($("#email").val())) { 
			   		sweetAlert("이메일 주소가 유효하지 않습니다.","Something went wrong", "error");
				      $("#email").focus(); 
				      return false; 
				}
			}
			$.ajax({
				url: "CheckEmail",
				type: "POST",
				data: {"email":email},
				dataType: "json",
				"success": function(response){
					//console.log(response);
					if(response.result == "fail"){
						console.error("error:"+response.message);
						return ;
					}
					
					if(response.data == true){
						sweetAlert("이미 존재하는 이메일입니다. 다른 이메일을 사용해 주세요.","Something went wrong", "error");
						$("#email").val("").focus();
						return;
					}
					//console.log("사용할 수 있음!");
					$("#emailCheck").text('check');
					$("#emailCheck").html("[사용 가능]");
					$("#btn-checkEmail").hide();
				},
				
				"error": function(jsXHR, status, e){
					console.error("error:"+status+":"+e);
				}
			});
		});
	});
</script>
</html>