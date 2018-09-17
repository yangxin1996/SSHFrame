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
		//����service�����������û�ƥ��	
		System.out.println(user);
		User temp = userService.Login(user);
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(null != temp){//��¼�ɹ�
			//����session
			session.setAttribute("user", temp);
			//ҳ����ת��frame.jsp��
			System.out.println(temp);
			return SUCCESS;
		}else{
			//ҳ����ת��login.jsp��������ʾ��Ϣ--ת��
			session.setAttribute("error", "�û��������벻��ȷ");
			return INPUT;
		}
	}	
	
}
