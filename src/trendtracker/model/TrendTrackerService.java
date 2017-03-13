/*TrendTrackerService - Method
1. notExist
2. getAll
3. get
4. add
5. update
6. delete*/

package trendtracker.model;

import java.sql.SQLException;
import java.util.ArrayList;

import trendtracker.exception.NotExistException;
import trendtracker.model.dto.CategoryDTO;
import trendtracker.model.dto.KeywordDTO;
import trendtracker.model.dto.LogDTO;
import trendtracker.model.dto.MajorDTO;
import trendtracker.model.dto.MemberDTO;
import trendtracker.model.dto.MemberKeywordDTO;

public class TrendTrackerService {

	/*
	 * /////////////////////////////////////////////////////////////////////////
	 * ///////////////// Category
	 * /////////////////////////////////////////////////////////////////////////
	 * /////////////////
	 */
	public static void notExistCategory(int categoryNum) throws NotExistException, SQLException {

		CategoryDTO category = CategoryDAO.getCategory(categoryNum);
		if (category == null) {
			throw new NotExistException("해당 '카테고리'가 존재하지 않습니다.");
		}
	}

	public static ArrayList<CategoryDTO> getAllCategories() throws SQLException {
		return CategoryDAO.getAllCategories();
	}

	public static CategoryDTO getCategory(int categoryNum) throws SQLException, NotExistException {
		CategoryDTO category = CategoryDAO.getCategory(categoryNum);
		if (category == null) {
			throw new NotExistException("검색하신 '카테고리'가 없습니다.");
		}
		return category;
	}
	
	public static CategoryDTO getCategory(String category) throws SQLException, NotExistException {
		CategoryDTO categoryObject = CategoryDAO.getCategory(category);
		if (category == null) {
			throw new NotExistException("검색하신 '카테고리'가 없습니다.");
		}
		return categoryObject;
	}
	
	public static ArrayList<CategoryDTO> getCategoryFromMajorNum(int majorNum) throws SQLException, NotExistException {
		ArrayList<CategoryDTO> categoryList = CategoryDAO.getCategoryFromMajorNum(majorNum);
		if (categoryList == null) {
			throw new NotExistException("검색하신 '카테고리'가 없습니다.");
		}
		return categoryList;
	}

	public static boolean addCategory(CategoryDTO category) throws SQLException {
		return CategoryDAO.addCategory(category);
	}

	public static boolean updateCategory(int categoryNum, Object info) throws SQLException, NotExistException {
		notExistCategory(categoryNum);
		return CategoryDAO.updateCategory(categoryNum, info);
	}

	public static boolean deleteCategory(int categoryNum) throws SQLException, NotExistException {
		notExistCategory(categoryNum);
		return CategoryDAO.deleteCategory(categoryNum);
	}

	/*
	 * /////////////////////////////////////////////////////////////////////////
	 * ///////////////// Keyword
	 * /////////////////////////////////////////////////////////////////////////
	 * /////////////////
	 */

	public static void notExistKeyword(int keywordNum) throws NotExistException, SQLException {
		KeywordDTO keyword = KeywordDAO.getKeyword(keywordNum);
		if (keyword == null) {
			throw new NotExistException("해당 '키워드'가 존재하지 않습니다.");
		}
	}

	public static ArrayList<KeywordDTO> getAllKeywords() throws SQLException {
		return KeywordDAO.getAllKeywords();
	}

	public static KeywordDTO getKeyword(int keywordNum) throws SQLException, NotExistException {
		KeywordDTO keyword = KeywordDAO.getKeyword(keywordNum);
		if (keyword == null) {
			throw new NotExistException("검색하신 '키워드' 정보가 없습니다.");
		}
		return keyword;
	}
	
	public static KeywordDTO getKeyword(String keyword) throws SQLException, NotExistException {
		KeywordDTO keywordDTO = KeywordDAO.getKeyword(keyword);
		if (keyword == null) {
			throw new NotExistException("검색하신 '키워드' 정보가 없습니다.");
		}
		return keywordDTO;
	}

	public static boolean addKeyword(KeywordDTO keyword) throws SQLException {
		return KeywordDAO.addKeyword(keyword);
	}

	public static boolean updateKeyword(int keywordNum, Object info) throws SQLException, NotExistException {
		notExistKeyword(keywordNum);
		return KeywordDAO.updateKeyword(keywordNum, info);
	}

	public static boolean deleteKeyword(int keywordNum) throws SQLException, NotExistException {
		notExistKeyword(keywordNum);
		return KeywordDAO.deleteKeyword(keywordNum);
	}

	/*
	 * /////////////////////////////////////////////////////////////////////////
	 * ///////////////// Log
	 * /////////////////////////////////////////////////////////////////////////
	 * /////////////////
	 */

	public static void notExistLog(int logNum) throws NotExistException, SQLException {
		LogDTO log = LogDAO.getLog(logNum);
		if (log == null) {
			throw new NotExistException("해당 'Log'가 존재하지 않습니다.");
		}
	}

	public static ArrayList<LogDTO> getAllLogs() throws SQLException {
		return LogDAO.getAllLogs();
	}

	public static LogDTO getLog(int logNum) throws SQLException, NotExistException {
		LogDTO log = LogDAO.getLog(logNum);
		if (log == null) {
			throw new NotExistException("검색하신 'Log' 정보가 없습니다.");
		}
		return log;
	}

	public boolean deleteLog(int logNum) throws SQLException, NotExistException {
		notExistLog(logNum);
		return LogDAO.deleteLog(logNum);
	}

	/*
	 * /////////////////////////////////////////////////////////////////////////
	 * ///////////////// Major
	 * /////////////////////////////////////////////////////////////////////////
	 * /////////////////
	 */

	public static void notExistMajor(int majorNum) throws NotExistException, SQLException {
		MajorDTO major = MajorDAO.getMajor(majorNum);
		if (major == null) {
			throw new NotExistException("해당 '최상위 카테고리'가 존재하지 않습니다.");
		}
	}

	public static ArrayList<MajorDTO> getAllMajors() throws SQLException {
		return MajorDAO.getAllMajors();
	}

	public static MajorDTO getMajor(int majorNum) throws SQLException, NotExistException {
		MajorDTO major = MajorDAO.getMajor(majorNum);
		if (major == null) {
			throw new NotExistException("검색하신'최상위 카테고리' 정보가 없습니다.");
		}
		return major;
	}

	public static boolean addMajor(MajorDTO majorNum) throws SQLException {
		return MajorDAO.addMajor(majorNum);
	}

	public static boolean updateMajor(int majorNum, String major) throws SQLException, NotExistException {
		notExistMajor(majorNum);
		return MajorDAO.updateMajor(majorNum, major);
	}

	public boolean deleteMajor(int majorNum) throws SQLException, NotExistException {
		notExistMajor(majorNum);
		return MajorDAO.deleteMajor(majorNum);
	}

	/*
	 * /////////////////////////////////////////////////////////////////////////
	 * ///////////////// Member
	 * /////////////////////////////////////////////////////////////////////////
	 * /////////////////
	 */

	public static void notExistMember(int memberNum) throws NotExistException, SQLException {
		MemberDTO member = MemberDAO.getMember(memberNum);
		if (member == null) {
			throw new NotExistException("해당 '회원'이 존재하지 않습니다.");
		}
	}

	public static ArrayList<MemberDTO> getAllMembers() throws SQLException {
		return MemberDAO.getAllMembers();
	}

	public static MemberDTO getMember(int memberNum) throws SQLException, NotExistException {
		MemberDTO member = MemberDAO.getMember(memberNum);
		if (member == null) {
			throw new NotExistException("검색하신 '회원' 정보가 없습니다.");
		}
		return member;
	}

	public static boolean addMember(MemberDTO member) throws SQLException {
		return MemberDAO.addMember(member);
	}

	public static boolean updateMember(MemberDTO member) throws SQLException, NotExistException {
		notExistMajor(member.getMemberNum());
		return MemberDAO.updateMember(member);
	}

	public static boolean deleteMember(int memberNum) throws SQLException, NotExistException {
		notExistMajor(memberNum);
		return MemberDAO.deleteMember(memberNum);
	}

	/*
	 * /////////////////////////////////////////////////////////////////////////
	 * ///////////////// MemberKeyword
	 * /////////////////////////////////////////////////////////////////////////
	 */

	public static void notExistMemberKeyword(int memberNum) throws NotExistException, SQLException {
		MemberKeywordDTO memberKeyword = MemberKeywordDAO.getMemberKeywordFromMember(memberNum);
		if (memberKeyword == null) {
			throw new NotExistException("해당 '회원 키워드'가 존재하지 않습니다.");
		}
	}

	public static void notExistMemberKeyword(int memberNum, int keywordNum) throws NotExistException, SQLException {
		MemberKeywordDTO memberKeyword = MemberKeywordDAO.getOneMemberKeyword(memberNum, keywordNum);
		if (memberKeyword == null) {
			throw new NotExistException("해당 '회원 키워드'가 존재하지 않습니다.");
		}
	}

	public static MemberKeywordDTO getMemberKeywordFromKeyword(int memberNum) throws SQLException, NotExistException {
		MemberKeywordDTO memberKeyword = MemberKeywordDAO.getMemberKeywordFromKeyword(memberNum);
		if (memberKeyword == null) {
			throw new NotExistException("검색하신 '키워드'에 대한 Member Keyword 정보가 없습니다.");
		}
		return memberKeyword;
	}

	public static MemberKeywordDTO getMemberKeywordFromMember(int memberNum) throws SQLException, NotExistException {
		MemberKeywordDTO memberKeyword = MemberKeywordDAO.getMemberKeywordFromMember(memberNum);
		if (memberKeyword == null) {
			throw new NotExistException("이 회원은 Member Keyword를 가지고 있지 않습니다.");
		}
		return memberKeyword;
	}

	public static MemberKeywordDTO getOneMemberKeyword(int memberNum, int keywordNum)
			throws SQLException, NotExistException {
		MemberKeywordDTO memberKeyword = MemberKeywordDAO.getOneMemberKeyword(memberNum, keywordNum);
		if (memberKeyword == null) {
			throw new NotExistException("이 회원은 검색한 Keyword를 가지고 있지 않습니다.");
		}
		return memberKeyword;
	}

	public static ArrayList<MemberKeywordDTO> getAllMemberKeywords() throws SQLException {
		return MemberKeywordDAO.getAllMemberKeywords();
	}

	public static boolean addMemberKeyword(MemberKeywordDTO member) throws SQLException {
		return MemberKeywordDAO.addMemberKeyword(member);
	}

	public static boolean updateMemberKeyword(int oldKeywordNum, int newKeywordNum, int memberNum)
			throws SQLException, NotExistException {
		notExistMajor(memberNum);
		return MemberKeywordDAO.updateMemberKeyword(oldKeywordNum, newKeywordNum, memberNum);
	}

	public static boolean deleteMemberKeyword(int memberNum, int keywordNum) throws SQLException, NotExistException {
		notExistMajor(memberNum);
		return MemberKeywordDAO.deleteMemberKeyword(memberNum, keywordNum);
	}

}