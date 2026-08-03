import java.util.PriorityQueue;

public class Leetcode703 {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public Leetcode703(int k, int[] nums) {

        this.k = k;

        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {

   
        minHeap.offer(val);

        if (minHeap.size() > k) {
            minHeap.poll();
        }

    
        return minHeap.peek();
    }
}
