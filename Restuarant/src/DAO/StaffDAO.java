package DAO;
import java.sql.SQLException;
import java.util.List;
import Food.DTO.StaffDTO;
	
public interface StaffDAO {
	List<StaffDTO> getAll() throws SQLException;	
}
