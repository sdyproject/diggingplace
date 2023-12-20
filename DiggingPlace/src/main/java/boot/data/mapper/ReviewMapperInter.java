package boot.data.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import boot.data.dto.ReviewDto;

@Mapper
public interface ReviewMapperInter {

	public void insertReview(ReviewDto reviewDto);
	public void insertPopupReview(ReviewDto reviewDto);
	
	public List<ReviewDto> reviewlist(String exhibition_num);
	public List<ReviewDto> PopupReviewReviewlist(String popup_num);
	public Integer scoreSum(String exhibition_num);
	public Integer PopupReviewScoreSum(String popup_num);
	public int reviewCount(String exhibition_num);
	public int PopupReviewCount(String popup_num);
	public void deleteReview(String review_num);
	public List<ReviewDto> myReviewlist(Map<String, Object> map);
	public int writeReviewCount(String memeber_num);
	public int getReviewCount();
	public int getPopupReviewCount();
	public void updateReview(ReviewDto reviewDto);
	public ReviewDto getDataByReviewNum(String review_num);
	public int getSearchReview(Map<String, String> map);
	public int getSearchPopupReview(Map<String, String> map);
	
}
