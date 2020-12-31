package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.CommandHandler;

public class JoinHandler implements CommandHandler {
	private static final String FORM_VIEW = "joinForm";
	// form_view => 조인 폼.
	private JoinService joinService = new JoinService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET"))
			// 만약 .request객체에서 "get" 문자열과 같은 메소드를 가진다면 
		{
			return processForm(req, res);
			//프로세스폼을 반환
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
		// request객체에서 "post"와 같은 문자열을 리턴하면,
			return processSubmit(req, res);
			// process submit으로 반환.
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
		
	}
	//processform으로 요청 반환.
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW; //join form 
	}

	
	
	//submit으로 요청이 들어옴.
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		
		
		
		//요청1
		JoinRequest joinReq = new JoinRequest(); //join req객체를 만들어서 , id, name, password,confirmpassword로 저장.
		joinReq.setId(req.getParameter("id"));
		joinReq.setName(req.getParameter("name"));
		joinReq.setPassword(req.getParameter("password"));
		joinReq.setConfirmPassword(req.getParameter("confirmPassword"));
		joinReq.setBirth(req.getParameter("birth"));
		joinReq.setGender(req.getParameter("gender")); 
		joinReq.setJob(req.getParameter("job"));
		
		System.out.println(joinReq.getBirth());
		Map<String, Boolean> errors = new HashMap<>(); // errors 객체 생성
		req.setAttribute("errors", errors); //errors라는 이름으로 request에 객체 저장.
		
		joinReq.validate(errors);//validate를 통한 데이터 검증
		
		
		
		if (!errors.isEmpty()) 
		//만약 error가 있다면
		{
			return FORM_VIEW; //joinform
		}
		
		try {
			joinService.join(joinReq);
	
			//joinservice.join메소드 connection객체를 생성해서 member객체에 저장하는 값들을 commit
			return "joinSuccess";
			//joinsuccess로 반환
		} catch (DuplicateIdException e) 
		//duplicate exception 실행시
		{
			errors.put("duplicateId", true);
			//errors 객체에 duplicateid라는 이름으로 저장.
			return FORM_VIEW;
			//중복아이디일때 , joinform으로 요청.
		}

	}

	
	
}
