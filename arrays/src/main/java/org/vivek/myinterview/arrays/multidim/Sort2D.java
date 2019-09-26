/**
 * 
 */
package org.vivek.myinterview.arrays.multidim;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Vivek
 *
 */
public class Sort2D {

  /**
   * @param args
   */
  public static void main(String[] args) {
    int[][] m = initializeArray();
    final int rows = m.length;
    final int cols = m[0].length;
    int [][] n = new int [rows][cols];
    //int[] firstcolumn= getColumn(m, 0);
   // Arrays.sort(firstcolumn);
    Stream.of(m).map(Arrays::toString).forEach(System.out::println);
    n= rotate(m);
    Stream.of(n).map(Arrays::toString).forEach(System.out::println);

  }
  static int[][] rotate(int[][] mat) {
    final int rows = mat.length;
    final int cols = mat[0].length;
    int[][] ret = new int[cols][rows];
    int[][] ret1 = new int[cols][rows];
    int []firstcolumn = new int[rows ];
    for (int r = 0; r < rows; r++) {
     
      firstcolumn[r] = mat[r][0];
        for (int c = 0; c < cols; c++) {
            ret[c][rows-1-r] = mat[r][c];
        }
    }
    Arrays.sort(firstcolumn);
    System.out.println("sorted="+Arrays.toString(firstcolumn));
    Map<Integer,Integer> map = new HashMap<>();
    int index=0;
    for(int i : firstcolumn) {
      map.put(i,index++);
    }
    map.forEach((k,v)->System.out.println("key="+k +" .value="+v));
    int rows1 = ret.length;
    int cols1 = ret[0].length;
    int []firstcolumn1 = new int[rows1 ];
    for (int r = 0; r < rows1; r++) {
      index =0;
       // for (int c = 0; c < cols1; c++) {
         // System.out.println("herer=> "+r +"element="+ret[r][c]+ ",mapkey="+map.get(ret[r][c]));
    
          if(map.get(ret[r][index])!=null){
            int k= map.get(ret[r][index]);
            ret1[k][r] = ret[r][c];
          }
         
         
       // }
    }
    
    
  //  System.out.println("sorted1="+Arrays.toString(firstcolumn1));
    return ret1;
}
  static int[] getColumn(int[][] matrix, int column) {
    return IntStream.range(0, matrix.length)
        .map(i -> matrix[i][column]).toArray();
}
  private static int[][] initializeArray() {
    int[][] m = { {5, 12, 17, 21, 23},
        {1,  2,  4,  6,  8},
        {12, 14, 18, 19, 27},
        {3,  7,  9, 15, 25}
};
      return m;
  }

}
