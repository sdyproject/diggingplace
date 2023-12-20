package boot.data.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.data.dto.PopupDto;
import boot.data.mapper.PopupMapperInter;

@Service
public class PopupService implements PopupServiceInter{

	@Autowired 
	PopupMapperInter mapper;

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return mapper.getTotalCount();
	}
	@Override
	public List<PopupDto> getPopupNum(int popup_num) {
		// TODO Auto-generated method stub
		return mapper.getPopupNum(popup_num);
	}
	@Override
	public List<PopupDto> getAllData(int start, int perpage) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("perpage", perpage);
		return mapper.getAllData(map);
	}
	@Override
	public PopupDto getPopupData(String popup_num) {
		// TODO Auto-generated method stub
		return mapper.getPopupData(popup_num);
	}
	@Override
	public List<PopupDto> getLocationData(String location, int start, int perpage) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("location", location);
		map.put("start", start);
		map.put("perpage", perpage);

		return mapper.getLocationData(map);
	}
	@Override
	public List<PopupDto> getMyLikePopupDatas(String member_num, int start, int perpage) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("member_num", member_num);
		map.put("start", start);
		map.put("perpage", perpage);
		return mapper.getMyLikePopupDatas(map);
	}
	@Override
	public int getMyLikePopupCount(String member_num) {
		// TODO Auto-generated method stub
		return mapper.getMyLikePopupCount(member_num);
	}
	@Override
	public int getLikeSortCount() {
		// TODO Auto-generated method stub
		return mapper.getLikeSortCount();
	}
	@Override
	public int getLocationSortCount(String location) {
		// TODO Auto-generated method stub
		return mapper.getLocationSortCount(location);
	}
	@Override
	public List<PopupDto> getLikeSort(int start, int perpage) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("start", start);
		map.put("perpage", perpage);
		return mapper.getLikeSort(map);
	}
	@Override
	public List<PopupDto> getPopupReviewSort(int start, int perpage) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("start", start);
		map.put("perpage", perpage);
		return mapper.getPopupReviewSort(map);
	}

	
}
