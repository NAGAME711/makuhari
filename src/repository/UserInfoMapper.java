


package repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import repository.entity.UserInfoMapperDto;

/**
 * @author i7403
 * dao 层
 * 
 */
public interface UserInfoMapper {

	List<UserInfoMapperDto> getUserMap(@Param(value = "user") String userName);

}