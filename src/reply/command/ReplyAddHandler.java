package reply.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import article.service.ArticleData;
import article.service.ReadArticleService;
import auth.service.User;
import mvc.command.CommandHandler;
import reply.model.Reply;
import reply.service.ReplyAddService;
import reply.service.ReplyService;

public class ReplyAddHandler implements CommandHandler {
	private ReplyAddService addService = new ReplyAddService();
	private ReadArticleService readService = new ReadArticleService();
	private ReplyService replyService = new ReplyService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("authUser");
		
		String pageNo = req.getParameter("pageNo");
		int articleNo = Integer.parseInt(req.getParameter("no"));
		String userId = user.getId();
		String body = req.getParameter("body");
		
		addService.add(userId, articleNo, body);
		ArticleData articleData = readService.getArticle(articleNo, true);
		List<Reply> replyList = replyService.getReplyList(articleNo); 
		req.setAttribute("articleData", articleData);
		req.setAttribute("replyList", replyList);
		
	
		res.sendRedirect(req.getContextPath() + "/article/read.do?no="+articleNo);
		return null;
	
	}

}
