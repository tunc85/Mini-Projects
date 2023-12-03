package calisan;

import java.util.Scanner;

public class CalisanRunner {
    public static void main(String[] args) { // runner
        System.out.println("******Uygulamaya Hosgeldiniz******"); //hosgeldin mesaji

        Scanner scan = new Scanner(System.in);//kullanicidan veri almamiz icin scanner class'ini cagirdik

        System.out.print("Personel numarasini giriniz:");// istek 1
        int no = scan.nextInt(); // girilen veri buraya saklanacak
        scan.nextLine(); // int bir degerden sonra string bir deger alacaksak bunu kullanabiliriz(Enter bug)

        System.out.print("Isım   giriniz:");// istek 2
        String isim = scan.nextLine(); // girelecek olan veri isim'in icinde

        System.out.print("Soy isim  giriniz:"); // istek 3
        String soyIsım = scan.nextLine(); // kullanicinin girecek oldugu veri String bir degiskenin icinde


        System.out.print("Tecrube yilini giriniz:");// istek 4
        int tecrube = scan.nextInt(); // veri tecrubenin icinde

        System.out.print("Guncel maas tutarini giriniz:"); // istek 5
        double maas = scan.nextDouble();// veri maas'in icinde
        System.out.println("");// gorsel duzeltme amaciyla gorunmez bir bosluk


        Calisan calisan1 = new Calisan(no, tecrube, isim, soyIsım, maas); // calisan clasi cagirdik
        // parametreli calisan clasindaki fieldlerimizin icini burada girdiklerimizle doldurduk




        int secim; // secim ' adinda bir degisken olusturduk menu arayuzu olusturmak icin
        do { // menunun 3 seceneginden birini isaretledikten sonra kod calismaya devam etsin diye do-while loop kullandim.
            System.out.println("Menü:"); // arayuz
            System.out.println("1. Çalışan bilgilerini göster");//Consturctor olusturmustuk bununla alakali.
            System.out.println("2. Zam yap");// Zam yap constructorunu kullanabilmek icin arayuzde bahsettik
            System.out.println("3. Format at");// format at constructor'u
            System.out.println("0. Çıkış");// menuden cikis icin verdigimiz secenek
            System.out.println("Seçiminizi yapınız: ");// buradanda yukaridakilerden hangisini istiyorsun diye sorduk.
            secim = scan.nextInt();//kullanicinin secenegini aldik
            scan.nextLine(); // Enter'i yutmasi icin bunu kullandim.

            switch (secim) {// switch-case-break ile olasi 4 senaryomu olusturacagim.
                case 1:// arayuz 1. secenek
                    // Çalışan bilgilerini göster
                    calisan1.calisanBilgileriniGoster(); // calisanbilgileri icin consturctorumuzun icindeki sout methodunu kullandik.
                    break; // 1 e basilirsa donguyu kir yeni bir dongu baslat.(calisan bilgilerini return et)
                case 2:// arayuz 2. secenek
                    // Zam yap
                    System.out.println("Zam değerini giriniz:");
                    int zamDegeri = scan.nextInt();// Zam yapacaksak ne kadar yapacagimizi secebilmemiz icin kullanicidan zam tutarini istedik.
                    scan.nextLine();//int sonrasi string alacagim icin enter'i yutmasi icin bunu kullandim.
                    calisan1.zamYap(zamDegeri);// zam yap constuctorumuzun icindeki method neydi? // (maas+zamDegeri)
                    break;//2 ye basilirsa donguyu kir guncel maasi return et
                case 3://arayuz 3 .secenek
                    // Format at
                    System.out.println("Kim format atacak ismini giriniz:");
                    String kisi = scan.nextLine();//formatlayacak kisinin adi
                    System.out.println("İşletim sistemini yazınız:");
                    String isletimSistemi = scan.nextLine();//hangi isletim sistemini kullandigi
                    calisan1.formatAt(isletimSistemi + " ", kisi + " ");//format at constructorumuzun icinde ne vardi? isletim sistemi + kim
                    break;//3 e basilirsa format bilgisini return et donguyu kir.
                case 0:// 0 a basilirsa cikis uyarisi ver ve donguyu kir.
                    // Çıkış
                    System.out.println("Programdan çıkılıyor."); // uyari
                    break;//donguyu kir.
                default: // eger bunlarin haricinde bir durum olursa default degere don ve donguyu kir.
                    System.out.println("Lütfen belirtilen aralıkta değer seçimi yapınız.");
                    break;
            }

        } while (secim != 0); // dongu 0 olmadigi surece dongu surekli devam edecek (cikis icin case:0) yapmamizin mantigi bu.

        scan.close();//clean cod icin scannerimizi kapadik.
    }//runner(main)sonu
}//class sonu









