
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * This class represents the game driver for the Tamagotchi game.
 * It allows users to interact with their digital pet by checking its status, feeding it, playing games, and ending the day early.
 */
public class GameDriver {
    /**
     * The main method that runs the Tamagotchi game.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println("!!!WELCOME  TO  TAMAGOTCHI GAME !!!");
        // Scanner for user input
        Scanner kbd = new Scanner(System.in);
        // Prompt user to enter pet name
        System.out.println("Enter the name of your Pet");
        String petName = kbd.nextLine();
        System.out.println("You named your pet as " + petName);
        // Create a new DigitalPet instance
        DigitalPet mypet = new DigitalPet(petName);
        boolean quit = false;
        //Game loop
        do {
            // Display menu options
            System.out.println("Valid commands are :\n 1. Check on " + petName + "  \n 2. Feed " + petName + "  \n 3. Play with " + petName + " \n 4. End the day early\n 5.Clean " + petName + "\n 6.Would you like to administer the medicine? \n 7.Go on vacation \n 8.Quit");

            System.out.println("What do you want to do for " + petName + "?");
            int choice = kbd.nextInt();
            // Handle user's choice

            switch (choice) {
                case 1:
                    // Check on pet's status
                    mypet.checkPet();
                    // Update the life stage of the pet based on the number of days
                    mypet.updateLife();

                    break;

                case 2:
                    // Feed the pet
                    System.out.println("Do you want to feed it a meal or a snack?");
                    //prompts the user to choose between feeding the pet a meal or a snack

                    String foodType = kbd.next();
                    //Reads the user input for the food type(meal or snack)
                    Food food = new Food(foodType);
                    //Create a new Food object based on the user's choice
                    mypet.feed(food.getFoodType());
                    mypet.UpdateLevels(food);

                    break;

                case 3:
                    // Play a game with the pet
                    mypet.playGame();

                    break;

                case 4:
                    // End the day early
                    mypet.endDayEarly();

                    break;


                case 5:
                    //cleans the pet as per user's choice
                    mypet.clean();
                    break;

                case 6://Gives the medicine to the pet , when it is sick
                    mypet.administerMedicine();
                    break;

                case 7: // Go on vacation
                    mypet.goOnVacation();

                case 8: // Quit the game
                    System.out.println("Thank you for playing!!!!");
                    quit = true;
                    break;

            }
            mypet.handleMaximumAge();//calls the method and gives the warning for pet's maximum life and informs the player that pet died
        }while (!quit) ;// Continue the loop until the user chooses to quit



    }
}