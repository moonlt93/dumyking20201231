package auth.command;

import java.io.IOException;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import article.service.DeleteArticleService;
import auth.service.LoginFailException;
import auth.service.User;
import mvc.command.CommandHandler;

public class ExtraHandler implements CommandHandler {
	private static final String FORM_VIEW = "loginForm";



	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("Get")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}

	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {

		int num = (int) Math.abs(Math.random() * 1000);
		
		String id = "extra" + "-" + num;
		String name= "extra"+"-"+num;
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		// request객체에 저장된 아이디가 null이거나 없을 때

		if (id == null || id.isEmpty())
		// id가 null이거나 isempty
		{
			errors.put("id", true);
			// "id"값을 넣으면 true로 반환
		}
		
		if (!errors.isEmpty())
		// 에러가 발생했을때
		{
			return FORM_VIEW;
			// 폼_뷰를 반환
		}

		try {
			User user = new User();
			user.setId(id);
			user.setName(name);
			// user객체 loginService.login(id,password)여기부터
			HttpSession session = req.getSession();
			session.setAttribute("authUser", user);
			//
			res.sendRedirect(req.getContextPath() + "/index.jsp");
			return null;

		} catch (LoginFailException e) {
			// id or pwd notMatch 이름으로 errors에 저장.
			errors.put("idOrPwNotMatch", true);

			return FORM_VIEW;
		}

		
		
		
		
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {

		return FORM_VIEW;
	}
}
