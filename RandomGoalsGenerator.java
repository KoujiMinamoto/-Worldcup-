import java.util.Random;

public class RandomGoalsGenerator
{
   private int randomNumber;
    public void GenerateRandomNumber()
    {
       Random randomObject = new Random();
       randomNumber = randomObject.nextInt(3);
    }
    
    public int getrandomNumber()
    {
        GenerateRandomNumber();
        return randomNumber;
    }
}
