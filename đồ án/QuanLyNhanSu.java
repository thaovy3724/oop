import java.util.Scanner;
public class QuanLyNhanSu {
    Scanner sc = new Scanner(System.in);
    private DanhSachNhanVien dsnv;
    private DanhSachBangLuong dsbl;
    //private DanhSachDuAn dsda;
    //private DanhSachPhongBan dspb;

    public QuanLyNhanSu(){
        dsnv=new DanhSachNhanVien();
        dsbl=new DanhSachBangLuong();
        //dsda=new DanhSachDuAn();
        //dspb=new DanhSachPhongBan();
    }

    public QuanLyNhanSu(DanhSachNhanVien dsnv, DanhSachBangLuong dsbl){
        this.dsnv=dsnv;
        this.dsbl=dsbl;
        //this.dsda=dsda;
        //this.dspb=dspb;
    }

    public void menuQuanLy(){
        int luachon;
        do{
        System.out.println("====QUAN LY NHAN SU===");
        System.out.println("Chon doi tuong can quan ly:");
        System.out.println("1.Nhan vien");
        System.out.println("2.Bang luong cua nhan vien");
        System.out.println("3.Phong ban");
        System.out.println("4.Du an");
        System.out.println("Nhap so khac de thoat");
        System.out.print("Nhap lua chon: ");
        luachon=Integer.parseInt(sc.nextLine());
        switch(luachon){
            //case 1: dsnv.menu(); break;
            case 2: dsbl.menu(); break;
            //case 3: dspb.menu(); break;
            //case 4: dsda.menu(); break;
            default: System.out.println("***Hen gap lai***");
        }
        }while(luachon>=1 && luachon<=4);
    }
}
