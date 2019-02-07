/**
 * 
 */
package repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import repository.entity.LoginUserDto;

/**
 * @author i7403
 *dao 层
 *
 */
public interface IUserDao {
	
	List<LoginUserDto> checkUser(@Param(value = "user") String userName,
			@Param(value = "pass") String pass);// 形参处出现的@Param是MyBatis提供的注解，@Param("username")中的username在UserMapper.xml文件里會用到
}
