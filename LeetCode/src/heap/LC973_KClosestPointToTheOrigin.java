package heap;

import java.util.PriorityQueue;

/**
 *
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 *
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 *
 * https://leetcode.com/problems/k-closest-points-to-origin/description/
 */
public class LC973_KClosestPointToTheOrigin {

    class Result{

        public int[] point;
        public double distance;

        public Result(int[] point, double distance){

            this.point = point;
            this.distance = distance;
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Result> heap = new PriorityQueue<Result>((r1, r2)-> Double.compare(r2.distance, r1.distance));

        for(int[] p: points){

            double distance = Math.sqrt(p[0]* p[0] + p[1]*p[1]);

            Result result = new Result(p,distance);

            heap.add(result);

            if(heap.size() > k) heap.poll();
        }


        int[][] result = new int[heap.size()][2];

        int index = 0;

        while(!heap.isEmpty()){

            Result r = heap.poll();

            result[index] = r.point;
            index ++;
        }

        return result;
    }
}
