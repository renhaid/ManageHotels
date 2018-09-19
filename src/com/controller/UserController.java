package com.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pojo.AdminUser;
import com.pojo.PageView;
import com.service.UserService;
import com.utils.MD5;

@Controller
public class UserController {
	@Autowired
	private UserService userservice;
	
	/**
	 * 
	 * @param ��¼
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("loginServlet.do")
	public String login (String username,String password,HttpServletRequest request,HttpServletResponse reponse) throws Exception{
		//����
		MD5  md=new MD5();
		String pwd=md.getMD5String(password);
		AdminUser user=userservice.login(username, pwd);
		
		if (user!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			Date date=new Date();
			SimpleDateFormat spdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String time=spdf.format(date);
			userservice.updateTime(user.getId(),time);
			return "index.jsp";
		}else {
			return "register.jsp";
		}
		
	}
	
	/**
	 * 
	 * @param ע��
	 * @return
	 */
	@RequestMapping("registerServlet.do")
	public String register(AdminUser user){
		Date date=new Date();
		SimpleDateFormat spf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String regster_time=spf.format(date);
		//����
		MD5 md=new MD5();
		String pwd=md.getMD5String(user.getPassword());
		user.setPassword(pwd);
		
		user.setRegister_time(regster_time);
		AdminUser us=userservice.query(user);
		if(us!=null){
			return "error.jsp";
		}else {
			userservice.insert(user);
			return "login.jsp";
		}	
	}
	
	/**
	 * 
	 * @param �޸�
	 * @return
	 */
	@RequestMapping("editorServlet.do")
	public @ResponseBody PageView editor(AdminUser user){
		//��ѯ�����Ƿ���ҪMD5����
		AdminUser us=userservice.find(user.getId());
		if(user.getPassword().equals(us.getPassword())){
			//Date��ʽת��Ϊ�ַ�����ʽ
			Date date=new Date();
			SimpleDateFormat spdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String editor_time=spdf.format(date);
			user.setEditor_time(editor_time);
			userservice.editor(user);
			PageView p=new PageView();
			p.setMessage("�޸ĳɹ�,�����µ�¼��");
			return p;
		}else{
			//����
			MD5 md=new MD5();
			String pwd=md.getMD5String(user.getPassword());
			user.setPassword(pwd);
			//Date��ʽת��Ϊ�ַ�����ʽ
			Date date=new Date();
			SimpleDateFormat spdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String editor_time=spdf.format(date);
			user.setEditor_time(editor_time);
			userservice.editor(user);
			PageView p=new PageView();
			p.setMessage("�޸ĳɹ�,�����µ�¼��");
			return p;		
		}
		
	}
	
	
}
