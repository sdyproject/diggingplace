package boot.data.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.data.dto.ReviewDto;
import boot.data.mapper.ReviewMapperInter;

@Service
public class ReviewService implements ReviewServiceInter{

	@Autowired
	ReviewMapperInter mapper;

	@Override
	public void insertReview(ReviewDto reviewDto) {
		// TODO Auto-generated method stub
	mapper.insertReview(reviewDto);
	}
	
	@Override
	public void insertPopupReview(ReviewDto reviewDto) {
		// TODO Auto-generated method stub
		mapper.insertPopupReview(reviewDto);
	}

	@Override
	public List<ReviewDto> reviewlist(String exhibition_num) {
		// TODO Auto-generated method stub
		return mapper.reviewlist(exhibition_num);
	}

	@Override
	public Integer scoreSum(String exhibition_num) {
		// TODO Auto-generated method stub
		return mapper.scoreSum(exhibition_num);
	}

	@Override
	public int reviewCount(String exhibition_num) {
		// TODO Auto-generated method stub
		return mapper.reviewCount(exhibition_num);
	}

	@Override
	public void deleteReview(String review_num) {
		// TODO Auto-generated method stub
		
		mapper.deleteReview(review_num);
		
	}

	@Override
	public List<ReviewDto> myReviewlist(String member_num, int start, int perpage) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("perpage", perpage);
		map.put("member_num", member_num);
		return mapper.myReviewlist(map);
	}

	@Override
	public int writeReviewCount(String memeber_num) {
		// TODO Auto-generated method stub
		return mapper.writeReviewCount(memeber_num);
	}

	@Override
	public int getReviewCount() {
		// TODO Auto-generated method stub
		return mapper.getReviewCount();
	}

	@Override
	public List<ReviewDto> PopupReviewReviewlist(String popup_num) {
		// TODO Auto-generated method stub
		return mapper.PopupReviewReviewlist(popup_num);
	}

	@Override
	public Integer PopupReviewScoreSum(String popup_num) {
		// TODO Auto-generated method stub
		return mapper.PopupReviewScoreSum(popup_num);
	}

	@Override
	public int PopupReviewCount(String popup_num) {
		// TODO Auto-generated method stub
		return mapper.PopupReviewCount(popup_num);
	}

	@Override
	public int getPopupReviewCount() {
		// TODO Auto-generated method stub
		return mapper.getPopupReviewCount();
	}

	@Override
	public void updateReview(ReviewDto reviewDto) {
		// TODO Auto-generated method stub
		mapper.updateReview(reviewDto);
		
	}

	@Override
	public ReviewDto getDataByReviewNum(String review_num) {
		// TODO Auto-generated method stub
		return mapper.getDataByReviewNum(review_num);
	}

	@Override
	public int getSearchReview(String exhibition_num, String member_num) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("exhibition_num", exhibition_num);
		map.put("member_num", member_num);
		return mapper.getSearchReview(map);
	}

	@Override
	public int getSearchPopupReview(String popup_num, String member_num) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("popup_num", popup_num);
		map.put("member_num", member_num);
		return mapper.getSearchPopupReview(map);
	}

	
	
	
}
