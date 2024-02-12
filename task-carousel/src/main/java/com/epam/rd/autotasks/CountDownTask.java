package com.epam.rd.autotasks;

public class CountDownTask implements Task{
    private int value;

    public CountDownTask(int value) {
        this.value = Math.max(value, 0);
    }

    public int getValue() {
        return value;
    }

    @Override
    public void execute() {
        if (value > 0) {
            value--;
        } else {
            value = 0;
        }
    }

    @Override
    public boolean isFinished() {
        return value == 0;
    }
}
