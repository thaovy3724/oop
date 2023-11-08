
public class mainQuanLiNhanSu {

	public static void main(String[] args) {
		NhanVienThoiVu nvtv1 = new NhanVienThoiVu();
		nvtv1.nhap();
		DanhSachNhanVien ds1 = new DanhSachNhanVien(nvtv1);
		ds1.xuat();
		ds1.tim();
		ds1.sua();
		ds1.xoa();
		return;
	}

}
