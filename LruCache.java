public class LruCache{
class Node{
int data;
Node previous;
Node next;
public Node(int data)
{
this.data=data;
}
}
 Node head,tail=null;
 int insert_count=1,max_size=5;//maximum queue lenght is 5
public void insert(int val)
{
    if(insert_count>max_size)
    {
        deq();
        enq(val);
    }
    else
    enq(val);
}
public boolean doesexist(int val)//checks if element exist
{
    Node current=head;
    while(current!=null)
    {
        if(current.data==val)
        return true;
        current=current.next;
    }
    return false;
}
public void fetch(int val)
{
    System.out.println("fetching "+val);
    if(doesexist(val))
    {
       deleteNode(val);
       enq(val);
    }
    else{
    insert(val);
    }
    display();
    System.out.println("");
}
public void deleteNode(int data) //delete at any node
    { 
  
         Node current=head;
        if (head == null) { 
            System.out.println("queue is empty");
        } 
        if (head.data== data) { 
            head=head.next;
            return;
        } 
        if(tail.data==data)
        {
            deq();
            return;
        }
    else{
        while(current!=null && current.data!=data)
        {
            current=current.next;
        }
        if(current.previous!=null)
        {
            current.previous.next=current.next;
        }
        if(current.next!=null)
        {    
            current.next.previous=current.previous;
        }
        else
        System.out.println("node doesnt exist");
    }
    }  
public void enq(int data)/*enqueue operation*/
{
  Node newNode = new Node(data);
 if(head==null)
 {
     tail=head=newNode;
     insert_count+=1;/*for maintaining  count of no.of elements in queue*/
 }
 else{
newNode.next=head;
head.previous=newNode;
head=newNode;
Node current=head;
  insert_count+=1;;
     
 }
}
 public void display() {  
            Node current = head;  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        System.out.println("Nodes of doubly linked list: ");  
        while(current != null) {  
            System.out.print(current.data + " ");  
            current = current.next;  
        }
        System.out.println();
        
    }
public void deq()/*dequeue operation*/
{
    if(head==null)
    System.out.println("queue is empty");
    else{
        tail=tail.previous;
        if(tail==null)
        head=null;
        else
        tail.next=null;
        insert_count=insert_count-1;
    }
}
public static void main(String[] args)
{
LruCache list=new LruCache();
list.fetch(1);
list.fetch(2);
list.fetch(3);
list.fetch(1);
list.fetch(4);
list.fetch(5);
list.fetch(6);
list.fetch(4);
list.fetch(90);
list.fetch(5);
list.fetch(45);
list.fetch(78);
}
}
