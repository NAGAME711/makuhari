package domin;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author i7403
 *bean 层
 *跟网页input name 对齐
 */
public class LoginCommand implements Serializable {
	@NotBlank(message = "{err_NotBlank_message}")
	private String name;
	@NotBlank(message = "{err_NotPass_message}")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}