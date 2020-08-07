package com.example.JUnit;

import com.example.Task3.ParserJsonToList;
import com.example.Utils.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

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
        //then:
        Assertions.assertArrayEquals(test1.toArray(), test2.toArray());
    }

}
