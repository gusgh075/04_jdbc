package com.beyond.section03.delete;

import com.beyond.section03.delete.MenuRepository;

import java.sql.Connection;

import static com.beyond.common.JDBCTemplate.*;

public class MenuService {
  public int removeMenu(int menuCode) {

    Connection con = getConnection();

    MenuRepository menuRepository = new MenuRepository();

    // repository 메서드를 호출하여 결과(1: 성공, 0: 실패) 반환 받기
    int result = menuRepository.removeMenu(con, menuCode);

    if (result > 0)   commit(con);
    else              rollback(con);

    return result;


  }
}
