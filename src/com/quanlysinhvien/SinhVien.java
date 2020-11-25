package com.quanlysinhvien;

public class SinhVien {
	private String 	maSo;
	private String 	hoTen;
	private float	diemToan;
	private float	diemLy;
	private float	diemHoa;
	private String 	soDienThoai;
	private String 	email;
	private String 	diaChiThuongChu;
	private	String 	diaChiTamTru;
	
	public SinhVien(String hoTen, String maSo, String soDienThoai, String diaChiThuongTru, String diaChiTamTru, String email) {
		this.hoTen = hoTen;
		this.maSo = maSo;
		this.soDienThoai = soDienThoai;
		this.diaChiThuongChu = diaChiThuongTru;
		this.diaChiTamTru = diaChiTamTru;
		this.email = email;
		this.diemToan = -1;
		this.diemLy = -1;
		this.diemHoa = -1;
	}
	
	public SinhVien(String hoTen, String maSo, String soDienThoai, String diaChiThuongTru, String diaChiTamTru, String email, float diemToan, float 	diemLy, float diemHoa) {
		this.hoTen = hoTen;
		this.maSo = maSo;
		this.soDienThoai = soDienThoai;
		this.diaChiThuongChu = diaChiThuongTru;
		this.diaChiTamTru = diaChiTamTru;
		this.email = email;
		this.diemToan = diemToan;
		this.diemLy = diemLy;
		this.setDiemHoa(diemHoa);		
	}
	
	public String getHoTen() {
		return hoTen;
	}
	
	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public float getDiemToan() {
		return diemToan;
	}

	public void setDiemToan(float diemToan) {
		this.diemToan = diemToan;
	}

	public float getDiemLy() {
		return diemLy;
	}

	public void setDiemLy(float diemLy) {
		this.diemLy = diemLy;
	}

	public float getDiemHoa() {
		return diemHoa;
	}

	public void setDiemHoa(float diemHoa) {
		this.diemHoa = diemHoa;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChiThuongChu() {
		return diaChiThuongChu;
	}

	public void setDiaChiThuongChu(String diaChiThuongChu) {
		this.diaChiThuongChu = diaChiThuongChu;
	}

	public String getDiaChiTamTru() {
		return diaChiTamTru;
	}

	public void setDiaChiTamTru(String diaChiTamTru) {
		this.diaChiTamTru = diaChiTamTru;
	}

	public String getMaSo() {
		return maSo;
	}

	public float getDiemTrungBinh() {
		if(this.diemHoa == -1 || this.diemLy == -1 || this.diemToan == -1) {
			return -1;
		}
		return (float)(Math.round(((this.diemToan + this.diemLy + this.diemHoa) / 3) * 100 ) / 100);
	}
	
	public String getLoai() {
		xepLoaiSinhVien();
		return xepLoaiSinhVien();
	}
	
	public String xepLoaiSinhVien() {
		float dtb = this.getDiemTrungBinh();
		if (dtb == -1) {
			 return "Chua xep loai";
		}else if (dtb >= 9.0) {
			 return "XS";
		}else if (dtb >= 8 && dtb < 9) {
			return "Gioi";
		}else if (dtb >= 7 && dtb < 8) {
			return "Kha";
		}else if (dtb >= 6 && dtb < 7) {
			return "TB Kha";
		}else if (dtb >= 5 && dtb > 5) {
			return "TB";
		}else {
			return "Yeu";
		}
	}
}
