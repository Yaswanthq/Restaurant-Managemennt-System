package Food.DTO;

import java.sql.Time;
import java.util.*;

public class OrderDTO {
	private int order_id;
	private int user_id;
	private Date order_date;
	private Time order_time;
	public OrderDTO() {
		
	}
	public OrderDTO(int order_id, int user_id, Date order_date, Time order_time) {
		this.order_id = order_id;
		this.user_id = user_id;
		this.order_date = order_date;
		this.order_time = order_time;
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
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public Time order_time() {
		return order_time;
	}
	public void setOrder_time(Time order_time) {
		this.order_time = order_time;
	}
	
}
