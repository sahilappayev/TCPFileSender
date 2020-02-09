/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import util.TCPUtil;
import util.UserUtil;

/**
 *
 * @author SahilAppayev
 */
public class Main {

    public static void main(String[] args) {
        UserUtil.userConfirmation();
        TCPUtil.requireSendingAddress();
        
        
    }
  
}
