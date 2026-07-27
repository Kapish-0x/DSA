class Solution {
    static int count=0;
    public int reversePairs(int[] nums) {
        count=0;
        mergeSort(nums,0,nums.length-1);
        return count;
    }
    static int[] mergeSort(int nums[],int st,int end){
        if(st<end){
            int mid=(st+end)/2;
            int arr1[]=mergeSort(nums,st,mid);
            int arr2[]=mergeSort(nums,mid+1,end);
            int arr3[]=mergeTwoSortedArray(arr1,arr2);
            return arr3;
        }
        else{
            int arr[]=new int[1];
            arr[0]=nums[st];
            return arr;
        }
    }
    public static int[] mergeTwoSortedArray(int arr1[],int arr2[]){

        int i=0,j=0,k=0;
        int arr3[]=new int[arr1.length+arr2.length];
        
        //count reverse pairs
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]>(long)2*arr2[j]){
              count+=arr1.length-i; 
                j++;
            }
            else
            i++;
        }

        i=0;
        j=0;

        //merge sort logic
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]>arr2[j]){
                arr3[k++]=arr2[j++];
            }
            else{
                arr3[k++]=arr1[i++];
            }
        }


        while(i<arr1.length){
            arr3[k++]=arr1[i++];
        }


        while(j<arr2.length){
            arr3[k++]=arr2[j++];
        }
        
        return arr3;
    }
}