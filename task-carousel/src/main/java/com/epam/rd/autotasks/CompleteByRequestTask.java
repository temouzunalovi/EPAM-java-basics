package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
    private boolean completed = false;
    private boolean finished = false;

    @Override
    public void execute() {
        if (completed) {
            finished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return finished;
    }

    public void complete() {
        completed = true;
    }
}
