package Tasks.library2;

import Tasks.library2.DAO.BookDAO;
import Tasks.library2.DAO.UserDAO;
import Tasks.library2.Utils.Role;
import Tasks.library2.model.Book;
import Tasks.library2.model.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Controller {
    private UserDAO userDAO = UserDAO.getInstance();
    private BookDAO bookDAO = BookDAO.getInstance();

    public void start() throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String name = "";
            String password = "";
            int count = 3;
            User user = null;

            System.out.println("Welcome to our library system");

            while (count != 0) {
                System.out.println("\nPlease enter user name: \n (write EXIT to leave the system)");
                name = reader.readLine();
                if (name.toUpperCase().equals("EXIT"))
                    return;

                System.out.println("Password: ");
                password = reader.readLine();
                user = userDAO.getAuthorisation(name, password);
                if (user != null)
                    break;
                System.out.println("Authorization failed! You have " + (--count > 0 ? count : "no") + " attempts left!");
            }

            if(user == null)
                continue;

            switch (user.getRole()) {
                case Admin:
                    adminMenu(user);
                    break;
                case Librarian:
                    librarianMenu(user);
                    break;
                case Visitor:
                    userMenu(user);
            }
        }
    }

    // FOR TEST data
    public void addUser(User user){
        userDAO.add(user);
    }

    // FOR TEST data
    public void addBook(Book book){
        bookDAO.add(book);
    }

    private void adminMenu(User user) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String menuItem;

        System.out.println(user.getName() + ", please make your choice:");

        while (true){
            System.out.println("\n 1 - ADD librarian" +
                                "\n 2 - DELETE librarian" +
                                "\n 3 - VIEW librarians" +
                                "\n 4 - EXIT" );
            menuItem = reader.readLine();
            switch (menuItem){
                case "1":
                    addLibrarian();
                    break;
                case "2":
                    deleteUser();
                    break;
                case "3":
                    viewUser(Role.Librarian);
                    break;
                case "4":
                    System.out.println("Goodbye " + user.getName() + "\n");
                    return;
                default:
                    System.out.println(user.getName() + ", please make CORRECT choice!");
            }
        }
    }

    private void librarianMenu(User user) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String menuItem;

        System.out.println(user.getName() + ", please make your choice:");

        while (true){
            System.out.println("\n 1 - ADD book" +
                    "\n 2 - ISSUE book" +
                    "\n 3 - RETURN book" +
                    "\n 4 - VIEW all books" +
                    "\n 5 - VIEW issued books" +
                    "\n 6 - EXIT" );
            menuItem = reader.readLine();
            switch (menuItem){
                case "1":
                    addBook();
                    break;
                case "2":
                    issueBook();
                    break;
                case "3":
                    break;
                case "4":
                    viewAllBooks();
                    break;
                case "5":
                    viewIssuedBooks();
                    break;
                case "6":
                    System.out.println("Goodbye " + user.getName() + "\n");
                    return;
                default:
                    System.out.println(user.getName() + ", please make CORRECT choice!");
            }
        }
    }

    private void userMenu(User user) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String menuItem;

        System.out.println(user.getName() + ", please make your choice:");

        while (true){
            System.out.println("\n 1 - GET book" +
                    "\n 2 - RETURN book" +
                    "\n 3 - RETURN ALL books" +
                    "\n 4 - VIEW books" +
                    "\n 5 - EXIT" );

            menuItem = reader.readLine();
            switch (menuItem){
                case "1":

                    break;
                case "2":

                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    System.out.println("Goodbye " + user.getName() + "\n");
                    return;
                default:
                    System.out.println(user.getName() + ", please make CORRECT choice!");
            }
        }
    }

    private User addLibrarian() throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name;
        String password;
        long id;

        System.out.println("Add librarian: ");
        System.out.println("ID: ");
        id = Long.parseLong(reader.readLine());
        System.out.println("Name: ");
        name = reader.readLine();
        System.out.println("Password: ");
        password = reader.readLine();

        return userDAO.add(new User(id, name, password, Role.Librarian));
    }

    private void viewUser(Role role){
        userDAO.viewAll(role);
    }

    private void deleteUser() throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String id;

        System.out.println("Enter ID of the user to delete:");
        id = reader.readLine();
        userDAO.delete(Long.parseLong(id));
    }

    private Book addBook() throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long id;
        String callNo;
        String name;
        int quantity;

        System.out.println("Add librarian: ");
        System.out.println("ID: ");
        id = Long.parseLong(reader.readLine());
        System.out.println("Catalog index: ");
        callNo = reader.readLine();
        System.out.println("Name: ");
        name = reader.readLine();
        System.out.println("Quantity: ");
        quantity = Integer.parseInt(reader.readLine());

        return bookDAO.add(new Book(id, callNo, name, quantity));

    }

    private void viewAllBooks(){
        bookDAO.viewAll();
    }

    private void viewIssuedBooks(){
        bookDAO.viewIssued();
    }

    private void issueBook() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long id;
        String callNo;
        System.out.println("Book catalog index:");
        callNo = reader.readLine();
        System.out.println("Visitor ID:");
        id = Long.parseLong(reader.readLine());

        if (bookDAO.issueBook(callNo, userDAO.getUserById(id)) == null)
            System.out.println("Wrong information. Book was not issued!");
    }
}
