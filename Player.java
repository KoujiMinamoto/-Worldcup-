
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    private String name;
    private int goals = 0;
    
    public Player()
   {
       name = "";
       goals = 0;
       
   }
   
   public void setName(String PlayerName)
   {
       name = PlayerName;
   }
   
   public String getName()
   {
       return name;
    }
    
   public void setGoals(int PlayerGoals)
   {
       goals = PlayerGoals;
   }
   
   public int getGoals()
   {
       return goals;
   }
}
