/*
CREATE TABLE major (
	maj_no INTEGER     NOT NULL, -- maj_no
	major  VARCHAR(50) NULL      -- major
);

 */
package trendtracker.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import trendtracker.model.dto.MajorDTO;
import trendtracker.model.util.DBUtil;

public class MajorDAO {
	public static boolean addMajor(MajorDTO major) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into major(major) values(?)");
			pstmt.setString(1, major.getMajor());
			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean updateMajor(int majorNum, String major) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement("update major set major=? where major_no=?");
			pstmt.setString(1, major);
			pstmt.setInt(2, majorNum);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean deleteMajor(int majorNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from major where maj_no=?");
			pstmt.setInt(1, majorNum);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static MajorDTO getMajor(int majorNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MajorDTO major = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from major where maj_no=?");
			pstmt.setInt(1, majorNum);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				major = new MajorDTO(rset.getInt(1), rset.getString(2));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return major;
	}

	public static ArrayList<MajorDTO> getAllMajors() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MajorDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from major");
			rset = pstmt.executeQuery();

			list = new ArrayList<MajorDTO>();
			while (rset.next()) {
				list.add(new MajorDTO(rset.getInt(1), rset.getString(2)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
