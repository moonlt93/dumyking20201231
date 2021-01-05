package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import member.dao.MemberDao;
import member.model.Member;

public class JoinService {
	//memberDao에 있는 sql문 실행 클래스
	private MemberDao memberDao = new MemberDao();
	
	public void join(JoinRequest joinReq) {
		// .......
		
		Connection con = null;
		try {
			con = ConnectionProvider.getConnection();//connection객체
			//
			con.setAutoCommit(false);
			// 트랜잭션 처리를 위해서 AutoCommit을 중지한다.

			
			Member m = memberDao.selectById(con, joinReq.getId());
			//m 객체는 memeberDao에서 selectbyID메소드를 통해 con,joinreq에 담긴 id메소드를 가져옴.
			
			if (m !=  null) 
			//만약 m객체가 null이 아니면?
			{
				JdbcUtil.rollback(con);
				//jdbcutil에 저장된 rollback 메소드 실행
				throw new DuplicateIdException();
				// 새로운 예외처리 실행.
			}
			
			Member member = new Member();
			//member 객체 생성
			member.setId(joinReq.getId());
			//joinReq에서 가져온 getId를 member객체에 저장.
			member.setName(joinReq.getName());
			//joinReq에서 가져온 getname를 member객체에 저장.
			member.setPassword(joinReq.getPassword());
			//joinReq에서 가져온 getpassword를 member객체에 저장.
			member.setBirth(joinReq.getBirth());
			member.setGender(joinReq.getGender());
			member.setJob(joinReq.getJob());
		
			memberDao.insert(con, member);
			//memberDao 에 삽입.  
			
			con.commit();
			//con 커밋.
		} catch (SQLException e) {
			JdbcUtil.rollback(con);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(con);
		}
	}
}
