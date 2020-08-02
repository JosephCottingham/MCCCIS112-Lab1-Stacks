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
      System.out.println("You will be prompted to insert name and number of tickets. Enter Name:# (Ex: Katie:4)"); //instruction for user to input ticket request
      
      String ticketInput = JOptionPane.showInputDialog("Name and number of tickets: "); //JOptionPane for user to enter information
      System.out.println("Entry Confirmation: " + ticketInput); //Confirmation of what user input
      
      
   
   }

}