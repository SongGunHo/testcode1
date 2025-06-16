package com.koreait.ex01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
public class Ex01 {

    @Autowired
    private DataSource dataSource;

    @Test
    void test1() throws SQLException {
        Connection con = dataSource.getConnection();
        System.out.println(con);






    }

















}
