/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.ums.delegate;

import com.tm.ums.delegate.impl.UserDelegateImpl;

/**
 *
 * @author Sohail Ahmad
 */
public class DelegateFactory {
    private static UserDelegate userDelegate;
    
    private DelegateFactory() {}

    public static UserDelegate getUserDelegate() {
        if(userDelegate == null)
            userDelegate = new UserDelegateImpl();
        return userDelegate;
    }
    
    
}
