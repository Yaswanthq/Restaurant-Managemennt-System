package DAO;
import java.sql.SQLException;
import java.util.List;
import Food.DTO.OrderDTO;
public interface OrderDAO {
		List<OrderDTO> getAll() throws SQLException;	
}
