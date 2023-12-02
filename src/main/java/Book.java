
//step 2  CREATE POJO CLASS
public class Book {
    // field to be created : id,title,author,genre,pageCount

    private int id;

    private String title;

    private String author;

    private String genre;

    private int pageCunt;

    // constructor with parameter


    public Book(String title, String author, String genre, int pageCunt) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pageCunt = pageCunt;
    }


    public Book() {
    }

    //getter and setter //@getter  @setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPageCunt() {
        return pageCunt;
    }

    public void setPageCunt(int pageCunt) {
        this.pageCunt = pageCunt;
    }
    //to sting method


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", pageCunt=" + pageCunt +
                '}';
    }

}
