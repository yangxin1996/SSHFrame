package cn.ncu.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.ncu.entity.User;
import cn.ncu.service.UserService;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;
	
	private User user = new User();
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	public String login() throws Exception {	
		System.out.println("login ============ " );
		//调用service方法，进行用户匹配	
		System.out.println(user);
		User temp = userService.Login(user);
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(null != temp){//登录成功
			//放入session
			session.setAttribute("user", temp);
			//页面跳转（frame.jsp）
			System.out.println(temp);
			return SUCCESS;
		}else{
			//页面跳转（login.jsp）带出提示信息--转发
			session.setAttribute("error", "用户名或密码不正确");
			return INPUT;
		}
	}	
	
}
