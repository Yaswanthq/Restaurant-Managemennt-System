package Food.DTO;
public class PaymentDTO {
	private int payment_id;
	private int order_id;
	private int user_id;
	private String status;
	
	public PaymentDTO() {
		super();
	}
	public PaymentDTO(int payment_id, int order_id, int user_id, String status) {
		super();
		this.payment_id = payment_id;
		this.order_id = order_id;
		this.user_id = user_id;
		this.status = status;
	}
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
