package trendtracker.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale.Category;

import trendtracker.model.dto.CategoryDTO;
import trendtracker.model.util.DBUtil;

public class CategoryDAO {
	public static boolean addCategory(CategoryDTO category) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into category(category, maj_no) values (?, ?)");
			pstmt.setString(1, category.getCategory());
			pstmt.setInt(2, category.getMajorNum());

			int result = pstmt.executeUpdate();

			if (result == 1)
				return true;
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean updateCategory(int categoryNum, Object info) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			if (info instanceof Integer) {
				pstmt = con.prepareStatement("update category set maj_no=? where cat_no=?");
				pstmt.setInt(2, (int) info);
			} else if (info instanceof String) {
				pstmt = con.prepareStatement("update category set category=? where cat_no=?");
				pstmt.setString(2, (String) info);
			}
			pstmt.setInt(1, categoryNum);
			int result = pstmt.executeUpdate();
			if (result == 1)
				return true;
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	public static boolean deleteCategory(int categoryNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("delete from category where cat_no=?");
			pstmt.setInt(1, categoryNum);
			int result = pstmt.executeUpdate();
			if (result == 1)
				return true;
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static CategoryDTO getCategory(Object categoryInfo) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CategoryDTO category = null;
		
		try{
			con = DBUtil.getConnection();
			if(categoryInfo instanceof Integer){
				pstmt = con.prepareStatement("select * from category where cat_id=?");
				pstmt.setInt(1, (int) categoryInfo);
			} else if(categoryInfo instanceof String){
				pstmt = con.prepareStatement("select * from category where category=?");
				pstmt.setString(1, (String) categoryInfo);
			}
			rset = pstmt.executeQuery();
			if(rset.next())
				category = new CategoryDTO(rset.getInt(1), rset.getInt(3), rset.getString(2));
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return category;
	}
	
	public static ArrayList<CategoryDTO> getCategoryFromMajorNum(int majorNum) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CategoryDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from category where maj_no=?");
			pstmt.setInt(1, majorNum);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<CategoryDTO>();
			while(rset.next()){
				list.add(new CategoryDTO(rset.getInt(1), rset.getInt(3), rset.getString(2)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	public static ArrayList<CategoryDTO> getAllCategories() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CategoryDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from category");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<CategoryDTO>();
			while(rset.next()){
				list.add(new CategoryDTO(rset.getInt(1), rset.getInt(3), rset.getString(2)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

}
