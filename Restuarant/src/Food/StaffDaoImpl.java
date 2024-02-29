package Food;
import java.util.*;

import Connectivity.DBConnection;

import java.sql.*;
import java.sql.Date;

import DAO.CommonDAO;
import Food.DTO.MenuDTO;
import Food.DTO.ReservationDTO;
import Food.DTO.StaffDTO;
public class StaffDaoImpl implements CommonDAO<StaffDTO>{
    Connection connection=DBConnection.getConnection();
	    public List<StaffDTO> getAll() throws SQLException {
	        List<StaffDTO> stafflist = new ArrayList<>();
	        String query = "SELECT * FROM staffs";
	        PreparedStatement statement = connection.prepareStatement(query);
	            ResultSet resultSet = statement.executeQuery();
	            while (resultSet.next()) {
	            	StaffDTO staff = new StaffDTO();
	                staff.setStaff_id(resultSet.getInt("staff_id"));
	                staff.setStaffname(resultSet.getString("name"));
	                staff.setRole(resultSet.getString("role"));
	                staff.setSalary(resultSet.getDouble("salary"));
	                stafflist.add(staff);
	            }
	        return stafflist;
	    }
		@Override
		public int insert(StaffDTO staff) throws SQLException {
			// TODO Auto-generated method stub
		        String sql = "INSERT INTO staffs (name, role, salary) VALUES (?, ?, ?)";
		        PreparedStatement statement = connection.prepareStatement(sql);
		        statement.setString(1, staff.getStaffname());
		        statement.setString(2, staff.getRole());
		        statement.setDouble(3, staff.getSalary());
		        return statement.executeUpdate();
		}
		@Override
		public int delete(StaffDTO staff) throws SQLException {
			// TODO Auto-generated method stub
				String sql = "DELETE INTO staffs WHERE staff_id=?";
			    PreparedStatement statement = connection.prepareStatement(sql);
			    statement.setInt(1,staff.getStaff_id());
			    return statement.executeUpdate();		
		}
	   public int update(StaffDTO staff) throws Exception{
    	  String sql="UPDATE staffs SET name=?,role=?,salary=? WHERE staff_id=?";
  	      PreparedStatement statement = connection.prepareStatement(sql);
  	      statement.setInt(1, staff.getStaff_id());
  	      statement.setString(2,staff.getStaffname());
  	      statement.setString(3, staff.getRole());
  	      statement.setDouble(4, staff.getSalary());
  	      return statement.executeUpdate();	
      }
	}
