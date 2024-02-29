package Food.DTO; 
public class TableDTO {
	private int t_id;
	private int t_number;
	private int capacity;
	private boolean avail;
	
	public TableDTO() {
		super();
	}
	public TableDTO(int t_id, int t_number, int capacity, boolean avail) {
		this.t_id = t_id;
		this.t_number = t_number;
		this.capacity = capacity;
		this.avail = avail;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public int getT_number() {
		return t_number;
	}
	public void setT_number(int t_number) {
		this.t_number = t_number;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Boolean getAvail() {
		return avail;
	}
	public void setAvail(Boolean avail) {
		this.avail = avail;
	}
	
}
