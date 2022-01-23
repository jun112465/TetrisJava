import javax.swing.*;
import java.awt.*;

class MyVar{
    int width = 12;
    int height = 21;
    int[][] boardArr = new int[21][12];
    int blockWidth = 25;
    int blockHeight = 25;
    int X = 80;
    int Y = 80;

    MyVar(){
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if(i == height-1)
                    boardArr[i][j] = 1;
                else if(j==0 || j==width-1)
                    boardArr[i][j] = 1;
                else
                    boardArr[i][j] = 0;
            }
        }
    }
    int[][][] blocks = {
        //■
        //■■■
        {
            {0,0,0,0},
            {1,0,0,0},
            {1,1,1,0},
            {0,0,0,0}
        },
        {
            {0,1,1,0},
            {0,1,0,0},
            {0,1,0,0},
            {0,0,0,0}
        },
        {
            {1,1,1,0},
            {0,0,1,0},
            {0,0,0,0},
            {0,0,0,0}
        },
        {
            {0,0,1,0},
            {0,0,1,0},
            {0,1,1,0},
            {0,0,0,0}
        },



    //  ■
    //■■■
        {
            {0,0,0,0},
            {0,0,1,0},
            {1,1,1,0},
            {0,0,0,0}
        },
        {
            {0,1,0,0},
            {0,1,0,0},
            {0,1,1,0},
            {0,0,0,0}
        },
        {
            {0,0,0,0},
            {1,1,1,0},
            {1,0,0,0},
            {0,0,0,0}
        },
        {
            {0,1,1,0},
            {0,0,1,0},
            {0,0,1,0},
            {0,0,0,0}
        },


    //  ■■
    //  ■■
        {
            {0,0,0,0},
            {1,1,0,0},
            {1,1,0,0},
            {0,0,0,0}
        },
        {
            {0,0,0,0},
            {1,1,0,0},
            {1,1,0,0},
            {0,0,0,0}
        },
        {
            {0,0,0,0},
            {1,1,0,0},
            {1,1,0,0},
            {0,0,0,0}
        },
        {
            {0,0,0,0},
            {1,1,0,0},
            {1,1,0,0},
            {0,0,0,0}
        },

        // ■■■■
        {
            {0,0,0,0},
            {0,0,0,0},
            {1,1,1,1},
            {0,0,0,0}
        },
        {
            {0,1,0,0},
            {0,1,0,0},
            {0,1,0,0},
            {0,1,0,0}
        },
        {
            {0,0,0,0},
            {0,0,0,0},
            {1,1,1,1},
            {0,0,0,0}
        },
        {
            {0,1,0,0},
            {0,1,0,0},
            {0,1,0,0},
            {0,1,0,0}
        },


        //■
        //■■■
        {
            {0,0,0,0},
            {0,1,0,0},
            {1,1,1,0},
            {0,0,0,0}
        },
        {
            {0,1,0,0},
            {0,1,1,0},
            {0,1,0,0},
            {0,0,0,0}
        },
        {
            {0,0,0,0},
            {1,1,1,0},
            {0,1,0,0},
            {0,0,0,0}
        },
        {
            {0,1,0,0},
            {1,1,0,0},
            {0,1,0,0},
            {0,0,0,0}
        },


        //  ■■
        //   ■■
        {
            {0,0,0,0},
            {1,1,0,0},
            {0,1,1,0},
            {0,0,0,0}
        },
        {
            {0,0,1,0},
            {0,1,1,0},
            {0,1,0,0},
            {0,0,0,0}
        },
        {
            {0,0,0,0},
            {1,1,0,0},
            {0,1,1,0},
            {0,0,0,0}
        },
        {
            {0,0,1,0},
            {0,1,1,0},
            {0,1,0,0},
            {0,0,0,0}
        },
        //  ■■
        //  ■■
        {
            {0,0,0,0},
            {0,1,1,0},
            {1,1,0,0},
            {0,0,0,0}
        },
        {
            {0,1,0,0},
            {0,1,1,0},
            {0,0,1,0},
            {0,0,0,0}
        },
        {
            {0,0,0,0},
            {0,1,1,0},
            {1,1,0,0},
            {0,0,0,0}
        },
        {
            {0,1,0,0},
            {0,1,1,0},
            {0,0,1,0},
            {0,0,0,0}
        }
    };
}


class MyPanel extends JPanel implements Runnable{

    MyVar v = new MyVar();
    JLabel gameTitle = new JLabel("Tetris Game Made By JunYeob");
    int arrX = 4;
    int arrY = 0;

    MyPanel(){
        add(gameTitle);
        for(int i=0; i<v.height; i++){
            for(int j=0; j<v.width; j++){
                if(v.boardArr[i][j] == 1)
                    System.out.print(1);
                else
                    System.out.print(0);
            }
            System.out.println();
        }
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGameBoard(g);
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(!detectCollision(2,arrX,arrY+1)){
                arrX = 4;
                deleteBlock(2,arrX,arrY);
                arrY++;
                drawBlock(2,arrX,arrY);
                repaint();
            }else {
                setBlock(2, arrX, arrY);
                repaint();
                break;
            }
        }
    }

    public void deleteBlock(int blockNum, int arrX, int arrY){
        for(int i=0; i<4; i++) {
            for (int j = 0; j < 4; j++) {
                if(v.blocks[blockNum][i][j] == 1){
                    v.boardArr[arrY+i][arrX+j] = 0;
                }
            }
        }
    }
    public void drawBlock(int blockNum, int arrX, int arrY){
        for(int i=0; i<4; i++) {
            for (int j = 0; j < 4; j++) {
                if(v.blocks[blockNum][i][j] == 1){
                    v.boardArr[arrY+i][arrX+j] = 2;
                }
            }
        }
    }

    public void setBlock(int blockNum, int arrX, int arrY){
        for(int i=0; i<4; i++) {
            for (int j = 0; j < 4; j++) {
                if(v.blocks[blockNum][i][j] == 1){
                    v.boardArr[arrY+i][arrX+j] = 1;
                }
            }
        }
    }
    public void drawGameBoard(Graphics g){
        for(int i=0; i<v.boardArr.length; i++){
            for(int j=0; j<v.boardArr[0].length; j++){
                int y = v.Y + v.blockHeight*i;
                int x = v.X + v.blockWidth*j;
                if(v.boardArr[i][j] == 1){
                    g.setColor(Color.GRAY);
                    g.fillRect(x,y,v.blockWidth, v.blockHeight);
                    g.setColor(Color.BLACK);
                }else if(v.boardArr[i][j] == 2){
                    g.setColor(Color.ORANGE);
                    g.fillRect(x,y,v.blockWidth, v.blockHeight);
                    g.setColor(Color.BLACK);
                }
                g.drawRect(x,y,v.blockWidth, v.blockHeight);
            }
        }
    }

    public boolean detectCollision(int blockNum, int arrX, int arrY){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(v.blocks[blockNum][i][j] == 1){
                    if(v.boardArr[arrY+i][arrX+j] == 1)
                        return true;
                }
            }
        }

        return false;
    }
}

public class MyTetris extends JFrame {
    MyTetris(){
        setTitle("My Tetris game");
        setSize(500,650);


        add(new MyPanel());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyTetris();
    }
}
