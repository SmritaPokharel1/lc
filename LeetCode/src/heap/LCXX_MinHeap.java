package heap;

public class LCXX_MinHeap {

    private int[] heap;
    private int size;

    public LCXX_MinHeap(int capacity){

        heap = new int[capacity];
        this.size = 0;
    }

    public void insert(int val){

        int current = size;

        heap[current] = val;
        size++;

        int parent = (current - 1)/2;

        while(current > 0 && heap[parent] > heap[current]){

            swap(parent,current);
            current = parent;
        }
    }

    public int peek(){

        if(size==0) throw new RuntimeException();

        return heap[0];
    }

    public int remove(){

        int top = heap[0];
        int bottomRight = heap[size-1];

        heap[0] = bottomRight;
        size --;

        heapify(0);

        return top;
    }

    public void heapify(int index){

        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;

        if(left < size && heap[smallest] > heap[left]){
            smallest = left;
        }

        if(right < size && heap[smallest] > heap[right]){
            smallest = right;
        }

        if(smallest != index){

            swap(smallest, index);
            heapify(smallest);
        }
    }

    public void swap(int current, int parent){

        int temp = heap[parent];

        heap[parent] = heap[current];
        heap[current] = temp;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LCXX_MinHeap babyHeap = new LCXX_MinHeap(10);
        babyHeap.insert(5);
        babyHeap.insert(3);
        babyHeap.insert(8);
        babyHeap.insert(1);
        babyHeap.insert(2);

        babyHeap.printHeap();          // Maybe: 1 2 8 5 3
        System.out.println(babyHeap.peek());   // 1
        System.out.println(babyHeap.remove()); // 1
        babyHeap.printHeap();          // New heap after removing 1
    }
}
