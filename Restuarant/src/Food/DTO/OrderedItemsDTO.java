package Food.DTO;

public class OrderedItemsDTO {
	private int ordered_id;
	private int order_id;
	private int item_id;
	private String item_name;
	private int quantity;
	private double price;
	
	public OrderedItemsDTO() {
		super();
	}
	public OrderedItemsDTO(int ordered_id, int order_id, int item_id, String item_name, int quantity, double price) {
		super();
		this.ordered_id = ordered_id;
		this.order_id = order_id;
		this.item_id = item_id;
		this.item_name = item_name;
		this.quantity = quantity;
		this.price = price;
	}
	public int getOrdered_id() {
		return ordered_id;
	}
	public void setOrdered_id(int ordered_id) {
		this.ordered_id = ordered_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
