import java.util.*;
import java.lang.*;
import java.io.*;


public class Game
{
    private Database newteamList;
    Menu menu = new Menu();
    RandomGoalsGenerator Random = new RandomGoalsGenerator();
    String winner;
    String goldenboot;
    String FairPlayAward;
    
    
    public Game()
    {
    
        newteamList = new Database();
        winner = "";
        goldenboot = "";
        FairPlayAward = "";
    }

    public void  playGame()
    {
        Team team = new Team();
        readFile();
        boolean exit = false;
        boolean A = false;
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
                          totalpoint();
                          sort();
                          A = true;
                          break;
                case 'B': if(A == true)
                          {
                              Final();
                              totalpoint();
                              sort();
                              sortFair();
                          }
                          else
                          {
                              System.out.println("Please play Preliminary Stage first "); 
                          }
                          break;
                case 'C': display();
                          break;
                case 'D': sortPlayer();
                          break;
                case 'E': Displayfinal();
                          break;                         
                case 'X': writeFile();
                          exit = true;
                          System.out.println("Goodbye. ");
                          break;
        
               
            }
            

      
          }
      
      
         }
    
    
    }
    
    public void Displayfinal()
    {
        System.out.println("Football World Cup Winner: "+winner);
        System.out.println("Golden Boot Award: "+goldenboot);
        System.out.println("Fair Play Award: "+FairPlayAward);
    
    
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
        newteamList.addgoal(goalfora,goala-goalfora,a);
        newteamList.addgoal(goalforb,goalb-goalforb,b);
        
        b++;
        }
        a++;
        }
    }
    
    public void SetPlayerName(int numberofteam)
    {
        Team ranklist = new Team();
        Scanner input = new Scanner(System.in);
        System.out.println("=== Add Player ===");
        System.out.println("Please insert 1st playername:"); 
        String newname = input.nextLine();
        if(validplayername(newname)==false)
        {
            System.out.println("=== Add Player ===");
            System.out.println("Please insert 1st playername again:"); 
            String newname1 = input.nextLine();
            if(validplayername(newname1)==false)
            {
                System.out.println("use default name:");
                newname = newteamList.getTeams().get(numberofteam).getName()+"-1-player";
                
            }
            else
            {
                newname = newname1;
            }
        
        }

        
        System.out.println("=== Add Player ===");
        System.out.println("Please insert 2st playername:"); 
        String new2name = input.nextLine();
        if(new2name.equals(newname)||validplayername(new2name)==false)
        {
            System.out.println("=== Add Player ===");
            System.out.println("Please insert 2st playername again:"); 
            String newname2 = input.nextLine();
            if(new2name.equals(newname)||validplayername(newname2)==false)
            {
                System.out.println("use default name:");
                new2name = newteamList.getTeams().get(numberofteam).getName()+"-2-player";
                
            }
            else
            {
                new2name = newname2;
            }
            
        
        }

        newteamList.addplayer(newname,new2name,numberofteam);
    }
    
    public void totalpoint()
    {   
        int totalpoint = 0;
        int a = 0 ;
        ArrayList<Team> resultList = newteamList.getTeams();
        while(a<=3)
        {
            totalpoint = (resultList.get(a).getWon()*3+resultList.get(a).getDrawn());
            newteamList.addpoint(totalpoint,a);
            a++;
        }
    
    }
    
    public void sort() 
    {
        ArrayList<Team> sortlist = newteamList.getTeams();
        Team sort;
        for(int a=0;a<3;a++)
        {
            for(int b=1;b<4-a;b++)
            {
                if(sortlist.get(b-1).getPoint() > sortlist.get(b).getPoint())
                {
                    sort = sortlist.get(b-1);
                    newteamList.getTeams().set((b-1),sortlist.get(b));
                    newteamList.getTeams().set(b,sort);
                
                }
                
                if(sortlist.get(b-1).getPoint() == sortlist.get(b).getPoint())
                {
                    if(sortlist.get(b-1).getGoal() > sortlist.get(b).getGoal())
                    {
                        sort =  sort = sortlist.get(b-1);
                        newteamList.getTeams().set((b-1),sortlist.get(b));
                        newteamList.getTeams().set(b,sort);
                    }
                    
                    if(sortlist.get(b-1).getGoal() == sortlist.get(b).getGoal())
                    {
                        int random = Random.GenerateRandomNumber(1);
                        if(random == 1)
                        {
                            sort =  sort = sortlist.get(b-1);
                            newteamList.getTeams().set((b-1),sortlist.get(b));
                            newteamList.getTeams().set(b,sort);
                        
                        
                        }
                        
                    }
                }
            }
        }

    }
    
    public void sortFair() 
    {
        for(int a=0;a<4;a++)
        {
            newteamList.addfair(a);
        }
        ArrayList<Team> sortlist = newteamList.getTeams();
        ArrayList<Team> sortfairlist = sortlist;
        Team sort;
        for(int a=0;a<3;a++)
        {
            for(int b=1;b<4-a;b++)
            {
                if(sortlist.get(b-1).getFair() > sortlist.get(b).getFair())
                {
                    sort = sortlist.get(b-1);
                    sortfairlist.set((b-1),sortlist.get(b));
                    sortfairlist.set(b,sort);
                
                }
                 
                
            }
        }
        
         if(sortfairlist.get(0).getFair() == sortfairlist.get(1).getFair() )
        {
            if(sortfairlist.get(1).getFair() == sortfairlist.get(2).getFair())
            {
                FairPlayAward = sortfairlist.get(0).getName()+" and "+ sortfairlist.get(1).getName()+" and "+ sortfairlist.get(2).getName();
            }
            else
            FairPlayAward = sortfairlist.get(0).getName()+" and "+ sortfairlist.get(1).getName();
        }
        else
        FairPlayAward = sortfairlist.get(0).getName();

    }
    
    public void sortPlayer()
    {
        ArrayList<Player> sortplayerList;
        sortplayerList = new ArrayList<Player>() ;
        Player sortplayer;
        for(int a=0;a<4;a++)
        {
             sortplayer = new Player();
             sortplayer.setName(newteamList.getTeams().get(a).getPlayer1name()+" ("+newteamList.getTeams().get(a).getName()+")");
             sortplayer.setGoals(newteamList.getTeams().get(a).getPlayer1());
             sortplayerList.add(sortplayer);
        
             sortplayer = new Player();
             sortplayer.setName(newteamList.getTeams().get(a).getPlayer2name()+" ("+newteamList.getTeams().get(a).getName()+")");
             sortplayer.setGoals(newteamList.getTeams().get(a).getPlayer2());
             sortplayerList.add(sortplayer);
        }
        Player sort;
        ArrayList<Player> sortlist = sortplayerList ;
        for(int a=0;a<7;a++)
        {
            for(int b=1;b<8-a;b++)
            {
                if(sortlist.get(b-1).getGoals() > sortlist.get(b).getGoals())
                {
                   sort = sortlist.get(b-1);
                   sortplayerList.set((b-1),sortlist.get(b));
                   sortplayerList.set(b,sort);
                
                }
            }
        }
        
        if(sortplayerList.get(7).getGoals() == sortplayerList.get(6).getGoals() )
        {
            if(sortplayerList.get(6).getGoals() == sortplayerList.get(5).getGoals())
            {
                goldenboot = sortplayerList.get(7).getName()+" and "+ sortplayerList.get(6).getName()+" and "+ sortplayerList.get(5).getName();
            }
            else
            goldenboot = sortplayerList.get(7).getName()+" and "+ sortplayerList.get(6).getName();
        }
        else
        goldenboot = sortplayerList.get(7).getName();
        
        for(int i=7;i>=0;i--)
        {
            System.out.println(sortplayerList.get(i).getName() + " - " +sortplayerList.get(i).getGoals() );
        }
    }
    
    public void Final()
    {
        int a =3;
        int b =2;
        int goalfora = 0;
        int goalforb = 0;
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
            winner = resultList.get(a).getName();
        }
        else if(goalb>goala)
        {
            newteamList.addwin(0,0,1,yellowa,reda,goala,a);
            newteamList.addwin(1,0,0,yellowb,redb,goalb,b);
            winner = resultList.get(b).getName();
        }
        else
        {   
            newteamList.addwin(0,0,0,yellowa,reda,goala,a);
            newteamList.addwin(0,0,0,yellowb,redb,goalb,b);
            playPenaltyShootOut(a,b);
        }
        goalfora = Random.GenerateRandomNumber(goala);
        goalforb = Random.GenerateRandomNumber(goalb);
        newteamList.addgoal(goalfora,goala-goalfora,a);
        newteamList.addgoal(goalforb,goalb-goalforb,b);
        
    
    
    
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
    
    public void  playPenaltyShootOut(int a ,int b)
    {
        int a1,b1= 0;
        a1 =Random.GenerateRandomNumber(5);
        b1 =Random.GenerateRandomNumber(5);
        
        if(a1>b1)
        {
            winner = newteamList.getTeams().get(a).getName();
            newteamList.addwin(1,0,0,0,0,0,a);
            newteamList.addwin(0,0,1,0,0,0,b);
        }
        else if(a1<b1)
        {
            winner = newteamList.getTeams().get(b).getName();
            newteamList.addwin(0,0,1,0,0,0,a);
            newteamList.addwin(1,0,0,0,0,0,b);
        }
        else
        {
            while(a1==b1)
            {
                a1 =Random.GenerateRandomNumber(1);
                b1 =Random.GenerateRandomNumber(1);
            }
            if(a1>b1)
            {
                winner = newteamList.getTeams().get(a).getName();
                newteamList.addwin(1,0,0,0,0,0,a);
                newteamList.addwin(0,0,1,0,0,0,b);
            }
            else if(a1<b1)
            {
                winner = newteamList.getTeams().get(b).getName();
                newteamList.addwin(0,0,1,0,0,0,a);
                newteamList.addwin(1,0,0,0,0,0,b);
            }
        
        }
    
        System.out.println("winner is :"+ winner );
    
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
    
    public void display()
    {
        for(int a=3;a>=0;a--)
        {
            ArrayList<Team> resultList = newteamList.getTeams();
            String name =resultList.get(a).getName();
            int played = resultList.get(a).getWon()+resultList.get(a).getDrawn()+resultList.get(a).getLost();
            int fair = resultList.get(a).getRed()*2+resultList.get(a).getYellow();
            System.out.println("Name         played  won  lost  drawn  goals  points  fairplay");
            System.out.println(name+"   "+played+"    "+resultList.get(a).getWon()+"    "+resultList.get(a).getDrawn()+"    "+resultList.get(a).getLost()+"    "+resultList.get(a).getGoal()+"    "+resultList.get(a).getPoint()+"    "+fair);
            
        
        
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
    
    private boolean validplayername(String iobuffer) //method to check insert any empties or blanks
    {
        if (iobuffer.matches("[a-zA-z\\-]*"))
        {
           
            if (iobuffer.trim().isEmpty() || iobuffer.length() < 2)
            {
                System.out.println("Error : please insert more than 2!");
                return false;
            }
            int position = 0;
            char hyphen = '-';
            int count = 0;
            for (position = 0; position < iobuffer.length(); position++)
            {
            if (iobuffer.charAt(position) == hyphen)
            {
                count++;
                if (count > 1)
                    return false;
            }
            if (iobuffer.charAt(0) == hyphen || iobuffer.charAt(iobuffer.length() - 1) == hyphen)
            {
                return false;
            }           
            }
            return true;

         }
         else
         {
             System.out.println("Error: opition shouldn't be #!123...Please enter again:");
             return false;
         }
    }
    
    public boolean isHyphen(String newPlayerName)
    {
        int position = 0;
        char hyphen = '-';
        int count = 0;
        for (position = 0; position < newPlayerName.length(); position++)
        {
            if (newPlayerName.charAt(position) == hyphen)
            {
                count++;
                if (count > 1)
                    return false;
            }
            if (newPlayerName.charAt(0) == hyphen || newPlayerName.charAt(newPlayerName.length() - 1) == hyphen)
            {
                return false;
            }           
        }
        return true;
    }
    
    private void writeFile()
    {
         String filename = ("statistics.txt");
        //try catch to handle IOException
        try
        {
            PrintWriter outputFile = new PrintWriter (filename);
            outputFile.println("Football World Cup Winner: "+winner);
            outputFile.println("Golden Boot Award: "+goldenboot);
            outputFile.println("Fair Play Award: "+FairPlayAward);
            outputFile.close();    
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occured");
        }
    }
}
