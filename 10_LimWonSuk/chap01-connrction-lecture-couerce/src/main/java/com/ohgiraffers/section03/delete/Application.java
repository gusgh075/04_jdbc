package com.ohgiraffers.section03.delete;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 메뉴 코드를 입력하세요: ");
        int menuCode = sc.nextInt();


        MenuRepository menuRepository = new MenuRepository();


        System.out.println(menuCode + "번 메뉴 삭제 성공!");
        {
            System.out.println(menuCode + "번 메뉴 삭제 실패!");


            sc.close();
        }
    }
}