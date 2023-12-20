package boot.data.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.data.dto.ExhibitionDto;
import boot.data.mapper.ExhibitionMapperInter;

@Service
public class ExhibitionService implements ExhibitionServiceInter {

	@Autowired
	ExhibitionMapperInter inter;
	

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return inter.getTotalCount();
	}

	@Override
	public List<ExhibitionDto> getAllData(int start, int perpage) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("perpage", perpage);
		return inter.getAllData(map);
	}

	@Override
	public ExhibitionDto getExhibitionData(String exhibition_num) {
		// TODO Auto-generated method stub
		return inter.getExhibitionData(exhibition_num);
	}

	@Override
	public List<ExhibitionDto> getLocationData(String location, int start, int perpage) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("location", location);
		map.put("start", start);
		map.put("perpage", perpage);

		return inter.getLocationData(map);
	}

	@Override
	public List<ExhibitionDto> getMyLikeExhibitionDatas(String member_num, int start, int perpage) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("member_num", member_num);
		map.put("start", start);
		map.put("perpage", perpage);

		return inter.getMyLikeExhibitionDatas(map);
	}

	@Override
	public int getMyLikeExhibitionCount(String member_num) {
		// TODO Auto-generated method stub
		return inter.getMyLikeExhibitionCount(member_num);
	}
	
	@Override
	public int getLikeSortCount() {
		// TODO Auto-generated method stub
		return inter.getLikeSortCount();
	}

	@Override
	public int getLocationSortCount(String location) {
		// TODO Auto-generated method stub
		return inter.getLocationSortCount(location);
	}

	@Override
	public List<ExhibitionDto> getLikeSort(int start, int perpage) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("start", start);
		map.put("perpage", perpage);
		return inter.getLikeSort(map);
	}

	@Override
	public List<ExhibitionDto> getPriceFree(int start, int perpage) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("start", start);
		map.put("perpage", perpage);
		return inter.getPriceFree(map);
	}

	@Override
	public List<ExhibitionDto> getPriceExpensive(int start, int perpage) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("start", start);
		map.put("perpage", perpage);
		return inter.getPriceExpensive(map);
	}

	@Override
	public List<ExhibitionDto> getExhibitonNum(int exhibition_num) {
		// TODO Auto-generated method stub
		return inter.getExhibitonNum(exhibition_num);
	}

	@Override
	public List<ExhibitionDto> getReviewSort(int start, int perpage) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("start", start);
		map.put("perpage", perpage);
		return inter.getReviewSort(map);
	}

	



	

	

}
