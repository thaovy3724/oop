public class LuongThoiVu extends Luong{
    public NhanVienThoiVu nv;

//constructor
    public LuongThoiVu(){
        super();
        nv = new NhanVienThoiVu();
    }

    public LuongThoiVu(NhanVienThoiVu nv, int khauTru, int thuong, int thanhToan, String phuongThucThanhToan){
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
        System.out.print("ten:"+nv.hoTen+"; so gio lam:"+nv.sogio+"; luong theo gio:"+nv.mucLuongTheoGio);
        super.xuat();
    }
//get
    public String getHoTen(){
        return nv.hoTen;
    }
    public String getPhuongThucThanhToan(){
        return phuongThucThanhToan;
    }
}
