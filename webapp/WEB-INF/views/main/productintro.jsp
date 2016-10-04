<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/smartcan/assets/css/companyintro.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="container">
<jsp:include page="/WEB-INF/views/include/header.jsp" />
<div id="content"> 
   
   <div id="intro_main">
   <div id="intro_sub">
      <div id="brand_main">
         <h1>제품소개</h1>
      </div>
      
      <div id="about_bottom">
         <p id=highlight>ABOUT</p>
            <p>
               스마트 쓰레기통은 웹 기반과 모바일 어플리케이션으로 사용이 가능한 통합 관리 소프트웨어 서비스입니다.  <br>
               적재량 정보를 받아와 사용자가 효율적으로 쓰레기를 수거 할 수 있도록 수거 경로와 일정을 짜주며, 이를 통해 <br> 
               시간과 돈을 모두 절약 할 수 있습니다.
            </p>
      </div>
      
      <div id="first_wrap">
         <div id="about_wrap">
            <img src="/smartcan/assets/images/companyintro/location.jpg" width="840px">
         </div>   
      </div>
      
      <div id="second_wrap">
      
         <div id="set_one">
         <div id="img_one">
         <img src="/smartcan/assets/images/companyintro/fill_sensor.png" width="300px" height="200px">
         </div>
         <div id="content_one">
            <p> 1. 적재량 센서 <br> 실시간으로 모든 종류의  물질이나 폐기물을 <br> 센서를 통해 모니터링합니다.
            </p>
         </div>
         </div>
         
         <div id="set_two">
         <div id="img_two">
            <img src="/smartcan/assets/images/companyintro/tele.png" width="300px" height="200px">
         </div>
         <div id="content_two">
         <p>2. 경로 최적화 <br> 최적화된 경로를 생성하여 분석합니다.</p>
         </div>
         </div>
         
         <div id="set_three">
         <div id="img_three">
         <img src="/smartcan/assets/images/companyintro/trash_vehicle.png" width="300px" height="200px">
         </div>
         <div id="content_three">
         <p>3. 폐기물 수거 <br> 가득찬 쓰레기통을 대상으로 
         <br>가장 효율적으로 수거할 수 있습니다.</p>
         </div>
         </div>   
      </div>
      
      <div id="three_wrap">
         <div id="end_wrap">
         
         <h2 id="text_wrap"> Smart Trash Can에 광고를 신청해보세요. </h2>
         <a class="btn btn-primary" href="/smartcan/adver/list">
         <b>바로가기</b>
         </a>
         
         </div>
      </div>

   </div>
   </div>
   
   
   
</div>
<jsp:include page="/WEB-INF/views/include/footer.jsp" />
</div>
</body>
</html>