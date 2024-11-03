import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Interfaces {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // int n = s.nextInt();
        // int [] arr = new int [n];
        // for(int i = 0; i < arr.length; i++){
        //     arr[i] = s.nextInt();
        // }
        int [] arr = {1, 9, 5, -31, -1, -1, 23, 2, 4, 45};
        System.out.println("1. Merge Sort \n2. Quick Sort \n3.Bubble Sort\nEnter a choice : ");
        int option = s.nextInt();
        switch (option) {
            case 1:
                Sortable mergeSort = new MergeSort();
                mergeSort.sort(arr);
                break;
            case 2:
                Sortable quickSort = new QuickSort();
                quickSort.sort(arr);
                break;
            case 3:
                Sortable bubbleSort = new BubbleSort();
                bubbleSort.sort(arr);
                break;
            default:
                Arrays.sort(arr);
                break;
        }
        System.out.println("Sorted Array");
        for(int i : arr){
            System.out.println(i);
        }

        // Playable 
        Playable mp3Player = new MP3Player();
        Playable cdPlayer = new CDPlayer();
        Playable streamingPlayer = new StreamingPlayer();

        mp3Player.play();
        cdPlayer.pause();
        streamingPlayer.stop();

        // Remote Control car
        ProductionRemoteControlCar prc1 = new ProductionRemoteControlCar();
        ProductionRemoteControlCar prc2 = new ProductionRemoteControlCar();
        prc1.setNumberOfVictories(2);
        prc2.setNumberOfVictories(3);
        List<ProductionRemoteControlCar> unsortedCars = new ArrayList<>();
        unsortedCars.add(prc1);
        unsortedCars.add(prc2);
        List<ProductionRemoteControlCar> rankings = TestTrack.getRankedCars(unsortedCars);
        System.out.println(rankings);
    }
}

interface Sortable{
    abstract public void sort(int [] arr);
}

class MergeSort implements Sortable{
    public void sort(int [] arr){
        seperate(arr);
    }

    void merge(int [] arr, int [] left, int [] right){
        int lsize = left.length;
        int rsize = right.length;
        int lp = 0, rp = 0, ap = 0;
        while(lp < lsize && rp < rsize){
            if(left[lp] < right[rp]){
                arr[ap] = left[lp];
                lp++;
            }
            else{
                arr[ap] = right[rp];
                rp++;
            }
            ap++;
        }
        while(lp < lsize){
            arr[ap] = left[lp];
            lp++;
            ap++;
        }
        while(rp < rsize){
            arr[ap] = right[rp];
            rp++;
            ap++;
        }
    }

    void seperate(int [] arr){
        int arrayLength = arr.length;
        if(arrayLength == 1){
            return;
        }
        int mid = arrayLength/2;
        int [] left = Arrays.copyOfRange(arr, 0, mid);
        int [] right = Arrays.copyOfRange(arr, mid, arrayLength);
        seperate(left);
        seperate(right);
        merge(arr, left, right);
    }
}

class QuickSort implements Sortable{
    public void sort(int [] arr){
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int [] arr, int minIndex, int maxIndex){


        if(minIndex >= maxIndex)    return;


        int pivot = arr[maxIndex];

        int left = partition(arr, minIndex, maxIndex, pivot);


        quickSort(arr, minIndex, left - 1);
        quickSort(arr, left + 1, maxIndex);

        
    }

    private int partition(int [] arr, int minIndex, int maxIndex, int pivot){

        int left = minIndex, right = maxIndex - 1;

        while(left < right){
            while(left < right && arr[left] < pivot)   left++;
            while(right > left && arr[right] > pivot)  right--;

            swap(arr, left, right);
        }

        if(arr[maxIndex] < arr[left])   swap(arr, left, maxIndex);
        else left = maxIndex;

        return left;
    }

    public void swap(int [] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}

class BubbleSort implements Sortable{
    public void sort(int [] arr){
        bubbleSort(arr);
    }

    public void bubbleSort(int [] arr){
        for(int i = 0; i < arr.length - 1; i++){
            boolean swapped = false;
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if(!swapped) return;
        }
    }
}

// Playable

interface Playable {
    void play();
    void pause();
    void stop();
}

class MP3Player implements Playable {
    public void play() {
        System.out.println("MP3Player is playing music.");
    }

    public void pause() {
        System.out.println("MP3Player is paused.");
    }

    public void stop() {
        System.out.println("MP3Player has stopped.");
    }
}

class CDPlayer implements Playable {
    public void play() {
        System.out.println("CDPlayer is playing music.");
    }

    public void pause() {
        System.out.println("CDPlayer is paused.");
    }

    public void stop() {
        System.out.println("CDPlayer has stopped.");
    }
}

class StreamingPlayer implements Playable {
    public void play() {
        System.out.println("StreamingPlayer is playing music.");
    }

    public void pause() {
        System.out.println("StreamingPlayer is paused.");
    }

    public void stop() {
        System.out.println("StreamingPlayer has stopped.");
    }
}


// Remote Control Car

interface RemoteControlCar{
    abstract void drive();
    abstract int getDistanceTravelled();
}

class ProductionRemoteControlCar implements RemoteControlCar{
    private int distance = 0;
    private int numberOfVictories = 0;
    public int getNumberOfVictories() {
        return numberOfVictories;
    }
    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }
    public void drive(){
        distance += 10;
    }
    public int getDistanceTravelled(){
        return distance;
    }
}

class ExperimentalRemoteControlCar implements RemoteControlCar{
    private int distance = 0;
    public void drive(){
        distance += 20;
    }
    public int getDistanceTravelled(){
        return distance;
    }
}

class TestTrack{
    public static void race(RemoteControlCar car){
        car.drive();
    }

    public static List<ProductionRemoteControlCar> getRankedCars(List<ProductionRemoteControlCar> unsorted){
        Collections.sort(unsorted, (a, b) -> a.getNumberOfVictories() - b.getNumberOfVictories());
        return unsorted;
    }
}