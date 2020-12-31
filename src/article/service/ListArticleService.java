package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import article.dao.ArticleDao;
import article.model.Article;
import jdbc.ConnectionProvider;

public class ListArticleService {
	private ArticleDao articleDao = new ArticleDao();
	private int size = 10;
	
	public ArticlePage getArticlePage(int pageNum) {
		try (Connection conn = ConnectionProvider.getConnection()) 
		{
			int total = articleDao.selectCount(conn);
			// total cnt 총 횟수.
			List<Article> content = articleDao.select(conn, pageNum, size);
			// content select에서 conn, pageNum size
			return new ArticlePage(total, pageNum, size, content);
			// 목록에 새로운 페이지 생성
		} catch (SQLException e) {
			e.printStackTrace();
			
			throw new RuntimeException(e);
		}
	}
}
