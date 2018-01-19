package com.csbme.awe.Service;

import com.csbme.awe.model.Record;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Sqlite {

    /**
     * @return the Connection object
     */
    private Connection connect() {
        String url = "jdbc:sqlite:sqlite.db";

        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
            System.out.println("db connection ok");

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * @param record
     */
    public void insert(Record record) {
        String sql = "INSERT INTO my_table(subject, grade) VALUES(?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, record.getSubject());
            pstmt.setString(2, record.getGrade());
            pstmt.executeUpdate();
            System.out.println("db insert new record");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
