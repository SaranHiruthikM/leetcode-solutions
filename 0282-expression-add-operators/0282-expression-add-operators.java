class Solution {
    List<String> res = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        dfs(num, target, 0, "", 0, 0);
        return res;
    }

    private void dfs(String num, int target, int index, String path, long value, long prev) {

        if (index == num.length()) {
            if (value == target) {
                res.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {

            // prevent leading zeros
            if (i != index && num.charAt(index) == '0') break;

            String curStr = num.substring(index, i + 1);
            long cur = Long.parseLong(curStr);

            if (index == 0) {
                // first number (no operator)
                dfs(num, target, i + 1, curStr, cur, cur);
            } else {

                // addition
                dfs(num, target, i + 1, path + "+" + curStr, value + cur, cur);

                // subtraction
                dfs(num, target, i + 1, path + "-" + curStr, value - cur, -cur);

                // multiplication
                dfs(num, target, i + 1, path + "*" + curStr,
                        value - prev + prev * cur,
                        prev * cur);
            }
        }
    }
}