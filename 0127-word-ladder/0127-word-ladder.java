class Solution {
      class Pair {
        String word;
        int level;

        Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
      }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
       HashSet<String> set = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<wordList.size();i++)
        {
             set.add(wordList.get(i));
        }
        q.offer(new Pair(beginWord,1));
        while(!q.isEmpty())
        {
            Pair  p =q.poll();
            String word =p.word;
            int level =p.level;
            if(word.equals(endWord))
            {
                return level;
            }
            char[] arr=word.toCharArray(); 
        for(int i=0;i<arr.length;i++)
        {
            char org = arr[i];

            for(char ch ='a';ch<='z';ch++)
            {
                arr[i]=ch;
                String newword =new String(arr);
                if(set.contains(newword))
                {
                      q.offer(new Pair(newword, level + 1));
                      set.remove(newword);
                }


            }
            arr[i]=org;
        }
        }
        return 0;


    }
}
