// Model : 비즈니스 로직
//			계산(실제 업무)
//		개발자, 고객

// View : 사람 눈에 보여지는 영역
//			입력받기
//			결과출력
//		디자이너

// Controller : 
//			상황 판단/ 필요한 기능 부르기
//		개발자

// Model을 또 나눔..
// DAO/DTO 패턴
// Data Access Object : DB에 관련된 작업 전담할 클래스
// Data Transfer / Temp Object : 작업 결과를 저장할 클래스

package com.lhw.sm.main;

import com.lhw.sm.student.StudentDTO;
import com.lhw.sm.student.StudentDAO;

// Controller
public class SMMain_C_Main {
	public static void goDBWork(int what, StudentDTO s) {
		
		if (what == 1) { // 학생 등록
			StudentDAO.reg(s);
		} else if(what == 2) {
			
		} else if(what == 3) { // 학생 수정
			StudentDAO.update(s);
		} else if(what == 4) {
			
		} else if(what == 5) { // 학생 삭제
			StudentDAO.del(s);
		}
	}
	
	
	public static void go(int menu) {
		if (menu == 1) {
			Menu_View.showInsertStudentMenu();
		} else if (menu == 2) {
			
		} else if (menu == 3) {
			Menu_View.showUpdateStudentMenu();
		} else if (menu == 4) {
			
		} else if (menu == 5) {
			Menu_View.showDelStudentMenu();
		} else if (menu == 6) {
			System.out.println("종료");
		}			
	}
	
	public static void main(String[] args) {
		Menu_View.showMainMenu();
	}
}
