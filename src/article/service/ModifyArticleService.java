package article.service;

import java.sql.Connection;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class ModifyArticleService {
	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();
	
	public void modify(ModifyRequest modReq) {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			//드라이버 커넥션 설정. 
			
			Article article = articleDao.selectById(conn, modReq.getArticleNumber());
			//id number에 해당하는 
			if (article == null) {
				throw new ArticleNotFoundException();
			}
			
			if (!canModify(modReq.getUserId(), article)) {
				throw new PermissionDeniedException();
			}
			
			articleDao.update(conn, modReq.getArticleNumber(), modReq.getTitle());
			contentDao.update(conn, modReq.getArticleNumber(), modReq.getContent());
			conn.commit();
		} catch (Exception e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	private boolean canModify(String modifyingUserId, Article article) {
		return article.getWriter().getId().equals(modifyingUserId);
	}
}
