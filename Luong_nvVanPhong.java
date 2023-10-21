import java.util.Scanner;

public class Luong_nvVanPhong extends Luong{

// Attributes
// final <int> phuCapHangThang - tien phu cap hang thang - dk: >0
// <int> soGioTangCa - so gio tang ca / thang- dk: >=0
// <int> mucTienTangCa - muc tien lam tang ca / gio = mucLuong * 30%
    private final int phuCapHangThang = 1000000;
    private int soGioTangCa;
    private int mucTienTangCa;

// Constructors
    public Luong_nvVanPhong(){
        super();
        soGioTangCa=0;
        mucTienTangCa=0;
    }

    public Luong_nvVanPhong(String maNV, String hoTen, int soNgayCong, int mucLuong, int soGioTangCa){
        super(maNV, hoTen, soNgayCong, mucLuong);
        this.soGioTangCa=soGioTangCa;
        // lop con nen khong access duoc private attribue (muc luong) cua lop cha --> get_mucLuong
        mucTienTangCa=super.get_mucLuong()*30/100; 
        // set private attribute (thuc lanh) cua lop cha --> set_thucLanh
        int luong = get_thucLanh() + soGioTangCa*mucTienTangCa +phuCapHangThang;
        super.set_thucLanh(luong);
    }

// Methods
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so gio tang ca:");
        soGioTangCa=sc.nextInt();
        mucTienTangCa=super.get_mucLuong()*30/100;
        int luong = get_thucLanh() + soGioTangCa*mucTienTangCa +phuCapHangThang;
        super.set_thucLanh(luong);
    }

    public void xuat(){
        super.xuat_trongLopCon();
        System.out.print("sogiotangca:"+soGioTangCa+";muctientangca:"+mucTienTangCa+";phucap:"+phuCapHangThang+"thuclanh:"+super.get_thucLanh()+")");
        System.out.println();
    }
}
