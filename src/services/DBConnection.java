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
        public static String table = "user_table" ;

	public static String connectionUrl = "jdbc:mysql://0.0.0.0/users?user=root&password=1";

	public static Connection connection;

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
				+ user.getVO()
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

	

	
	public boolean delete(Users user) {

		PreparedStatement stmt = null;

		try {

			String insertSQL = "DELETE FROM "+table+" WHERE e_mail = '"
					+ user.getE_mail() + "';";
			stmt = connection.prepareStatement(insertSQL,
					Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();
                try {
                
                stmt.close();
                connection.close();
                } catch (SQLException ex) {
                        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
                        
			return true;
     
                
            } catch (Exception e) {
			e.printStackTrace();
			return false;
        }
        }
	

	public static void flushTable() {

		PreparedStatement stmt = null;

		try {

			String deleteSQL = "flush tables "+table+";";
			stmt = connection.prepareStatement(deleteSQL,
					Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();
			

		} catch (Exception e) {
			e.printStackTrace();
			
		}


	}



	

}
