package services;

import java.util.ArrayList;

public class UserServices {
    private static DBConnection database = new DBConnection();

    private static ArrayList<Users> users = database.getAll();
    

    private static UserServices list = new UserServices();

    public static UserServices getList() {
        return list;
    }

    public static int addUser(Users newUser) {
        newUser.setId(DBConnection.save(newUser));
        users.add(newUser);
        return newUser.getId();
    }

    public static ArrayList<Users> getAll() {
        return users;
    }

    public static Users findUser(String e_mail, String password) {
        for (Users u : users) {
            if (e_mail.equals(u.getE_mail()) && (password.equals(u.getPass()))) {
                return u;
            }
        }
        return null;
    }



}
