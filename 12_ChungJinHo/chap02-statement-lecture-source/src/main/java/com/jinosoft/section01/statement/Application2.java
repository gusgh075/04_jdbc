package com.jinosoft.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.jinosoft.common.JDBCTemplate.close;
import static com.jinosoft.common.JDBCTemplate.getConnection;

public class Application2 {
  public static void main(String[] args){
    Connection con = null; // DB 연결 객체
    Statement stmt = null; // SQL 전달 후 수행 결과 받아오는 객체
    ResultSet rset = null; // SELECT 수행 결과를 얻어와 저장하는 객체

    Scanner sc = new Scanner(System.in);
    System.out.print("조회할 메뉴 코드 입력 : ");
    int menuCode = sc.nextInt();

    try {
      con = getConnection();

      stmt = con.createStatement();

      String sql = "select * from tbl_menu where menu_code = " +  menuCode;

      /* ResultSet : SELECT 결과를 다루는 객체(1행 씩) */

      rset = stmt.executeQuery(sql);

      if(rset.next()){
        System.out.println("menu_code : " + rset.getInt("menu_code"));
        System.out.println("menu_name : " + rset.getString("menu_name"));
        System.out.println("menu_price : " + rset.getInt("menu_price"));
        System.out.println("category_code : " + rset.getInt("category_code"));
        System.out.println("orderable_status : " + rset.getString("orderable_status"));
        System.out.println("----------------------------------------------------------------------");
      } else {
        System.out.println("해당 메뉴코드와 일치하는 행이 없습니다.");
      }


    } catch (SQLException e){
      throw new RuntimeException(e);
    } finally {
      // 프로그램 안정성을 위하여 JDBC 객체를 생성 역순으로 반환
      close(stmt);
      close(rset);
      close(con);
    }

  }

}
