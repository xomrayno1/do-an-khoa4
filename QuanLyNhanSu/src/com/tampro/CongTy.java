package com.tampro;

import java.util.ArrayList;
import java.util.Scanner;

/*Mục Đích : Quản lý nhân sự 
 * Ngày tạo : 26/06/2020
 * Người tạo : Nguyễn Chí Tâm 
 * Version : 1.0
 */
public class CongTy {
	//1.Attributes 
	private String tenCongTy;
	private String maSoThue;
	private float doanhThuThang;
	private DanhSachNhanSu dsNhanSu;
		//2.Constructors methods
	public CongTy(String tenCongTy, String maSoThue, float doanhThuThang,DanhSachNhanSu ds) {
		
		this.tenCongTy = tenCongTy;
		this.maSoThue = maSoThue;
		this.doanhThuThang = doanhThuThang;
		this.dsNhanSu = ds;
	}
		public CongTy() {
			dsNhanSu = new DanhSachNhanSu();
			dummyDataCongTy();
			dummyDataNhanSu();
		}
		//3.Get,set methods
		public String getTenCongTy() {
			return tenCongTy;
		}
		public void setTenCongTy(String tenCongTy) {
			this.tenCongTy = tenCongTy;
		}
		public String getMaSoThue() {
			return maSoThue;
		}
		public void setMaSoThue(String maSoThue) {
			this.maSoThue = maSoThue;
		}
		public float getDoanhThuThang() {
			return doanhThuThang;
		}
		public void setDoanhThuThang(float doanhThuThang) {
			this.doanhThuThang = doanhThuThang;
		}
		public DanhSachNhanSu getDsNhanSu() {
			return dsNhanSu;
		}
		public void setDsNhanSu(DanhSachNhanSu dsNhanSu) {
			this.dsNhanSu = dsNhanSu;
		}
		
		//4.Input,output methods
		public void nhap(Scanner sc) {
			System.out.println("============ Nhập thông tin công ty ============");
			System.out.println("Nhập thông tin công ty");
			this.tenCongTy = sc.nextLine();
			System.out.println("Nhập mã số thuế");
			this.maSoThue = sc.nextLine();
			System.out.println("Nhập doanh thu tháng");
			this.doanhThuThang = Float.parseFloat(sc.nextLine());	
			System.out.println("============ Kết thúc ============");
		}
		public void xuat() {
			System.out.println("\t[Tên công ty] : "+this.tenCongTy
					+"\t[Mã số thuế] : "+this.maSoThue
					+"\t[Doanh thu tháng] : "+this.doanhThuThang
					);
			dsNhanSu.xuatToanBoCongTy();
		}
		//5.Business methods
		public void tinhLuong() {
			dsNhanSu.tinhLuongToanBoCongTy();
		}
		public void outHelper(ArrayList<NhanSu> list) {
			for(NhanSu items : list) {
				items.xuat();
			}
		}
		public void PhanBo(Scanner sc) {
			for(NhanSu items : dsNhanSu.getListDsNhanSu()) {
				if(items instanceof NhanVienThuong) {
					NhanVienThuong nvt = (NhanVienThuong) items;
					if(nvt.getTruongPhongQuanLy() == null ) {
						nvt.xuat();
						PhanBoChoMotNhanSu(sc,nvt);
					}
				}
			}
		}
		public void themNhanSu(Scanner sc) {
			ArrayList<NhanVienThuong> lnvt = dsNhanSu.nhap(sc);
			for(NhanVienThuong nvt : lnvt) {
				nvt.xuat();
				PhanBoChoMotNhanSu(sc,nvt);
				dsNhanSu.addNhanSu(nvt);
			}
			
		
		}
		public void PhanBoChoMotNhanSu(Scanner sc,NhanVienThuong nvt) {
			System.out.println("Bạn có muốn phân bổ hay ko . Chọn 1 . Phân Bổ , Chọn khác 1 . Đi tiếp");
			int option = Integer.parseInt(sc.nextLine());
			if(option == 1) {
				TruongPhong tp = chonTruongPhong(sc);
				nvt.setTruongPhongQuanLy(tp);
				tp.tangNhanVien();
			}
		}
		public TruongPhong chonTruongPhong(Scanner sc) {
			return (TruongPhong)dsNhanSu.chonTruongPhong(sc);
		}
		public boolean deleteNhanSuByMa(String ma) {
			return dsNhanSu.deleteNhanSuByMa(ma);
		}
		public void xuatNhanSu() {
			dsNhanSu.xuatToanBoCongTy();
		}
		public void tinhLuongCongTy() {
			dsNhanSu.tinhLuongToanBoCongTy();
		}
		public void tongLuongCongTy() {
			dsNhanSu.tongLuongCongTy();
		}
		public ArrayList<NhanSu> timNVThuongLuongCaoNhat(){
			return dsNhanSu.timNVThuongLuongCaoNhat();
		}
		public ArrayList<NhanSu> timTruongPhongNhieuNVNhat(){
			return dsNhanSu.timTruongPhongNhieuNVNhat();
		}
		public void sortNhanSuTheoAbc() {
			dsNhanSu.sortNhanSuTheoAbc();
		}
		public void sortNhanSuTheoLuongGiam() {
			dsNhanSu.sortNhanSuTheoLuongGiam();
		}
		public ArrayList<NhanSu> timGiamDocCoPhanNhiuNhat() {
			return dsNhanSu.timGiamDocCoPhanNhiuNhat();
		}
		public void tinhTongThuNhapCuaTungGiamDoc() {
			 dsNhanSu.tinhTongThuNhapCuaTungGiamDoc(doanhThuThang);
		}
		
		//String maSo, String hoTen, String soDienThoai, float soNgayLamViec,	TruongPhong truongPhongQuanLy    nv thuong
		//String maSo, String hoTen, String soDienThoai, float soNgayLamViec
		public void dummyDataNhanSu() {
			NhanSu ns = new NhanSu();
			ns = new NhanVienThuong("1","Nguyễn Văn A","12345",20);
			dsNhanSu.addNhanSu(ns);
			ns = new NhanVienThuong("2","Nguyễn Văn B","13245",18);
			dsNhanSu.addNhanSu(ns);
			ns = new NhanVienThuong("3","Nguyễn Văn C","14345",29);
			dsNhanSu.addNhanSu(ns);
			ns = new NhanVienThuong("4","Nguyễn Văn D","17345",17);
			dsNhanSu.addNhanSu(ns);
			ns = new NhanVienThuong("5","Nguyễn Văn E","19345",15);
			dsNhanSu.addNhanSu(ns);
			ns = new NhanVienThuong("6","Nguyễn Văn F","11345",25);
			dsNhanSu.addNhanSu(ns);
			
			ns = new TruongPhong("7","Trần Văn G","23212",18);
			dsNhanSu.addNhanSu(ns);
			ns = new TruongPhong("8","Trần Văn I","23122",18);
			dsNhanSu.addNhanSu(ns);
			ns = new TruongPhong("9","Trần Văn J","22221",28);
			dsNhanSu.addNhanSu(ns);
			
			ns = new GiamDoc("10","Lê Văn X","23211",16);
			dsNhanSu.addNhanSu(ns);
			ns = new GiamDoc("11","Lê Văn Y","232111",28);
			dsNhanSu.addNhanSu(ns);
			
		}
		public void dummyDataCongTy() {
			this.tenCongTy  = "com.tampro";
			this.doanhThuThang = 43000;
			this.maSoThue = "2323111";
		}
		
}
