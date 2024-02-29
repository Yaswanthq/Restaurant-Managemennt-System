package Food.DTO;
import java.sql.Time;
import java.util.*;
public class ReservationDTO {
	private int reservation_id;
	private int table_id;
	private Date date;
	private String time;
	private int user_id;
	public ReservationDTO() {
		
	}
	public ReservationDTO(int reservation_id, int table_id, Date date, String time, int user_id) {
		this.reservation_id = reservation_id;
		this.table_id = table_id;
		this.date = date;
		this.time = time;
		this.user_id = user_id;
	}
	public int getReservation_id() {
		return reservation_id;
	}
	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}
	public int getTable_id() {
		return table_id;
	}
	public void setTable_id(int table_id) {
		this.table_id = table_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
}
