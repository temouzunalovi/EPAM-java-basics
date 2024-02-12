package com.epam.rd.autotasks.sprintplanning.tickets;

public class Bug extends Ticket {
    private final UserStory us;

    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
        if (userStory == null || !userStory.isCompleted()) {
            return null;
        }
        return new Bug(id, name, estimate, userStory);
    }

    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        us = userStory;
    }

    @Override
    public String toString() {
        return "[Bug " + getId() + "] " + us.getName() + ": " + getName();
    }
}
