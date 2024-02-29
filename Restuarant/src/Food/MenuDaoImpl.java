package Food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connectivity.DBConnection;
import DAO.CommonDAO;
import Food.DTO.FeedBackDTO;
import Food.DTO.MenuDTO;

public class MenuDaoImpl implements CommonDAO<MenuDTO>{
    Connection connection=DBConnection.getConnection();
    public List<MenuDTO> getAll() throws SQLException {
        List<MenuDTO> menulist = new ArrayList<>();
        String query = "SELECT * FROM items";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
        	MenuDTO menu = new MenuDTO();
            menu.setItem_id(resultSet.getInt("item_id"));
            menu.setItem_name(resultSet.getString("item_name"));
            menu.setPrice(resultSet.getDouble("price"));
            menu.setAvailability(resultSet.getBoolean("availability"));
            menulist.add(menu);
        }
        return menulist;
    }
    public int insert(MenuDTO menu) throws SQLException{
    	  String sql = "INSERT INTO items (item_name, price, availability) VALUES ( ? ,? ,?)";
          PreparedStatement statement = connection.prepareStatement(sql);
          statement.setString(1, menu.getItem_name());
          statement.setDouble(2, menu.getPrice());
          statement.setBoolean(3, menu.getAvailability());
          return statement.executeUpdate();
      }
      public int delete(MenuDTO menu) throws SQLException{
  		String sql = "DELETE INTO items WHERE item_id=?";
  	    PreparedStatement statement = connection.prepareStatement(sql);
  	    statement.setInt(1,menu.getItem_id());
  	    return statement.executeUpdate();		
  	}
      public int update(MenuDTO menu) throws Exception{
    	  String sql="UPDATE items SET item_name=?,price=?,availability=? WHERE item_id=?";
  	      PreparedStatement statement = connection.prepareStatement(sql);
  	      statement.setInt(1, menu.getItem_id());
  	      statement.setString(2,menu.getItem_name());
  	      statement.setDouble(3, menu.getPrice());
  	      statement.setBoolean(4, menu.getAvailability());
  	    return statement.executeUpdate();	
    	  
    	  
      }
}
