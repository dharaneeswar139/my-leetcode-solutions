class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c == '*'){
                if(sb.length() > 0){
                    sb.deleteCharAt(sb.length() - 1);
                }
            }else if(c == '%'){
                sb.reverse();
            }else if(c == '#'){
                sb.append(sb);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}