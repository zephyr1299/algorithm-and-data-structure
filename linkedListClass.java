import java.util.*;
public class linkedListClass{
    public static void main(String... args) {
        LinkedList<Animal> ll = new LinkedList<>();
        Animal animal = new Animal("animal");
        ll.add(animal);

        dog d = new dog("dog");
        ll.add(d);
        cat c = new cat("cat");
        cat c2 = new cat("cat2");
        ll.add(c);

        ll.pop();
        ll.pop();
        ll.push(c2);
        System.out.println("first: " + ll.getFirst().getAnimal());


    }
}

class Animal {
    String animal;

    public Animal() {

    }
    public Animal(String animal){
        this.animal = animal;
    }

    public String getAnimal() {
        return animal;
    }

}

class dog extends Animal {
    public dog(String animal){
        this.animal = animal;
    }

}
class cat extends Animal {
    public cat(String animal){
        this.animal = animal;
    }
}
