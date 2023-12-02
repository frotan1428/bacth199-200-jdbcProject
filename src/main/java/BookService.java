public class BookService {

    BookRepository bookRepository= new BookRepository();

    public void createTable(){
        bookRepository.createTable();
    }
}
