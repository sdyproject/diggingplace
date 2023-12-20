package boot.data.dto;



import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("ExhibitionDto")
public class ExhibitionDto {
	private String exhibition_num; 
	private String exhibition_subject; 
	private String exhibition_location ; 
	private String exhibition_content ; 
	private String exhibition_term ; 
	private String exhibition_price;
	private String exhibition_artist;	
	private String exhibition_image ;
	private String exhibition_detaillocation; 
	private String exhibition_link ; 
	private String exhibition_latitude;
	private String exhibition_longitude;
	
}
