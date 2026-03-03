class Solution {
    public String frequencySort(String s) {
          Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Convert map to list
        List<Map.Entry<Character, Integer>> list = 
                new ArrayList<>(map.entrySet());

        // Step 3: Sort by frequency in decreasing order
        list.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        // Step 4: Build result using StringBuilder
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : list) {
            char ch = entry.getKey();
            int freq = entry.getValue();

            for (int i = 0; i < freq; i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}