package photo_of_the_day.entity;

import javax.persistence.*;

@Entity
@Table
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String photoLink;
    private int rate;
    private String author;

    @Column(columnDefinition = "TEXT")
    private String feedback;

    public Photo() {
    }

    public Photo(String photoLink, int rate, String author, String feedback) {
        this.photoLink = photoLink;
        this.rate = rate;
        this.author = author;
        this.feedback = feedback;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
