import java.util.Scanner;

public class BookService {

    // to get access method from repository class
    BookRepository repository= new BookRepository();

    Scanner input = new Scanner(System.in);

    //step 7 : Method to call the Create Table from Repository class

    public void createTable(){
        repository.createTable();
    }
    //step 9: Method to register book
    public void saveBook(){
         System.out.println("Title : ");
         String title = input.nextLine();

         System.out.println("Author  : ");
         String author = input.nextLine();

        System.out.println("Generation  : ");
        String genre = input.nextLine();

        System.out.println("PageCount  : ");
        int pageCount = input.nextInt();
        input.nextLine();//consume new line

        //after getting all data from user , we create a new object using info enter by user
        Book newBook= new Book(title,author,genre,pageCount);
        repository.save(newBook);
    }


    //step 11: Method for display all Data

    public void getAllBooks(){
        repository.findAllBook();
    }

    //STEP 13:  FIND BOOK BY ID //1

    public Book getBookById(int id){
     Book book=  repository.findBookById(id);
     if (book==null){
         System.out.println("No Book Found with this Id : "+ id);
     }
     return  book;
    }

    //step 15 : method to delete book by id

    public void deleteBookBydId(int id){
       repository.delete(id);
    }

    //step 17 :  method for update

    public void updateBook(int id){
        //find book by id from the table

        Book  existBook = getBookById(id);
        if (existBook ==null){
            System.out.println("Book with id : "+ id+ " Not Found");
        }else {

            //ask all data from User:
            System.out.println("Title  : ");
            String title = input.nextLine();

            System.out.println("Author  : ");
            String author = input.nextLine();

            System.out.println("Generation  : ");
            String genre = input.nextLine();

            System.out.println("PageCount  : ");
            int pageCount = input.nextInt();
            input.nextLine();//consume new line
            //start updating book of existing book

            existBook.setTitle(title);
            existBook.setAuthor(author);
            existBook.setGenre(genre);
            existBook.setPageCunt(pageCount);
            //we can leave the Id uncached
            repository.update(existBook);
        }

    }




}
