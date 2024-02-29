package Food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connectivity.DBConnection;
import DAO.CommonDAO;
import Food.DTO.PaymentDTO;
import Food.DTO.StaffDTO;

public class PaymentDaoImpl implements CommonDAO<PaymentDTO>{
    Connection connection=DBConnection.getConnection();
    public List<PaymentDTO> getAll() throws SQLException {
        List<PaymentDTO> paymentlist = new ArrayList<>();
        String query = "SELECT * FROM payment";
        PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	PaymentDTO payment = new PaymentDTO();
                 payment.setPayment_id(resultSet.getInt("payment_id"));
                 payment.setOrder_id(resultSet.getInt("order_id"));
                 payment.setUser_id(resultSet.getInt("user_id"));
                 payment.setStatus(resultSet.getString("status"));
                 paymentlist.add(payment);
            }
        return paymentlist;
    }
    public int update(PaymentDTO payment) throws Exception{
  	  String sql="UPDATE payment SET status=? WHERE payment_id=?";
	      PreparedStatement statement = connection.prepareStatement(sql);
	      statement.setString(1,payment.getStatus());
	      statement.setInt(2, payment.getPayment_id());
	      return statement.executeUpdate();	
    }
	public int insert(PaymentDTO payment) throws SQLException {
		// TODO Auto-generated method stub
		 String sql="INSERT into payment (order_id,user_id,status)VALUES(?,?,?)";
		 PreparedStatement statement = connection.prepareStatement(sql);
		 statement.setInt(1, payment.getOrder_id());
		 statement.setInt(2,payment.getUser_id());
		 statement.setString(3, payment.getStatus());
		 return statement.executeUpdate();
	}
	@Override
	public int delete(PaymentDTO t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
