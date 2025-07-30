# Exercise-3-of-Part-4---Advanced-OOP---Univeristy-of-Turku

## 2. Student ID
Student ID: 2406530

## 3. Exercise
The task proposed by exercise 3 is to interpret the implementation of the Exercise3 file and answer the following questions.

## a.) What language feature is involved in the methods challenge1 and challenge2? How does this feature manifest, and how should it be used?
**In challenge1**, the method signature declares that it accepts any object of type Bird: 
```java
void challenge1(Bird b)
```
For example, since class Crow extends Bird (or, in other words, is a subtype of Bird), it can be passed by this method as per the Liskov Substitution Principle.

As such, considering the fly() and walk() methods are contained within the Winged and Bipedal interfaces, the Bird class inherits them as part of its public contract. In this sense, any variable of type Bird has access to these methods, allowing the calls b.fly() and b.walk() to be valid.

This is mainly due to the polymorphism through subtyping feature. It should be used when there is a well defined inheritance hierarchy, as it means all objects processes should share a common ancestor.


**In challenge2**, parametric polymorphism is used, mostly used when  a flexible and reusable code is needed, based on the object's capabilities and not their ancestry. The method signature uses Generics to achieve a more flexible form of polymorphism:
```java
X extends Winged & Bipedal> void challenge2(X b)
```
This syntax is a bounded type parameter and created a contarct that any type X passed to this method must implement both the Winged and Bipedal interfaces.

This guarantees that any object b of type X will have the fly() and walk() methods. This allows the method to work with any class that has these capabilities, even if it doesn't extend Bird.

## b.) The methods challenge1 and challenge2 seem to perform the same way based on their output. What are the key functional differences between them?
The key difference between the methods is that while challenge1 uses polymorphism though subtyping, challenge2 uses generics. 

With the use of generics, challlenge2 can accept an object from any class hierarchy as long as it fulfills the contract of implementing the Winged and Bipedal interfaces, while challenge1 is can only accept objects that belong to the Bird inheritance hierarchy.

This means that altough they may seem the same based on the provided output, challenge2 has a greater flexibility adn reasuability, as it is based on what the object can do as opposed to what the object is.


## c.) Come up with and implement a meaningful situation from the perspective of object-oriented programming that demonstrates the advantages of the latter method, challenge2. (Presumably, the implementation has some advantages because it has a longer method definition -- why else would someone write a more complex signature for code that does exactly the same thing?).
In order to demonstrate the advantage of challenge2, a new class Bat, which implements both Winged and Bipedal is introduced.

When an instance of Bat is passed to both methods, challenge2 accepts it because Bat fulfills the required interface contract.

However, in challenge1, it will not compile, as Bat is not a subtype of Bird.

In this sense, it is evident that challenge2 demonstrates an advantage over challenge1, since it works with any class that has the right capabilities.
