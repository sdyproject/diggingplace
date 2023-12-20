package boot.data.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("PopupDto")
public class PopupDto {
	private String popup_num ; 
	private String popup_subject  ; 
	private String popup_location  ; 
	private String popup_content  ; 
	private String popup_term  ; 
	private String popup_image ; 
	private String popup_link;
	private String popup_latitude;
	private String popup_longitude;
	private String popup_detaillocation; 
	
}
