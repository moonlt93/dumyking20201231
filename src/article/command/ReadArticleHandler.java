package article.command;

import java.util.List;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleContentNotFoundException;
import article.service.ArticleData;
import article.service.ArticleNotFoundException;
import article.service.ReadArticleService;
import mvc.command.CommandHandler;
import reply.model.Reply;
import reply.service.ReplyService;

public class ReadArticleHandler implements CommandHandler {
	private ReadArticleService readService = new ReadArticleService();//readarticle객체 생성
	private ReplyService replyService = new ReplyService(); // replyservice 객체 생성.

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String noVal = req.getParameter("no"); // request객체에 저장된 변수를.getParameter로 return 받음.그때 무조건 String.
		int articleNum = Integer.parseInt(noVal);// noVal을 정수로 형변환
		
		try {
			ArticleData articleData = readService.getArticle(articleNum, true);
		//	articleData 객체를 생성. =>readService.getArticle  
			List<Reply> replyList = replyService.getReplyList(articleNum);
			
			req.setAttribute("articleData", articleData);
			
			req.setAttribute("replyList", replyList);
			
			return "readArticle";
			
		} catch (ArticleNotFoundException | ArticleContentNotFoundException e) {
			//req.getServletContext().log("no article", e);
			System.out.println("게시물이 없습니다.");
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}

}
