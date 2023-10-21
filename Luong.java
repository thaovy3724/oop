import java.util.Scanner;

public class Luong{

// Attributes
// <String> maNV - ma nhan vien - dk: co 8 ki tu   
// <String> hoTen - ho ten nhan vien - dk: khong bo trong
// <int> soNgayCong - so ngay lam viec / thang - dk: >=0
// <int> thucLanh - tong tien luong nhan trong 1 thang - dk: >0
// <int> mucLuong - muc tien luong / ngay - dk: >0
    private String maNV, hoTen;
    private int soNgayCong, mucLuong, thucLanh;

// Constructors
    public Luong(){
        maNV="";
        hoTen="";
        soNgayCong=0;
        mucLuong=0;
        thucLanh=0;
    }
    public Luong(String maNV, String hoTen, int soNgayCong, int mucLuong){
        this.maNV=maNV;
        check_MaNV();
        this.hoTen=hoTen;
        check_hoTen();
        this.soNgayCong=soNgayCong;
        check_soNgayCong();
        this.mucLuong=mucLuong;
        check_mucLuong();
        thucLanh=mucLuong*soNgayCong;
    }

// Methods
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien:");
        maNV=sc.nextLine();
        check_MaNV();
        System.out.println("Nhap ho ten:");
        hoTen=sc.nextLine();
        check_hoTen();
        System.out.println("Nhap so ngay cong:");
        soNgayCong=sc.nextInt();
        check_soNgayCong();
        System.out.println("Nhap muc luong");
        mucLuong=sc.nextInt();
        check_mucLuong();
        thucLanh=mucLuong*soNgayCong;
    }

    public void xuat(){
        System.out.println("(maNV:"+maNV+";ten:"+hoTen+";songaycong:"+soNgayCong+";mucluong:"+mucLuong+"thuclanh:"+thucLanh+")");
    }

    protected void xuat_trongLopCon(){
        System.out.print("(maNV:"+maNV+";ten:"+hoTen+";songaycong:"+soNgayCong+";mucluong:"+mucLuong+";");
    }
    
// Get - Set
    // GET
    public int get_mucLuong(){
        return mucLuong;
    }
    public int get_thucLanh(){
        return thucLanh;
    }
    //SET
    public void set_thucLanh(int thucLanh){
        this.thucLanh=thucLanh;
    }

// Kiem tra dieu kien cua attributes
    private void check_MaNV(){
        Scanner sc = new Scanner(System.in);
        while(maNV.length()!=8){
            System.out.println("Ma nhan vien phai co 8 ki tu !!!");
            maNV=sc.nextLine();
        }
    }
    private void check_hoTen(){
        Scanner sc = new Scanner(System.in);
        while(hoTen.length()==0){
            System.out.println("Ban can dien ho ten !!!");
            hoTen=sc.nextLine();
        }
    }
    private void check_soNgayCong(){
        Scanner sc = new Scanner(System.in);
        while(soNgayCong<0){
            System.out.println("So ngay cong phai lon hon hoac bang 0 !!!");
            soNgayCong=sc.nextInt();
        }
    }
    private void check_mucLuong(){
        Scanner sc = new Scanner(System.in);
        while(mucLuong<0){
            System.out.println("Muc luong phai lon hon hoac bang 0 !!!");
            mucLuong=sc.nextInt();
        }
    }
}
