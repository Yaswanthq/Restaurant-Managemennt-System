package Food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DAO.CommonDAO;
import Food.DTO.FeedBackDTO;
import Food.DTO.OrderedItemsDTO;
import Connectivity.DBConnection;
public class FeedBackDaoImpl implements CommonDAO<FeedBackDTO>{
    Connection connection=DBConnection.getConnection();
    public List<FeedBackDTO> getAll() throws SQLException {
        List<FeedBackDTO> feedbacklist = new ArrayList<>();
        String query = "SELECT * FROM feedback";
        Connection connection=DBConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	 FeedBackDTO feedback = new FeedBackDTO();
                 feedback.setUser_id(resultSet.getInt("user_id"));
                 feedback.setFeedback(resultSet.getString("feedback"));
                 feedback.setRatings(resultSet.getInt("ratings"));
                 feedback.setFeedback_id(resultSet.getInt("feedback_id"));
                 feedbacklist.add(feedback);
            }
        return feedbacklist;
    }
    public int insert(FeedBackDTO feedback) throws SQLException{
  	  String sql = "INSERT INTO feedback (user_id, feedback, ratings) VALUES ( ? ,? ,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, feedback.getUser_id());
        statement.setString(2, feedback.getFeedback());
        statement.setInt(3, feedback.getRatings());
        return statement.executeUpdate();
    }
    public int delete(FeedBackDTO feedback) throws SQLException{
		String sql = "DELETE FROM feedback WHERE feedback_id=?";
	    PreparedStatement statement = connection.prepareStatement(sql);
	    statement.setInt(1,feedback.getFeedback_id());
	    return statement.executeUpdate();		
	}
}
