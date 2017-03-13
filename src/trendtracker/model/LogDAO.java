/*
CREATE TABLE log (
	log_no   INTEGER     NOT NULL, -- log_no
	mem_no   INTEGER     NOT NULL, -- mem_no
	keyword  VARCHAR(50) NULL,     -- keyword
	log_date DATE        NULL      -- log_date
);
*/

package trendtracker.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import trendtracker.model.dto.LogDTO;
import trendtracker.model.util.DBUtil;

public class LogDAO {
	public static boolean addLog(LogDTO log) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into log(mem_no, keyword) values(?)");
			pstmt.setInt(1, log.getMemberNum());
			pstmt.setString(2, log.getKeyword());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean deleteLog(int logNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from log where log_no=?");
			pstmt.setInt(1, logNum);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static LogDTO getLog(int logNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		LogDTO log = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from log where log_no=?");
			pstmt.setInt(1, logNum);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				log = new LogDTO(rset.getInt(1), rset.getInt(2), rset.getString(2), rset.getString(2));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return log;
	}

	public static ArrayList<LogDTO> getAllLogs() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<LogDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from log");
			rset = pstmt.executeQuery();

			list = new ArrayList<LogDTO>();
			while (rset.next()) {
				list.add(new LogDTO(rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getString(4)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
