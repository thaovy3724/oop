import java.util.Scanner;
class PHONGBAN {
    protected String maphong; // 5 ki tu
    protected String tenphong; // ten phong
    protected String trgphong; // ten truong phong
    protected static int slnv; // so luong nhan vien
    protected  String diadiem; // dia diem
    protected String mada; // ma de an - 5 ki tu

    // constructor 
    public PHONGBAN () {
    }

    public PHONGBAN (String maphong, String tenphong, String trgphong, int slnv, String diadiem, String mada)
    {
        this.maphong=maphong;
        this.tenphong=tenphong;
        this.trgphong=trgphong;
        this.slnv=slnv;
        this.diadiem=diadiem;
        this.mada=mada;
    }

    // input
    public void nhapPhongBan ()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phong: ");
        maphong = sc.nextLine();
        System.out.print("Nhap ten phong: ");
        tenphong = sc.nextLine();
        System.out.print("Nhap ten truong phong: ");
        trgphong = sc.nextLine();
        do {
            System.out.print("Nhap so luong nhan vien trong phong ban: ");
            slnv = sc.nextInt();
            if (slnv < 0)
                System.out.println("So luong nhan vien khong hop le, vui long nhap lai...");
        } while (slnv < 0);
        System.out.print("Nhap dia diem phong ban: ");
        diadiem = sc.nextLine();
        System.out.print("Nhap ma de an: ");
        mada = sc.nextLine();
        sc.close();
    }

    // output
    public void xuatPhongBan () {
        System.out.println("MaPhong: " +maphong+ " TenPhong: " +tenphong+ " TruongPhong: " +trgphong+ " SLNhanvien: " +slnv+ " DiaDiem: " +diadiem+ " MaDeAn: " +mada);
    }
    // get&set maphong
    public String getMaphong () {
        return maphong;
    }
    public void setMaphong (String maphong) {
        this.maphong=maphong;
    }

    // get&set tenphong
    public String getTenphong () {
        return tenphong;
    }
    public void setTenphong (String tenphong) {
        this.tenphong=tenphong;
    }

    // get&set trgphong
    public String getTrgphong () {
        return maphong;
    }
    public void setTrgphong (String trgphong) {
        this.trgphong=trgphong;
    }

    // get&set slnv (so luong nhan vien)
    public int getSLNV () {
        return slnv;
    }
    public void setSLNV (int slnv) {
        this.slnv=slnv;
    }

    // get&set diadiem
    public String getDiadiem () {
        return diadiem;
    }
    public void setDiadiem (String diadiem) {
        this.diadiem=diadiem;
    }

    // get&set mada
    public String getMada () {
        return mada;
    }
    public void setMada (String mada) {
        this.mada=mada;
    }
}