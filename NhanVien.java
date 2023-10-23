import java.util.Scanner; 

public class NhanVien extends ThongTinCaNhan{
	private Scanner scan = new Scanner(System.in);
	
	//Các thuộc tính
	private String maSo;
	private String maPhongBan;
	private String maDeAn;
	private long luong;
	
	//Các hàm get và set của class
	//*** Các hàm get ***
	public String getMaSo() {
		return maSo;
	}
	public String getMaPhongBan() {
		return maPhongBan;
	}
	public String getMaDeAn() {
		return maDeAn;
	}
	public long getLuong() {
		return luong;
	}
	
	//*** Các hàm set ***
	public void setMaSo(String newMaSo) {
		maSo = newMaSo;
	}
	public void setMaPhongBan(String newMaPhongBan) {
		maPhongBan = newMaPhongBan;
	}
	public void setMaDeAn(String newMaDeAn) {
		maDeAn = newMaDeAn;
	}
	public void setLuong(long newLuong) {
		luong = newLuong;
	}
	
	//Các hàm kiểm tra điều kiện
	
	//*** Kiểm tra điều kiện của maSo ***
	private boolean maSoKhongHopLe(String newMaSo) {
		if(newMaSo.length() != 8) return true;
		return false;
	}
	
	//*** Kiểm tra điều kiện của maPhongBan ***
	private boolean maPhongBanKhongHopLe(String newMaPhongBan) {
		if(newMaPhongBan.length() != 5) return true;
		return false;
	}
	
	//*** Kiểm tra điều kiện của maDeAn
	private boolean maDeAnKhongHopLe(String newMaDeAn) {
		if(newMaDeAn.length() != 5) return true;
		return false;
	}
	
	//*** Kiểm tra điều kiện của luong ***
	private boolean luongKhongHopLe(long newLuong) {
		if(newLuong < 0) return true; 
		return false;
	}
	
	
	//Các constructor của class
	
	//*** Constructor không tham số ***
	public NhanVien() {
		super();
		maSo = "";
		maPhongBan = "";
		maDeAn = "";
		luong = 0;
	}
	
	//*** Constructor có tham số ***
	public NhanVien(String newHoTen, int newNgaySinh, int newThangSinh, int newNamSinh, 
			String newGioiTinh, String newMaSo, String newMaPhongBan, String newMaDeAn, 
			long newLuong) {
		super(newHoTen, newNgaySinh, newThangSinh, newNamSinh, newGioiTinh);
		maSo = newMaSo;
		maPhongBan = newMaPhongBan;
		maDeAn = newMaDeAn;
		luong = newLuong;
		if(maSoKhongHopLe(maSo)) maSo = "";
		if(maPhongBanKhongHopLe(maPhongBan)) maPhongBan = "";
		if(maDeAnKhongHopLe(maDeAn)) maDeAn = "";
		if(luongKhongHopLe(luong)) luong = 0;
	}
	
	
	//Các hàm nhập xuất của class
	
	//*** Hàm nhập
	
	//***** Các hàm nhập thành phần *****
	private void NhapMaSo() {
		String newMaSo;
		do {
			System.out.print("Nhap ma so (8 ki tu): ");
			newMaSo = scan.nextLine();
		} while(maSoKhongHopLe(newMaSo));
		maSo = newMaSo;
	}
	private void NhapMaPhongBan() {
		String newMaPhongBan;
		do {
			System.out.print("Nhap ma phong ban (5 ki tu): ");
			newMaPhongBan = scan.nextLine();
		} while(maPhongBanKhongHopLe(newMaPhongBan));
		maPhongBan = newMaPhongBan;
	}
	private void NhapMaDeAn() {
		String newMaDeAn;
		do {
			System.out.print("Nhap ma de an (5 ki tu): ");
			newMaDeAn = scan.nextLine();
		} while(maDeAnKhongHopLe(newMaDeAn));
		maDeAn = newMaDeAn;
	}
	private void NhapLuong() {
		long newLuong;
		do {
			System.out.print("Nhap luong: ");
			newLuong = Long.parseLong(scan.nextLine());
		} while(luongKhongHopLe(newLuong));
		luong = newLuong;
	}
	
	//***** Hàm nhập tổng hợp *****
	public void Nhap() {
		super.Nhap();
		NhapMaSo();
		NhapMaPhongBan();
		NhapMaDeAn();
		NhapLuong();
	}
	
	//*** Hàm xuất
	
	//***** Các hàm xuất thành phần *****
	private void XuatMaSo() {
		System.out.println("Ma so: "+maSo);
	}
	private void XuatMaPhongBan() {
		System.out.println("Ma phong ban: "+maPhongBan);
	}
	private void XuatMaDeAn() {
		System.out.println("Ma de an: "+maDeAn);
	}
	private void XuatLuong() {
		System.out.println("Luong: "+luong);
	}
	
	//***** Hàm xuất tổng hợp *****
	public void Xuat() {
		super.Xuat();
		XuatMaSo();
		XuatMaPhongBan();
		XuatMaDeAn();
		XuatLuong();
	}
}
