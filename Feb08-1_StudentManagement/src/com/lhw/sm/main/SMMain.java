//Connection : ����
//	������ ����� �� �ִ� ���� ����
//	con.close()�� �� ������ ������
//	
//PreparedStatement : sql �����ϴ� �༮
//	���� �ϳ��� ���� �� �ִ� ���� ����
//	pstmt.close()�� �� �༮ ���̱�


package com.lhw.sm.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import oracle.net.aso.k;

public class SMMain {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Connection con = null; // ���� (close�� �� ���� ����, ���� ����)
		PreparedStatement pstmt = null; // sql ���� (�� con�� ���� �� �ִ� ���� ���� �� 500��)
		int menu = 0;
		String sql = "";
		ResultSet rs =null;
		
		SimpleDateFormat sdf = null;
		sdf = new SimpleDateFormat("yyyy");
		int birthYear = 0;
		int nowYear = 0;
		int no = 0;
		double mid = 0;
		double fin = 0;
		String name = "";
		String birthday = "";
		
		try {
			// DB ���� �ּ�
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			// ����
			while (true) {
				System.out.println("-------------");
				System.out.println("1. �л� ���");
				System.out.println("2. �л� ��ȸ");
				System.out.println("3. ���� ����");
				System.out.println("4. �̸� ����");
				System.out.println("5. �л� ����");
				System.out.println("4. ����");
				System.out.println("-------------");
				System.out.print("�޴� : ");

				menu = keyboard.nextInt();
				if (menu == 1) {
					con = DriverManager.getConnection(url, "lhw", "lhw");
					System.out.print("�̸� : ");
					name = keyboard.next();
					System.out.print("����(YYYYMMDD) : ");
					birthday = keyboard.next();
					System.out.print("�߰� : ");
					mid = keyboard.nextDouble();
					System.out.print("�⸻ : ");
					fin = keyboard.nextDouble();

					sql = "insert into feb08_student values("
							+ "feb08_student_seq.nextval, ?, to_date(?,'YYYYMMDD'), ?,?" 
							+ ")";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(2, birthday);
					pstmt.setDouble(3, mid);
					pstmt.setDouble(4, fin);
					
					// INSERT
					if (pstmt.executeUpdate() == 1) {
						System.out.println("����");
					}
					
					pstmt.close();
					con.close();
					
				} else if (menu == 2) {
					con = DriverManager.getConnection(url, "lhw", "lhw");
					sql = "select s_no, s_name, s_birthday, (s_mid+s_fin)/2 as s_avg from feb08_student order by s_no desc";
					pstmt = con.prepareStatement(sql);
					
					// SELECT
					rs = pstmt.executeQuery();
					
					while (rs.next()) {
						System.out.println(rs.getInt("s_no") + ")");
						System.out.println("�̸� : " + rs.getString("s_name"));
						System.out.println("���� : " + rs.getDate("s_birthday"));
						
						// ���� ���
						birthYear = Integer.parseInt(sdf.format(rs.getDate("s_birthday")));
						nowYear = Integer.parseInt(sdf.format(new Date()));
						System.out.println("���� : " + (nowYear - birthYear + 1) + "��");
						
						System.out.println("��� : " + rs.getDouble("s_avg") + "��");
						System.out.println("-----");
					}
					
					rs.close();
					pstmt.close();
					con.close();
					
				} else if (menu == 3) {
					con = DriverManager.getConnection(url, "lhw", "lhw");
					System.out.println("�л� ��ȣ : ");
					no = keyboard.nextInt();
					System.out.println("�߰���� : ");
					mid = keyboard.nextDouble();
					System.out.println("�⸻��� : ");
					fin = keyboard.nextDouble();
					
					sql = "update feb08_student " + 
							"set s_mid=?, s_fin=? " + 
							"where s_no = ?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(3, no);
					pstmt.setDouble(1, mid);
					pstmt.setDouble(2, fin);
					
					if (pstmt.executeUpdate() == 1) {
						System.out.println("���� ����");
					}
					pstmt.close();
					con.close();
					
				} else if (menu == 4) {
					con = DriverManager.getConnection(url, "lhw", "lhw");
					System.out.println("�л� ��ȣ : ");
					no = keyboard.nextInt();
					System.out.println("�ٲ� �̸� : ");
					name = keyboard.next();
					
					sql = "update feb08_student " + 
							"set s_name = ? " + 
							"where s_no = ?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(2, no);
					pstmt.setString(1, name);
					
					if (pstmt.executeUpdate() == 1) {
						System.out.println("���� ����");
					}
					pstmt.close();
					con.close();
					
				} else if (menu == 5) {
					con = DriverManager.getConnection(url, "lhw", "lhw");
					System.out.println("������ ��ȣ : ");
					no = keyboard.nextInt();
					
					sql = "delete from FEB08_STUDENT " + 
							"where s_no = ?";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, no);
					if (pstmt.executeUpdate() == 1) {
						System.out.println("���� ����");
					}
					pstmt.close();
					con.close();
					
				} else {
					System.out.println("����");
					break;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			keyboard.close();
			try {pstmt.close();} catch (Exception e) {}
			try {con.close();} catch (Exception e) {}
		}
		
	}

}
