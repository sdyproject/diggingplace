package boot.data.service;

import java.util.List;
import java.util.Map;

import boot.data.dto.ExhibitionDto;
import boot.data.dto.ReviewDto;



public interface ExhibitionServiceInter {

	
	public int getTotalCount();
	
	public List<ExhibitionDto> getExhibitonNum(int exhibition_num);
	public List<ExhibitionDto> getAllData(int start, int perpage);
	public ExhibitionDto getExhibitionData(String exhibition_num);
	public List<ExhibitionDto> getLocationData(String location,int start, int perpage);
	public List<ExhibitionDto>getMyLikeExhibitionDatas(String member_num,int start, int perpage);
	public int getMyLikeExhibitionCount(String member_num);
	public int getLikeSortCount();
	public int getLocationSortCount(String location);
	public List<ExhibitionDto> getPriceFree(int start, int perpage);
	public List<ExhibitionDto> getPriceExpensive(int start, int perpage);
	public List<ExhibitionDto> getLikeSort(int start, int perpage);
	public List<ExhibitionDto> getReviewSort(int start, int perpage);
	
}
