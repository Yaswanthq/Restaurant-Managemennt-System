package DAO;
import java.sql.SQLException;
import java.util.List;
import DAO.CommonDAO;
import Food.DTO.UserDTO;
public interface UserDAO extends CommonDAO<UserDTO>{
	UserDTO getByEmailAndPassword(String email, String password) throws SQLException;
	int insert(UserDTO user1) throws SQLException;
	List<UserDTO> getAll() throws SQLException;
}