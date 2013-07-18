/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.ums.delegate;

import com.tm.ums.model.User;

/**
 *
 * @author Sohail Ahmad
 */
public interface UserDelegate {
    
    public long createUser(User user);

    public User readUser(Long id);

    public int updateUser(User user);

    public int deleteUser(Long id);
}
