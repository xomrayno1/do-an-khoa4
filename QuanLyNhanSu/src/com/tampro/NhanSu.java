package com.tampro;

import java.util.Scanner;

/*Mục Đích : Class cha quản lý nhân sự 
 * Ngày tạo : 26/06/2020
 * Người tạo : Nguyễn Chí Tâm 
 * Version : 1.0
 */
public class NhanSu {
	//1.Attributes 
	protected String maSo;
	protected String hoTen;
	protected String soDienThoai;
	protected float soNgayLamViec;
	protected float luongThang;
	//2.Constructors methods
	public NhanSu(String maSo, String hoTen, String soDienThoai, float soNgayLamViec) {
		
		this.maSo = maSo;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.soNgayLamViec = soNgayLamViec;
	}
	public NhanSu() {
		
	}
	//3.Get,set methods
	public String getMaSo() {
		return maSo;
	}
	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public float getSoNgayLamViec() {
		return soNgayLamViec;
	}
	public void setSoNgayLamViec(float soNgayLamViec) {
		this.soNgayLamViec = soNgayLamViec;
	}
	
	public float getLuongThang() {
		return luongThang;
	}
	//4.Input,output methods
	public void nhap(Scanner sc) {
		System.out.println("============ Thêm Nhân Sự ============");
		System.out.println("Nhập mã số \t");
		this.maSo = sc.nextLine();
		System.out.println("Nhập họ tên \t");
		this.hoTen = sc.nextLine();
		System.out.println("Nhập số điện thoại \t");
		this.soDienThoai = sc.nextLine();
		System.out.println("Nhập số ngày làm việc");
		this.soNgayLamViec = Float.parseFloat(sc.nextLine());
		
	}
	public void xuat() {
		System.out.print("\t [Mã số] : "+this.maSo
				+"\t [Họ tên] : "+this.hoTen
				+"\t [Số điện thoai] : "+this.soDienThoai
				+"\t [Số ngày làm việc] : "+this.soNgayLamViec
				+"\t [Lương tháng] : "+this.luongThang
				); 
	}
	//5.Business methods
	public void tinhLuong() {
		
	}

}
