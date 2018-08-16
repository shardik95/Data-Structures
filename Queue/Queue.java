package Queue;

public class Queue<T> {

    private class QueueNode<T>{

        T data;
        QueueNode<T> next;

        QueueNode(T data){
            this.data = data;
            this.next = null;
        }
    }

    QueueNode<T> first;
    QueueNode<T> last;

    public void add(T data){
        QueueNode<T> newNode = new QueueNode<T>(data);
        if(last!=null){
            last.next = newNode;
        }
        last = newNode;
        if(first==null)
            first = newNode;
    }

    public T remove(){
        if(first==null)
            return null;
        T ret = first.data;
        first=first.next;
        if(first==null)
            last=null;
        return ret;
    }

    public T peek(){
        if(first==null)
            return null;
        return first.data;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public static void main(String args[]){
        Queue<Integer> queue =new Queue<Integer>();
        queue.add(5);
        queue.add(6);
        System.out.println(queue.peek());
        queue.remove();
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
        queue.remove();
        System.out.println(queue.isEmpty());
    }


}
