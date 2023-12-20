package boot.data.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.data.dto.ExhibitionLikeDto;
import boot.data.dto.PopupLikeDto;
import boot.data.mapper.ExhibitionLikeMapperInter;
import boot.data.mapper.PopupLikeMapperInter;

@Service
public class PopupLikeService implements PopupLikeServiceInter {

	@Autowired
	PopupLikeMapperInter mapper;

	@Override
	public void insertPopupLike(PopupLikeDto popupLikeDto) {
		// TODO Auto-generated method stub
		mapper.insertPopupLike(popupLikeDto);
	}

	@Override
	public void deletePopupLike(String popup_num, String member_num) { // TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("popup_num", popup_num);
		map.put("member_num", member_num);
		mapper.deletePopupLike(map);
	}

	@Override
	public int PopupLikeCount(String popup_num) {
		// TODO Auto-generated method stub
		return mapper.PopupLikeCount(popup_num);
	}

	@Override
	public int PopupLikeCheck(String popup_num, String member_num) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("popup_num", popup_num);
		map.put("member_num", member_num);

		return mapper.PopupLikeCheck(map);
	}

	@Override
	public List<Map<String, Object>> findMemberPopupNum(String member_num) {
		// TODO Auto-generated method stub
		return mapper.findMemberPopupNum(member_num);
	}

}
