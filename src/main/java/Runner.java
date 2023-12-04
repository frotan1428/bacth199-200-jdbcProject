import java.util.Scanner;

public class Runner {

    /*
MiniProject: Book Management System
    1. Create Book Management System that can be used by any library or book store
    2. User (Admin) can: CRUD operations
        - register book (id, title, author, genre, pageCount fields)
        - list/display books
        - update book by id
        - delete book by id
*/

// 1. Create menu for the app
// 2. Create book class (entity)
// 3. Create methods for books
// 4. Create class to connect database

    public static void main(String[] args) {
        start();
    }

    public static void start(){
        Scanner input =new Scanner(System.in);
        //create an instance of Service class to call the method
        BookService bookService= new BookService();
        //step 8: use service object call the method from service class
        bookService.createTable();
        int select;
        do {

            System.out.println("------------------------------------");
            System.out.println("-----Book Admin  Panel ---");
            System.out.println("1- Register Book");
            System.out.println("2- List all Books");
            System.out.println("3- Delete  Book By Id");
            System.out.println("4- Update Book ");
            System.out.println("5- Find Book by id ");
            System.out.println("0- exit");
            System.out.println("Select your Activity: ");
            System.out.println("------------------------------------");
            select=input.nextInt();
            input.nextLine();//consume new line

            int id;


            switch (select){
                case 1:
                    //register book
                    bookService.saveBook();
                    break;
                case 2:
                    //Display all book
                    bookService.getAllBooks();
                    break;
                case 3:

                    id = getBookId(input);
                    bookService.deleteBookBydId(id);
                    break;
                case 4:
                    id = getBookId(input);
                    bookService.updateBook(id);
                    break;
                case 5:
                    //Find book by id;
                    id = getBookId(input);
                    Book book= bookService.getBookById(id);
                    System.out.println(book);
                    break;
                case 0:
                    //exist the App
                    System.out.println("Thank you for using the app. Have a nice Time!");
                    break;
                default:
                    System.out.println("Incorrect input .Try numbers between 0 and 5");

            }

        }while (select!=0);

    }

    private static int getBookId(Scanner inp){
        System.out.println("Please Enter Book Id: ");
        int id = inp.nextInt();
        inp.nextLine();// new lice
        return id;
    }
}
