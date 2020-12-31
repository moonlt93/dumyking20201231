package article.command;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import article.model.Writer;
import article.service.WriteArticleService;
import article.service.WriteRequest;
import auth.service.User;
import mvc.command.CommandHandler;

public class WriteArticleHandler implements CommandHandler {
    private static final String FORM_VIEW = "newArticleForm";
    private WriteArticleService writeService = new WriteArticleService();
    
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
    	
        Map<String, Boolean> errors = new HashMap<>();
        req.setAttribute("errors", errors);
        
        User user = (User) req.getSession().getAttribute("authUser");
        WriteRequest writeReq = createWriteRequest(user, req);
        writeReq.validate(errors);
        
        if (!errors.isEmpty()) {
            return FORM_VIEW;
        }
     
        
        
        int newArticleNo = writeService.write(writeReq); //새로운 게시글번호 저장 , insert해서 contentdao에 넣는 과정포함됨

        
        req.setAttribute("newArticleNo", newArticleNo); //request 객체에 게시글 번호저장
        
        return "newArticleSuccess";
    }
    


    
    private WriteRequest createWriteRequest(User user, HttpServletRequest req) {
        return new WriteRequest(new Writer(user.getId(),
                user.getName()),
                req.getParameter("title"),
                req.getParameter("content"));
    }
}
