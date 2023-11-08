import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachNhanVien extends DanhSach{
	//Khai báo mảng các nhân viên
	private static ArrayList<NhanVien> danhSachNhanVien = new ArrayList<NhanVien>();
	public Scanner scan = new Scanner(System.in);
	
	//Các constructor của class
	public DanhSachNhanVien() {
		danhSachNhanVien = new ArrayList<NhanVien>();
	}
	public DanhSachNhanVien(NhanVien nv1) {
		danhSachNhanVien.add(nv1);
	}
	//Phương thức xuất
	@Override public void xuat() {
		System.out.println("=====================================================");
		for(NhanVien i: danhSachNhanVien) {
			i.xuat();
			System.out.println("=====================================================");
		}
	}
	
	//Phương thức thêm
	@Override public void them() {
		int luaChon;
		do {
			System.out.print("Nhap loai nhan vien can them (1.Nhan vien thoi vu   2. Nhan vien Chinh thuc): ");
			luaChon = Integer.parseInt(scan.nextLine());
		} while(luaChon < 1 || luaChon > 2);
		if (luaChon == 1) {
			NhanVienThoiVu newNhanVien = new NhanVienThoiVu();
			newNhanVien.nhap();
			danhSachNhanVien.add(newNhanVien);
		}
		else {
			NhanVienChinhThuc newNhanVien = new NhanVienChinhThuc();
			newNhanVien.nhap();
			danhSachNhanVien.add(newNhanVien);
		}
	}
	//Menu tìm kiếm
	@Override protected int menuTim() {
		if(danhSachNhanVien.size() == 0) {
			System.out.println("Khong co nhan vien nao trong danh sach!!!");
			return -1;
		}
		int luaChon = -1;
		System.out.println("===========================================");
		System.out.println("|1. Tim theo ma so nhan vien.");
		System.out.println("|2. Tim theo gioi tinh nhan vien.");
		System.out.println("|3. Tim theo ten nhan vien.");
		System.out.println("|4. Tim theo ma phong ban nhan vien.");
		System.out.println("|5. Tim theo loai nhan vien.");
		System.out.println("|6. Tim theo muc luong nhan vien.");
		System.out.println("|0. Huy tim kiem.");
		System.out.println("===========================================");
		do {
			System.out.println("Nhap lua chon: ");
			luaChon = Integer.parseInt(scan.nextLine());
		} while (luaChon < 0 || luaChon > 6);
		return luaChon;
	}
	//Phương thức tìm kiếm
		//*** Các phương thức tìm thành phần ***
	
			//***** Tìm theo mã số *****
	private ArrayList<NhanVien> timMaSo() {
		String maSoCanTim;
		ArrayList<NhanVien> nhanVienCanTim = new ArrayList<NhanVien>();
		do {
			System.out.print("Nhap ma so nhan vien can tim: ");
			maSoCanTim = scan.nextLine();
		} while(maSoCanTim.length() != NhanVien_CONST.NUMBEROFCHAR_MASO);
		for(NhanVien i: danhSachNhanVien) {
			String maSo = i.getMaSo();
			if(maSo == maSoCanTim.intern()) {
				nhanVienCanTim.add(i);
			}
		}
		return nhanVienCanTim;
	}
	
			//***** Tìm theo giới tính *****
	private ArrayList<NhanVien> timGioiTinh() {
		int gioiTinhDuocLuaChon;
		do {
			System.out.print("Gioi tinh (1.Nam 2.nu): ");
			gioiTinhDuocLuaChon = Integer.parseInt(scan.nextLine());
		} while(gioiTinhDuocLuaChon < 1 || gioiTinhDuocLuaChon > 2);
		switch(gioiTinhDuocLuaChon) {
			case 1:
				ArrayList<NhanVien> danhSachNhanVienNam = new ArrayList<NhanVien>();
				for(NhanVien i: danhSachNhanVien) {
					String gioiTinh = i.getGioiTinh();
					if(gioiTinh == NhanVien_CONST.GIOITINH_NAM) {
						danhSachNhanVienNam.add(i);
					}
				}
				return danhSachNhanVienNam;
			case 2:
				ArrayList<NhanVien> danhSachNhanVienNu = new ArrayList<NhanVien>();
				for(NhanVien i: danhSachNhanVien) {
					String gioiTinh = i.getGioiTinh();
					if(gioiTinh == NhanVien_CONST.GIOITINH_NU) {
						danhSachNhanVienNu.add(i);
					}
				}
				return danhSachNhanVienNu;
		}
		return null;
	}
	
			//***** Tìm theo tên *****
	private ArrayList<NhanVien> timTen() {
		String tenCanTim;
		ArrayList<NhanVien> danhSachNhanVienCungTen = new ArrayList<NhanVien>();
		System.out.println("Nhap ten nhan vien can tim: ");
		tenCanTim = scan.nextLine();
		for(NhanVien i: danhSachNhanVien) {
			String ten = i.getTen();
			if (ten == tenCanTim.intern()) {
				danhSachNhanVienCungTen.add(i);
			}
		}
		return danhSachNhanVienCungTen;
	}
	
			//***** Tìm theo mã phòng ban *****
	private ArrayList<NhanVien> timMaPhongBan() {
		String maPhongBanCanTim;
		ArrayList<NhanVien> danhSachNhanVienPhongBan = new ArrayList<NhanVien>();
		do {
			System.out.print("Nhap ma phong ban can tim: ");
			maPhongBanCanTim = scan.nextLine();
		} while(maPhongBanCanTim.length() != NhanVien_CONST.NUMBEROFCHAR_MAPHONGBAN);
		for(NhanVien i: danhSachNhanVien) {
			String maPhongBan = i.getMaPhongBan();
			if(maPhongBan == maPhongBanCanTim.intern()) {
				danhSachNhanVienPhongBan.add(i);
			}
		}
		return danhSachNhanVienPhongBan;
	}
	
			//***** Tìm theo loại nhân viên
	private ArrayList<NhanVien> timLoaiNhanVien() {
		int luaChon;
		do {
			System.out.print("Nhap loai nhan vien can tim (1.Nhan vien thoi vu   2. Nhan vien Chinh thuc): ");
			luaChon = Integer.parseInt(scan.nextLine());
		} while(luaChon < 1 || luaChon > 2);
		switch(luaChon) {
			case 1:
				ArrayList<NhanVien> danhSachNhanVienThoiVu = new ArrayList<NhanVien>();
				for(NhanVien i: danhSachNhanVien) {
					if(i instanceof NhanVienThoiVu) {
						danhSachNhanVienThoiVu.add(i);
					}
				}
				return danhSachNhanVienThoiVu;
			case 2:
				ArrayList<NhanVien> danhSachNhanVienChinhThuc = new ArrayList<NhanVien>();
				for(NhanVien i: danhSachNhanVien) {
					if(i instanceof NhanVienChinhThuc) {
						danhSachNhanVienChinhThuc.add(i);
					}
				}
				return danhSachNhanVienChinhThuc;
		}
		return null;
	}
	
			//***** Tìm theo mức lương *****
	private ArrayList<NhanVien> timMucLuong() {
		int luaChon;
		long mucLuongCanTim;
		ArrayList<NhanVien> danhSachNhanVienTheoMucLuong = new ArrayList<NhanVien>();
		do {
			System.out.println("Chon phan loai muc luong(1. >; 2. <; 3. =): ");
			luaChon = Integer.parseInt(scan.nextLine());
		} while(luaChon < 1 || luaChon > 3);
		do {
			System.out.println("Nhap muc luong can tim: ");
			mucLuongCanTim = Long.parseLong(scan.nextLine());
		} while(mucLuongCanTim < 0);
		switch(luaChon) {
			case 1:
				for(NhanVien i: danhSachNhanVien) {
					long luong = i.getMucLuong();
					if (luong > mucLuongCanTim) {
						danhSachNhanVienTheoMucLuong.add(i);
					}
				}
				return danhSachNhanVienTheoMucLuong;
			case 2:
				for(NhanVien i: danhSachNhanVien) {
					long luong = i.getMucLuong();
					if (luong < mucLuongCanTim) {
						danhSachNhanVienTheoMucLuong.add(i);
					}
				}
				return danhSachNhanVienTheoMucLuong;
			case 3:
				for(NhanVien i: danhSachNhanVien) {
					long luong = i.getMucLuong();
					if (luong == mucLuongCanTim) {
						danhSachNhanVienTheoMucLuong.add(i);
					}
				}
				return danhSachNhanVienTheoMucLuong;
		}
		return null;
	}
		//*** Phương thức tìm ***
			//***** Tổng hợp các phương thức tìm thành phần *****
	public ArrayList<NhanVien> danhSachCanTim() {
		int luaChon = menuTim();
		ArrayList<NhanVien> danhSachNhanVienCanTim = new ArrayList<NhanVien>();
		switch(luaChon) {
			case 0:
				return null;
			case 1:
				danhSachNhanVienCanTim = timMaSo();
				break;
			case 2:
				danhSachNhanVienCanTim = timGioiTinh();
				break;
			case 3:
				danhSachNhanVienCanTim = timTen();
				break;
			case 4:
				danhSachNhanVienCanTim = timMaPhongBan();
				break;
			case 5:
				danhSachNhanVienCanTim = timLoaiNhanVien();
				break;
			case 6:
				danhSachNhanVienCanTim = timMucLuong();
				break;
		}
		return danhSachNhanVienCanTim;
	}
	@Override public void tim() {
		ArrayList<NhanVien> danhSachTimDuoc = danhSachCanTim();
		if (danhSachTimDuoc == null) {
			System.out.println("Khong co nhan vien nao trong danh sach can tim...");
			return;
		}
		System.out.println("Danh sach cac nhan vien can tim la: ");
		for(NhanVien i: danhSachTimDuoc) {
			i.xuat();
		}
	}
	//Phương thức xóa
	@Override public void xoa() {
		ArrayList<NhanVien> danhSachNhanVienCanXoa = danhSachCanTim();
		if (danhSachNhanVienCanXoa == null) {
			System.out.println("Khong co nhan vien nao trong danh sach can tim...");
			return;
		}
		int luaChon, stt;
		while (danhSachNhanVienCanXoa.size() > 0) {
			System.out.println("Danh sach cac nhan vien can xoa: ");
			for(NhanVien i: danhSachNhanVienCanXoa) {
				System.out.println("1. ");i.xuat();
			}
			do{
				System.out.println("1. Xoa 1 nhan vien trong danh sach");
				System.out.println("2. xoa tat ca nhan vien trong danh sach");
				System.out.println("0. Thoat");
				luaChon = Integer.parseInt(scan.nextLine());
			} while(luaChon < 0 || luaChon > 2);
			if (luaChon == 1) {
				do {
					System.out.println("Nhap STT nhan vien can xoa: ");
					stt = Integer.parseInt(scan.nextLine());
				} while(stt < 0 || stt > danhSachNhanVienCanXoa.size());
				danhSachNhanVien.remove(danhSachNhanVienCanXoa.get(stt-1));
				danhSachNhanVienCanXoa.remove(stt-1);
				System.out.println("Da xoa nhan vien!!");
			} 
			if (luaChon == 2) {			
					danhSachNhanVien.removeAll(danhSachNhanVienCanXoa);
					danhSachNhanVien.clear();
					System.out.println("Da xoa cac nhan vien trong danh sach tren!!");
			}
			if (luaChon == 0) return;
		}
	}
	
	//Phương thức sửa
	@Override public void sua() {
		ArrayList<NhanVien> danhSachNhanVienCanSua = danhSachCanTim();
		if (danhSachNhanVienCanSua == null) {
			System.out.println("Khong co nhan vien nao trong danh sach can tim...");
			return;
		}
		while(danhSachNhanVienCanSua.size() > 0) {
			int stt, luaChon ;
			System.out.println("Danh sach nhan vien can sua: ");
			for(NhanVien i: danhSachNhanVienCanSua) {
				System.out.println("1. ");i.xuat();
			}
			do {
				System.out.println("1. Chon 1 nhan vien can sua");
				System.out.println("0. Thoat");
				luaChon = Integer.parseInt(scan.nextLine());
			} while(luaChon < 0 || luaChon > 1);
			if(luaChon == 0) return;
			do {
				System.out.print("Nhap STT nhan vien can sua: ");
				stt = Integer.parseInt(scan.nextLine());
			} while(stt < 0 || stt > danhSachNhanVienCanSua.size());
			int index = danhSachNhanVien.indexOf(danhSachNhanVienCanSua.get(stt-1));
			do {
				System.out.println("Chon thong tin can sua:");
				System.out.println("1. Ho Ten");
				System.out.println("2. Ngay thang nam sinh");
				System.out.println("3. Gioi tinh");
				System.out.println("4. Ma so");
				System.out.println("5. Ma phong Ban");
				if(danhSachNhanVienCanSua.get(stt-1) instanceof NhanVienThoiVu) {
					System.out.println("6. So gio lam ");
					System.out.println("7. Muc luong theo gio ");
				}
				if(danhSachNhanVienCanSua.get(stt-1) instanceof NhanVienChinhThuc) {
					System.out.println("6. So ngay lam ");
					System.out.println("7. Muc luong theo ngay ");
				}
				luaChon = Integer.parseInt(scan.nextLine());
			} while(luaChon < 1 || luaChon > 7);
			switch(luaChon) {
				case 1:
					(danhSachNhanVien.get(index)).nhapHoTen();;
					break;
				case 2:
					(danhSachNhanVien.get(index)).nhapNamSinh();
					break;
				case 3:
					(danhSachNhanVien.get(index)).nhapGioiTinh();
					break;
				case 4:
					(danhSachNhanVien.get(index)).nhapMaSo();
					break;
				case 5:
					(danhSachNhanVien.get(index)).nhapMaPhongBan();
					break;
				case 6:
					if (danhSachNhanVien.get(index) instanceof NhanVienThoiVu) {
						((NhanVienThoiVu)(danhSachNhanVien.get(index))).nhapSoGio();
					}
					if (danhSachNhanVien.get(index) instanceof NhanVienChinhThuc) {
						((NhanVienChinhThuc)(danhSachNhanVien.get(index))).nhapSoNgay();
					}
					break;
				case 7:
					if (danhSachNhanVien.get(index) instanceof NhanVienThoiVu) {
						((NhanVienThoiVu)(danhSachNhanVien.get(index))).nhapMucLuongTheoGio();;
					}
					if (danhSachNhanVien.get(index) instanceof NhanVienChinhThuc) {
						((NhanVienChinhThuc)(danhSachNhanVien.get(index))).nhapMucLuongTheoNgay();;
					}
					break;
			}
		}
	} 
}