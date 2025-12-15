package com.jinosoft.section01.insert;

import com.jinosoft.common.JDBCTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.jinosoft.common.JDBCTemplate.*;

public class Application1 {
  public static  void main(String[] args) {
    String sql = "INSERT INTO tbl_menu(menu_name, menu_price, category_code, orderable_status) " +
        " VALUES(?, ?, ?, ?) ON DUPLICATED KEY UPDATE";

    Connection con = null;
    PreparedStatement pstmt = null;
    int result = 0; // DML 수행 결과는 반영된 행의 개수(int)

    Scanner sc = new Scanner(System.in);
    System.out.print("추가할 메뉴명 : ");
    String menuName = sc.nextLine();

    System.out.print("추가할 메뉴 가격 : ");
    int menuPrice = sc.nextInt();
    sc.nextLine();

    System.out.print("카테고리 코드 : ");
    int categoryCode = sc.nextInt();
    sc.nextLine();

    System.out.print("주문 가능 여부(Y,N) : ");
    String orderableStatus = sc.nextLine().toUpperCase();

    try {

      con = getConnection();

      pstmt = con.prepareStatement(sql);

      pstmt.setString(1, menuName);
      pstmt.setInt(2, menuPrice);
      pstmt.setInt(3, categoryCode);
      pstmt.setString(4, orderableStatus);

      result = pstmt.executeUpdate();
      if (result > 0) {
        System.out.println("메뉴 추가 성공!!!");
        con.commit();
      } else {
        System.out.println("메뉴 추가 실패...");
        con.rollback();
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      close(pstmt);
      close(con);
    }

  }
}
