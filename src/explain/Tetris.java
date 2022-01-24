package explain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class MyComponents{
    int[][] gameArr = new int[21][12];
    //게임 판 (21*12 사이즈의 평면)
    //이 배열을 JPanel에서 그리는 것이 목적이다.
    int blockSize = 25;
    int startX = 80;
    int startY = 80;

    int width = 12; //gameArr 의 가로길이
    int height = 21; //gameArr 의 세로길이

    public int x = 5;
    public int y = 0;
    int blockNum = 0;
    int blockParent = 0;

    MyComponents(){
        drawFrame();
    }

    public void initPosition(){
        x = 5;
        y = 0;
    }
    public void getRandomBlockNum(){
        blockNum = (int)(Math.random()*24);
        blockParent = blockNum - blockNum%6;
    }

    //gameArr 배열을 JPanel 에 그리는 함수
    public void drawGameArr(Graphics g){
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                if(gameArr[i][j] == 0){
                    //빈칸 그리기
                    g.drawRect(startX+j*blockSize, startY+i*blockSize,
                            blockSize, blockSize);
                }else if(gameArr[i][j] == 1){
                    //회색 블록 그리기
                    g.setColor(Color.GRAY);
                    g.fillRect(startX+j*blockSize, startY+i*blockSize,
                            blockSize, blockSize);
                    //검정 테두리
                    g.setColor(Color.BLACK);
                    g.drawRect(startX+j*blockSize, startY+i*blockSize,
                            blockSize, blockSize);
                }else if(gameArr[i][j] == 2){
                    //주황색 블록 그리기
                    g.setColor(Color.ORANGE);
                    g.fillRect(startX+j*blockSize, startY+i*blockSize,
                            blockSize, blockSize);
                    //검정 테두리
                    g.setColor(Color.BLACK);
                    g.drawRect(startX+j*blockSize, startY+i*blockSize,
                            blockSize, blockSize);
                }
            }
        }
    }

    //blockNum - 출력할 블록 모양 결정
    //arrX, arrY - gameArr 에서의 위치좌표
    public void drawBlock(int blockNum, int arrX, int arrY){
        for(int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                if (blocks[blockNum][i][j] == 1) {
                    gameArr[arrY + i][arrX + j] = 2;
                }
            }
        }
    }
    public void deleteBlock(int blockNum, int arrX, int arrY ){
        for(int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                if (blocks[blockNum][i][j] == 1) {
                    gameArr[arrY + i][arrX + j] = 0;
                }
            }
        }
    }

    public void fixBlock(int blockNum, int arrX, int arrY){
        for(int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                if (blocks[blockNum][i][j] == 1) {
                    gameArr[arrY + i][arrX + j] = 1;
                }
            }
        }
    }

    public void drawFrame(){
        for(int i=0; i<21; i++){
            for(int j=0; j<12;j++){
                if(j==0 || j==11)
                    gameArr[i][j] = 1;
                else if(i ==20)
                    gameArr[i][j] = 1;
            }
        }
    }
    public boolean detectCollision(int blockNum, int arrX, int arrY){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(blocks[blockNum][i][j] == 1){
                    if(gameArr[arrY+i][arrX+j] == 1)
                        return true;
                }
            }
        }

        return false;
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

class MyPanel extends JPanel implements Runnable, KeyListener { //JPanel 상속
    MyComponents com = new MyComponents();

    MyPanel(){
        requestFocus();
        setFocusable(true);
        addKeyListener(this);
        Thread myThread = new Thread(this);
        myThread.start();
    }

    @Override //JPanel 안에 있는 함수를 쓴다는 뜻.
    protected void paintComponent(Graphics g) {
        //우리가 만들어 놓은 창 위에 그림을 그려주는 함수.
        super.paintComponent(g);
        com.drawGameArr(g);
    }

    @Override
    public void run() {
        while(true) {
            com.getRandomBlockNum();
            com.initPosition();
            com.drawBlock(com.blockNum, com.x, com.y);
            while (true) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                moveDown(com.blockNum);
                System.out.println(com.x + " : " + com.y);
                if (com.detectCollision(com.blockNum, com.x, com.y+1)) {
                    com.fixBlock(com.blockNum, com.x, com.y);
                    break;
                }
            }
        }
    }
    public void moveDown(int blockNum){
        if(!com.detectCollision(blockNum, com.x, com.y+1)){
            com.deleteBlock(blockNum, com.x, com.y);
            com.y++;
            com.drawBlock(blockNum, com.x, com.y);
            repaint();
        }
    }
    public void moveRight(int blockNum){
        System.out.println("move right func start");
        if(!com.detectCollision(blockNum, com.x+1, com.y)){
            com.deleteBlock(blockNum, com.x, com.y);
            com.x++;
            com.drawBlock(blockNum, com.x, com.y);
            repaint();
            System.out.println("move right");
        }
    }
    public void moveLeft(int blockNum){
        System.out.println("move left func start");
        if(!com.detectCollision(blockNum, com.x-1, com.y)){
            com.deleteBlock(blockNum, com.x, com.y);
            com.x--;
            com.drawBlock(blockNum, com.x, com.y);
            repaint();
            System.out.println("move left");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
       switch(e.getKeyCode()){
           case KeyEvent.VK_DOWN:
               System.out.println("down");
               break;
           case KeyEvent.VK_UP:
               break;
           case KeyEvent.VK_LEFT:
               moveLeft(com.blockNum);
               break;
           case KeyEvent.VK_RIGHT:
               moveRight(com.blockNum);
               break;
           default:
               break;
       }
       repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) { }
}

//테트리스 클래스
public class Tetris extends JFrame{ //JFrame 상속

    //생성자 : 클래스가 생성될 때 아래 코드가 실행된다
    Tetris(){
        //생성자
        setTitle("Tetris Window"); //상단 메뉴바의 텍스트 지정
        setDefaultCloseOperation(EXIT_ON_CLOSE); //이건 그냥 적자
        setSize(800,800); //윈도우의 사이즈 지정
        add(new MyPanel()); //프레임에 패널을 추가
        setVisible(true); //윈도우가 보이도록 설정
    }

    public static void main(String[] args) { //메인함수
        Tetris a = new Tetris(); //객체를 생성하는 명령어
//        Tetris b = new Tetris();
        //클래스와 객체의 관계
    }
}

