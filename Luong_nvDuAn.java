import java.util.Scanner;

public class Luong_nvDuAn extends Luong{

// Attributes
// final <int> phuCapHangThang - tien phu cap hang thang - dk: >0
// <int> tienThuong -tien thuong cho moi du an
    private final int phuCapHangThang = 1000000;
    private int tienThuong;

// Constructors
    public Luong_nvDuAn(){
        super();
        tienThuong=0;
    }

    public Luong_nvDuAn(String maNV, String hoTen, int soNgayCong, int mucLuong, int tienThuong){
        super(maNV, hoTen, soNgayCong, mucLuong);
        this.tienThuong=tienThuong;
        // set private attribute (thuc lanh) cua lop cha --> set_thucLanh
        int luong = get_thucLanh() + tienThuong +phuCapHangThang;
        super.set_thucLanh(luong);
    }

// Methods
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap so tien thuong cua thang:");
        tienThuong=sc.nextInt();
        int luong = get_thucLanh() + tienThuong +phuCapHangThang;
        super.set_thucLanh(luong);
    }

    public void xuat(){
        super.xuat_trongLopCon();
        System.out.print(";phucap:"+phuCapHangThang+";tienthuong:"+tienThuong+";thuclanh:"+super.get_thucLanh()+")");
        System.out.println();
    }
}
