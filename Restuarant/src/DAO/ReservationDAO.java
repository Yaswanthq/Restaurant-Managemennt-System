package DAO;
import java.sql.SQLException;
import java.util.List;

import Food.DTO.ReservationDTO;

public interface ReservationDAO {
	List<ReservationDTO> getAll() throws SQLException;
}
