import java.util.Scanner; 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class NhanVien {
	public Scanner scan = new Scanner(System.in);
	
	//Các thuộc tính
	private String ho, ten;
	private LocalDate ngaySinh;
	private int id;
	private static int count = 1000; 
	private String maPhongBan;
	private long luongCanBan;
	
	//Các hàm get và set của class
		//*** Các hàm get ***
	public String getHo() {
		return ho;
	}
	public String getTen() {
		return ten;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public int getID() {
		return id;
	}
	public String getMaPhongBan() {
		return maPhongBan;
	}
	public long getLuongCanBan() {
		return luongCanBan;
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
	public void setNgaySinh(String newNgaySinh) {
		if(newNgaySinh.contains("-")) {
			ngaySinh = LocalDate.parse(newNgaySinh);
		}
		else {
			ngaySinh = LocalDate.parse(newNgaySinh, DateTimeFormatter.BASIC_ISO_DATE);
		}
	}
	/* public void setId(String newId) {
		id = newId;
	} */
	public void setMaPhongBan(String newMaPhongBan) {
		if(maPhongBanKhongHopLe(newMaPhongBan)) return;
		maPhongBan = newMaPhongBan;
	}
	
	//Các hàm kiểm tra điều kiện
	
		//*** Kiểm tra điều kiện của ngày sinh ***
	private boolean ngaySinhKhongHopLe(String newNgaySinh) {
		try {
			if (newNgaySinh.contains("-") == true) {
				LocalDate newDate = LocalDate.parse(newNgaySinh);
			} else {
				LocalDate newDate = LocalDate.parse(newNgaySinh, DateTimeFormatter.BASIC_ISO_DATE);
			}
		}
		catch(DateTimeParseException e) { return true; }
		return false;
	}

		//*** Kiểm tra điều kiện của id ***
	private boolean idKhongHopLe(String newId) {
		if(newId.length() != NhanVien_CONST.NUMBEROFCHAR_ID) return true;
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
		ngaySinh = LocalDate.parse("0001-01-01");
		id = 0;
		maPhongBan = "";
	}
	
		//*** Constructor có tham số ***
	public NhanVien(String newHo, String newTen, String newNgaySinh, int newId, String newMaPhongBan) {
		ho = newHo;
		ten = newTen;
		setNgaySinh(newNgaySinh);
		id = newId;
		maPhongBan = newMaPhongBan;
		//if(idKhongHopLe(id)) id = "";
		if(maPhongBanKhongHopLe(maPhongBan)) maPhongBan = "";
	}
	
	
	//Các hàm nhập xuất của class
	
		//*** Hàm nhập
	
			//***** Các hàm nhập thành phần *****
	public void nhapHoTen() {
		String newHoTen;
		System.out.print("Nhap ho va ten: ");
		newHoTen = scan.nextLine();
		setHoTen(newHoTen);
	}
	public void nhapNgaySinh() {
		String newNgaySinh;
		System.out.print("Nhap ngay sinh (YYYY-MM-DD): ");
		newNgaySinh = scan.nextLine();
		do {
			System.out.print("Ngay sinh khong hop le, vui long nhap lai!!!");
			System.out.print("Nhap ngay sinh (YYYY-MM-DD): ");
			newNgaySinh = scan.nextLine();
		} while(ngaySinhKhongHopLe(newNgaySinh));
		setNgaySinh(newNgaySinh);
	}
	/*
	public void nhapId() {
		String newId;
		System.out.print("Nhap ma so (8 ki tu): ");
		newId = scan.nextLine();
		while(idKhongHopLe(newId)) {
			System.out.print("Ma so khong hop le, vui long nhap lai!!!");
			System.out.print("Nhap ma so (8 ki tu): ");
			newId = scan.nextLine();
		}
		id = newId;
	} */
	public void nhapMaPhongBan() {
		String newMaPhongBan;
		System.out.print("Nhap ma phong ban: ");
		newMaPhongBan = scan.nextLine();
		while(maPhongBanKhongHopLe(newMaPhongBan)) {
			System.out.println("Ma phong ban khong hop le!! (Phai co "+NhanVien_CONST.NUMBEROFCHAR_MAPHONGBAN
					+" ki tu)");
			System.out.print("Nhap ma phong ban: ");
			newMaPhongBan = scan.nextLine();
		}
		maPhongBan = newMaPhongBan;
	}
	
			//***** Hàm nhập tổng hợp *****
	public void nhap() {
		nhapHoTen();
		nhapNgaySinh();
		id=count++;
	}
	
		//*** Hàm xuất
	
			//***** Các hàm xuất thành phần *****
	private void xuatHoTen() {
		System.out.println("Ho va ten: "+ho+" "+ten);
	}
	private void xuatNgaySinh() {
		System.out.println("Ngay thang nam sinh: "+ngaySinh);
	}
	private void xuatID() {
		System.out.println("Ma so: "+id);
	}
	private void xuatLuongCanBan() {
		System.out.println("Muc Luong: "+luongCanBan);
	}
	
			//***** Hàm xuất tổng hợp *****
	public void xuat() {
		xuatHoTen();
		xuatNgaySinh();
		System.out.println("ma pb: "+maPhongBan);
		xuatID();
	}
	//Hàm tính tổng số lượng nhân viên
	/*public static int tongSoLuongNhanVien() {
		return
	}*/
}