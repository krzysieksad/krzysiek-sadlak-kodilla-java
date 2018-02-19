package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //given
        User mike = new Millenials("mike02");
        User jennifer = new YGeneration("jenn_sweet");
        User sally = new ZGeneration("salem");

        //when
        String mikePost = mike.sharePost();
        String jenniferPost = jennifer.sharePost();
        String sallyPost = sally.sharePost();

        //then
        Assert.assertEquals("Post shared on Twitter.", mikePost);
        Assert.assertEquals("Post shared on Facebook.", jenniferPost);
        Assert.assertEquals("Post shared on Snapchat.", sallyPost);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //given
        User jake = new Millenials("jake_the_great");

        //when
        jake.setSocialPublisher(new FacebookPublisher());
        String jakePost = jake.sharePost();

        //then
        Assert.assertEquals("Post shared on Facebook.", jakePost);
    }
}
