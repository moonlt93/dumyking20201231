package auth.service;

import java.sql.Connection;

import java.sql.SQLException;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class LoginService {
	private MemberDao memberDao = new MemberDao();

	public User login(String id, String password)
	// user 클래스 login메소드
	{
		try (Connection conn = ConnectionProvider.getConnection())
		// Connection conn객체 생성
		{
			Member member = memberDao.selectById(conn, id);
			// member 객체는 Dao에서 id구분
			if (member == null)
			// member가 null 일때 로그인 가능한거 없겠지?
			{
				throw new LoginFailException();
				// login실패 예외처리
			}
			if (!member.matchPassword(password))
			// member클래스의 password가 매칭이 안된다면?
			{
				throw new LoginFailException();
				// 로그인실패 예외처리가 뜸
			}

			return new User(member.getId(), member.getName(), member.getBirth(), member.getGender(), member.getJob());
			// 새로운 user 객체는 (멤버클래스에서 id와 name과 BIRTH 와 Gender와 Job을 받아옴.)
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
