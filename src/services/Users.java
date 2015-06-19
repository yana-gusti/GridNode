/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;


public class Users {

	public Integer id;
	public String first_name;
	public String last_name;
	public String vo;
	public String username;

	public String pass;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getVO() {
		return vo;
	}

	public void setVO(String birthday) {
		this.vo = birthday;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String e_mail) {
		this.username = e_mail;
	}



	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Users(Integer id, String first_name, String last_name,
			 String vo, String username,  String pass) {
		this.id=id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.vo = vo;
		this.username =username;
		this.pass = pass;

	}

}
