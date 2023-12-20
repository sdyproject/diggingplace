package boot.data.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.data.dto.ExhibitionLikeDto;
import boot.data.mapper.ExhibitionLikeMapperInter;

@Service
public class ExhibitionLikeService implements ExhibitionLikeServiceInter {

	@Autowired
	ExhibitionLikeMapperInter mapper;

	@Override
	public void insertExhibitionLike(ExhibitionLikeDto boardLikeDto) {
		// TODO Auto-generated method stub
		mapper.insertExhibitionLike(boardLikeDto);
	}

	@Override
	public void deleteExhibitionLike(String exhibition_num, String member_num) { // TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("exhibition_num", exhibition_num);
		map.put("member_num", member_num);
		mapper.deleteExhibitionLike(map);
	}

	/*
	 * @Override public int exhibitionLikeCheck(String exhibition_num, String
	 * member_num) { // TODO Auto-generated method stub Map<String, String> map =
	 * new HashMap<>(); map.put("exhibition_num", exhibition_num);
	 * map.put("member_num", member_num);
	 * 
	 * return mapper.exhibitionLikeCheck(map);
	 * 
	 * }
	 */

	@Override
	public int exhibitionLikeCount(String exhibition_num) {
		// TODO Auto-generated method stub
		return mapper.exhibitionLikeCount(exhibition_num);
	}

	@Override
	public int exhibitionLikeCheck(String exhibition_num, String member_num) {
		// TODO Auto-generated method stub
		Map<String, String> map =
				  new HashMap<>(); map.put("exhibition_num", exhibition_num);
				  map.put("member_num", member_num);
				  
				  
				  
				  return mapper.exhibitionLikeCheck(map);
	}

	@Override
	public List<Map<String, Object>> findMemberExhibitionNum(String member_num) {
		// TODO Auto-generated method stub
		return mapper.findMemberExhibitionNum(member_num);
	}

	
	

	
	
	
	
	

	

	

}
