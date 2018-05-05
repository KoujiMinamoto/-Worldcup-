
/**
 * Write a description of class Team here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Team
{
   private String name;
   private int rank, redcards, yellowcards,won,lost,drawn, goals;
   Player player1 = new Player();
   Player player2 = new Player();
   
   public void displayTeamrecord()
   {
       System.out.print(name + ",");
       System.out.print(rank + ",");
   }
   
   public void setName(String TeamName)
   {
       name = TeamName;
   }
   
   public String getName()
   {
       return name;
   }
    
    public void setRank(int TeamRank)
   {
       rank = TeamRank;
   }
   
   public int getRank()
   {
       return rank;
   }
   
   
   
   
   
  
}
