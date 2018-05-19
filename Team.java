import java.util.*;

public class Team
{
   private String name ;
   private int rank, redcards, yellowcards,won,lost,drawn, goals,point;
   Player player1;
   Player player2;
   
   
   
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
   
   public void setRed(int TeamRed)
   {
       redcards = TeamRed;
   }
   
   public int getRed()
   {
       return redcards;
   }
   public void setYellow(int TeamYellow)
   {
       yellowcards = TeamYellow;
   }
   
   public int getYellow()
   {
       return yellowcards;
   }
   
   public void setWon(int TeamWon)
   {
       won = TeamWon;
   }
   
   public int getWon()
   {
       return won;
   }
   
   public void setLost(int TeamLost)
   {
       lost = TeamLost;
   }
   
   public int getLost()
   {
       return lost;
   }
   
   public void setDrawn(int TeamDrawn)
   {
       drawn = TeamDrawn;
   }
   
   public int getDrawn()
   {
       return drawn;
   }
   
   public void setGoal(int TeamGoal)
   {
       goals = TeamGoal;
   }
   
   public int getGoal()
   {
       return goals;
   }
   
   public void setPoint(int TeamPoint)
   {
       point = TeamPoint;
   }
   
   public int getPoint()
   {
       return point;
   }
   
   
   
}