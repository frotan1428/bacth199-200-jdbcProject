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
        //!!! todo continue form Here !!!!
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


}
