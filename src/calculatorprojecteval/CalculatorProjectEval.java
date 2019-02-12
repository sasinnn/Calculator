/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorprojecteval;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author gudisas19
 */
public class CalculatorProjectEval {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
         
         startCalc();
    }

   

    public static void startCalc() {

        System.out.println("Sasin");
        System.out.println("Calculator Project");
        System.out.println("");
        calcEnter();
    }

    public static String calculate(String s) {
        String result = "";
        int parts = countParts(s);
        /* goes to countParts() method and determines whether the input has
                                                two or three parts and then has if and else statements move the user
                                                to the next part. if there are 2 parts, it calls the evalTwo() method
                                                if there are three parts, it calls the evalThree() method. Anything else
                                                will print an Error. */
        if (parts == 2) {
            result = evalTwo(s);
        } else if (parts == 3) {
            result = evalThree(s);
            // } else if (parts == 5) {
            //  evalFive(str1);
        } else {
            if ((s.toLowerCase()).equals("quit")) {
                result = "quit";
            } else {
                result = "ERROR";
            }
        }
        return result;
    }

    public static void calcEnter() {
        Scanner in = new Scanner(System.in); //Opens input for user to be ready to continue to the next parts.
        System.out.println("Welcome!");
        System.out.println("Enter 'help' to learn which operators you can use");
        System.out.println("Enter ‘quit’ to quit the program");
        System.out.println("Enter 'continue' if you want to continue");
        /* Gives the user three options to choose from. 
                Help will show them all the operators I have included in my code.
                    As seen throughout the code, the user will always have the option to use 
                    this function to make the program easier for them.
                Quit will quit the program.
                Continue will prompt the user to another console to input their equation
                    (if they know what the operators are already. */

        String str1;
        boolean run = true;
        /* Helps with Quit option, because it will keep the program running
                            unless the user inputs quit, which makes the boolean false
                            ending the run loop and quits the Calculator */

        while (run) {
            System.out.println("");
            System.out.println("Enter 'help', 'continue' or 'quit'");
            // System.out.println("Please enter a space between your operator and the number!");
            System.out.print("> ");
            str1 = in.nextLine();
            if ((str1.toLowerCase()).equals("help")) { //if the user types this, they are shown all the options
                System.out.println("___________________"); //line break
                System.out.println("Two Parts:"); //splits the functions into two and three parts.
                System.out.println("\tAbsolute Value: |");
                System.out.println("\tRound: r");
                System.out.println("\tSquare Root: V");
                System.out.println("\tSine: s");
                System.out.println("\tCosine: c");
                System.out.println("\tTangent: t");
                System.out.println("Three Parts:");
                System.out.println("\tAddition: +");
                System.out.println("\tSubtraction: -");
                System.out.println("\tMultiplication: *");
                System.out.println("\tDivision: /");
                System.out.println("\tRemainder: %");
                System.out.println("\tPower: ^");
                System.out.println("___________________");
                //System.out.println("\n");
                //calcEnter();
            } else if ((str1.toLowerCase()).equals("continue")) { // if the user types this (no spaces, case insensitive)
                System.out.println("\nOk. Let's move on!");
                System.out.println("Enter an equation:");
                System.out.println("Please enter spaces between your each operator and number.");
               
                System.out.print("> ");
                str1 = in.nextLine(); //scanner
                System.out.println(calculate(str1));
            } else if ((str1.toLowerCase()).equals("quit")) {
                run = false;
                calculate(str1);
                System.out.println("Have a good day!");
                System.exit(0);
            } else {
                System.out.println("Please re-enter one of the options.");
                //calcEnter();
            }

        }

    }

    public static int countParts(String str1) {
        Scanner sc = new Scanner(str1);
        int parts = 0;
        while (sc.hasNext()) {
            parts++;
            sc.next();
        }
        return parts;
    }

    public static String evalTwo(String str1) {
        Scanner on = new Scanner(str1);
        String str2 = "";
        double A = 0;

        if (on.hasNext()) {
            str2 = on.next();
        } else {
            return "ERROR";
            // return;
        }
        if (on.hasNextDouble()) {
            A = on.nextDouble();
        } else {
            return "ERROR";
            // return;
        }

        if ((str2.toLowerCase()).equals("v")) {
            double a = Math.sqrt(A);
            return a + "";
        } else if (str2.equals("s")) {
            double a = Math.sin(A);
            return a + "";
        } else if (str2.equals("c")) {
            double a = Math.cos(A);
            return a + "";
        } else if (str2.equals("t")) {
            double a = Math.tan(A);
            return a + "";
        } else if (str2.equals("|")) {
            double a = Math.abs(A);
            return a + "";
        } else if (str2.equals("~")) {
            double a = Math.round(A);
            return a + "";
        } else if (str2.equals("at")) {
            if (A != 0) {
                return Math.atan(A) + "";
            } else {
                return "ERROR";
            }
        } else if (str2.equals("as")) {
            if (A > -1 && A < 1) {
                return (Math.asin(A)) + "";
            } else {
                return "ERROR";
            }
        } else if (str2.equals("ac")) {
            if (A > -1 && A < 1) {
                return (Math.acos(A)) + "";
            } else {
                return "ERROR";
            }
        } else {
            return "ERROR";
        }

    }

    public static String evalThree(String str1) {
        Scanner on = new Scanner(str1);
        double one;
        String str2;
        double two;
        if (on.hasNextDouble()) {
            one = on.nextDouble();
        } else {
            return "ERROR";
        }

        if (on.hasNext()) {
            str2 = on.next();
        } else {
            return "ERROR";
        }

        if (on.hasNextDouble()) {
            two = on.nextDouble();;
        } else {
            return "ERROR";
        }

        if (str2.equals("+")) {
            return (one + two) + "";
        } else if (str2.equals("-")) {
            return (one - two) + "";
        } else if (str2.equals("*")) {
            return (one * two) + "";
        } else if (str2.equals("/")) {
            return (one / two) + "";
        } else if (str2.equals("%")) {
            return (one % two) + "";
        } else if (str2.equals("^")) {
            return (Math.pow(one, two)) + "";
        } else {
            return "ERROR";
        }
    }
}