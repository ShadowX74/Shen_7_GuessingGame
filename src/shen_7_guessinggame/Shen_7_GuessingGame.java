package shen_7_guessinggame;

import java.util.Scanner;
import java.util.Random;

public class Shen_7_GuessingGame {

    static int number;
    static String name;
    static int guess;
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();
    static int tries;
    static boolean again = true;
    static int maxTries;
    static int triesLeft;
    static String tryOrTries;
    static String tryOrTries2;
    
    public static void main(String[] args) {
        intro();
        while (again) {
            game();
            tries = 0;
        }
        exit();
    }
    
    private static void intro() {
        System.out.println("Hello, welcome to \"Guess That Number\"!!!");
        System.out.println("");
    }
    
    private static void game() {
        insertName();
        difficulty();
        makeANumber();
        guessNumber();
        playAgain();
    }
    
    private static void difficulty() {
        System.out.println("What difficulty would you like? (Easy/Medium/Hard)");
        String difficulty = scan.nextLine();
        switch (difficulty) {
            case "Easy":
                maxTries = 10;
                break;
            case "Medium":
                maxTries = 5;
                break;
            default:
                maxTries = 3;
                break;
        }
        System.out.println("You will have " + maxTries + " tries to guess a number between 1 and 100.");
    }
    
    private static void makeANumber() {
        number = rand.nextInt(100);
    }
    
    private static void insertName() {
        System.out.println("What is your name?");
        name = scan.nextLine();
    }
    
    private static void guessNumber() {
        System.out.println("Guess a number from 1 to 100");
        guess = scan.nextInt();
        checkNumber();
    }
    
    private static void checkNumber() {
        if (guess > number) {
            tries++;
            triesLeft = maxTries - tries;
            withinTries("high");
        } else if (guess < number) {
            tries++;
            triesLeft = maxTries - tries;
            withinTries("low");
        } else {
            tries++;
            tryOrTries();
            System.out.println("Good job " + name + "! It took you " + tries + " " +tryOrTries +"!");
        }
    }
    
    private static void withinTries(String highOrLow) {
        if (tries < maxTries) {
            tryOrTries2();
            System.out.println("Too " + highOrLow + ". You have " + triesLeft + " " + tryOrTries2 + " left, try again.");
            guessNumber();
        } else {
            System.out.println("You used up all of your tries! The number was " + number +"!");
        }
    }
    
    private static void playAgain() {
        System.out.println("Would you like to play again? (Y/N)");
        again = scan.next().contains("Y");
    }
    
    private static void exit() {
        System.out.println("Thank you for playing!");
    }
    
    private static void tryOrTries() {
        if (tries == 1) {
            tryOrTries = "try";
        } else {
            tryOrTries = "tries";
        }
    }
    
    private static void tryOrTries2() {
        if (triesLeft == 1) {
            tryOrTries2 = "try";
        } else {
            tryOrTries2 = "tries";
        }
    }
}