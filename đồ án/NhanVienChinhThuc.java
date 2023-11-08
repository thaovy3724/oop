
public class NhanVienChinhThuc extends NhanVien{
	//Các thuộc tính mới
	private int soNgay;
	private int mucLuongTheoNgay;
	
	//Các hàm get và set mới
		//*** Các hàm get ***
	public int getSoNgay() {
		return soNgay;
	}
	public int getMucLuongTheoNgay() {
		return mucLuongTheoNgay;
	}
	
		//*** Các hàm set ***
	public void setSoNgay(int newSoNgay) {
		soNgay = newSoNgay;
		tinhLuong();
	}
	public void setMucLuongTheoNgay(int newMucLuongTheoNgay) {
		mucLuongTheoNgay = newMucLuongTheoNgay;
		tinhLuong();
	}
	
	//Các hàm điều kiện
	private boolean soNgayKhongHopLe(int newSoNgay) {
		if(newSoNgay < 0) return true;
		return false;
	}
	private boolean mucLuongTheoNgayKhongHopLe(int newMucLuongTheoNgay) {
		if(newMucLuongTheoNgay < 0) return true;
		return false;
	}
	
	//Các constructor
		//*** Constructor không tham số ***
	public NhanVienChinhThuc() {
		super();
		soNgay = 0;
		mucLuongTheoNgay = 0;
	}
	
		//*** Constructor có tham số ***
	public NhanVienChinhThuc(String newHo, String newTen, int newNgaySinh, int newThangSinh, int newNamSinh, 
			String newGioiTinh, String newMaSo, String newMaPhongBan, int newSoNgay, int newMucLuongTheoNgay) {
		super(newHo, newTen, newNgaySinh, newThangSinh, newNamSinh, newGioiTinh, newMaSo, newMaPhongBan);
		soNgay = newSoNgay;
		if(soNgayKhongHopLe(soNgay)) soNgay = 0;
		mucLuongTheoNgay = newMucLuongTheoNgay;
		if(mucLuongTheoNgayKhongHopLe(mucLuongTheoNgay)) mucLuongTheoNgay = 0;
	}
	
	//Hàm tính lương
	@Override public void tinhLuong() {
		setMucLuong(soNgay * mucLuongTheoNgay);
	}
	
	//Các hàm nhập và xuất
			//*** Hàm nhập ***
		
				//***** Các hàm nhập thành phần mới *****
	public void nhapSoNgay() {
		int newSoNgay;
		do {
			System.out.print("Nhap so ngay lam: ");
			newSoNgay = Integer.parseInt(scan.nextLine());
		} while(soNgayKhongHopLe(newSoNgay));
		soNgay = newSoNgay;
	}
	public void nhapMucLuongTheoNgay() {
		int newMucLuongTheoNgay;
		do {
			System.out.print("Nhap muc luong theo ngay: ");
			newMucLuongTheoNgay = Integer.parseInt(scan.nextLine());
		} while(mucLuongTheoNgayKhongHopLe(mucLuongTheoNgay));
		mucLuongTheoNgay = newMucLuongTheoNgay;
	}
	
				//***** Hàm nhập tổng hợp *****
	@Override public void nhap() {
		super.nhap();
		nhapSoNgay();
		nhapMucLuongTheoNgay();
		tinhLuong();
	}
			//*** Hàm xuất ***
	
				//***** Các hàm xuất thành phần mới *****
	public void xuatSoNgay() {
		System.out.println("So ngay lam: "+soNgay);
	}
	public void xuatMucLuongTheoNgay() {
		System.out.println("Muc luong theo ngay: "+mucLuongTheoNgay);
	}
	
				//*** Hàm xuất tổng hợp ***
	@Override public void xuat() {
		super.xuat();
		xuatSoNgay();
		xuatMucLuongTheoNgay();
	}
}
