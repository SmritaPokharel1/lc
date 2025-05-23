package matrix;


import java.util.Arrays;
import java.util.List;

//Given a triangle array, return the minimum path sum from top to bottom.
//For each step, you may move to an adjacent number of the row below.
// More formally, if you are on index i on the current row,
// you may move to either index i or index i + 1 on the next row.
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        int size = triangle.size();

        int[][] memo = new int[size][triangle.get(size-1).size()];

        for (int i = 0; i < size; i++) {
            memo[i] = new int[triangle.get(i).size()];
            Arrays.fill(memo[i], -1);
        }

        return path(triangle, 0,0, memo);
    }

    public int path(List<List<Integer>> triangle, int next, int i, int[][] memo){

        if(next >= triangle.size() || i >= triangle.get(next).size()) return 0;

        if(next==triangle.size() -1) return triangle.get(next).get(i);

        if(memo[next][i]!=-1) return memo[next][i];

        memo[next][i] = triangle.get(next).get(i) + Math.min(path(triangle,next+1,i,memo), path(triangle,next+1, i+1,memo));

        return memo[next][i];
    }
}
