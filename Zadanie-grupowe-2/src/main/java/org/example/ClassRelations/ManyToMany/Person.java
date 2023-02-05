package org.example.ClassRelations.ManyToMany;

import java.util.ArrayList;
import java.util.List;

// Many people know many people (and many people know many people)
public class Person {
    private String name;
    private List<Person> friends;

    public Person(String name) {
        this.name = name;
        this.friends = new ArrayList<>();
    }

    public void addFriend(Person friend) {
        this.friends.add(friend); // I add the new friend to my friends list
        friend.friends.add(this); // I add myself to the new friend's friends list
    }

    public static void example() {
        Person seba = new Person("Seba");
        Person wojtas = new Person("Wojtas");
        Person spejson = new Person("Spejson");
        Person pjoter = new Person("Pjoter");

        seba.addFriend(wojtas);
        seba.addFriend(spejson);
        seba.addFriend(pjoter);

        wojtas.addFriend(spejson);
        wojtas.addFriend(pjoter);

        spejson.addFriend(pjoter);

        List<Person> blokEkipa = new ArrayList<>();
        blokEkipa.add(seba);
        blokEkipa.add(wojtas);
        blokEkipa.add(spejson);
        blokEkipa.add(pjoter);

        for (Person ziomek : blokEkipa) {
            System.out.println("Ziomek " + ziomek.name);
            for (Person friend : ziomek.friends) {
                System.out.println(friend.name);
            }
        }
    }
}
