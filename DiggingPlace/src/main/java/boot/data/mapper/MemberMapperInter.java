package boot.data.mapper;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import boot.data.dto.MemberDto;

@Mapper
public interface MemberMapperInter {
	
	public List<MemberDto> getAllMember();
	public void insertMember(MemberDto dto);
	public int getSearchEmail(String member_email);
	public int getSearchNinkname(String member_nickname);
	public int getUpdateNinkname(Map<String, String> map);
	public String getMemberName(String member_email);
	public int LoginEmailPassCheck(Map<String, String>  map);
	public MemberDto getDataByEmail(String member_email);
	public void deleteMember(String member_num);
	public void MemberProfileUpdate(MemberDto dto);
	public MemberDto getDataByMemberNum(String member_num);
	public String findEmailMemberNum(String member_email);
	public void kakaoinsert(Map<String, String> loginok);
	public MemberDto findkakao(Map<String, String> loginok);
	public int MemberEmailCheck(Map<String, String> map);
	public String FindMemberEmail(String member_name);
	public int MemberPassCheck(Map<String, String> map);
	public String FindMemberPass(String member_name);
	public List<MemberDto> getMemberReview(String exhibition_num);
	public List<MemberDto> getMemberPopupsReview(String popup_num);
	public List<MemberDto> getMemberReviewList(Map<String, Object> map);
	public List<MemberDto> getMemberPopupReviewList(Map<String, Object> map);
	public int memberEmail(String meber_email);
	public void updateTemporarilyPass(Map<String,String> map);



	
}
