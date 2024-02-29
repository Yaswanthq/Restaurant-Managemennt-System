package DAO;
import java.sql.SQLException;
import java.util.List;
import Food.DTO.TableDTO;
public interface TableDAO {
	List<TableDTO> getAll() throws SQLException;
}
