package article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticlePage;
import article.service.ListArticleService;
import mvc.command.CommandHandler;

public class ListArticleHandler implements CommandHandler {
	
	private ListArticleService listService = new ListArticleService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String pageNoVal = req.getParameter("pageNo");
		//request객체에서 pageNo라는 이름을 가진 파라미터를 pageNoVal에 저장. 
		int pageNo = 1;
		//pageNo는1 ? 페이지 이름을 1부터 시작해주기 위해서
		
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		//pageNo <- pageNoVal 정수로 형변환. 
		}
		
		ArticlePage articlePage = listService.getArticlePage(pageNo);
		// articlePage 객체 
		req.setAttribute("articlePage", articlePage);
		//request에 articlePage이름으로 저장. 
		return "listArticle";
	}
}






