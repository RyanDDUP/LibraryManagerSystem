package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.BookType;
import util.StringUtil;

/**
 * BookType Dao
 * 
 * @author RZ
 *
 */
public class BookTypeDao {

	/**
	 * add book type
	 * 
	 */
	public int add(Connection conn, BookType bookType) throws Exception {
		String sqls = "SELECT bookTypeName from t_booktype where bookTypeName=?";
		PreparedStatement pstmt1 = conn.prepareStatement(sqls);
		pstmt1.setString(1, bookType.getBookTypeName());
		ResultSet resultSet = pstmt1.executeQuery();
		if (resultSet.next()) {
			if (bookType.getBookTypeName().equals(resultSet.getString("bookTypeName"))) {
				return -1;
			}

		}

		String sql = "INSERT INTO t_bookType VALUES(null,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());

		return pstmt.executeUpdate();
	}
	
	public ResultSet list(Connection conn, BookType bookType) throws SQLException {
		StringBuffer sql = new StringBuffer("Select * from t_bookType");
		if(StringUtil.isNotEmpty(bookType.getBookTypeName())) {
			
			sql.append("and bookTypeName like '%'"+bookType.getBookTypeName()+"'%'");
		}
		PreparedStatement pstmt =conn.prepareStatement(sql.toString().replaceFirst("and", "Where"));
		return pstmt.executeQuery();
	}
}
