package boot.data.service;

import java.util.List;

import boot.data.dto.PopupDto;

public interface PopupServiceInter {

	public int getTotalCount();

	public List<PopupDto> getPopupNum(int popup_num); 

	public List<PopupDto> getAllData(int start, int perpage);

	public PopupDto getPopupData(String popup_num);

	public List<PopupDto> getLocationData(String location, int start, int perpage);

	public List<PopupDto> getMyLikePopupDatas(String member_num, int start, int perpage);

	public int getMyLikePopupCount(String member_num);

	public int getLikeSortCount();

	public int getLocationSortCount(String location);

	public List<PopupDto> getLikeSort(int start, int perpage);
	
	public List<PopupDto> getPopupReviewSort(int start, int perpage);
}
