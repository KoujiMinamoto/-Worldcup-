import java.util.*;
import java.io.*;

public class Database
{
    private ArrayList<Team> teamList;
    
    public Database()
    {
        teamList = new ArrayList<Team>();
    }
    
    public void addplayer(String newplayer,String newplayer2,int a)
    {
    
        getTeams().get(a).setPlayer1(newplayer,0);
        getTeams().get(a).setPlayer2(newplayer2,0);
    
    }
   
    public boolean addteam (Team newteam)
    {
       if (newteam != null)
       {
           teamList.add(newteam);
           return true;
        }
       return false;
       
    }
    
    public void addwin (int win,int drawn, int lose, int y , int r ,int goal ,int a)
    {
        getTeams().get(a).setWon(getTeams().get(a).getWon()+win);
        getTeams().get(a).setDrawn(getTeams().get(a).getDrawn()+drawn);
        getTeams().get(a).setLost(getTeams().get(a).getLost()+lose);
        getTeams().get(a).setYellow(getTeams().get(a).getYellow()+y);
        getTeams().get(a).setRed(getTeams().get(a).getRed()+r);
        getTeams().get(a).setGoal(getTeams().get(a).getGoal()+goal);
    }
    
    public void addgoal (int goal, int goal2,int a)
    {
        getTeams().get(a).setPlayer1goal(goal);
        getTeams().get(a).setPlayer2goal(goal2);
    }
    
    
    public void addpoint(int point ,int a)
    {
         getTeams().get(a).setPoint(point);
    
    }
    

   

    
    public ArrayList<Team> getTeams()
   {
       return teamList;
   }
   

    

}
