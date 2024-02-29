package Food.DTO;
public class MenuDTO {
	private int item_id;
	private String item_name;
	private double price;
	private boolean availability;
	public MenuDTO() {
		
	}
	public MenuDTO(int item_id, String item_name, double price, boolean availability) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.price = price;
		this.availability = availability;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean getAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

}
