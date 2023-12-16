package groupMiniProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Depo {

    public List<Urun> urunList;
    Scanner scanner = new Scanner(System.in);

    public Depo() {

        this.urunList = new ArrayList<>() ;
    };
    //depoya ürün ekleme
    public void urunEkle(Urun urun){
        urunList.add(urun);

    }

    //urunTanimlama==>  urunun ismi, ureticisi ve birimi girilecek. id  alınacak. (miktar 0) (raf null)
    public void urunTanimlama() {
        System.out.println("Urun tanımlama  id, urunun ismi, ureticisi ve birimi girin ");
        System.out.println("id giriniz");
        int id=scanner.nextInt();
        System.out.println("Urun ismi giriniz");
        String urunIsim=scanner.next();
        System.out.println("Uretici ismi giriniz");
        String uretici=scanner.next();
        System.out.println("Birim giriniz");
        String birim=scanner.next();

        Urun product = new Urun(id, urunIsim, uretici, 0, birim,null);
        urunList.add(product);
    }

    //urunListele==> tanimlanan urunler listelenecek. urunun adeti ve raf numarasi tanimlama yapilmadiysa default deger gorunsun.
    public void urunListele() {
        System.out.printf("%-8s%-12s%-15s%-12s%-12s%-8s%n", "ID", "ISIM", "URETICI", "MIKTAR", "BIRIM", "RAF");
        System.out.println("---------------------------------------------------------------");
        for (Urun product : urunList) {
            System.out.printf("%-8s%-12s%-15s%-12s%-12s%-8s%n", product.id, product.urunIsmi, product.uretici, product.miktar, product.birim, product.raf);}
        System.out.println();
    }
    //urunGirisi==> giris yapmak istedigimiz urnunun id numarasi ile girecegiz.
    public void urunGirisi() {
        System.out.println("Urun girişi için id giriniz \t==> id:");
        int id=scanner.nextInt();
        System.out.println("Urun miktarı giriniz ");
        int girilenMiktar = scanner.nextInt();
        for (Urun product : urunList) {
            if (product.getId() == id) {
                product.setMiktar(product.getMiktar() + girilenMiktar);
                break;
            }
        }
    }

    //urunuRafaKoy ==> listeden urunu sececegiz ve id numarasina gore urunu rafa koyacagiz
//    public void urunuRafaKoy(int id, String raf) { //1.yol
//        for (Urun product : urunList) {
//            if (product.getId() == id) {
//                product.setRaf(raf);
//                break;
//            }
//        }
//    }

    public void urunuRafaKoy() {  //2.yol
        System.out.print("Urun ID: ");
        int id = scanner.nextInt();
        System.out.print("Raf: ");
        String raf = scanner.next();

        for (Urun urun : urunList) {
            if (urun.getId() == id) {
                urun.setRaf(raf);
                System.out.println("Urun rafa koyuldu. Raf: " + raf);
                return;
            }
        }

        System.out.println("Urun bulunamadi.");
    }
    //urunCikisi==> listeden urunu sececegiz ve urunun cikis yapcagiz. burada urun listesinden sadece miktarda degisiklik yapilacak.
    //urun adedi 0 dan az olamaz. 0 olunca urun tanimlamasi silinmesin. sadece miktari 0 olsun.
    public void urunCikisi() {
        System.out.println("Çıkışını yapmak isediğiniz ürünün id'sini giriniz ");
        int cikisId= scanner.nextInt();
        System.out.println("Çıkış yapılacak miktarı giriniz");
        int cikanMiktar= scanner.nextInt();

        for (Urun product : urunList) {
            int kalanMiktar = 0;
            if (product.getId() == cikisId) {
                kalanMiktar = product.getMiktar() - cikanMiktar;
                if (kalanMiktar <0 ) {
                    ;
                    System.out.println("Rafta bulunan urunden daha fazla cikis yapilamaz ");
                    break;
                } else if (kalanMiktar <= 0) {
                    product.setMiktar(0);
                    break;

                } else {
                    product.setMiktar(kalanMiktar);
                    break;
                }

            }
        }  }

    public void urunTopluEkle(){
        Urun ur1=new Urun(1,"Un","Hekimoglu",0,"Cuval","Raf1");
        Urun ur2=new Urun(2,"İrmik","Ankara",1,"Balya","Raf2");
        Urun ur3=new Urun(3,"Mercimek","Yayla",1,"Poset","Raf3");
        Urun ur4=new Urun(4,"Bulgur","Yayla",2,"Torba","Raf3");
        Urun ur5=new Urun(5,"K.Fasulye","Yayla",3,"Cuval","Raf3");
        Urun ur6=new Urun(6,"Nohut","Yayla",5,"Cuval","Raf3");
        Urun ur7=new Urun(7,"Pirinç","Yayla",8,"Cuval","Raf3");
        Urun ur8=new Urun(8,"Makarna","Ankara",13,"Cuval","Raf3");
        Urun ur9=new Urun(9,"Şehriye","Filiz",21,"Cuval","Raf3");
        Urun ur10=new Urun(10,"Şeker","Balküpü",34,"Cuval","Raf4");
        this.urunList.add(ur1);
        this.urunList.add(ur2);
        this.urunList.add(ur3);
        this.urunList.add(ur4);
        this.urunList.add(ur5);
        this.urunList.add(ur6);
        this.urunList.add(ur7);
        this.urunList.add(ur8);
        this.urunList.add(ur9);
        this.urunList.add(ur10);
    }

}
