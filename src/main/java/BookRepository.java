import java.sql.*;

//this class will be connected with DB (Connection ,statement, prepared statement)
public class BookRepository {

    private Connection con;

    private Statement statement;

    private PreparedStatement prs;

    //step 3-  Creating Connection

    private void getConnection(){
        try {
            this.con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Book_db","dev_user","password");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    //step 4 - Method for Statement

    private void getStatement(){
        try {
            this.statement=con.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //step 5- Method for prepared Statements

    private void getPreparedStatement(String query){
        try {
            this.prs=con.prepareStatement(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //step 6 . Method for Creating Table

    public void createTable(){
        getConnection();//create connection
        getStatement();//to able to run the query
        String query="CREATE TABLE IF NOT EXISTS tbl_book " +
                "(id SERIAL," +
                "title VARCHAR(100)," +
                "author VARCHAR(50)," +
                "genre VARCHAR(50)," +
                "pageCount INT)";
        try {
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                statement.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }
    //step 10: method to persist data into db.

    public void save(Book newbook){
        getConnection();
        String query= "INSERT INTO tbl_book (title,author,genre,pageCount) VALUES (?,?,?,?)";
        getPreparedStatement(query);

        try {
           prs.setString(1,newbook.getTitle());
           prs.setString(2,newbook.getAuthor());
           prs.setString(3,newbook.getGenre());
           prs.setInt(4,newbook.getPageCunt());
           prs.executeUpdate();// to store / persist values into Table/DB
            System.out.println("Bok Register Successfully ....");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                prs.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }


    //step  12 Display All book
    public void findAllBook() {
        getConnection();
        String query ="SELECT * FROM tbl_book";
        getStatement();

        try {
          ResultSet resultSet =   statement.executeQuery(query);
          while (resultSet.next()){
              System.out.println("ID: " +resultSet.getInt("id"));
              System.out.println("Title: " +resultSet.getString("title"));
              System.out.println("Author: " +resultSet.getString("author"));
              System.out.println("Generation : " +resultSet.getString("genre"));
              System.out.println("pageCount: " +resultSet.getInt("pageCount"));
              System.out.println();
          }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                statement.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    //step 14:  find book By id
    public Book findBookById(int id) {
        getConnection();
        Book book=null;

        String query="SELECT * FROM tbl_book WHERE id = ?";
        try {
            getPreparedStatement(query);
            prs.setInt(1,id);
          ResultSet resultSet =  prs.executeQuery();

          while (resultSet.next()){
              book =new Book();
              book.setId(resultSet.getInt("id"));
              book.setTitle(resultSet.getString("title"));
              book.setAuthor(resultSet.getString("author"));
              book.setGenre(resultSet.getString("genre"));
              book.setPageCunt(resultSet.getInt("pageCount"));
          }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                prs.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return book;
    }

    //step 16: delete book by id
    public void delete(int id) {
        getConnection();
        String query ="DELETE FROM tbl_book WHERE id =?";
        getPreparedStatement(query);
        try {
            prs.setInt(1,id);
          int rowsDeleted =  prs.executeUpdate();
          if (rowsDeleted>0){
              System.out.println("Book With id "+ id + "is deleted successfully ..");
          }else {
              System.out.println("Book With id "+ id + "  is not Found");
          }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void update(Book existBook) {
        getConnection();
        String query = "UPDATE tbl_book SET title=? ,author=?, genre=?,pageCount=? WHERE id=?";
        getPreparedStatement(query);
        try {
            prs.setString(1,existBook.getTitle());
            prs.setString(2,existBook.getAuthor());
            prs.setString(3,existBook.getGenre());
            prs.setInt(4,existBook.getPageCunt());
            prs.setInt(5,existBook.getId());

          int update =  prs.executeUpdate();
          if (update>0){
              System.out.println("Book Updated Successfully ..");
          }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                prs.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    //




}
