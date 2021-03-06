package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
//import com.kodilla.stream.lambda.ExpressionExecutor;
//import com.kodilla.stream.reference.FunctionalCalculator;
//import com.kodilla.stream.book.Book;
//import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import java.time.LocalDate;
//import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
//import com.kodilla.stream.person.People;

public class StreamMain {
    /**
     * Class for submodule 7.
     * @param args just args
     */
    public static void main(final String[] args) {
        //Task 7.3
        System.out.println("\nTask 7.3.:");

        Forum forum = new Forum();
        Map<Integer, ForumUser> users = forum.getUserList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> user.getBirthDate().plusYears(20).isBefore(LocalDate.now()))
                .filter(user -> user.getPostsPublished() > 0)
                .collect(Collectors.toMap(ForumUser::getId, user -> user));

        System.out.println("# elements: " + users.size());
        users.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        //submodule 7.3
        /*BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);*/

        //Deleted in submodule 7.3, chapter 'Kolektor Collectors.joining()'
        /*BookDirectory theBookDirectory = new BookDirectory();

        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);*/

        //Deleted in submodule 7.3, chapter 'Stream na kolekcjach z dowolnymi obiektami'
        /*People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);*/

        //In submodule 7.3. everything in this class should have been deleted
        //Saved it as a reminder.
        /*ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);*/

        System.out.println("");

        //Task 7.1
        System.out.println("\nTask 7.1.:");

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("my poem is beautiful", (poem) -> poem + ", but now is pretty.");
        System.out.println("");
        poemBeautifier.beautify("Violets are blue", (poem) -> "Roses are red\n" + poem + "\nActually violets are violet\nBut who cares");
        System.out.println("");
        poemBeautifier.beautify("Magic growth", String::toUpperCase);
        System.out.println("");
        poemBeautifier.beautify("Creating Haiku\nIs harder than it appears\nThis may take a while",
            (poem) -> ("try reading that: " + poem).replaceAll("[\n :]", "").toLowerCase());
        System.out.println("");
        poemBeautifier.beautify("Raindrops on this page\nWind blows my paper away\nOh crap! I need that...\n", (poem) -> "I hate poems!");

        //Submodule 7.2
        /*System.out.println("\nSubmodule 7.2.:");

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);*/
    }
}
