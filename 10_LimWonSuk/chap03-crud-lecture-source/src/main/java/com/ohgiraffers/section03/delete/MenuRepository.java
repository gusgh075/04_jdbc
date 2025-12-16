package com.ohgiraffers.section03.delete;

import com.ohgiraffers.section02.update.Menu;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;

public class MenuRepository {
    public int updateMenu(Connection con, Menu modifyMenu){
        int result = 0; // 업데이트 결과 1 또는 0 저장할 변수
        PreparedStatement pstmt = null;
        Properties prop = new Properties(); // XML 읽어오기

        try{
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/MenuMapper.xml"));

            String sql = prop.getProperty("delete");

            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, modifyMenu.getMenuName());
            pstmt.setInt   (2, modifyMenu.getMenuPrice());
            pstmt.setInt   (3, modifyMenu.getMenuCode());

            result = pstmt.executeUpdate(); // UPDATE 수행

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }
}
