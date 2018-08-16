package Stack;

public class Stack<T> {

    private class StackNode<T> {

        private T data;
        private StackNode<T> next;

        StackNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private StackNode<T> top;

    public void push(T data){
        StackNode<T> stk = new StackNode<T>(data);
        if(top!=null){
            top.next = stk;
        }
        top = stk;
    }

    public T peek(){
        if(top!=null)
            return top.data;
        return null;
    }

    public boolean isEmpty(){
        return top==null;
    }

    public T pop(){
        if(top!=null){
            T ret = top.data;
            top = top.next;
            return ret;
        }
        return null;
    }

    public static void main(String args[]){
        Stack<Integer> stk = new Stack<Integer>();
        System.out.println(stk.isEmpty());
        stk.push(5);
        System.out.println(stk.peek());
        System.out.println(stk.isEmpty());
        System.out.println(stk.pop());
        System.out.println(stk.isEmpty());
    }

}
