package com.kodilla.testing.forum.statistics;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class CalculateStatisticsTestSuite {
    @Test
    public void testCalculateAdvStatistics1() {
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
        //Assert.assertEquals(0, calculate.showStatistics().get("avgPostsPerUser"), 0); //division by 0
        //Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerUser"), 0); //division by 0
        //Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerPost"), 0); //division by 0
    }

    @Test
    public void testCalculateAdvStatistics2() {
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
        //Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerPost"), 0); //division by 0
    }

    @Test
    public void testCalculateAdvStatistics3() {
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
        //Assert.assertEquals(0, calculate.showStatistics().get("avgPostsPerUser"), 0); //division by 0
        //Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerUser"), 0); //division by 0
        //Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerPost"), 0); //division by 0
    }

    @Test
    public void testCalculateAdvStatistics4() {
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
        //Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerPost"), 0); //division by 0
    }

    @Test
    public void testCalculateAdvStatistics5() {
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
        //Assert.assertEquals(0, calculate.showStatistics().get("avgPostsPerUser"), 0); //division by 0
        //Assert.assertEquals(-0.04, calculate.showStatistics().get("avgCommentsPerUser"), 0); //division by 0
        //Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerPost"), 0); //division by 0
    }

    @Test
    public void testCalculateAdvStatistics6() {
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
        //Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerPost"), 0); //division by 0
    }

    @Test
    public void testCalculateAdvStatistics7() {
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
        //Assert.assertEquals(0, calculate.showStatistics().get("avgPostsPerUser"), 0); //division by 0
        //Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerUser"), 0); //division by 0
        Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerPost"), 0);
    }

    @Test
    public void testCalculateAdvStatistics8() {
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
    public void testCalculateAdvStatistics9() {
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
        //Assert.assertEquals(0, calculate.showStatistics().get("avgPostsPerUser"), 0); //division by 0
        //Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerUser"), 0); //division by 0
        Assert.assertEquals(6.876, calculate.showStatistics().get("avgCommentsPerPost"), 0);
    }

    @Test
    public void testCalculateAdvStatistics10() {
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
    public void testCalculateAdvStatistics11() {
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
        //Assert.assertEquals(0, calculate.showStatistics().get("avgPostsPerUser"), 0); //division by 0
        //Assert.assertEquals(0, calculate.showStatistics().get("avgCommentsPerUser"), 0); //division by 0
        Assert.assertEquals(0.256, calculate.showStatistics().get("avgCommentsPerPost"), 0);
    }

    @Test
    public void testCalculateAdvStatistics12() {
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
