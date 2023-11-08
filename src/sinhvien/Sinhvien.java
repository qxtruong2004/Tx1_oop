package sinhvien;
import java.util.Scanner;
public class Sinhvien {
          private int ID;
          private String Ten;
          private double Diem;

    public Sinhvien() {
    }
    public Sinhvien(int ID, String Ten, double Diem) {
        this.ID = ID;
        this.Ten = Ten;
        if(Diem < 0)  this.Diem = 0;
        else  this.Diem = Diem;
    }

    public int getID() {
        return ID;
    }

    public String getTen() {
        return Ten;
    }

    public double getDiem() {
        return Diem;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public void setDiem(double Diem) {
        if(Diem < 0)  this.Diem = 0;
        else  this.Diem = Diem;
    }

    @Override
    public String toString() {
        return "Sinhvien{" + "ID=" + ID + ", Ten=" + Ten + ", Diem=" + Diem + '}';
    }
        public double hocbong() {
            if(Diem >= 9) return 200;
            else if(8 <= Diem && Diem < 9) return 100;
            else return 0.0;
        }
        public static void main(String[] args) {
            Scanner sn = new Scanner (System.in);
            Sinhvien sv[] = new Sinhvien [100];
            int count = 0;
            int result;
            do{
                System.out.println("****CHUONG TRINH QUAN LY SINH VIEN****");
                System.out.println("1. Them 1 sinh vien moi");
                System.out.println("2. Tim 1 sinh vien theo ten");
                System.out.println("3. Xoa 1 sinh vien theo ten ");
                System.out.println("4. In ra danh sach sinh vien");
                System.out.println("5. Update 1 sinh vien theo ID");
                System.out.println("6. Thoat khoi chuong trinh");
                int choice;
            System.out.println("Moi nhap su lua chon cua ban: "); 
            choice = sn.nextInt();
            switch (choice){
                case 1 -> {
                    int id;
                    String name;
                    double diem;
                    System.out.println("THEM 1 SINH VIEN MOI");
                    System.out.println("Nhap ID cho sinh vien: ");  id = sn.nextInt();
                    sn.nextLine();
                    System.out.println("Nhap TEN cho sinh vien: "); name = sn.nextLine();
                    System.out.println("Nhap DIEM cho sinh vien: "); diem = sn.nextDouble();
                    Sinhvien newSinhvien = new Sinhvien(id, name, diem);
                    sv [count] = newSinhvien;
                    count ++;
                    }
                case 2 -> {
                    System.out.println("TIM 1 SINH VIEN THEO TEN");
                    String findname;
                    sn.nextLine();
                    System.out.println("Nhap ten sinh vien can tim kiem: ");
                    findname = sn.nextLine();
                    int res = 0;
                    for(int i = 0; i < count; i++){
                        if(findname.equals(sv[i].getTen())){
                            System.out.println("Tim thay sinh vien co ma ten"+ findname);
                            System.out.println(sv[i].toString());
                            res += 1;
                        }
                    }
                    if(res == 0) System.out.println("Khong co sinh vien nao co ID nhu vay");
                    }
                case 3 -> {
                    System.out.println("XOA 1 SINH VIEN THEO ID");
                    int deleteid;
                    System.out.println("Moi ban nhap ID sinh vien ban can xoa: ");
                    sn.nextLine();
                    deleteid = sn.nextInt();
                    int ret= 0;
                    for(int i = 0; i < count; i++){
                        if(deleteid == sv[i].getID()){
                            sv[i] = sv[i+1];
                            ret += 1;
                            count--;
                        }
                    }
                    if(ret ==  0) System.out.println("Khong co sinh vien nao co ma nhu vay");
                    else System.out.println("Da xoa thanh cong");
                    }
                case  4 -> { 
                    System.out.println("THONG TIN DANH SACH SINH VIEN");
                    for(int i = 0; i < count; i++ ){
                        System.out.println(sv[i].toString());
                    }
                    }
                case 5 -> { 
                    System.out.println("UPDATE SINH VIEN THEO ID");
                    int repairid;
                    System.out.println("Moi ban nhap id sinh vien can chinh sua: ");
                    repairid = sn.nextInt();
                    int rets = 0;
                    for(int i = 0; i < count; i++){
                        if(repairid == sv[i].getID()){
                            rets += 1;
                            int Id;
                            String Name;
                            double Diem;
                            System.out.println("Nhap ID cho sinh vien: ");  Id = sn.nextInt();
                            sn.nextLine();
                            System.out.println("Nhap TEN cho sinh vien: "); Name = sn.nextLine();
                            System.out.println("Nhap DIEM cho sinh vien: "); Diem = sn.nextDouble();
                            sv[i].setDiem(Diem);
                            sv[i].setID(Id);
                            sv[i].setTen(Name);
                        }
                    }
                    if(rets == 0) System.out.println("Khong co sinh vien nao co ma nhu vay de cap nhat");
                    else System.out.println("Cap nhat thanh cong");
                    }
                case 6 -> {
                    System.out.println("EXIT ");
                    System.exit(0);
                    }
                default -> System.out.println("GIA TRI KHONG HOP LE");
            }
            System.out.println("Ban co muon dung tai day khong, nhan 0 neu OK");
            result = sn.nextInt();
            }
            while(result != 0);
    }
}
