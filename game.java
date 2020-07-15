import java.util.Scanner; 
public class game
{
   public static void main(String [] args)
   {
      board b = new board();
      Scanner scn = new Scanner(System.in);
      char menu;
 
      do {
         System.out.println(b.getCurBoardAsStr());
         System.out.print("\n[m]ove, [u]ndo, [r]edo, [q]uit: ");
         menu = scn.nextLine().toCharArray()[0];
       
         System.out.println("\n[m]ove, [u]ndo, [r]edo, [q]uit: ");
         System.out.print("Enter Value: ");
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
         } 
      }
       while (menu!='q');
   }
 }
