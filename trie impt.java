import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class HelloWorld{

     public static void main(String []args){
        List<String> ss=new ArrayList<>();
        ss.add("pqrs");
        ss.add("pprt");
        ss.add("psst");
        ss.add("qqrs");
        ss.add("pqrs");
        Trie tr=new Trie();
        ss.forEach(tr::insert);
        System.out.println(tr.query("abc"));
     }
}
class Trie{
    Node start;//starting node
    public Trie()
    {
        this.start=new Node();
    }
    public int query(String s)
    {
        Node current=start.next(s.charAt(0));
        for(int i=1;i<s.length();i++){
         if(current==null)
        {
            return 0;
        }
        current=current.next(s.charAt(i));
        }
        return current.count;
    }
    public void insert(String s)
    {
     Node current=start;
     for(int i=0;i<s.length();i++)
     {
         if(current.TNodes[s.charAt(i)-'a']==null){
             current.TNodes[s.charAt(i)-'a']=new Node();
         }
         current=current.next(s.charAt(i));
     }
     current.count++;
    }
}
class Node{
    int count;//keeps count of terminating strings at this point
    Node[] TNodes=new Node[26];
    public Node next(char ch)
    {
        return TNodes[ch-'a'];
    }
}