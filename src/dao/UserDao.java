package dao;
/*
 * user dao calss
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

public class UserDao {
	
	/*
	 * login verification
	 */
	
	public User login(Connection conn, User user) throws Exception{
		User resultUser = null;
		String sql = "SELECT * FROM t_user WHERE userName=? and password=?";
		PreparedStatement pstms = conn.prepareStatement(sql);
		pstms.setString(1, user.getUserName());
		pstms.setString(2, user.getPassword());
		ResultSet rst = pstms.executeQuery();
		if (rst.next()) {
			 resultUser = new User(); 
			 resultUser.setId(rst.getInt("id"));
			 resultUser.setUserName(rst.getString("userName"));
			 resultUser.setPassword(rst.getString("password"));
		}
		return resultUser; 
	}
}
