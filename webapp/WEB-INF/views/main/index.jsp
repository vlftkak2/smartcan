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
<link href="/smartcan/assets/css/index.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/smartcan/assets/js/jquery/jquery-1.9.0.js"></script>

</head>
<body>
<div id="container">
<jsp:include page="/WEB-INF/views/include/header.jsp" />
<div id="content">

<div id="intro_main">
   <div id="intro_sub">

            <div id="main_top"> <!-- 상단 메인 이미지 -->
               <img src="/smartcan/assets/images/index/main_top.jpg" width=1000px>
            </div>
            
         <div id="first_wrap">
            <div id="fresh_photo">
               <img src="/smartcan/assets/images/index/path.png" width=450px />
            </div>
            
            
            <div id="about_top">
                     <div id="ban1">
                     <a href="/smartcan/companyintro">
                     <span><h3>Smart trash can introduction </h3></span>
                     <span>"일상 속에서 편리하게 사용할 수 있는 쓰레기통으로" <br>
                     "편리함을 느껴보세요."
                     </span>
                     </a>
                     </div>
            </div>
            <div id=about_bottom>
                     <div id="ban2">
                     <a href="/smartcan/board/customlist">
                     <span><h3>Smart tash can board</h3></span>
                     <span>"스마트 쓰레기통의 불편한점이 있었나요?" <br>
                     "여기를 클릭하세요."
                     </span>
                     </a>
                     </div>
            </div>   
         
         </div>


         <div id="end_wrap"> 
         
            <div id="daily_wrap">
               <p id="highlight">잦은 수거로 인한 이산화탄소가 줄어듭니다. </p>
               <p id="highlight2"> 하루가 시작되고 잠깐의 휴식이 되어 머무르고, 하루의 마무리를 <br> 같이하는
               스마트 쓰레기통 <br>
               </p>
            </div>
            
            <div id="refresh_photo">
               <img src="/smartcan/assets/images/index/route.jpg"/>
            </div>
            
         </div>
      





   </div>
</div>
</div>
<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</div>
</body>
</html>