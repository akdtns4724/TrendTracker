package trendtracker.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import trendtracker.model.dto.MemberDTO;
import trendtracker.model.util.DBUtil;

public class MemberDAO {

	public static boolean addMember(MemberDTO member) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into member(age, name, id, pw, email, phone, gender) values(?, ?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, member.getAge());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getId());
			pstmt.setString(4, member.getPw());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getGender());

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean updateMember(MemberDTO member) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update member set age=?, pw=?, email=?, phone=?, gender=? where mem_no=?");
			pstmt.setInt(1, member.getAge());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getGender());
			pstmt.setInt(6, member.getMemberNum());

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean deleteMember(int memNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from member where mem_no=?");
			pstmt.setInt(1, memNum);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static MemberDTO getMember(int memNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberDTO member = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from member where id=?");
			pstmt.setInt(1, memNum);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				member = new MemberDTO(rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return member;
	}

	public static ArrayList<MemberDTO> getAllMembers() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MemberDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from member");
			rset = pstmt.executeQuery();

			list = new ArrayList<MemberDTO>();
			while (rset.next()) {
				list.add(new MemberDTO(rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getString(4),
						rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

}