package boot.data.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import boot.data.dto.MemberDto;
import boot.data.service.KakaoAPI;
import boot.data.service.MemberService;

@Controller
public class LoginController {

	@Autowired
	MemberService mservice;

	@Autowired
	private KakaoAPI kakao;

	@GetMapping("/login/main")
	public String loginform(HttpSession session, Model model) {

		String loginemail = (String) session.getAttribute("loginemail");
		String loginok = (String) session.getAttribute("loginok");

		if (loginok == null)
			return "layout2/login/loginform";

		else {
			session.setMaxInactiveInterval(60 * 60 * 4);
			String name = mservice.getMemberName(loginemail);
			model.addAttribute("name", name);
			System.out.println("name:" + name);
			return "redirect:/";

		}
	}

	@PostMapping("/member/loginprocess")
	public String loginprocess(String member_email, String member_pass, HttpSession session,
			@RequestParam(required = false) String cbsave, Model model) {

		int check = mservice.LoginEmailPassCheck(member_email, member_pass);
		if (check == 1) {

			session.setAttribute("loginemail", member_email);
			session.setAttribute("loginok", "loginok");
			session.setAttribute("cbsave", cbsave);
			System.out.println("cbsave:" + cbsave);
			return "redirect:/";
		} else {
			return "redirect:/member/loginform";
		}

	}

	@GetMapping("/member/loginError")
	@ResponseBody
	public int loginError(String member_email, String member_pass) {
		int check = mservice.LoginEmailPassCheck(member_email, member_pass);
		System.out.println(member_email + " " + member_pass);
		System.out.println(check);
		return check;
	}

	
	  @GetMapping("/login/logoutprocess") 
	  public String logout(HttpSession session)
	  {
	  
	 
	  session.removeAttribute("loginok");
	  
	  
	 
	  
	  return "redirect:/"; 
	  }
	 

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/kakao/login", method = RequestMethod.GET)
	public String Kakaologin(@RequestParam(value = "code", required = false) String code) throws Exception {
		String access_Token = kakao.getAccessToken(code);
		MemberDto MemberInfo = kakao.getUserInfo(access_Token);
		System.out.println("login Controller : " + MemberInfo);
		/*
		 * System.out.println("###nickname#### : " + loginok.get("member_nickname"));
		 * System.out.println("###email#### : " + loginok.get("member_email"));
		 */

		session.invalidate();

		session.setAttribute("member_name", MemberInfo.getMember_name());
		session.setAttribute("loginemail", MemberInfo.getMember_email());
		/* session.setAttribute("member_photo", MemberInfo.getMember_photo()); */
		session.setAttribute("member_gender", MemberInfo.getMember_gender());
		session.setAttribute("loginok", MemberInfo);

		return "redirect:/";

	}

	
}
