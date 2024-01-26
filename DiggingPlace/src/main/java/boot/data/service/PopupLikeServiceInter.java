package boot.data.service;








import java.util.List;
import java.util.Map;

import boot.data.dto.PopupLikeDto;

public interface PopupLikeServiceInter {

	
	
	  public void insertPopupLike(PopupLikeDto popupLikeDto); 
	  public void deletePopupLike(String popup_num, String member_num); 
	  public int PopupLikeCheck(String popup_num, String member_num);
	  public int PopupLikeCount(String popup_num);
	  
	  public List<Map<String, Object>> findMemberPopupNum(String member_num);
	  
	 
	
	
	
	
	

}
