package trendtracker.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import trendtracker.model.dto.KeywordDTO;
import trendtracker.model.util.DBUtil;

/*
 * keyword
 * 1. key_no int
 * 2. cat_no int
 * 3. keyword String
 */

public class KeywordDAO {
	public static boolean addKeyword(KeywordDTO keyword) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into keyword(cat_no, keyword) values (?, ?)");
			pstmt.setInt(1, keyword.getCategoryNum());
			pstmt.setString(2, keyword.getKeyword());

			int result = pstmt.executeUpdate();

			if (result == 1)
				return true;
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean updateKeyword(int keyNum, Object info) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			if (info instanceof Integer) {
				pstmt = con.prepareStatement("update keyword set cat_no=? where cat_no=?");
				pstmt.setInt(2, (int) info);
			} else if (info instanceof String) {
				pstmt = con.prepareStatement("update keyword set keyword=? where cat_no=?");
				pstmt.setString(2, (String) info);
			}
			pstmt.setInt(1, keyNum);
			int result = pstmt.executeUpdate();
			if (result == 1)
				return true;
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean deleteKeyword(int keyNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from keyword where key_no=?");
			pstmt.setInt(1, keyNum);
			int result = pstmt.executeUpdate();
			if (result == 1)
				return true;
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static KeywordDTO getKeyword(Object keyInfo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		KeywordDTO activist = null;

		try {
			con = DBUtil.getConnection();
			if(keyInfo instanceof Integer){
				pstmt = con.prepareStatement("select * from keyword where key_no=?");
				pstmt.setInt(1, (int) keyInfo);
			} else if(keyInfo instanceof String){
				pstmt = con.prepareStatement("select * from keyword where keyword=?");
				pstmt.setString(1, (String) keyInfo);
			}
			rset = pstmt.executeQuery();
			if (rset.next())
				activist = new KeywordDTO(rset.getInt(1), rset.getInt(2), rset.getString(3));
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return activist;
	}

	public static ArrayList<KeywordDTO> getAllKeywords() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<KeywordDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from keyword");
			rset = pstmt.executeQuery();

			list = new ArrayList<KeywordDTO>();
			while (rset.next()) {
				list.add(new KeywordDTO(rset.getInt(1), rset.getInt(2), rset.getString(3)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
