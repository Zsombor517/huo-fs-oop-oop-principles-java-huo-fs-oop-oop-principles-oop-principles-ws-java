package com.codecool.animal;

// --- Task 3
// TODO: A Lion is a type of Animal.
public class Lion extends Animal {

    public Lion(String name, int age) {
        // HINT: Use the 'super' keyword to pass information to the parent constructor.
        super(name, age);
    }

    // --- Task 4
    // TODO: Provide the specific implementation for the makeSound() method
    //  that you defined in the Animal class. Lions should roar.
    @Override
    public void makeSound() {
        System.out.println("Roar!");
    }

}
