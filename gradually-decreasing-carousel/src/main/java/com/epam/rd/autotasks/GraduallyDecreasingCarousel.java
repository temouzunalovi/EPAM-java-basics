package com.epam.rd.autotasks;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{
    public GraduallyDecreasingCarousel(final int capacity) {
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
