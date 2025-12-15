package com.google.section03.delete;


import java.sql.Connection;

import static com.google.common.JDBCTemplate.*;

public class MenuService {


  public int removeMenu(int menuCode) {
    Connection con = getConnection();

    MenuRepository menuRepository = new MenuRepository();

    int result = menuRepository.removeMenu(con,menuCode);

    if(result > 0) commit(con);
    else rollback(con);

    return result;
  }
}


