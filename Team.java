import java.util.*;
public class Team
{
   private String name ;
   private int rank, redcards, yellowcards,won,lost,drawn, goals,point,Fair;
   Player player1 = new Player();
   Player player2 = new Player();
      
   public Team()
   {
      name = "";
      rank = 0;
      redcards = 0;
      yellowcards = 0;
      won = 0;
      lost = 0;
      drawn = 0;
      goals = 0;
      point = 0;
      Fair = 0;
   }
  
   public Team(String newTeamName, int newRank)
   {
      name = newTeamName;
      rank = newRank;
      redcards = 0;
      yellowcards = 0;
      won = 0;
      lost = 0;
      drawn = 0;
      goals = 0;
      point = 0;
      Fair = 0;
   }
   
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
   
   public void setPlayer1(String player,int goals)
   {
       player1.setName(player);
       player1.setGoals(player1.getGoals()+goals);
   }
   
   public void setPlayer2(String player,int goals)
   {
       player2.setName(player);
       player2.setGoals(player2.getGoals()+goals);
   }
   
   public void setPlayer1goal(int goals)
   {
       player1.setGoals(player1.getGoals()+goals);
   }
   
   public void setPlayer2goal(int goals)
   {
       player2.setGoals(player2.getGoals()+goals);
   }
   
   public int getPlayer1()
   {
       return player1.getGoals();
   }
   
   public int getPlayer2()
   {
       return player2.getGoals();
   }
   
   public String getPlayer1name()
   {
       return player1.getName();
   }
   
   public String getPlayer2name()
   {
       return player2.getName();
   }
   
   public void setFair(int fair)
   {
       Fair = fair;
   }
   
   public int getFair()
   {
       return Fair;
   }
}