public class LuongChinhThuc extends Luong{
    NhanVienChinhThuc nv;

//constructor
    public LuongChinhThuc(){
        super();
        nv = new NhanVienChinhThuc();
    }

    public LuongChinhThuc(NhanVienChinhThuc nv, int khauTru, int thuong, int thanhToan, String phuongThucThanhToan){
        super(khauTru, thuong, thanhToan, phuongThucThanhToan);
        this.nv=nv;
    }

//nhap
    public void nhap(){
        nv.nhap();
        super.nhap();
    }

//xuat
    public void xuat(){
        System.out.print("ten:"+nv.hoTen+"; so ngay cong"+nv.soNgayCong+"; luong theo ngay:"+nv.mucLuongTheoNgay);
        super.xuat();
    }
}
