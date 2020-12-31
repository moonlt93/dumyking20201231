package auth.command;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;

public class LogoutHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession session = req.getSession(false);
		//session객체에 담긴것만 return
		if (session != null) {
			//session이 null이 아니라면
			session.invalidate();
			//session객체무효화 
		}

		res.sendRedirect(req.getContextPath() + "/index.jsp");
		//rediect +index.jsp
		return null;
	}
}
