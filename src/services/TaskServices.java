package services;

import java.util.ArrayList;
import java.util.List;


public class TaskServices {
	  private static ArrayList<Tasks> tasks = DBConnection.getAllUserTasks();
	    private static ArrayList<Tasks> active_tasks = DBConnection.getActiveTasks();
	    private static ArrayList<Tasks> completed_tasks = DBConnection.getCompletedTasks();

	    private static ArrayList<Tasks> new_tasks = new ArrayList<Tasks>();
	    private static TaskServices list = new TaskServices();

	    public static TaskServices getList() {
	        return list ;
	    }

	    public static void add(Tasks newTask) {
	        newTask.setId(DBConnection.saveTask(newTask));
	        tasks.add(newTask);
	        new_tasks.add(newTask);
	    }



	    public static List<Tasks> getAll() {
	        return tasks;
	    }

	    public static List<Tasks> getAllActive() {
	        return active_tasks;
	    }

	    public static List<Tasks> getAllCompleted() {
	        return completed_tasks;
	    }

	    public static ArrayList<Tasks> getUserTasks() {
	        return new_tasks;
	    }

	   
	     public static Tasks findTask(String task_name) {
	            for (Tasks t : tasks) {
	                if (task_name.equals(t.getTask_name())) {
	                    return t;
	                }
	            }
	            return null;
	     }     
	   	  public static Tasks findTaskByUserId(String task_name) {
		            for (Tasks t : tasks) {
		                if (task_name.equals(t.getTask_name())) {
		                    return t;
		                }
		            }
		            return null;


	    }
	    }
