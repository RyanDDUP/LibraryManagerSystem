package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import model.Book;

/**
 * Book Dao
 * @author RZ
 *
 */
public class BookDao {
	
	/**
	 * book add;
	 * @param conn
	 * @param book
	 * @return
	 * @throws SQLException 
	 */
	public int add(Connection conn, Book book) throws SQLException {
		String sql="insert into t_book values(?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setFloat(4, book.getPrice());
		pstmt.setInt(5, book.getBookTypeId());
		pstmt.setString(6, book.getBookDesc());
		return pstmt.executeUpdate();
		
	}
}
