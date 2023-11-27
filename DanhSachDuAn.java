import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class DanhSachDuAn implements DanhSach{
	public Scanner sc = new Scanner(System.in);
	
//field
	private ArrayList<DuAn> ds;
	
//constructor
	public DanhSachDuAn() {
		ds = new ArrayList<DuAn>();
	}

	public DanhSachDuAn(ArrayList<DuAn> ds) {
		this.ds = ds;
	}

//doc file
public void docFile() {
	try {
		BufferedReader input = new BufferedReader(new FileReader("duan.txt"));
		String line = input.readLine();
		DuAn da= new DuAn(); 
		while(line!=null) {
			String[] ar = line.split(","); // chia chuỗi thành các chuỗi con phân cách bởi dấu ,
			// vi tri 0 danh dau =1 la du an nhan vien chinh thuc
			if(ar[0].equalsIgnoreCase("1")) {  
				// 1.int maduan, 2.String tenduan, 3.double loi nhuan, 4.double ngan sach, 5.int newID, 6.String newHo, 7.String newTen, 8.String newNgaySinh, 9.int newMaPhongBan, 10.double newTienBaoHiem
				NhanVienChinhThuc nv = new NhanVienChinhThuc(Integer.parseInt(ar[5]), ar[6], ar[7], ar[8], Integer.parseInt(ar[9]), Double.parseDouble(ar[10]));
				//String maDuAn,String tenDuAn, int loiNhuan, int nganSach, NhanVien nv
				da = new DuAnCaNhan(Integer.parseInt(ar[1]), ar[2], Double.parseDouble(ar[3]), Double.parseDouble(ar[4]), nv);
			}
			 // vi tri 0 danh dau =2 la du an nhan vien thoi vu
			if(ar[0].equalsIgnoreCase("2")) {
				//1.int maduan, 2.String tenduan, 3.double loi nhuan, 4.double ngan sach, 5.int newID, 6.String newHo, 7.String newTen, 8.String newNgaySinh, 9.int newMaPhongBan, 10.thoiHanLamViec
				NhanVienThoiVu nv = new NhanVienThoiVu(Integer.parseInt(ar[5]), ar[6], ar[7], ar[8], Integer.parseInt(ar[9]), Integer.parseInt(ar[10]));
				//String maDuAn,String tenDuAn, int loiNhuan, int nganSach, NhanVien nv
				da = new DuAnCaNhan(Integer.parseInt(ar[1]), ar[2], Double.parseDouble(ar[3]), Double.parseDouble(ar[4]), nv);
			}
			// vi tri 0 danh dau =3 la du an phong ban
			if(ar[0].equalsIgnoreCase("3")) 
		//1.int maduan, 2.String tenduan, 3.double loi nhuan, 4.double ngan sach,5. mapb, 6.tenpb
				da = new DuAnPhongBan(Integer.parseInt(ar[1]), ar[2], Double.parseDouble(ar[3]), Double.parseDouble(ar[4]), Integer.parseInt(ar[5]), ar[6]);
			ds.add(da);
			line=input.readLine();
			}
			input.close();
			DuAn.init(da.getMaDuAn());
		}
		catch (Exception ex) { // mở file bị lỗi sẽ dô catch
			ex.printStackTrace();
		}	
	
	}
//ghi file
		public void ghiFile() {
				try {
					FileWriter f = new FileWriter("duan.txt");
					String s = new String();
					for(DuAn da : ds) {
						if(da instanceof DuAnCaNhan) {   
							 // du an ca nhan - nhan vien chinh thuc 
							DuAnCaNhan da1 = (DuAnCaNhan) da;
							if(da1.getNhanVien() instanceof NhanVienChinhThuc){
								NhanVienChinhThuc nv1 = (NhanVienChinhThuc) da1.getNhanVien();
								// 1.int maduan, 2.String tenduan, 3.double loi nhuan, 4.double ngan sach, 5.int newID, 6.String newHo, 7.String newTen, 8.String newNgaySinh, 9.int newMaPhongBan, 10.double newTienBaoHiem
								s = 1+","+da1.getMaDuAn()+","+da1.getTenDuAn()+","+da1.getLoiNhuan()+","+da1.getNganSach()+","+nv1.getID()+","+nv1.getHo()+","+nv1.getTen()+","+nv1.getNgaySinh()+","+nv1.getMaPhongBan()+","+nv1.getTienBaoHiem()+"\n";
							}
							else{
								// du an ca nhan - nhan vien thoi vu
								// 1.int maduan, 2.String tenduan, 3.double loi nhuan, 4.double ngan sach, 5.int newID, 6.String newHo, 7.String newTen, 8.String newNgaySinh, 9.int newMaPhongBan, 10.int thoiHanLamViec
								DuAnCaNhan da2 = (DuAnCaNhan) da;
								NhanVienThoiVu nv2 = (NhanVienThoiVu) da2.getNhanVien();
								s = 2+","+da2.getMaDuAn()+","+da2.getTenDuAn()+","+da2.getLoiNhuan()+","+da2.getNganSach()+","+nv2.getID()+","+nv2.getHo()+","+nv2.getTen()+","+nv2.getNgaySinh()+","+nv2.getMaPhongBan()+","+nv2.getThoiHanLamViec()+"\n";
							}
						}
						if(da instanceof DuAnPhongBan) {
							// du an phong ban
							//1.int maduan, 2.String tenduan, 3.double loi nhuan, 4.double ngan sach,5. mapb, 6.tenpb
							DuAnPhongBan da3 = (DuAnPhongBan) da;
							s = 3 +da3.getMaDuAn()+","+da3.getTenDuAn()+","+da3.getLoiNhuan()+","+da3.getNganSach()+","+da3.getMaPb()+","+da3.getTenPb()+"\n";
						}
						f.write(s);
					}
					f.close();
				}catch (Exception e) {
					System.out.println(e);
				}
		}

	// MENU
	public void menu(DanhSachNhanVien dsnv) {
		int luachon;  // bien trong dk vong lap phai khai bao ngoai do while
		do {
			System.out.println("=====================================================");
			System.out.println("--- MENU DANH SACH DU AN ---");
			System.out.println("|1. Them");
			System.out.println("|2. Tim kiem");
			System.out.println("|3. Xoa");
			System.out.println("|4. Sua");
			System.out.println("|5. Xuat");
			System.out.println("Nhap so khac de thoat !!!"); 
			System.out.println("=====================================================");
			System.out.print("Nhap lua chon: ");
        	luachon=Integer.parseInt(sc.nextLine());
			switch(luachon) {
				case 1:
					them(dsnv);  // người dùng nhập 1 sẽ gọi hàm thêm
					break;
				case 2:
					tim();
					break;
				case 3:
					xoa();
					break;
				case 4:
					sua();
					break;
				case 5:
					xuat();
					break;
				default:  // nhập số khác sẽ dô default xuất ra dòng thóat danh sách....
					System.out.println("Thoat danh sach du an");
					break;
			}	
		}
		while(luachon>=1 && luachon<=5);
	}
	
	//xuat
	public void xuat() {
		if(ds.size()==0) {
			System.out.println("Danh sach rong !");
		}
		else {
			System.out.println("=====================================================");
			System.out.println("Xuat danh sach du an: ");
			for(DuAn a : ds) {
				a.xuat();   // tinh da hinh
				System.out.println("=====================================================");
			}
		}
	}

	//them
	public void them(DanhSachNhanVien dsnv) { //dspb
		int luachon;
		do {
			System.out.println("Nhap loai du an muon them: ");
			System.out.println("1. Du an ca nhan ");
			System.out.println("2. Du an phong ban ");
			System.out.print("Nhap lua chon: ");
			luachon = Integer.parseInt(sc.nextLine());
		}
		while(luachon!=1 && luachon!=2); // khi lua chon khac 1 va 2 thi lam lai
		int stt;
		if(luachon==1) {
			DuAnCaNhan a = new DuAnCaNhan();
			ArrayList<NhanVien> dsNhanVien = dsnv.getDanhSachNhanVien();
			int i=0;
			System.out.println("=====================================================");
			for(NhanVien nv : dsNhanVien){
				System.out.println("STT: "+i);
				nv.xuat();
				System.out.println("=====================================================");
				i++;
			}
			do{
			System.out.print("Chon so thu tu cua nhan vien: ");
			stt=Integer.parseInt(sc.nextLine());
			if(stt<0 || stt>=dsNhanVien.size())
				System.out.println("Nhap sai so thu tu !");
			} while(stt<0 || stt>=dsNhanVien.size());
			a.nhap(dsNhanVien.get(stt));
			ds.add(a);
		}/*
		else {
			DuAnPhongBan a = new DuAnPhongBan();
			ArrayList<PhongBan> dsPhongBan = dsnv.getDanhSachPhongBan();
			int i=0;
			System.out.println("=====================================================");
			for(PhongBan pb : dsPhongBan){
				System.out.println("STT: "+i);
				pb.xuat();
				System.out.println("=====================================================");
			}
			do{
				System.out.print("Chon so thu tu cua phong ban: ");
				stt=Integer.parseInt(sc.nextLine());
				if(stt<0 || stt>=dsPhongBan. size())
					System.out.println("Nhap sai so thu tu !");
				} while(stt<0 || stt>=dsPhongBan.size());
			PhongBan pb = dsPhongBan.get(stt);
			a.nhap(pb.getMaPb(), pb.getTenPb());
			ds.add(a);
		}
		*/
	}
	// MENU Tim Kiem
	public int menuTim() {
		int luachon;
		if(ds.size()==0){
			System.out.println("Danh sach rong !");
			luachon = -1;
		}
		else {
			System.out.println("=====================================================");
			System.out.println("--- MENU TIM KIEM ---");
			System.out.println("|1. Tim kiem theo ten du an");
			System.out.println("|2. Tim kiem theo ten phong ban");
			System.out.println("|3. Tim kiem theo ten nhan vien");
			System.out.println("|4. Tim kiem theo loi nhuan");	
			System.out.println("=====================================================");
			luachon = Integer.parseInt(sc.nextLine());
		}
		return luachon;
	}
	
	// Tim theo ten du an
	public ArrayList<DuAn> timTenDuAn() { 
		ArrayList<DuAn> kq = new ArrayList<DuAn>();
		System.out.print("Nhap ten du an can tim: ");
		String tenCanTim = sc.nextLine();
		String ten;
		for(DuAn a : ds) {
			ten = a.getTenDuAn();
			if(ten.equalsIgnoreCase(tenCanTim)) {  
				kq.add(a);
			}
		}
		return kq;
	}
	
	// Tim theo ten phong ban
	
	public ArrayList<DuAn> timTenPhongBan() {
		ArrayList <DuAn> kq = new ArrayList<DuAn>();
		System.out.print("Nhap ten phong ban can tim: ");
		String tenCanTim = sc.nextLine();
		DuAnPhongBan da;
		for(DuAn a : ds) {  // Duan : kieu du lieu, a: bien
			if( a instanceof DuAnPhongBan) { // kt xem co phai thuoc du an phong ban ko
				da = (DuAnPhongBan) a;
				if(da.getTenPb().equalsIgnoreCase(tenCanTim)) {
					kq.add(a);
				}
			}
		}
		return kq;
	}
	
	// Tim theo ten nhan vien
	public ArrayList<DuAn> timTenNhanVien(){
		ArrayList<DuAn> kq = new ArrayList<DuAn>();
		System.out.print("Nhap ten nhan vien can tim: ");
		String tenCanTim = sc.nextLine();
		DuAnCaNhan da;
		for(DuAn a : ds) {
			if(a instanceof DuAnCaNhan) {
				da = (DuAnCaNhan) a;   // ép kiểu
				String ten = da.getNhanVien().getTen();
				if(ten.equalsIgnoreCase(tenCanTim)) {
					kq.add(da);
				}
			}
		}
		return kq;
	}
		
	
	//Tim theo loi nhuan
	public ArrayList<DuAn> timLoiNhuan(){
		ArrayList<DuAn> kq = new ArrayList<DuAn>();
		System.out.print("Nhap loi nhuan can tim: ");
		double loiNhuanCanTim = Double.parseDouble(sc.nextLine());
		for(DuAn a : ds) 
			if(a.getLoiNhuan() == loiNhuanCanTim) 
				kq.add(a);
		return kq;
	}
	
	//Tim kiem
	public ArrayList<DuAn> ketQuaTimKiem(){
		int luachon = menuTim();
		ArrayList<DuAn> kq = new ArrayList<DuAn>();
		switch(luachon) {
		case 1:
			kq = timTenDuAn();
			break;
		case 2:
			kq = timTenPhongBan();
			break;
		case 3:
			kq = timTenNhanVien();
			break;
		case 4:
			kq = timLoiNhuan();
			break;
		}
		return kq;
	}

	@Override public void tim() { // void : khong tra ve
		ArrayList<DuAn> kq = ketQuaTimKiem();
		if(kq.size()==0) {
			System.out.println("Khong tim thay");
		}
		else {
			System.out.println("Ket qua tim kiem: ");
			for(DuAn a : kq) {
				a.xuat();  // Tính đa hình
			}
		}
	}
	
	// Xoa
	public void xoa() {
		ArrayList<DuAn> kq = ketQuaTimKiem();
		if(kq.size()==0) {
			System.out.println("Khong tim thay");
		}
		else {
			System.out.println("Ket qua tim kiem: ");
			for(DuAn a : kq) {
				a.xuat();  // Tính đa hình
				ds.remove(a); // xóa đối tượng a khỏi anh sách, remove: xóa
			}
		}
	}
		
	
	// Sua
	public void sua() {
		ArrayList<DuAn> kq = ketQuaTimKiem();
		if(kq.size()==0) {
			System.out.println("Khong tim thay");
		}
		else {
			int i=0;
			System.out.println("Ket qua tim kiem: ");
			for(DuAn a : kq) {
				System.out.println(i++);
				a.xuat();  // Tính đa hình	
			}
		}
		//sua
		int stt, luachon;
		do {
			 stt = Integer.parseInt(sc.nextLine());
		}
		while (stt<0 || stt>=kq.size());
		DuAn da = kq.get(stt);  // kq là mảng.get(stt) là lấy chỉ số stt, giống a[0]
		do {
			System.out.println("=====================================================");
			System.out.println("--- MENU SUA ---");
			System.out.println("|1. Sua ten du an ");
			System.out.println("|2. Sua loi nhuan ");
			System.out.println("|3. Sua ngan sach ");
			System.out.println("Nhap so khac de thoat !!!");
			System.out.println("=====================================================");
			System.out.print("Nhap lua chon : ");
			luachon = Integer.parseInt(sc.nextLine());
			switch(luachon) {
			case 1:
				System.out.print("Sua ten du an");
				String tenDuAn = sc.nextLine();
				da.setTenDuAn(tenDuAn);
			case 2:
				System.out.print("Sua loi nhuan");
				Double loiNhuan = Double.parseDouble(sc.nextLine());
				da.setLoiNhuan(loiNhuan);
			case 3:
				System.out.print("Sua ngan sach");
				Double nganSach = Double.parseDouble(sc.nextLine());
				da.setNganSach(nganSach);
			}
			System.out.println("Hien thi sau khi sua: ");
			da.xuat(); // pt xuat ben class du an
			if(luachon<1 || luachon>3)
				System.out.println("--- Thoat ---");
		}
		while(luachon>=1 && luachon<=3);
	}
//ham cap nhat
	/*
	dsDuAn.xoaNhanVien(idCanXoa, idPBCanXoa):
		duyet mang du an:
			+ neu la duancannhan thi ktra idnv = idcanxoa -> remove
			+ neu la duanphongban thi ktra idpb = idpbcanxoa: //idpb=0 thi bo qua
				duyet qua nhan vien = idcanxoa ->remove + cap nhat so luong nhan vien
				*/
			
	public void xoaNhanVien(int idCanXoa){
		DuAnCaNhan da;
		for(DuAn a : ds)
			if(a instanceof DuAnCaNhan){
				da = (DuAnCaNhan) a;
				if(da.getNhanVien().getID() == idCanXoa)
					ds.remove(da);
			}
	}
	
	/*
	dsDuAn.suaNhanVien(nvSauKhiSua);
		duyet mang du an:
			+ neu la duancannhan , ktra maid cua nhanvien == maIDCanSua -> da.setNhanVien(nvSauKhiSua)
			+ neu la duanphongban thi ktra idpb = idpbcanxoa: //idpb=0 thi bo qua
				duyet qua nhan vien = idcansua -> set*/

	public void suaNhanVien(NhanVien nv){
		DuAnCaNhan da;
		for(DuAn a : ds)
			if(a instanceof DuAnCaNhan){
				da = (DuAnCaNhan) a;
				if(da.getNhanVien().getID() == nv.getID())
					da.setNhanVien(nv);
			}
	}
/*
	public void xoaIDPB(int idCanXoa){
		DuAnPhongBan da1;
		DuAnCaNhan da2;
		for(DuAn a: ds)
			if(a instanceof DuAnPhongBan){
				da1 = (DuAnPhongBan) a;
				if(da1.getMaPb() == idCanXoa)
					ds.remove(da1);
			}
			else{
				da2 = (DuAnCaNhan) a;
				if(da2.getNhanVien().getMaPhongBan() == idCanXoa)
					ds.remove(da2);
			}
	}
	*/
/*
	public void suaPb(PhongBan pb){
		DuAnPhongBan da1;
		for(DuAn a: ds)
			if(a instanceof DuAnPhongBan){
				da1 = (DuAnPhongBan) a;
				if(da1.getMaPb() == pb.getMaPb()){
					da1.setMaPb(pb.getMaPb());
					da1.setTenPb(pb.getTenPb());
				}
			}
	}*/
}
