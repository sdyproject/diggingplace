package boot.data.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import boot.data.dto.ExhibitionLikeDto;

import boot.data.service.ExhibitionLikeService;
import boot.data.service.ExhibitionService;
import boot.data.service.MemberService;

@Controller
public class ExhibitionLikeController {

	@Autowired
	ExhibitionLikeService lservice;

	@Autowired
	MemberService mservice;
	
	@Autowired
	ExhibitionService eservice;
	

	@GetMapping("/exhibition/insertLike")
	public String insertBoardLike(String exhibition_num, HttpSession session) {
		String loginemail = (String) session.getAttribute("loginemail");
		String member_num = mservice.findEmailMemberNum(loginemail);
		
		
		ExhibitionLikeDto exhibitionLikeDto = new ExhibitionLikeDto();
		exhibitionLikeDto.setExhibition_num(exhibition_num);
		exhibitionLikeDto.setMember_num(member_num);

		lservice.insertExhibitionLike(exhibitionLikeDto);

		return "/exhibition/exhibitiondetail";
	}

	@GetMapping("/exhibition/deleteLike")
	public String deleteBoardLike(String exhibition_num, HttpSession session) {
		String loginemail = (String) session.getAttribute("loginemail");
		String member_num = mservice.findEmailMemberNum(loginemail);

		lservice.deleteExhibitionLike(exhibition_num, member_num);

		return "/exhibition/exhibitiondetail";

	}
	
	@GetMapping("/exhibition/insertLikeList")
	public String insertLikeList(String exhibition_num, HttpSession session) {
		String loginemail = (String) session.getAttribute("loginemail");
		String member_num = mservice.findEmailMemberNum(loginemail);
		
		
		ExhibitionLikeDto exhibitionLikeDto = new ExhibitionLikeDto();
		exhibitionLikeDto.setExhibition_num(exhibition_num);
		exhibitionLikeDto.setMember_num(member_num);

		lservice.insertExhibitionLike(exhibitionLikeDto);

		return "/exhibition/exhibitionlist";
	}

	@GetMapping("/exhibition/deleteLikeList")
	public String deleteLikeList(String exhibition_num, HttpSession session) {
		String loginemail = (String) session.getAttribute("loginemail");
		String member_num = mservice.findEmailMemberNum(loginemail);

		lservice.deleteExhibitionLike(exhibition_num, member_num);

		return "/exhibition/exhibitionlist";

	}
	
	

}
