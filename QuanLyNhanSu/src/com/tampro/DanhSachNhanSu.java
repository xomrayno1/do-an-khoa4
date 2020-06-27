package com.tampro;
/*Mục Đích : Quản lý nhân sự 
 * Ngày tạo : 26/06/2020
 * Người tạo : Nguyễn Chí Tâm 
 * Version : 1.0
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DanhSachNhanSu {

	// 1.Attributes
	private ArrayList<NhanSu> listDsNhanSu;
	private float tongLuongCongTy;

	// 2.Constructors methods
	public DanhSachNhanSu(ArrayList<NhanSu> listDsNhanSu) {
		this.listDsNhanSu = listDsNhanSu;
	}

	public DanhSachNhanSu() {
		listDsNhanSu = new ArrayList<NhanSu>();
	}

	// 3.Get,set methods
	public ArrayList<NhanSu> getListDsNhanSu() {
		return listDsNhanSu;
	}

	public void setListDsNhanSu(ArrayList<NhanSu> listDsNhanSu) {
		this.listDsNhanSu = listDsNhanSu;
	}

	public float getTongLuongCongTy() {
		return tongLuongCongTy;
	}

	// 4.Input,output methods

	public ArrayList<NhanVienThuong> nhap(Scanner sc) {
		boolean flag = true;
		NhanSu ns = null;
		ArrayList<NhanVienThuong> listNhanVienThuong  = new ArrayList<NhanVienThuong>();
		do {
			System.out.println("1.Nhập thông tin nhân viên thường");
			System.out.println("2.Nhập thông tin trưởng phòng");
			System.out.println("3.Nhập thông tin giám đốc");
			System.out.println("4... Thoát");
			int option = Integer.parseInt(sc.nextLine());
			switch (option) {
			case 1:
				 ns = new NhanVienThuong();
				 ns.nhap(sc);
				 ns.tinhLuong();
				 listNhanVienThuong.add((NhanVienThuong)ns);
				break;
			case 2:
				ns = new TruongPhong();
				ns.nhap(sc);
				ns.tinhLuong();
				addNhanSu(ns);
				break;
			case 3:
				ns = new GiamDoc();
				ns.nhap(sc);
				ns.tinhLuong();
				addNhanSu(ns);
				break;
			default:
				flag = false;
				break;
			}
		}while(flag);
		
		return listNhanVienThuong;
	}

	

	// 5.Business methods
	public void addNhanSu(NhanSu ns) {
		listDsNhanSu.add(ns);
	}
	public NhanSu timKiemTruongPhongTheoMa(String maNhanSu) {
		
		for(NhanSu items : listDsNhanSu) {
			if(items instanceof TruongPhong) {
				if(items.getMaSo().equalsIgnoreCase(maNhanSu)) {
					return items;
				}
			}
		}

		return null;
	}

	public ArrayList<NhanSu> xuatNhanVienChuaDuocPhanBo() {
		ArrayList<NhanSu> dsNhanSuChuaPhanBo = new ArrayList<NhanSu>();
		for(NhanSu items : listDsNhanSu) {
			if(items instanceof NhanVienThuong) {
				if(((NhanVienThuong) items).getTruongPhongQuanLy() == null ) {
					dsNhanSuChuaPhanBo.add(items);
				}
			}
		}
		return dsNhanSuChuaPhanBo;
	}
	public ArrayList<TruongPhong> xuatDanhSachTruongPhong() {
		ArrayList<TruongPhong> dsTruongPhong = new ArrayList<TruongPhong>();
		for(NhanSu items : listDsNhanSu) {
			if(items instanceof TruongPhong) {
				TruongPhong tp = (TruongPhong) items;
				dsTruongPhong.add(tp);
			}
		}
		return dsTruongPhong;
	}


	public boolean deleteNhanSuByMa(String ma) {

		for (NhanSu items : listDsNhanSu) {
			if (items.getMaSo().equalsIgnoreCase(ma)) {
				if (items instanceof NhanVienThuong) {
//					NhanVienThuong nt = (NhanVienThuong) items;
//					if(nt.getTruongPhongQuanLy() != null) {
//						nt.getTruongPhongQuanLy().giamNhanVien();	
//					}
					xoaNhanVien(items);
//					listDsNhanSu.remove(items);
//					return true;
				} else if (items instanceof TruongPhong) {
					for (NhanSu ns : listDsNhanSu) {
						if (ns instanceof NhanVienThuong) {
							NhanVienThuong nt = (NhanVienThuong) ns;
							if(nt.getTruongPhongQuanLy() != null && nt.getTruongPhongQuanLy().getMaSo().equalsIgnoreCase(ma)) {
								                         // có thể dùng items.getMaSo() vì items hiện tại là truong phong va la cai de xoa
								nt.setTruongPhongQuanLy(null);
							}
						}
					}
//					listDsNhanSu.remove(items);
//					return true;
				} 
//				else {
///					listDsNhanSu.remove(items);
///					return true;
//				}
				listDsNhanSu.remove(items);
				return true;
			}
		}

		return false;
	}
	public void xoaNhanVien(NhanSu items) {
		NhanVienThuong nt = (NhanVienThuong) items;
		if(nt.getTruongPhongQuanLy() != null) {
			nt.getTruongPhongQuanLy().giamNhanVien();	
		}
	}
	public NhanSu chonTruongPhong(Scanner sc) {
		NhanSu ns = null ;
		ArrayList<TruongPhong>  dsTruongPhong  = xuatDanhSachTruongPhong();
		do {
			for(TruongPhong item : dsTruongPhong) {
				item.xuatMaVaTen();
			}
			System.out.println("Vui lòng nhập mã trưởng phòng cần phân bổ");
			String ma = sc.nextLine();
			ns = timKiemTruongPhongTheoMa(ma);
			if(ns == null) {
				System.out.println("Mã nhập không đúng, vui lòng nhập lại");
			}
		}while(ns==null);
		
		return ns;
	}

	public void xuatToanBoCongTy() {
		for (NhanSu items : listDsNhanSu) {
			items.xuat();
		}
	}

	public void tinhLuongToanBoCongTy() {
		for (NhanSu items : listDsNhanSu) {
			items.tinhLuong();
		}
	}

	public void tongLuongCongTy() {
		int luong = 0;
		for (NhanSu items : listDsNhanSu) {
			luong += items.luongThang;
		}
		this.tongLuongCongTy = luong;
	}

	public ArrayList<NhanVienThuong> xuatToanBoNhanVienThuong() {
		ArrayList<NhanVienThuong> listNhanVienThuong = new ArrayList<NhanVienThuong>();
		for(NhanSu items : listDsNhanSu) {
			if(items instanceof NhanVienThuong) {
				NhanVienThuong nt = (NhanVienThuong) items;
				listNhanVienThuong.add(nt);
			}
		}
		return listNhanVienThuong;
	}
	public ArrayList<NhanSu> timNVThuongLuongCaoNhat() {
		ArrayList<NhanVienThuong> listNVThuong = xuatToanBoNhanVienThuong();
		if(listNVThuong !=null) {
			int indexMax = 0;
			for (int i = 1; i < listNVThuong.size(); i++) {
			
					NhanSu OjectCurrent = listNVThuong.get(i);
					NhanSu OjectMax = listNVThuong.get(indexMax);
					if (OjectCurrent.getLuongThang() > OjectMax.luongThang) {
						indexMax = i;
					}
				
			}
			ArrayList<NhanSu> listMax = new ArrayList<NhanSu>();
			for (int i = indexMax; i < listNVThuong.size(); i++) {
				
					NhanSu OjectCurrent = listNVThuong.get(i);
					NhanSu OjectMax = listNVThuong.get(indexMax);
					if (OjectCurrent.getLuongThang() == OjectMax.luongThang) {
						listMax.add(OjectCurrent);
					}
				
			}
			return listMax;
		}
		return null;
	}

	public ArrayList<NhanSu> timTruongPhongNhieuNVNhat() {
		ArrayList<TruongPhong> listTruongPhongs = xuatDanhSachTruongPhong();
		if(listTruongPhongs != null) {
			int indexMax = 0;
			for (int i = 1; i < listTruongPhongs.size(); i++) {
				
					NhanSu OjectCurrent = listTruongPhongs.get(i);
					NhanSu OjectMax = listTruongPhongs.get(indexMax);
					if (((TruongPhong) OjectCurrent).getSoLuongNVDuoiQuyen() > ((TruongPhong) OjectMax)
							.getSoLuongNVDuoiQuyen()) {
						indexMax = i;
					}

				
			}
			ArrayList<NhanSu> listMax = new ArrayList<NhanSu>();
			for (int i = indexMax; i < listTruongPhongs.size(); i++) {
				
					NhanSu OjectCurrent = listTruongPhongs.get(i);
					NhanSu OjectMax = listTruongPhongs.get(indexMax);
					if (((TruongPhong) OjectCurrent).getSoLuongNVDuoiQuyen() == ((TruongPhong) OjectMax)
							.getSoLuongNVDuoiQuyen()) {
						listMax.add(OjectCurrent);
					}
				
			}
			return listMax;
		}
		return null;
	}

	public void sortNhanSuTheoAbc() {
		for (int i = 0; i < listDsNhanSu.size(); i++) {
			for (int j = i + 1; j < listDsNhanSu.size(); j++) {
				if (listDsNhanSu.get(i).hoTen.compareToIgnoreCase(listDsNhanSu.get(i).hoTen) > 0) {
					Collections.swap(listDsNhanSu, i, j);
				}
			}
		}
		xuatToanBoCongTy();
	}

	public void sortNhanSuTheoLuongGiam() {
		for (int i = 0; i < listDsNhanSu.size(); i++) {
			for (int j = i + 1; j < listDsNhanSu.size(); j++) {
				if (listDsNhanSu.get(i).luongThang < listDsNhanSu.get(j).luongThang) {
					Collections.swap(listDsNhanSu, i, j);
				}
			}
		}
		xuatToanBoCongTy();
	}

	public ArrayList<NhanSu> timGiamDocCoPhanNhiuNhat() {
		int indexMax = 0;
		for (int i = 1; i < listDsNhanSu.size(); i++) {
			if (listDsNhanSu.get(i) instanceof GiamDoc) {
				NhanSu OjectCurrent = listDsNhanSu.get(i);
				NhanSu OjectMax = listDsNhanSu.get(indexMax);
				if (((GiamDoc) OjectCurrent).getSoCoPhan() > ((GiamDoc) OjectMax).getSoCoPhan()) {
					indexMax = i;
				}
			}
		}
		ArrayList<NhanSu> list = new ArrayList<NhanSu>();
		for (int i = indexMax; i < listDsNhanSu.size(); i++) {
			if (listDsNhanSu.get(i) instanceof GiamDoc) {
				NhanSu OjectCurrent = listDsNhanSu.get(i);
				NhanSu OjectMax = listDsNhanSu.get(indexMax);
				if (((GiamDoc) OjectCurrent).getSoCoPhan() == ((GiamDoc) OjectMax).getSoCoPhan()) {
					list.add(OjectCurrent);
				}
			}
		}
		return list;
	}

	public void tinhTongThuNhapCuaTungGiamDoc(float doanhThuThang) {
		float loiNhuan = doanhThuThang - tongLuongCongTy;
		for (NhanSu items : listDsNhanSu) {
			if (items instanceof GiamDoc) {
				GiamDoc gd = (GiamDoc) items;
				float thuNhap = gd.luongThang + gd.getSoCoPhan() * loiNhuan;
				System.out.println("\t[Tên] : " + items.hoTen + "\t[Tổng thu nhập] : " + thuNhap);
			}
		}
	}

}
