package DAO;

import java.sql.SQLException;
import java.util.List;

import Food.DTO.PaymentDTO;

public interface PaymentDAO {
	List<PaymentDTO> getAll() throws SQLException;
}
