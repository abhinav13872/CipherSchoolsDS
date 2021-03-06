package SORTING;
import java.util.Scanner;



public class MergeSort
{
static Scanner sc=new Scanner(System.in);

public static void main(String [] args)
{
System.out.print("TESTCASES: ");
int T=sc.nextInt();

while(T-- > 0)
{
System.out.print("SIZE OF AN ARRAY: ");
int n=sc.nextInt();
int arr[]=new int[n];

System.out.print("ARRAY: ");
for(int i=0;i<n;i++) arr[i]=sc.nextInt();

MergeSort(arr,0,arr.length-1);
Print(arr,n);
}
}



private static void MergeSort(int arr[],int L,int R)
{
if(L < R)
{
//GET MID INDEX
int Mid=(L+R)/2;

//SORT THE FIRST & SECOND HALVES..
MergeSort(arr,L,Mid);
MergeSort(arr,Mid+1,R);

//MERGE THE SORTED HALVES
Merge(arr,L,Mid,R);
}
}



private static void Merge(int arr[],int l,int mid,int r)
{
// Find sizes of two subarrays to be merged 
int n1=mid-l+1; 
int n2=r-mid; 

/* Create temp arrays */
int L[]=new int[n1];
int R[]=new int[n2];

/*Copy data to temp arrays*/
for(int i=0; i<n1; i++) L[i] = arr[l+i]; 
for(int j=0; j<n2; j++) R[j] = arr[mid+1+j]; 


// MERGE:-
// Initial indexes of first and second subarrays 
int i=0,j=0; 

// Initial index of merged subarry array 
int k=l;
while(i < n1 && j < n2) 
{
if (L[i] <= R[j]) arr[k++] = L[i++];
else arr[k++] = R[j++];
}

/* Copy remaining elements of L[] if any */
while(i < n1) arr[k++] = L[i++]; 

/* Copy remaining elements of R[] if any */
while(j < n2) arr[k++] = R[j++]; 
}




private static void Print(int arr[],int n)					//PRINT-METHOD
{
System.out.print("ARRAY: ");
for(int i=0;i<n;i++) System.out.print(arr[i] + ((i != n-1) ? " " : "\n\n"));
}
}

/*
#MERGE_SORT:-
=>In this algorithm we use DIVIDE AND CONQUER Technique.

=>Divide till all the elements get isolated, and then
  Compare and Merge the sorted halves reccurssively.


#TIME-COMPLEXITY:-
 ->Best Case   : O(n*logn)
 ->Average Case: O(n*logn)
 ->Worst Case  : O(n*logn)
[Here we are dividing an input Array into k halves n times]
*/
