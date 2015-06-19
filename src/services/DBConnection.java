/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnection implements Interface<Users> {
        public static String table = "users" ;
		public static Connection connection=null;



	public ArrayList<Users> getAll() {
		try {
			String userName = "root";
			String password = "1";

			String url = "jdbc:mysql://localhost:3306/gridnode";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url, userName, password);
			connection.getClientInfo();
			System.out.println("Database connection established");
		} catch (Exception e) {
			System.err.println("Cannot connect to database server");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		ArrayList<Users> array = new ArrayList<Users>();
		Statement stmt = null;
		ResultSet rs = null;
		String SQL = "SELECT * FROM "+table+";";

		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				Users tmpUser = new Users(null, rs.getString("first_name"),
						rs.getString("last_name"), 
						rs.getString("vo"), rs.getString("username"), rs.getString("pass"));
				tmpUser.setId(rs.getInt("id"));
				array.add(tmpUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (connection != null) {
				try {
					connection.close();
					System.out.println("Database Connection Terminated");
				} catch (Exception e) {}
			}
		}
		return array;
	}

	public static int save(Users user) {
		try {
			String userName = "root";
			String password = "1";

			String url = "jdbc:mysql://localhost:3306/gridnode";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url, userName, password);
			connection.getClientInfo();
			System.out.println("Database connection established");
		} catch (Exception e) {
			System.err.println("Cannot connect to database server");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		PreparedStatement stmt = null;
		ResultSet rs = null;
		int id =1;
		String insertSQL = "INSERT INTO "+table+" ("+table+".first_name, "+table+".last_name, "+table+".vo, "+table+".username,  "+table+".pass) VALUES('"
				+ user.getFirst_name()
				+ "', '"
				+ user.getLast_name()
				+ "', '"
				+ user.getVO()
				+ "', '"
				+ user.getUserName()
				+ "', '"
				+ user.getPass() + "');";

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
		}finally {
			if (connection != null) {
				try {
					connection.close();
					System.out.println("Database Connection Terminated");
				} catch (Exception e) {}
			}
		}
		return id;

                
	}

	public static ArrayList<Users> getUser(Users user) {
		try {
			String userName = "root";
			String password = "1";

			String url = "jdbc:mysql://localhost:3306/gridnode";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url, userName, password);
			connection.getClientInfo();
			System.out.println("Database connection established");
		} catch (Exception e) {
			System.err.println("Cannot connect to database server");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		ArrayList<Users> arrayUsers = new ArrayList<Users>();
		Statement stmt = null;
		ResultSet rs = null;
		String SQL = "SELECT * FROM "+table+" WHERE username = '"
				+ user.getUserName() + "';";
		System.out.println(SQL);
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				user = new Users(null, rs.getString("first_name"),
						rs.getString("last_name"), 
						rs.getString("vo"), rs.getString("username"),
						 rs.getString("pass"));
				user.setId(rs.getInt("id"));
				arrayUsers.add(user);
                               
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (connection != null) {
				try {
					connection.close();
					System.out.println("Database Connection Terminated");
				} catch (Exception e) {}
			}
		}
		return arrayUsers;

	}

	

	
	public boolean delete(Users user) {
		try {
			String userName = "root";
			String password = "1";

			String url = "jdbc:mysql://localhost:3306/gridnode";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url, userName, password);
			connection.getClientInfo();
			System.out.println("Database connection established");
		} catch (Exception e) {
			System.err.println("Cannot connect to database server");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		PreparedStatement stmt = null;

		try {

			String insertSQL = "DELETE FROM "+table+" WHERE username = '"
					+ user.getUserName() + "';";
			stmt = connection.prepareStatement(insertSQL,
					Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();
                try {
                
                stmt.close();
                connection.close();
                } catch (SQLException ex) {
                        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                }finally {
					if (connection != null) {
						try {
							connection.close();
							System.out.println("Database Connection Terminated");
						} catch (Exception e) {}
					}
				}
			return true;
     
                
            } catch (Exception e) {
			e.printStackTrace();
			return false;
        }
        }
	

	public static void flushTable() {
		try {
			String userName = "root";
			String password = "1";

			String url = "jdbc:mysql://localhost:3306/gridnode";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url, userName, password);
			connection.getClientInfo();
			System.out.println("Database connection established");
		} catch (Exception e) {
			System.err.println("Cannot connect to database server");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		PreparedStatement stmt = null;

		try {

			String deleteSQL = "flush tables "+table+";";
			stmt = connection.prepareStatement(deleteSQL,
					Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			if (connection != null) {
				try {
					connection.close();
					System.out.println("Database Connection Terminated");
				} catch (Exception e) {}
			}
		}


	}



	

}
