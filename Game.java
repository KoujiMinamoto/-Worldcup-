import java.util.*;
import java.lang.*;
import java.io.*;

public class Game
{
    Team team = new Team();
    private Database newteamList;
    Player player = new Player();
    Menu menu = new Menu();
    RandomGoalsGenerator Random = new RandomGoalsGenerator();
    
    
    public Game()
    {
    
        newteamList = new Database();
    
    }

    public void  playGame()
    {
        Team team = new Team();
        readFile();
        boolean exit = false;
        int i = 0;
        while(i < 4)
        {
            ArrayList<Team> resultList = newteamList.getTeams();
            System.out.println("Please insert playername for "+ resultList.get(i).getName()); 
            SetPlayerName(i);
            i++;
        
        }
                
        Scanner input = new Scanner(System.in);
        while (!exit)
        {
            menu.displaymenu();

            //insert case
            String iobuffer = input.nextLine(); 
            System.out.println("");
            
         if (validBlank(iobuffer))
         { 
           String iobuffer1 = iobuffer.toUpperCase();
           char option = iobuffer1.charAt(0);

           switch(option)
           {
                case 'A': Preliminary();
                        break;
                case 'B': 
                        break;
                case 'C': 
                        break;
                case 'D': 
                         break;
                case 'E': 
                         break;                         
                case 'X': //writeFile();
                        exit = true;
                        System.out.println("Goodbye. ");
                        break;
        
               
            }
            

      
          }
      
      
         }
    
    
    }
    
    public void Preliminary()
    {
        int a= 0;
        int b;
        int goalfora = 0;
        int goalforb = 0;
        while(a<=3)
        {
        b= a+1;
        while(b<=3)
        {
            
        int reda = 0;
        int yellowa = 0;
         int redb = 0;
        int yellowb = 0;
        int goala = 0;
        int goalb = 0;
        ArrayList<Team> resultList = newteamList.getTeams();
        if(resultList.get(a).getRank() > resultList.get(b).getRank())
        {
            goala = Random.GenerateRandomNumber(5-resultList.get(a).getRank()+resultList.get(b).getRank()+Random.GenerateRandomNumber(2));
            goalb = Random.GenerateRandomNumber(5+Random.GenerateRandomNumber(2));
            
        }
        else if(resultList.get(a).getRank() < resultList.get(b).getRank())
        {
            goalb = Random.GenerateRandomNumber(5-resultList.get(b).getRank()+resultList.get(a).getRank()+Random.GenerateRandomNumber(2));
            goala = Random.GenerateRandomNumber(5+Random.GenerateRandomNumber(2));
        
        }
        else
        {
        
        }
        
        reda = Random.GenerateRandomNumber(1);
        yellowa = Random.GenerateRandomNumber(4);
        redb = Random.GenerateRandomNumber(1);
        yellowb = Random.GenerateRandomNumber(4);
        displayGameResult(resultList.get(a).getName(),resultList.get(b).getName(),goala,goalb,reda,redb,yellowa,yellowb);
        if(goala>goalb)
        {
            newteamList.addwin(1,0,0,yellowa,reda,goala,a);
            newteamList.addwin(0,0,1,yellowb,redb,goalb,b);
        }
        else if(goalb>goala)
        {
            newteamList.addwin(0,0,1,yellowa,reda,goala,a);
            newteamList.addwin(1,0,0,yellowb,redb,goalb,b);
        }
        else
        {
            newteamList.addwin(0,1,0,yellowa,reda,goala,a);
            newteamList.addwin(0,1,0,yellowb,redb,goalb,b);
        }
        goalfora = Random.GenerateRandomNumber(goala);
        goalforb = Random.GenerateRandomNumber(goalb);
        newteamList.addgoal(goalfora,2*a);
        newteamList.addgoal(goala-goalfora,2*a+1);
        newteamList.addgoal(goalforb,2*b);
        newteamList.addgoal(goalb-goalforb,2*b+1);
        
        
        b++;
        }
        a++;
        }
    }
    
    public void SetPlayerName(int numberofteam)
    {
        Player setname;
        Player set2name;
        set2name = new Player();
        setname = new Player();
        Scanner input = new Scanner(System.in);
        System.out.println("=== Add Player ===");
        System.out.println("Please insert 1st playername:"); 
        String newname = input.nextLine();
        if(validplayername(newname)==true)
        {
            System.out.println("=== Add Player ===");
            System.out.println("Please insert 1st playername again:"); 
            String newname1 = input.nextLine();
            if(validplayername(newname1)==true)
            {
                System.out.println("use default name:");
                setname.setName("");
                
            }
            
        
        }
        else
        {
        newname = input.nextLine(); 
        setname.setName(newname);
        }
        newteamList.addplayer(setname);
        
        System.out.println("=== Add Player ===");
        System.out.println("Please insert 2st playername:"); 
        String new2name = input.nextLine();
        if(validplayername(new2name)==true)
        {
            System.out.println("=== Add Player ===");
            System.out.println("Please insert 2st playername again:"); 
            String newname2 = input.nextLine();
            if(validplayername(newname2)==true)
            {
                System.out.println("use default name:");
                set2name.setName("");
                
            }
            
        
        }
        else
        {
        newname = input.nextLine(); 
        set2name.setName(newname);
        }
        newteamList.addplayer(set2name);
    }
    
    public void Final()
    {
    
    
    
    
    
    }
    
    public void displayGameResult(String teama, String teamb , int goala, int goalb ,int reda ,int redb ,int yellowa, int yellowb)
    {
        System.out.println(teama + goala +" vs. " +teamb + goalb);
        if(yellowa>0)
        {
            if(reda == 0)
            {
                System.out.println("Cards awarded:"+ teama + "-" + yellowa + "yellowcard");
            }
            else
            {
            System.out.println("Cards awarded:"+ teama + "-" + yellowa + "yellowcard  " + reda +"redcard" );
            }
        }
        if(yellowb>0)
        {
            if(redb == 0)
            {
                System.out.println("Cards awarded:"+ teamb + "-" + yellowb + "yellowcard");
            }
            else
            {
            System.out.println("Cards awarded:"+ teamb + "-" + yellowb + "yellowcard  " + redb +"redcard" );
            }
        }
    
    
    }
    
    public void  playPenaltyShootOut()
    {
    
    
    
    }
    
     private void readFile()
    {
        String filename = ("team.txt");
        String teams;
        Team loadFromFile;
        
        try
        {
            FileReader inputFile = new FileReader(filename);
            Scanner parser = new Scanner(inputFile);
            int linecount = 0;
            while (parser.hasNextLine())
            {
                loadFromFile = new Team(); 
                teams = parser.nextLine();
                String[] attribute = teams.split(",");



                System.out.println ("Team"+ (linecount+1));
                loadFromFile.setName(attribute[0]);
                loadFromFile.setRank(convertStringtoInt(attribute[1]));

                loadFromFile.displayTeamrecord();
                newteamList.addteam(loadFromFile);
                linecount++; 
            }
            inputFile.close();
        }
        catch(FileNotFoundException exception)
        {
            System.out.println(filename + " not found");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occured");
        }
    }
    

    private int convertStringtoInt(String input) //method to convert String to Integer
    {
        //intialised variables
        String S = input;
        int i = 0;
        //try catch to handle NumberFormatException
        try
        {
            // the String to int conversion happens here
            i = Integer.parseInt(input.trim());

            // print out the value after the conversion
            //System.out.println("int i = " + i);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage() + ", please input an integer!");
        }
        return i;
    }
    
    private boolean validBlank(String iobuffer) //method to check insert any empties or blanks
    {
        if (iobuffer.matches("[abcdexABCDEX]*"))
        {
           
            if (iobuffer.trim().isEmpty() || iobuffer.length() > 1)
            {
                System.out.println("Error : please insert from A to E OR Z !");
                return false;
            }
            
          
            return true;
            
        
            
         }
        System.out.println("Error: opition shouldn't be #!123...Please enter again:");
        return true;
    }
    
    public boolean validplayername(String playername)
    {
       //check if car is not in database , and return false to break while loop
       boolean isrepeated = newteamList.validname(playername);
       if (isrepeated)
       {
        System.out.println("Error : player name existed , please insert another name!");
        return isrepeated;
       }
        
       return false;
    }
}
