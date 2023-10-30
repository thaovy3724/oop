import java.util.Scanner;

public class Luong{
    protected int khauTru, thuong;
    protected int thanhToan;
    protected String phuongThucThanhToan;
    //luong

//constructor
    public Luong(){
        khauTru=0;
        thuong=0;
        thanhToan=0;
        phuongThucThanhToan="";
    }

    public Luong(int khauTru, int thuong, int thanhToan, String phuongThucThanhToan){
        this.khauTru=khauTru;
        checkKhauTru();
        this.thuong=thuong;
        checkThuong();
        this.thanhToan=thanhToan;
        checkThanhToan();
        this.phuongThucThanhToan=phuongThucThanhToan;
    }

//nhap
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap khau tru:");
        khauTru=Integer.parseInt(sc.nextLine());
        checkKhauTru();
        System.out.println("nhap tien thuong:");
        thuong=Integer.parseInt(sc.nextLine());
        checkThuong();
        System.out.println("nhap so tien da thanh toan:");
        thanhToan=Integer.parseInt(sc.nextLine());
        checkThanhToan();
        System.out.println("nhap phuong thuc thanh toan:");
        phuongThucThanhToan=sc.nextLine();
}

//xuat
    public void xuat(){
        System.out.print("khautru:"+khauTru+"; thuong:"+thuong+"; thanhtoan:"+thanhToan+"; pthuc thanh toan:"+phuongThucThanhToan);
    }

//kiem tra dieu kien
    private void checkKhauTru(){
        Scanner sc = new Scanner(System.in);
        while(khauTru<0){
            System.out.println("Can nhap lon hon bang 0 !!!");
            khauTru=Integer.parseInt(sc.nextLine());
        }
    }

    private void checkThuong(){
        Scanner sc = new Scanner(System.in);
        while(thuong<0){
            System.out.println("Can nhap lon hon bang 0 !!!");
            thuong=Integer.parseInt(sc.nextLine());
        }
    }

    private void checkThanhToan(){
        Scanner sc = new Scanner(System.in);
        while(thanhToan<0){
            System.out.println("Can nhap lon hon bang 0 !!!");
            thanhToan=Integer.parseInt(sc.nextLine());
        }
    }
}