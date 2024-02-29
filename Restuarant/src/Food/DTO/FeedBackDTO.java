package Food.DTO;

public class FeedBackDTO {
	private int feedback_id;
	private int user_id;
	private String feedback;
	private int ratings;
	public FeedBackDTO() {
		super();
	}
	public int getFeedback_id() {
		return feedback_id;
	}
	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}
	public FeedBackDTO(int feedback_id, int user_id, String feedback, int ratings) {
		super();
		this.feedback_id = feedback_id;
		this.user_id = user_id;
		this.feedback = feedback;
		this.ratings = ratings;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	
}
