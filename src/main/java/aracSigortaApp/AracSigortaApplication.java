package aracSigortaApp;

        /*
        Proje: Araç Sigorta Prim Hesaplama
               Araç tipleri:otomobil, kamyon, otobüs, motosiklet
                            -otobüs: 18-30 koltuk veya 31 ve üstü koltuk
        ​
               Tarife dönemi:Aralık 2023,Haziran 2023
                  1.dönem :Haziran 2023               2.dönem:Aralık 2023
                  otomobil: 2000                       otomobil: 2500
                  kamyon:   3000                       kamyon:   3500
                  otobüs: tip1: 4000 tip2: 5000        otobüs: tip1: 4500 tip2: 5500
                  motosiklet: 1500                     motosiklet: 1750
        ​
                1-Tekrar tekrar kullanılan bir seçim menüsü(form) gösterelim.
                2-Tarife dönemi bilgisi,araç tipi bilgilerini kullanıcıdan alalım.
                3-Hatalı girişte hesaplama başarısız uyarısı verip tekrar menü(form) gösterilsin.
                4-Menüde yeni işlem veya çıkış için seçenek sunulsun .
                5-tarife dönemi ve araç tipine göre sigorta primi hesaplansın.
         */


import java.util.Scanner;

public class AracSigortaApplication {
    public static void main(String[] args) {
        //1. uygulumayi baslatan bir method
        start();
    }
    public static void start(){
        //2.kullanicidan bilgi alma
        Scanner input=new Scanner(System.in);
        boolean isAgain;

        //3. tekrar tekrar menü gosterilicek
        do {
            System.out.println("--Zorunlu Araç Sigorta Primi Hesaplama--");
            System.out.println("Tarife dönemi seciniz: ");
            System.out.println("1. Haziran 2023");
            System.out.println("2. Aralık 2023");
            int donem=input.nextInt();
            String donemBilgi=donem==1?"Haziran 2023":"Aralık 2023";
            //tarife donemi dogru girilirse isleme devam et hatali ise uyari mesaji ver yeniden forma gonder
            if (donem==1||donem==2){
                //4. arac objesini olusturduk
                Arac arac=new Arac();//default
                System.out.println("Arac tipini seciniz: ");
                System.out.println("otomobil, kamyon, otobüs, motosiklet");
                arac.type=input.next();
                arac.hesaplaPrim(donem);
                //prim=0 ise hatali giris yeni islem
                //prim>0 ise hesaplama basarili sonucu goruntule
                if (arac.prim>0){
                    System.out.println("---------------------------------");
                    System.out.println("Arac tipi: "+arac.type);
                    System.out.println("tarife donemi : "+donemBilgi);
                    System.out.println("Aracinizin ilgili donem sigorta primi : "+arac.prim);
                    System.out.println("----------------------------------");
                    System.out.println("yeni islem icin 1, cıkıs icin 0 seciniz");
                    int select=input.nextInt();
                    isAgain=select==1?true:false;

                }else {
                    System.out.println("Hesaplama islemi basarisiz, tekrar deneyiniz");
                    System.out.println("yeni islem icin 1, cikis icin 0 seciniz");
                    int select=input.nextInt();
                    isAgain=select==1?true:false;
                }

            }else {//hatali giriste
                System.out.println("hatali giriş!");
                isAgain=true;
            }


        }while (isAgain);
        System.out.println("iyi gunler");
    }




}



















