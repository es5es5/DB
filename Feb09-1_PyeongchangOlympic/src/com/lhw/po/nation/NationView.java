package com.lhw.po.nation;

import java.util.ArrayList;

import com.lhw.po.main.MainView;

public class NationView {
	public static void printRegResult(String what) {
		try {
			if (what.equals("성공")) {
				System.out.println("나라 등록 성공");
			} else {
				System.out.println("나라 등록 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MainView.showMainMenu();
		}
	}
	
	public static void printUpdateResult(String what) {
		try {
			if (what.equals("성공")) {
				System.out.println("나라 메달 수 수정 성공");
			} else {
				System.out.println("나라 메달 수 수정 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MainView.showMainMenu();
		}
	}

	public static void printDelResult(String what) {
		try {
			if (what.equals("성공")) {
				System.out.println("나라 삭제 성공");
			} else {
				System.out.println("나라 삭제 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MainView.showMainMenu();
		}
	}

	public static void printSearchResult(String what, ArrayList<NationDTO> nations) {
		try {
			if (what.equals("성공")) {
				for (NationDTO nation : nations) {
					nation.nationInfo();
				}
			} else if (what.equals("없는나라")) {
				System.out.println("없는 나라 검색");
			} else {
				System.out.println("나라 검색 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MainView.showMainMenu();
		}
	}

	public static void printSearchMedalResult(String what, ArrayList<NationDTO> nations) {
		try {
			if (what.equals("성공")) {
				for (NationDTO nation : nations) {
					nation.nationMedalInfo();
				}
			} else if (what.equals("없는나라")) {
				System.out.println("없는 나라 검색");
			} else {
				System.out.println("나라 검색 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MainView.showMainMenu();
		}
	}
	

}
