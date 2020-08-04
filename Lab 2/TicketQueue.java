import ch04.threads.*;
import ch04.queues.*;
import support.LLNode;
public class TicketQueue implements Runnable
{
   
   protected LLNode<Integer> TicketQueueHead = null;
   
      
   

}

public class ticketCount // counter class for keeping track of tickets left after purchases
{
   private int ticketCounter;
   public Counter ()
   {
      ticketCounter = 100;
   }
   public void decrement()
   {
      ticketCounter--;
   }
   
   public int getTicketCount()
   {
      return ticketCounter;
   }

}