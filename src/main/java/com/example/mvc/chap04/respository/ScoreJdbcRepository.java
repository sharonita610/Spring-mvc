package com.example.mvc.chap04.respository;

import com.example.mvc.chap04.entity.Score;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("jdbc")
public class ScoreJdbcRepository implements ScoreRepository {


    // ============================= db 연결 ========================
    private String url = "jdbc:mariadb://localhost:3306/spring";
    private String username = "root";
    private String password = "1234";


    public ScoreJdbcRepository() {
        // 1. 드라이버 클래스를 로딩 (mariadb 커넥터 로딩)
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Score> findAll() {
        return null;
    }

    @Override
    public List<Score> findAll(String sort) {

        List<Score> scoreList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            String sql = "select * from tbl_score";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                scoreList.add(new Score(rs));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return scoreList;
    }




    @Override
    public boolean save(Score score) {

        // sql connection
        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            conn.setAutoCommit(false);

            String sql = "INSERT INTO TBL_SCORE (NAME, KOR, ENG, MATH, TOTAL, AVERAGE, GRADE)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, score.getName());
            pstmt.setInt(2, score.getKor());
            pstmt.setInt(3, score.getMath());
            pstmt.setInt(4, score.getEng());
            pstmt.setInt(5, score.getTotal());
            pstmt.setDouble(6, score.getAverage());
            pstmt.setString(7, String.valueOf(score.getGrade()));

            int result = pstmt.executeUpdate(); // 성공시 1 실패시 0

            if (result == 1) {
                conn.commit();
                return true;

            } else {
                conn.rollback();
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }


    @Override
    public boolean deleteByStuNum(int stuNum) {
        try(Connection conn = DriverManager.getConnection(url, username, password)){

            String sql = "delete from tbl_score where stu_num = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, stuNum);

            int del = pstmt.executeUpdate();

            if(del == 1){
                conn.commit();
                return true;
            }else {
                conn.rollback();
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    public Score findByStuNum(int stuNum) {

        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            conn.setAutoCommit(false);

            String sql = "SELECT * from tbl_score where stu_num = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, stuNum);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Score(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
