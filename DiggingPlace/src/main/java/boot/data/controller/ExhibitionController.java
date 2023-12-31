package boot.data.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.ExhibitionDto;
import boot.data.dto.MemberDto;
import boot.data.dto.ReviewDto;
import boot.data.service.ExhibitionLikeService;
import boot.data.service.ExhibitionService;
import boot.data.service.MemberService;
import boot.data.service.ReviewService;
import lombok.extern.java.Log;

@Controller
public class ExhibitionController {

	@Autowired
	ExhibitionService eservice;

	@Autowired
	MemberService mservice;

	@Autowired
	ExhibitionLikeService lservice;
	
	@Autowired
	ReviewService rservice;

	// 전시회 리스트페이지
	@GetMapping("/exhibition/exhibitionlist")
	public ModelAndView list(HttpSession session, Model model,
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage) {

		ModelAndView eview = new ModelAndView();
		int listsize = eservice.getTotalCount();

		int totalCount = eservice.getTotalCount();
		int totalPage;
		int startPage;
		int endPage;
		int start;
		int perPage = 9;
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

		List<ExhibitionDto> list = eservice.getAllData(start, perPage);
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

			String exhibition_num = list.get(i).getExhibition_num();

			elist.add(exhibition_num);

			model.addAttribute("exhibition_num", exhibition_num);
			System.out.println("exhibition_num:" + exhibition_num);

			int Likes = lservice.exhibitionLikeCount(exhibition_num);
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

			int like_check = lservice.exhibitionLikeCheck(exhibition_num, member_num);
			System.out.println("like_check:" + like_check);
			clist.add(like_check);
			model.addAttribute("like_check", like_check);
			
			///
			 int reviewcount= rservice.reviewCount(exhibition_num);
			 System.out.println("reviewcount:" + reviewcount);
			 rlist.add(reviewcount); 
			 
			
			 
			 Integer totalscore = rservice.scoreSum(exhibition_num);
				  System.out.println("totalscore:"+totalscore);
				
				  
				  if (totalscore==null) {
					int noreview=0;
					model.addAttribute("noreview", noreview);
					System.out.println("noreview:"+noreview);
					rslist.add(noreview);
					
				}else {
					
					double result  = (double) totalscore/ (double) reviewcount;
					  System.out.println("result:"+result);
					double avgscore = Math.round(result* 10) /10.0;
					  System.out.println("result:"+result);
					  model.addAttribute("avgscore", avgscore);
					  rslist.add(result);
					  
				}
				 
				 
			 
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
		eview.setViewName("/exhibition/exhibitionlist");

		return eview;

	}

	// 지역별 전시회리스트 정렬
	@GetMapping("/exhibition/locationsort")
	public ModelAndView checklist(@RequestParam(required = false, value = "location") String location, Model model,
			HttpSession session, @RequestParam(value = "currentPage", defaultValue = "1") int currentPage) {

		System.out.println("location:" + location);
		
		
		String loginemail = (String) session.getAttribute("loginemail");
		/* System.out.println(loginemail); */
		String member_num = mservice.findEmailMemberNum(loginemail);
		/* System.out.println(member_num); */

		ModelAndView model4 = new ModelAndView();
		int listsize = eservice.getLocationSortCount(location);
		System.out.println("listsize:" + listsize);

		int locationtotalCount = eservice.getLocationSortCount(location);
		int totalPage;
		int startPage;
		int endPage;
		int start;
		int perPage = 9;
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
		List<ExhibitionDto> list = eservice.getLocationData(location, start, perPage);

		List<String> elist = new ArrayList<String>();
		List<Integer> llist = new ArrayList<Integer>();
		List<Integer> clist = new ArrayList<Integer>();
		List<Integer> rlist = new ArrayList<Integer>();
		List<Object> rslist = new ArrayList<Object>();
		
		for (int i = 0; i < list.size(); i++) {

			// 리스트에 있는 전시회 num 가져오기
			// 이렇게만 가져오면 1번만 가져와진다 리스트로 전시회 뽑는거라서

			String exhibition_num = list.get(i).getExhibition_num();

			elist.add(exhibition_num);

			model.addAttribute("exhibition_num", exhibition_num);
			/* System.out.println("exhibition_num:"+exhibition_num); */

			int Likes = lservice.exhibitionLikeCount(exhibition_num);
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

			int like_check = lservice.exhibitionLikeCheck(exhibition_num, member_num);
			System.out.println("like_check:" + like_check);
			clist.add(like_check);
			
			///
			 int reviewcount= rservice.reviewCount(exhibition_num);
			 System.out.println("reviewcount:" + reviewcount);
			 rlist.add(reviewcount);

			model.addAttribute("like_check", like_check);
			
			 Integer totalscore = rservice.scoreSum(exhibition_num);
			  System.out.println("totalscore:"+totalscore);
			
			  
			  if (totalscore==null) {
				int noreview=0;
				model.addAttribute("noreview", noreview);
				System.out.println("noreview:"+noreview);
				rslist.add(noreview);
				
			}else {
				
				double result  = (double) totalscore/ (double) reviewcount;
				  System.out.println("result:"+result);
				double avgscore = Math.round(result* 10) /10.0;
				  System.out.println("result:"+result);
				  model.addAttribute("avgscore", avgscore);
				  rslist.add(result);
				  
			}

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
		model4.setViewName("/exhibition/exhibitionlist");

		return model4;
	}

	@GetMapping("/exhibition/pricefree")
	public ModelAndView pricefree(HttpSession session, Model model, 
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage) {
		ModelAndView model1 = new ModelAndView();
		
		int listsize = eservice.getTotalCount();
		System.out.println("listsize:" + listsize);

		int pricefreetotalCount = eservice.getTotalCount();
		int totalPage;
		int startPage;
		int endPage;
		int start;
		int perPage = 9;
		int perBlock = 3;

		// 총 페이지 개수
		totalPage = pricefreetotalCount / perPage + (pricefreetotalCount % perPage == 0 ? 0 : 1);
		// 각블럭의 시작페이지.. 현재페이지가 3(s:1, e:5) 6(s:6, e:10)
		startPage = (currentPage - 1) / perBlock * perBlock + 1;
		endPage = startPage + perBlock - 1;
		// 총페이지가8 (6~10 ... endpage를 8로 수정해주어야함.)
		if (endPage > totalPage)
			endPage = totalPage;
		// 각페이지에서 불러올 시작번호
		start = (currentPage - 1) * perPage;
		
		List<ExhibitionDto> list = eservice.getPriceFree(start, perPage);

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

			// 리스트에 있는 전시회 num 가져오기
			// 이렇게만 가져오면 1번만 가져와진다 리스트로 전시회 뽑는거라서

			String exhibition_num = list.get(i).getExhibition_num();

			elist.add(exhibition_num);

			model.addAttribute("exhibition_num", exhibition_num);
			System.out.println("exhibition_num:" + exhibition_num);

			int Likes = lservice.exhibitionLikeCount(exhibition_num);
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

			int like_check = lservice.exhibitionLikeCheck(exhibition_num, member_num);
			System.out.println("like_check:" + like_check);
			clist.add(like_check);
			
			///
			 int reviewcount= rservice.reviewCount(exhibition_num);
			 System.out.println("reviewcount:" + reviewcount);
			 rlist.add(reviewcount);
			 
			 Integer totalscore = rservice.scoreSum(exhibition_num);
			  System.out.println("totalscore:"+totalscore);
			
			  
			  if (totalscore==null) {
				int noreview=0;
				model.addAttribute("noreview", noreview);
				System.out.println("noreview:"+noreview);
				rslist.add(noreview);
				
			}else {
				
				double result  = (double) totalscore/ (double) reviewcount;
				  System.out.println("result:"+result);
				double avgscore = Math.round(result* 10) /10.0;
				  System.out.println("result:"+result);
				  model.addAttribute("avgscore", avgscore);
				  rslist.add(result);
				  
			}

			model.addAttribute("like_check", like_check);

		}
		int no = pricefreetotalCount - (currentPage - 1) * perPage;
		model1.addObject("pricefreetotalCount", pricefreetotalCount);
		model1.addObject("totalPage", totalPage);
		model1.addObject("startPage", startPage);
		model1.addObject("endPage", endPage);
		model1.addObject("perBlock", perBlock);
		model1.addObject("currentPage", currentPage);
		model1.addObject("no", no);
		model1.addObject("listsize", listsize);
		model1.addObject("list", list);
		model1.setViewName("/exhibition/exhibitionlist");

		return model1;
	}

	@GetMapping("/exhibition/priceexpensive")
	public ModelAndView priceexpensive(HttpSession session, Model model, @RequestParam(value = "currentPage", defaultValue = "1") int currentPage) {
		ModelAndView model2 = new ModelAndView();
		int listsize = eservice.getTotalCount();
		System.out.println("listsize:" + listsize);

		int priceexpensivetotalCount = eservice.getTotalCount();
		int totalPage;
		int startPage;
		int endPage;
		int start;
		int perPage = 9;
		int perBlock = 3;

		// 총 페이지 개수
		totalPage = priceexpensivetotalCount / perPage + (priceexpensivetotalCount % perPage == 0 ? 0 : 1);
		// 각블럭의 시작페이지.. 현재페이지가 3(s:1, e:5) 6(s:6, e:10)
		startPage = (currentPage - 1) / perBlock * perBlock + 1;
		endPage = startPage + perBlock - 1;
		// 총페이지가8 (6~10 ... endpage를 8로 수정해주어야함.)
		if (endPage > totalPage)
			endPage = totalPage;
		// 각페이지에서 불러올 시작번호
		start = (currentPage - 1) * perPage;
		
		List<ExhibitionDto> list = eservice.getPriceExpensive(start, perPage);

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

			// 리스트에 있는 전시회 num 가져오기
			// 이렇게만 가져오면 1번만 가져와진다 리스트로 전시회 뽑는거라서

			String exhibition_num = list.get(i).getExhibition_num();

			elist.add(exhibition_num);

			model.addAttribute("exhibition_num", exhibition_num);
			System.out.println("exhibition_num:" + exhibition_num);

			int Likes = lservice.exhibitionLikeCount(exhibition_num);
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

			int like_check = lservice.exhibitionLikeCheck(exhibition_num, member_num);
			System.out.println("like_check:" + like_check);
			clist.add(like_check);
			
			///
			 int reviewcount= rservice.reviewCount(exhibition_num);
			 System.out.println("reviewcount:" + reviewcount);
			 rlist.add(reviewcount);
			 
			 Integer totalscore = rservice.scoreSum(exhibition_num);
			  System.out.println("totalscore:"+totalscore);
			
			  
			  if (totalscore==null) {
				int noreview=0;
				model.addAttribute("noreview", noreview);
				System.out.println("noreview:"+noreview);
				rslist.add(noreview);
				
			}else {
				
				double result  = (double) totalscore/ (double) reviewcount;
				  System.out.println("result:"+result);
				double avgscore = Math.round(result* 10) /10.0;
				  System.out.println("result:"+result);
				  model.addAttribute("avgscore", avgscore);
				  rslist.add(result);
				  
			}

			model.addAttribute("like_check", like_check);

		}
		int no = priceexpensivetotalCount - (currentPage - 1) * perPage;
		model2.addObject("priceexpensivetotalCount", priceexpensivetotalCount);
		model2.addObject("totalPage", totalPage);
		model2.addObject("startPage", startPage);
		model2.addObject("endPage", endPage);
		model2.addObject("perBlock", perBlock);
		model2.addObject("currentPage", currentPage);
		model2.addObject("no", no);
		model2.addObject("listsize", listsize);
		model2.addObject("list", list);
		model2.setViewName("/exhibition/exhibitionlist");

		return model2;
	}

	// 좋아요순 전시회리스트 정렬
	@GetMapping("/exhibition/likesort")
	public ModelAndView likesort(HttpSession session, Model model, 
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage) {
		ModelAndView model3 = new ModelAndView();
		
		int listsize = eservice.getTotalCount();
		System.out.println("listsize:" + listsize);

		int likesortCount = eservice.getTotalCount();
		int totalPage;
		int startPage;
		int endPage;
		int start;
		int perPage = 9;
		int perBlock = 3;

	
		totalPage = likesortCount / perPage + (likesortCount % perPage == 0 ? 0 : 1);
		
		startPage = (currentPage - 1) / perBlock * perBlock + 1;
		endPage = startPage + perBlock - 1;
		
		if (endPage > totalPage)
			endPage = totalPage;
		
		start = (currentPage - 1) * perPage;
		
		List<ExhibitionDto> list = eservice.getLikeSort(start, perPage);
		
		
		
		
		
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

			

			String exhibition_num = list.get(i).getExhibition_num();

			elist.add(exhibition_num);

			model.addAttribute("exhibition_num", exhibition_num);
			System.out.println("exhibition_num:" + exhibition_num);

			int Likes = lservice.exhibitionLikeCount(exhibition_num);
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


			int like_check = lservice.exhibitionLikeCheck(exhibition_num, member_num);
			System.out.println("like_check:" + like_check);
			clist.add(like_check);
			
			///
			 int reviewcount= rservice.reviewCount(exhibition_num);
			 System.out.println("reviewcount:" + reviewcount);
			 rlist.add(reviewcount);
			 
			 Integer totalscore = rservice.scoreSum(exhibition_num);
			  System.out.println("totalscore:"+totalscore);
			
			  
			  if (totalscore==null) {
				int noreview=0;
				model.addAttribute("noreview", noreview);
				System.out.println("noreview:"+noreview);
				rslist.add(noreview);
				
			}else {
				
				double result  = (double) totalscore/ (double) reviewcount;
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
		model3.setViewName("/exhibition/exhibitionlist");

		return model3;
	}
	
	// 리뷰순 전시회리스트 정렬
		@GetMapping("/exhibition/reviewsort")
		public ModelAndView reviewsort(HttpSession session, Model model, 
				@RequestParam(value = "currentPage", defaultValue = "1") int currentPage) {
			ModelAndView model5 = new ModelAndView();
			
			int listsize = rservice.getReviewCount();
			System.out.println("listsize:" + listsize);

			int reviewsortCount = rservice.getReviewCount();
			int totalPage;
			int startPage;
			int endPage;
			int start;
			int perPage = 9;
			int perBlock = 3;

		
			totalPage = reviewsortCount / perPage + (reviewsortCount % perPage == 0 ? 0 : 1);
			
			startPage = (currentPage - 1) / perBlock * perBlock + 1;
			endPage = startPage + perBlock - 1;
			
			if (endPage > totalPage)
				endPage = totalPage;
			
			start = (currentPage - 1) * perPage;
			
			List<ExhibitionDto> list = eservice.getReviewSort(start, perPage);
			
			
			
			
			
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

				

				String exhibition_num = list.get(i).getExhibition_num();

				elist.add(exhibition_num);

				model.addAttribute("exhibition_num", exhibition_num);
				System.out.println("exhibition_num:" + exhibition_num);

				int Likes = lservice.exhibitionLikeCount(exhibition_num);
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

				int like_check = lservice.exhibitionLikeCheck(exhibition_num, member_num);
				System.out.println("like_check:" + like_check);
				clist.add(like_check);
				
				///
				 int reviewcount= rservice.reviewCount(exhibition_num);
				 System.out.println("reviewcount:" + reviewcount);
				 rlist.add(reviewcount);
				 
				 Integer totalscore = rservice.scoreSum(exhibition_num);
				  System.out.println("totalscore:"+totalscore);
				
				  
				  if (totalscore==null) {
					int noreview=0;
					model.addAttribute("noreview", noreview);
					System.out.println("noreview:"+noreview);
					rslist.add(noreview);
					
				}else {
					
					double result  = (double) totalscore/ (double) reviewcount;
					  System.out.println("result:"+result);
					double avgscore = Math.round(result* 10) /10.0;
					  System.out.println("result:"+result);
					  model.addAttribute("avgscore", avgscore);
					  rslist.add(result);
					  
				}

				model.addAttribute("like_check", like_check);

			}
			int no = reviewsortCount - (currentPage - 1) * perPage;
			model5.addObject("reviewsortCount", reviewsortCount);
			model5.addObject("totalPage", totalPage);
			model5.addObject("startPage", startPage);
			model5.addObject("endPage", endPage);
			model5.addObject("perBlock", perBlock);
			model5.addObject("currentPage", currentPage);
			model5.addObject("no", no);
			model5.addObject("listsize", listsize);
			model5.addObject("list", list);
			model5.setViewName("/exhibition/exhibitionlist");

			return model5;
		}

	// 전시회 상세페이지
	@GetMapping("/exhibition/exhibitiondetail/{exhibition_num}")
	public ModelAndView detail(@PathVariable String exhibition_num, HttpSession session, Model model) {
		
		ModelAndView edview = new ModelAndView();
		
		
		String loginemail = (String) session.getAttribute("loginemail");
		/* System.out.println("loginemail:" + loginemail); */

		String member_num = mservice.findEmailMemberNum(loginemail);
		/* System.out.println("member_num:" + member_num); */
		
		

		ExhibitionDto edto = eservice.getExhibitionData(exhibition_num);
		System.out.println("exhibition_num:" + exhibition_num);
		
		
		 List<MemberDto> list = mservice.getMemberReview(exhibition_num);
		 System.out.println("list:"+list);
		 int reviewcount= rservice.reviewCount(exhibition_num);
		 System.out.println("reviewcount:" + reviewcount);
		 
		 Integer totalscore = rservice.scoreSum(exhibition_num);
			  System.out.println("totalscore:"+totalscore);
			
			  
			  if (totalscore==null) {
				int noreview=0;
				model.addAttribute("noreview", noreview);
				System.out.println("noreview:"+noreview);
				
			}else {
				
				double result  = (double) totalscore/ (double) reviewcount;
				  System.out.println("result:"+result);
				double avgscore = Math.round(result* 10) /10.0;
				  System.out.println("avgscore:"+avgscore);
				  model.addAttribute("avgscore", avgscore);
			}
			 
			
			 
			
		
		 
		int like_check = lservice.exhibitionLikeCheck(exhibition_num, member_num);
		System.out.println("like_check:" + like_check);

		int Like = lservice.exhibitionLikeCount(exhibition_num);
		
		System.out.println("Like:" + Like);

		model.addAttribute("Like", Like);
		model.addAttribute("reviewcount", reviewcount);
		model.addAttribute("like_check", like_check);
		model.addAttribute("member_num", member_num);
		model.addAttribute("exhibition_num", exhibition_num);
		
		edview.addObject("list", list); 
		edview.addObject("Edto", edto);

		edview.setViewName("/exhibition/exhibitiondetail");

		return edview;
	}

	@GetMapping("/exhibition/mylikedelete")
	@ResponseBody
	public void deleteLike(@RequestParam String exhibition_num, HttpSession session) {
		String loginemail = (String) session.getAttribute("loginemail");
		String member_num = mservice.findEmailMemberNum(loginemail);

		lservice.deleteExhibitionLike(exhibition_num, member_num);
	}
	
	

}
