package article.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import article.service.ArticleData;
import article.service.DeleteArticleService;
import article.service.PermissionDeniedException;
import article.service.ReadArticleService;
import auth.service.User;
import mvc.command.CommandHandler;

public class DeleteArticleHandler implements CommandHandler {
	private static final String FORM_VIEW = "deleteArticleForm";
	
	private ReadArticleService readService = new ReadArticleService();
	private DeleteArticleService deleteArticleService = new DeleteArticleService();

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

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		// 현재 로그인 한 사용자
		// 삭제하려는 게시물의 작성자
		HttpSession session = req.getSession();
		User authUser = (User) session.getAttribute("authUser");
		//세션객체에서 같은 이름으로 가져와서 저장.
		int no = Integer.parseInt(req.getParameter("no"));
		// 정수 no는 request객체에 저장된 파라미터 no를 형변환 한  값.
		if (authUser.getId().startsWith("extra")) {
			//authUser에서 id를 가져오는데 extra로 시작하는 아이디를 가져온다.
			deleteArticleService.delete(no, authUser);
			//
			
		} else {
			
			String password = req.getParameter("password");
			
			
			
			ArticleData articleData = readService.getArticle(no, false);
			
			// 가 같으면 삭제함
			//    암호가 일치하는 지 확인 해서
			//           일치하면 삭제
			//           아니면 throw exception
			
			// 안 같으면 throw exception
			if (!authUser.getId().equals(articleData.getArticle().getWriter().getId())) {
				res.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
			try {
				deleteArticleService.delete(no, authUser, password);
				
				
			} catch (PermissionDeniedException e) {
				errors.put("invalidePassword", true);
				return FORM_VIEW;
			}	catch (Exception e) {
				throw new RuntimeException(e);
			}
		
		}
		
		return "deleteArticleSuccess";
		
		
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
			return FORM_VIEW;
	}
}





