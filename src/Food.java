
/**
 * Represents a Food class
 */
public class Food {
    /**
     * Declaring fields
     */
    private int hungerImpact; //// Represents the impact of the food on the pet's hunger level.
    private String foodType; // stores the type of food
    private int happinessImpact; // Represents the impact of the food on the pet's happiness level.

    /**
     * Constructor for Food class
     * @param foodType
     */

    public Food(String foodType)
    {
        this.foodType= foodType;
    }

    /**
     * Gets the type of food for the pet.
     *
     * @return the food type for digital pet
     */
    public String getFoodType() {

        return foodType;
    }
    /**
     * Gets the hunger impact of the pet's food
     * @return the impact of the pet's food on its hunger level
     */
    public int getHungerImpact()
    {
        return hungerImpact;
    }
    /**
     * Gets the happiness impact of the pet's food
     * @return the impact of the pet's food on its happiness level
     *
     */
    public int getHappinessImpact()
    {
        return happinessImpact;
    }
}
