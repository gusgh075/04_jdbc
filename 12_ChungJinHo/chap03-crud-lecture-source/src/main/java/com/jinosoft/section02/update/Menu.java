package com.jinosoft.section02.update;

public class Menu {
  private int menuCode;
  private String menuName;
  private int menuPrice;
  private int categoryCode;
  private String orderableStatus;

  public Menu(int menuCode,String menuName, int menuPrice) {
    this.menuCode = menuCode;
    this.menuName = menuName;
    this.menuPrice = menuPrice;

  }

  public void setMenuCode(int menuCode) {
    this.menuCode = menuCode;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }
  public void setMenuPrice(int menuPrice) {
    this.menuPrice = menuPrice;
  }
  public void setCategoryCode(int categoryCode) {
    this.categoryCode = categoryCode;
  }
  public void setOrderableStatus(String orderableStatus) {
    this.orderableStatus = orderableStatus;
  }

  public int getMenuCode() {
    return menuCode;
  }

  public String getMenuName() {
    return menuName;
  }
  public int getMenuPrice() {
    return menuPrice;
  }
  public int getCategoryCode() {
    return categoryCode;
  }
  public String getOrderableStatus() {
    return orderableStatus;
  }
}
