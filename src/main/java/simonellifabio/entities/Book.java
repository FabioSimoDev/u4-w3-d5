package simonellifabio.entities;

public class Book extends CatalogItem{
    private String author;
    private String genre;

    public Book() {
    }

    public Book(String isbn, String title, int publicationYear, int pageCount, String author, String genre) {
        super(isbn, title, publicationYear, pageCount);
        this.author = author;
        this.genre = genre;
    }
}
