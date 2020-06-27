package com.tampro;

import java.util.ArrayList;
import java.util.Scanner;

public class XuLy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CongTy congTy = new CongTy();
		doMenu(sc,congTy);
	}
	public  static void inMenu() {
		System.out.println("1.Nhập thông tin công ty");
		System.out.println("2.Phân bổ nhân viên trưởng phòng");
		System.out.println("3.Xuất toàn bộ người trong công ty");
		System.out.println("4.Tính và xuất tổng lương cho toàn công ty");
		System.out.println("5.Tìm nhân viên thường có lương cao nhất");
		System.out.println("6.Tìm trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất");
		System.out.println("7.Sắp xếp toàn công ty theo thứ tự abc");
		System.out.println("8.Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần");
		System.out.println("9.Tìm giám đốc có cổ phần nhiều nhất");
		System.out.println("10.Tính và xuất thu nhập của từng giám đốc");
		System.out.println("11.Xóa nhân sự");
		System.out.println("12.Thêm nhân sự");
	}
	public static void doMenu(Scanner sc , CongTy ct) {
		boolean flag = true;
		ArrayList<NhanSu> ns;
		do {
			inMenu();
			int option = Integer.parseInt(sc.nextLine());
			switch (option) {
			case 1:
				ct.nhap(sc);
				ct.themNhanSu(sc);
				break;
			case 2:
				ct.PhanBo(sc);
				break;
			case 3:
				ct.tinhLuongCongTy();
				ct.xuatNhanSu();
				break;
			case 4:
				ct.tongLuongCongTy();
				float tongLuong = ct.getDsNhanSu().getTongLuongCongTy();
				System.out.println("Tổng lương cho công ty là :"+tongLuong);
				break;
			case 5:
				ns = ct.timNVThuongLuongCaoNhat();
				ct.outHelper(ns);
				break;
			case 6:
				ns = ct.timTruongPhongNhieuNVNhat();
				ct.outHelper(ns);
				break;
			case 7:
				ct.sortNhanSuTheoAbc();
				break;
			case 8:
				ct.sortNhanSuTheoLuongGiam();
				break;
			case 9:
				 ns = ct.timGiamDocCoPhanNhiuNhat();
				 ct.outHelper(ns);
				break;
			case 10:
				ct.tinhTongThuNhapCuaTungGiamDoc();
				break;
			case 11:
				System.out.println("Nhập mã nhân sự cần Xóa");
				String ma = sc.nextLine();
				boolean check = ct.deleteNhanSuByMa(ma);
				if(!check) {
					System.out.println("Mã không tồn tại");
				}else {
					System.out.println("Thành Công");
				}
				break;
			case 12:
				ct.themNhanSu(sc);
				break;
			default:
				flag = false;
				break;
			}
		}while(flag);
	}
}
