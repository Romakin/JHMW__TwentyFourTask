package com.example.Hamcrest;

import com.example.Task3.ParserJsonToList;
import com.example.Utils.Employee;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ParserJsonToListTest {

    private ParserJsonToList parser;

    @Before
    public void initTest() {
        parser = new ParserJsonToList();
    }

    @After
    public void afterTest() {
        parser = null;
    }

    @Test
    public void eqParseTest() {
        //given:
        String jsonStr = "[{\"id\":3,\"firstName\":\"Test1\",\"lastName\":\"Test1L\",\"country\":\"EN\",\"age\":18}," +
                "{\"id\":4,\"firstName\":\"Test2\",\"lastName\":\"Test2L\",\"country\":\"DE\",\"age\":38}]";
        //when:
        List<Employee> test1 = parser.jsonToList(jsonStr);
        List<Employee> test2 = parser.jsonToListNormal(jsonStr);
        /* Здесь использована функция, которой нет в JUnit */
        //then:
        MatcherAssert.assertThat(test1.toArray(), Matchers.arrayContainingInAnyOrder(test2.toArray()));
    }

}
