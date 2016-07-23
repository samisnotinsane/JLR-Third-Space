package io.modernfamily;

/**
 * Created by sameenislam on 23/07/2016.
 */
public class Dummy {

    private String userId;
    private String id;
    private String title;
    private String body;

    public Dummy() {

    }

    public Dummy(String userId, String id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Dummy{" +
                "userId='" + userId + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public String getTitle() {

        return title;
    }

    public String getBody() {
        return body;
    }

    public String getUserId() {

        return userId;
    }
}
