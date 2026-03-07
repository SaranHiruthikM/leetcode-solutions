class Solution {

    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        helper(s, 0, new ArrayList<>());
        return res;
    }

    public void helper(String s, int index, List<String> parts){

        if(parts.size() == 4){
            if(index == s.length()){
                res.add(String.join(".", parts));
            }
            return;
        }

        for(int len = 1; len <= 3; len++){

            if(index + len > s.length()) break;

            String segment = s.substring(index, index + len);

            if(isValid(segment)){
                parts.add(segment);
                helper(s, index + len, parts);
                parts.remove(parts.size() - 1);
            }
        }
    }

    public boolean isValid(String segment){

        if(segment.length() > 1 && segment.charAt(0) == '0')
            return false;

        int val = Integer.parseInt(segment);

        return val <= 255;
    }
}