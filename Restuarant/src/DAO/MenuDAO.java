package DAO;
import java.sql.SQLException;
import java.util.List;
import Food.DTO.MenuDTO;
public interface MenuDAO {
	List<MenuDTO> getAll() throws SQLException;
	int update(MenuDTO menu) throws Exception;
}
