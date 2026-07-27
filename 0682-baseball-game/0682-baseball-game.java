class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer>st=new Stack<>();
        int ans=0;
        for(String op:ops){
            if(op.equals("+")){
                int top=st.pop();
                int nt=top+st.peek();
                st.push(top);
                st.push(nt);
            }else if(op.equals("C")){
                ans-=st.pop();
                continue;
            }else if(op.equals("D")){
                st.push(2*st.peek());
            }else{
                st.push(Integer.valueOf(op));
            }
            ans+=st.peek();
        }
        return ans;
    }
}