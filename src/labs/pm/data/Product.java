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
 * {@code Product} class represents properties and behaviors of
 * product objects in the Product Management System.
 * <br>
 * Each product has an id, name, and price
 * <br>
 * Each product can have a discount, calculated based on a
 * {@link DISCOUNT_RATE discount rate}
 * @version 4.0
 * @author NANO
 */

package labs.pm.data;
import static labs.pm.data.Rating.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import static java.math.RoundingMode.HALF_UP;

public sealed abstract class Product permits Drink,Food {
    public static final BigDecimal DISCOUNT_RATE=BigDecimal.valueOf(0.1);
    private final int id;
    private final  String name;
    private final BigDecimal price;
//    private final Condition condition;
    private final Rating rating;
     Product(int id,String name,BigDecimal price,Rating rating){
        this.id=id;
        this.name=name;
        this.price=price;
//        this.condition=condition;
        this.rating=rating;
    }

//    public Product(int id,String name,BigDecimal price) {
//        this(id,name,price,NOT_RATED);
//
//    }
//    public  Product(){
//        this(0,"no name",BigDecimal.ZERO);
//    }

    public Rating getRating() {
        return rating;
    }

//    public Condition getCondition() {
//        return condition;
//    }

    public int getId() {
        return id;
    }

//    public void setId(final int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public BigDecimal getPrice() {
        return price;
    }

//    public void setPrice(final BigDecimal price) {
//        this.price = price;
//    }
//    public  String serve(){
//        return condition.getCaution();
//    }
    /**
     * Calculates discount based on a product price and
     * {@link DISCOUNT_RATE discount rate}
     *
     * @return a {@link java.math.BigDecimal BigDecimal}
     *         value of the discount
     */

    public  BigDecimal getDiscount(){
        return price.multiply(DISCOUNT_RATE).setScale(2,HALF_UP);
    }
     public abstract  Product applyRaating(Rating newRating);

    @Override
    public String toString() {
        return
                id +
                ", '" + name + '\'' +
                ", " + getDiscount() +
                ", " + rating.getRating()
                +" "+getBestBefore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o ) return true;
        if(o instanceof  Product product){
            return id == product.id && Objects.equals(name, product.name);

        }
        return  false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
    public LocalDate getBestBefore() {
        return LocalDate.now();
    }

}
