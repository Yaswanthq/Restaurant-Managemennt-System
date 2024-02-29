package Food;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connectivity.DBConnection;
import DAO.CommonDAO;
import Food.DTO.OrderDTO;
import Food.DTO.OrderedItemsDTO;
import Food.DTO.ReservationDTO;

public class OrdereditemsDaoImpl implements CommonDAO<OrderedItemsDTO>{
    Connection connection=DBConnection.getConnection();
    public List<OrderedItemsDTO> getAll() throws SQLException {
        List<OrderedItemsDTO> ordereditemslist = new ArrayList<>();
        String query = "SELECT * FROM ordereditems";
        PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	OrderedItemsDTO item = new OrderedItemsDTO();
            	item.setOrdered_id(resultSet.getInt("ordered_item_id"));
                 item.setItem_id(resultSet.getInt("item_id"));
                 item.setItem_name(resultSet.getString("item_name"));
                 item.setQuantity(resultSet.getInt("quantity"));
                 item.setPrice(resultSet.getDouble("price"));
                 ordereditemslist.add(item);
            }
        return ordereditemslist;
    }
    public int insert(OrderedItemsDTO item) throws SQLException{
    	  String sql = "INSERT INTO ordereditems (item_id, item_name,quantity,price) VALUES (?, ?, ?, ?)";
          PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
          statement.setInt(1, item.getItem_id());
          String itemNameQuery = "SELECT item_name FROM items WHERE item_id = ?";
          PreparedStatement itemNameStatement = connection.prepareStatement(itemNameQuery);
          itemNameStatement.setInt(1, item.getItem_id());
          ResultSet itemNameResultSet = itemNameStatement.executeQuery();
          if (itemNameResultSet.next()) {
              String itemName = itemNameResultSet.getString("item_name");
              statement.setString(2, itemName); 
          }
          statement.setInt(3, item.getQuantity());
          statement.setDouble(4, item.getPrice());
          int rowsAffected = statement.executeUpdate();
          
          // Retrieve generated keys
          ResultSet generatedKeys = statement.getGeneratedKeys();
          if (generatedKeys.next()) {
              // Get the generated order ID
              int orderId = generatedKeys.getInt(1);
              item.setOrdered_id(orderId); // Set the order ID in the DTO
          }
          
          return rowsAffected;
      }
    public int delete(OrderedItemsDTO item) throws SQLException{
		String sql = "DELETE FROM ordereditems WHERE ordered_item_id=?";
	    PreparedStatement statement = connection.prepareStatement(sql);
	    statement.setInt(1,item.getOrdered_id());
	    return statement.executeUpdate();		
	}
    public List<OrderedItemsDTO> getPeakedOrder() throws Exception {
        List<OrderedItemsDTO> ordereditemslist = new ArrayList<>();
        String sql = "SELECT items.item_name AS item_name, SUM(ordereditems.quantity) AS total_sold FROM items INNER JOIN ordereditems ON items.item_id = ordereditems.item_id GROUP BY items.item_id, items.item_name ORDER BY total_sold DESC";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            OrderedItemsDTO item = new OrderedItemsDTO();
            item.setItem_name(resultSet.getString("item_name"));
            // Retrieve the quantity using the alias "total_sold"
            item.setQuantity(resultSet.getInt("total_sold"));
            ordereditemslist.add(item);
        }
        return ordereditemslist;
    }
    public double getTotal(OrderedItemsDTO items) throws Exception{
    	    double totalPrice = 0;
    	    String query = "SELECT price FROM items WHERE item_id = ?";
    	    PreparedStatement pst = connection.prepareStatement(query);
    	    pst.setInt(1, items.getItem_id());
    	    ResultSet rs = pst.executeQuery();
    	    if (rs.next()) {
    	        double price = rs.getDouble("price");
    	        int quantity = items.getQuantity();
    	        totalPrice = price * quantity;
    	    } 
    	    return totalPrice;

    }
}
