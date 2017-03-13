package trendtracker.model.dto;

public class CategoryDTO {
	private int categoryNum;
	private int majorNum;
	private String category;
	
	public CategoryDTO() {
	}

	public CategoryDTO(int categoryNum, int majorNum, String category) {
		this.categoryNum = categoryNum;
		this.majorNum = majorNum;
		this.category = category;
	}

	public int getCategoryNum() {
		return categoryNum;
	}

	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}

	public int getMajorNum() {
		return majorNum;
	}

	public void setMajorNum(int majorNum) {
		this.majorNum = majorNum;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
