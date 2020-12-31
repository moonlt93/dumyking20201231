package member.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import member.model.Member;

public class MemberDao {
	
	

	
	
	public void delete(Connection conn, String id) throws SQLException {
		// 삭제 쿼리 실행
		String sql = "DELETE member "
				+ "WHERE memberid=?";
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) 
		
		{
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
		}
	}
	
	public void update(Connection conn, Member member) 
			throws SQLException {
		
		String sql = "UPDATE member "
				+ "SET name=?, password=? "
				+ "WHERE memberid=? ";
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getId());
			
			pstmt.executeUpdate();
		}
	}

	public Member selectById(Connection con, String id) 
			throws SQLException {
		
		Member member = null;
		
		String sql = "SELECT memberid, name, password, regdate ,Birth,Gender,Job "
				+ "FROM member "
				+ "WHERE memberid=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				member = new Member();
				member.setId(rs.getString(1));
				member.setName(rs.getString(2));
				member.setPassword(rs.getString(3));
				member.setRegDate(rs.getTimestamp(4));
				member.setBirth(rs.getString(5));
				member.setGender(rs.getString(6));
				member.setJob(rs.getString(7));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(rs, pstmt);
		}
		
		
		return member;
	}

	public void insert(Connection con, Member member) throws SQLException {
		String sql = "INSERT INTO member "
				+ "(memberid, name, password, regdate, birth,gender,job) "
				+ "VALUES (?, ?, ?, SYSDATE,to_date(?,'yyyy-mm-dd'),?,?) ";//이거 물어보기
		
		PreparedStatement pstmt = null;
		System.out.println(member.getBirth());
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getBirth());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getJob());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			JdbcUtil.close(pstmt);
		}
		
	}
}







