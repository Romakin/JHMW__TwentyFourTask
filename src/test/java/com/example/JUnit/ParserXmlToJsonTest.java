package com.example.JUnit;

import com.example.Task2.ParserXmlToJson;
import com.example.Utils.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class ParserXmlToJsonTest {

    private ParserXmlToJson parser;

    @Before
    public void initTest() {
        parser = new ParserXmlToJson();
    }

    @After
    public void afterTest() {
        parser = null;
    }

    @Test
    public void parseXML_success() {
        //given:
        final String filePath = "./data.xml";
        // when:
        List<Employee> list = parser.parseXML(filePath);
        // then:
        Assertions.assertTrue(list != null && list.size() > 0);
    }

    @Test
    public void parseXML_failure() {
        //given:
        final String filePath = "./data_can_not_find_file.xml";
        // when:-
        List<Employee> list = parser.parseXML(filePath);
        // then:
        Assertions.assertNull(list);
    }

}
