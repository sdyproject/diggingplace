package boot.data.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import boot.data.dto.MemberDto;
import boot.data.service.MemberService;

@RestController
public class LoginRestController {

	@Autowired
	MemberService mservice;
	
	@GetMapping("/member/memberlogin")
	public Map<String, String> loginproc(String email , String pass, HttpSession session)
	{
		Map<String, String> map = new HashMap<>();
		
		int result = mservice.LoginEmailPassCheck(email, pass);
		
		if(result==1)
		{
			session.setMaxInactiveInterval(60*60*4);
			
			MemberDto dto = mservice.getDataByEmail(email);
			
			session.setAttribute("loginok", "yes");
			session.setAttribute("loginemail", email);
			session.setAttribute("loginname", dto.getMember_nickname());
		}
		map.put("result", result==1?"success":"fail");
		
		return map;
	}
}
