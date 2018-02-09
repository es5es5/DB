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

import java.util.ArrayList;

import com.lhw.sm.student.StudentDAO;
import com.lhw.sm.student.StudentDTO;

// Controller
public class SM_MainController {
	public static void goDBWork(int what, StudentDTO s) {
		
		if (what == 1) { // 학생 등록
			StudentDAO.reg(s);
		} else if(what == 2) { // 학생 조회
			StudentDAO.showAll();
		} else if(what == 3) { // 이름 수정
			StudentDAO.updateScore(s);
		} else if(what == 4) { // 이름 수정
			StudentDAO.updateName(s);
		} else if(what == 5) { // 학생 삭제
			StudentDAO.del(s);
		} else { // 종료
			
		}
	}
	
	
	public static void go(int menu) {
		if (menu == 1) {
			SM_MainMenu.showInsertStudentMenu();
		} else if (menu == 2) {
			SM_MainMenu.showAll();
		} else if (menu == 3) {
			SM_MainMenu.showUpdateStudentMenu();
		} else if (menu == 4) {
			SM_MainMenu.showUpdateName();
		} else if (menu == 5) {
			SM_MainMenu.showDelStudentMenu();
		} else if (menu == 6) {
			System.out.println("종료");
		}			
	}
	
	public static void main(String[] args) {
		SM_MainMenu.showMainMenu();
	}
	
	public static void goPrintRegStudentResult(int what) {
		SM_View.printRegStudentResult(what);
	}
	
	public static void goShowAll(int what, ArrayList<StudentDTO> students) {
		SM_View.printShoAllResult(what, students);
	}
}
