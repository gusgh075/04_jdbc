package com.jinosoft.section03.delete;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import static com.jinosoft.common.JDBCTemplate.close;

public class MenuRepository {

  public int removeMenu(Connection con, int menuCode) {
    int result = 0;

    PreparedStatement pstmt = null;
    Properties prop = new Properties();

    try {
      prop.loadFromXML(new FileInputStream("src/main/java/com/jinosoft/mapper/MenuMapper.xml"));

      String sql = prop.getProperty("deleteMenu");
      pstmt = con.prepareStatement(sql);

      pstmt.setInt(1, menuCode);

      result = pstmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      close(pstmt);
    }

    return result;
  }
}