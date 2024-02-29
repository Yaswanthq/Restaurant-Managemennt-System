package Food;
import java.util.*;

import Connectivity.DBConnection;

import java.sql.*;
import DAO.CommonDAO;
import DAO.OrderDAO;
import Food.DTO.OrderDTO;
public class OrderDaoImpl implements OrderDAO{
    Connection connection=DBConnection.getConnection();
    public List<OrderDTO> getAll() throws SQLException {
        List<OrderDTO> userList1 = new ArrayList<>();
        String query = "SELECT * FROM orders";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
        	OrderDTO order = new OrderDTO();
            order.setOrder_id(resultSet.getInt("order_id"));
            order.setUser_id(resultSet.getInt("user_id"));
            order.setOrder_date(resultSet.getDate("order_date"));
            order.setOrder_time(resultSet.getTime("order_time"));
            userList1.add(order);
        }
        return userList1;
    }
   }
