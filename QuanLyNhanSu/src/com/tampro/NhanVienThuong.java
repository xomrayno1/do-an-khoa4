package com.tampro;

import java.util.Scanner;

/*Mục Đích : Quản lý nhân viên thường 
 * Ngày tạo : 26/06/2020
 * Người tạo : Nguyễn Chí Tâm 
 * Version : 1.0
 */
public class NhanVienThuong extends NhanSu {
	private final int LUONG_MOT_NGAY = 100;
	// 1.Attributes
	private TruongPhong truongPhongQuanLy;
	// 2.Constructors methods

	public NhanVienThuong(String maSo, String hoTen, String soDienThoai, float soNgayLamViec,
			TruongPhong truongPhongQuanLy) {
		super(maSo, hoTen, soDienThoai, soNgayLamViec);
		this.truongPhongQuanLy = truongPhongQuanLy;
	}

	public NhanVienThuong(String maSo, String hoTen, String soDienThoai, float soNgayLamViec) {
		super(maSo, hoTen, soDienThoai, soNgayLamViec);
	}

	public NhanVienThuong() {
		super();
		truongPhongQuanLy = null;
	}

	// 3.Get,set methods
	public TruongPhong getTruongPhongQuanLy() {
		return truongPhongQuanLy;
	}

	public void setTruongPhongQuanLy(TruongPhong truongPhongQuanLy) {
		this.truongPhongQuanLy = truongPhongQuanLy;
	}

	// 4.Input,output methods
	@Override
	public void nhap(Scanner sc) {
		// TODO Auto-generated method stub
		super.nhap(sc);
		System.out.println("============ Kết thúc ============");
	}

	@Override
	public void xuat() {
		// TODO Auto-generated method stub
		super.xuat();
		String temp = "";
		if (truongPhongQuanLy != null) {
			temp = truongPhongQuanLy.getHoTen();
		}else {
			temp = "Chưa Có";
		}
		System.out.println("\t[Trưởng phòng quản lý] : " + temp);
		System.out.println();
	}

	// 5.Business methods
	@Override
	public void tinhLuong() {
		// TODO Auto-generated method stub
		this.luongThang = LUONG_MOT_NGAY * soNgayLamViec;
	}
}
