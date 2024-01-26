package boot.data.service;

import java.util.List;


import boot.data.dto.ReviewDto;

public interface ReviewServiceInter {
	public void insertReview(ReviewDto reviewDto);
	public void insertPopupReview(ReviewDto reviewDto);
	public List<ReviewDto> reviewlist(String exhibition_num);
	public List<ReviewDto> PopupReviewReviewlist(String popup_num);

	public Integer  scoreSum(String exhibition_num);
	public Integer PopupReviewScoreSum(String popup_num);

	public int reviewCount(String exhibition_num);
	public int PopupReviewCount(String popup_num);

	public void deleteReview(String review_num);
	public List<ReviewDto> myReviewlist(String member_num,int start, int perpage);
	public int writeReviewCount(String memeber_num);
	public int getReviewCount();
	public int getPopupReviewCount();
	public void updateReview(ReviewDto reviewDto);
	public ReviewDto getDataByReviewNum(String review_num);
	public int getSearchReview(String exhibition_num,String member_num);
	public int getSearchPopupReview(String popup_num,String member_num);

}
