import java.util.Scanner; 

public abstract class NhanVien {
	public Scanner scan = new Scanner(System.in);
	
	//Các thuộc tính
	private String ho, ten;
	private int ngaySinh, thangSinh, namSinh;
	private String gioiTinh; 
	private String maSo;
	private String maPhongBan;
	private long mucLuong;
	
	//Các hàm get và set của class
		//*** Các hàm get ***
	public String getHo() {
		return ho;
	}
	public String getTen() {
		return ten;
	}
	public int getNgaySinh() {
		return ngaySinh;
	}
	public int getThangSinh() {
		return thangSinh;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public String getMaSo() {
		return maSo;
	}
	public String getMaPhongBan() {
		return maPhongBan;
	}
	public long getMucLuong() {
		return mucLuong;
	}
	
		//*** Các hàm set ***
	public void setHo(String newHo) {
		ho = newHo;
	}
	public void setTen(String newTen) {
		ten = newTen;
	}
	public void setHoTen(String newHoTen) {
		newHoTen = newHoTen.trim();
		String[] temp = newHoTen.split(" ");
		ten = temp[temp.length-1];
		for(int i=0;i<temp.length - 1;i++) {
			ho = ho + temp[i] + " ";
		}
		ho = ho.trim();
	}
	public void setNgaySinh(int newNgaySinh) {
		ngaySinh = newNgaySinh;
	}
	public void setThangSinh(int newThangSinh) {
		thangSinh = newThangSinh;
	}
	public void setNamSinh(int newNamSinh) {
		namSinh = newNamSinh;
	}
	public void setGioiTinh(String newGioiTinh) {
		gioiTinh = newGioiTinh;
	}
	public void setMaSo(String newMaSo) {
		maSo = newMaSo;
	}
	public void setMaPhongBan(String newMaPhongBan) {
		maPhongBan = newMaPhongBan;
	}
	public void setMucLuong(long newmucLuong) {
		mucLuong = newmucLuong;
	}
	
	//Các hàm kiểm tra điều kiện
	
		//*** Kiểm tra điều kiện của ngày tháng năm sinh ***
	private boolean namNhuan(int namDuocKiemTra) {
		if (namDuocKiemTra %100 == 0) {
			if(namDuocKiemTra %400 == 0) return true;
				else return false;
		}
		if (namDuocKiemTra %4 == 0) return true;
			return false;
	}
	private boolean thangKhongHopLe(int newThang) {
		if(newThang > 12 || newThang < 1) return true;	
			return false;
	}
	private boolean ngayKhongHopLe(int newNgay) {
		int maxNgay = 31;
		if (thangSinh == 2) {
			if (namNhuan(namSinh)) maxNgay = 29; 
			else maxNgay = 28;
		}
		if (thangSinh == 4 || thangSinh == 6 || thangSinh == 9 || thangSinh == 11) maxNgay = 30;
		if (newNgay > maxNgay || newNgay < 1) return true;
		return false;
	}
	private boolean namKhongHopLe(int newNam) {
		int chuSo = 0;
		while (newNam>0) {
			newNam /=10;
			chuSo++;
		}
		if(chuSo != 4) return true;
		return false;
	}
		
		//*** Kiểm tra điều kiện của giới tính ***
	private boolean gioiTinhKhongHopLe(String newGioiTinh) {
		String gioiTinhDuocKiemTra = newGioiTinh.toLowerCase().intern();
		if(gioiTinhDuocKiemTra == NhanVien_CONST.GIOITINH_NAM) return false;
		if(gioiTinhDuocKiemTra == NhanVien_CONST.GIOITINH_NU) return false;
		return true;
	}
	
		//*** Kiểm tra điều kiện của maSo ***
	private boolean maSoKhongHopLe(String newMaSo) {
		if(newMaSo.length() != NhanVien_CONST.NUMBEROFCHAR_MASO) return true;
		return false;
	}
	
		//*** Kiểm tra điều kiện của maPhongBan ***
	private boolean maPhongBanKhongHopLe(String newMaPhongBan) {
		if(newMaPhongBan.length() != NhanVien_CONST.NUMBEROFCHAR_MAPHONGBAN) return true;
		return false;
	}
	
	
	//Các constructor của class
	
		//*** Constructor không tham số ***
	public NhanVien() {
		ho = "";
		ten = "";
		ngaySinh = 0;
		thangSinh = 0;
		namSinh = 0;
		gioiTinh = "";
		maSo = "";
		maPhongBan = "";
	}
	
		//*** Constructor có tham số ***
	public NhanVien(String newHo, String newTen, int newNgaySinh, int newThangSinh, int newNamSinh, 
			String newGioiTinh, String newMaSo, String newMaPhongBan) {
		ho = newHo;
		ten = newTen;
		ngaySinh = newNgaySinh;
		thangSinh = newThangSinh;
		namSinh = newNamSinh;
		gioiTinh = newGioiTinh.toLowerCase();
		if(ngayKhongHopLe(ngaySinh) || thangKhongHopLe(thangSinh) || namKhongHopLe(namSinh)) {
			ngaySinh = 0;
			thangSinh = 0;
			namSinh = 0;
		}
		if(gioiTinhKhongHopLe(gioiTinh)) gioiTinh = "";
		maSo = newMaSo;
		maPhongBan = newMaPhongBan;
		if(maSoKhongHopLe(maSo)) maSo = "";
		if(maPhongBanKhongHopLe(maPhongBan)) maPhongBan = "";
	}
	
	//Các hàm trừu tượng
	abstract public void tinhLuong();
	
	//Các hàm nhập xuất của class
	
		//*** Hàm nhập
	
			//***** Các hàm nhập thành phần *****
	public void nhapHoTen() {
		String newHoTen;
		System.out.print("Nhap ho va ten: ");
		newHoTen = scan.nextLine();
		setHoTen(newHoTen);
	}
	public void nhapNamSinh() {
		int newNamSinh;
		do {
			System.out.print("Nhap nam sinh: ");
			newNamSinh = Integer.parseInt(scan.nextLine());
		} while(namKhongHopLe(newNamSinh));
		namSinh = newNamSinh;
	}
	public void nhapThangSinh() {
		int newThangSinh;
		do {
			System.out.print("Nhap thang sinh: ");
			newThangSinh = Integer.parseInt(scan.nextLine());
		} while(thangKhongHopLe(newThangSinh));
		thangSinh = newThangSinh;
	}
	public void nhapNgaySinh() {
		int newNgaySinh;
		do {
			System.out.print("Nhap ngay sinh: ");
			newNgaySinh = Integer.parseInt(scan.nextLine());
		} while(ngayKhongHopLe(newNgaySinh));
		ngaySinh = newNgaySinh;
	}
	public void nhapGioiTinh() {
		String newGioiTinh;
		do {
			System.out.print("Gioi tinh (Nam hay nu?): ");
			newGioiTinh = (scan.nextLine()).toLowerCase().intern();
		} while(gioiTinhKhongHopLe(newGioiTinh));
		gioiTinh = newGioiTinh;
	}
	public void nhapMaSo() {
		String newMaSo;
		do {
			System.out.print("Nhap ma so (8 ki tu): ");
			newMaSo = scan.nextLine();
		} while(maSoKhongHopLe(newMaSo));
		maSo = newMaSo;
	}
	public void nhapMaPhongBan() {
		String newMaPhongBan;
		do {
			System.out.print("Nhap ma phong ban (5 ki tu): ");
			newMaPhongBan = scan.nextLine();
		} while(maPhongBanKhongHopLe(newMaPhongBan));
		maPhongBan = newMaPhongBan;
	}
	
			//***** Hàm nhập tổng hợp *****
	public void nhap() {
		nhapHoTen();
		nhapNamSinh();
		nhapThangSinh();
		nhapNgaySinh();
		nhapGioiTinh();
		nhapMaSo();
		nhapMaPhongBan();
	}
	
		//*** Hàm xuất
	
			//***** Các hàm xuất thành phần *****
	private void xuatHoTen() {
		System.out.println("Ho va ten: "+ho+" "+ten);
	}
	private void xuatNgayThangNamSinh() {
		System.out.println("Ngay thang nam sinh: "+ngaySinh+" - "+thangSinh+" - "+namSinh);
	}
	private void xuatGioiTinh() {
		System.out.println("Gioi tinh: "+gioiTinh);
	}
	private void xuatMaSo() {
		System.out.println("Ma so: "+maSo);
	}
	private void xuatMaPhongBan() {
		System.out.println("Ma phong ban: "+maPhongBan);
	}
	private void xuatMucLuong() {
		System.out.println("Muc Luong: "+mucLuong);
	}
	
			//***** Hàm xuất tổng hợp *****
	public void xuat() {
		xuatHoTen();
		xuatNgayThangNamSinh();
		xuatGioiTinh();
		xuatMaSo();
		xuatMaPhongBan();
		xuatMucLuong();
	}
}
