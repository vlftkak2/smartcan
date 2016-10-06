package kr.ac.sungkyul.smartcan.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import kr.ac.sungkyul.smartcan.dao.UserDao;
import kr.ac.sungkyul.smartcan.vo.PassLinkVo;
import kr.ac.sungkyul.smartcan.vo.UserVo;



@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private MailSender mailSender; // xml에 등록한 bean autowired
	
	// 가입
	public void join(UserVo vo){
		userDao.insert(vo);
	}
	
	// 로그인
	public UserVo login(String email, String password){
		UserVo authUser = userDao.login(email,password);
		return authUser;
	}
	
	//로그인 시 검사
	public Boolean loginCheck(String email, String password){
		UserVo vo =  userDao.login(email,password); // no, name, email 가져옴
		Boolean result = (vo != null);
		return result;
	}
	
	//회원정보 수정 시 정보 출력
	public UserVo get(Long no){	
		UserVo uservo = userDao.get(no);
		return uservo;
	}
	
	// 회원정보 수정 (패스워드 미입력)
	public void update(UserVo vo){ 
		userDao.update(vo);
	}
	
	// 회원정보 수정 (패스워드 입력)
	public void updateInfo(UserVo vo){
		userDao.update(vo);	
	}
	
	//로그인 시 검사
	public Boolean idCheck(UserVo uservo){
		String email = userDao.find(uservo);
		Boolean result = (email != null); // 존재하면 true
		return result;
	}
	 //아이디 찾기
	public String idfind(UserVo vo){
		String email = userDao.find(vo);
		return email;
	}
	
	//비밀번호 검사
	public String checkPass(UserVo uservo){	
		String email = userDao.passfind(uservo);
		return email;
	}
	
	//비밀번호 검사
	public String sendEmail( String email) throws Exception {
    	System.out.println("emailController: "+email);
    	
    	String ranNum= random();	//해시암호화
    	
    	SimpleMailMessage message = new SimpleMailMessage();
    	
    	//여러 버퍼 이용 시 속도 면에서 빠름
    	StringBuffer strBuffer1 = new StringBuffer(ranNum);  
    	
    	String link= strBuffer1.append(email).toString();
    	System.out.println("link: "+link);
    	userDao.savelink(link,email);	//DB에 링크 저장
    	
    	String sender = "GS25_Manager@gs25.com"; 
    	String receiver = "vlftkak2@naver.com"; //받을사람의 이메일입니다.
        String subject = "Smart Can 회원님의 임시 비밀번호입니다.";
        String content = "안녕하세요. Smart Can입니다. 회원님의 비밀번호를 새로 설정하실 수 있으시는 링크 입니다. \n" 
        				+ "http://localhost:8088/smartcan/user/" + link +"/repassword";
        
    	
        message.setFrom(sender);
        message.setTo(receiver);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
        
        System.out.println("이메일 전송");
        
        String result = "true";
        return result;
		}
	
	// 해시암호화
	public String random() {
		// (1) Calendar객체를 얻는다.
		Calendar cal = Calendar.getInstance();
		// (2) 출력 형태를 지정하기 위해 Formatter를 얻는다.
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy:MM:dd-hh:mm:ss");
		// (3) 출력형태에 맞는 문자열을 얻는다.
		String datetime = sdf1.format(cal.getTime());
		System.out.println("--> " + datetime);
		
		String MD5 = ""; 
		try{
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			md.update(datetime.getBytes()); 
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer(); 
			for(int i = 0 ; i < byteData.length ; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			MD5 = sb.toString();
			
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace(); 
			MD5 = null; 
		}
		System.out.println(MD5);
		return MD5;
		
	}
	
	//비밀번호 찾기 후 재설정
	 public Long passlink(String domain){
		 PassLinkVo plvo = userDao.passlink(domain); // no, link, state, user_no 가져옴
		 Long no = null;
		 
		 if(plvo == null){
			 System.out.println("plvo null");
			 return 0L;
		 } else{
			 System.out.println("plvo not null");
			 Integer state = plvo.getState();
			 System.out.println(state);
			 if(state == 0){
				 System.out.println("State 0");
				 no = plvo.getUser_no();
			 } else {
				 System.out.println("State 1");
				 return 0L;
			 }
		 }
		 
		 return no;
	}
	//비밀번호 찾기 후 재설정
	 public String setpass(Long no,String password){
			Integer state = 1; 
			userDao.setState(no, state); //state 설정
				
			Integer resultInt = userDao.setPass(no,password); //result 반환
			String result = String.valueOf(resultInt); // String 변환
			return result;
		}
	 
	//아이디 유효성 검사
	public Map<String, Object> checkEmail(String email){	
			Long no = userDao.checkEmail(email);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", "success");
			map.put("data", no != null);	//존재할 경우 true
			System.out.println(email + " -service- "+ (no != null));
			
			return map;
	}
}