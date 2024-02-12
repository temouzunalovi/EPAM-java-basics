package com.epam.rd.autotasks;

import java.util.ArrayList;
import java.util.List;

public class TaskCarousel {
    private int capacity;
    private final List<Task> tasks = new ArrayList<>();
    private int load = 0;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
    }

    public boolean addTask(Task task) {
        if (task != null && !task.isFinished() && !isFull()) {
            tasks.add(task);
            return true;
        } else return false;
    }

    public boolean execute() {
        if (isEmpty()) {
            return false;
        }
        refreshCounter();
        tasks.get(load).execute();
        if (tasks.get(load).isFinished()) {
            tasks.remove(load);
        } else {
            load++;
        }
        return true;
    }

    public boolean isFull() {
        if (tasks.size() == capacity) return true;
        else return false;
    }

    public boolean isEmpty() {
        if (tasks.size() == 0) return true;
        else return false;
    }

    private void refreshCounter() {
        if (load >= tasks.size()) load = 0;
    }

}
