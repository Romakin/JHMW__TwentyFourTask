package com.example.JUnit;


import com.example.Task1.ParserCsvToJson;
import com.example.Utils.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

import java.util.List;

public class ParserCsvToJsonTest {

    private ParserCsvToJson parser;

    @Before
    public void initTest() {
        parser = new ParserCsvToJson();
    }

    @After
    public void afterTest() {
        parser = null;
    }

    @Test
    public void testParseCSV_apache_success() {
        // given:
        final  String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        final String filePath = "./data.csv";
        // when:
        List<Employee> list = parser.parseCSV_apache(filePath, columnMapping);
        // then:
        Assertions.assertTrue(list != null && list.size() > 0);
    }

    @Test
    public void testParseCSV_apache_failure() {
        // given:
        final  String[] columnMapping = {"col1", "col2", "col3", "col4", "col5"};
        final String filePath = "./data_can_not_find_file.csv";
        // when:
        List<Employee> list = parser.parseCSV_apache(filePath, columnMapping);
        // then:
        Assertions.assertNull(list);
    }

    @Test
    public void testParseCSV_opencsv_success() {
        // given:
        final  String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        final String filePath = "./data.csv";
        // when:
        List<Employee> list = parser.parseCSV_opencsv(filePath, columnMapping);
        // then:
        Assertions.assertTrue(list != null && list.size() > 0);
    }

    @Test
    public void testParseCSV_opencsv_failure() {
        // given:
        final  String[] columnMapping = {"col1", "col2", "col3", "col4", "col5"};
        final String filePath = "./data_can_not_find_file.csv";
        // when:
        List<Employee> list = parser.parseCSV_opencsv(filePath, columnMapping);
        // then:
        Assertions.assertNull(list);
    }
}
