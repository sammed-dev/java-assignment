/*
    Given an array of distinct integers. Write a program to count all the triplets
    such that the sum of two elements equals the third element.
    Example,
    Input: N = 4
    arr[] = {1, 5, 3, 2}
    Output: 2
    Explanation: There are 2 triplets: 1 + 2 = 3 and 3 + 2 = 5
    Hint: Use Java collections to solve it in O(N2)
*/



package com.mycompany.employeetax;
import java.util.Arrays;

public class PythagorianTriplet {

    public static void main(String[] args) {

        int arr[] = {1, 5, 3, 2};
        Arrays.sort(arr);

        for(int i= arr.length-1;i>=2;i--){
            int last = arr[i];
            int k=0,j= i-1;
            while(k<j){
                if(arr[k]+arr[j] == last){
                    System.out.println(arr[k]+" + "+arr[j]+" = "+last);
                    break;
                }
                else if (arr[k]+arr[j] < last){
                    k++;
                } else{
                    j--;
                }
            }
        }



//        // Arrays.asList() won't work for primitives it works only for objects.
//        // List<Integer> arrList = Arrays.asList(arr);
//
//        //to convert into ArrayList use stream()
//        List<Integer> arrList = Arrays.stream(arr).boxed().toList();
//
//        Collections.sort(arrList);

        
    }

}
