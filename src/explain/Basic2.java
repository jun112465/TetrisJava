package explain;

import java.lang.reflect.Array;
import java.util.*;

public class Basic2 {
    public static void main(String[] args) {
        int[][] arr1 = new int[3][3];
        int[][] arr2 = new int[3][3];

        int k = 0;
        int u = 9;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                arr1[i][j] = k++;
                arr2[i][j] = u++;
            }
        }

        arr1[0] = arr2[0].clone();

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.println(arr1[i][j]);
            }
        }
    }
}
