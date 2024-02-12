package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

import java.util.Arrays;

public class Sprint {
    private final int capacity;
    private final int ticketsLimit;
    private Ticket[] tickets;
    private int curIndex = 0;
    private int totalEstimate = 0;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        tickets = null;
    }

    public Ticket[] resizeArray(Ticket[] ticket) {
        if(ticket == null) {
            return new Ticket[1];
        } else {
            Ticket[] temp = new Ticket[ticket.length+1];
            System.arraycopy(ticket, 0, temp, 0, ticket.length);
            return temp.clone();
        }
    }

    public boolean addUserStory(UserStory userStory) {
        if (userStory != null && !userStory.isCompleted() && curIndex < ticketsLimit &&  totalEstimate + userStory.getEstimate() <= capacity) {
            boolean tr = false;
            for(UserStory elem : userStory.getDependencies()) {
                if (!elem.isCompleted()) {
                    boolean f = false;
                    for(int i = 0; i < curIndex; i++) {
                        if(elem.getId() == tickets[i].getId()) {
                            f = true;
                            break;
                        }
                    }
                    if(!f) {
                        tr = true;
                        break;
                    }
                }
            }
            if (!tr) {
                tickets = resizeArray(tickets);
                tickets[curIndex] = userStory;
                curIndex++;
                totalEstimate += userStory.getEstimate();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean addBug(Bug bugReport) {
        if (bugReport != null && !bugReport.isCompleted() && curIndex < ticketsLimit &&  totalEstimate + bugReport.getEstimate() <= capacity) {
            tickets = resizeArray(tickets);
            tickets[curIndex] = bugReport;
            curIndex++;
            totalEstimate += bugReport.getEstimate();
            return true;
        } else {
            return false;
        }
    }

    public Ticket[] getTickets() {
        return tickets.clone();
    }

    public int getTotalEstimate() {
        return totalEstimate;
    }
}
