package com.jinosoft.section02.prepared;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.jinosoft.common.JDBCTemplate.*;

/* PreparedStatement(준비된 Statement)
*  - Statement에 SQL을 미리 준비시켜 놓고
*  ?(Placeholder) 자리에 알맞은 값을 세팅 후 수행하는 객체
*  - Statement의 자식 인터페이스
*
*  - 장점
*    1) SQL Injection 방지
*    2) SQL 조합이 간단함
*    3) 속도가 빠름(DBMS 캐싱)
*  */
public class Application1 {
  public static void main(String[] args) throws SQLException {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rset = null;

    try {
      con= getConnection();

      String sql="select * from tbl_menu where menu_code = ?";
      pstmt = con.prepareStatement(sql); // 요이

      pstmt.setInt(1,16);

      rset = pstmt.executeQuery(); // 땅


    } catch(Exception e){
      throw  new RuntimeException(e);
    } finally {
      close(rset);
      close(pstmt);
      close(con);
    }
  }
}
