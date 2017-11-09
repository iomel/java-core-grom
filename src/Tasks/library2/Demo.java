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


        Book book1 = new Book("C@4", "JAVA for Dummies",5);
        Book book2 = new Book("B@14", "Bukvar",15);
        Book book3 = new Book("3C@A", "C++",1);
        Book book4 = new Book("A@14", "Cooking",2);
        Book book5 = new Book("J$A3", "Math part 3", 5);
        controller.addTestBook(book1);
        controller.addTestBook(book2);
        controller.addTestBook(book3);
        controller.addTestBook(book4);
        controller.addTestBook(book5);

        System.out.println("\nWrong user operation");
        controller.login(user3);
        controller.addLibrarian(user2);
        controller.viewLibrarian();

        System.out.println("\nCorrect user operation");
        controller.login(user1);
        controller.addLibrarian(user2);
        controller.viewLibrarian();

        System.out.println("**************");
        controller.logout();
        System.out.println("\nuser operation after logout");
        controller.viewLibrarian();

        System.out.println("\nWrong user access");
        controller.login(user5);
        controller.viewAllBooks();


        System.out.println("\nWrong user operation");
        controller.viewAllBooks();

        System.out.println("\nCorrect user operation");
        controller.login(user2);
        controller.viewAllBooks();

        System.out.println("\nCorrect user operation, book is available to get");
        controller.issueBook(book3, user3);
        controller.viewAllBooks();
        controller.viewIssuedBooks();

        System.out.println("\nCorrect user operation, book is NOT available to get");
        controller.issueBook(book3, user4);
        controller.viewAllBooks();
        controller.viewIssuedBooks();

        System.out.println("\nCorrect user operation, book returned");
        controller.returnBook(book3, user3);
        controller.viewAllBooks();
        controller.viewIssuedBooks();

    }
}
