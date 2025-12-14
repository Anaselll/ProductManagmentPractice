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
@FunctionalInterface
public interface Rateable <T>{
    public static final Rating DEFAULT_RATING=Rating.NOT_RATED;

  T applyRating(Rating rating);
  public default T applyRating(int stars){
      return applyRating(convert(stars));
  }
    public default Rating getRating(){
        return DEFAULT_RATING;
    }
    public static Rating convert(int starts){
        return (starts>=0 && starts<=5)? Rating.values()[starts]:DEFAULT_RATING;
    }

}
