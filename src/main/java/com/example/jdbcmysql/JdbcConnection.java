package com.example.jdbcmysql;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.sql.*;
//import java.util.concurrent.TimeUnit;


@Configuration
public class JdbcConnection {

    @Value("${user}")
    private String dbuser;

    @Value("${pass}")
    private String password;

    @Value("${name}")
    private String database;

    @Value("${host}")
    private String dbhost;

    @Value("${port}")
    private  String dbport;

    @Bean
    public void testJdbcConnection () throws Exception {

        String url = "jdbc:mysql://" + dbhost + ":" + dbport + "/" + database;

        Connection conn = null;
        conn = DriverManager.getConnection(url, dbuser, password);

        // System.out.println ("Here if connection was successful");

        Statement st = conn.createStatement();

        String query = "SELECT * from test";

        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            System.out.println("id: " + rs.getInt("ID") + "\ttext: " + rs.getString("Text"));
        }

        rs.close();
        st.close();
        conn.close();

        // TimeUnit.SECONDS.sleep(5);
    }
}
