
public class NhanVienThoiVu extends NhanVien {
	//Các thuộc tính mới
	private int thoiHanLamViec;
	
	//Các hàm get và set mới
		//*** Các hàm get ***
	public int getThoiHanLamViec() {
		return thoiHanLamViec;
	}
	
		//*** Các hàm set ***
	public void setThoiHanLamViec(int newThoiHanLamViec) {
		if(thoiHanLamViecKhongHopLe(newThoiHanLamViec)) return;
		thoiHanLamViec = newThoiHanLamViec;
	}
	
	//Các hàm điều kiện
	private boolean thoiHanLamViecKhongHopLe(int newThoiHanLamViec) {
		if(newThoiHanLamViec < 0 || newThoiHanLamViec > NhanVien_CONST.MAX_OF_THOIHANLAMVIEC) return true;
		return false;
	}
	
	//Các constructor
		//*** Constructor không tham số ***
	public NhanVienThoiVu() {
		super();
		thoiHanLamViec = 0;
	}
	
		//*** Constructor có tham số ***
	public NhanVienThoiVu(String newHo, String newTen, String newNgaySinh, 
			int newId, String newMaPhongBan, int newThoiHanLamViec) {
		super(newHo, newTen, newNgaySinh, newId, newMaPhongBan);
		thoiHanLamViec = newThoiHanLamViec;
		if(thoiHanLamViecKhongHopLe(thoiHanLamViec)) thoiHanLamViec = 0;
	}
	
	//Các hàm nhập và xuất
		//*** Hàm nhập ***
	
			//***** Các hàm nhập thành phần mới *****
	public void nhapThoiHanLamViec() {
		int newThoiHanLamViec;
		System.out.print("Nhap thoi han lam viec: ");
		newThoiHanLamViec = Integer.parseInt(scan.nextLine());
		while(thoiHanLamViecKhongHopLe(newThoiHanLamViec)) {
			System.out.println("Thoi han lam viec khong hop le!! (Phai lon hon 0)");
			System.out.print("Nhap thoi han lam viec: ");
			newThoiHanLamViec = Integer.parseInt(scan.nextLine());
		}
		thoiHanLamViec = newThoiHanLamViec;
	}
	
			//***** Hàm nhập tổng hợp *****
	@Override public void nhap() {
		super.nhap();
		nhapThoiHanLamViec();
	}
	
		//*** Hàm xuất ***
	
			//***** Các hàm xuất thành phần mới *****
	private void xuatThoiHanLamViec() {
		System.out.println("Thoi han lam viec: "+thoiHanLamViec);
	}
	
			//*** Hàm xuất tổng hợp ***
	@Override public void xuat() {
		super.xuat();
		xuatThoiHanLamViec();
	}
}