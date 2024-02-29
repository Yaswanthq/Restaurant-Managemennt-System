package Food.DTO;

public class StaffDTO {
	private int staff_id;
	private String staffname;
	private String role;
	private Double salary;
	
	public StaffDTO() {
		super();
	}
	public StaffDTO(int staff_id, String staffname, String role, Double salary) {
		super();
		this.staff_id = staff_id;
		this.staffname = staffname;
		this.role = role;
		this.salary = salary;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaffname() {
		return staffname;
	}
	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
}
