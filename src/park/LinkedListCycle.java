package park;

import java.util.LinkedList;

public class LinkedListCycle {
    LinkedList<Node> park;

    public LinkedListCycle(){
        park = new LinkedList<Node>();
    }

    public void add(char c, int size){

        if(park.size()==size-1){
            Node t = park.peekLast();
            Node n = new Node(c,park.peekLast());
            this.park.add(n);
            t.next=n;
            n.next = park.peekFirst();
            park.peekFirst().prev=n;
        }
        else if (park.size()==0){
            Node n = new Node(c);
            this.park.add(n);
        }
        else{
            Node t = park.peekLast();
            Node n = new Node(c,park.peekLast());
            this.park.add(n);
            t.next = n ;
        }

    }

    public Node getHead(){
        return park.peekFirst();
    }

    class Node{
        char data;
        Node next;
        Node prev;

        public Node(char c){
            this.data=c;
        }
        public Node(char c, Node t){
            this.data=c;
            this.prev=t;
        }

        public void setData( char c){
            this.data = c;
        }
        public char getData(){
            return this.data;
        }
        public Node getNext(){
            return this.next;
        }

        public Node getPrev(){
            return this.prev;
        }
    }
}
