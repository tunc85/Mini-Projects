package groupMiniProject;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Depo depoKayit = new Depo();
        depoKayit.urunTopluEkle();
        int secim;
        do{
            System.out.println("***Depo yönetimi projemize hoşgeldiniz***"); //   ("Rafta bulunan urunden daha fazla cikis yapilamaz ");
            System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz"); //  hata mesajı alındıktan sonra tekrar hosgeldin yazdirilmasin .
            System.out.println("Işlem seçeneklerimiz aşağıda sıralanmıştır"); //  İLK 3 A , SON 6 B LİSTESİ ŞEKLİNDE OLSUN
            System.out.println("1. Urun Tanımlama");
            System.out.println("2. Urun Listele");
            System.out.println("3. Urun Girişi");
            System.out.println("4. Urunu Rafa Koy");
            System.out.println("5. Urun Cikisi");
            System.out.println("6. Sistemden Cikis");

            secim=scanner.nextInt();
            switch (secim){
                case 1:
                    //urunTanımlama
                    depoKayit.urunTanimlama();
                    depoKayit.urunListele();
                    break;
                case 2:
                    //urunListele
                    depoKayit.urunListele();
                    break;
                case 3:
                    //urunGirisi
                    depoKayit.urunGirisi();
                    depoKayit.urunListele();
                    break;
                case 4:
                    //urunuRafaKoy
                    depoKayit.urunuRafaKoy();
                    depoKayit.urunListele();
                    break;
                case 5:
                    //urunCikisi
                    depoKayit.urunCikisi();
                    depoKayit.urunListele();
                    break;
                case 6:
                    System.out.println("Sistemden çıkılıyor..");
                    break;
                default:
                    System.out.println("Hatali bir secim yaptiniz.\n" +
                            "Lutfen gecerli bir secim yapiniz.");
                    break;
            }
        }while(secim!=6);



    }
}