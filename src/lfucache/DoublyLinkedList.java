package lfucache;

public class DoublyLinkedList <K,V>{
    Node<K,V> head;
    Node<K,V> tail;


    public DoublyLinkedList(){
        head=new Node<>(null,null);
        tail=new Node<>(null,null);
        head.next=tail;
        tail.prev=head;

    }

    public void addFirst(Node<K,V> node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }

    public void remove(Node<K,V> node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public Node<K,V> removeLast(){
        if(head.next==tail){
            return null;
        }
        Node<K,V> temp=tail.prev;
        remove(temp);
        return temp;
    }

    public boolean isEmpty() {
        if(head.next==tail){
            return true;
        }
        return false;
    }
}
