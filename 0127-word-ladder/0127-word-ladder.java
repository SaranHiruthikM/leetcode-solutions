class Pair {
    String first;
    int second;

    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> set = new HashSet<String>();
        for(int i=0; i<wordList.size(); i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            String word = curr.first;
            if(word.equals(endWord)) return curr.second;
            for(int i=0; i<word.length(); i++){
                for(char ch='a'; ch<='z'; ch++){
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if(set.contains(replacedWord)){
                        q.offer(new Pair(replacedWord, curr.second + 1));
                        set.remove(replacedWord);
                    }
                }
            }
        }

        return 0;
    }
}