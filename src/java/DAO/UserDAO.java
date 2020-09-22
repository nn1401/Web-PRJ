/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DB.ConnectDB;
import Model.UserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author BIA
 */
public class UserDAO {

    static UserModel userModel;

    public static ArrayList<UserModel> getAll() {
        ArrayList<UserModel> list = new ArrayList();
        try {
            String sql = "Select * from UserTable";
            Connection conn = ConnectDB.getConnection();
            Statement sta = conn.createStatement();
            ResultSet rs = sta.executeQuery(sql);
            while (rs.next()) {
                int userID = rs.getInt(1);
                String userPass = rs.getString(2);
                String userName = rs.getString(3);
                String userGender = rs.getString(4);
                list.add(new UserModel(userID, userPass, userName, userGender));
            }
            conn.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean addUser(UserModel userModel) {
        try {
            Connection conn;
            conn = ConnectDB.getConnection();
            String sql = "Insert into UserTable(UserPass,UserName,UserGender) values (?, ?, ?)";
            PreparedStatement prs = conn.prepareStatement(sql);
            prs.setString(1, userModel.getUserPass());
            prs.setString(2, userModel.getUserName());
            prs.setString(3, userModel.getGender());
            prs.execute();
            conn.close();
            return true;
        } catch (Exception e) {
            System.out.println("Add failed!");
            e.printStackTrace();
        }
        return false;
    }
}
