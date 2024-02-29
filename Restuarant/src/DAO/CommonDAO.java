package DAO;
import java.sql.SQLException;
import java.util.List;

import Food.DTO.UserDTO;
public interface CommonDAO <T> 
	{
		List<T> getAll() throws SQLException;
		int insert(T t) throws SQLException;
//		int update(T t,String update) throws SQLException;
		int delete(T t) throws SQLException;
	}
