package com.company.Shop.Dao;

import com.company.Shop.Model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {
    public static final Map<Integer , User> userMap = new HashMap<>();

    static {
        initUsers();
    }

    private static void initUsers(){
        User user1 = new User(1 , "Alex" , "Alex" , "123" , "Female" ,
                LocalDateTime.now());
        User user2 = new User(2 , "Lena" , "Lena" , "123" , "Female" ,
                LocalDateTime.now());
        User user3 = new User(3 , "Max" , "Max" , "123" , "Male" ,
                LocalDateTime.now());

        userMap.put(user1.getId(),user1);
        userMap.put(user2.getId(),user2);
        userMap.put(user3.getId(),user3);
    }

    public static User getUser(Integer id){
        return userMap.get(id);
    }

    public static User addUSer(User user){
        userMap.put(user.getId() , user);
        return user;
    }

    public static User updateUser(User user){
        userMap.put(user.getId() , user);
        return user;
    }

    public static void deleteUser(Integer id){
        userMap.remove(id);
    }

    public static List<User> getAllUsers(){
        return new ArrayList<>(userMap.values());
    }

//    public static boolean authorize(String login , String password){
//        for(User users : userMap.values()){
//            if(users.getLogin().equals(login) && users.getPassword().equals(password)){
//                return true;
//            }
//        }
//        return false;
//    }
}
