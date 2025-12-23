/*
 * Copyright (c) 2020-2025. All rights reserved.
 * Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 *
 */
/**
 * {@code Shop} class represents an application that manages Products
 * @version 4.0
 * @author NANO
 */

package labs.pm.app;
import labs.pm.data.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

public class Shop {
    public static void main(String[] args) {
//        Product p1=new Product(101,"Juice",BigDecimal.valueOf(1.99));
//        Product p2=new Drink(102,"Tea",BigDecimal.valueOf(23.4),Rating.FOUR_STAR);
//        Product p3=new Food(103,"Pizza",BigDecimal.valueOf(200.4),Rating.FOUR_STAR, LocalDate.now().plusDays(2));
//        System.out.println("p1: "+ p1);
//        System.out.println("p2: "+ p2);
//        System.out.println("p3: "+ p3);
        ProductManager pm=new ProductManager(Locale.of("Fr"));
        Product p6=pm.createProduct(104,"Chocolate",BigDecimal.valueOf(2.99),Rating.NOT_RATED);
        Product p7=pm.createProduct(105,"Cake",BigDecimal.valueOf(2.99),Rating.NOT_RATED);
        pm.printProductReport(p6);
        pm.printProductReport(p7);
//        p6= pm.reviewProduct(p6,Rating.THREE_STAR,"Nice hot cup of tea");
//        p6= pm.reviewProduct(p6,Rating.FOUR_STAR,"Nice hot cup");
        pm.reviewProduct(p6,Rating.THREE_STAR,"Nice hot cup of tea");
        pm.reviewProduct(p6,Rating.FOUR_STAR,"Nice hot cup");
      pm.printProductReport(p6);
//        Product p7=pm.createProduct(101,"Chocolate",BigDecimal.valueOf(2.99),Rating.FIVE_STAR,LocalDate.now().plusDays(2));
//        System.out.println(p6+"\n");
//        System.out.println(p7);
//        System.out.println(p6.equals(p7));
     ;
    }
}