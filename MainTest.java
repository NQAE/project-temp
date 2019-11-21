package testNG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


public class MainTest {

    public static void main(String[] args) {

        //Task 2 Exercise 5
        List<SimpleModelBean> listSimpleModelBeans = new ArrayList<>();
        Collections.sort(listSimpleModelBeans);

        //Task 2 Exercise 6
        Collections.reverse(listSimpleModelBeans);

        //Task 2 Exercise 7
        //after overriding of Object.equals in SimpleModelBean,
        //adding new elements below to setSimpleModelBean
        //will work properly (will add just unique elements)
        HashSet<SimpleModelBean> setSimpleModelBean = new HashSet<>();
    }
}