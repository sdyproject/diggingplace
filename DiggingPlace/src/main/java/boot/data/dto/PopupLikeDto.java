package boot.data.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("PopupLikeDto")
public class PopupLikeDto {

	
	private String popup_like_num  ; 
	private String popup_num  ; 
	private String member_num ; 

}
