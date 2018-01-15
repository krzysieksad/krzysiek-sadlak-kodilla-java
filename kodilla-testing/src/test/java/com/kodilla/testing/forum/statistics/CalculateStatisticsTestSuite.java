package com.kodilla.testing.forum.statistics;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class CalculateStatisticsTestSuite {
    @Test
    public void testCalculateAdvStatisticsIfAll0() {
        //given
        Statistics statisticsMock = mock(Statistics.class);
        int postsCount = 0;
        int commentsCount = 0;
        List<String> usersNames = new ArrayList<>();
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        CalculateStatistics calculate = new CalculateStatistics();

        //when
        calculate.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(0, calculate.showStatistics().get("usersAmount"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("postsAmount"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("commentsAmount"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("avgPostsPerUser"), 0); //division by 0, won't be counted
        Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerUser"), 0); //division by 0, won't be counted
        Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerPost"), 0); //division by 0, won't be counted
    }

    @Test
    public void testCalculateAdvStatisticsOfUsers100() {
        //given
        Statistics statisticsMock = mock(Statistics.class);
        int postsCount = 0;
        int commentsCount = 0;
        List<String> usersNames = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            usersNames.add("user" + i);
        }
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        CalculateStatistics calculate = new CalculateStatistics();

        //when
        calculate.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(100, calculate.showStatistics().get("usersAmount"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("postsAmount"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("commentsAmount"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("avgPostsPerUser"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerUser"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerPost"), 0); //division by 0, won't be counted
    }

    @Test
    public void testCalculateAdvStatisticsOfComments4() {
        //given
        Statistics statisticsMock = mock(Statistics.class);
        int postsCount = 0;
        int commentsCount = 4;
        List<String> usersNames = new ArrayList<>();
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        CalculateStatistics calculate = new CalculateStatistics();

        //when
        calculate.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(0, calculate.showStatistics().get("usersAmount"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("postsAmount"), 0);
        Assert.assertEquals(4, calculate.showStatistics().get("commentsAmount"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("avgPostsPerUser"), 0); //division by 0, won't be counted
        Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerUser"), 0); //division by 0, won't be counted
        Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerPost"), 0); //division by 0, won't be counted
    }

    @Test
    public void testCalculateAdvStatisticsOfComment7Users100() {
        //given
        Statistics statisticsMock = mock(Statistics.class);
        int postsCount = 0;
        int commentsCount = 7;
        List<String> usersNames = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            usersNames.add("user" + i);
        }
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        CalculateStatistics calculate = new CalculateStatistics();

        //when
        calculate.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(100, calculate.showStatistics().get("usersAmount"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("postsAmount"), 0);
        Assert.assertEquals(7, calculate.showStatistics().get("commentsAmount"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("avgPostsPerUser"), 0);
        Assert.assertEquals(0.07, calculate.showStatistics().get("avgCommentsPerUser"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerPost"), 0); //division by 0, won't be counted
    }

    @Test
    public void testCalculateAdvStatisticsOfCommentsNegative4() {
        //given
        Statistics statisticsMock = mock(Statistics.class);
        int postsCount = 0;
        int commentsCount = -4;
        List<String> usersNames = new ArrayList<>();
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        CalculateStatistics calculate = new CalculateStatistics();

        //when
        calculate.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(0, calculate.showStatistics().get("usersAmount"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("postsAmount"), 0);
        Assert.assertEquals(-4, calculate.showStatistics().get("commentsAmount"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("avgPostsPerUser"), 0); //division by 0, won't be counted
        Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerUser"), 0); //division by 0, won't be counted
        Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerPost"), 0); //division by 0, won't be counted
    }

    @Test
    public void testCalculateAdvStatisticsOfCommentsNegative6Users100() {
        //given
        Statistics statisticsMock = mock(Statistics.class);
        int postsCount = 0;
        int commentsCount = -6;
        List<String> usersNames = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            usersNames.add("user" + i);
        }
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        CalculateStatistics calculate = new CalculateStatistics();

        //when
        calculate.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(100, calculate.showStatistics().get("usersAmount"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("postsAmount"), 0);
        Assert.assertEquals(-6, calculate.showStatistics().get("commentsAmount"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("avgPostsPerUser"), 0);
        Assert.assertEquals(-0.06, calculate.showStatistics().get("avgCommentsPerUser"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerPost"), 0); //division by 0, won't be counted
    }

    @Test
    public void testCalculateAdvStatisticsOfPosts1000() {
        //given
        Statistics statisticsMock = mock(Statistics.class);
        int postsCount = 1000;
        int commentsCount = 0;
        List<String> usersNames = new ArrayList<>();
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        CalculateStatistics calculate = new CalculateStatistics();

        //when
        calculate.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(0, calculate.showStatistics().get("usersAmount"), 0);
        Assert.assertEquals(1000, calculate.showStatistics().get("postsAmount"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("commentsAmount"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("avgPostsPerUser"), 0); //division by 0, won't be counted
        Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerUser"), 0); //division by 0, won't be counted
        Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerPost"), 0);
    }

    @Test
    public void testCalculateAdvStatisticsOfPosts1000Users100() {
        //given
        Statistics statisticsMock = mock(Statistics.class);
        int postsCount = 1000;
        int commentsCount = 0;
        List<String> usersNames = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            usersNames.add("user" + i);
        }
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        CalculateStatistics calculate = new CalculateStatistics();

        //when
        calculate.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(100, calculate.showStatistics().get("usersAmount"), 0);
        Assert.assertEquals(1000, calculate.showStatistics().get("postsAmount"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("commentsAmount"), 0);
        Assert.assertEquals(10, calculate.showStatistics().get("avgPostsPerUser"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerUser"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerPost"), 0);
    }

    @Test
    public void testCalculateAdvStatisticsOfPosts1000Comments6876() {
        //given
        Statistics statisticsMock = mock(Statistics.class);
        int postsCount = 1000;
        int commentsCount = 6876;
        List<String> usersNames = new ArrayList<>();
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        CalculateStatistics calculate = new CalculateStatistics();

        //when
        calculate.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(0, calculate.showStatistics().get("usersAmount"), 0);
        Assert.assertEquals(1000, calculate.showStatistics().get("postsAmount"), 0);
        Assert.assertEquals(6876, calculate.showStatistics().get("commentsAmount"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("avgPostsPerUser"), 0); //division by 0, won't be counted
        Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerUser"), 0); //division by 0, won't be counted
        Assert.assertEquals(6.876, calculate.showStatistics().get("avgCommentsPerPost"), 0);
    }

    @Test
    public void testCalculateAdvStatisticsOfPosts1000Comments4089Users100() {
        //given
        Statistics statisticsMock = mock(Statistics.class);
        int postsCount = 1000;
        int commentsCount = 4089;
        List<String> usersNames = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            usersNames.add("user" + i);
        }
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        CalculateStatistics calculate = new CalculateStatistics();

        //when
        calculate.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(100, calculate.showStatistics().get("usersAmount"), 0);
        Assert.assertEquals(1000, calculate.showStatistics().get("postsAmount"), 0);
        Assert.assertEquals(4089, calculate.showStatistics().get("commentsAmount"), 0);
        Assert.assertEquals(10, calculate.showStatistics().get("avgPostsPerUser"), 0);
        Assert.assertEquals(40.89, calculate.showStatistics().get("avgCommentsPerUser"), 0);
        Assert.assertEquals(4.089, calculate.showStatistics().get("avgCommentsPerPost"), 0);
    }

    @Test
    public void testCalculateAdvStatisticsOfPosts1000Comments256() {
        //given
        Statistics statisticsMock = mock(Statistics.class);
        int postsCount = 1000;
        int commentsCount = 256;
        List<String> usersNames = new ArrayList<>();
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        CalculateStatistics calculate = new CalculateStatistics();

        //when
        calculate.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(0, calculate.showStatistics().get("usersAmount"), 0);
        Assert.assertEquals(1000, calculate.showStatistics().get("postsAmount"), 0);
        Assert.assertEquals(256, calculate.showStatistics().get("commentsAmount"), 0);
        Assert.assertEquals(0, calculate.showStatistics().get("avgPostsPerUser"), 0); //division by 0, won't be counted
        Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerUser"), 0); //division by 0, won't be counted
        Assert.assertEquals(0.256, calculate.showStatistics().get("avgCommentsPerPost"), 0);
    }

    @Test
    public void testCalculateAdvStatisticsOfPosts1000Comments725Users100() {
        //given
        Statistics statisticsMock = mock(Statistics.class);
        int postsCount = 1000;
        int commentsCount = 725;
        List<String> usersNames = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            usersNames.add("user" + i);
        }
        when(statisticsMock.postsCount()).thenReturn(postsCount);
        when(statisticsMock.commentsCount()).thenReturn(commentsCount);
        when(statisticsMock.usersNames()).thenReturn(usersNames);

        CalculateStatistics calculate = new CalculateStatistics();

        //when
        calculate.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(100, calculate.showStatistics().get("usersAmount"), 0);
        Assert.assertEquals(1000, calculate.showStatistics().get("postsAmount"), 0);
        Assert.assertEquals(725, calculate.showStatistics().get("commentsAmount"), 0);
        Assert.assertEquals(10, calculate.showStatistics().get("avgPostsPerUser"), 0);
        Assert.assertEquals(7.25, calculate.showStatistics().get("avgCommentsPerUser"), 0);
        Assert.assertEquals(0.725, calculate.showStatistics().get("avgCommentsPerPost"), 0);
    }
}
