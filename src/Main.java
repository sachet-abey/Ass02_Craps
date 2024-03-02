import java.util.Random; // Import Random from Java
import java.util.Scanner; // Import Scanner from Java
public class Main {
    public static void main(String[] args) {
        Random rnd = new Random(); // Create a new Random object called rnd
        Scanner scan = new Scanner(System.in); // Create a scanner to read user input
        boolean playing = true; // Initialize playing variable for the while loop which is true when the user is still playing
        while(playing) { // While playing is true (the user is playing)
            int die1 = rnd.nextInt(6) + 1; // First die: roll a number from 1 to 6, inclusive
            int die2 = rnd.nextInt(6) + 1; // Second die: roll a number from 1 to 6, inclusive
            int crapsRoll = die1 + die2; // Take the sum of the two dice rolled, resulting in a number from 2 to 12, inclusive
            boolean done = false; // Initialize done variable for the do-while loop. This is set to true when the user enters a valid input
            System.out.println("The two dice roll and have a sum of "+crapsRoll); // Tell user the craps roll (the sum of the two dice)
            if(crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) { // If the craps roll is 2, 3, or 12
                System.out.println("You crapped out! You lose!"); // The player craps out or loses
            }
            else if(crapsRoll == 7 || crapsRoll == 11) { // If the craps roll is 7 or 11
                System.out.println("You got a natural! You win!"); // The player gets a natural and wins
            }
            else { // Otherwise
                int point = crapsRoll; // The craps roll is set as the point
                System.out.println("The point is "+point); // Tells user the point
                while(!done) { // While user is still trying for point
                    die1 = rnd.nextInt(6) + 1; // First die: roll a number from 1 to 6, inclusive
                    die2 = rnd.nextInt(6) + 1; // Second die: roll a number from 1 to 6, inclusive
                    crapsRoll = die1 + die2; // Take the sum of the two dice rolled, resulting in a number from 2 to 12, inclusive
                    System.out.println("The two dice roll and have a sum of " + crapsRoll); // Tell user the craps roll (the sum of the two dice)
                    if (crapsRoll == point) { // If the craps roll is equal to the point
                        System.out.println("You matched the point! You win!"); // The player wins
                        done = true; // Set done to true because we are done, so we don't need to loop (user won, not trying for point anymore)
                    }
                    else if (crapsRoll == 7) { // If the craps roll is equal to 7
                        System.out.println("You rolled a 7! You lose!"); // The player loses
                        done = true; // Set done to true because we are done, so we don't need to loop (user lost, not trying for point anymore)
                    }
                    else { // Otherwise (user didn't match the point so loop continues)
                        System.out.println("You didn't match the point! The two dice will be rolled again."); // The player doesn't win nor lose. The two dice will be rolled again. Loop continues
                    }
                }
            }
            done = false; // Set done to false for the next do-while loop
            do {
                System.out.println("Would you like to continue playing? [Y/N]"); // Prompts user if they would like to continue playing
                String response = scan.nextLine(); // Read user input as string
                if(response.equalsIgnoreCase("Y")) { // If user enters Y (yes), ignoring case
                    done = true; // Set done to true to continue the outer while loop - user continues playing because they entered yes
                }
                else if(response.equalsIgnoreCase("N")) { // If user enters N (no), ignoring case
                    playing = false; // Terminate outer while loop by setting playing to false
                    done = true; // Set done to true - no more looping needed
                }
                else { // Otherwise (user entered a valid input)
                    System.out.println("You entered "+response+". Please enter a valid input!"); // Tells user what they entered and asks user to enter a valid input
                }
            }
            while (!done); // Keeps looping when done is false (done becomes true when user enters a valid input)
        }
    }
}
