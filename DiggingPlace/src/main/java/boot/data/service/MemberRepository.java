package boot.data.service;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import boot.data.dto.MemberDto;

@Repository
public class MemberRepository {

	@Autowired
	private SqlSessionTemplate sql;
	
	public void kakaoinsert(HashMap<String, Object> MemberInfo) {
		sql.insert("boot.data.mapper.MemberMapperInter.kakaoInsert", MemberInfo);
	}
	
	public MemberDto findkakao(HashMap<String, Object> MemberInfo) {
		System.out.println("RN:"+MemberInfo.get("nickname"));
		System.out.println("RE:"+MemberInfo.get("email"));
		return sql.selectOne("boot.data.mapper.MemberMapperInter.findKakao", MemberInfo);
	}
}
