package eats.dto;

public class ReviewDTO {
	private int restaurantNo;
	private int reviewNo;
	private int score;
	private String regdate;
	private String writer;
	private String content;
	
	public ReviewDTO() {}
	public ReviewDTO(int restaurantNo, int reviewNo, int score, String regdate, String writer, String content) {
		this.restaurantNo = restaurantNo;
		this.reviewNo = reviewNo;
		this.score = score;
		this.regdate = regdate;
		this.writer = writer;
		this.content = content;
	}
	
	public int getRestaurantNo() {
		return restaurantNo;
	}
	public void setRestaurantNo(int restaurantNo) {
		this.restaurantNo = restaurantNo;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" | review ��ȣ = ");
		builder.append(reviewNo);
		builder.append(" | ���� = ");
		builder.append(score);
		builder.append(" | ����� = ");
		builder.append(regdate);
		builder.append(" | �ۼ��� = ");
		builder.append(writer);
		builder.append(" | ���� = ");
		builder.append(content);
		return builder.toString();
	}
	
	
	
}
