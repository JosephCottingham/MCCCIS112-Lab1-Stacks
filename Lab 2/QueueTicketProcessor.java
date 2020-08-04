import ch04.queues.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class QueueTicketProcessor
{
   public static void main (String [] args)
   {
      //TicketQueue tickets = new TicketQueue(100);
      //Thread test = new Thread(tickets);
      //test.start();  
      System.out.println("Thank you for doing business with us! We look forward to helping you order your tickets for this event."); 
      System.out.println("You will be prompted to insert name and number of tickets. Enter Name:# (Ex: Katie:4)"); //instruction for user to input ticket request
      
      String ticketInput = JOptionPane.showInputDialog("Name and number of tickets: "); //JOptionPane for user to enter information
      System.out.println("Entry Confirmation: " + ticketInput); //Confirmation of what user input
      String split[] = ticketInput.split(":"); // split of input to separate the number of tickets requested
      
      int ticketAmount = Integer.parseInt(split[1]); // number to be pushed onto Queue and to use to subtract from total tickets
      System.out.println(ticketAmount); //check to see if split worked (can be taken out later)
      
      
   
   }

}