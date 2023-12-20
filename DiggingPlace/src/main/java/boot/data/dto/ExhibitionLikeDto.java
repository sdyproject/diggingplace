package boot.data.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("ExhibitionLikeDto")
public class ExhibitionLikeDto {
	
	private String exhibition_like_num ; 
	private String exhibition_num ; 
	private String member_num ; 
	private int like_count;
	
	
}
