/*
 * Copyright (c) 2020-2025. All rights reserved.
 * Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 *
 */

package labs.pm.data;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductManager {
    private Product product;
    private Review review;
    public Product createProduct(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore){
        product= new Food(id,name,price,rating,bestBefore);
        return  product;
    }
    public  Product createProduct(int id, String name, BigDecimal price, Rating rating){
        product =new Drink(id,name,price,rating);
        return product
                ;
    }
    public Product reviewProduct(Product product,Rating rating,String comments){
        review=new Review(rating,comments);
        this.product=product.applyRaating(rating);
        return this.product;

    }
    public  void printProductReport(){
        StringBuilder txt =new StringBuilder();
        txt.append(product);
        txt.append("\n");
        if(review !=null){
            txt.append(review);
        }else{
            txt.append("not reviewed");
        }
        txt.append("\n");
        System.out.println(txt);


    }

}
