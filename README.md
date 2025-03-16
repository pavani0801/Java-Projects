

                       WELCOME  TO  TAMAGOTCHI 
## Building the game:
To build the Digital Pet program , you need to have Java installed on your system.
-->Download and Install IntelliJ IDEA:
-->Clone the repository to the local machine.
## Running the game:
-->Navigate to the Project Directory
-->Compile the java class
-->Execute the GameDriver class

Tamagotchi is a fun game where you can interact with a virtual pet. The game has the following actions:
## How the game works

The `Food` class models different types of food for the digital pet, storing hunger and happiness impacts.
Its constructor initializes the food type. Methods `getFoodType()`, `getHungerImpact()`, and `getHappinessImpact()`
retrieve food type, hunger impact, and happiness impact, respectively. This class encapsulates food-related attributes
and behaviors for managing the pet's well-being.

hungerImpact: Represents how much the food reduces the pet's hunger.
foodType: A string that indicates the type of food (e.g., "meal" or "snack").
happinessImpact: Represents how much the food affects the pet's happiness. A higher value indicates a greater increase
in happiness.
Constructor:
- public Food(String foodType): This constructor initializes a new Food object with the specified food type. 
- It takes a string parameter representing the type of food and sets the foodType field accordingly.
- public String getFoodType(): This method returns the type of food for the pet. It retrieves the value stored in the 
- foodType field and returns it as a string.
- public int getHungerImpact(): This method returns the impact of the pet's food on its hunger level. It retrieves the
- value stored in the hungerImpact field and returns it as an integer.
- public int getHappinessImpact(): This method returns the impact of the pet's food on its happiness level. 
- It retrieves the value stored in the happinessImpact field and returns it as an integer.
  Getter Methods:
  getFoodType(): Returns the foodType field, indicating what type of food this object represents.
  getHungerImpact(): Returns the hungerImpact field, showing how much this food affects the pet's hunger.
  getHappinessImpact(): Returns the happinessImpact field, indicating how much the food impacts the pet's happiness.

DigitalPet Class: This class represents the digital pet itself. It has fields to store the pet's name, happiness,
weight, hunger, days, interactions, life stage, dirtiness level, sickness status, and whether medicine has been taken.
Methods are provided to initialize the pet, check its status, feed it, play games, pass the day, clean it, update its
life stage, and administer medicine.

##Methods: in Digital Pet

checkPet():- This method evaluates and displays the current state of the pet , including it's happiness , weight , hunger
and dirtiness level of the pet.
keeps a count of interactions and if the interactions reaches 5 per day , control jumps to Time() to end the current day.

feed(String foodType):-
initializes variables to store happiness, weight, and hunger adjustments based on the pet's life stage.
Adjusts food effects using a switch-case statement based on the pet's life stage.
Modifies happiness, hunger, and weight based on the food type ("meal" or "snack").
Displays "Yummy!" message after adjustments and increments interaction count.
Calls Time() method to end the day if interactions reach or exceed 5.

playGame():-
IT's a fun game , where the user gets to know the happiness level of the pet.
Initializes variables to store changes in happiness, hunger, and the outcome of the game.
Generates a random computer choice between 1 and 10 and prompts the user to guess a number.
Adjusts game effects based on the pet's life stage using a switch-case statement.
Compares the user's choice with the computer's choice and updates pet attributes accordingly.
Increments the interaction count and ends the day if interactions reach the maximum limit.
Provides feedback messages to the user based on the outcome of their guess.

Time():- The Time() method simulates the passage of time for the digital pet, marking the end of the current day and
preparing for the next one.
For the next day , it increases hunger and decreases happiness , increases dirtiness indicating that these values change
over a period of time.
Increments the days variable to the next consecutive day.Then control
calls the passDay() method to check for sickness level of the pet at the end of the day.

endDayEarly():- The endDayEarly() method concludes the current day for the digital pet, advancing to the next day and
resetting interaction counts. It adjusts the pet's hunger, happiness, and dirtiness levels for the new day and resets
the medicine status. Finally, it updates the pet's status and checks for sickness before ending the method.

updateLife():- The updateLife() method determines the life stage of the digital pet based on the number of days since
its creation. It assigns the appropriate life stage ('infant', 'child', or 'adult') and prints a message indicating
the current stage. This method will keep a track of pet's lifecycle changes over the period of time .

clean():-The `clean()` method resets the dirtiness level of the pet to 0, indicating cleanliness. It prints a message
confirming that the pet has been cleaned.

passDay(): Checks the pet's sickness status based on its dirtiness level.
If the sickness is for too long not cured , the pet dies .
If the pet is dead, the player automatically exits from the game.

administerMedicine()
This method is used to administer medicine to the pet . If the pet is sick and checks whether the pet has not been given
medicine on the current day , If these conditions turn out to be true then control comes in and checks the condition
if(Math.random < 0.5) cureProbability=0.5 , if it is true medicine is given and get's cured .In the else block , the pet
will still be given a dose of medicine , but it won't work, or it doesn't get cured. The outer else block states that
the medicine can only be given once per day.

updateLevel() :- ensures that the pet's happiness , hunger doesn't exceed the maximum value i.e 100.

getVacationDays() :- The getVacationDays() method is a getter that returns the current count of vacation days for a 
digital pet

getCareInstructions():- returns the set of instructions present in the Queue.

setCareInstructions(Queue<String> careInstructionQueue):- Sets the care of instructions into the queue for each day 
while the player is away.


goOnVacation():- Asks the player , how many days will the player be on a vacation . The maximum number of days the
player can be away is from 1- 5 days.Reads the player input and stores it in vacationDays.If the player chooses to go on
vacation for more than 5 days , the program says invalid.Before leaving for the vacation the player must give the set of 
instructions for each day. The given set of instructions will be store in a Queue of Linked List.
This methods invokes simulateVacation(); which consists of set of instructions and their respective operations.

simualateVacation():- The simulateVacation() method processes a queue of care instructions to simulate caring for a 
digital pet while the player is on vacation. It uses a loop to retrieve and execute each instruction, with a switch 
statement to determine the appropriate action (like feeding, cleaning, or playing with the pet). The loop continues 
until all instructions are processed, handling valid and invalid commands accordingly. Once finished, the method 
indicates that the vacation has ended, allowing gameplay to resume. This structure helps simulate the care of the pet 
when the player isn't actively participating, ensuring continuity in the game's flow.


The handleMaximumAge():-  method checks if the pet is nearing or has exceeded its maximum age. If there are fewer than 5 
days left before reaching the maximum age, it warns the player. If the pet surpasses its maximum age, it informs the 
player of the pet's death and prompts them to restart the game. call the method in game driver after the loop.

restart():- The restart() method handles restarting the game when the digital pet has died. It prompts the player to
decide whether to start a new game with a new pet or exit. If the player chooses to restart, they are prompted to enter
a name for the new pet, and all pet attributes are reset to their initial values: happiness, weight, hunger, day count,
interactions, dirtiness, sick status, and stage (set to "infant"). A new maximum age is randomly generated between 20 
and 40 days, and a message is displayed indicating that the new pet has hatched. If the player chooses not to restart, 
a thank-you message is displayed, and the game exits. This method ensures a clean restart while giving the player the
choice to continue or quit. call the setname(newName) in the digital pet constructor.


GameDriver Class: This class acts as the driver for the game. It allows users to interact with their digital pet through
a menu. Users can check the pet's status, feed it, play games, end the day early, clean it,
and administer medicine.

-->Constructors
-->public DigitalPet(String name)
Game Loop:
A do-while loop begins, representing the main game loop. This loop allows for repeated interactions with the digital 
pet, providing the structure for the game's primary logic.
A new instance of the DigitalPet class is created using the name provided by the player:
DigitalPet mypet = new DigitalPet(petName).
The quit variable is used to control the loop, allowing the game to continue running until the player decides to quit.

Displays a message indicating that the pet has been hatched.

### How the player interacts with the pet
    The valid commands are :
      ------------------------
      1. Check the status of the pet.
      2. Feed the pet
      3. Play with pet.
      4. Start new day.
      5. Clean your pet.
      6. Administer Medicine.
      7. Go on Vacation
      8.Quit

> Command 1 - checkStatus()
- Enter 1 to check status of the pet.
- Displays the pet's current status, including hunger state, happiness degree, and weight.

> Command 2 - feed()
- Enter 2 to feed the pet with his favorite meal or snack.
- Prompts the player to choose between a meal or a snack for feeding the pet.
- The result of the pet's hunger state, happiness degree, and weight are displayed.

> Command 3 - play()
- Enter 3 to play with pet.
- Player can play a random game to engage the pet.
-
> Command 4 - endSooner()
- Enter 4 to end day sooner that is to start the next day early.
- Progresses time to the next day.
- Resets the interactions and increases the dirtiness.

> Command 5 - cleanPet()
- Enter 5 to clean the pet.
- This method cleans the pet by reducing its dirtiness level by 10 .
- It ensures that the dirtiness level does not go below 0.
- Prints a message mentioning that the pet has been cleaned neatly.

> Command 6 - administerMedicine()
- Enter 6 to give a dose of medicine.
- This method administers medicine to the pet if it is sick and if medicine hasn't been administered already on the
- present day.
- It reduces the pet's dirtiness level by 50% and indicates that a dose has been given.
- If the pet is not sick, it prints a message stating that the dose cannot be given.
- Also, it ensures that only one dose per day is given.

->Command 7 -goOnVacation()
-invokes the method and executes the necessary vacation instructions when the player is away.

->Command 8 - quit
exits the game by printing thanks for playing .
