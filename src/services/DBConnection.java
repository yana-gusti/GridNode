/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import Pages.LoginPage;
import java.sql.*;
import java.util.ArrayList;


public class DBConnection implements Interface<Users> {
        public static String table = "user_table" ;

	private final String connectionUrl = "jdbc:mysql://0.0.0.0/users?user=root&password=1";

	private static Connection connection;

	public DBConnection() {

		try {
            Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(connectionUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Users> getAll() {

		ArrayList<Users> array = new ArrayList<Users>();
		Statement stmt = null;
		ResultSet rs = null;
		String SQL = "SELECT * FROM "+table;

		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				Users tmpUser = new Users(null, rs.getString("first_name"),
						rs.getString("last_name"), 
						rs.getString("birthday"), rs.getString("e_mail"), rs.getString("pass"));
				tmpUser.setId(rs.getInt("id"));
				array.add(tmpUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return array;
	}

	public static int save(Users user) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int id =1;
		String insertSQL = "INSERT INTO "+table+" ("+table+".first_name, "+table+".last_name, "+table+".birthday, "+table+".e_mail,  "+table+".pass) VALUES('"
				+ user.getFirst_name()
				+ "', '"
				+ user.getLast_name()
				+ "', '"
				+ user.getBirthday()
				+ "', '"
				+ user.getE_mail()
				+ "', '"
				+ user.getPass() + "')";

		try {
			stmt = connection.prepareStatement(insertSQL,
					Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();

			if (rs != null && rs.next()) {
				id = rs.getInt(id);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
	}

	public static ArrayList<Users> getUser(Users user) {

		ArrayList<Users> arrayUsers = new ArrayList<Users>();
		Statement stmt = null;
		ResultSet rs = null;
		String SQL = "SELECT * FROM "+table+" WHERE e_mail = '"
				+ user.getE_mail() + "'";
		System.out.println(SQL);
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				user = new Users(null, rs.getString("first_name"),
						rs.getString("last_name"), 
						rs.getString("birthday"), rs.getString("e_mail"),
						 rs.getString("pass"));
				user.setId(rs.getInt("id"));
				arrayUsers.add(user);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrayUsers;

	}

	public static ArrayList<Tasks> getAllUserTasks() {
		ArrayList<Tasks> arrayTasks = new ArrayList<Tasks>();

		
		Statement stmt = null;
		ResultSet rs = null;
		
		String selectSQL = "SELECT * FROM "+table+" WHERE e_mail LIKE '"+LoginPage.user.getE_mail()+"'";
		try {
			
			stmt = connection.createStatement();
			rs = stmt.executeQuery(selectSQL);

			while (rs.next()){

			Tasks task = new Tasks( rs.getString("e_mail"),
					rs.getString("task_name"), rs.getString("date"),
					rs.getString("description"), rs.getString("condition"));
			task.setId(rs.getInt("id"));
			arrayTasks.add(task);
			
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		return arrayTasks;
	}

	public static int saveTask(Tasks task) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int id =1;
		String insertSQL = "INSERT INTO "+table+" ("+table+".e_mail, "+table+".task_name, "+table+".date, "+table+".description, "+table+".condition) VALUES('"

				+ LoginPage.user.getE_mail()
				+ "', '"
				+ task.getTask_name()
				+ "', '"
				+ task.getDate()
				+ "', '"
				+ task.getDescription()
				+ "', '"
				+ task.getCondition() + "')";
		try {
			stmt = connection.prepareStatement(insertSQL,
					Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();

			if (rs != null && rs.next()) {
				id = rs.getInt(id);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
	}

	public static ArrayList<Tasks> getActiveTasks() {
	
		ArrayList<Tasks> arrayTasks = new ArrayList<Tasks>();
		Statement stmt = null;
		ResultSet rs = null;
		String selectSQL = "SELECT * FROM "+table+" WHERE e_mail LIKE '"+LoginPage.user.getE_mail()+"' AND `condition`= 'active'";
		try {


			stmt = connection.createStatement();
			rs = stmt.executeQuery(selectSQL);

			while (rs.next()){

			Tasks task = new Tasks( rs.getString("e_mail"),
					rs.getString("task_name"), rs.getString("date"),
					rs.getString("description"), rs.getString("condition"));
			task.setId(rs.getInt("id"));
			arrayTasks.add(task);
			
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		return arrayTasks;
	}

	public static ArrayList<Tasks> getCompletedTasks() {
		ArrayList<Tasks> arrayTasks = new ArrayList<Tasks>();
		Statement stmt = null;
		ResultSet rs = null;
		String selectSQL = "SELECT * FROM "+table+" WHERE e_mail LIKE '"+LoginPage.user.getE_mail()+"' AND `condition`= 'completed'";

		try {

			stmt = connection.createStatement();
			rs = stmt.executeQuery(selectSQL);

			while (rs.next()){

			Tasks task = new Tasks( rs.getString("e_mail"),
					rs.getString("task_name"), rs.getString("date"),
					rs.getString("description"), rs.getString("condition"));
			task.setId(rs.getInt("id"));
			arrayTasks.add(task);
			
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}

	
		return arrayTasks;
	}

	public boolean delete(Users user) {
		PreparedStatement stmt = null;

		try {

			String insertSQL = "DELETE FROM "+table+" WHERE e_mail = '"
					+ user.getE_mail() + "';";
			stmt = connection.prepareStatement(insertSQL,
					Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static boolean deleteTask1(Tasks task) {
		PreparedStatement stmt = null;

		try {

			String deleteSQL = "DELETE FROM "+table+" WHERE task_name = '"
					+ task.getTask_name() + "';";
			stmt = connection.prepareStatement(deleteSQL,
					Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public ArrayList<Tasks> getTasksByTask_Name(String n, String t) {
		// TODO Auto-generated method stub
		return null;
	}


}
