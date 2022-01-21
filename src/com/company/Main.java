package com.company;

import java.lang.reflect.TypeVariable;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // 1. Implement custom Functional interface using lambda expressions.
        System.out.println("Item 1: Implement custom Functional interface using lambda expressions.\n");

        CustomFunctionalInterface test1 = () -> System.out.println("Test information with Lambda Expression");
        test1.display();


        // 2. There is a list of users (User {email, loginDate, team}).
        // Filter users who logged in after week ago, group by a team, where K - team, V - email.

        System.out.println("-----------------------------------------------------------------------------\nItem 2:\n");

        List<User> listOfUsers = new ArrayList<>();

        listOfUsers.add(new User("0@1.com", LocalDate.now(), "New user"));
        listOfUsers.add(new User("1@1.com", LocalDate.now().minusDays(5), "Premium user"));
        listOfUsers.add(new User("2@1.com", LocalDate.now().minusDays(8), "Experienced user"));
        listOfUsers.add(new User("3@1.com", LocalDate.now().minusDays(2), "New user"));
        listOfUsers.add(new User("4@1.com", LocalDate.now().minusDays(4), "Premium user"));
        listOfUsers.add(new User("5@1.com", LocalDate.now().minusDays(7), "New user"));
        listOfUsers.add(new User("6@1.com", LocalDate.now().minusDays(14), "Experienced user"));
        listOfUsers.add(new User("7@1.com", LocalDate.now().minusDays(12), "New user"));
        listOfUsers.add(new User("8@1.com", LocalDate.now().minusDays(9), "Premium user"));
        listOfUsers.add(new User("9@1.com", LocalDate.now().minusDays(15), "Experienced user"));
        listOfUsers.add(new User("10@1.com", LocalDate.now().minusDays(25), "Experienced user"));
        listOfUsers.add(new User("11@1.com", LocalDate.now().minusDays(10), "New user"));
        System.out.println("List of Users: \n" + listOfUsers+ "\n");

        var map1 = listOfUsers.stream()
                .filter(user -> user.getLoginDate().isAfter(LocalDate.now().minusDays(7)))
                .collect(Collectors.groupingBy(User::getTeam,                         //group by a team
                        Collectors.mapping(User::getEmail, Collectors.toSet())));     // collect emails to Set
        System.out.println("Users who logged in after week ago: " + map1 + "\n");


        Map<String, Set<String>> map2 = listOfUsers.stream()
                .collect(Collectors.groupingBy(User::getTeam, //group by a team
                        Collectors.mapping(User::getEmail, Collectors.toSet())));     // collect emails to Set
        System.out.println("Users grouped by a team: " + map2);


         // 3. There are 2 collections with movies. Each Movie has a ticket’s price,  genre.
        // Per each genre calculate the average price of tickets and count movies for a particular genre.

        System.out.println("\n-----------------------------------------------------------------------------\nItem 3:\n");

        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie("My Big Fat Greek Wedding", "Comedy", 80));
        movies.add(new Movie("The Holiday", "Comedy", 100));
        movies.add(new Movie("Beauty and the Beast", "Romance", 130));
        movies.add(new Movie("Big Fat Liar", "Comedy", 150));
        movies.add(new Movie("When Harry Met Sally", "Romance", 110));
        movies.add(new Movie("Black Widow", "Action", 160));

        List<Movie> movies1 = new ArrayList<>();

        movies1.add(new Movie("The Big Bang Theory", "Romance", 90));
        movies1.add(new Movie("And Just Like That...", "Romance", 160));
        movies1.add(new Movie("RoboCop", "Action", 140));
        movies1.add(new Movie("Mortal Kombat", "Action", 110));
        movies1.add(new Movie("Crank: High Voltage", "Comedy", 200));

        List<List<Movie>> listOfMovies = new ArrayList<>();
        listOfMovies.add(movies);
        listOfMovies.add(movies1);

        var countMoviesOfGenre = listOfMovies.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting()));

        var averagePriceOfTickets = listOfMovies.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.averagingInt(Movie::getTicketPrice)))
                ;


        System.out.println("Count movies for a particular genre:  " + countMoviesOfGenre);
        System.out.println("\nThe average price of tickets per each genre:  " + averagePriceOfTickets);


        // 4. *There is a collection of boxes(Box). Each box contains a list of some things(Thing). Things may be fragile.
        // The task is to add extra packing(Protector) for fragile things using streams.
        System.out.println("\n-----------------------------------------------------------------------------\nItem 4*:\n");

        List<Thing> box1 = new ArrayList<>();
        box1.add(new Thing("Ball", false));
        box1.add(new Thing("Pen", false));
        box1.add(new Thing("Pencil", false));
        box1.add(new Thing("Vase", true));
        box1.add(new Thing("Glass", true));

        List<Thing> box2 = new ArrayList<>();
        box2.add(new Thing("lace", false));
        box2.add(new Thing("Smartphone", true));
        box2.add(new Thing("Notebook", true));
        box2.add(new Thing("Carafe", true));
        box2.add(new Thing("Monitor", false));

        List<Thing> box3 = new ArrayList<>();
        box3.add(new Thing("Camera", true));
        box3.add(new Thing("Hammer", false));
        box3.add(new Thing("Battery", true));
        box3.add(new Thing("Wheel", false));
        box3.add(new Thing("Steering wheel", false));

        List<List<Thing>> listOfBoxes = new ArrayList<>();
        listOfBoxes.add(box1);
        listOfBoxes.add(box2);
        listOfBoxes.add(box3);

//        System.out.println(listOfBoxes);

      listOfBoxes.stream()
                .flatMap(Collection::stream)
                .filter(it -> it.isFragile())
                .forEach(System.out::println);
//                .collect(Collectors.groupingBy(Collectors.counting()));

//        System.out.println(newListOfBoxes);


    }

}
