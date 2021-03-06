package BINARYSEARCH;
import java.util.Scanner;



public class FirstOccur
{
public static int search(int arr[],int key)				//SEARCH_METHOD
{
int l=0;								//LEFT_POINTER
int r=arr.length-1;							//RIGHT_POINTER
  
while(l <= r)
{
int mid=(l+r)/2;

if(key < arr[mid]) r=mid-1;

if(key > arr[mid]) l=mid+1; 

if(arr[mid] == key)
{
/*HERE WE KNOW MATCH IS FOUND BUT
NOW CHECK FOR THE FIRST MATCH**/

l=mid;
while(l > 0)
{
if(arr[l-1] != key) break;
l--;
}
return l;
}
}
return -1;
}



public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);

System.out.print("TESTCASES: ");
int T=sc.nextInt();

while(T-->0)
{
FirstOccur p=new FirstOccur();

System.out.print("SIZE OF ARRAY AND ELEMENT TO BE SEARCHED: ");
int n=sc.nextInt();
int key=sc.nextInt();
int arr[]=new int[n];							//CREATION_OF_ARRAY

System.out.print("ARRAY: ");
for(int i=0;i<n;i++) arr[i]=sc.nextInt();				//SCANNING_OF_ARRAY

System.out.println("FIRST OCCURENCE IS AT: "+p.search(arr,key));
}

}
}

/*
[PREREQUISITE => SORTED ARRAY]

#TESTCASES:-

10 4
1 2 4 4 4 4 5 8 9 10
=>2

15 7
1 2 3 3 5 6 7 7 7 7 7 8 8 8 8
=>6

9 1
-5 -4 -3 -2 -1 0 0 0 1
=>8

4 1
1 2 2 5
=>0

7 4
1 2 3 4 5 6 7
=>3

9 1
-5 -4 -3 -2 -1 0 0 0 1
=>8

5 1
1 1 1 1 1
=>0

10 3
1 2 4 4 4 4 5 8 9 10
=>-1

15 10
1 2 3 3 5 6 7 7 7 7 7 8 8 8 8
=>-1
*/
