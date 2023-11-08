public class LuongChinhThuc extends Luong{
//field
    NhanVienChinhThuc nv;
    private int tienTangCa;
//constructor
    public LuongChinhThuc(){
        super();
        nv = new NhanVienChinhThuc();
        tienTangCa=0;
    }

    public LuongChinhThuc(NhanVienChinhThuc nv,int thucLanh, int thanhToan, int tienTangCa){
        super(thucLanh, thanhToan);
        this.nv=nv;
        this.tienTangCa=tienTangCa;
        checkTienTangCa();
    }

//nhap
    @Override public void nhap(){
        nv.nhap();
        System.out.print("Nhap tien tang ca: ");
        tienTangCa=Integer.parseInt(sc.nextLine());
        checkTienTangCa();
        super.nhap();
    }

//xuat
    @Override public void xuat(){
        System.out.print("[ho ten: "+nv.getHo()+" "+nv.getTen()+"; so ngay cong: "+nv.getSoNgay()+"; luong theo ngay: "+nv.getMucLuongTheoNgay()+"; tien tang ca: "+tienTangCa);
        super.xuat();
    }

//override abstract method
    @Override protected int tongLuong(){
        return nv.getMucLuongTheoNgay()*nv.getSoNgay()+tienTangCa-thue; //base + bonus - tax
    }

    @Override protected int tinhThue(){
        return nv.getMucLuongTheoNgay()*nv.getSoNgay()*8/100;
    }

//kiem tra dieu kien
    private void checkTienTangCa(){
        while(tienTangCa<0){
            System.out.println("Can nhap lon hon bang 0 !!!");
            tienTangCa=Integer.parseInt(sc.nextLine());
        }
    }

//get - set
//NOTE
    @Override public String getTen(){
        return nv.getTen();
    }
    @Override public void setTen(){
        System.out.print("Nhap ten nhan vien: ");
        String ten = sc.nextLine();
        nv.setTen(ten);
    }
}
