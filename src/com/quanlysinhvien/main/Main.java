package com.quanlysinhvien.main;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.quanlysinhvien.QuanLySinhVien;
import com.quanlysinhvien.SinhVien;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		QuanLySinhVien qlsv = new QuanLySinhVien();
		int luaChon;
		boolean exit = false;

		qlsv.themSV(new SinhVien("Nguyen Van A", "SV01", "123", "HCM", "HCM", "sv01@gmail.com"));
		qlsv.themSV(new SinhVien("Nguyen Van B", "SV02", "243", "Vung Tau", "HCM", "sv02@gmail.com", (float) 5.5,
				(float) 8.9, (float) 5.2));
		qlsv.themSV(new SinhVien("Nguyen Van C", "SV03", "243", "Da Lat", "HCM", "sv03@gmail.com", (float) 6, (float) 9,
				(float) 2));
		qlsv.themSV(new SinhVien("Nguyen Van C", "SV04", "243", "Long An", "HCM", "sv04@gmail.com", (float) 5.5,
				(float) 10, (float) 3.5));

		while (exit == false) {

			inMenu();
			try {
				luaChon = Integer.parseInt(sc.nextLine());				
			} catch (Exception e) {
				luaChon = 0;
			}
			switch (luaChon) {
			case 1:
				System.out.println("===========================================================================");
				System.out.println("Danh sách sinh viên.=======================================================");
				System.out.println("===========================================================================");
				System.out.println("|STT\t|MSSV\t|Ho va ten\t\t|Diem Trung Binh|Xep Loai");
				System.out.println("---------------------------------------------------------------------------");
				for (int i = 0; i < qlsv.soLuong(); i++) {
					SinhVien sv = qlsv.getSinhVien(i);
					String dtb;
					if (sv.getDiemTrungBinh() == -1) {
						dtb = "chua nhap\t";
					}else {
						dtb = Float.toString(sv.getDiemTrungBinh()) + "\t\t";
					}
					System.out.println(String.format("|%d\t|%s\t|%s\t\t|%s|%s", i, sv.getMaSo(), sv.getHoTen(), dtb, sv.getLoai()));
				}
				break;
			case 2:
				System.out.println();
				System.out.println("===========================================================================");
				System.out.println("Danh sách sinh viên có điểm trung bình cao nhất.===========================");
				System.out.println("===========================================================================");
				System.out.println("|STT\t|MSSV\t|Ho va ten\t\t|Diem Trung Binh|Xep Loai");
				System.out.println("---------------------------------------------------------------------------");
				LinkedList<Integer> dsSv = qlsv.svDTBCaoNhat();
				for (int i = 0; i < dsSv.size(); i++) {
					SinhVien sv = qlsv.getSinhVien(dsSv.get(i));
					String dtb = Float.toString(sv.getDiemTrungBinh()) + "\t\t";
					System.out.println(String.format("|%d\t|%s\t|%s\t\t|%s|%s", i, sv.getMaSo(), sv.getHoTen(), dtb, sv.getLoai()));
				}
				break;
			case 3: 
				System.out.println("\n=============================================================================");
				System.out.println("Danh sách sinh viên yếu.=======================================================");
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("|STT\t|MSSV\t|Ho va ten\t\t|Diem Trung Binh|Xep Loai");
				System.out.println("---------------------------------------------------------------------------");
				List<Integer> dsSvYeu = qlsv.dsSVYeu();
				for (int i = 0; i < dsSvYeu.size(); i++) {
					SinhVien sv = qlsv.getSinhVien(dsSvYeu.get(i));
					String dtb = Float.toString(sv.getDiemTrungBinh()) + "\t\t";
					System.out.println(String.format("|%d\t|%s\t|%s\t\t|%s|%s", i, sv.getMaSo(), sv.getHoTen(), dtb, sv.getLoai()));
				}
				break;
			case 4:
				System.out.println("\n============================================================================");
				System.out.println("Tìm danh sách theo tên.=======================================================");
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("|STT\t|MSSV\t|Ho va ten\t\t|Diem Trung Binh|Xep Loai");
				System.out.print("Nhập tên sinh viên muốn tìm: ");
				LinkedList<Integer> dsSvTimTheoTen = qlsv.timTheoTen(sc.nextLine());
				if(dsSvTimTheoTen.size() == 0) {
					System.out.println("Khong tim thay sinh vien phu hop");
				}else {
					
					for (int i = 0; i < dsSvTimTheoTen.size(); i++) {
						SinhVien sv = qlsv.getSinhVien(dsSvTimTheoTen.get(i));
						String dtb = Float.toString(sv.getDiemTrungBinh()) + "\t\t";
						System.out.println(String.format("|%d\t|%s\t|%s\t\t|%s|%s", i, sv.getMaSo(), sv.getHoTen(), dtb, sv.getLoai()));
					}
				}
				break;
			case 5:
				System.out.println("\n============================================================================");
				System.out.println("Tìm danh sách theo ma so sinh vien.===========================================");
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println("|STT\t|MSSV\t|Ho va ten\t\t|Diem Trung Binh|Xep Loai");
				System.out.print("Nhập ma so sinh viên muốn tìm: ");
				LinkedList<Integer> dsSvTimTheoMS = qlsv.timTheoTen(sc.nextLine());
				if(dsSvTimTheoMS.size() == 0) {
					System.out.println("Không tìm thấy sinh viên phù hợp.");
				}else {
					
					for (int i = 0; i < dsSvTimTheoMS.size(); i++) {
						SinhVien sv = qlsv.getSinhVien(dsSvTimTheoMS.get(i));
						String dtb = Float.toString(sv.getDiemTrungBinh()) + "\t\t";
						System.out.println(String.format("|%d\t|%s\t|%s\t\t|%s|%s", i, sv.getMaSo(), sv.getHoTen(), dtb, sv.getLoai()));
					}
				}
				break;
			case 6:
				System.out.println("\n===========================================================================");
				System.out.println("Xóa sinh viên theo mã số sinh viên.==========================================");
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.print("Nhập mã số sinh viên muốn xóa: ");
				qlsv.xoaSinhVien(sc.nextLine());
				break;
			default:
				System.out.println("Thoát chương trình.");
				exit = true;
				break;
			}
			System.out.println("Nhan phim Enter de tiep tuc...");
			sc.nextLine();
			
		}
		sc.close();

	}

	private static void inMenu() {
		System.out.println("CHƯƠNG TRÌNH QUAN LÝ SINH VIÊN.");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("1. Hiện danh sách sinh viên.");
		System.out.println("2. Sinh viên có điểm trung bình cao nhất.");
		System.out.println("3. Danh sách sinh viên yếu.");
		System.out.println("4. Tìm sinh viên theo tên.");
		System.out.println("5. Tìm sinh viên theo mã số.");
		System.out.println("6. Xóa sinh viên.");
		System.out.println("0. Thoat.");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.print("Mời bạn nhập từ 1 đến 6 để chọn lựa chon, nhập phím khác để thoát): ");
	}

}
