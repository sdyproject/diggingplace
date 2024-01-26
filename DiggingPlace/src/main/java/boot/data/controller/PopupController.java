package boot.data.controller;

import java.util.ArrayList;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.MemberDto;
import boot.data.dto.PopupDto;

import boot.data.service.MemberService;
import boot.data.service.PopupLikeService;

import boot.data.service.PopupService;
import boot.data.service.ReviewService;

@Controller
public class PopupController {

	@Autowired
	PopupService pservice;

	@Autowired
	MemberService mservice;

	@Autowired
	PopupLikeService lservice;
	

	
	@Autowired
	ReviewService rservice;

	// 전시회 리스트페이지
	@GetMapping("/popup/popuplist")
	public ModelAndView list(HttpSession session, Model model,
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage) {

		ModelAndView eview = new ModelAndView();
		int listsize = pservice.getTotalCount();

		int totalCount = pservice.getTotalCount();
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

		List<PopupDto> list = pservice.getAllData(start, perPage);
		System.out.println("list:" + list);

		String loginemail = (String) session.getAttribute("loginemail");
		/* System.out.println(loginemail); */
		String member_num = mservice.findEmailMemberNum(loginemail);
		/*
		 * System.out.println(member_num);
		 */
		List<String> elist = new ArrayList<String>();
		List<Integer> llist = new ArrayList<Integer>();
		List<Integer> clist = new ArrayList<Integer>();
		List<Integer> rlist = new ArrayList<Integer>();
		List<Object> rslist = new ArrayList<Object>();
		
		for (int i = 0; i < list.size(); i++) {

			// 리스트에 있는 전시회 num 가져오기
			//

			String popup_num = list.get(i).getPopup_num();

			elist.add(popup_num);

			model.addAttribute("popup_num", popup_num);
			System.out.println("popup_num:" + popup_num);

			int Likes = lservice.PopupLikeCount(popup_num);
			System.out.println("Likes:" + Likes);
			model.addAttribute("Likes", Likes);

			llist.add(Likes);

			System.out.println("elist:" + elist);
			model.addAttribute("elist", elist);
			System.out.println("llist:" + llist);
			model.addAttribute("llist", llist);
			System.out.println("clist:" + clist);
			model.addAttribute("clist", clist);
			System.out.println("rlist:" + rlist);
			model.addAttribute("rlist", rlist);
			System.out.println("rslist:" + rslist);
			model.addAttribute("rslist", rslist);

			int like_check = lservice.PopupLikeCheck(popup_num, member_num);
			System.out.println("like_check:" + like_check);
			clist.add(like_check);
			
			int popupreviewcount= rservice.PopupReviewCount(popup_num);
			 System.out.println("popupreviewcount:" + popupreviewcount);
			 rlist.add(popupreviewcount);
			 
			 Integer totalscore = rservice.PopupReviewScoreSum(popup_num);
			  System.out.println("totalscore:"+totalscore);
			
			  
			  if (totalscore==null) {
				int noreview=0;
				model.addAttribute("noreview", noreview);
				System.out.println("noreview:"+noreview);
				rslist.add(noreview);
				
			}else {
				
				double result  = (double) totalscore/ (double) popupreviewcount;
				  System.out.println("result:"+result);
				double avgscore = Math.round(result* 10) /10.0;
				  System.out.println("result:"+result);
				  model.addAttribute("avgscore", avgscore);
				  rslist.add(result);
				  
			}

			model.addAttribute("like_check", like_check);

		}

		model.addAttribute("member_num", member_num);

		int no = totalCount - (currentPage - 1) * perPage;
		eview.addObject("totalCount", totalCount);
		eview.addObject("totalPage", totalPage);
		eview.addObject("startPage", startPage);
		eview.addObject("endPage", endPage);
		eview.addObject("perBlock", perBlock);
		eview.addObject("currentPage", currentPage);
		eview.addObject("no", no);

		eview.addObject("list", list);
		eview.addObject("listsize", listsize);
		eview.setViewName("/popup/popuplist");

		return eview;

	}

	// 지역별 전시회리스트 정렬
	@GetMapping("/popup/locationsort")
	public ModelAndView checklist(@RequestParam(required = false, value = "location") String location, Model model,
			HttpSession session, @RequestParam(value = "currentPage", defaultValue = "1") int currentPage) {

		System.out.println("location:" + location);
		
		
		String loginemail = (String) session.getAttribute("loginemail");
		/* System.out.println(loginemail); */
		String member_num = mservice.findEmailMemberNum(loginemail);
		/* System.out.println(member_num); */

		ModelAndView model4 = new ModelAndView();
		int listsize = pservice.getLocationSortCount(location);
		System.out.println("listsize:" + listsize);

		int locationtotalCount = pservice.getLocationSortCount(location);
		int totalPage;
		int startPage;
		int endPage;
		int start;
		int perPage = 8;
		int perBlock = 3;

		// 총 페이지 개수
		totalPage = locationtotalCount / perPage + (locationtotalCount % perPage == 0 ? 0 : 1);
		// 각블럭의 시작페이지.. 현재페이지가 3(s:1, e:5) 6(s:6, e:10)
		startPage = (currentPage - 1) / perBlock * perBlock + 1;
		endPage = startPage + perBlock - 1;
		// 총페이지가8 (6~10 ... endpage를 8로 수정해주어야함.)
		if (endPage > totalPage)
			endPage = totalPage;
		// 각페이지에서 불러올 시작번호
		start = (currentPage - 1) * perPage;
		// 각페이지에서 필요한 게시글 가져오기
		List<PopupDto> list = pservice.getLocationData(location, start, perPage);

		List<String> elist = new ArrayList<String>();
		List<Integer> llist = new ArrayList<Integer>();
		List<Integer> clist = new ArrayList<Integer>();
		List<Integer> rlist = new ArrayList<Integer>();
		List<Object> rslist = new ArrayList<Object>();
		
		for (int i = 0; i < list.size(); i++) {

			// 리스트에 있는 전시회 num 가져오기
			// 이렇게만 가져오면 1번만 가져와진다 리스트로 전시회 뽑는거라서

			String popup_num = list.get(i).getPopup_num();

			elist.add(popup_num);

			model.addAttribute("popup_num", popup_num);
			/* System.out.println("exhibition_num:"+exhibition_num); */

			int Likes = lservice.PopupLikeCount(popup_num);
			System.out.println("Likes:" + Likes);
			model.addAttribute("Likes", Likes);

			llist.add(Likes);

			System.out.println("elist:" + elist);
			model.addAttribute("elist", elist);
			System.out.println("llist:" + llist);
			model.addAttribute("llist", llist);
			System.out.println("clist:" + clist);
			model.addAttribute("clist", clist);
			System.out.println("rlist:" + rlist);
			model.addAttribute("rlist", rlist);

			int like_check = lservice.PopupLikeCheck(popup_num, member_num);
			System.out.println("like_check:" + like_check);
			clist.add(like_check);
			
			int popupreviewcount= rservice.PopupReviewCount(popup_num);
			 System.out.println("popupreviewcount:" + popupreviewcount);
			 rlist.add(popupreviewcount);
			 
			 Integer totalscore = rservice.PopupReviewScoreSum(popup_num);
			  System.out.println("totalscore:"+totalscore);
			
			  
			  if (totalscore==null) {
				int noreview=0;
				model.addAttribute("noreview", noreview);
				System.out.println("noreview:"+noreview);
				rslist.add(noreview);
				
			}else {
				
				double result  = (double) totalscore/ (double) popupreviewcount;
				  System.out.println("result:"+result);
				double avgscore = Math.round(result* 10) /10.0;
				  System.out.println("result:"+result);
				  model.addAttribute("avgscore", avgscore);
				  rslist.add(result);
				  
			}

			model.addAttribute("like_check", like_check);

		}

		int no = locationtotalCount - (currentPage - 1) * perPage;
		model4.addObject("locationtotalCount", locationtotalCount);
		model4.addObject("totalPage", totalPage);
		model4.addObject("startPage", startPage);
		model4.addObject("endPage", endPage);
		model4.addObject("perBlock", perBlock);
		model4.addObject("currentPage", currentPage);
		model4.addObject("no", no);
		model4.addObject("list", list);
		model4.addObject("location", location);
		model4.addObject("listsize", listsize);
		model4.setViewName("/popup/popuplist");

		return model4;
	}

	
	// 좋아요순 전시회리스트 정렬
	@GetMapping("/popup/likesort")
	public ModelAndView likesort(HttpSession session, Model model, 
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage) {
		ModelAndView model3 = new ModelAndView();
		
		int listsize = pservice.getTotalCount();
		System.out.println("listsize:" + listsize);

		int likesortCount = pservice.getTotalCount();
		int totalPage;
		int startPage;
		int endPage;
		int start;
		int perPage = 8;
		int perBlock = 3;

	
		totalPage = likesortCount / perPage + (likesortCount % perPage == 0 ? 0 : 1);
		
		startPage = (currentPage - 1) / perBlock * perBlock + 1;
		endPage = startPage + perBlock - 1;
		
		if (endPage > totalPage)
			endPage = totalPage;
		
		start = (currentPage - 1) * perPage;
		
		List<PopupDto> list = pservice.getLikeSort(start, perPage);
		
		
		
		
		
		String loginemail = (String) session.getAttribute("loginemail");
		System.out.println(loginemail);
		String member_num = mservice.findEmailMemberNum(loginemail);
		System.out.println(member_num);

		List<String> elist = new ArrayList<String>();
		List<Integer> llist = new ArrayList<Integer>();
		List<Integer> clist = new ArrayList<Integer>();
		List<Integer> rlist = new ArrayList<Integer>();
		List<Object> rslist = new ArrayList<Object>();
		
		for (int i = 0; i < list.size(); i++) {

			

			String popup_num = list.get(i).getPopup_num();

			elist.add(popup_num);

			model.addAttribute("popup_num", popup_num);
			System.out.println("popup_num:" + popup_num);

			int Likes = lservice.PopupLikeCount(popup_num);
			System.out.println("Likes:" + Likes);
			model.addAttribute("Likes", Likes);

			llist.add(Likes);

			System.out.println("elist:" + elist);
			model.addAttribute("elist", elist);
			System.out.println("llist:" + llist);
			model.addAttribute("llist", llist);
			System.out.println("clist:" + clist);
			model.addAttribute("clist", clist);
			System.out.println("rlist:" + rlist);
			model.addAttribute("rlist", rlist);
			System.out.println("rslist:" + rslist);
			model.addAttribute("rslist", rslist);


			int like_check = lservice.PopupLikeCheck(popup_num, member_num);
			System.out.println("like_check:" + like_check);
			clist.add(like_check);
			
			int popupreviewcount= rservice.PopupReviewCount(popup_num);
			 System.out.println("popupreviewcount:" + popupreviewcount);
			 rlist.add(popupreviewcount);
			 
			 Integer totalscore = rservice.PopupReviewScoreSum(popup_num);
			  System.out.println("totalscore:"+totalscore);
			
			  
			  if (totalscore==null) {
				int noreview=0;
				model.addAttribute("noreview", noreview);
				System.out.println("noreview:"+noreview);
				rslist.add(noreview);
				
			}else {
				
				double result  = (double) totalscore/ (double) popupreviewcount;
				  System.out.println("result:"+result);
				double avgscore = Math.round(result* 10) /10.0;
				  System.out.println("result:"+result);
				  model.addAttribute("avgscore", avgscore);
				  rslist.add(result);
				  
			}

			model.addAttribute("like_check", like_check);

		}
		int no = likesortCount - (currentPage - 1) * perPage;
		model3.addObject("likesortCount", likesortCount);
		model3.addObject("totalPage", totalPage);
		model3.addObject("startPage", startPage);
		model3.addObject("endPage", endPage);
		model3.addObject("perBlock", perBlock);
		model3.addObject("currentPage", currentPage);
		model3.addObject("no", no);
		model3.addObject("listsize", listsize);
		model3.addObject("list", list);
		model3.setViewName("/popup/popuplist");

		return model3;
	}
	
	// 리뷰순 전시회리스트 정렬
			@GetMapping("/popup/popupreviewsort")
			public ModelAndView popupreviewsort(HttpSession session, Model model, 
					@RequestParam(value = "currentPage", defaultValue = "1") int currentPage) {
				ModelAndView model6 = new ModelAndView();
				
				int listsize = rservice.getPopupReviewCount();
				System.out.println("listsize:" + listsize);
										
				int popupreviewsortCount = rservice.getPopupReviewCount();
				int totalPage;
				int startPage;
				int endPage;
				int start;
				int perPage = 8;
				int perBlock = 3;

			
				totalPage = popupreviewsortCount / perPage + (popupreviewsortCount % perPage == 0 ? 0 : 1);
				
				startPage = (currentPage - 1) / perBlock * perBlock + 1;
				endPage = startPage + perBlock - 1;
				
				if (endPage > totalPage)
					endPage = totalPage;
				
				start = (currentPage - 1) * perPage;
				
				List<PopupDto> list =pservice.getPopupReviewSort(start, perPage);
						
				
				
				
				
				
				String loginemail = (String) session.getAttribute("loginemail");
				System.out.println(loginemail);
				String member_num = mservice.findEmailMemberNum(loginemail);
				System.out.println(member_num);

				List<String> elist = new ArrayList<String>();
				List<Integer> llist = new ArrayList<Integer>();
				List<Integer> clist = new ArrayList<Integer>();
				List<Integer> rlist = new ArrayList<Integer>();
				List<Object> rslist = new ArrayList<Object>();
				for (int i = 0; i < list.size(); i++) {

					

					String popup_num = list.get(i).getPopup_num();

					elist.add(popup_num);

					model.addAttribute("popup_num", popup_num);
					System.out.println("popup_num:" + popup_num);

					int Likes = lservice.PopupLikeCount(popup_num);
					System.out.println("Likes:" + Likes);
					model.addAttribute("Likes", Likes);

					llist.add(Likes);
						

					System.out.println("elist:" + elist);
					model.addAttribute("elist", elist);
					System.out.println("llist:" + llist);
					model.addAttribute("llist", llist);
					System.out.println("clist:" + clist);
					model.addAttribute("clist", clist);
					System.out.println("rlist:" + rlist);
					model.addAttribute("rlist", rlist);
					System.out.println("rslist:" + rslist);
					model.addAttribute("rslist", rslist);

					int like_check = lservice.PopupLikeCheck(popup_num, member_num);
					System.out.println("like_check:" + like_check);
					clist.add(like_check);
					
					int popupreviewcount= rservice.PopupReviewCount(popup_num);
					 System.out.println("popupreviewcount:" + popupreviewcount);
					 rlist.add(popupreviewcount);
					 
					 Integer totalscore = rservice.PopupReviewScoreSum(popup_num);
					  System.out.println("totalscore:"+totalscore);
					
					  
					  if (totalscore==null) {
						int noreview=0;
						model.addAttribute("noreview", noreview);
						System.out.println("noreview:"+noreview);
						rslist.add(noreview);
						
					}else {
						
						double result  = (double) totalscore/ (double) popupreviewcount;
						  System.out.println("result:"+result);
						double avgscore = Math.round(result* 10) /10.0;
						  System.out.println("result:"+result);
						  model.addAttribute("avgscore", avgscore);
						  rslist.add(result);
						  
					}

					model.addAttribute("like_check", like_check);

				}
				int no = popupreviewsortCount - (currentPage - 1) * perPage;
				model6.addObject("popupreviewsortCount", popupreviewsortCount);
				model6.addObject("totalPage", totalPage);
				model6.addObject("startPage", startPage);
				model6.addObject("endPage", endPage);
				model6.addObject("perBlock", perBlock);
				model6.addObject("currentPage", currentPage);
				model6.addObject("no", no);
				model6.addObject("listsize", listsize);
				model6.addObject("list", list);
				model6.setViewName("/popup/popuplist");

				return model6;
			}

	// 팝업 상세페이지
	@GetMapping("/popup/popupdetail/{popup_num}")
	public ModelAndView detail(@PathVariable String popup_num, HttpSession session, Model model) {

		ModelAndView prview = new ModelAndView();

		
		String loginemail = (String) session.getAttribute("loginemail");
		System.out.println("loginemail:" + loginemail);

		String member_num = mservice.findEmailMemberNum(loginemail);
		System.out.println("member_num:" + member_num);

		PopupDto edto = pservice.getPopupData(popup_num);
		System.out.println("popup_num:" + popup_num);

		
		
		 List<MemberDto> mlist = mservice.getMemberPopupsReview(popup_num);
		 System.out.println("mlist:"+mlist);
		 int popupreviewcount= rservice.PopupReviewCount(popup_num);
		 System.out.println("popupreviewcount:" + popupreviewcount);
		
		Integer totalscore = rservice.PopupReviewScoreSum(popup_num);
		  System.out.println("totalscore:"+totalscore);
		  
		  
		
		  
		  if (totalscore==null) {
			int noreview=0;
			model.addAttribute("noreview", noreview);
			System.out.println("noreview:"+noreview);
			
		}else {
			
			double result = (double) totalscore/(double) popupreviewcount;
			  System.out.println("result:"+result);
			  double avgscore = Math.round(result* 10) /10.0;
			  
			  model.addAttribute("avgscore", avgscore);
		}
		
		  int like_check = lservice.PopupLikeCheck(popup_num, member_num);
			System.out.println("like_check:" + like_check);

			int Like = lservice.PopupLikeCount(popup_num);
			System.out.println("Like:" + Like);
		
		model.addAttribute("Like", Like);
		model.addAttribute("popupreviewcount", popupreviewcount);
		model.addAttribute("like_check", like_check);
		model.addAttribute("member_num", member_num);
		model.addAttribute("popup_num", popup_num);


		/* edview.addObject("elist", elist); */
		prview.addObject("Edto", edto);
		prview.addObject("mlist", mlist); 
		prview.setViewName("/popup/popupdetail");

		return prview;
	}

	@GetMapping("/popup/mylikedelete")
	@ResponseBody
	public void deleteLike(@RequestParam String popup_num, HttpSession session) {
		String loginemail = (String) session.getAttribute("loginemail");
		String member_num = mservice.findEmailMemberNum(loginemail);

		lservice.deletePopupLike(popup_num, member_num);
	}

}
