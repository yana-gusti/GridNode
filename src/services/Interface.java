package services;

import java.util.ArrayList;


public interface Interface <users> {

    public ArrayList<Users> getAll();

//    public int save(users object);
    
    public boolean delete(users object);

//    public int saveTask(Tasks object);

//    public boolean deleteTask(Integer object);



    public ArrayList<Tasks> getTasksByTask_Name(String n, String t);




}