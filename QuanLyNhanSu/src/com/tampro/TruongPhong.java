package com.tampro;

import java.util.Scanner;

/*Mục Đích : Quản lý TruongPhong
 * Ngày tạo : 26/06/2020
 * Người tạo : Nguyễn Chí Tâm 
 * Version : 1.0
 */
public class TruongPhong extends NhanSu {
	private final int LUONG_MOT_NGAY = 200;
	private final int PHU_CAP_MOI_NHAN_VIEN = 100;
	    //1.Attributes 
	    private int  soLuongNVDuoiQuyen ;
		//2.Constructors methods
		public TruongPhong(String maSo, String hoTen, String soDienThoai, float soNgayLamViec) {
			super(maSo, hoTen, soDienThoai, soNgayLamViec);
			this.soLuongNVDuoiQuyen = 0;
		}
		public TruongPhong() {
			super();
			soLuongNVDuoiQuyen = 0;
		}
		//3.Get,set methods
		public int getSoLuongNVDuoiQuyen() {
			return soLuongNVDuoiQuyen;
		}
		
		public void setSoLuongNVDuoiQuyen(int soLuongNVDuoiQuyen) {
			this.soLuongNVDuoiQuyen = soLuongNVDuoiQuyen;
		}
		//4.Input,output methods
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
			System.out.println("\t[Số lượng nhân viên quản lý ] : "+soLuongNVDuoiQuyen);
		}
		public void xuatMaVaTen() {
			System.out.println("\t[Mã] : "+this.maSo + "\t[Tên] : "+this.hoTen);
		}
		//5.Business methods
		@Override
		public void tinhLuong() {
			// TODO Auto-generated method stub
			this.luongThang = LUONG_MOT_NGAY * soNgayLamViec  + PHU_CAP_MOI_NHAN_VIEN * soLuongNVDuoiQuyen;
		}
		public void tangNhanVien() {
			this.soLuongNVDuoiQuyen++;
		}
		public void giamNhanVien () {
			this.soLuongNVDuoiQuyen--;
		}
		
}
