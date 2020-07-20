import ch02.stacks.*;
import java.util.concurrent.ThreadLocalRandom;

public class board{
    final int ROW = 5;
    final int COLUMN = 5;
    int curCount = 0;

    int[][] curBoard = {
        {0, 1,2,3,4,5},
        {1, 0,0,0,0,0},
        {2, 0,0,0,0,0},
        {3, 0,0,0,0,0},
        {4, 0,0,0,0,0},
        {5, 0,0,0,0,0}
    };

    ArrayBoundedStack<int[][]> redo = new ArrayBoundedStack<int[][]>();
    ArrayBoundedStack<int[][]> undo = new ArrayBoundedStack<int[][]>();

    ArrayBoundedStack<Integer> redoCount = new ArrayBoundedStack<Integer>();
    ArrayBoundedStack<Integer> undoCount = new ArrayBoundedStack<Integer>();

    public board(){
        for (int x = 0; x < 3; x++) curBoard[ThreadLocalRandom.current().nextInt(0, 5)][ThreadLocalRandom.current().nextInt(1, 6)] = 2;
    }

    public int[][] getCurBoard(){
        return curBoard;
    }

    public int getCount(){
        return curCount;
    }


    public void undo(){
        if (undo.isEmpty()) return;
        redo.push(curBoard);
        curBoard = undo.top();
        undo.pop();
        redoCount.push(curCount);
        curCount = undoCount.top();
        undoCount.pop();
    }


    public void redo(){
        if (redo.isEmpty()) return;
        undo.push(curBoard);
        curBoard = redo.top();
        redo.pop();
        undoCount.push(curCount);
        curCount = redoCount.top();
        redoCount.pop();
    }


    public void move(int x, int y)
    {
      if (x < 0 || y < 0)
      {
         throw new StackUnderflowException("Number less than 0. Not in coordinate range.");
      }
      if (x > 6 || y > 6)
      {
         throw new StackOverflowException("Number greater than 6. Not in coordinate range.");
      }
        
        if (curBoard[x][y] % 2 == 0)
        {
            redo = new ArrayBoundedStack<int[][]>();
            redoCount = new ArrayBoundedStack<Integer>();
            undo.push(copy(curBoard));
            curBoard[x][y] = curBoard[x][y]+1;
            undoCount.push(curCount);
            curCount++;
        }
    }
    public Boolean isGameOver()
    {        
    if (curCount >= 3) return true;	
    return false;   
    }
    
    private int[][] copy(int[][] array){
        int[][] copy = new int[6][6];
        for(int x = 0; x < 6; x++){
            for(int y = 0; y < 6; y++){
                copy[y][x] = array[y][x];
            }
        } 
        return copy;
    }

    private void printBoard(int[][] board){
        String dis = "PrintBoard\n";
        for(int x = 0; x < 6; x++){
            for(int y = 0; y < 6; y++){
                if (y == 0 && x == 0) dis += "   ";
                else if (x > 0 && y > 0) {
                    switch (board[y][x]) {
                        case 0:
                            dis += " * ";
                            break;
                        case 1:
                            dis += " X ";
                            break;
                        case 2:
                            dis += " * ";
                            break;
                        case 3:
                            dis += " O ";
                            break;
                        default:
                            break;
                    }
                } else {
                    dis += " ";
                    dis += String.valueOf(board[y][x]);
                    dis += " ";
                }
            }
            dis += "\n";
        }
        System.out.print(dis);
    }

    public String getCurBoardAsStr(){
        String dis = "";
        for(int x = 0; x < 6; x++){
            for(int y = 0; y < 6; y++){
                if (y == 0 && x == 0) dis += "   ";
                else if (x > 0 && y > 0) {
                    switch (curBoard[y][x]) {
                        case 0:
                            dis += " * ";
                            break;
                        case 1:
                            dis += " X ";
                            break;
                        case 2:
                            dis += " * ";
                            break;
                        case 3:
                            dis += " O ";
                            break;
                        default:
                            break;
                    }
                } else {
                    dis += " ";
                    dis += String.valueOf(curBoard[y][x]);
                    dis += " ";
                }
            }
            dis += "\n";
        }
        return dis;
    }

    public String getRevealedBoardAsString(){
      String dis = "";
      for(int x = 0; x < 6; x++){
          for(int y = 0; y < 6; y++){
              if (y == 0 && x == 0) dis += "   ";
              else if (x > 0 && y > 0) {
                  switch (curBoard[y][x]) {
                      case 0:
                          dis += " X ";
                          break;
                      case 1:
                          dis += " X ";
                          break;
                      case 2:
                          dis += " O ";
                          break;
                      case 3:
                          dis += " O ";
                          break;
                      default:
                          break;
                  }
              } else {
                  dis += " ";
                  dis += String.valueOf(curBoard[y][x]);
                  dis += " ";
              }
          }
          dis += "\n";
      }
      return dis;

    }
}
