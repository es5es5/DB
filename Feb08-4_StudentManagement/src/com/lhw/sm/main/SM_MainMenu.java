// View : 사람 눈에 보여지는 영역
//			입력받기
//			결과출력
//		디자이너

package com.lhw.sm.main;

import java.util.Scanner;

import com.lhw.sm.student.StudentDTO;

// View
public class SM_MainMenu {
	public static void showMainMenu() {
		Scanner keyboard = null;
		
		try {
			keyboard = new Scanner(System.in);
			System.out.println("1. 학생 등록");
			System.out.println("2. 학생 조회");
			System.out.println("3. 점수 수정");
			System.out.println("4. 이름 수정");
			System.out.println("5. 학생 삭제");
			System.out.println("6. 종료");
			System.out.println("-----------");
			System.out.print("뭐 : ");
			int menu = keyboard.nextInt();
			SM_MainController.go(menu);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
	public static void showInsertStudentMenu() {
		Scanner keyboard = null;
		try {
			keyboard = new Scanner(System.in);
			System.out.print("이름 : ");
			String name = keyboard.next();
			System.out.print("생일(YYYYMMDD) : ");
			String birthday2 = keyboard.next();
			System.out.print("중간 : ");
			double mid = keyboard.nextDouble();
			System.out.print("기말 : ");
			double fin = keyboard.nextDouble();
			
			// INSERT시킬 정보를 다 가지고 있는 학생 객체
			StudentDTO s = new StudentDTO();
			s.setName(name);
			s.setMid(mid);
			s.setFin(fin);
			s.setBirthday2(birthday2);
			
			SM_MainController.goDBWork(1, s);;
			
		} catch (Exception e) {
			SM_MainController.goPrintRegStudentResult(0);
		}
	}
	public static void showDelStudentMenu() {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(System.in);
			
			System.out.print("삭제할 학생 번호 : ");
			int no = keyboard.nextInt();
			
			// 자바빈 DTO
			StudentDTO s = new StudentDTO();
			s.setNo(no);
			
			SM_MainController.goDBWork(5, s);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void showUpdateStudentMenu() {
		Scanner keyboard = null;

		try {
			keyboard = new Scanner(System.in);
			
			System.out.print("수정할 학생 번호 : ");
			int no = keyboard.nextInt();
			System.out.print("중간 점수 : ");
			double mid = keyboard.nextDouble();
			System.out.print("기말 점수 : ");
			double fin = keyboard.nextDouble();
			
			// 자바빈 DTO
			StudentDTO s = new StudentDTO();
			s.setNo(no);
			s.setMid(mid);
			s.setFin(fin);
			
			SM_MainController.goDBWork(3, s);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void showUpdateName() {
		Scanner keyboard = null;
		try {
			keyboard = new Scanner(System.in);
			System.out.print("바꿀 학생 번호 : ");
			int no = keyboard.nextInt();
			
			StudentDTO s = new StudentDTO();
			s.setNo(no);
			
			SM_MainController.goDBWork(4, s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void showAll() {
		SM_MainController.goDBWork(2, null);
	}
}
