package com.epam.rd.autotasks.house;


import com.epam.rd.autotasks.residents.cats.Cat;
import com.epam.rd.autotasks.residents.cats.Kitten;
import com.epam.rd.autotasks.residents.dogs.Dog;
import com.epam.rd.autotasks.residents.dogs.Puppy;

public class Main {

    public static void main(String[] args) {
        Dog rex = new Dog("Rax");
        Puppy randy = new Puppy("Randy");
        Cat barbos = new Cat("Barbos");
        Kitten murzik = new Kitten("Murzik");

        House dogHouse = new House();
        dogHouse.enter(rex);
        dogHouse.enter(randy);
        System.out.println(dogHouse);

        House catHouse = new House();
        catHouse.enter(barbos);
        catHouse.enter(murzik);
        System.out.println(catHouse);
    }
}
