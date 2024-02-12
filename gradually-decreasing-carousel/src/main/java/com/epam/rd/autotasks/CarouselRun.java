package com.epam.rd.autotasks;

public class CarouselRun {

    private int[] array;
    private int capacity;
    private int currentIndex = 0;
    private int type = 0;
    private int circle = 1;

    public CarouselRun(DecrementingCarousel dc, int type) {
        array = dc.array;
        capacity = dc.maxIndex;
        this.type = type;
    }


    public int next() {
        if (capacity == 0 || isFinished()) {
            return -1;
        }
        while (array[currentIndex] == 0) {
            currentIndex++;
            currentIndex%=capacity;
            if(currentIndex==0) {
                circle++;
            }
        }
        int a = array[currentIndex];
        switch (type) {
            case 0:
                array[currentIndex]--;
                break;
            case 1:
                array[currentIndex] -= circle;
                if (array[currentIndex] < 0) {
                    array[currentIndex] = 0;
                }
                break;
        }
        currentIndex++;
        currentIndex%=capacity;
        if (currentIndex == 0) {
            circle++;
        }
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
