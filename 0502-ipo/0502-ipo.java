class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        // arry 2d

       
         int n=profits.length;
         int[][] project= new int[n][2];
         for(int i=0;i<n;i++)
         {
            project[i][0]=capital[i];
            project[i][1]=profits[i];
            
         }
        Arrays.sort(project,(a,b)->Integer.compare(a[0],b[0]));
        int idx=0;
        while(k>0)
        {
            //choices
            while(idx<n &&project[idx][0]<=w )
            {
                
                    pq.offer(project[idx][1]);
              
                idx++;

            }
            //adding to ans
            if(pq.isEmpty())
            {
                return w;
            }
            
            int proft = pq.poll();
            w += proft;
            
            k--;
        }
        return w;

    }
}