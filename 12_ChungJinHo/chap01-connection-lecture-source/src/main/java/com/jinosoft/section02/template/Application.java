package com.jinosoft.section02.template;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static com.jinosoft.section02.template.JDBCTemplate.*;

/* properties 파일 내용을 읽어와 DB와 연결할 수 있다 */
public class Application {
  public static void main(String[] args) {

    Connection con = null;
    
    try{
      con = getConnection();
      System.out.println("con = " + con);
    } catch (Exception e) {
      throw  new RuntimeException(e);
    } finally {
      close(con);
      }

    }

  }
