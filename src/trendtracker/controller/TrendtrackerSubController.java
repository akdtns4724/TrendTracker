package trendtracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import trendtracker.model.TrendTrackerService;
import trendtracker.model.dto.CategoryDTO;
import trendtracker.model.dto.KeywordDTO;
import trendtracker.model.dto.MajorDTO;
import trendtracker.model.dto.MemberDTO;
import trendtracker.model.dto.MemberKeywordDTO;

@Controller
public class TrendtrackerSubController {
	// 예외 전담 처리 로직의 메소드
	@ExceptionHandler(Exception.class)
	public String exceptionProcess(Exception e) {
		e.printStackTrace();
		return "redirect:/showError.jsp?errorMsg=" + e.getMessage();
	}
	
	@RequestMapping("/")
	public ModelAndView main() throws Exception {
		/*
		 * 로그인 로직 추가 + 세션 로직 추가
		 */
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return mv;
	}
	
	// Category
	// 새로운 서브카테고리 등록 메소드
	@RequestMapping("categoryInsert")
	public ModelAndView categoryInsert(CategoryDTO category) throws Exception {
		boolean result = TrendTrackerService.addCategory(category);
		ModelAndView mv = new ModelAndView();
		if (result) {
			mv.setViewName("categoryView");
			mv.addObject("category", category);
			mv.addObject("successMsg", "서브 카테고리 등록 완료");
		} else {
			throw new Exception("다시 시도하세요");
		}
		return mv;
	}

	// 존재하는 서브카테고리 수정 요구
	@RequestMapping("categoryUpdateReq")
	public ModelAndView categoryUpdateReq(@RequestParam("categoryNum") int categoryNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("categoryView");
		mv.addObject("category", TrendTrackerService.getCategory(categoryNum));
		return mv;
	}

	// 존재하는 서브카테고리 수정 메소드
	@RequestMapping("categoryUpdate")
	public ModelAndView categoryUpdate(@RequestParam("categoryNum") int categoryNum, @RequestParam("info") Object info)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		if (TrendTrackerService.updateCategory(categoryNum, info)) {
			mv.setViewName("categoryView");
			mv.addObject("categoryAll", TrendTrackerService.getAllCategories());
		}
		return mv;
	}

	// 존재하는 서브카테고리 삭제 메소드
	@RequestMapping("categoryDelete")
	public ModelAndView categoryDelete(@RequestParam("categoryNum") int categoryNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		if (TrendTrackerService.deleteCategory(categoryNum)) {
			mv.setViewName("categoryView");
			mv.addObject("categoryAll", TrendTrackerService.getAllCategories());
		}
		return mv;
	}

	// 특정 서브카테고리 검색 메소드
	@RequestMapping("category")
	public ModelAndView category(@RequestParam("majorNum") int majorNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("categoryView");
		mv.addObject("category", TrendTrackerService.getCategoryFromMajorNum(majorNum));
		mv.addObject("major", TrendTrackerService.getMajor(majorNum));
		return mv;
	}

	// 모든 서브카테고리 검색 메소드
	@RequestMapping("categoryAll")
	public ModelAndView categoryAll() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("categoryView");
		mv.addObject("categoryAll", TrendTrackerService.getAllCategories());
		return mv;
	}

	// Keyword
	// 새로운 키워드 등록 메소드
	@RequestMapping("keywordInsert")
	protected ModelAndView keywordInsert(KeywordDTO keyword) throws Exception {
		boolean result = TrendTrackerService.addKeyword(keyword);
		ModelAndView mv = new ModelAndView();
		if (result) {
			mv.setViewName("keywordView");
			mv.addObject("keyword", keyword);
			mv.addObject("successMsg", "키워드 등록 완료");
		} else {
			throw new Exception("다시 시도하세요");
		}
		return mv;
	}

	// 존재하는 키워드 수정 요구
	@RequestMapping("keywordUpdateReq")
	public ModelAndView keywordUpdateReq(@RequestParam("keywordNum") int keywordNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("keywordView");
		mv.addObject("keyword", TrendTrackerService.getKeyword(keywordNum));
		return mv;
	}

	// 존재하는 키워드 수정 메소드
	@RequestMapping("keywordUpdate")
	public ModelAndView keywordUpdate(@RequestParam("keywordNum") int keywordNum, @RequestParam("info") Object info)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		if (TrendTrackerService.updateKeyword(keywordNum, info)) {
			mv.setViewName("keywordView");
			mv.addObject("keywordAll", TrendTrackerService.getAllKeywords());
		}
		return mv;
	}

	// 존재하는 키워드 삭제 메소드
	@RequestMapping("keywordDelete")
	public ModelAndView keywordDelete(@RequestParam("keywordNum") int keywordNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		if (TrendTrackerService.deleteKeyword(keywordNum)) {
			mv.setViewName("keywordView");
			mv.addObject("keywordAll", TrendTrackerService.getAllKeywords());
		}
		return mv;
	}

	// 특정 키워드 검색 메소드
	@RequestMapping(value = "keyword", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public ModelAndView keyword(@RequestParam("keyword") String keyword) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("keywordView");
		if (TrendTrackerService.getKeyword(keyword) == null) {
			mv.addObject("keyword", new KeywordDTO(0, 0, keyword));
		} else {
			mv.addObject("keyword", TrendTrackerService.getKeyword(keyword));
		}
		return mv;
	}

	// 모든 키워드 검색메소드
	@RequestMapping("keywordAll")
	public ModelAndView keywordAll() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("keywordView");
		mv.addObject("keywordAll", TrendTrackerService.getAllKeywords());
		return mv;
	}

	// Major
	// 새로운 카테고리 등록 메소드
	@RequestMapping("majorInsert")
	protected ModelAndView majorInsert(MajorDTO major) throws Exception {
		boolean result = TrendTrackerService.addMajor(major);
		ModelAndView mv = new ModelAndView();
		if (result) {
			mv.setViewName("categoryView");
			mv.addObject("major", major);
			mv.addObject("successMsg", "카테고리 등록 완료");
		} else {
			throw new Exception("다시 시도하세요");
		}
		return mv;
	}

	// 존재하는 카테고리 수정 메소드
	@RequestMapping("majorUpdate")
	public ModelAndView majorUpdate(@RequestParam("majorNum") int majorNum, @RequestParam("major") String major)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		if (TrendTrackerService.updateMajor(majorNum, major)) {
			mv.setViewName("categoryView");
			mv.addObject("majorAll", TrendTrackerService.getAllMajors());
		}
		return mv;
	}

	// 존재하는 카테고리 삭제 메소드
	@RequestMapping("majorDelete")
	public ModelAndView majorDelete(@RequestParam("majorNum") int majorNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		if (TrendTrackerService.deleteKeyword(majorNum)) {
			mv.setViewName("categoryView");
			mv.addObject("majorAll", TrendTrackerService.getAllMajors());
		}
		return mv;
	}

	// 특정 카테고리 검색 메소드
	@RequestMapping("major")
	public ModelAndView major(@RequestParam("majorNum") int majorNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("categoryView");
		mv.addObject("major", TrendTrackerService.getMajor(majorNum));
		return mv;
	}

	// 모든 카테고리 검색 메소드
	@RequestMapping("majorAll")
	public ModelAndView majorAll() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("categoryView");
		mv.addObject("majorAll", TrendTrackerService.getAllMajors());
		return mv;
	}

	// Member
	// 새로운 회원 등록 메소드
	@RequestMapping("memberInsert")
	protected String memberInsert(MemberDTO member) throws Exception {
		boolean result = TrendTrackerService.addMember(member);
		ModelAndView mv = new ModelAndView();
		if (result) {
			mv.addObject("member", member);
		} else {
			throw new Exception("다시 시도하세요");
		}
		return "redirect:/main.html";
	}

	// 존재하는 회원정보 수정 메소드
	@RequestMapping("memberUpdate")
	public ModelAndView memberUpdate(MemberDTO member) throws Exception {
		ModelAndView mv = new ModelAndView();
		if (TrendTrackerService.updateMember(member)) {
			mv.setViewName("mypageUpdate");
			mv.addObject("member", TrendTrackerService.getMember(member.getMemberNum()));
		}
		return mv;
	}

	// 존재하는 회원 탈퇴 메소드
	@RequestMapping("memberDelete")
	public ModelAndView memberDelete(@RequestParam("memberNum") int memberNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		if (TrendTrackerService.deleteMember(memberNum)) {
			mv.setViewName("mypageUpdate");
		}
		return mv;
	}

	// 특정 회원 검색 메소드
	@RequestMapping("member")
	public ModelAndView member(@RequestParam("memberNum") int memberNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mypageinfo");
		mv.addObject("member", TrendTrackerService.getMember(memberNum));
		return mv;
	}

	// 모든 회원 검색 메소드
	@RequestMapping("memberAll")
	public ModelAndView memberAll() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberAll", TrendTrackerService.getAllMembers());
		return mv;
	}

	// MemberKeyword
	// 새로운 멤버-키워드 등록 메소드
	@RequestMapping("memberKeywordInsert")
	protected ModelAndView memberKeywordInsert(MemberKeywordDTO memberKeyword) throws Exception {
		boolean result = TrendTrackerService.addMemberKeyword(memberKeyword);
		ModelAndView mv = new ModelAndView();
		if (result) {
			mv.setViewName("mypageinfo");
			mv.addObject("memberKeyword", memberKeyword);
			mv.addObject("successMsg", "카테고리 등록 완료");
		} else {
			throw new Exception("다시 시도하세요");
		}
		return mv;
		// return "redirect:/main.html";
	}

	// 존재하는 지정 키워드 수정 메소드
	@RequestMapping("memberKeywordUpdate")
	public ModelAndView memberKeywordUpdate(@RequestParam("oldKeywordNum") int oldKeywordNum,
			@RequestParam("newKeywordNum") int newKeywordNum, @RequestParam("memberNum") int memberNum)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		if (TrendTrackerService.updateMemberKeyword(oldKeywordNum, newKeywordNum, memberNum)) {
			mv.setViewName("mypageinfo");
			mv.addObject("memberKeywordAll", TrendTrackerService.getAllMemberKeywords());
		}
		return mv;
	}

	// 존재하는 멤버-키워드 삭제 메소드
	@RequestMapping("memberKeywordDelete")
	public ModelAndView majorDelete(@RequestParam("memberNum") int memberNum,
			@RequestParam("keywordNum") int keywordNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		if (TrendTrackerService.deleteMemberKeyword(memberNum, keywordNum)) {
			mv.setViewName("mypageinfo");
			mv.addObject("memberKeywordAll", TrendTrackerService.getAllMemberKeywords());
		}
		return mv;
	}

	// 키워드번호별 멤버-키워드 검색 메소드
	@RequestMapping("memberKeywordFromKeyword")
	public ModelAndView memberKeywordFromKeyword(@RequestParam("keywordNum") int keywordNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(" ");
		mv.addObject("memberKeywordFromKeyword", TrendTrackerService.getMemberKeywordFromKeyword(keywordNum));
		return mv;
	}

	// 멤버번호별 멤버-키워드 검색 메소드
	@RequestMapping("memberKeywordFromMember")
	public ModelAndView memberKeywordFromMember(@RequestParam("memberNum") int memberNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(" ");
		mv.addObject("memberKeywordFromMember", TrendTrackerService.getMemberKeywordFromMember(memberNum));
		return mv;
	}

	// 한 회원의 여러 지정 키워드 중 특정 멤버-키워드 검색 메소드
	@RequestMapping("oneMemberKeyword")
	public ModelAndView oneMemberKeyword(@RequestParam("memberNum") int memberNum,
			@RequestParam("keywordNum") int keywordNum) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(" ");
		mv.addObject("memberKeywordFromMember", TrendTrackerService.getOneMemberKeyword(memberNum, keywordNum));
		return mv;
	}

	// 모든 멤버-키워드 검색 메소드
	@RequestMapping("memberKeywordAll")
	public ModelAndView memberKeywordAll() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mypageinfo");
		mv.addObject("memberKeywordAll", TrendTrackerService.getAllMemberKeywords());
		return mv;
	}
}