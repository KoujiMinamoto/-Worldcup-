
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
   
   public boolean validplayername(String iobuffer) //method to check insert any empties or blanks
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
}
