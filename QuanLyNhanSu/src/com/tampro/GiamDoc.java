package com.tampro;

import java.util.Scanner;

/*Mục Đích : Quản lý nhân sự 
 * Ngày tạo : 26/06/2020
 * Người tạo : Nguyễn Chí Tâm 
 * Version : 1.0
 */
public class GiamDoc extends NhanSu{
	private final int LUONG_MOT_NGAY = 300;
	    //1.Attributes 
	private float soCoPhan;
		//2.Constructors methods
	
	
		public GiamDoc(float soCoPhan) {
			super();
			this.soCoPhan = soCoPhan;
		}
		public GiamDoc(String maSo, String hoTen, String soDienThoai, float soNgayLamViec) {
			super(maSo, hoTen, soDienThoai, soNgayLamViec);
		}
		public GiamDoc() {
			
			super();
		}
		//3.Get,set methods
		public float getSoCoPhan() {
			return soCoPhan;
		}
		public void setSoCoPhan(float soCoPhan) {
			
			this.soCoPhan = soCoPhan;
		}
		//4.Input,output methods
		@Override
		public void nhap(Scanner sc) {
			// TODO Auto-generated method stub
			super.nhap(sc);
			do {
				System.out.println("Nhập số cổ phần ");
				this.soCoPhan = sc.nextInt();
			}while(soCoPhan > 100);
			
			System.out.println("============ Kết thúc ============");
		}
		@Override
		public void xuat() {
			// TODO Auto-generated method stub
			super.xuat();
			System.out.println("\t[Số cổ phần ] :"+soCoPhan);
		}
		//5.Business methods
		@Override
		public void tinhLuong() {
			// TODO Auto-generated method stub
		    this.luongThang = LUONG_MOT_NGAY * soNgayLamViec;
		}
}
