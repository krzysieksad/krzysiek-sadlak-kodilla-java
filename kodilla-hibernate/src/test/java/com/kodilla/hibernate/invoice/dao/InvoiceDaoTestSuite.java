package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ItemDao itemDao;

    @Test
    public void testInvoiceDaoSave() {
        //given
        Product bottledWater = new Product("Bottled Water");
        Product ham = new Product("Ham");
        Product cheese = new Product("Cheese");
        Product butter = new Product("Butter");
        Product bread = new Product("Bread");
        productDao.save(bottledWater);
        productDao.save(ham);
        productDao.save(cheese);
        productDao.save(butter);
        productDao.save(bread);
        int bottledWaterId = bottledWater.getId();
        int hamId = ham.getId();
        int cheeseId = cheese.getId();
        int butterId = butter.getId();
        int breadId = bread.getId();

        Item item1 = new Item(bottledWater, new BigDecimal(2), 10, new BigDecimal(20));
        Item item2 = new Item(ham, new BigDecimal(36.50), 2, new BigDecimal(73));
        Item item3 = new Item(butter, new BigDecimal(6), 2, new BigDecimal(12));
        Item item4 = new Item(bread, new BigDecimal(3), 2, new BigDecimal(6));
        Item item5 = new Item(ham, new BigDecimal(36.50), 4, new BigDecimal(146));
        Item item6 = new Item(cheese, new BigDecimal(25.90), 1, new BigDecimal(25.90));
        Item item7 = new Item(bottledWater, new BigDecimal(2), 50, new BigDecimal(100));
        Item item8 = new Item(butter, new BigDecimal(6), 5, new BigDecimal(30));
        Item item9 = new Item(cheese, new BigDecimal(25.90), 3, new BigDecimal(77.70));
        Invoice invoice1 = new Invoice("20180306/00001");
        Invoice invoice2 = new Invoice("20180306/00002");
        Invoice invoice3 = new Invoice("20180306/00003");

        item1.setInvoice(invoice1);
        item2.setInvoice(invoice1);
        item3.setInvoice(invoice1);
        item4.setInvoice(invoice1);
        item5.setInvoice(invoice2);
        item6.setInvoice(invoice2);
        item7.setInvoice(invoice2);
        item8.setInvoice(invoice3);
        item9.setInvoice(invoice3);
        invoice1.getItems().addAll(Arrays.asList(item1, item2, item3, item4));
        invoice2.getItems().addAll(Arrays.asList(item5, item6, item7));
        invoice3.getItems().addAll(Arrays.asList(item8, item9));

        //when
        invoiceDao.save(invoice1);
        invoiceDao.save(invoice2);
        invoiceDao.save(invoice3);

        int invoice1Id = invoice1.getId();
        int invoice2Id = invoice2.getId();
        int invoice3Id = invoice3.getId();

        //then
        Assert.assertEquals(5, productDao.count());
        Assert.assertEquals(9, itemDao.count());
        Assert.assertEquals(3, invoiceDao.count());

        //cleanUp
        try {
            invoiceDao.delete(invoice1Id);
            invoiceDao.delete(invoice2Id);
            invoiceDao.delete(invoice3Id);
            productDao.delete(bottledWaterId);
            productDao.delete(hamId);
            productDao.delete(cheeseId);
            productDao.delete(butterId);
            productDao.delete(breadId);
        } catch (Exception e) {
            //nothing
        }
    }
}
