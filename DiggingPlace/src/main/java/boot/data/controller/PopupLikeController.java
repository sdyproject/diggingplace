package boot.data.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import boot.data.dto.PopupLikeDto;
import boot.data.service.MemberService;
import boot.data.service.PopupLikeService;
import boot.data.service.PopupService;

@Controller
public class PopupLikeController {

	@Autowired
	PopupLikeService lservice;

	@Autowired
	MemberService mservice;
	
	@Autowired
	PopupService pservice;
	

	@GetMapping("/popup/insertLike")
	public String insertLike(String popup_num, HttpSession session) {
		String loginemail = (String) session.getAttribute("loginemail");
		String member_num = mservice.findEmailMemberNum(loginemail);
		
		
		PopupLikeDto popupLikeDto = new PopupLikeDto();
		popupLikeDto.setPopup_num(popup_num);
		popupLikeDto.setMember_num(member_num);

		lservice.insertPopupLike(popupLikeDto);

		return "/popup/popupdetail";
	}

	@GetMapping("/popup/deleteLike")
	public String deleteLike(String popup_num, HttpSession session) {
		String loginemail = (String) session.getAttribute("loginemail");
		String member_num = mservice.findEmailMemberNum(loginemail);

		lservice.deletePopupLike(popup_num, member_num);

		return "/popup/popupdetail";

	}
	
	@GetMapping("/popup/insertLikelist")
	public String insertLikelist(String popup_num, HttpSession session) {
		String loginemail = (String) session.getAttribute("loginemail");
		String member_num = mservice.findEmailMemberNum(loginemail);
		
		
		PopupLikeDto popupLikeDto = new PopupLikeDto();
		popupLikeDto.setPopup_num(popup_num);
		popupLikeDto.setMember_num(member_num);

		lservice.insertPopupLike(popupLikeDto);

		return "/popup/popuplist";
	}

	@GetMapping("/popup/deleteLikelist")
	public String deleteLikelist(String popup_num, HttpSession session) {
		String loginemail = (String) session.getAttribute("loginemail");
		String member_num = mservice.findEmailMemberNum(loginemail);

		lservice.deletePopupLike(popup_num, member_num);

		return "/popup/popuplist";

	}
	
	
	

}
