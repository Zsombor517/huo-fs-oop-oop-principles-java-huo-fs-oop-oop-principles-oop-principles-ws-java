package com.codecool.animal;

// --- Task 5
// TODO: A Parrot is also a type of Animal. M
public class Parrot extends Animal {

    public Parrot(String name, int age) {
        // HINT: Use the 'super' keyword to pass information to the parent constructor.
        super(name, age);
    }

    // --- Task 6
    // TODO: Provide the specific implementation for the makeSound() method.
    //  Parrots should squawk.
    @Override
    public void makeSound() {
        System.out.println("Squawk!");
    }

}
