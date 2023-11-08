import java.util.Scanner;

public class QuanLyNhanSu {
    Scanner sc = new Scanner(System.in);

    //menu chon loai doi tuong
    public int menuDoiTuong(){
        int luachon;
        System.out.println("=====MENU DOI TUONG======");
        System.out.println("Chon loai doi tuong can quan ly");
        System.out.println("1.Nhan vien");
        System.out.println("2.Bang luong");
        System.out.println("3.Phong ban");
        System.out.println("4.Du an");
        System.out.println("Nhap so khac de thoat!!!");
        luachon = Integer.parseInt(sc.nextLine());
        return luachon;
    }

    public void thaoTac(){
        int luachon;
        do{
            luachon = menuDoiTuong();
            switch (luachon){
                case 1: ; break;
                case 2: kq = timLoaiLuong(); break;
                case 3: kq = timThucLanh(); break;
                case 4: kq = timThanhToan(); break;
            }
            if(luachon <1 || luachon>4){
                System.out.println("****Hen gap lai****");
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
}
