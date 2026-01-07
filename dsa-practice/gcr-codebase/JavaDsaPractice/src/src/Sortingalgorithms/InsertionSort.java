package src.Sortingalgorithms;

public class InsertionSort {
    public static void main(String [] args) {
    	int arr[]= {5,7,3,2,8};
    	for(int i=1;i<arr.length;i++) {
    		int current=i;
    		int j=i-1;
            while(j>=0 && current<arr[j]) {
            	arr[j+1]=arr[j];
            	j--;
            }
            arr[j+1]=current;	
    	}
    	System.out.println(arr);
    }
}
