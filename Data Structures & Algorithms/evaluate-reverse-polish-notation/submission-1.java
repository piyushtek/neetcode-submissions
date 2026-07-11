class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(String x:tokens){
            if(x.equals("+") || x.equals("*") ||  x.equals("-") || x.equals("/")){
                System.out.println(st);
                
                int x1=st.pop();
                
                int x2=st.pop();
                if(x.equals("+"))
                    st.push(x1+x2);
                if(x.equals("*"))
                    st.push(x1*x2);
                if(x.equals("-"))
                    st.push(x2-x1);
                if(x.equals("/"))
                    st.push(x2/x1);        
                
            }
            else{
                st.push(Integer.parseInt(x));
            }
        }
        return st.peek();
    }
}
