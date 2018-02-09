// Model : ����Ͻ� ����
//			���(���� ����)
//		������, ��

// View : ��� ���� �������� ����
//			�Է¹ޱ�
//			������
//		�����̳�

// Controller : 
//			��Ȳ �Ǵ�/ �ʿ��� ��� �θ���
//		������

// Model�� �� ����..
// DAO/DTO ����
// Data Access Object : DB�� ���õ� �۾� ������ Ŭ����
// Data Transfer / Temp Object : �۾� ����� ������ Ŭ����

package com.lhw.sm.main;

import java.util.ArrayList;

import com.lhw.sm.student.StudentDAO;
import com.lhw.sm.student.StudentDTO;

// Controller
public class SM_MainController {
	public static void goDBWork(int what, StudentDTO s) {
		
		if (what == 1) { // �л� ���
			StudentDAO.reg(s);
		} else if(what == 2) { // �л� ��ȸ
			StudentDAO.showAll();
		} else if(what == 3) { // �̸� ����
			StudentDAO.updateScore(s);
		} else if(what == 4) { // �̸� ����
			StudentDAO.updateName(s);
		} else if(what == 5) { // �л� ����
			StudentDAO.del(s);
		} else { // ����
			
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
			System.out.println("����");
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
