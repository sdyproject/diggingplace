package boot.data.mapper;








import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import boot.data.dto.ExhibitionDto;
import boot.data.dto.ExhibitionLikeDto;




@Mapper
public interface  ExhibitionLikeMapperInter {

	
	
	  public void insertExhibitionLike(ExhibitionLikeDto exhibitionLikeDto); 
	  public void deleteExhibitionLike(Map<String, String> map); 
	  public int exhibitionLikeCheck(Map<String, String> map);
	  public int exhibitionLikeCount(String exhibition_num);
	  
	  public ExhibitionLikeDto getExhibitionLikeData(String exhibition_num);
	  
	  
	  public List<Map<String, Object>> findMemberExhibitionNum(String member_num);
	  
	
	
	
	
	
}
