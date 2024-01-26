package boot.data.mapper;





import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import boot.data.dto.PopupLikeDto;




@Mapper
public interface  PopupLikeMapperInter {

	
	
	  public void insertPopupLike(PopupLikeDto popupLikeDto); 
	  public void deletePopupLike(Map<String, String> map); 
	  public int PopupLikeCheck(Map<String, String> map);
	  public int PopupLikeCount(String popup_num);
	  public List<Map<String, Object>> findMemberPopupNum(String member_num);
	  
	
	
	
	
	
}
