public class gameBoard
{
   public static void main(String [] args)
   {
    final int ROW = 5;
    final int COLUMN = 6;
  String [][] table  =
                        {
                          {" 0 ", " 1 ", " 2 ", " 3 ", " 4 ", " 5 "},
                    {" 0 "," * ", " * ", " * ", " * ", " * ", " * "},
     				     {" 1 "," * ", " * ", " * ", " * ", " * ", " * "},
                    {" 2 "," * ", " * ", " * ", " * ", " * ", " * "},
                    {" 3 "," * ", " * ", " * ", " * ", " * ", " * "},
                    {" 4 "," * ", " * ", " * ", " * ", " * ", " * "},
                    {" 5 "," * ", " * ", " * ", " * ", " * ", " * "},
                      };
                   


          for (int i = 0; i <= COLUMN; i++)
          {
            
            System.out.println();
            
            for (int j = 0; j <= ROW; j++)
            {
               System.out.print(table[i][j] );
            }
            System.out.println();
         }    
                                      
   }

}