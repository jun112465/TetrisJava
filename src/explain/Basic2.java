package explain;

import java.lang.reflect.Array;
import java.util.*;

public class Basic2 {
    public static void main(String[] args) {

        int[] arr1 = new int[5];
        //1차원 배열
//        int[] arr2 = {1,2,3,4};
        int[] arr2 = new int[4];
        arr2[0] = 1;
        arr2[1] = 2;
        arr2[2] = 3;
        arr2[3] = 4;
        //2차원 배열
//        int[][] arr3 = {
//                {1,2,3,4},
//                {1,2,3,4}
//        };
        int[][] arr3 = new int[2][4];
        //3차원 배열
        int [][][] arr4 = {
                {
                        {1,2,3,4},
                        {1,2,3,4}
                },
                {
                        {5,6,7,8},
                        {7,8,9,10}
                }
        };

        //2차원 배열 선언
        int[][] arr5 = new int[10][10];




    }

    public static void test(){

    }
}
