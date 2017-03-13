package trendtracker.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import trendtracker.model.dto.MemberKeywordDTO;
import trendtracker.model.util.DBUtil;

public class MemberKeywordDAO {
	public static boolean addMemberKeyword(MemberKeywordDTO memberKeyword) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into member values(?, ?)");
			pstmt.setInt(1, memberKeyword.getMemberNum());
			pstmt.setInt(2, memberKeyword.getKeywordNum());

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean updateMemberKeyword(int oldKeywordNum, int newKeywordNum, int memberNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update mem_key set key_no=? where mem_no=? and key_no=?");
			pstmt.setInt(1, newKeywordNum);
			pstmt.setInt(2, memberNum);
			pstmt.setInt(3, oldKeywordNum);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean deleteMemberKeyword(int memberNum, int keywordNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from mem_key where key_no=? and mem_no=?");
			pstmt.setInt(1, keywordNum);
			pstmt.setInt(2, memberNum);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static MemberKeywordDTO getMemberKeywordFromKeyword(int keywordNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberKeywordDTO memberKeyword = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from mem_key where key_no=?");
			pstmt.setInt(1, keywordNum);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				memberKeyword = new MemberKeywordDTO(rset.getInt(1), rset.getInt(2));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return memberKeyword;
	}

	public static MemberKeywordDTO getMemberKeywordFromMember(int memberNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberKeywordDTO memberKeyword = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from mem_key where mem_no=?");
			pstmt.setInt(1, memberNum);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				memberKeyword = new MemberKeywordDTO(rset.getInt(1), rset.getInt(2));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return memberKeyword;
	}

	public static MemberKeywordDTO getOneMemberKeyword(int memberNum, int keywordNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberKeywordDTO memberKeyword = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from mem_key where mem_no=? and key_no=?");
			pstmt.setInt(1, memberNum);
			pstmt.setInt(2, keywordNum);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				memberKeyword = new MemberKeywordDTO(rset.getInt(1), rset.getInt(2));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return memberKeyword;
	}

	public static ArrayList<MemberKeywordDTO> getAllMemberKeywords() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MemberKeywordDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from mem_key");
			rset = pstmt.executeQuery();

			list = new ArrayList<MemberKeywordDTO>();
			while (rset.next()) {
				list.add(new MemberKeywordDTO(rset.getInt(1), rset.getInt(2)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}