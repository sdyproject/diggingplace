package boot.data.service;




import java.util.List;


import boot.data.dto.MemberDto;

public interface MemberServiceInter {

	
	public List<MemberDto> getAllMember();
	public void insertMember(MemberDto dto);
	public int getSearchEmail(String member_email);
	public int getSearchNinkname(String member_nickname);
	public int getUpdateNinkname(String member_nickname,String member_num);
	public String getMemberName(String member_email);
	public int LoginEmailPassCheck(String member_email, String member_pass);
	public MemberDto getDataByEmail(String member_email);
	public void deleteMember(String member_num);
	public void MemberProfileUpdate(MemberDto dto);
	public MemberDto getDataByMemberNum(String member_num);
	public String findEmailMemberNum(String member_email);
	public int MemberEmailCheck(String member_name, String member_hp, String member_birth);
	public String FindMemberEmail(String member_name);
	public int MemberPassCheck(String member_name, String member_email, String member_hp);
	public String FindMemberPass(String member_name);
	public List<MemberDto> getMemberReview(String exhibition_num);
	public List<MemberDto> getMemberPopupsReview(String popup_num);
	public List<MemberDto> getMemberReviewList(String exhibition_num,int start, int perpage);
	public List<MemberDto> getMemberPopupReviewList(String popup_num,int start, int perpage);
	public int memberEmail(String meber_email);
	public void updateTemporarilyPass(String member_pass,String member_email);

}
