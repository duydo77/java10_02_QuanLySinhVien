package com.quanlysinhvien;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class QuanLySinhVien {
	Scanner sc = new Scanner(System.in);
	List<SinhVien> dsSinhVien = new ArrayList<SinhVien>();
	
	public SinhVien getSinhVien(int idx) { 
		return dsSinhVien.get(idx);
	}
	
	public int soLuong() {
		return dsSinhVien.size();
	}
	
	public void themSV(SinhVien newSv) {		
		this.dsSinhVien.add(newSv);
	}	
	
	public LinkedList<Integer> svDTBCaoNhat() {
		float diemCaoNhat = this.getDiemMax();
		LinkedList<Integer> dsDiemCaoNhat = new LinkedList<>();
		for (int i = 0; i < dsSinhVien.size(); i++) {
			if (diemCaoNhat == dsSinhVien.get(i).getDiemTrungBinh()) {
				dsDiemCaoNhat.add(i);
			}
		}
		return dsDiemCaoNhat;
	}
	
	public float getDiemMax() {
		float tempDiemMax = 0;
		for (SinhVien sv: dsSinhVien) {
			if(tempDiemMax < sv.getDiemTrungBinh()) {
				tempDiemMax = sv.getDiemTrungBinh();
			}
		}
		return tempDiemMax;
	}
	
	public LinkedList<Integer> dsSVYeu(){
		LinkedList<Integer> dsSvYeu = new LinkedList<>();
		for (int i = 0; i < dsSinhVien.size(); i++) {
			if (dsSinhVien.get(i).getLoai() == "Yeu") {
				dsSvYeu.add(i);
			}
		}
		return dsSvYeu;
	}
	
	public LinkedList<Integer> timTheoTen(String hoTen) {
		LinkedList<Integer> dsSv = new LinkedList<Integer>();
		for (int i = 0; i < dsSinhVien.size(); i++) {
			if (dsSinhVien.get(i).getHoTen().contains(hoTen)) {
				dsSv.add(i);
			}
		}
		return dsSv;
	}
	
	public LinkedList<Integer> timTheoMa(String maSo) {
		LinkedList<Integer> dsSv = new LinkedList<Integer>();
		for (int i = 0; i < dsSinhVien.size(); i++) {
			if (dsSinhVien.get(i).getHoTen() == maSo) {
				dsSv.add(i);
			}
		}
		return dsSv;
	}
	
	public void xoaSinhVien(String maSo) {
		int idSvXoa = -1;
		for (int i = 0; i < dsSinhVien.size(); i++) {
			if(dsSinhVien.get(i).getMaSo().equalsIgnoreCase(maSo)) {
				idSvXoa = i;
			}
		}
		if (idSvXoa != -1) {
			dsSinhVien.remove(idSvXoa);			
			System.out.println("Đã xóa sinh viên.");
		}else {
			System.out.println("Khong có sinh viên với mã số " + maSo +".");
		}
		
	}
}
