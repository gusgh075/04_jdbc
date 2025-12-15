package com.jinosoft.section03.delete;

import java.sql.Connection;
import static com.jinosoft.common.JDBCTemplate.*;

public class MenuService {
  public int removeMenu(int menuCode) {
    Connection con = getConnection();

    MenuRepository menuRepository = new MenuRepository();

    int result = menuRepository.removeMenu(con, menuCode);

    if (result > 0) {
      commit(con);
    } else  {
      rollback(con);
    }

    close(con);

    return result;
  }
}