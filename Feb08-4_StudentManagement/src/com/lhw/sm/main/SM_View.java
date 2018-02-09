package com.lhw.sm.main;

import java.util.ArrayList;

import com.lhw.sm.student.StudentDTO;

public class SM_View {

	public static void printRegStudentResult(int what) {
		if (what == 1) {
			System.out.println("학생 등록 성공");
		} else {
			System.out.println("학생 등록 실패");
		}
		SM_MainController.main(null);
	}
	
	public static void printUpdateStudentResult(int what) {
		if (what == 1) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
		SM_MainController.main(null);
	}
	
	public static void printDelStudentResult(int what) {
		if (what == 1) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		SM_MainController.main(null);
	}
	
	public static void printShoAllResult(int what, ArrayList<StudentDTO> students) {
		if (what == 0) {
			System.out.println("등록된 학생이 없습니다.");
		} else if (what == -1) {
			System.out.println("학생 정보 받아오기 실패");
		} else if (what == 1) {
			for (StudentDTO s : students) {
				s.info();
			}
		}
		SM_MainController.main(null);
	}


	
}
