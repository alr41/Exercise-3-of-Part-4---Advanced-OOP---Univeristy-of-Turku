package fi.utu.tech.ooj.exercise4.exercise3;

interface Winged {
    default void fly() {
        System.out.println(this + " flies!");
    }
}

interface Bipedal {
    default void walk() {
        System.out.println(this + " walks!");
    }
}

abstract class Bird implements Winged, Bipedal {

}

class Crow extends Bird {
    private static int idx = 0;
    private int id = ++idx;

    @Override
    public String toString() {
        return "Varis " + id;
    }
}

// Implementation of task c.)
class Bat implements Winged, Bipedal {
  @Override
  public String toString() {
    return "A Bat!";
  }
}

public class Exercise3 {
    public Exercise3() {
        System.out.println("Exercise 3");

        challenge1(new Crow());
        challenge2(new Crow());
    }

    void challenge1(Bird b) {
        System.out.println("In this challenge, we fly and then we walk!");

        b.fly();
        b.walk();
    }

    <X extends Winged & Bipedal> void challenge2(X b) {
        System.out.println("In this challenge, we fly and then we walk!");

        b.fly();
        b.walk();
    }

  public static void main(String[] args) {
    var exercise = new Exercise3();
    var crow = new Crow();
    var bat = new Bat();
  
    System.out.println("Testing with a Bat (not a Bird)";
  
    // exercise.challenge1(bat); Results in error: incompatible types
    exercise.challenge2(bat); // Works as Bat meets the generic contract
  }
}
