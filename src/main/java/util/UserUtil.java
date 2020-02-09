/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import bean.User;

/**
 *
 * @author SahilAppayev
 */
public class UserUtil {

    public static User requireUserInputs() {
        String name = InputUtil.inportText("Enter name:");
        String surname = InputUtil.inportText("Enter surname:");
        return new User(name, surname);
    }

    public static void userConfirmation() {

        for (int i = 0; i < 3; i++) {
            User user = requireUserInputs();
            if ("Sahil".equals(user.getName()) && "Appayev".equals(user.getSurname())) {
                InputUtil.printSuccessMessage();
                break;
            } else if (i == 2) {
                System.out.println("Invalid name or surname. You banned!");
                System.exit(0);
            } else {
                System.out.println("Invalid name or surname. Try it again!");
            }
        }
    }
}
