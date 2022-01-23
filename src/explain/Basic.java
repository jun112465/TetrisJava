package explain;

public class Basic {


    public static void main (String[] args) {
//        int k = 10;
//        drawStars(k); //drawStars 함수에 k값을 매개변수로 줬다.
//
//        int a = 5;
//        drawStars(a); //함수호출
//
//        int b = 15;
//        drawStars(b);


//        printTimeTable();
//        System.out.println("hello" + "현");

//        int f1 = isOver50(51);
//        f1 = 1;
//
//        int f2 = isOver50(40);
//        System.out.println(f1);
//        System.out.println(f2);
//        printChessStage();
        printSquare();
    }

    //함수를 호출할 때 매개변수를 지정해서 함수 내부에서 사용할 수 있다.
    //별 n개를 출력해주는 기능을 가진 함출
    //함수정의
    public static void drawStars(int n){ //n 이라는 매개변수 존재

        //n을 활용
        for(int i=0; i<n; i++)
            System.out.print("*");
        System.out.println();
    }

    public static void testArray() {
        //배열은 - 변수의 집합
        int[] arr; //배열을 생성
    }


    public static void printZeroToNine(){
        int[] arr = new int[10];
        for(int i=0; i<arr.length; i++){
            arr[i] = i;
            System.out.println(arr[i]);
        }
    }

    public static void printTimeTable(int k){
        for(int i=1; i<=9; i++){
            System.out.println(i + " * " + k + " = " + i*k);
        }
    }

    public static int isOver50(int n){
        if(n >= 50)
            return 1;
        else
            return 0;
    }
//    public static void printSquareStar(){
//        for(int i=0; i<5; i++) {
////            drawStars(5);
//            for(int j=0; j<5; j++)
//                System.out.print("*");
//            System.out.println();
//        }
//    }


    public static void printChessStage(){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(i%2 == 0){
                    if(j%2 == 0) System.out.print("*");
                    else System.out.print("ㅁ");
                }
                else{
                    if(j%2 == 0) System.out.print("ㅁ");
                    else System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public static void printSquare(){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(i==0 || i==7)
                    System.out.print("ㅁ");
                else{
                    if(j==0 || j==7) System.out.print("ㅁ");
                    else System.out.print("ㅇ");
                }
            }
            System.out.println();
        }
    }

}
