

import javax.lang.model.element.Name;
import java.util.*;

/**
 * Represents a Digital Pet class
 */

public class DigitalPet {
    /**
     * Declare fields
     */
    private String name; // Represents the name of the pet
    private int happiness; //variable represents the happiness of the pet
    private int weight;    //variable represents the weight of the pet
    private int hunger;   //variable represents the hunger of the pet
    private int days;    //variable represents the days of the pet
    private int interactions; //variable represents the number of interactions the user made with pet
    private String stage; // Represents the life stage of the Pet
    private int dirtiness;//Represents the dirtiness level of the pet
    private int daysSick;// Represents the number of consecutive days the pet has been sick
    private boolean sick;// Represents whether the pet is currently sick or not
    private int medicineTaken;// Represents whether medicine has been administered to the pet (-1: not taken, 0: taken)
    private int vacationDays;//Represents the number of days the player has been on a vacation
    //A list to store daily care instructions during vacation
    private Queue<String> careInstructionQueue;
    private int maximumAge;//Represents the maximum the pet will be alive

    /**
     * Constructs a new DigitalPet with the specified name.
     * Initializes hunger, happiness, and weight with default values.
     *
     * @param name a name for the new DigitalPet
     */
    public DigitalPet(String name) {
        setName(name);//sets the name
        this.happiness = 5; //default happiness level
        this.weight = 5;    //default weight of pet
        this.hunger = 10;  //default hunger level
        this.days = 1;     // Initialize days to 0
        this.interactions = 0; //Initializes interactions to 0
        this.dirtiness = 0;//Intializes the dirtiness level to 0
        this.sick = false; // Initialize the 'sick' field to false, indicating the pet is not sick initially
        this.medicineTaken = -1; // Initialize the 'medicineTaken' field to -1, indicating medicine has not been administered for the current day
        this.vacationDays = 0;//Default to zero , indicates no vacation
        this.careInstructionQueue = new LinkedList<>();//Intialization of Array :List for care instructions
        this.stage = "infant";
        Random random = new Random(); // Create a Random object to generate random numbers
        // Generate a random age between 20 and 40 (inclusive) by creating a random integer
        // from 0 to 20 and then adding 20 to it
        this.maximumAge = random.nextInt(21) + 20;
        System.out.println(maximumAge + " is the random generated number"); //printing the random generated number
        System.out.println(name + " has just been hatched"); //printing that pet has been hatched
    }
    /**
     * Restarts the game with a new DigitalPet instance if the pet has died.
     * Prompts the user to decide whether to restart with a new pet or end the game.
     * If the user chooses to restart, initializes all relevant fields and prints a welcome message.
     * If the user chooses not to restart, the program exits.
     */
    public void restart() {
        Scanner kbd = new Scanner(System.in);
        // Prompt the user to restart or exit the game
        System.out.println("Your pet has died. Would you like to restart a new game with a new pet ? (yes/no)");
        String choice = kbd.nextLine().toLowerCase();
        // If the user chooses to restart
        if (choice.equals("yes")) {
            System.out.println("Enter new pet name for your pet");//prompt the user to enter the new name for the pet
            String newName=kbd.nextLine(); //reads the string data and stores it in scanner variable
            setName(newName); //sets the new name for the pet
            this.happiness = 5; // Reset happiness level to default
            this.weight = 5;    // Reset weight to default
            this.hunger = 10;   // Reset hunger to default
            this.days = 1;      // Reset day count to 1
            this.interactions = 0; // Reset interactions
            this.dirtiness = 0; // Reset dirtiness level
            this.sick = false; // Reset sick status
            this.medicineTaken = -1; // Reset medicine administration status
            this.vacationDays = 0; // Reset vacation days
            this.careInstructionQueue = new LinkedList<>(); // Reinitialize care instructions queue
            this.stage = "infant"; // Reset life stage to infant
            Random random = new Random();
            this.maximumAge = new Random().nextInt(21) + 20; // Generate a new maximum age
            System.out.println(maximumAge + "is the random generated number"); //printing the random generated number
            System.out.println(name + " has just been hatched"); // Notify the user that the new pet has hatched
        }
        else {
            // If the user chooses not to restart, exit the game
            System.out.println("Thanks for playing .. Bye!!!");
            System.exit(0); // Exit the program
        }
    }
    /**
     * Gets the name of the digital pet.
     *
     * @return the name of the digital pet
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the digital pet.
     *
     * @param newName the new name for the digital pet
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Checks the status of the pet, including happiness, weight, and hunger level.
     * Prints messages indicating the pet's happiness level and current weight and hunger level.
     * Increments the interactions count.
     * If the number of interactions reaches 5, ends the day.
     */
    public void checkPet() {
        if (this.happiness > 5) //checks the happiness level of the pet
        {
            System.out.println(name + " is very happy :D");
        } else {
            System.out.println(name + " is happy :)");
        }
        System.out.println(name + " weight is " + this.weight);
        System.out.println(name + " hunger level is " + this.hunger);
        System.out.println(name + " dirtiness level is " + this.dirtiness);

        this.interactions++;

        if (interactions >= 5) {
            Time(); //Ending the day after user had enough interactions with th pet
        }

    }

    /**
     * Feeds the pet with the specified type of food, adjusting happiness, weight, and hunger.
     *
     * @param foodType The type of food to feed the pet. Should be either "meal" or "snack".
     */
    public void feed(String foodType) {

        int happinessIncrease = 0; //stores the increase in happiness
        int weightIncrease = 0;
        int hungerDecrease = 0;  //Stores the decrease in the hunger

        //Adjust food effects based on life stage
        switch (stage.toLowerCase()) {
            case "infant":
                //Infant needs
                //stores the increase in happiness
                happinessIncrease = 4;
                //stores the decrease in hunger
                hungerDecrease = 3;
                //stores the increase in weight
                weightIncrease = 2;
                break;

            case "child":
                //Child needs
                //stores the increase in happiness
                happinessIncrease = 3;
                //stores the decrease in hunger
                hungerDecrease = 2;
                //stores the increase in weight
                weightIncrease = 1;

                break;
            case "adult":
                //Adult needs
                //stores the increase in happiness
                happinessIncrease = 5;
                //stores the decrease in hunger
                hungerDecrease = 4;
                //stores the increase in weight
                weightIncrease = 4;
                break;
            default:
                System.out.println("Invalid life stage:");
                break;
        }
        //Checks if the food type is meal
        if ("meal".equalsIgnoreCase(foodType)) {
            happinessIncrease += 1; //stores the increase in happiness
            hungerDecrease -= 1;
            weightIncrease += 1;
        }
        //Checks if the food type is snack
        else if ("snack".equalsIgnoreCase(foodType)) {
            happinessIncrease += 2;
            hungerDecrease -= 2;
            weightIncrease += 2;
        }
        //Checks if the food type is invalid
        else {
            System.out.println("Invalid food type. Please choose 'meal' or 'snack'.");
            return;
        }
        //Updates pet's happiness,weight and hunger based on food type
        this.happiness += happinessIncrease;
        // Ensure happiness doesn't go below 0
        this.happiness = Math.max(this.happiness, 0);
        this.hunger -= hungerDecrease;
        // Ensure hunger doesn't go below 0
        this.hunger = Math.max(this.hunger, 0);
        this.weight += weightIncrease;

        // Display message
        System.out.println("Yummy!");
        interactions++;
        // Incrementing interactions value each time after the pet is fed

        if (interactions >= 5) {
            Time();
        }
    }

    /**
     * Updates the hunger and happiness levels of the pet after feeding it with a specific food.
     * The hunger level is adjusted based on the hunger impact of the food, ensuring it doesn't exceed 100.
     * The happiness level is adjusted based on the happiness impact of the food, ensuring it doesn't exceed 100.
     *
     * @param food The food item fed to the pet.
     */

    public void UpdateLevels(Food food) {
        hunger = Math.min(hunger + food.getHungerImpact(), 100);
        //Calculates the new hunger level for the pet after feeding it with a specific food, considering hunger impact of the food.
        //Ensures that the hunger level doesn't exceed 100.
        happiness += food.getHappinessImpact();
        //Calculates the new happiness level for the pet after feeding it with a specific food, considering happiness effect of the food.
        //Ensures that the happiness level doesn't exceed 100
    }

    /**
     * Number-Guessing game for the pet
     * If the User choice matches the randomly generated computers choice,
     * The Pet's happiness is increased by 25  ; otherwise , happiness is decreased by 25.
     */
    public void playGame() {
// Variables to store changes in happiness and hunger
        int happinessIncrease = 0;
        int hungerIncrease = 0;
        int happinessDecrease = 0;
        //creating a Scanner object
        Scanner kbd = new Scanner(System.in);
        //Generating a random computer choice number between 1 -10
        int computerChoice = (int) (Math.random() * 10) + 1;
        // Asking the user to enter their choice
        System.out.println("Guess the number between 1 and 10");
        int userChoice;
        userChoice = kbd.nextInt();
        // Adjusting game effects based on life stage
        switch (stage.toLowerCase()) {
            case "infant":
                // Increase in happiness when the pet is in the infant stage
                happinessIncrease = 2;
                // Increase in hunger when the pet is in the infant stage
                hungerIncrease = 3;
                // Decrease in happiness when the pet is in the infant stage
                happinessDecrease = 3;
                break;
            case "child":
                // Increase in happiness when the pet is in the child stage
                happinessIncrease = 5;
                // Increase in hunger when the pet is in the child stage
                hungerIncrease = 2;
                // Decrease in happiness when the pet is in the child stage
                happinessDecrease = 5;
                break;
            case "adult":
                // Increase in happiness when the pet is in the adult stage
                happinessIncrease = 3;
                // Increase in hunger when the pet is in the adult stage
                hungerIncrease = 4;
                // Decrease in happiness when the pet is in the adult stage
                happinessDecrease = 2;
                break;
        }
//Checking if userChoice Matches the computerChoice
        if (userChoice == computerChoice) {
            //Display message to show that the user guess is correct and increase happiness
            System.out.println("Yayy! You guessed it Correctly ." + name + " is happier");
            happinessIncrease += 25; // Increases happiness by 25 if user wins
            hungerIncrease += 2; // Increase hunger by 2 if the user wins
            this.happiness += happinessIncrease; // Increase happiness based on game outcome
            this.happiness = Math.max(this.happiness, 0); // Ensure happiness doesn't go below 0
            this.hunger += hungerIncrease; // Increase hunger based on game outcome
            this.hunger = Math.max(this.hunger, 0); // Ensure hunger doesn't go below 0
            weight = weight - 2; //Decrease hunger by 2 if the user wins
            this.weight = Math.max(this.weight, 0); // Ensure weight doesn't go below 0

        } else {
//Display message that user guess is wrong and decrease happiness
            System.out.println("Oops! Wrong guess. " + name + " is not very happy!");
            happinessDecrease -= 25; //Decreases happiness by 25 if the user loses
            hungerIncrease += 2; //Decreases hunger by 2 if the user loses
            this.happiness += happinessDecrease; // Decrease happiness based on game outcome
            this.happiness = Math.max(this.happiness, 0); // Ensure happiness doesn't go below 0
            this.hunger += hungerIncrease; // Increase hunger based on game outcome
            this.hunger = Math.max(this.hunger, 0); // Ensure hunger doesn't go below 0
            weight -= 2; //Decreases weight by 2 if the user loses
            this.weight = Math.max(this.weight, 0); // Ensure weight doesn't go below 0
        }
        this.interactions++;//incrementing the interactions each time the user plays the game with the pet

//checking if the interactions have reached the maximum limit for the day
        if (this.interactions >= 5) {
            Time(); //method call

        }
    }


    /**
     * Ending the current day for the pet
     * Resets the interactions for the new day
     */

    public void Time() {

        System.out.println("Day " + days + " has ended..See You Tomorrow!!!");

        days++; // Progresses to the next day
        interactions = 0;//Resets interactions for the new day
        //update pet's hunger  based on days
        hunger += 3;
        //update pet's  happiness based on days
        happiness -= 3;
        //updates the dirtiness level of the pet over the time
        this.dirtiness += 1;

        medicineTaken = -1; // Reset medicineTaken  for the new day
        passDay(); // Update pet's status and check for sickness


    }


    /**
     * Ends the current day early as per user's choice
     * Increments the day count and resets interactions for the new day
     */
    public void endDayEarly() {


        System.out.println("day " + days + " has ended as per your wish .. see you tomorrow!!!");

        days++; //Progresses to the next day
        interactions = 0; //Resets interactions for the new day
        // Adjust pet's hunger, happiness, and dirtiness levels for the new day
        hunger += 3;
        happiness -= 3;
        dirtiness += 1;

        medicineTaken = -1; // Reset medicineTaken  for the new day

        passDay(); // Update pet's status and check for sickness


    }


    /**
     * Updates the life stage of the pet based on the number of days passed.
     * Sets the stage variable to "infant" if days are less than or equal to 10,
     * "child" if days are between 11 and 20, and "adult" otherwise.
     * Prints a message indicating the current stage of the pet.
     */
    public void updateLife() {
        // Check if the number of days is within the infant stage
        if (days <= 10) {
            stage = "infant";
            System.out.println("Stage of " + name + " is : " + stage);
        } else if (days >= 11 && days <= 15) {
            // Check if the number of days is within the child stage
            stage = "child";
            System.out.println("Stage of " + name + " is : " + stage);
        } else {
            // Otherwise, the pet is in the adult stage
            stage = "adult";
            System.out.println("Stage of " + name + " is :" + stage);
        }
    }

    /**
     * Cleans the pet, resets dirtiness to 0.
     */
    public void clean() {
        this.dirtiness = 0; //Resets the ditiness level to 0 indicating the pet is clean
        System.out.println(name + "  has been cleaned"); //Display message
    }

    /**
     * checking for sickness based on dirtiness level and calculates the sickness Levels .
     */
    public void passDay() {
        double chancesofGettingSick = dirtiness * 0.1; // Each point of dirtiness adds 10% chance of getting sick
        // Check if pet gets sick
        if (Math.random() < chancesofGettingSick) // Calculate chance of getting sick based on dirtiness level
        {
            sick = true; //if pet is sick
            daysSick++; //counts the number of days the pet has been sick
        } else {
            sick = false;
            daysSick = 0;
        }
        if (sick) {
            //checks whether the pet is sick
            System.out.println(name + " is sick"); //Displays the message
            //If the pet is sick for consecutive five days , it dies
            if (daysSick >= 5) {
                System.out.println("Sorry , " + name + " died as it has been sick for too long ");
                restart(); //restarts the game
            }
        } else {
            System.out.println(name + " is not sick");
            //sick = false ,If pet is not sick

        }


    }

    /**
     * Administers medicine to the pet if it is sick and medicine hasn't been taken yet on the current day.
     * If medicine is administered, the pet's dirtiness level is reduced by 50%.
     * If medicine has already been taken on the current day, informs the user that medicine can only be administered once per day.
     */
    public void administerMedicine() {
        double cureProbability = 0.5;
// Check if the pet is sick and medicine hasn't been taken yet on the current day
        // generate a random number - if it's less than 0.5 then the medicine cures the pet, otherwise it remains sick
        // variable `sick` will always be equal to true
        if (sick && medicineTaken == -1) {
            if (Math.random() < cureProbability) {
                System.out.println(name + " has taken the medicine..It is cured  ");
                //sick = false;
                medicineTaken = 0;
            }
            //The pet has been given the medicine , but it is not cured yet
            else {
                System.out.println(name + " has taken the medicine , but it didn't get cured and it is still sick");
            }


        } else {
            // Inform the user that medicine can only be administered once per day
            System.out.println("Sorry...You can administer a dose of medicine only once per day");
        }
    }

    /**
     * Returns the number of vacation days for the pet.
     *
     * @return the number of days the pet owner is on vacation.
     */
    public int getVacationDays() {
        return vacationDays;
    }

    /**
     * Returns the list of care instructions during the owner's vacation.
     *
     * @return a list of care instructions for each day of the vacation.
     */
    public Queue<String> getCareInstructions() {
        return careInstructionQueue;
    }

    /**
     * Sets the list of care instructions to be followed during the owner's vacation.
     *
     * @param careInstructionQueue a list of daily care instructions for the pet during the vacation.
     */
    public void setCareInstructions(Queue<String> careInstructionQueue) {
        this.careInstructionQueue = careInstructionQueue;

    }

    /**
     * Starts a vacation and prompts the user for care instructions for each day.
     * This method validates the duration of the vacation and collects care instructions.
     */

    public void goOnVacation() {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        // Read the duration
        System.out.println("How many days will you be on vacation? (1-5)");
        int vacationDuration = scanner.nextInt();
        // Validate the vacation duration
        if (vacationDuration < 1 || vacationDuration > 5) {
            System.out.println("Invalid vacation duration. Please choose between 1 and 5 days.");
            return;
        }
        // Clear any existing care instructions
        careInstructionQueue.clear();
        scanner.nextLine();
        // Loop to collect care instructions for each day
        for (int i = 0; i < vacationDuration; i++) {
            System.out.println("Enter care instructions for day " + (i + 1) + ":");
            System.out.println("Enter the commands in a single line -Valid Commands: feed meal, feed snack, play, administer medicine, clean");
            String instructions = scanner.nextLine();// Read the user's input
            // Split the instructions and add them to the queue
            String[] commands = instructions.split(", ");
            // Add each command to the care instructions queue
            for (String command : commands) {
                careInstructionQueue.offer(command.trim()); //Trim to remove extra spaces
            }
            // Add "next-day" command at the end of each day's instructions
            careInstructionQueue.offer("next-day");
        }
        System.out.println("You're on vacation. Enjoy your time away!");
        simulateVacation();// Simulate the care during vacation
    }

    /**
     * Simulates the care of the pet while the player is on vacation based on the care instructions.
     * * If the pet dies during the vacation due to sickness, informs the player.
     */
    public void simulateVacation() {
        // Process care instructions until the instruction queue is empty
        while (!careInstructionQueue.isEmpty()) {
            // Retrieve the next instruction from the queue
            String instruction = careInstructionQueue.poll();
            // Process the instruction based on the switch case
            switch (instruction) {
                // Feed the pet with a meal
                case "feed meal":
                    feed(instruction.split(" ")[1]);
                    System.out.println(name + "has been fed a meal...");
                    break;
                case "feed snack":
                    // Feed the pet with a snack
                    feed(instruction.split(" ")[1]);
                    System.out.println(name + "has been fed a snack...");
                    break;
                case "play":
                    // Play a game with the pet
                    playGame();
                    break;
                case "administer medicine":
                    // Administer medicine if the pet is sick
                    if (sick == true) {
                        administerMedicine();
                    }
                    break;
                case "clean":
                    // Clean the pet
                    clean();
                    break;
                case "next-day":
                    // End the current day
                    Time();
                    break;
                default:
                    // Handle invalid care instructions
                    System.out.println("Invalid care instruction: " + instruction);
                    break;
            }
            if(daysSick>=5)
            {
                System.out.println("Pet die when you are on vacation");
            }
        }
        System.out.println("Your vacation is completed .. welcome back !");
    }
    /**
     * This method checks if an entity (like a person or an object) is close to reaching its maximum age.
     * If the entity has fewer than 5 days left before reaching the maximum age, a warning message is displayed.
     *  If the entity has passed its maximum age, a message is displayed indicating that the entity has died,
     *  * and the program is terminated.
     */
    public void handleMaximumAge() {
        // If the entity has fewer than 5 days left before reaching the maximum age, display a warning message
        if (maximumAge - days < 5) {
            // Display a message indicating that the entity is approaching the end of its lifespan
            System.out.println(name + " is getting very old and doesn't have much time left.");
        }
        if (days>maximumAge) {
            // If the number of days exceeds the maximum age, the entity has died
            System.out.println(name + " has died of old age. Thank you for taking care of them.");
            restart(); //restarts the game again
        }

    }
}



