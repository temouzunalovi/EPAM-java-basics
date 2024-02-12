package com.epam.rd.autotasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HalvingCarouselTest {

    @Test
    void checkAddElement() {
        HalvingCarousel carousel = new HalvingCarousel(5);
        assertFalse(carousel.addElement(0));
        assertFalse(carousel.addElement(-1));
        assertFalse(carousel.addElement(-123456));
        assertFalse(carousel.addElement(0));

        assertTrue(carousel.addElement(1));
        assertTrue(carousel.addElement(2));

        assertFalse(carousel.addElement(0));
        assertFalse(carousel.addElement(-123));

        assertTrue(carousel.addElement(1234));
        assertTrue(carousel.addElement(1234));

        assertFalse(carousel.addElement(0));
        assertFalse(carousel.addElement(-456));

        assertTrue(carousel.addElement(22));

        assertFalse(carousel.addElement(22));

        assertFalse(carousel.addElement(-856));
        assertFalse(carousel.addElement(0));

        assertFalse(carousel.addElement(357));
        assertFalse(carousel.addElement(159));
        assertFalse(carousel.addElement(1));
    }

    @Test
    void checkAddElementAfterRun() {
        HalvingCarousel carousel = new HalvingCarousel(5);

        assertTrue(carousel.addElement(1));
        assertTrue(carousel.addElement(2));
        assertTrue(carousel.addElement(3));

        carousel.run();

        assertFalse(carousel.addElement(4));
        assertFalse(carousel.addElement(5));
        assertFalse(carousel.addElement(6));

        assertFalse(carousel.addElement(0));
        assertFalse(carousel.addElement(-123));
        assertFalse(carousel.addElement(-4568));
    }

    @Test
    void testCarouselRunsSingleTimeOnly() {
        HalvingCarousel carousel = new HalvingCarousel(4);
        carousel.addElement(4);

        assertNotNull(carousel.run());
        assertNull(carousel.run());
        assertNull(carousel.run());
    }


}