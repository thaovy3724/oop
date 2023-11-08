import java.util.Scanner;
import java.util.ArrayList;

public class DanhSachLuong {
    public Scanner sc = new Scanner(System.in);

//field
    private ArrayList<Luong> danhSachLuong;

//constructor
    public DanhSachLuong(){
        danhSachLuong=new ArrayList<Luong>();
    }

    public DanhSachLuong(ArrayList<Luong> danhSachLuong){
        this.danhSachLuong=danhSachLuong;
    }

//Menu CRUD
    public void menu(){
        int luachon;
        do{
        System.out.println("1.Them");
        System.out.println("2.Tim kiem");
        System.out.println("3.Xoa");
        System.out.println("4.Sua");
        System.out.println("5.Xuat");
        System.out.println("Nhap so khac de thoat !!!");
        System.out.print("Nhap lua chon: ");
        luachon=Integer.parseInt(sc.nextLine());
        switch(luachon){
            case 1: them(); break;
            case 2: tim(); break;
            case 3: xoa(); break;
            case 4: sua(); break;
            case 5: xuat(); break;
        }
        if(luachon<1 || luachon>5)
            System.out.println("***Thoat danh sach luong***");
        }
        while(luachon>=1 && luachon<=5);
    }
//xuat
    public void xuat(){
        if(danhSachLuong.size()==0)
            System.out.println("Danh sach rong!!!");
        else{
            System.out.println("Xuat danh sach luong");
            for(Luong l : danhSachLuong){
                l.xuat();
                System.out.println("========================");
            }
        }
    }

//them
    public void them(){
        //cho user chon so luong bang luong muon them
        System.out.println("Nhap so luong bang luong muon them:");
        int n = Integer.parseInt(sc.nextLine());
        int luachon;
        for(int i=0; i<n; i++){
        //cho user chon loai luong muon them
            do{
                System.out.println("Nhap bang luong cua loai nhan vien muon them");
                System.out.println("1.Nhan vien chinh thuc");
                System.out.println("2.Nhan vien thoi vu");
                luachon=Integer.parseInt(sc.nextLine());
            }
            while(luachon!=1 && luachon!=2); //kiem tra dieu kien nhap
            if(luachon==1){
                LuongChinhThuc l = new LuongChinhThuc();
                l.nhap();
                danhSachLuong.add(l);
            }
            else if(luachon==2){
                LuongThoiVu l = new LuongThoiVu();
                l.nhap();
                danhSachLuong.add(l);
            }
        }
    }

//tim kiem
    public int menuTim(){
        int luachon;
        if(danhSachLuong.size()==0){
            System.out.println("Danh sach rong!!!");
            luachon=-1;
        }
        else{
        System.out.println("=====MENU TIM KIEM======");
        System.out.println("1.Tim theo ten nhan vien");
        System.out.println("2.Tim theo loai bang luong");
        System.out.println("3.Tim theo tien thuc lanh");
        System.out.println("4.Tim theo so tien da thanh toan");
        System.out.println("Nhap so khac de thoat!!!");
        System.out.print("Nhap lua chon: ");
        luachon = Integer.parseInt(sc.nextLine());
        }
        return luachon;
    }

    public void tim(){
        int luachon;
        do{
            luachon = menuTim();
            ArrayList<Luong> kq = new ArrayList<>(); //mang de hung ket qua
            //switch tren lua chon
            switch (luachon){
                case 1: kq = timTen(); break;
                case 2: kq = timLoaiLuong(); break;
                case 3: kq = timThucLanh(); break;
                case 4: kq = timThanhToan(); break;
            }
            if(luachon <1 || luachon>4){
                System.out.println("***Thoat***");
            }
            //kiem tra mang ket qua co rong khong
            else{
                if(kq.size()==0)
                    System.out.println("Khong tim thay!!!");
                else{
                    //xuat ket qua
                    System.out.println("Ket qua tim kiem :");
                    for(Luong l : kq){
                        l.xuat();
                        System.out.println("========================");
                    }
                }
            }
        }
        while(luachon>=1 && luachon<=4);
    }
    
    //cac ham tim kiem
    private ArrayList<Luong> timTen(){
        //tao mang moi chua ket qua vua tim duoc
        ArrayList<Luong> kq = new ArrayList<>();
        System.out.println("Nhap ten nhan vien can tim:");
        String tenInput=sc.nextLine();
        //String pattern=".*"+ten.toLowerCase()+".*"; //note
        //sai: ten=".*"+ten.toLowercase()+".*";
        for(Luong l : danhSachLuong){
            //cast l de truy cap method getTen
            /*
            if(l instanceof LuongChinhThuc)
                l = (LuongChinhThuc) l;
            else if(l instanceof LuongThoiVu)
                l = (LuongThoiVu) l;
            */
            //if(l.getTen().toLowerCase().matches(pattern))
            if(l.getTen().equalsIgnoreCase(tenInput))
                kq.add(l);
        }
        return kq;
    }

    private ArrayList<Luong> timLoaiLuong(){
        //tao mang moi chua ket qua vua tim duoc
        ArrayList<Luong> kq = new ArrayList<>();
        int luachon;
        do{
        System.out.println("Nhap loai luong can tim");
        System.out.println("1.Luong chinh thuc");
        System.out.println("2.Luong thoi vu");
        luachon = Integer.parseInt(sc.nextLine());
        }
        while(luachon!=1 && luachon!=2);
        if(luachon==1)
            for(Luong l : danhSachLuong){
                if(l instanceof LuongChinhThuc)
                kq.add(l);
            }
        if(luachon==2)
            for(Luong l : danhSachLuong){
                if(l instanceof LuongThoiVu)
                kq.add(l);
            }
        return kq;
    }

    private ArrayList<Luong> timThanhToan(){
        //tao mang moi chua ket qua vua tim duoc
        ArrayList<Luong> kq = new ArrayList<>();
        System.out.println("Nhap so tien da thanh toan can tim:");
        int tien = Integer.parseInt(sc.nextLine());
        for(Luong l : danhSachLuong)
            //cast l de truy cap method getTen
            /*
            if(l instanceof LuongChinhThuc)
                l = (LuongChinhThuc) l;
            else if(l instanceof LuongThoiVu)
                l = (LuongThoiVu) l;
            */
            if(l.getThanhToan()==tien) 
                kq.add(l);
        return kq;
    }

    private ArrayList<Luong> timThucLanh(){
        //tao mang moi chua ket qua vua tim duoc
        ArrayList<Luong> kq = new ArrayList<>();
        System.out.println("Nhap so tien thuc lanh can tim:");
        int tien = Integer.parseInt(sc.nextLine());
        for(Luong l : danhSachLuong)
            //cast l de truy cap method getTen
            /*
            if(l instanceof LuongChinhThuc)
                l = (LuongChinhThuc) l;
            else if(l instanceof LuongThoiVu)
                l = (LuongThoiVu) l;
            */
            if(l.getThucLanh()==tien) 
                kq.add(l);
        return kq;
    }

//xoa
public void xoa(){
    int luachon;
    do{
        System.out.println("===XOA KHOI DANH SACH===");
        luachon = menuTim();
        ArrayList<Luong> kq = new ArrayList<>(); //mang de hung ket qua
        //switch tren lua chon
        switch (luachon){
            case 1: kq = timTen(); break;
            case 2: kq = timLoaiLuong(); break;
            case 3: kq = timThucLanh();break;
            case 4: kq = timThanhToan(); break;
        }

        //kiem tra mang ket qua co rong khong
        if(kq.size()==0)
            System.out.println("Khong tim thay noi dung can xoa!!!");
        else{
            //xuat ket qua
            System.out.println("Ket qua tim kiem :");
            for(Luong l : kq){
                l.xuat();
                System.out.println("========================");
            }
            //xoa
            for(Luong l : kq)
                danhSachLuong.remove(l);
            System.out.println("Da xoa thanh cong!!!");
        }
    }
    while(luachon>=1 && luachon<=4);
}

//sua
    public void sua(){
        int luachon;
    do{
        System.out.println("=====SUA THONG TIN======");
        luachon = menuTim();
        ArrayList<Luong> kq = new ArrayList<>(); //mang de hung ket qua
        //switch tren lua chon
        switch (luachon){
            case 1: kq = timTen(); break;
            case 2: kq = timLoaiLuong(); break;
            case 3: kq = timThucLanh();break;
            case 4: kq = timThanhToan(); break;
        }

        //kiem tra mang ket qua co rong khong
        if(luachon>=1 && luachon<=4){
            if(kq.size()==0)
                System.out.println("Khong tim thay bang luong can sua!!!");
            else{
                //tim thay
                //xuat ket qua
                System.out.println("Ket qua tim kiem :");
                int i = 0;
                for(Luong l : kq){
                    System.out.print((i++)+". "); l.xuat();
                    System.out.println("========================");
                }
                //sua
                //chon thu tu cua nhan vien can sua
                int stt;
                do{
                    System.out.println("Chon STT cua nhan vien muon sua");
                    stt = Integer.parseInt(sc.nextLine());
                }
                while(stt<0 || stt>=kq.size());
                
                //***nhap lua chon thong tin muon sua***
                int sua;
                Luong l = kq.get(stt);
                do{
                //menu thong tin can sua
                System.out.println("========MENU SUA========");
                System.out.println("1.Ho ten");
                if(l instanceof LuongChinhThuc){
                    System.out.println("2.So ngay cong");
                    System.out.println("3.Muc luong theo ngay");
                }
                else if(l instanceof LuongThoiVu){
                    System.out.println("2.So gio lam");
                    System.out.println("3.Muc luong theo gio");
                }
                System.out.println("4.Thanh toan");
                System.out.println("Nhap so khac de thoat !!!");
                //nhap lua chon
                System.out.print("Nhap lua chon:");
                sua = Integer.parseInt(sc.nextLine());
                //goi cac ham sua
                if(sua>=1 && sua<=4){
                    switch(sua){
                        case 1: l.setTen(); break;
                        case 2: 
                            if(l instanceof LuongChinhThuc)
                                suaSoNgayCong((LuongChinhThuc) l);
                            else if(l instanceof LuongThoiVu)
                                suaSoGio((LuongThoiVu) l);
                            break;
                        case 3:
                            if(l instanceof LuongChinhThuc)
                                suaMucLuongTheoNgay((LuongChinhThuc) l);
                            else if(l instanceof LuongThoiVu){
                                suaMucLuongTheoGio((LuongThoiVu) l);
                            }
                            break;
                        case 4: l.setThanhToan(); break;
                    }
                    System.out.println("Hien thi sau khi cap nhat:");
                    l.xuat();
                }
                else System.out.println("***Thoat***");
                }
                while(sua>=1 && sua<=4);
            }
        }
    }
        while(luachon>=1 && luachon<=4);
    }

    private void suaSoNgayCong(LuongChinhThuc l){
        int ngay;
        do{
            System.out.print("Nhap so ngay cong moi: ");
            ngay =  Integer.parseInt(sc.nextLine());
        }
        while(ngay<0);
        l.nv.setSoNgay(ngay);
        l.thue=l.tinhThue();
        l.thucLanh=l.tongLuong();
    }

    private void suaMucLuongTheoNgay(LuongChinhThuc l){
        int mucLuong;
        do{
            System.out.print("Nhap muc luong theo ngay moi: ");
            mucLuong =  Integer.parseInt(sc.nextLine());
        }
        while(mucLuong<0);
        l.nv.setMucLuongTheoNgay(mucLuong);
        l.thue=l.tinhThue();
        l.thucLanh=l.tongLuong();
    }

    private void suaSoGio(LuongThoiVu l){
        int gio;
        do{
            System.out.print("Nhap so gio moi: ");
            gio =  Integer.parseInt(sc.nextLine());
        }
        while(gio<0 || gio>24);
        l.nv.setSoGio(gio);
        l.thue=l.tinhThue();
        l.thucLanh=l.tongLuong();
    }

    private void suaMucLuongTheoGio(LuongThoiVu l){
        int mucLuong;
        do{
            System.out.print("Nhap muc luong theo gio moi: ");
            mucLuong =  Integer.parseInt(sc.nextLine());
        }
        while(mucLuong<0);
        l.nv.setMucLuongTheoGio(mucLuong);
        l.thue=l.tinhThue();
        l.thucLanh=l.tongLuong();
    }
}
