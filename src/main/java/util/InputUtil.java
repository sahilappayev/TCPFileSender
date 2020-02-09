/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Scanner;

/**
 *
 * @author SahilAppayev
 */
public class InputUtil {
    public static String inportText(String value){
        Scanner sc = new Scanner(System.in);
        System.out.println(value);
        return sc.nextLine();
    }
    
    public static int inportNumber(String value){
        Scanner sc = new Scanner(System.in);
        System.out.println(value);
        return sc.nextInt();
    }
    
    public static void printSuccessMessage(){
        System.out.println("Operation completed successfully!");
    }
}
