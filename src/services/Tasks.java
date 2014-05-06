/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;



public class Tasks {

   
	public Integer id;
	public String login;
	public String task_name;
	public String date;
	public String description;
	public String condition;



   
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
    public Tasks( String login, String task_name, String date, String description, String condition){
        this.login = login;
        this.task_name = task_name;
        this.date = date;
        this.description = description;
        this.condition = condition;
        
    }
}
