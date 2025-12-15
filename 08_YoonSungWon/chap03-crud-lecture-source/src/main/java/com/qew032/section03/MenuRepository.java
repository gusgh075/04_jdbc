package com.qew032.section03;

import com.qew032.section02.update.Menu;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import static com.qew032.common.JDBCTemplate.close;

public class MenuRepository {

    public int deleteMenu(Connection con, int menuCode) {
        // 삭제 결과 1 또는 0 저장할 변수
        int result = 0;

        PreparedStatement pstmt = null;
        Properties prop = new Properties();

        try {

            prop.loadFromXML(new FileInputStream("src/main/java/com/qew032/mapper/MenuMapper.xml"));

            String sql = prop.getProperty("deleteMenu");

            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, menuCode);

            // DELETE 수행
            result = pstmt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }
}
