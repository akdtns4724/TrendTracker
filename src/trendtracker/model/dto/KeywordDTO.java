package trendtracker.model.dto;

public class KeywordDTO {
   private int keywordNum;
   private int categoryNum;
   private String keyword;
   
   public KeywordDTO() {
   }

   public KeywordDTO(int keywordNum, int categoryNum, String keyword) {
      this.keywordNum = keywordNum;
      this.categoryNum = categoryNum;
      this.keyword = keyword;
   }

   public int getKeywordNum() {
      return keywordNum;
   }

   public void setKeywordNum(int keywordNum) {
      this.keywordNum = keywordNum;
   }

   public int getCategoryNum() {
      return categoryNum;
   }

   public void setCategoryNum(int categoryNum) {
      this.categoryNum = categoryNum;
   }

   public String getKeyword() {
      return keyword;
   }

   public void setKeyword(String keyword) {
      this.keyword = keyword;
   }
}