package DAO;
import java.sql.SQLException;
import java.util.List;
import Food.DTO.OrderDTO;
import Food.DTO.OrderedItemsDTO;
public interface OrderedItemsDAO {
	List<OrderedItemsDTO> getPeakedOrder() throws SQLException;	
	double getTotal(OrderedItemsDTO items) throws Exception;
}
