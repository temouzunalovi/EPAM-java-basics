package com.epam.rd.autotasks;

public class CarouselRun {

    private int[] array;
    private int capacity;
    private int currentIndex = 0;

    public CarouselRun(DecrementingCarousel dc) {
        array = dc.array;
        capacity = dc.maxIndex;
    }


    public int next() {
        if (capacity == 0) {
            return -1;
        }
        int c = 0;
        while (array[currentIndex] == 0) {
            currentIndex++;
            currentIndex%=capacity;
            c++;
            if (c == capacity+1) {
                return -1;
            }
        }
        int a = array[currentIndex];
        array[currentIndex]--;
        currentIndex++;
        currentIndex%=capacity;
        return a;
    }

    public boolean isFinished() {
        for(int i = 0; i < capacity; i++) {
            if(array[i] > 0) {
                return false;
            }
        }
        return true;
    }

}
