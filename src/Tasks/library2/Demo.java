package Tasks.library2;


import Tasks.library2.Utils.Role;
import Tasks.library2.Utils.Session;
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

        Session session1;
        Session session2;

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


        System.out.println("\nCorrect user operation");
        session1 = controller.login(user1);
        controller.addLibrarian(session1, user2);
        controller.addLibrarian(session1, user5);
        controller.viewLibrarian(session1);

        System.out.println("************************");
        controller.deleteLibrarian(session1, user5);
        controller.viewLibrarian(session1);

        System.out.println("\nWrong user operation");
        controller.viewAllBooks(session1);

        System.out.println("\nCorrect user operation");
        session2 = controller.login(user2);
        controller.viewAllBooks(session2);

        System.out.println("\nCorrect user operation, book is available to get");
        controller.issueBook(session2, "3C@A", user3);
        controller.viewAllBooks(session2);
        controller.viewIssuedBooks(session2);

        System.out.println("\nCorrect user operation, book is NOT available to get");
        controller.issueBook(session2, "3C@A", user4);
        controller.viewAllBooks(session2);
        controller.viewIssuedBooks(session2);

        System.out.println("\nCorrect user operation, book returned");
        controller.logout(session2);
        controller.returnBook(session2, "3C@A", user3);
        controller.viewAllBooks(session2);
        controller.viewIssuedBooks(session2);

    }
}
