import java.util.*;
import java.io.*;

public class Database
{
    private ArrayList<Team> teamList;
    private ArrayList<Player> playerList;
    
    public Database()
    {
        teamList = new ArrayList<Team>();
        playerList = new ArrayList<Player>();
    }
    
    public void addplayer(Player newplayer)
    {
    
        playerList.add(newplayer);
    
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
    
    public void addgoal (int goal, int a)
    {
        getPlayers().get(a).setGoals(goal);
    }
    
    public void addpoint(int point ,int a)
    {
         getTeams().get(a).setPoint(point);
    
    }
    
   public int getnumberofplayers()
    {
       
       return playerList.size();
    
    }
   

    
    public ArrayList<Team> getTeams()
   {
       return teamList;
   }
   
   public ArrayList<Player> getPlayers()
   {
       return playerList;
   }
    
   public boolean validname(String name)
   {
       //check if name is not in database , and return false to break while loop
       for (int i =0; i < getnumberofplayers(); i++)
       {
        if (name.equals(getPlayers().get(i).getName()))
        return true;
        }
        
        return false;
   }
}
