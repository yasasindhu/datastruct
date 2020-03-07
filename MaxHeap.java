import java.io.*;
public class MaxHeap{

     public static void main(String []args){
       // int arr[]={1,2,3};
        int arr[]={ 1,2,3,4,5,6,7,8};
        MaxHeap h=new MaxHeap();
        h.buildHeap(arr);
        for(int i=0;i<arr.length;i++)
        System.out.print(" "+arr[i]);
       
     }
      
     public  void buildHeap(int[] arr)
     {
         for(int i=(arr.length/2);i>=0;i--)//starting from first parent leaving leaf nodes
         {
             System.out.println(i);
         heapify(i,arr);
         }
     }
    
 public void heapify(int parent_index,int arr[]) 
    { 
        int max= parent_index;
        int left_index = left(parent_index);  
        int right_index = right(parent_index);  
  
        
        if (left_index<arr.length && arr[left_index] > arr[max]) 
            max = left_index; 
  
        if (right_index< arr.length && arr[right_index] > arr[max]) 
            max = right_index; 
        
        if (max!= parent_index) { 
            int temp= arr[parent_index]; 
            arr[parent_index] = arr[max]; 
            arr[max] = temp; 
 
            heapify(max,arr); 
        } 
        else
        return ;
    } 
  
        public int left(int i)
        {
            
            return 2*i+1;
        }
        public int right(int i)
        {
            return 2*i+2;
        }
}
