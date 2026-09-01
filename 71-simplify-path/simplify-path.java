class Solution {
    public String simplifyPath(String paths) {
        String[] pathArr = paths.split("/");
        Stack<String> st = new Stack<>();
        for(String path : pathArr){
            if(path.equals(".") || path.equals("")) continue;
            if(!path.equals("..")){
                st.push(path);
            }else if(!st.isEmpty()){
                st.pop();
            }

        }

        if(st.isEmpty()){
            return "/";
        }

        String res = "";
        while(!st.isEmpty()){
            res = String.format("/%s", st.pop()) + res;
        }

        return res;
    }
}