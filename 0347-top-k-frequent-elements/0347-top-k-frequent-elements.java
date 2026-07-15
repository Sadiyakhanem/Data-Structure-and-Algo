class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        class pair
        {
            int first;
            int second;
            pair(int first, int second)
            {
                this.first =first;
                this.second =second;
            }
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->
        {
            if(a.first!=b.first)
            {
                return a.first-b.first;
            }
            else
            {
                return a.second-b.second;
            }
        });
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<nums.length;i++)
        {
            int numb = nums[i];
           
            map.put(numb, map.getOrDefault(numb,0)+1);

        }
        int count=0;
        
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            
            int number = entry.getKey();
            int freq = entry.getValue();

          if(count<k)
          {
            pq.offer(new pair(freq,number));
            count++;
          }
          else{
            if(pq.peek().first<freq)
            {
                pq.poll();
                pq.offer(new pair(freq,number));
            }
            else
            {
                continue;
            }
          }


        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++)
        {
            ans[i]=pq.poll().second;
        }

        return ans;


        
    }
}