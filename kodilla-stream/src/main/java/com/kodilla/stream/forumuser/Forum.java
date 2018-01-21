package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> userList = new ArrayList<>();

    /**
     * Fill userList.
     */
    public Forum() {
        this.userList.add(new ForumUser(1, "user1", 'M', LocalDate.of(1998, 10, 14), 15));
        this.userList.add(new ForumUser(2, "user2", 'F', LocalDate.of(1959, 12, 26), 35));
        this.userList.add(new ForumUser(3, "user3", 'M', LocalDate.of(2001, 11, 15), 354));
        this.userList.add(new ForumUser(4, "user4", 'M', LocalDate.of(1974, 1, 4), 0));
        this.userList.add(new ForumUser(5, "user5", 'M', LocalDate.of(1988, 5, 28), 87));
        this.userList.add(new ForumUser(6, "user6", 'F', LocalDate.of(1974, 6, 30), 805));
        this.userList.add(new ForumUser(7, "user7", 'M', LocalDate.of(2009, 9, 20), 8524));
        this.userList.add(new ForumUser(8, "user8", 'F', LocalDate.of(1990, 11, 25), 78));
        this.userList.add(new ForumUser(10, "user10", 'F', LocalDate.of(2004, 1, 2), 875));
        this.userList.add(new ForumUser(11, "user11", 'M', LocalDate.of(1984, 2, 6), 152));
        this.userList.add(new ForumUser(12, "user12", 'F', LocalDate.of(1993, 3, 21), 3540));
        this.userList.add(new ForumUser(13, "user13", 'M', LocalDate.of(2003, 8, 31), 876));
    }

    public List<ForumUser> getUserList() {
        return userList;
    }
}
