package boot.data.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.ExhibitionDto;
import boot.data.dto.ExhibitionLikeDto;
import boot.data.dto.MemberDto;
import boot.data.dto.PopupDto;
import boot.data.dto.ReviewDto;
import boot.data.service.ExhibitionService;
import boot.data.service.MemberService;
import boot.data.service.PopupService;
import boot.data.service.ReviewService;
import lombok.val;

@Controller
public class ReviewController {

	@Autowired
	MemberService mservice;
	@Autowired
	ReviewService rservice;
	@Autowired
	ExhibitionService eservice;
	@Autowired
	PopupService pservice;

	
	  @PostMapping("/exhibition/reviewinsert") 
	  public String reviewinsert(@ModelAttribute
	  ReviewDto reviewDto,HttpSession session, String exhibition_num,Model model) {
	  
	  String loginemail = (String)
	  session.getAttribute("loginemail"); System.out.println("loginemail:" +
	  loginemail);
	  
	  String member_num = mservice.findEmailMemberNum(loginemail);
	  System.out.println("member_num:" + member_num);
	  
	  model.addAttribute("loginemail", loginemail);
	  model.addAttribute("member_num", member_num);
	  model.addAttribute("exhibition_num", exhibition_num);
	  System.out.println(exhibition_num);
	  
	  rservice.insertReview(reviewDto);
	  return "redirect:/exhibition/exhibitiondetail/"+exhibition_num;
	  
	  }
	  
	  @PostMapping("/popup/popupsreviewinsert") 
	  public String popupreviewinsert(@ModelAttribute
	  ReviewDto reviewDto,HttpSession session, String popup_num,Model model) {
	  
	  String loginemail = (String)
	  session.getAttribute("loginemail"); System.out.println("loginemail:" +
	  loginemail);
	  
	  String member_num = mservice.findEmailMemberNum(loginemail);
	  System.out.println("member_num:" + member_num);
	  
	  model.addAttribute("loginemail", loginemail);
	  model.addAttribute("member_num", member_num);
	  model.addAttribute("popup_num", popup_num);
	  System.out.println(popup_num);
	  
	  rservice.insertPopupReview(reviewDto);
	  return "redirect:/popup/popupdetail/"+popup_num;
	  
	  }
	 

	
	 

	@GetMapping("/exhibition/reviewform")
	public String writereview(HttpSession session, int exhibition_num, Model model) {

		String loginemail = (String) session.getAttribute("loginemail");
		System.out.println("loginemail:" + loginemail);

		String member_num = mservice.findEmailMemberNum(loginemail);
		System.out.println("member_num:" + member_num);

		
		List<ExhibitionDto> dto = eservice.getExhibitonNum(exhibition_num);
		
	

		System.out.println("exhibition_num:" + exhibition_num);

		model.addAttribute("exhibition_num", exhibition_num);
		model.addAttribute("dto", dto);
		model.addAttribute("member_num", member_num);
		return "/review/reviewform";
	}
	

	@GetMapping("/popup/popupreviewform")
	public String popupreviewform(HttpSession session, int popup_num, Model model) {

		String loginemail = (String) session.getAttribute("loginemail");
		System.out.println("loginemail:" + loginemail);

		String member_num = mservice.findEmailMemberNum(loginemail);
		System.out.println("member_num:" + member_num);

		
		List<PopupDto> dto = pservice.getPopupNum(popup_num);
		
		System.out.println("popup_num:" + popup_num);

		model.addAttribute("popup_num", popup_num);
		model.addAttribute("dto", dto);
		model.addAttribute("member_num", member_num);
		return "/review/popupreviewform";
	}
	
	
	

	@GetMapping("/review/reviewlist")
	public ModelAndView reviewlist(HttpSession session, Model model,
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage, String exhibition_num) {
		
		String loginemail = (String) session.getAttribute("loginemail");
		System.out.println("loginemail:" + loginemail);

		String member_num = mservice.findEmailMemberNum(loginemail);
		System.out.println("member_num:" + member_num);

		
		ModelAndView eview = new ModelAndView();
		int listsize = rservice.reviewCount(exhibition_num);

		int totalCount = rservice.reviewCount(exhibition_num);
		System.out.println("totalCount:" + totalCount);
		int totalPage;
		int startPage;
		int endPage;
		int start;
		int perPage = 8;
		int perBlock = 3;

		// 총 페이지 개수
		totalPage = totalCount / perPage + (totalCount % perPage == 0 ? 0 : 1);
		// 각블럭의 시작페이지.. 현재페이지가 3(s:1, e:5) 6(s:6, e:10)
		startPage = (currentPage - 1) / perBlock * perBlock + 1;
		endPage = startPage + perBlock - 1;
		// 총페이지가8 (6~10 ... endpage를 8로 수정해주어야함.)
		if (endPage > totalPage)
			endPage = totalPage;
		// 각페이지에서 불러올 시작번호
		start = (currentPage - 1) * perPage;
		// 각페이지에서 필요한 게시글 가져오기

		List<MemberDto> list = mservice.getMemberReviewList(exhibition_num, start, perPage);
		System.out.println("list:" + list);
		System.out.println("exhibition_num:" + exhibition_num);
		
		Integer totalscore = rservice.scoreSum(exhibition_num);
		  System.out.println("totalscore:"+totalscore);
		
		  
		  if (totalscore==null) {
			int noreview=0;
			model.addAttribute("noreview", noreview);
			System.out.println("noreview:"+noreview);
			
		}else {
			
			double result  = (double) totalscore/ (double) totalCount;
			  
			double avgscore = Math.round(result* 10) /10.0;
			  System.out.println("avgscore:"+avgscore);
			  model.addAttribute("avgscore", avgscore);
		}

		int no = totalCount - (currentPage - 1) * perPage;
		eview.addObject("exhibition_num", exhibition_num);
		eview.addObject("totalCount", list.size());
		eview.addObject("totalPage", totalPage);
		eview.addObject("startPage", startPage);
		eview.addObject("endPage", endPage);
		eview.addObject("perBlock", perBlock);
		eview.addObject("currentPage", currentPage);
		eview.addObject("no", no);
		eview.addObject("listsize", listsize);
		eview.addObject("list", list);
		eview.addObject("member_num", member_num);

		
		eview.setViewName("/review/reviewlist");
		return eview;
	}
	
	@GetMapping("/review/popupreviewlist")
	public ModelAndView popupreviewlist(HttpSession session, Model model,
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage, String popup_num) {
		
		String loginemail = (String) session.getAttribute("loginemail");
		System.out.println("loginemail:" + loginemail);

		String member_num = mservice.findEmailMemberNum(loginemail);
		System.out.println("member_num:" + member_num);
		
		
		ModelAndView eview = new ModelAndView();
		int listsize = rservice.PopupReviewCount(popup_num);

		int totalCount = rservice.PopupReviewCount(popup_num);
		System.out.println("totalCount:" + totalCount);
		int totalPage;
		int startPage;
		int endPage;
		int start;
		int perPage = 8;
		int perBlock = 3;

		// 총 페이지 개수
		totalPage = totalCount / perPage + (totalCount % perPage == 0 ? 0 : 1);
		// 각블럭의 시작페이지.. 현재페이지가 3(s:1, e:5) 6(s:6, e:10)
		startPage = (currentPage - 1) / perBlock * perBlock + 1;
		endPage = startPage + perBlock - 1;
		// 총페이지가8 (6~10 ... endpage를 8로 수정해주어야함.)
		if (endPage > totalPage)
			endPage = totalPage;
		// 각페이지에서 불러올 시작번호
		start = (currentPage - 1) * perPage;
		// 각페이지에서 필요한 게시글 가져오기

		List<MemberDto> plist = mservice.getMemberPopupReviewList(popup_num, start, perPage);
		System.out.println("plist:" + plist);
		System.out.println("popup_num:" + popup_num);
		
		Integer totalscore = rservice.PopupReviewScoreSum(popup_num);
		  System.out.println("totalscore:"+totalscore);
		
		  
		  if (totalscore==null) {
			int noreview=0;
			model.addAttribute("noreview", noreview);
			System.out.println("noreview:"+noreview);
			
		}else {
			
			double result  = (double) totalscore/ (double) totalCount;
			  System.out.println("result:"+result);
			double avgscore = Math.round(result* 10) /10.0;
			  System.out.println("avgscore:"+avgscore);
			  model.addAttribute("avgscore", avgscore);
		}

		int no = totalCount - (currentPage - 1) * perPage;
		eview.addObject("popup_num", popup_num);
		eview.addObject("totalCount", totalCount);
		eview.addObject("totalPage", totalPage);
		eview.addObject("startPage", startPage);
		eview.addObject("endPage", endPage);
		eview.addObject("perBlock", perBlock);
		eview.addObject("currentPage", currentPage);
		eview.addObject("no", no);
		eview.addObject("listsize", listsize);
		eview.addObject("plist", plist);
		eview.addObject("member_num", member_num);
		eview.setViewName("/review/popupreviewlist");
		
		return eview;
	}

	@GetMapping("/review/reviewdelete")
	@ResponseBody
	public void reviewdelete(@RequestParam String review_num ) {
		
		

		rservice.deleteReview(review_num);
	}
	
	//수정폼에 출력할 데이터 반환
		@GetMapping("/review/updateform")
		@ResponseBody
		public ReviewDto getData(String review_num)
		{
			return rservice.getDataByReviewNum(review_num);
		}
		
		//수정
		@PostMapping("/review/update")
		@ResponseBody
		public void update(ReviewDto dto)
		{
			rservice.updateReview(dto);
			
			
		}
		
		@GetMapping("/review/memberreviewcheck")
		@ResponseBody
		public Map<String, Integer> memberreviewcheck(@RequestParam String member_num ,@RequestParam String exhibition_num) {
			Map<String, Integer> map = new HashMap<>();
			int reviewcount = rservice.getSearchReview(exhibition_num, member_num);
			System.out.println("reviewcount:" + reviewcount);
			map.put("reviewcount", reviewcount);

			return map;
		}
		
		@GetMapping("/review/memberpopupreviewcheck")
		@ResponseBody
		public Map<String, Integer> memberpopupreviewcheck(@RequestParam String member_num ,@RequestParam String popup_num) {
			Map<String, Integer> map = new HashMap<>();
			int previewcount = rservice.getSearchPopupReview(popup_num, member_num);
			System.out.println("previewcount:" + previewcount);

			map.put("previewcount", previewcount);

			return map;
		}
		
}
