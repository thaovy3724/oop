import java.util.Scanner;

public class ThongTinCaNhan {
	private Scanner scan = new Scanner(System.in);
	
	//Các thuộc tính của class
	private String hoTen;
	private int ngaySinh, thangSinh, namSinh;
	private String gioiTinh; 
	
	//Các hàm get và set của class
	
	//*** Các hàm get ***
	public String getHoTen() {
		return hoTen;
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
	
	//*** Các hàm set ***
	public void setHoTen(String newHoTen) {
		hoTen = newHoTen;
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
		if(gioiTinhDuocKiemTra == "nam") return false;
		if(gioiTinhDuocKiemTra == "nu") return false;
		return true;
	}
	
	
	//Các constructor của class
	
	//*** Constructor không tham số ***
	public ThongTinCaNhan() {
		hoTen = "";
		ngaySinh = 0;
		thangSinh = 0;
		namSinh = 0;
		gioiTinh = "";
	}
	
	//*** Constructor có tham số
	public ThongTinCaNhan(String newHoTen, int newNgaySinh, int newThangSinh, int newNamSinh,
			String newGioiTinh) {
		hoTen = newHoTen;
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
	}
	
	
	//Các hàm nhập xuất của class
	
	//*** Hàm nhập ***
	
	//***** Các hàm nhập thành phần *****
	private void NhapHoTen() {
		String newHoTen;
		System.out.print("Nhap ho va ten: ");
		newHoTen = scan.nextLine();
		hoTen = newHoTen;
	}
	private void NhapNamSinh() {
		int newNamSinh;
		do {
			System.out.print("Nhap nam sinh: ");
			newNamSinh = Integer.parseInt(scan.nextLine());
		} while(namKhongHopLe(newNamSinh));
		namSinh = newNamSinh;
	}
	private void NhapThangSinh() {
		int newThangSinh;
		do {
			System.out.print("Nhap thang sinh: ");
			newThangSinh = Integer.parseInt(scan.nextLine());
		} while(thangKhongHopLe(newThangSinh));
		thangSinh = newThangSinh;
	}
	private void NhapNgaySinh() {
		int newNgaySinh;
		do {
			System.out.print("Nhap ngay sinh: ");
			newNgaySinh = Integer.parseInt(scan.nextLine());
		} while(ngayKhongHopLe(newNgaySinh));
		ngaySinh = newNgaySinh;
	}
	private void NhapGioiTinh() {
		String newGioiTinh;
		do {
			System.out.print("Gioi tinh (Nam hay nu?): ");
			newGioiTinh = (scan.nextLine()).toLowerCase().intern();
		} while(gioiTinhKhongHopLe(newGioiTinh));
		gioiTinh = newGioiTinh;
	}
	
	//***** Hàm nhập tổng hợp *****
	
	public void Nhap() {
		NhapHoTen();
		NhapNamSinh();
		NhapThangSinh();
		NhapNgaySinh();
		NhapGioiTinh();
	}
	
	//*** Hàm xuất ***
	
	//***** Các hàm xuất thành phần *****
	private void XuatHoTen() {
		System.out.println("Ho va ten: "+hoTen);
	}
	private void XuatNgayThangNamSinh() {
		System.out.println("Ngay thang nam sinh: "+ngaySinh+" - "+thangSinh+" - "+namSinh);
	}
	private void XuatGioiTinh() {
		System.out.println("Gioi tinh: "+gioiTinh);
	}
	
	//***** Hàm xuất tổng hợp *****
	public void Xuat() {
		XuatHoTen();
		XuatNgayThangNamSinh();
		XuatGioiTinh();
	}
}
