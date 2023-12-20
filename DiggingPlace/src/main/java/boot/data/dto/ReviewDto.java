package boot.data.dto;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("ReviewDto")
public class ReviewDto {

	private String review_num;
	private String review_content;
	private Date review_writeday;
	private String  member_num;
	private String exhibition_num;
	private String review_score;
	private String popup_num;
	
}
