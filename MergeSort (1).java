import java.util.ArrayList;
/**
 * Write a description of class MergeSort here.
 *
 * @author Louis
 * @version 4/15/2024
 */
public class MergeSort
{
    
       public static int[] mergeSort(int[] a)
    {
        if (a.length <= 1)return a;

        
        int[] arr1 = new int[(a.length/2)];
        int[] arr2 = new int[a.length-(a.length/2)];
        
        for (int i = 0; i < (a.length/2); i++){
            arr1[i] = a[i];
        }

        
        for (int i = (a.length/2); i < a.length; i++) {
            arr2[i - (a.length/2)] = a[i];
        }
        
        
        
        arr1 = mergeSort(arr1);
        arr2 = mergeSort(arr2);
        
        return merge(arr1,arr2);
        
        
    }
    
    public static int[] merge(int[] a, int[] b)
    {
        ArrayList<Integer> tempC = new ArrayList<Integer>();
        ArrayList<Integer> tempA = new ArrayList<Integer>();
        ArrayList<Integer> tempB = new ArrayList<Integer>();
        
        
        for(int i:a)tempA.add(i);
        for(int i:b)tempB.add(i);
        
        
        while(tempA.size() > 0 && tempB.size() > 0){
            if (tempA.get(0) > tempB.get(0)){
                tempC.add(tempB.remove(0));
                
            }
            else{
                tempC.add(tempA.remove(0));
                
            }
            
        }
        
        
        
        while (tempA.size() > 0){
            tempC.add(tempA.get(0));
            tempA.remove(tempA.get(0));
        }
        
        while (tempB.size() > 0){
            tempC.add(tempB.get(0));
            tempB.remove(tempB.get(0));
        }
        
        int[] c = new int[tempC.size()];
        for(int i = 0; i < tempC.size(); i++){
            c[i] = tempC.get(i);
        }
        
        return c;
        
        
          }
    
    public static void main(String[] args)
    {
        int[] arr = {1,9,5,7,2,-1,3,11,0,8};
           int [] result = MergeSort.mergeSort(arr);
        for(int i=0;i<result.length;i++)
            System.out.print(result[i] + " ");
        System.out.println();
        
    }
}


