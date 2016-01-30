package dao;

import java.sql.Connection;

import model.User;
import util.DB_util;

public class DaoTest {

	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		DB_util dbUtil = new DB_util();
		
		Connection conn =dbUtil.getConn();
		User user = new User("admin", "admin1");
		
		try {
			User currentUser = userDao.login(conn, user);
			if (currentUser ==null) {
				System.out.println("null");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
