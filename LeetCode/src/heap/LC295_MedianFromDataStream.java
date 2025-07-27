package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LC295_MedianFromDataStream {

    private PriorityQueue<Integer> min;

    private PriorityQueue<Integer> max;

    public LC295_MedianFromDataStream() {

        min = new PriorityQueue<Integer>();
        max = new PriorityQueue<Integer>(Collections.reverseOrder());
    }

    public void addNum(int num) {

        max.add(num);
        min.add(max.poll());

        if(min.size() > max.size()) max.add(min.poll());
    }

    public double findMedian() {

        if(max.size() == min.size()) return (min.peek() + max.peek()) / 2.00;

        return max.peek();
    }
}
