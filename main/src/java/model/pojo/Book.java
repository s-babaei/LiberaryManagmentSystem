package model.pojo;

public class Book {
    private Long Id;
    private String name;
    private Status status;
    private String author;
















    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", author='" + author + '\'' +
                '}';
    }

    public Book(Long id, String name, Status status, String author) {
        Id = id;
        this.name = name;
        this.status = status;
        this.author = author;
    }

    public Book(String name, Status status, String author) {
        this.name = name;
        this.status = status;
        this.author = author;
    }

    public Book() {
    }
}
