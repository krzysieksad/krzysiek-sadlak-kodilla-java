package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacBuilder() {
        //given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .ingredient(Bigmac.IngredientType.BACON)
                .burgers(3)
                .ingredient(Bigmac.IngredientType.CHILI_PEPPER)
                .ingredient(Bigmac.IngredientType.ONION)
                .sauce(Bigmac.SauceType.STANDARD)
                .roll(Bigmac.RollType.ROLL_WITH_SESAME)
                .ingredient(Bigmac.IngredientType.CHEESE)
                .build();

        //when
        int ingredients = bigmac.getIngredients().size();

        //then
        Assert.assertEquals(4, ingredients);
    }
}
