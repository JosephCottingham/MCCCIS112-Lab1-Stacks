import ch02.stacks.ArrayBoundedStack;
import java.util.concurrent.ThreadLocalRandom;

public class board{
    final int ROW = 5;
    final int COLUMN = 5;

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

    public board(){
        for (int x = 0; x < 3; x++) curBoard[ThreadLocalRandom.current().nextInt(0, 5)][ThreadLocalRandom.current().nextInt(1, 6)] = 2;
    }

    public int[][] getCurBoard(){
        return curBoard;
    }


    public void undo(){
        if (undo.isEmpty()) return;
        redo.push(curBoard);
        curBoard = redo.top();
        redo.pop();
    }


    public void redo(){
        if (redo.isEmpty()) return;
        undo.push(curBoard);
        curBoard = redo.top();
        redo.pop();

    }


    public void move(int x, int y){
        if (curBoard[++x][++y] % 2 == 0){
            undo.push(curBoard);
            curBoard[x][y]++;
        }
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
}