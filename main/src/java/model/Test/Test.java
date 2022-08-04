package model.Test;

import java.util.Arrays;
import java.util.List;

public class Test {


    public static void main(String[] args) {

            List<Integer> list = Arrays.asList(10, 1, 20, 19, 2);


            list.stream().forEachOrdered(System.out::println);


        }
}
