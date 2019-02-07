package controller;//这种命名是错误的，别学我

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import comm.Constans;
import domin.LoginCommand;
import repository.entity.UserInfoMapperDto;
import service.UserService;


/**
 * @author i7403
 *
 */

@Controller
public class LoginController {

	/**
	 * 注入
	 */
	@Autowired
	private UserService userService;
	/**
	 * index 処理
	 * @param model
	 * @return　login.jsp
	 */
	@RequestMapping(value = "/index")
	public String loginPage(Model model) {
		model.addAttribute("loginCommand", new LoginCommand());
		return Constans.RETURN_LOGIN;
	}

	/**
	 * @param loginCommand
	 * @param result
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public ModelAndView testValid(@Validated LoginCommand loginCommand, BindingResult result) throws Exception {
		
		if (result.hasErrors()) {

			String msg = result.getFieldError().getDefaultMessage();
			return new ModelAndView(Constans.RETURN_LOGIN, "error", msg);
		} else {
			
			boolean userCks=userService.checkUserPass(loginCommand.getName(), loginCommand.getPassword());
			
			if (!userCks) {
				return new ModelAndView(Constans.RETURN_LOGIN, "error", "ユーザーID、パスワードを確認してください！");
			} else {
				List<UserInfoMapperDto> userlist=userService.show(loginCommand.getName(), loginCommand.getPassword());	
				return new ModelAndView("download", "userlist",  userlist);
				
			}

		}
	}

}