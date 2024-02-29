package Food;
import java.util.*;

import Connectivity.DBConnection;
import DAO.CommonDAO;
import DAO.UserDAO;
import Food.DTO.UserDTO;
import java.sql.*;
public class UserDaoImpl implements UserDAO{
    public UserDaoImpl() {
		super();
	}
    Connection connection=DBConnection.getConnection();
	public int insert(UserDTO user) throws SQLException {
    	String role="user";
        String sql = "INSERT INTO user (username, email, password, phone_number, role) VALUES (?, ?, ?, ?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getEmail());
        statement.setString(3, user.getPassword());
        statement.setString(4, user.getNumber());
        statement.setString(5, role);
        return statement.executeUpdate();
    }

    public UserDTO getByEmailAndPassword(String email, String password) throws SQLException {
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        UserDTO user=new UserDTO();
        while (resultSet.next()) {
            user.setUser_id(resultSet.getInt("user_id"));
            user.setUsername(resultSet.getString("username"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setNumber(resultSet.getString("phone_number"));
            user.setRole(resultSet.getString("role"));
        }
        return user;
    }
    
    public List<UserDTO> getAll() throws SQLException {
        List<UserDTO> userList = new ArrayList<>();
        String query = "SELECT * FROM user";
        PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	UserDTO user = new UserDTO();
            	user.setUser_id(resultSet.getInt("user_id"));
            	user.setUsername(resultSet.getString("username"));
            	user.setEmail(resultSet.getString("email"));
            	user.setPassword(resultSet.getString("password"));
            	user.setNumber(resultSet.getString("phone_number"));
            	user.setRole(resultSet.getString("role"));
                userList.add(user);
            }
        return userList;
    }

	@Override
	public int delete(UserDTO t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
