package de.niklas.methods;

import java.util.Arrays;
import java.util.Random;

public class Quicksort {

    int[] data;

    public static void sort(int[] array){
        Quicksort qs = new Quicksort();
        qs.data = array;
        qs.quicksort(0, array.length-1);
    }

    public void quicksort(int left, int right){
        if(left < right){
            int teiler =  teile(left, right);
            quicksort(left, teiler-1);
            quicksort(teiler+1, right);
        }
    }

    public int teile(int left, int right){
        int i = left;
        int j = right-1;
        int pivot = data[right];

        do{
            for(; data[i] <= pivot && i < right; i++);

            for(; data[j] >= pivot && j > left; j--);

            if(i < j){
//                swap(data[i], data[j]);
                int tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
            }
        }while(i < j);

        if(data[i] > pivot){
//            swap(data[i], pivot);
            int tmp = data[i];
            data[i] = data[right];
            data[right] = tmp;
        }

        return i;
    }

    public void swap(int i, int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {
        int[] unsortedArr = new int[new Random().nextInt(2, 100)];
        for(int i = 0; i < unsortedArr.length-1; i++){
            unsortedArr[i] = new Random().nextInt(1, 100);
        }
        System.out.println("Unsortiert: " + Arrays.toString(unsortedArr));
        sort(unsortedArr);
        System.out.println("Sortiert:   " + Arrays.toString(unsortedArr));
    }
}
