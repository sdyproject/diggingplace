package boot.data.dto;

import java.sql.Date;
import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("MemberDto")
public class MemberDto {

		private String member_num;
		private String member_name;
		private String member_nickname;
		private String member_pass;
		private String member_email;
		private String member_hp;
		private String member_gender;
		private Date member_birth;
		private String member_photo;
		private Timestamp member_joinday;
		private String review_num;
		private String review_content;
		private Date review_writeday;
		private String review_score;
		private String exhibition_num;
		private String popup_num;
}
