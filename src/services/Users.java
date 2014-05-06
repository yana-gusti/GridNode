/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;


public class Users {

	public Integer id;
	public String first_name;
	public String last_name;
	public String birthday;
	public String e_mail;

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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}



	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Users(Integer id, String first_name, String last_name,
			 String birthday, String e_mail,  String pass) {
		this.id=id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.birthday = birthday;
		this.e_mail =e_mail;
		this.pass = pass;

	}

}
