import java.util.Random;

public class RandomGoalsGenerator
{
   private int randomNumber;
    public int GenerateRandomNumber(int i)
    {
       Random randomObject = new Random();
       randomNumber = randomObject.nextInt(i+1);
       return randomNumber;
    }
    

}
