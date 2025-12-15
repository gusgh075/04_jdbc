package com.google.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/* 반복되는 JDBC 관련 코드를 미리 작성해서 Util용으로 사용할
   JDVCTemplate 클래스를 만들 수 있다. */
public class JDBCTemplate {
  public static Connection getConnection () {
    Properties prop = new Properties();
    Connection con = null;

    try {
      prop.load(new FileReader("src/main/java/com/google/config/jdbc-config.properties"));

      // properties 파일에서 읽어온 데이터를 Key를 통해 얻어옴
      String url = prop.getProperty("url");
      String user = prop.getProperty("user");
      String password = prop.getProperty("password");

      con = DriverManager.getConnection(url, user, password);
      System.out.println("con = " + con);

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return con;
  }

  /**
   * Connection을 닫는 메서드
   * - 메모리 자원 반환
   * - DBMS 연결된 커넥션 제거
   * @param con
   */
  public static void close(Connection con){
    try {
     if(con != null && !con.isClosed()) con.close(); // 참조하고 있는 객체가 있을때 널포인트 익셉션
    } catch (SQLException e) {
      throw new RuntimeException(e); // sqlexception은 꼭 실행되어야 하는데 unchecked로 바꿔줌!
    }
  }

  public static void close(Statement stmt){
    try {
      if(stmt != null && !stmt.isClosed()) stmt.close(); // 참조하고 있는 객체가 있을때 널포인트 익셉션
    } catch (SQLException e) {
      throw new RuntimeException(e); // sqlexception은 꼭 실행되어야 하는데 unchecked로 바꿔줌!
    }
  }

  public static void close(ResultSet rset){
    try {
      if(rset != null && !rset.isClosed()) rset.close(); // 참조하고 있는 객체가 있을때 널포인트 익셉션
    } catch (SQLException e) {
      throw new RuntimeException(e); // sqlexception은 꼭 실행되어야 하는데 unchecked로 바꿔줌!
    }
  }
}
