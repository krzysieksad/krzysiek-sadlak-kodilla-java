package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    private final int id;
    private final String userName;
    private final char sex;
    private final LocalDate birthDate;
    private final int postsPublished;

    /**
     * Creation of forum user.
     * @param id unique id.
     * @param userName login.
     * @param sex sex.
     * @param birthDate date of birth.
     * @param postsPublished amount of posts published.
     */
    public ForumUser(final int id, final String userName, final char sex, final LocalDate birthDate, final int postsPublished) {
        this.id = id;
        this.userName = userName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postsPublished = postsPublished;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostsPublished() {
        return postsPublished;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", postsPublished=" + postsPublished +
                '}';
    }
}
