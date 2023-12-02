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

        BookService bookService= new BookService();
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
            System.out.println("Select your Activity");
            select=input.nextInt();
            input.nextLine();//consume new line


            switch (select){
                case 1:
                    //register book
                    System.out.println("save books");
                    break;
                case 2:
                    //Display all book
                    System.out.println("Display books");
                    break;
                case 3:
                    System.out.println("Delete books");
                    //Delete book by Id:
                    break;
                case 4:
                    //Update book  By Id:
                    System.out.println("Update books");
                    break;
                case 5:
                    //Find book by id;
                    System.out.println("Find  book By id");
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
}
