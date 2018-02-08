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

import com.lhw.sm.student.StudentDTO;
import com.lhw.sm.student.StudentDAO;

// Controller
public class SMMain_C_Main {
	public static void goDBWork(int what, StudentDTO s) {
		
		if (what == 1) { // �л� ���
			StudentDAO.reg(s);
		} else if(what == 2) {
			
		} else if(what == 3) { // �л� ����
			StudentDAO.update(s);
		} else if(what == 4) {
			
		} else if(what == 5) { // �л� ����
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
			System.out.println("����");
		}			
	}
	
	public static void main(String[] args) {
		Menu_View.showMainMenu();
	}
}
