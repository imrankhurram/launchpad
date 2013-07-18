/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.ums.delegate.impl;

import com.tm.ums.delegate.UserDelegate;
import com.tm.ums.model.User;
import com.tm.ums.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDelegateImpl implements UserDelegate {

    @Override
    public long createUser(User user) {
        Connection con = ConnectionFactory.getConnection();

        if (con == null) {
            throw new RuntimeException("Can't get database connection");
        }
        int effectedRows = 0;
        try(PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO USER(first_name, last_name, email, password) VALUES(?, ?, ?, ?)");) {
            
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            
            effectedRows = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDelegateImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return effectedRows;
    }

    @Override
    public User readUser(Long id) {

        Connection con = ConnectionFactory.getConnection();

        if (con == null) {
            throw new RuntimeException("Can't get database connection");
        }
        User user = null;
        try(PreparedStatement ps = con.prepareStatement(
                    "SELECT u.id, u.first_name, u.last_name, u.email, u.password FROM USER u where u.id = ?");) {
            
            ps.setLong(1, id);

            //get user data from database
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                user = new User();
                user.setId(result.getLong("id"));
                user.setFirstName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDelegateImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public int updateUser(User user) {
        Connection con = ConnectionFactory.getConnection();

        if (con == null) {
            throw new RuntimeException("Can't get database connection");
        }
        int effectedRows = 0;
        try(PreparedStatement ps = con.prepareStatement(
                    "UPDATE USER U set u.first_name=?, u.last_name=?, u.email=?, u.password=? where u.id = ?");) {
            
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setLong(5, user.getId());

            //get user data from database
            effectedRows = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDelegateImpl.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return effectedRows;
    }

    @Override
    public int deleteUser(Long id) {
        Connection con = ConnectionFactory.getConnection();

        if (con == null) {
            throw new RuntimeException("Can't get database connection");
        }
        int effectedRows = 0;
        try(PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM USER WHERE id = ?");) {
            
            ps.setLong(1, id);
            effectedRows = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDelegateImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return effectedRows;
    }
}
