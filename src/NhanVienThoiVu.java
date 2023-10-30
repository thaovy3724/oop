
public class NhanVienThoiVu extends NhanVien {
	//Các thuộc tính mới
	private int soGio;
	private int mucLuongTheoGio;
	
	//Các hàm get và set mới
		//*** Các hàm get ***
	public int getSoGio() {
		return soGio;
	}
	public long getMucLuongTheoGio() {
		return mucLuongTheoGio;
	}
	
		//*** Các hàm set ***
	public void setSoGio(int newSoGio) {
		soGio = newSoGio;
		tinhLuong();
	}
	public void setMucLuongTheoGio(int newMucLuongTheoGio) {
		mucLuongTheoGio = newMucLuongTheoGio;
		tinhLuong();
	}
	
	//Các hàm điều kiện
	private boolean soGioKhongHopLe(int newSoGio) {
		if(newSoGio < 0) return true;
		return false;
	}
	private boolean mucLuongTheoGioKhongHopLe(int newMucLuongTheoGio) {
		if(newMucLuongTheoGio < 0) return true;
		return false;
	}
	
	//Các constructor
		//*** Constructor không tham số ***
	public NhanVienThoiVu() {
		super();
		soGio = 0;
		mucLuongTheoGio = 0;
	}
	
		//*** Constructor có tham số ***
	public NhanVienThoiVu(String newHo, String newTen, int newNgaySinh, int newThangSinh, int newNamSinh, 
			String newGioiTinh, String newMaSo, String newMaPhongBan, int newSoGio, int newMucLuongTheoGio) {
		super(newHo, newTen, newNgaySinh, newThangSinh, newNamSinh, newGioiTinh, newMaSo, newMaPhongBan);
		soGio = newSoGio;
		if(soGioKhongHopLe(soGio)) soGio = 0;
		mucLuongTheoGio = newMucLuongTheoGio;
		if(mucLuongTheoGioKhongHopLe(mucLuongTheoGio)) mucLuongTheoGio = 0;
	}
	//Hàm tính lương
	@Override public void tinhLuong() {
		setMucLuong(soGio * mucLuongTheoGio);
	}
	//Các hàm nhập và xuất
		//*** Hàm nhập ***
	
			//***** Các hàm nhập thành phần mới *****
	public void nhapSoGio() {
		int newSoGio;
		do {
			System.out.print("Nhap so gio lam: ");
			newSoGio = Integer.parseInt(scan.nextLine());
		} while(soGioKhongHopLe(newSoGio));
		soGio = newSoGio;
	}
	public void nhapMucLuongTheoGio() {
		int newMucLuongTheoGio;
		do {
			System.out.print("Nhap muc luong theo gio: ");
			newMucLuongTheoGio = Integer.parseInt(scan.nextLine());
		} while(mucLuongTheoGioKhongHopLe(newMucLuongTheoGio));
		mucLuongTheoGio = newMucLuongTheoGio;
	}
	
			//***** Hàm nhập tổng hợp *****
	@Override public void nhap() {
		super.nhap();
		nhapSoGio();
		nhapMucLuongTheoGio();
		tinhLuong();
	}
	
		//*** Hàm xuất ***
	
			//***** Các hàm xuất thành phần mới *****
	private void xuatSoGio() {
		System.out.println("So gio lam: "+soGio);
	}
	private void xuatMucLuongTheoGio() {
		System.out.println("Muc luong theo gio: "+mucLuongTheoGio);
	}
	
			//*** Hàm xuất tổng hợp ***
	@Override public void xuat() {
		super.xuat();
		xuatSoGio();
		xuatMucLuongTheoGio();
	}
}
