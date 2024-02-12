package com.epam.rd.autotasks.house;

import java.util.ArrayList;
import java.util.List;

import com.epam.rd.autotasks.residents.cats.Cat;
import com.epam.rd.autotasks.residents.cats.Kitten;
import com.epam.rd.autotasks.residents.dogs.Dog;
import com.epam.rd.autotasks.residents.dogs.Puppy;

public class House <T> {

    private final List<T> residents = new ArrayList<T> ();

    public void enter(T resident) {
        residents.add(resident);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("There are following residents in the house:\n");
        for (Object resident : residents) {
            builder.append(resident.toString()).append("\n");
        }
        return builder.toString();
    }
}
