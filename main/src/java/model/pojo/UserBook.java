package model.pojo;

import java.time.LocalDateTime;
import java.sql.Date;

public class UserBook {

    private Long Id;
    private Date creat_date;
    private Status status;
    private Long userId;
    private Long book_id;

    public UserBook(Long id, Date creat_date, Status status, Long userId, Long book_id) {
        Id = id;
        this.creat_date = creat_date;
        this.status = status;
        this.userId = userId;
        this.book_id = book_id;
    }

    public UserBook(Date creat_date, Status status, Long userId, Long book_id) {
        this.creat_date = creat_date;
        this.status = status;
        this.userId = userId;
        this.book_id = book_id;
    }

    public UserBook() {
    }

    @Override
    public String toString() {
        return "MemberBook{" +
                "Id=" + Id +
                ", creat_date=" + creat_date +
                ", status=" + status +
                ", userId=" + userId +
                ", book_id=" + book_id +
                '}';
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getCreat_date() {
        return creat_date;
    }

    public void setCreat_date(Date creat_date) {
        this.creat_date = creat_date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long

    getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }
}
