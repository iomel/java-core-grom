package Tasks.library;

import Tasks.library.model.Admin;
import Tasks.library.model.Book;
import Tasks.library.model.Librarian;
import Tasks.library.model.Visitor;

import java.util.Date;

public class Demo {

    public static void main(String[] args) {
        Controller controller = new Controller();

        Admin admin1 = new Admin(1111, "access1", "Vasya");
        Admin admin2 = new Admin(1221, "access2", "Dima");

        controller.addAdmin(admin1);
        controller.addAdmin(admin2);
//        controller.viewAdmins();

        Librarian libr1 = new Librarian(1111, "access_Lib", "Masha", "1@gmail.com", "Obolon", "Kiev", "0444321223");
        Librarian libr2 = new Librarian(1121, "access_Lib2", "Valya", "Vl@gmail.com", "Teremki", "Kiev", "0444329999");
        Librarian libr3 = new Librarian(1119, "access_Lib3", "Rita", "Ri@gmail.com", "Prospect", "Vyshgorod", "0504321223");

        admin1.addLibrarian(libr1);
        admin1.addLibrarian(libr2);
        admin2.addLibrarian(libr3);
//        controller.getLibrarianDAO().view();

        Visitor visitor1 = new Visitor(1121, "12345", "Petya", "0959943234");
        Visitor visitor2 = new Visitor(1921, "12345", "Dasha", "095873722");
        Visitor visitor3 = new Visitor(1129, "12345", "Liza", "21227506");
        Visitor visitor4 = new Visitor(1127, "12345", "Vasya", "0919991223");

        controller.addVisitor(visitor1);
        controller.addVisitor(visitor2);
        controller.addVisitor(visitor3);
        controller.addVisitor(visitor4);
        controller.viewVisitors();

        Book book1 = new Book("C@4", "JAVA for Dummies", "Andrey", "SamIzDat", new Date(), 5);
        Book book2 = new Book("B@14", "Bukvar", "Lenin", "Ababagalamaga", new Date(), 15);
        Book book3 = new Book("3C@A", "C++", "John Ch", "Tom&Co", new Date(), 1);
        Book book4 = new Book("A@14", "Cooking", "Kolya J.J.", "Makar&Co", new Date(), 2);
        Book book5 = new Book("J$A3", "Math part 3", "Koravin A.", "Nauka i zhizn", new Date(), 5);

        controller.addBook(book1);
        controller.addBook(book2);
        controller.addBook(book3);
        controller.addBook(book4);
        controller.addBook(book5);
        controller.viewBooks();

        libr1.viewIssuedBooks();
        libr1.issueBook("C@4", visitor1);
        libr1.issueBook("3C@A", visitor1);
        libr2.issueBook("3C@A", visitor2);
        libr2.issueBook("C@4", visitor2);

        libr3.viewIssuedBooks();

        libr2.returnBook("3C@A", visitor1);
        libr3.viewIssuedBooks();
        libr1.viewBooks();

    }
}
