class Solution {
    public int[][] kClosest(int[][] points, int k) {
        class pair
        {
            int first;
            int second;
            pair (int first, int second)
            {
                this.first =first;
                this.second =second;
            }
        }
        
        PriorityQueue<pair> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.first!=b.first)
                {
                    return b.first-a.first;
                }
                else
                {
                    return b.second-a.second;
                }
            }
        );
        for(int i=0;i<k;i++)
        {
           int distance = dist(points[i]);
            pq.offer(new pair(distance,i));
        }
        for(int i =k; i<points.length;i++)
        {
            int distance = dist(points[i]);
            pq.offer(new pair (distance,i));
            pq.poll();

        }
        
        
        int[][] ans = new int[k][2];
        for(int i =0;i<k;i++)
        {
            //ans[i][0]= pq.poll().first;
         int  knowindex=pq.poll().second;
         ans[i][0]=points[knowindex][0];
         ans[i][1]=points[knowindex][1];
         


        }
        return ans;

        
    }
    public int dist(int[] arr)
    {
        int x= arr[0];
        int y = arr[1];
       
        return x * x + y * y;
    }
}