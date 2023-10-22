import java.util.Scanner;
public class DEAN {
	private String madean;
	private String tendean;
	private String maphong;
	private String diadiem;
	
	public DEAN() {
		madean = "";
		tendean ="";
		maphong = "";
		diadiem = "";
	}
	
	public DEAN(String madean,String tendean, String maphong, String diadiem ) {
		this.madean = madean;
		this.tendean = tendean;
		this.maphong = maphong;
		this.diadiem = diadiem;
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma de an (5 ki tu): ");
		madean = sc.nextLine();
		System.out.println("Nhap ten de an : ");
	 	tendean = sc.nextLine();
		System.out.println("Nhap ma phong (5 ki tu) : ");
	 	maphong = sc.nextLine();
		System.out.println("Nhap dia diem de an (30 ki tu) :");
	 	diadiem = sc.nextLine();	
	
	}
	
	public void xuat() {
		System.out.println("Ma de an: "+madean+", ten de an: "+tendean+", ma phong: "+maphong+", dia diem de an: "+diadiem);
		
	}
	
	// Get - Set
	public void setMadean(String madean) {
		this.madean = madean;
	}
	public String getMadean() {
		return madean;
	}
	public void setTendean(String tendean) {
		this.tendean = tendean;
	}
	public String getTendean() {
		return tendean;
	}
	public void setMaphong(String maphong) {
		this.maphong = maphong;
	}
	public String getMaphong() {
		return maphong;
	}
	public void setDiadiem(String diadiem) {
		this.diadiem = diadiem;
	}
	public String getDiadiem() {
		return diadiem;
	}
	
	public static void main (String args[]) {
		DEAN dean = new DEAN();
		dean.nhap();
		dean.xuat();
		
	}
}
