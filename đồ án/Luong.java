import java.util.Scanner;

public abstract class Luong{
    public Scanner sc = new Scanner(System.in);

//field
    protected int thue;
    protected int thucLanh;
    protected int thanhToan;
    
//constructor
    public Luong(){
        thue=0;
        thucLanh=0;
        thanhToan=0;
    }

    public Luong(int thucLanh, int thanhToan){
        thue=tinhThue();
        this.thucLanh=thucLanh; 
        checkThucLanh();
        this.thanhToan=thanhToan;
        checkThanhToan();
    }

//nhap
    protected void nhap(){
        thue=tinhThue();
        thucLanh=tongLuong();
        System.out.print("Nhap so tien da thanh toan: ");
        thanhToan=Integer.parseInt(sc.nextLine());
        checkThanhToan();
    }

//xuat
    protected void xuat(){
        System.out.println("; thue: "+thue+"; thucLanh: "+thucLanh+"; thanhToan: "+thanhToan+"]");
    }

//cac ham abstract
    protected abstract int tongLuong();
    protected abstract int tinhThue();
//kiem tra dieu kien
    protected void checkThucLanh(){
        while(thucLanh<0){
            System.out.println("Can nhap lon hon bang 0 !!!");
            System.out.print("Nhap lai thuc lanh: ");
            thucLanh=Integer.parseInt(sc.nextLine());
        }
    }

    protected void checkThanhToan(){
        while(thanhToan<0){
            System.out.println("Can nhap lon hon bang 0 !!!");
            System.out.print("Nhap lai thanh toan: ");
            thanhToan=Integer.parseInt(sc.nextLine());
        }
        while(thanhToan>tongLuong()){
            System.out.println("Thanh toan nhieu hon tong luong");
            System.out.print("Nhap lai thanh toan: ");
            thanhToan=Integer.parseInt(sc.nextLine());
        }
    }

//get - set
    public abstract String getTen();

    public int getThanhToan(){
        return thanhToan;
    }

    public int getThucLanh(){
        return thucLanh;
    }

    public abstract void setTen();

    public void setThanhToan(){
        System.out.print("Nhap so tien thanh toan: ");
        thanhToan = Integer.parseInt(sc.nextLine());
        checkThanhToan();
    }
}