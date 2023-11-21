import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class DanhSachNhanVien implements DanhSach<NhanVien>{
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
//doc
	public ArrayList<NhanVien> docFile(){
        ArrayList<NhanVien> kq = new ArrayList<NhanVien>();
        try {
            BufferedReader input = new BufferedReader(new FileReader("data.txt"));
            String line = input.readLine();
            while (line != null) {
            //dua du lieu vao mang
                String[] ar = line.split(",");
                NhanVien nv;
            //kiem tra thuoc loai bang luong nao
                if(ar[0].equalsIgnoreCase("1")){ //bang luong chinh thuc
            //1.String newHo, 2.String newTen, 3.String newNgaySinh, 4.int newId, 5.String newMaPhongBan
            //6.double baoHiem, 7.int soNgay, 8.double mucLuongTheoNgay, 9.double tienTangCa, 10.double thanhToan
            //String newHo, String newTen, String newNgaySinh, String newId, String newMaPhongBan, double newTienBaoHiem
                    nv = new NhanVienChinhThuc(ar[1], ar[2], ar[3], Integer.parseInt(ar[4]),
                                                                    ar[5], Double.parseDouble(ar[6]));
                }
                else{ //bang luong thoi vu
                    //6.int thoiHanLamViec, 7.int soGio, 8.double mucLuongTheoGio, 9.double thuong, 10.double thanhToan
                    nv = new NhanVienThoiVu(ar[1], ar[2], ar[3], Integer.parseInt(ar[4]),
                                                                ar[5], Integer.parseInt(ar[6]));
                }
                kq.add(nv);
                //doc dong tiep theo
                line = input.readLine();
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            }
        return kq;
    }
//ghi
public void ghiFile(ArrayList<NhanVien> dsnv){
	try {
		FileWriter fw = new FileWriter("data.txt");
		//ghi
		String s;
		for(NhanVien nv: dsnv){
			//neu la bang luong chinh thuc
			if(nv instanceof NhanVienChinhThuc){
		//1. newId, 2. newMaPhongBan, 3.newHo, 4.newTen, 5.newNgaySinh, 6.double newTienBaoHiem
				NhanVienChinhThuc nv1 = (NhanVienChinhThuc) nv;
				s = 1+","+nv1.getHo()+","+nv1.getTen()+","+nv1.getNgaySinh()+","+nv1.getID()+","+nv1.getMaPhongBan()+","+
				nv1.getTienBaoHiem()+"\n";
			}
			else{
		//1. newId, 2. newMaPhongBan, 3.newHo, 4.newTen, 5.newNgaySinh, 6.int newThoiHanLamViec
		//7.int soGio, 7.double mucLuongTheoGio, 8.double tienThuong, 9.double thanhToan
				NhanVienThoiVu nv2 = (NhanVienThoiVu) nv;
				s = 2+","+nv2.getHo()+","+nv2.getTen()+","+nv2.getNgaySinh()+","+nv2.getID()+","+nv2.getMaPhongBan()+","+
				nv2.getThoiHanLamViec()+"\n";
			}
			fw.write(s);
		}
		fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
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
	@Override public int menuTim() {
		if(danhSachNhanVien.size() == 0) {
			System.out.println("Khong co nhan vien nao trong danh sach!!!");
			return -1;
		}
		int luaChon = -1;
		System.out.println("===========================================");
		System.out.println(",1. Tim theo ma so nhan vien.");
		System.out.println(",2. Tim theo ten nhan vien.");
		System.out.println(",3. Tim theo ma phong ban nhan vien.");
		System.out.println(",4. Tim theo loai nhan vien.");
		//System.out.println(",5. Tim theo muc luong nhan vien.");
		System.out.println(",0. Huy tim kiem.");
		System.out.println("===========================================");
		do {
			System.out.println("Nhap lua chon: ");
			luaChon = Integer.parseInt(scan.nextLine());
		} while (luaChon < 0 || luaChon > 4);
		return luaChon;
	}
	//Phương thức tìm kiếm
		//*** Các phương thức tìm thành phần ***
	
			//***** Tìm theo mã số *****
	private ArrayList<NhanVien> timID() {
		int idCanTim;
		ArrayList<NhanVien> nhanVienCanTim = new ArrayList<NhanVien>();
		System.out.print("Nhap ma so nhan vien can tim: ");
		idCanTim = Integer.parseInt(scan.nextLine());
		while((String.valueOf(idCanTim)).length() != NhanVien_CONST.NUMBEROFCHAR_ID) {
			System.out.println("Ma so khong hop le!! (Ma so nhan vien phai co "+
					NhanVien_CONST.NUMBEROFCHAR_ID+" ki tu)");
			System.out.print("Nhap ma so nhan vien can tim: ");
			idCanTim = Integer.parseInt(scan.nextLine());
		}
		for(NhanVien i: danhSachNhanVien) {
			int id = i.getID();
			if(id == idCanTim) {
				nhanVienCanTim.add(i);
			}
		}
		return nhanVienCanTim;
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
	
	/*
			//***** Tìm theo mã phòng ban *****
	private ArrayList<NhanVien> timMaPhongBan() {
		int maPhongBanCanTim;
		ArrayList<NhanVien> danhSachNhanVienPhongBan = new ArrayList<NhanVien>();
		System.out.print("Nhap ma phong ban can tim: ");
		maPhongBanCanTim = Integer.parseInt(scan.nextLine());
		while((String.valueOf(maPhongBanCanTim)).length() != NhanVien_CONST.NUMBEROFCHAR_MAPHONGBAN) {
			System.out.println("Ma phong ban khong hop le (Ma phong ban phai co "+
					NhanVien_CONST.NUMBEROFCHAR_MAPHONGBAN+" ki tu");
			System.out.print("Nhap ma phong ban can tim: ");
			maPhongBanCanTim = Integer.parseInt(scan.nextLine());
		}
		for(NhanVien i: danhSachNhanVien) {
			String maPhongBan = i.getMaPhongBan();
			if(maPhongBan == maPhongBanCanTim) {
				danhSachNhanVienPhongBan.add(i);
			}
		}
		return danhSachNhanVienPhongBan;
	}
	*/
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
	/*
			//***** Tìm theo mức lương *****
	private ArrayList<NhanVien> timluongCanBan() {
		int luaChon;
		long luongCanBanCanTim;
		ArrayList<NhanVien> danhSachNhanVienTheoluongCanBan = new ArrayList<NhanVien>();
		do {
			System.out.println("Chon phan loai muc luong(1. >; 2. <; 3. =): ");
			luaChon = Integer.parseInt(scan.nextLine());
		} while(luaChon < 1 || luaChon > 3);
		do {
			System.out.println("Nhap muc luong can tim: ");
			luongCanBanCanTim = Long.parseLong(scan.nextLine());
		} while(luongCanBanCanTim < 0);
		switch(luaChon) {
			case 1:
				for(NhanVien i: danhSachNhanVien) {
					long luong = i.getluongCanBan();
					if (luong > luongCanBanCanTim) {
						danhSachNhanVienTheoluongCanBan.add(i);
					}
				}
				return danhSachNhanVienTheoluongCanBan;
			case 2:
				for(NhanVien i: danhSachNhanVien) {
					long luong = i.getluongCanBan();
					if (luong < luongCanBanCanTim) {
						danhSachNhanVienTheoluongCanBan.add(i);
					}
				}
				return danhSachNhanVienTheoluongCanBan;
			case 3:
				for(NhanVien i: danhSachNhanVien) {
					long luong = i.getluongCanBan();
					if (luong == luongCanBanCanTim) {
						danhSachNhanVienTheoluongCanBan.add(i);
					}
				}
				return danhSachNhanVienTheoluongCanBan;
		}
		return null;
	}
	*/
		//*** Phương thức tìm ***
			//***** Tổng hợp các phương thức tìm thành phần *****
	
	public ArrayList<NhanVien> danhSachCanTim() {
		int luaChon = menuTim();
		ArrayList<NhanVien> danhSachNhanVienCanTim = new ArrayList<NhanVien>();
		switch(luaChon) {
			case 0:
				return null;
			case 1:
				danhSachNhanVienCanTim = timID();
				break;
			case 2:
				danhSachNhanVienCanTim = timTen();
				break;
			/*case 3:
				danhSachNhanVienCanTim = timMaPhongBan();
				break;*/
			case 4:
				danhSachNhanVienCanTim = timLoaiNhanVien();
				break;
			/*case 5:
				danhSachNhanVienCanTim = timluongCanBan();
				break;*/
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
				int count = 1;
				System.out.println(count+". ");i.xuat();
				count++;
			}
			System.out.println("1. Xoa 1 nhan vien trong danh sach");
			System.out.println("2. xoa tat ca nhan vien trong danh sach");
			System.out.println("0. Thoat");
			do {
				System.out.print("Nhap lua chon: ");
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
				int count = 1;
				System.out.println(count+". ");i.xuat();
				count++;
			}
			System.out.println("1. Chon 1 nhan vien can sua");
			System.out.println("0. Thoat");
			do {
				System.out.print("Nhap lua chon: ");
				luaChon = Integer.parseInt(scan.nextLine());
			} while(luaChon < 0 || luaChon > 1);
			if(luaChon == 0) return;
			do {
				System.out.print("Nhap STT nhan vien can sua: ");
				stt = Integer.parseInt(scan.nextLine());
			} while(stt < 0 || stt > danhSachNhanVienCanSua.size());
			int index = danhSachNhanVien.indexOf(danhSachNhanVienCanSua.get(stt-1));
			System.out.println("Chon thong tin can sua:");
			System.out.println("1. Ho Ten");
			System.out.println("2. Ngay sinh");
			System.out.println("3. Ma phong Ban");
			if(danhSachNhanVienCanSua.get(stt-1) instanceof NhanVienThoiVu) {
				System.out.println("4. Tien bao hiem");
			}
			if(danhSachNhanVienCanSua.get(stt-1) instanceof NhanVienChinhThuc) {
				System.out.println("4. Thoi han lam viec");
			}
			do {
				System.out.print("Nhap lua chon: ");
				luaChon = Integer.parseInt(scan.nextLine());
			} while(luaChon < 1 || luaChon > 4);
			switch(luaChon) {
				case 1:
					(danhSachNhanVien.get(index)).nhapHoTen();;
					break;
				case 2:
					(danhSachNhanVien.get(index)).nhapNgaySinh();
					break;
				case 3:
					(danhSachNhanVien.get(index)).nhapMaPhongBan();
					break;
				case 4:
					if (danhSachNhanVien.get(index) instanceof NhanVienThoiVu) {
						((NhanVienThoiVu)(danhSachNhanVien.get(index))).nhapThoiHanLamViec();
					}
					if (danhSachNhanVien.get(index) instanceof NhanVienChinhThuc) {
						((NhanVienChinhThuc)(danhSachNhanVien.get(index))).nhapTienBaoHiem();
					}
					break;
			}
		}
	} 
	
	//Đọc, ghi file
	
		//*** Đọc file ***
	public void DocFile() {
		/*
		try {
			//Scanner scan = new Scanner(inputFile);
			while(scan.hasNextLine()) {
				NhanVien newNV = new NhanVien();
				String temp = scan.nextLine();
				String arr[] = temp.split(",");
				if(arr[0].intern() == "1") {
					newNV = (NhanVienThoiVu)newNV;
				} else {
					newNV = (NhanVienChinhThuc)newNV;
				};
				newNV.setHoTen(arr[1]);
				newNV.setNgaySinh(arr[2]);
				//newNV.setMaPhongBan(Integer.parseInt(arr[3]));
				if(newNV instanceof NhanVienThoiVu) {
					((NhanVienThoiVu)newNV).setThoiHanLamViec(Integer.parseInt(arr[4]));
				}
				if(newNV instanceof NhanVienChinhThuc) {
					((NhanVienChinhThuc)newNV).setTienBaoHiem(Double.parseDouble(arr[4]));
				}
			}
			scan.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
		System.out.println("hello");
	}
	
		//*** Ghi file ***
	public void GhiFile() {
		//try {
			//FileWriter fw = new FileWriter(outputFile,true);
			/*
			for(NhanVien i: danhSachNhanVien) {
				if (i instanceof NhanVienThoiVu) {
					fw.write("1,");
				}
				if (i instanceof NhanVienChinhThuc) {
					fw.write("2,");
				}
				String ho, ten, ngaySinh;
				int maPhongBan;
				ho = i.getHo();
				ten = i.getTen();
				ngaySinh = (i.getNgaySinh()).toString();
				maPhongBan = i.getMaPhongBan();
				fw.write(ho+" "+ten+","+ngaySinh+","+maPhongBan+",");
				if (i instanceof NhanVienThoiVu) {
					int temp = ((NhanVienThoiVu)i).getThoiHanLamViec();
					String thoiHanLamViec = String.valueOf(temp);
					fw.write(thoiHanLamViec);
				}
				if (i instanceof NhanVienChinhThuc) {
					double temp = ((NhanVienChinhThuc)i).getTienBaoHiem();
					String tienBaoHiem = String.valueOf(temp);
					fw.write(tienBaoHiem);
				}
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		System.out.println("hello");
	}
}