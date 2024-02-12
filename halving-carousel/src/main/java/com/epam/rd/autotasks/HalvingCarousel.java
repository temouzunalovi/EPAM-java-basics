package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {

    public HalvingCarousel(final int capacity) {
        super(capacity);
    }

    public CarouselRun run(){
        if (run) {
            return null;
        } else {
            CarouselRun cr = new CarouselRun(this, 1);
            run = true;
            return cr;
        }
    }

}
