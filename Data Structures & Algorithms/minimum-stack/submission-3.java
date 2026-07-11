class MinStack {

    class Node{
        int val;
        int min;
        Node(int v,int m){
            val=v;
            min=m;
        }
        public String toString(){
            return val+" "+ min;
        }
    }
    
    Stack<Node> st;
    int currMin;
    public MinStack() {
        st=new Stack<>();
        currMin=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        int min=currMin;
        if(val<currMin){
            currMin=val;
            min=val;
        }
        st.push(new Node(val,min));
        System.out.println(st);
    }


    public void pop() {
        if(!st.isEmpty()){
            st.pop();
            if(!st.isEmpty())
                currMin=st.peek().min;
        }
        
        if(st.isEmpty()){
            currMin=Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        if(!st.isEmpty()){
            return st.peek().val;
        }
        return -1;
    }
    
    public int getMin() {
        if(!st.isEmpty()){
            return st.peek().min;
        }
        return -1;
    }
}
