package Tasks.library2;


import Tasks.library2.Utils.Role;
import Tasks.library2.model.Book;
import Tasks.library2.model.User;

public class Demo {

    public static void main(String[] args) throws Exception{
        Controller controller = new Controller();

        User user1 = new User(1221, "Admin", "qwerty", Role.Admin);
        User user2 = new User(1131, "Librarian", "rtfm", Role.Librarian);
        User user3 = new User(12991, "Vasya", "123", Role.Visitor);
        User user4 = new User(12178, "Petya", "111", Role.Visitor);
        User user5 = new User(11311, "Libr", "rtfm", Role.Librarian);

        controller.addTestUser(user1);
//        controller.addTestUser(user2);
        controller.addTestUser(user3);
        controller.addTestUser(user4);


        Book book1 = new Book("C@4", "JAVA for Dummies");
        Book book2 = new Book("B@14", "Bukvar");
        Book book3 = new Book("3C@A", "C++");
        Book book4 = new Book("A@14", "Cooking");
        Book book5 = new Book("J$A3", "Math part 3");
        controller.addTestBook(book1, 2);
        controller.addTestBook(book2, 3);
        controller.addTestBook(book3, 1);
        controller.addTestBook(book4, 1);
        controller.addTestBook(book5, 2);

        System.out.println("\nWrong user operation");
        controller.addLibrarian(user3, user2);
        controller.viewLibrarian(user3);

        System.out.println("\nCorrect user operation");
        controller.addLibrarian(user1, user2);
        controller.addLibrarian(user1, user5);
        controller.viewLibrarian(user1);

        System.out.println("************************");
        controller.deleteLibrarian(user1, user5);
        controller.viewLibrarian(user1);

        System.out.println("\nWrong user operation");
        controller.viewAllBooks(user1);

        System.out.println("\nCorrect user operation");
        controller.viewAllBooks(user2);

        System.out.println("\nCorrect user operation, book is available to get");
        controller.issueBook(user2, "3C@A", user3);
        controller.viewAllBooks(user2);
        controller.viewIssuedBooks(user2);

        System.out.println("\nCorrect user operation, book is NOT available to get");
        controller.issueBook(user2, "3C@A", user4);
        controller.viewAllBooks(user2);
        controller.viewIssuedBooks(user2);

        System.out.println("\nCorrect user operation, book returned");
        controller.returnBook(user2, "3C@A", user3);
        controller.viewAllBooks(user2);
        controller.viewIssuedBooks(user2);

    }
}
