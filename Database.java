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
    

   
       public boolean addteam (Team newteam)
    {
       if (newteam != null)
       {
           teamList.add(newteam);
           return true;
        }
       return false;
       
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
