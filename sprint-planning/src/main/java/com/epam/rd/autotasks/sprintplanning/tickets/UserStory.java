package com.epam.rd.autotasks.sprintplanning.tickets;

public class UserStory extends Ticket {
    private final UserStory[] us;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        us = dependsOn;
    }

    @Override
    public void complete() {
        for(UserStory elem : us) {
            if(!elem.isCompleted()) {
                return;
            }
        }
        super.complete();
    }

    public UserStory[] getDependencies() {
        return us.clone();
    }

    @Override
    public String toString() {
        return "[US " + getId() + "] " + getName();
    }
}
