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
        controller.addUser(user1);
        controller.addUser(user2);
        controller.addUser(user3);
        controller.addUser(user4);


        Book book1 = new Book(1233,"C@4", "JAVA for Dummies",5);
        Book book2 = new Book(2134,"B@14", "Bukvar",15);
        Book book3 = new Book(1121,"3C@A", "C++",1);
        Book book4 = new Book(9821,"A@14", "Cooking",2);
        Book book5 = new Book(8731,"J$A3", "Math part 3", 5);
        controller.addBook(book1);
        controller.addBook(book2);
        controller.addBook(book3);
        controller.addBook(book4);
        controller.addBook(book5);




        controller.start();


    }
}
