package service;//com.demo.service才是正道……

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comm.PassUtli;
import repository.IUserDao;
import repository.UserInfoMapper;
import repository.entity.LoginUserDto;
import repository.entity.UserInfoMapperDto;

/**
 * @author i7403
 *
 */
@Service
public class UserService {

	@Autowired
	UserInfoMapper mapper;

	/**
	 * 注入dao层
	 *
	 */
	@Autowired
	IUserDao getmapper;

	public List<UserInfoMapperDto> show(String id, String pass) throws Exception {

		List<UserInfoMapperDto> retMap = mapper.getUserMap(id);
		System.out.println(retMap.size());
		return retMap;

	}

	/**
	 * @param id
	 * @param pass
	 * @return 
	 * @throws Exception
	 */
	public boolean checkUserPass(String id, String pass) throws Exception {
		String shaPass = PassUtli.pwdCr(id, pass);
	
		List<LoginUserDto> retMap = getmapper.checkUser(id, shaPass);
		
		if (retMap.size() < 1) {

			return false;
		} else {
		for(int i=0;i<retMap.size();i++) {
			
			String kumi=retMap.get(i).kumiawase();
			System.out.println("dai"+i+"kai--------"+kumi);
		}
			
			return true;
		}

	}

}