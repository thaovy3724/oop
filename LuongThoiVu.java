public class LuongThoiVu extends Luong{
//field
    NhanVienThoiVu nv;
    private int thuong;
//constructor
    public LuongThoiVu(){
        super();
        thuong=0;
        nv = new NhanVienThoiVu();
    }

    public LuongThoiVu(NhanVienThoiVu nv,int thuong, int thucLanh, int thanhToan){
        super(thucLanh, thanhToan);
        this.nv=nv;
        this.thuong=thuong;
        checkThuong();
    }

//nhap
    @Override public void nhap(){
        nv.nhap();
        System.out.print("Nhap tien thuong: ");
        thuong=Integer.parseInt(sc.nextLine());
        checkThuong();
        super.nhap();
    }

//xuat
    @Override public void xuat(){
        System.out.print("[ho ten: "+nv.getHo()+" "+nv.getTen()+"; so gio lam: "+nv.getSoGio()+"; luong theo gio: "+nv.getMucLuongTheoGio()+"; tien thuong: "+thuong);
        super.xuat();
    }

//override abstract method
    @Override protected int tongLuong(){
        return nv.getSoGio()*nv.getMucLuongTheoGio()+thuong-thue;
    }

    @Override protected int tinhThue(){
        return (int)nv.getMucLuong()*8/100;
    }
//kiem tra dieu kien
    private void checkThuong(){
        while(thuong<0){
            System.out.println("Can nhap lon hon bang 0 !!!");
            thuong=Integer.parseInt(sc.nextLine());
        }
    }
//get - set
    @Override public String getTen(){
        return nv.getTen();
    }
    @Override public void setTen(){
        System.out.print("Nhap ten nhan vien: ");
        String ten = sc.nextLine();
        nv.setTen(ten);
    }

}
    