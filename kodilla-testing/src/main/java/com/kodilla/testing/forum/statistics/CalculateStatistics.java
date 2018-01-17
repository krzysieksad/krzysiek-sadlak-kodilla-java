package com.kodilla.testing.forum.statistics;

import java.util.HashMap;
import java.util.Map;

public class CalculateStatistics {
    private int usersAmount;
    private int postsAmount;
    private int commentsAmount;
    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;

    /**
     * Counts forum statistics.
     * @param statistics statistics.
     */
    public void calculateAdvStatistics(final Statistics statistics) {
        this.usersAmount = statistics.usersNames().size();
        this.postsAmount = statistics.postsCount();
        this.commentsAmount = statistics.commentsCount();
        this.avgPostsPerUser = 0;
        this.avgCommentsPerUser = 0;
        this.avgCommentsPerPost = 0;
        if (statistics.usersNames().size() != 0) {
            this.avgPostsPerUser = (double) statistics.postsCount() / (double) statistics.usersNames().size();
            this.avgCommentsPerUser = (double) statistics.commentsCount() / (double) statistics.usersNames().size();
        }
        if (statistics.postsCount() != 0) {
            this.avgCommentsPerPost = (double) statistics.commentsCount() / (double) statistics.postsCount();
        }
    }

    /**
     * Shows forum statistics.
     * @return map of statistics.
     */
    public Map<String, Double> showStatistics() {
        Map<String, Double> statistics = new HashMap<>();
        statistics.put("usersAmount", (double) this.usersAmount);
        statistics.put("postsAmount", (double) this.postsAmount);
        statistics.put("commentsAmount", (double) this.commentsAmount);
        statistics.put("avgPostsPerUser", this.avgPostsPerUser);
        statistics.put("avgCommentsPerUser", this.avgCommentsPerUser);
        statistics.put("avgCommentsPerPost", this.avgCommentsPerPost);
        return statistics;
    }
}
