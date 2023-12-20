package boot.data.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import boot.data.dto.PopupDto;

@Mapper
public interface PopupMapperInter {

	public int getTotalCount();

	/* public List<PopupDto> getPopupNum(); */
	
	public List<PopupDto> getPopupNum(int popup_num); 
	public List<PopupDto> getAllData(Map<String, Object> map);
	public PopupDto getPopupData(String popup_num);
	public List<PopupDto> getLocationData(Map<String, Object> map); 
	public List<PopupDto> getMyLikePopupDatas(Map<String, Object> map);
	public int getMyLikePopupCount(String member_num);
	public int getLikeSortCount();
	public int getLocationSortCount(String location);
	public List<PopupDto> getLikeSort(Map<String, Object> map);
	public List<PopupDto> getPopupReviewSort(Map<String, Object> map);
}
