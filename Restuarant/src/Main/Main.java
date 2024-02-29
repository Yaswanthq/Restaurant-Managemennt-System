package Main;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Food.*;
import Food.DTO.*;
import DAO.*;
public class Main{
	static int choice=0;
	static OrderDTO or=new OrderDTO();
	static UserDaoImpl u=new UserDaoImpl();
	static MenuDTO m1=new MenuDTO();
	static MenuDaoImpl m=new MenuDaoImpl();
	static TableDTO t1=new TableDTO();
	static TableDaoImpl t=new TableDaoImpl();
	static ReservationDTO r=new ReservationDTO();
	static ReservationDaoImpl re=new ReservationDaoImpl();
	static OrderedItemsDTO o1=new OrderedItemsDTO();
	static OrdereditemsDaoImpl o=new OrdereditemsDaoImpl();
	static FeedBackDTO f=new FeedBackDTO();
	static FeedBackDaoImpl f1=new FeedBackDaoImpl();
	static StaffDTO s=new StaffDTO();
	static StaffDaoImpl s1=new StaffDaoImpl();
	static PaymentDTO p=new PaymentDTO();
	static PaymentDaoImpl p1=new PaymentDaoImpl();
	static Scanner sc=new Scanner(System.in);
	static boolean val=true;
	public static void main(String args[]) throws Exception {
	System.out.println();
	System.out.println("< -----WELCOME TO RESTOMANIA ----->");
	System.out.println();
	System.out.println("+---------------------------------+");
	System.out.println("|      1.    SIGN UP              |");
	System.out.println("+---------------------------------+");
	System.out.println("|      2.    LOG IN               |");
	System.out.println("+---------------------------------+");
	System.out.println();
	System.out.print("Enter your choice: ");
	choice=sc.nextInt();
	sc.nextLine();
	String email="";
	String password="";
	String number="";
	switch(choice) {
		case 1:
			UserDTO user1=new UserDTO();
			System.out.print("Enter your name :");
			String name=sc.nextLine();
			user1.setUsername(name);
			String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
			Matcher matcher;
			Pattern pattern = Pattern.compile(emailPattern);
			do {
			    System.out.print("Enter your Email: ");
			    email = sc.next();
			    matcher = pattern.matcher(email);
			    if (!matcher.matches()) {
			        System.out.println("Invalid email format! Please enter a valid email.");
			    }
			} while (!matcher.matches()); // Repeat until a valid email Email Doesn't Exist!!!is entered
			user1.setEmail(email);
			String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
			pattern = Pattern.compile(passwordPattern);
			do {
			    System.out.print("Enter your Password: ");
			    password = sc.next();
			    matcher = pattern.matcher(password);
			    if (!matcher.matches()) {
			        System.out.println("Invalid password format! Password must contain at least 8 characters, including at least one uppercase letter, one lowercase letter, one digit, and one special character.");
			    }
			} while (!matcher.matches()); // Repeat until a valid password is entere
			user1.setPassword(password);
		    String phonePattern = "\\d{10}"; 
		    pattern = Pattern.compile(phonePattern);
		    do {
		    	System.out.print("Enter your Mobile Number: ");
				number=sc.next();
		    	matcher = pattern.matcher(number);
		        if (!matcher.matches()) {
		            System.out.println("Phone number is not valid.");
		        }
		    }while(!matcher.matches());
			user1.setNumber(number);
			int rs=u.insert(user1);
			if(rs>0) {
				System.out.println("Signed Up Successfully!!");
				System.out.println("-------------------------");
			}
			main(null);
			break;
		case 2:
			System.out.print("Enter you email: ");
			email=sc.next();
			System.out.print("Enter your password: ");
			password=sc.next();
			UserDTO user=u.getByEmailAndPassword(email,password);
			if(user!=null) {
				String res=user.getRole();
				if(res!=null && res.equals("user")) {
					do {
							System.out.println("+-------------WELCOME CUSTOMER--------------+");
							System.out.println("|-------------------------------------------|");
							System.out.println("| 1 ----->      VIEW MENU                   |");
							System.out.println("|-------------------------------------------|");
							System.out.println("| 2 ----->     VIEW TABLES                  |");
							System.out.println("|-------------------------------------------|");
							System.out.println("| 3 ----->   MAKE RESERVATION               |");
							System.out.println("|-------------------------------------------|");
							System.out.println("| 4 ----->    PLACE AN ORDER                |");
							System.out.println("|-------------------------------------------|");
							System.out.println("| 5 ----->   PROVIDE FEEDBACK               |");
							System.out.println("|-------------------------------------------|");
							System.out.println("| 6 ----->     LOGOUT                       |");
							System.out.println("|-------------------------------------------|");
							System.out.print("Enter your choice: ");
							choice=sc.nextInt();
							switch(choice) {
							case 1:
								System.out.println("         List of items        ");
								List<MenuDTO> menulist=m.getAll();
								for(MenuDTO menu1:menulist) {
									System.out.println("+-------------------------+");
									System.out.println("Item id:"+ menu1.getItem_id());
									System.out.println("Item Name:"+ menu1.getItem_name());
									System.out.println("Price:"+ menu1.getPrice());
									System.out.println("Availability:"+ menu1.getAvailability());
								}
							
								break;
							case 2:
								System.out.println("         List of Tables       ");
								List<TableDTO> tablelist=t.getAll();
								for(TableDTO table:tablelist) {
									System.out.println("+-------------------------+");
									System.out.println("Table id:"+ table.getT_id());
									System.out.println("Table Name:"+ table.getT_number());
									System.out.println("Capacity:"+ table.getCapacity());
									System.out.println("Availability:"+ table.getAvail());
								}
								break;
							case 3:
								System.out.println("+--------------------------------+");
								System.out.println("| 1 ---> Make an Reservation     |");
								System.out.println("+--------------------------------+");
								System.out.println("| 2 ---> Cancel Reservation      |");
								System.out.println("+--------------------------------+");
								System.out.println("| 3 --->       Exit              |");
								System.out.println("+--------------------------------+");
								System.out.println("Enter your choice: ");
								choice=sc.nextInt();
								switch(choice) {
								case 1:
									System.out.print("Enter the table id: ");
									int id=sc.nextInt();
									Date date1 = null;
								    boolean isValidDate = false;
								    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
								    while (!isValidDate) {
								        System.out.print("Enter Date (format: yyyy-MM-dd): ");
								        String dateInput = sc.next();
								        try {
								            java.util.Date utilDate = sdf.parse(dateInput);
								            Date currentDate = new Date(System.currentTimeMillis());
								            if (utilDate.after(currentDate)) {
								                date1 = new java.sql.Date(utilDate.getTime());
								                isValidDate = true;
								            } else {
								                System.out.println("Please enter a future date.");
								            }
								        } catch (ParseException e) {
								            System.out.println("Invalid date format. Please enter date in format yyyy-MM-dd.");
								        }
								    }
						            System.out.print("Enter the reservation time (HH:mm:ss): ");
						            String time = sc.next();
						            int userId=user.getUser_id();
									r.setTable_id(id);
									r.setDate(date1);
									r.setTime(time);
									r.setUser_id(userId);
									int rs1=re.insert(r);
									if(rs1>0) {
										System.out.println("Reservation Successfully!!");
										System.out.println("-------------------------");
									}
									break;
								case 2:
									System.out.println("Enter your table id");
									int table=sc.nextInt();
									r.setTable_id(table);
									int rs2=re.delete(r);
									if(rs2>0) {
										System.out.println("Reservation cancelled Successfully!!!!");
									}
									break;
								case 3:
									break;
								}
								break;
							case 4:
								System.out.println("+--------------------------------+");
								System.out.println("| 1 --->   Place an Order        |");
								System.out.println("+--------------------------------+");
								System.out.println("| 2 --->    Cancel Order         |");
								System.out.println("+--------------------------------+");
								System.out.println("| 3 --->       Exit              |");
								System.out.println("+--------------------------------+");
								System.out.println("Enter your choice: ");
								choice=sc.nextInt();
								switch(choice) {
								case 1: // Place an Order
								    System.out.print("Enter the item id: ");
								    int id = sc.nextInt();
								    System.out.print("Enter the quantity: ");
								    int quantity = sc.nextInt();
								    o1.setItem_id(id);
								    o1.setQuantity(quantity);
								    double totalAmount = o.getTotal(o1);
								    o1.setPrice(totalAmount);
								    System.out.println("Total Amount: " + totalAmount);
								    int rowsAffected = o.insert(o1);
								    if (rowsAffected > 0) {
								        System.out.println("Item added successfully!");
								        int orderId = o1.getOrdered_id();
								        System.out.println("Your order Id is: "+orderId);
								        do {
								            // Ask user for additional item ID and quantity
								            System.out.println("+-------------------------------+");
								            System.out.println("|Do you want to add more items: |");
								            System.out.println("|-------------------------------|");
								            System.out.println("|         1 ---> Yes             |");
								            System.out.println("|         2 ---> No              |");
								            System.out.println("+-------------------------------|");
								            System.out.print("Enter your choice: ");
								            choice = sc.nextInt();
								            
								            switch(choice) {
								                case 1:
								                    System.out.print("Enter the item id: ");
								                    id = sc.nextInt();
								                    System.out.print("Enter the quantity: ");
								                    quantity = sc.nextInt();
								                    o1.setItem_id(id);
								                    o1.setQuantity(quantity);
								                    totalAmount += o.getTotal(o1);
								                    o1.setPrice(totalAmount);
								                    System.out.println("Total Amount: " + totalAmount);			
								                    o1.setOrdered_id(orderId);
								                    rowsAffected = o.insert(o1);
								                    if (rowsAffected > 0) {
								                        System.out.println("Item added successfully!");
								                        System.out.println("Your order Id is: "+orderId);
								                    } else {
								                        System.out.println("Failed to add item!");
								                    }
								                    break;
								                case 2:
								                    break;
								            }
								        } while(choice<2);
								        
								        // Insert payment details once all items are added
								        int userId = user.getUser_id();
								        String status = "pending";
								        p.setOrder_id(orderId); // Use the same orderId for payment
								        p.setUser_id(userId); 
								        p.setStatus(status);
								        
								        int paymentInserted = p1.insert(p);
								        if (paymentInserted > 0) {
								            System.out.println("Payment inserted Successfully!!");
								        } else {
								            System.out.println("Failed to insert payment details!");
								        }
								    } else {
								        System.out.println("Failed to place order!");
								    }
								    break;
								case 2:
									System.out.println("Enter your Ordered id");
									int orderid=sc.nextInt();
									o1.setOrdered_id(orderid);
									int rs3=o.delete(o1);
									if(rs3>0) {
										System.out.println("Order cancelled Successfully!!!!");
									}
								case 3:
									break;
								}
								break;
							case 5:
								System.out.println("+---------------------+");
								System.out.print("Enter your Feedback: ");
								sc.nextLine();
								String feed=sc.nextLine();
								System.out.print("Give your Ratings: ");
								int ratings=sc.nextInt();
								int userId=user.getUser_id();
								f.setUser_id(userId);
								f.setFeedback(feed);
								f.setRatings(ratings);
								int rs2=f1.insert(f);
								if(rs2>0) {
									System.out.println("Feedback Submitted Successfully!!");
								}else {
									System.out.println("Feedback Not Submitted");
								}
								break;
							case 6:
								main(null);
								break;
							}
						}while(choice<6);
				}
				else if(res!=null && res.equals("admin")) {
					do {
						System.out.println("+---------------WELCOME ADMIN---------------+");
						System.out.println("|-------------------------------------------|");
						System.out.println("| 1 ----->       MANAGE MENU                |");
						System.out.println("|-------------------------------------------|");
						System.out.println("| 2 ----->      MANAGE ORDERS               |");
						System.out.println("|-------------------------------------------|");
						System.out.println("| 3 ----->      MANAGE TABLES               |");
						System.out.println("|-------------------------------------------|");
						System.out.println("| 4 ----->     MANAGE FEEDBACK              |");
						System.out.println("|-------------------------------------------|");
						System.out.println("| 5 ----->    MANAGE RESERVATION            |");
						System.out.println("|-------------------------------------------|");
						System.out.println("| 6 ----->      MANAGE STAFFS               |");
						System.out.println("+-------------------------------------------|");
						System.out.println("| 7 ----->      MANAGE PAYMENTS             |");
						System.out.println("|-------------------------------------------|");
						System.out.println("| 8 ----->        LOGOUT                    |");
						System.out.println("+-------------------------------------------+");
						System.out.print("Enter your choice: ");
						choice=sc.nextInt();
						sc.nextLine();
						switch(choice) {
							case 1:
								System.out.println("+----------------------------------+");
								System.out.println("|    1 --->  Add Items             |");
								System.out.println("|----------------------------------|");
								System.out.println("|    2 --->  Update Items          |");
								System.out.println("|----------------------------------|");
								System.out.println("|    3 --->  Delete Items          |");
								System.out.println("|----------------------------------|");
								System.out.println("|    4 --->  View Items            |");
								System.out.println("|----------------------------------|");
								System.out.println("|    5 --->      Exit              |");
								System.out.println("+----------------------------------+");
								System.out.println("Enter your choice");
								choice =sc.nextInt();
								sc.nextLine();
								switch(choice) {
									case 1:
										System.out.print("Enter item name: ");
										String itemname=sc.nextLine();
										System.out.print("Enter the price: ");
										double amt=sc.nextDouble();
										System.out.print("Enter true if available else make it as false:");
										boolean b=sc.nextBoolean();
										m1.setItem_name(itemname);
										m1.setPrice(amt);
										m1.setAvailability(b);
										int rs1=m.insert(m1);
										if(rs1>0) {
											System.out.println("Menu items added Successfully");
										}
										break;
									case 2:
										System.out.println("Enter the item id: ");
										int id=sc.nextInt();
										System.out.print("Enter item name to be update: ");
										String name1=sc.nextLine();
										System.out.print("Enter the price to be update: ");
										double amt1=sc.nextDouble();
										System.out.print("Enter true if available else make it as false:");
										boolean bo=sc.nextBoolean();
										m1.setItem_id(id);
										m1.setItem_name(name1);
										m1.setPrice(amt1);
										m1.setAvailability(bo);
										int result=m.update(m1);
										if(result>0) {
											System.out.println("Menu items updated Successfully!!!");
										}
										break;	
									case 3:
										System.out.print("Enter item id to be deleted: ");
										int id1=sc.nextInt();
										m1.setItem_id(id1);
									    int set=m.delete(m1);
									    if(set>0) {
									    	System.out.println("Menu items deleted Successfully!!!");
									    }
										break;
									case 4:
										System.out.println("         List of items        ");
										List<MenuDTO> menulist=m.getAll();
										for(MenuDTO menu1:menulist) {
											System.out.println("+-------------------------+");
											System.out.println("Item id:"+ menu1.getItem_id());
											System.out.println("Item Name:"+ menu1.getItem_name());
											System.out.println("Price:"+ menu1.getPrice());
											System.out.println("Availability:"+ menu1.getAvailability());
										}
										break;
									case 5:
										break;
								}
								break;
							case 2:
								System.out.println("+----------------------------------+");
								System.out.println("|    1 --->  View Peaked Orders    |");
								System.out.println("|----------------------------------|");
								System.out.println("|    2 --->  View Orders           |");
								System.out.println("|----------------------------------|");
								System.out.println("|    3 --->      Exit              |");
								System.out.println("+----------------------------------+");
							    System.out.print("Enter your choice: ");
							    choice = sc.nextInt();
							    switch(choice) {
							        case 1:
							         
							            List<OrderedItemsDTO> peakedOrders = o.getPeakedOrder();
							            for(OrderedItemsDTO order : peakedOrders) {
							            	System.out.println("+-------------------------+");
							                System.out.println("Item Name: " + order.getItem_name());
							                System.out.println("Total Sold: " + order.getQuantity());
							            }
							            break;
							       case 2:
							    	   System.out.println("    List Of Ordered Items      ");
							           List<OrderedItemsDTO> orders = o.getAll();
							            for(OrderedItemsDTO order : orders) {
							            	System.out.println("+-------------------------+");
							                System.out.println("Ordered ID: " + order.getOrdered_id());
							                System.out.println("Item ID: " + order.getItem_id());
							                System.out.println("Item name: " + order.getItem_name());
							                System.out.println("Quantity: " + order.getQuantity());
							                System.out.println("Price: " + order.getPrice());
							           
							            }
							            break;
							        case 3:
							        	break;
							    }
							    break;
							case 3:
							    System.out.println("+----------------------------------+");
							    System.out.println("|    1 --->  Add Table             |");
							    System.out.println("|----------------------------------|");
							    System.out.println("|    2 --->  Update Table          |");
							    System.out.println("|----------------------------------|");
							    System.out.println("|    3 --->  Delete Table          |");
							    System.out.println("|----------------------------------|");
							    System.out.println("|    4 --->  View Tables           |");
							    System.out.println("|----------------------------------|");
							    System.out.println("|    4 --->      Exit              |");
							    System.out.println("+----------------------------------+");
							    System.out.print("Enter your choice: ");
							    int tableChoice = sc.nextInt();
							    switch (tableChoice) {
							        case 1: // Add Table
						
							        	System.out.print("Enter table number to add:");
							        	int table=sc.nextInt();
							        	System.out.print("Enter the capacity to be added: ");
							        	int capacity=sc.nextInt();
							        	System.out.print("Enter true to make available or keep it as false: ");
							        	boolean val=sc.nextBoolean();
							        	t1.setT_number(table);
							        	t1.setCapacity(capacity);
							        	t1.setAvail(val);
							        	int rs1=t.insert(t1);
							        	if(rs1>0) {
							        		System.out.println("Table inserted Successfully");
							        	}else {
							        		System.out.println("Table insertion failed");
							        	}
							            break;
							        case 2: // Update Table
							            
							        	System.out.print("Enter your table id: ");
							        	int number1=sc.nextInt();
							        	t1.setT_id(number1);
							        	int p=t.insert(t1);
							        	if(p>0) {
							        		System.out.println("Table updated Successfully");
							        	}else {
							        		System.out.println("Table updation failed");
							        	}
							            break;
							        case 3: // Delete Table
							           
							        	System.out.print("Enter the table id you want to delete: ");
							        	int table1=sc.nextInt();
							        	t1.setT_id(table1);
							        	int k=t.insert(t1);
							        	if(k>0) {
							        		System.out.println("Table deleted Successfully");
							        	}else {
							        		System.out.println("Table deletion failed");
							        	}
							            break;
							        case 4: // Exit
							        	System.out.println("         List of Tables       ");
										List<TableDTO> tablelist=t.getAll();
										for(TableDTO table11:tablelist) {
											System.out.println("+-------------------------+");
											System.out.println("Table id:"+ table11.getT_id());
											System.out.println("Table Number:"+ table11.getT_number());
											System.out.println("Capacity:"+ table11.getCapacity());
											System.out.println("Availability:"+ table11.getAvail());
										}
							            break;
							        case 5:
							        	break;
							        default:
							            System.out.println("Invalid choice");
							            break;
							    }
							    break;

							case 4: // Manage Feedback
							    System.out.println("+----------------------------------+");
							    System.out.println("|    1 --->  View Feedback         |");
							    System.out.println("|    2 --->  Delete Feedback       |");
							    System.out.println("|    3 --->      Exit              |");
							    System.out.println("+----------------------------------+");
							    System.out.print("Enter your choice: ");
							    int feedbackChoice = sc.nextInt();
							    switch (feedbackChoice) {
							        case 1: // View Feedback
							           
							        	System.out.println("       List of feedbacks      ");
							        	 List<FeedBackDTO> feedback = f1.getAll();
								            for(FeedBackDTO feedback1 : feedback) {
								            	System.out.println("+-------------------------+");
								                System.out.println("FeedBack ID: " + feedback1.getFeedback_id());
								                System.out.println("User ID: " + feedback1.getUser_id());
								                System.out.println("FeedBacks: " + feedback1.getFeedback());
								                System.out.println("Ratings: " + feedback1.getRatings());
								            }
							        	
							            break;
							        case 2: // Delete Feedback
							            
							        	System.out.print("Enter the Feedback id you want to delete");
							        	int id=sc.nextInt();
							        	f.setFeedback_id(id);
							        	int rs1=f1.delete(f);
							        	if(rs1>0) {
							        		System.out.println("Feedback deleted Successfully");
							        	}else {
							        		System.out.println("Feedback deletion failed");
							        	}
							            break;
							        case 3: // Exit
							            break;
							        default:
							            System.out.println("Invalid choice");
							            break;
							    }
							    break;

							case 5: // Manage Reservations
							    System.out.println("+----------------------------------+");
							    System.out.println("|    1 --->  View Reservations     |");
							    System.out.println("|    2 --->  Cancel Reservation    |");
							    System.out.println("|    3 --->      Exit              |");
							    System.out.println("+----------------------------------+");
							    System.out.print("Enter your choice: ");
							    int reservationChoice = sc.nextInt();
							    switch (reservationChoice) {
							        case 1: // View Reservations
							        	System.out.println("       List of Reservation      ");
							        	 List<ReservationDTO> reservation = re.getAll();
								            for(ReservationDTO reservations : reservation) {
								            	System.out.println("+-------------------------+");
								                System.out.println("Reservation ID: " + reservations.getReservation_id());
								                System.out.println("Table ID: " + reservations.getTable_id());
								                System.out.println("User Id: "+reservations.getUser_id());
								                System.out.println("Reservation date: " + reservations.getDate());
								                System.out.println("Reservation Time: " + reservations.getTime());
								            }
							            break;
							        case 2: // Cancel Reservation
							        		
							            break;
							        case 3: // Exit
							            break;
							        default:
							            System.out.println("Invalid choice");
							            break;
							    }
							    break;
							case 6: // Manage Staff
							    System.out.println("+----------------------------------+");
							    System.out.println("|    1 --->  Add Staff             |");
							    System.out.println("|----------------------------------|");
							    System.out.println("|    2 --->  Update Staff          |");
							    System.out.println("|----------------------------------|");
							    System.out.println("|    3 --->  Delete Staff          |");
							    System.out.println("|----------------------------------|");
							    System.out.println("|    4 --->  View Staff            |");
							    System.out.println("|----------------------------------|");
							    System.out.println("|    4 --->      Exit              |");
							    System.out.println("+----------------------------------+");
							    System.out.print("Enter your choice: ");
							    int staffChoice = sc.nextInt();
							    sc.nextLine();
							    switch (staffChoice) {
							        case 1: // Add Staff
							        	System.out.print("Enter Staff Name: ");
							        	String names=sc.nextLine();
							        	System.out.print("Enter the role: ");
							        	String role=sc.nextLine();
							        	System.out.println("Enter Salary: ");
							        	double salary=sc.nextDouble();
							        	s.setStaffname(names);
							        	s.setRole(role);
							        	s.setSalary(salary);
							        	int re=s1.insert(s);
							        	if(re>0) {
							        		System.out.println("Staffs inserted Successfully");
							        	}else {
							        		System.out.println("Staffs insertion failed");
							        	}
							            break;
							        case 2: // Update Staff
							            System.out.print("Enter staff id you need to be updated: ");
							            int staffid=sc.nextInt();
							            System.out.print("Enter the role to be updated: ");
							            String srole=sc.next();
							            System.out.print("Enter the salary to be updated: ");
							            double ssalary=sc.nextDouble();
							            s.setStaff_id(staffid);
							            s.setRole(srole);
							            s.setSalary(ssalary);
							            int k=s1.update(s);
							            if(k>0) {
							            	System.out.println("Updated Succesfully");
							            }else {
							            	System.out.println("Updation Failed");
							            }
							            break;
							        case 3: // Delete Staff
							        	System.out.print("Enter staff id to be deleted: ");
							        	int sid=sc.nextInt();
							        	s.setStaff_id(sid);
							        	int p=s1.delete(s);
							        	if(p>0) {
							        		System.out.println("Staff deleted successfully");
							        	}else {
							        		System.out.println("Staff deletion failed");
							        	}
							            break;
							        case 4: 
							        	System.out.println("    List of Staffs   ");
							        	List<StaffDTO> staff=s1.getAll();
										for(StaffDTO staffs:staff) {
											System.out.println("+-------------------------+");
											System.out.println("Staff id:"+ staffs.getStaff_id());
											System.out.println("Staff Name:"+ staffs.getStaffname());
											System.out.println("Role:"+ staffs.getRole());
											System.out.println("Salary:"+ staffs.getSalary());
										}
							            break;
							        case 5:
							        	break;
							        default:
							            System.out.println("Invalid choice");
							            break;
							    }
							    break;

							case 7: // Manage Payments
							    System.out.println("+----------------------------------+");
							    System.out.println("|    1 --->  View Payments         |");
							    System.out.println("+----------------------------------+");
							    System.out.println("|    2 --->  Update Payment        |");
							    System.out.println("+----------------------------------+");
							    System.out.println("|    3 --->      Exit              |");
							    System.out.println("+----------------------------------+");
							    System.out.print("Enter your choice: ");
							    int paymentChoice = sc.nextInt();
							    switch (paymentChoice) {
							        case 1: // View Payments
							            // Implement logic to view payment records
							        	System.out.println("       List of Payments      ");
							        	List<PaymentDTO> payment = p1.getAll();
							            for(PaymentDTO payments : payment) {
							            	System.out.println("+-------------------------+");
							                System.out.println("Payment ID: " + payments.getPayment_id());
							                System.out.println("Order ID: " + payments.getOrder_id());
							                System.out.println("User Id: "+payments.getUser_id());
							                System.out.println("Status: " + payments.getStatus());
							            }
							            break;
							        case 2: // Update Payment
							            // Implement logic to update payment details
							        	System.out.print("Enter payement id: ");
							        	int pid=sc.nextInt();
							        	System.out.print("Change the status: ");
							        	String sts=sc.next();
							        	p.setPayment_id(pid);
							        	p.setStatus(sts);
							        	int l=p1.update(p);
							        	if(l>0) {
							        		System.out.println("Status updated Succesfully");
							        	}else {
							        		System.out.println("Status updation failed");
							        	}
							            break;
							        case 3: // Exit
							            break;
							        default:
							            System.out.println("Invalid choice");
							            break;
							    }
							    break;
							case 8:
								break;
						}
					}while(choice<=7);
				}
				else{
					System.out.println("Invalid Email and password");
					main(null);
				}
			}
			else {
					System.out.println("Email Doesn't Exist!!!");
					main(null);
				}
			}
	}
}
					
