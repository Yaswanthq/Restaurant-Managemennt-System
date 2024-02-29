package Food;
import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import Connectivity.DBConnection;
import DAO.*;
import Food.DTO.ReservationDTO;
import Food.DTO.UserDTO;
public class ReservationDaoImpl implements CommonDAO<ReservationDTO>{
    Connection connection=DBConnection.getConnection();
    public List<ReservationDTO> getAll() throws SQLException {
        List<ReservationDTO> reservationlist = new ArrayList<>();
        String query = "SELECT * FROM reservation";
        PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	ReservationDTO reservation = new ReservationDTO();
                 reservation.setReservation_id(resultSet.getInt("reservation_id"));
                 reservation.setTable_id(resultSet.getInt("table_id"));
                 reservation.setDate(resultSet.getDate("reservation_date"));
                 reservation.setTime(resultSet.getString("reservation_time"));
                 reservation.setUser_id(resultSet.getInt("user_id"));
                 reservationlist.add(reservation);
            }
        return reservationlist;
    }
	public int insert(ReservationDTO reservation) throws SQLException {
		 Date currentDate = new Date(System.currentTimeMillis()); // Get the current date
		    if (reservation.getDate().before(currentDate)) {
		        throw new SQLException("Cannot insert reservation with a past date.");
		    }
        String sql = "INSERT INTO reservation (table_id, reservation_date, reservation_time,user_id) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, reservation.getTable_id());
        java.util.Date utilDate = reservation.getDate();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        statement.setDate(2, sqlDate);
        statement.setString(3, reservation.getTime());
        statement.setInt(4, reservation.getUser_id());
        return statement.executeUpdate();
    }
	public int delete(ReservationDTO reservation) throws SQLException{
		String sql = "DELETE INTO reservation WHERE table_id=?";
	    PreparedStatement statement = connection.prepareStatement(sql);
	    statement.setInt(1,reservation.getTable_id());
	    return statement.executeUpdate();		
    }
}
