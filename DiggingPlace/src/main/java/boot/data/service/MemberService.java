package boot.data.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boot.data.dto.MemberDto;
import boot.data.mapper.MemberMapperInter;

@Service
public class MemberService implements MemberServiceInter{
	
	@Autowired
	MemberMapperInter mapper;

	@Override
	public List<MemberDto> getAllMember() {
		// TODO Auto-generated method stub
		return mapper.getAllMember();
	}

	@Override
	public void insertMember(MemberDto dto) {
		// TODO Auto-generated method stub
		mapper.insertMember(dto);
	}

	@Override
	public int getSearchEmail(String member_email) {
		// TODO Auto-generated method stub
		return mapper.getSearchEmail(member_email);
	}
	
	@Override
	public int getSearchNinkname(String member_nickname) {
		// TODO Auto-generated method stub
		return mapper.getSearchNinkname(member_nickname);
	}
	
	@Override
	public int getUpdateNinkname(String member_nickname, String member_num) {
		// TODO Auto-generated method stub
		Map<String, String>  map =new HashMap<>();
		map.put("member_nickname", member_nickname);
		map.put("member_num", member_num);
		return mapper.getUpdateNinkname(map);
	}


	@Override
	public String getMemberName(String member_email) {
		// TODO Auto-generated method stub
		return mapper.getMemberName(member_email);
	}

	@Override
	public int LoginEmailPassCheck(String member_email, String member_pass) {
		Map<String, String> map =new HashMap<>();
		map.put("member_email", member_email);
		map.put("member_pass", member_pass);
		return mapper.LoginEmailPassCheck(map);
	}

	@Override
	public MemberDto getDataByEmail(String member_email) {
		// TODO Auto-generated method stub
		return mapper.getDataByEmail(member_email);
	}

	@Override
	public void deleteMember(String member_num) {
		// TODO Auto-generated method stub
		mapper.deleteMember(member_num);
	}

	

	@Override
	public MemberDto getDataByMemberNum(String member_num) {
		// TODO Auto-generated method stub
		return mapper.getDataByMemberNum(member_num);
	}

	@Override
	public String findEmailMemberNum(String member_email) {
		// TODO Auto-generated method stub
		return mapper.findEmailMemberNum(member_email);
	}

	@Override
	public void MemberProfileUpdate(MemberDto dto) {
		// TODO Auto-generated method stub
		mapper.MemberProfileUpdate(dto);
	}

	@Override
	public int MemberEmailCheck(String member_name, String member_hp, String member_birth) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("member_name", member_name);
		map.put("member_hp", member_hp);
		map.put("member_birth", member_birth);
		return mapper.MemberEmailCheck(map);
	}

	@Override
	public String FindMemberEmail(String member_name) {
		// TODO Auto-generated method stub
		return mapper.FindMemberEmail(member_name);
	}

	@Override
	public int MemberPassCheck(String member_name, String member_email, String member_hp) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("member_name", member_name);
		map.put("member_email", member_email);
		map.put("member_hp", member_hp);
		return mapper.MemberPassCheck(map);
	}

	@Override
	public String FindMemberPass(String member_name) {
		// TODO Auto-generated method stub
		return mapper.FindMemberPass(member_name);
	}

	@Override
	public List<MemberDto> getMemberReview(String exhibition_num) {
		// TODO Auto-generated method stub
		return mapper.getMemberReview(exhibition_num);
	}
	
	@Override
	public List<MemberDto> getMemberPopupsReview(String popup_num) {
		// TODO Auto-generated method stub
		return mapper.getMemberPopupsReview(popup_num);
	}
	
	
	@Override
	public List<MemberDto> getMemberReviewList(String exhibition_num, int start, int perpage) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("exhibition_num", exhibition_num);
		map.put("start", start);
		map.put("perpage", perpage);
		return mapper.getMemberReviewList(map);
	}

	@Override
	public List<MemberDto> getMemberPopupReviewList(String popup_num, int start, int perpage) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("popup_num", popup_num);
		map.put("start", start);
		map.put("perpage", perpage);
		return mapper.getMemberPopupReviewList(map);
	}

	
	

	

	

	

	

	
	

	
	

	

}
