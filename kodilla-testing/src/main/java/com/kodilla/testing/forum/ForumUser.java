package com.kodilla.testing.forum;

import java.util.ArrayList;
import java.util.LinkedList;

public class ForumUser {
    private final String name;
    private final String realName;
    private final ArrayList<ForumPost> posts = new ArrayList<ForumPost>();
    private final LinkedList<ForumComment> comments = new LinkedList<ForumComment>();

    /**
     * For creating forum user.
     * @param name login.
     * @param realName firstName and lastName.
     */
    public ForumUser(final String name, final String realName) {
        //name visible on forum
        this.name = name;
        //real name of the user
        this.realName = realName;
    }

    public void addPost(final String author, final String postBody) {
        ForumPost thePost = new ForumPost(postBody, author);
        posts.add(thePost);
    }

    public void addComment(final ForumPost thePost, final String author, final String commentBody) {
        ForumComment theComment = new ForumComment(thePost, commentBody, author);
        comments.add(theComment);
    }

    public int getPostsQuantity() {
        return posts.size();
    }

    public int getCommentsQuantity() {
        return comments.size();
    }

    /**
     * Returns post.
     * @param postNumber number of post.
     * @return post.
     */
    public ForumPost getPost(final int postNumber) {
        ForumPost thePost = null;
        if (postNumber >= 0 && postNumber < posts.size()) {
            thePost = posts.get(postNumber);
        }
        return thePost;
    }

    /**
     * Returns comment.
     * @param commentNumber number of comment.
     * @return comment.
     */
    public ForumComment getComment(final int commentNumber) {
        ForumComment theComment = null;
        if (commentNumber >= 0 && commentNumber < comments.size()) {
            theComment = comments.get(commentNumber);
        }
        return theComment;
    }

    /**
     * Removes post.
     * @param thePost post to remove.
     * @return if removed.
     */
    public boolean removePost(final ForumPost thePost) {
        boolean result = false;
        if (posts.contains(thePost)) {
            posts.remove(thePost);
            result = true;
        }
        return result;
    }

    /**
     * Removes comment.
     * @param theComment comment to remove.
     * @return if removed.
     */
    public boolean removeComment(final ForumComment theComment) {
        boolean result = false;
        if (comments.contains(theComment)) {
            comments.remove(theComment);
            result = true;
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }
}
