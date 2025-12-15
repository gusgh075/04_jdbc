package com.google.section02.prepared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.google.common.JDBCTemplate.close;
import static com.google.common.JDBCTemplate.getConnection;

/* PreparedStatement(준비된 Statement)
*  - Statement에 SQL을 미리 준비 시켜 놓고
*    ?(위치 홀더, place holder) 자리에 알맞은 값을 세팅 후 수행하는 객체
*  - Statement의 자식 인터페이스 (다형성 적용가능)
*  - 장점
*    1) SQL Injection 방지
*    2) SQL 조합이 간단함
*    3) 속도가 빠름(DBMS 캐싱)
**/
public class Application2 {
  public static void main(String[] args) throws SQLException {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rset = null;

    Scanner sc = new Scanner(System.in);

    System.out.print("메뉴 카테고리 코드 입력 : ");
    int categoryCode = sc.nextInt();

    System.out.print("메뉴 가격 입력 : ");
    int menuPrice = sc.nextInt();

    try {
      con= getConnection();


      String sql="select *" +
          " from tbl_menu" +
          " where category_code = ?" +
          " and menu_price >= ?";
      pstmt = con.prepareStatement(sql);

      pstmt.setInt(1,categoryCode);
      pstmt.setInt(2,menuPrice);

      rset = pstmt.executeQuery();

      while(rset.next()){
        System.out.println(rset.getInt(1) + " " + rset.getString(2));
      }

    } catch(Exception e){
      throw  new RuntimeException(e);
    } finally {
      close(rset);
      close(pstmt);
      close(con);
    }
  }
}
