package com.qew032.section03;

import java.sql.Connection;

import static com.qew032.common.JDBCTemplate.*;

public class MenuService {

    public int removeMenu(int menuCode) {

        Connection con = getConnection();

        MenuRepository menuRepository = new MenuRepository();

        // repository 메서드를 호출하여 결과(1: 성공, 0:실패) 반환 받기
        int result = menuRepository.deleteMenu(con, menuCode);

        if(result > 0)  commit(con);
        else                rollback(con);

        return result;
    }

}
