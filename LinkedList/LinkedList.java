package LinkedList;

public class LinkedList {

    class Node{
        Node next;
        int data;

        Node(int data){
            this.data=data;
        }
    }

    Node head;

    public void insertAtFront(int data){
        Node n = new Node(data);
        n.next =head;
        head = n;
    }

    public void insertAfterNode(Node n,int data){
         int findNodeData = n.data;
         Node temp = head;
         while(temp!=null){
             if(temp.data == findNodeData){
                 Node newNode  = new Node(data);
                 newNode.next = temp.next;
                 temp.next = newNode;
                 break;
             }
             temp = temp.next;
         }
    }

    public void insertAtEnd(int data) {

        Node n = new Node(data);
        if(head ==null){
            head = n;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = n;

        //optimisation possible with a tail pointer
    }

    public void printList(){
        Node temp  = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
    }

    public void deleteNode(int key){
        Node temp = head;
        Node prev = null;
        if(temp!=null && temp.data == key){
            head=head.next;
            return;
        }
        while(temp!=null && temp.data!=key){
            prev = temp;
            temp=temp.next;
        }

        if(temp==null)
            return;

        prev.next = temp.next;

    }

    public void reverse(){
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public boolean Search(int key){
        Node temp = head;

        while(temp!=null){
            if(temp.data == key)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public static void main(String args[]){

        LinkedList list =new LinkedList();
        list.insertAtFront(5);
        list.insertAtFront(6);
        list.insertAtEnd(7);
        list.deleteNode(5);
        list.printList();
        System.out.println();
        list.insertAtFront(5);
        list.reverse();
        list.printList();
        System.out.println(list.Search(6));
        System.out.println(list.Search(9));
    }

}
