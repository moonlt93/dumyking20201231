package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import member.service.ChangePasswordService;
import member.service.InvalidPasswordException;
import member.service.MemberNotFoundException;
import mvc.command.CommandHandler;

public class ChangePasswordHandler implements CommandHandler {
	private static final String FORM_VIEW = "changePwdForm";
	private ChangePasswordService changePwdSvc = new ChangePasswordService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("get")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			return processSubmit(req, res);
		} else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		User user = (User) req.getSession().getAttribute("authUser");
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		String curPwd = req.getParameter("curPwd");//현재 비밀번호
		String newPwd = req.getParameter("newPwd");// 새로운 비밀번호.
		
		if (curPwd == null || curPwd.isEmpty()) 
		//현재 비밀번호가 null이거나 ""값일때
		{
			errors.put("curPwd", true);
			//errors객체에 curPwd라는 이름으로 넣어줌.
		}
		
		if (newPwd == null || newPwd.isEmpty()) 
		//새로운 password가 null이거나 길이가 0일때
		{
			errors.put("newPwd", true);
			//errors객체에 newPwd라는 이름으로 저장.
		}
		if (!errors.isEmpty()) 
		//에러가 났을때
		{
			return FORM_VIEW;
			//비밀번호 form을 유지.
		}
		
		//changePwdSvc.
		try {
			changePwdSvc.changePassword(user.getId(), curPwd, newPwd);
			//비밀번호바꾸기 service는(id,현재비밀번호,새로운비밀번호)
			return "changePwdSuccess";
			//비밀번호 바꾸기에 성공
		} catch (InvalidPasswordException e) {
			errors.put("badCurPwd", true);
			return FORM_VIEW;
		} catch (MemberNotFoundException e) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		
	}
	
	
}
