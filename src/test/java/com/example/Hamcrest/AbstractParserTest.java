package com.example.Hamcrest;

import com.example.Task1.ParserCsvToJson;
import com.example.Utils.Employee;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AbstractParserTest {

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
    public void saveToFileTest() {
        String filePath = "./test.test";
        List<Employee> list = new ArrayList<>();
        parser.saveToFile(filePath, list);
        File file = new File(filePath);
        MatcherAssert.assertThat(file.exists(), Matchers.is(true));
    }

    @Test
    public void clearFileTest() {
        String filePath = "./test.test";
        File file = new File(filePath);
        try {
            parser.clearFile(file);
        } catch (Exception e) {}
        MatcherAssert.assertThat(file.exists(), Matchers.is(false));
    }
}
