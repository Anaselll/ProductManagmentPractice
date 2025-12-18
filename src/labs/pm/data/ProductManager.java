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
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class ProductManager {
    private Product product;
    //private Review review;
    private Review[] reviews=new Review[5];
    private Locale locale;
    private ResourceBundle resources;
    private DateTimeFormatter dateFormat;
    private NumberFormat moneyFormat;

    public ProductManager(Locale locale) {
        this.locale = locale;
        resources=ResourceBundle.getBundle("labs.pm.data.resources",locale);
        dateFormat=DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).localizedBy(locale);
        moneyFormat=NumberFormat.getCurrencyInstance(locale);
    }

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
        if(reviews[reviews.length-1]!=null){
            reviews= Arrays.copyOf(reviews,reviews.length+5);
        }
      //  review=new Review(rating,comments);

        int sum=0,i=0;

        boolean reviewed=false;
        while(i<reviews.length&& !reviewed){
            if(reviews[i]==null){
                reviews[i]=new Review(rating,comments);
                reviewed=true;
            }
            sum+=reviews[i].rating().ordinal();
            i++;
        }

        this.product=product.applyRating(Rateable.convert(Math.round((float)sum/i)));
        return this.product;

    }
    public  void printProductReport(){
        StringBuilder txt =new StringBuilder();
        String type=switch (product){
            case Food food->resources.getString("food");
            case Drink drink->resources.getString("drink");
        };
        txt.append(MessageFormat.format(resources.getString("product"),product.getName(),moneyFormat.format(product.getPrice()),product.getRating().getRating(),dateFormat.format(product.getBestBefore()),type));
        txt.append("\n");
        if(reviews[0]==null){
            txt.append("not reviewed");

        }
        for (Review review:reviews){
            if(review==null){
                break;
            }

                txt.append(review);


        }

        txt.append("\n");
        System.out.println(txt);
    }

}
