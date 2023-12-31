package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.net.MulticastSocket;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.ExhibitionDto;
import boot.data.dto.MemberDto;
import boot.data.dto.PopupDto;

import boot.data.dto.ReviewDto;
import boot.data.service.ExhibitionLikeService;
import boot.data.service.ExhibitionService;

import boot.data.service.MemberService;
import boot.data.service.PopupLikeService;

import boot.data.service.PopupService;
import boot.data.service.ReviewService;

@Controller
public class MemberController {
	@Autowired
	MemberService mservice;

	@Autowired
	ExhibitionLikeService lservice;

	@Autowired
	ExhibitionService eservice;

	@Autowired
	PopupLikeService plservice;

	@Autowired
	PopupService pservice;

	@Autowired
	ReviewService rservice;

	

	@GetMapping("/member/loginform")
	public String memberlogin()

	{
		return "/login/loginform";
	}

	@GetMapping("/member/memberlist")
	public String list()

	{
		return "layout/member/memberlist";
	}

	@GetMapping("/member/list")
	public String list(Model model) {
		List<MemberDto> list = mservice.getAllMember();

		model.addAttribute("list", list);
		model.addAttribute("count", list.size());

		return "/member/memberlist";
	}

	@GetMapping("/member/memberform")
	public String memberform() {
		return "/member/memberform";
	}

	// 이메일중복체크
	@GetMapping("/member/memberemailcheck")
	@ResponseBody
	public Map<String, Integer> memberemailcheck(@RequestParam String member_email) {
		Map<String, Integer> map = new HashMap<>();
		int n = mservice.getSearchEmail(member_email);
		System.out.println(n);
		map.put("count", n);

		return map;
	}

	@GetMapping("/member/membernicknamecheck")
	@ResponseBody
	public Map<String, Integer> memberninknamecheck(@RequestParam String member_nickname) {
		Map<String, Integer> map = new HashMap<>();
		int nick = mservice.getSearchNinkname(member_nickname);
		System.out.println("nick:" + nick);
		map.put("nickcount", nick);

		return map;
	}
	
	
	@GetMapping("/member/memberupdatenicknamecheck")
	@ResponseBody
	public Map<String, Integer> memberupdatenicknamecheck(@RequestParam String member_nickname,HttpSession session) {
		String loginemail = (String) session.getAttribute("loginemail");
		/* System.out.println(loginemail); */
		String member_num = mservice.findEmailMemberNum(loginemail);
		/*
		 * System.out.println(member_num);
		 */
		
		Map<String, Integer> map = new HashMap<>();
		int unick = mservice.getUpdateNinkname(member_nickname, member_num);
		
		map.put("unick", unick);
		System.out.println("unick:" + unick);
		return map;
	}
	// insert

	@PostMapping("/member/memberinsert")
	public String insert(@ModelAttribute MemberDto dto,
			/* MultipartFile myphoto, */
			HttpSession session) {

		mservice.insertMember(dto);

		return "/login/loginform";

	}

	
	@GetMapping("/myinfo")
	public ModelAndView myinfo(Model model, HttpSession session,
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage
			
			) {

		ModelAndView view = new ModelAndView();

		String loginemail = (String) session.getAttribute("loginemail");

		String member_num = mservice.findEmailMemberNum(loginemail);

		MemberDto dto = mservice.getDataByMemberNum(member_num);
		
		int totalCounts = pservice.getMyLikePopupCount(member_num);
		int rtotalCounts = rservice.writeReviewCount(member_num);

		int totalCount = eservice.getMyLikeExhibitionCount(member_num);
		
		
		int totalPage;
		int startPage;
		int endPage;
		int start;
		int perPage = 3;
		int perBlock = 5;

		totalPage = totalCount / perPage + (totalCount % perPage == 0 ? 0 : 1);

		startPage = (currentPage - 1) / perBlock * perBlock + 1;
		endPage = startPage + perBlock - 1;

		if (endPage > totalPage)
			endPage = totalPage;

		start = (currentPage - 1) * perPage;
		

		List<ExhibitionDto> list = eservice.getMyLikeExhibitionDatas(member_num, start, perPage);
		System.out.println("list:" + list);
		
		
		
		

		int no = totalCount - (currentPage - 1) * perPage;
		view.addObject("totalCounts", totalCounts);
		view.addObject("totalCount", totalCount);
		view.addObject("rtotalCounts", rtotalCounts);
		view.addObject("totalPage", totalPage);
		view.addObject("startPage", startPage);
		view.addObject("endPage", endPage);
		view.addObject("currentPage", currentPage);
		view.addObject("perBlock", perBlock);
		view.addObject("no", no);
		
		
		view.addObject("list", list);
		view.addObject("dto", dto);
		model.addAttribute("member_num", member_num);
		view.setViewName("/member/myinfo");

		return view;

	}
	
	// 나의 정보로 이동
		@GetMapping("/memberpopup")
		public ModelAndView memberpopup(Model model, HttpSession session,
				
				@RequestParam(value = "pcurrentPage", defaultValue = "1") int pcurrentPage
				
				) {

			ModelAndView view = new ModelAndView();

			String loginemail = (String) session.getAttribute("loginemail");

			String member_num = mservice.findEmailMemberNum(loginemail);

			MemberDto dto = mservice.getDataByMemberNum(member_num);

			
			int totalCounts = pservice.getMyLikePopupCount(member_num);
			int rtotalCounts = rservice.writeReviewCount(member_num);
			int totalCount = eservice.getMyLikeExhibitionCount(member_num);
			
			
			
			
			
			////////////////////////////////
			int ptotalPage;
			int pstartPage;
			int pendPage;
			int pstart;
			int perPage = 3;
			int perBlock = 5;

			ptotalPage = totalCounts / perPage + (totalCounts % perPage == 0 ? 0 : 1);

			pstartPage = (pcurrentPage - 1) / perBlock * perBlock + 1;
			pendPage = pstartPage + perBlock - 1;

			if (pendPage > ptotalPage)
				pendPage = ptotalPage;

			pstart = (pcurrentPage - 1) * perPage;
			

			
			List<PopupDto> plist = pservice.getMyLikePopupDatas(member_num, pstart, perPage);
			System.out.println("plist:" + plist);
			
			
			
			
			
			int no2 = totalCounts - (pcurrentPage - 1) * perPage;
		
			
			view.addObject("totalCounts", totalCounts);
			view.addObject("totalCount", totalCount);
			view.addObject("rtotalCounts", rtotalCounts);
			view.addObject("ptotalPage", ptotalPage);
			view.addObject("pstartPage", pstartPage);
			view.addObject("pendPage", pendPage);
			view.addObject("pcurrentPage", pcurrentPage);
			
			
			
			
			
			
			
			view.addObject("perBlock", perBlock);
		
			view.addObject("no2", no2);
			
		
			view.addObject("plist", plist);
			
			view.addObject("dto", dto);
			model.addAttribute("member_num", member_num);
			view.setViewName("/member/memberpopup");

			return view;

		}
		
		// 나의 정보로 이동
		@GetMapping("/memberreview")
		public ModelAndView memberreview(Model model, HttpSession session,
				
				@RequestParam(value = "rcurrentPage", defaultValue = "1") int rcurrentPage
				) {

			ModelAndView view = new ModelAndView();

			String loginemail = (String) session.getAttribute("loginemail");

			String member_num = mservice.findEmailMemberNum(loginemail);

			MemberDto dto = mservice.getDataByMemberNum(member_num);

		
			int totalCounts = pservice.getMyLikePopupCount(member_num);
			int rtotalCounts = rservice.writeReviewCount(member_num);
			int totalCount = eservice.getMyLikeExhibitionCount(member_num);
			
			
			
			int rtotalPage;
			int rstartPage;
			int rendPage;
			int rstart;
			int perPage = 3;
			int perBlock = 5;

			rtotalPage = rtotalCounts / perPage + (rtotalCounts % perPage == 0 ? 0 : 1);

			rstartPage = (rcurrentPage - 1) / perBlock * perBlock + 1;
			rendPage = rstartPage + perBlock - 1;

			if (rendPage > rtotalPage)
				rendPage = rtotalPage;

			rstart = (rcurrentPage - 1) * perPage;
			

			
			List<ReviewDto> rlist = rservice.myReviewlist(member_num, rstart, perPage);
			System.out.println("rlist:" + rlist);
			
			
			
			
			int no3 = rtotalCounts - (rcurrentPage - 1) * perPage;
			
			
			view.addObject("rtotalCounts", rtotalCounts);
			
			
		
			
			view.addObject("rtotalPage", rtotalPage);
			view.addObject("rstartPage", rstartPage);
			view.addObject("rendPage", rendPage);
			view.addObject("rcurrentPage", rcurrentPage);
			view.addObject("totalCounts", totalCounts);
			view.addObject("totalCount", totalCount);
			view.addObject("rtotalCounts", rtotalCounts);
			view.addObject("perBlock", perBlock);
			view.addObject("no3", no3);
			view.addObject("rlist", rlist);
			view.addObject("dto", dto);
			model.addAttribute("member_num", member_num);
			view.setViewName("/member/memberreview");

			return view;

		}
	
	

	@GetMapping("/member/memberfindemail")
	public String memberfindemail() {
		return "/member/memberfindemail";
	}

	@GetMapping("/member/findmemberemail")
	@ResponseBody
	public Map<String, Object> findmemberemail(String member_name, String member_hp, String member_birth) {

		int find = mservice.MemberEmailCheck(member_name, member_hp, member_birth);
		System.out.println(member_name);
		System.out.println(member_hp);
		System.out.println(member_birth);
	

		Map<String, Object> map2 = new HashMap<>();
		String email = mservice.FindMemberEmail(member_name);
		System.out.println("email:" + email);

		if (find==1) {
			System.out.println("find:" + find);
			map2.put("find", find);
			System.out.println("email:" + email);
			map2.put("email", email);
		}

		
		
		

		return map2;
	}

	@GetMapping("/member/memberfindpass")
	public String memberfind() {
		return "/member/memberfindpass";
	}

	@GetMapping("/member/findmemberpass")
	@ResponseBody
	public Map<String, Object> memberfindproccess(String member_name, String member_email, String member_hp) {

		int findpass = mservice.MemberPassCheck(member_name, member_email, member_hp);
		System.out.println(member_name);
		System.out.println(member_email);
		System.out.println(member_hp);
		System.out.println(findpass);

		String pass = mservice.FindMemberPass(member_name);
		String temporary_pass = "";

		Map<String, Object> map2 = new HashMap<>();

		System.out.println("pass:" + pass);
		String mpass = "";

		for (int i = 0; i < pass.length(); i++) {
			if (i < pass.length() - 6) {
				mpass += "*";
			} else {
				mpass += pass.charAt(i);
			}
		}
		System.out.println("mpass:" + mpass);
		map2.put("mpass", mpass);

		map2.put("findpass", findpass);
		map2.put("pass", pass);

		if (findpass != 0) {
			UUID uid = UUID.randomUUID();

			temporary_pass = uid.toString().substring(0, 8);

			System.out.println("temporary_pass" + temporary_pass);
		}
		return map2;
	}

	// 삭제
	@GetMapping("/member/memberdelete")
	@ResponseBody
	public void deleteMember(@RequestParam String member_num, HttpSession session) {
		session.invalidate();
		mservice.deleteMember(member_num);
	}

	@GetMapping("/member/myprofile")
	public String myprofile(Model model, HttpSession session) {
		String loginemail = (String) session.getAttribute("loginemail");

		String member_num = mservice.findEmailMemberNum(loginemail);
		MemberDto dto = mservice.getDataByMemberNum(member_num);

		model.addAttribute("dto", dto);
		model.addAttribute("member_num", member_num);

		return "/member/myprofile";
	}

	@PostMapping("/member/updateprofile")
	public String updateprofile(MemberDto dto, MultipartFile upload, HttpSession session) {

		String path = session.getServletContext().getRealPath("/photo");
		String fileName = UUID.randomUUID().toString() + "_" + upload.getOriginalFilename();

		if (upload.isEmpty()) {
			dto.setMember_photo(null);

		} else {
			dto.setMember_photo(fileName);

			try {
				upload.transferTo(new File(path + "\\" + fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		mservice.MemberProfileUpdate(dto);
		return "redirect:/myinfo";
	}
	
	/*
	 * // 임시 비밀번호 발급
	 * 
	 * @GetMapping("/member/passSearchMailSender")
	 * 
	 * @ResponseBody public int passSearchMailSender(@RequestParam String email) {
	 * System.out.println(email);
	 * 
	 * int checkEmail = mservice.isUserEmail(email); System.out.println(checkEmail);
	 * if (checkEmail == 1) { MailApi.mailSend(email); String randompass =
	 * MailApi.getRandompass(); System.out.println(randompass);
	 * mservice.updateTemporarilyPass(randompass, email); } return checkEmail; }
	 */

}
