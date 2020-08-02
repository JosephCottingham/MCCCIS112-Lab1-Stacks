import java.util.Scanner; 
public class game
{
   public static void main(String [] args)
   {
      board b = new board();
      Scanner scn = new Scanner(System.in);
      char menu;
 
      do {
         System.out.println("Try to find the two hidden Os in the board! You may undo or redo turns. You only have three turns. Good Luck!");
         System.out.println("Moves Remaining: " + String.valueOf(3-b.getCount()));
         System.out.println(b.getCurBoardAsStr());
         
       
         System.out.println("\n[m]ove, [u]ndo, [r]edo, [q]uit: ");
         //System.out.print("Enter Value: ");
         menu = scn.next().charAt(0);
         switch (menu) {
            case 'm':
               System.out.print("\nX Coorinate: ");
               String C1 = scn.next();
               System.out.print("\nY Coorinate: ");
               String C2 = scn.next();
               b.move(Integer.parseInt(C1), Integer.parseInt(C2));
               break;
            case 'u':
               b.undo();
               break;
            case 'r':
               b.redo();
               break;
            case 'q':
               System.out.println("You have quit shame on you, here is the board!");
               System.out.println(b.getRevealedBoardAsString());
         }
         if(b.isGameOver()){
            menu = 'q';
            System.out.println("You have used all 3 moves. Game over.");
            System.out.println(b.getRevealedBoardAsString());
         }
      }
       while (menu!='q');
   }
 }
