import java.util.*;
public class Leetcode435
{
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int removes=0;
        int prevStart=intervals[0][0];
        int prevEnd=intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            int currStart=intervals[i][0];
            int currEnd=intervals[i][1];
            if(prevEnd<=currStart){
                prevStart=currStart;
                prevEnd=currEnd;
            }
            else{
                removes++;
                if(currEnd<prevEnd){
                    prevStart=currStart;
                    prevEnd=currEnd;
                }
            }
        }
        return removes;
        
    }
}