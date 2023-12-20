package boot.data.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import boot.data.dto.ExhibitionDto;
import boot.data.dto.ReviewDto;

@Mapper
public interface ExhibitionMapperInter {

	public int getTotalCount();
	public List<ExhibitionDto> getExhibitonNum(int exhibition_num);
	public List<ExhibitionDto> getAllData(Map<String, Object> map);
	public ExhibitionDto getExhibitionData(String exhibition_num);
	public List<ExhibitionDto> getLocationData(Map<String, Object> map); 
	public List<ExhibitionDto> getMyLikeExhibitionDatas(Map<String, Object> map);
	public int getMyLikeExhibitionCount(String member_num);
	public int getLikeSortCount();
	public int getLocationSortCount(String location);
	public List<ExhibitionDto> getPriceFree(Map<String, Object> map);
	public List<ExhibitionDto> getPriceExpensive(Map<String, Object> map);
	public List<ExhibitionDto> getLikeSort(Map<String, Object> map);
	public List<ExhibitionDto> getReviewSort(Map<String, Object> map);

}
