import java.util.Scanner;
class PHONGKINHDOANH extends PHONGBAN {
    protected int doanhthu;
    protected String chienDichQuangCao;

    // constructor
    public PHONGKINHDOANH () {
        doanhthu = 0;
        chienDichQuangCao = "";
    }

    public PHONGKINHDOANH (String maphong, String tenphong, String trgphong, int slnv, String diadiem, String mada, int doanhthu, String chienDichQuangCao) {
        super (maphong, tenphong, trgphong, slnv, diadiem, mada);
        this.doanhthu = doanhthu;
    }

    // input 
    public void nhapPhongKD () {
        super.nhapPhongBan();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap doanh thu cua Phong Kinh Doanh trong thang nay: ");
        doanhthu = sc.nextInt();
        System.out.print("Nhap chien dich cua phong Kinh Doanh: ");
        chienDichQuangCao = sc.nextLine();
    }

    // output
    public void xuatPhongKD () {
        super.xuatPhongBan();
        System.out.println("Doanh thu cua Phong Kinh Doanh: " + doanhthu);
        System.out.println("Chien dich cua phong Kinh Doanh: " + chienDichQuangCao);
    }

    // set&get doanh thu
    public int getDoanhThu () {
        return doanhthu;
    }
    public void setDoanhThu (int doanhthu) {
        this.doanhthu = doanhthu;
    }

    // get&set chienDichQuangCao
    public String getChienDichQuangCao () {
        return chienDichQuangCao;
    }
    public void setChienDichQuangCao (String chienDichQuangCao) {
        this.chienDichQuangCao = chienDichQuangCao;
    }
}
