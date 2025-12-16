package com.beyond.section03.delete;

import com.beyond.section02.update.Menu;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import static com.beyond.common.JDBCTemplate.close;

public class MenuRepository {
  public int removeMenu(Connection con, int menuCode) {
    int result = 0; // 업데이트 결과 1 또는 0 저장할 변수

    PreparedStatement pstmt = null;
    Properties prop = new Properties(); // XML 읽어오기

    try{
      prop.loadFromXML(new FileInputStream("src/main/java/com/beyond/mapper/MenuMapper.xml"));

      String sql = prop.getProperty("deleteMenu");

      pstmt = con.prepareStatement(sql);

      pstmt.setInt(1, menuCode);

      result = pstmt.executeUpdate(); // UPDATE 수행

    }catch(Exception e){
      throw new RuntimeException(e);
    } finally {
      close(pstmt);
    }

    return result;
  }
}
