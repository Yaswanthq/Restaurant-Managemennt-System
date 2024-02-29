package Food;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Connectivity.DBConnection;
import DAO.CommonDAO;
import DAO.TableDAO;
import Food.DTO.FeedBackDTO;
import Food.DTO.TableDTO;
	public class TableDaoImpl implements CommonDAO<TableDTO>{
	    Connection connection=DBConnection.getConnection();
	    public List<TableDTO> getAll() throws SQLException {
	        List<TableDTO> tablelist = new ArrayList<>();
	        String query = "SELECT * FROM tables";
	        PreparedStatement statement = connection.prepareStatement(query);
	            ResultSet resultSet = statement.executeQuery();
	            while (resultSet.next()) {
	            	TableDTO table = new TableDTO();
	                table.setT_id(resultSet.getInt("table_id"));
	                table.setT_number(resultSet.getInt("table_number"));
	                table.setCapacity(resultSet.getInt("capacity"));
	                table.setAvail(resultSet.getBoolean("availability"));
	                tablelist.add(table);
	            }
	        return tablelist;
	    }
	    public int insert (TableDTO table) throws SQLException{
	    	   String sql = "INSERT INTO tables (table_number, capacity,availability) VALUES (?, ?, ?)";
	           PreparedStatement statement = connection.prepareStatement(sql);
	           statement.setInt(1, table.getT_number());
	           statement.setInt(2, table.getCapacity());
	           statement.setBoolean(3, table.getAvail());
	           return statement.executeUpdate();
	    	
	    }
	    public int delete (TableDTO table) throws SQLException{
	    	   String sql = "DELETE FROM tables WHERE table_id=?";
	           PreparedStatement statement = connection.prepareStatement(sql);
	           statement.setInt(1, table.getT_id());
	           return statement.executeUpdate();	
	    }
	    public int update(TableDTO table) throws SQLException{
			String sql = "UPDATE FROM tables WHERE table_id=?";
		    PreparedStatement statement = connection.prepareStatement(sql);
		    statement.setInt(1,table.getT_id());
		    return statement.executeUpdate();		
		}
	    
	}
