package biletRezervasyonApp;
/*
project: Bilet Rezervasyon ve Bilet Fiyatı Hesaplama Uygulaması

        1-Uygulama mesafe ve kurallara göre otobüs bileti fiyatı hesaplar sonuç olarak bilet bilgisini verir
        2- Kullanıcıdan     mesafe (KM),
        yolcu yaşı ,
        yolculuk tipi (Tek Yön, Gidiş-Dönüş)
        ve koltuk no bilgilerini alınır.
        NOT: Koltuk numaraları 1-32 aralığında olmalıdır.)
        Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
        Aksi halde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.

        3-Fiyat hesaplama kuralları:
        -Mesafe başına ücret:
        Tek yön: 1 Lira / km       Çift Yön(Gidiş-Dönüş): 2 Lira/km
        -Tekli Koltuk ücreti:
        Koltuk no 3 veya 3 ün katı ise fiyat %20 daha fazladır(Tek yön: 1.2 Lira/km, Çift Yön:2.4 Lira/km).
        -İlk olarak seferin mesafe, yön ve koltuk no bilgisine göre fiyatı hesaplanır,
        sonrasında koşullara göre aşağıdaki indirimler uygulanır ;
        i)-Çift Yön indirimi:
        "Yolculuk Tipi" gidiş dönüş seçilmiş ise son bilet fiyatı üzerinden %20 indirim uygulanır.
        ii)-Yaş indirimi:
        Kişi 12 yaşından küçükse son bilet fiyatı üzerinden %50 indirim uygulanır.
        Kişi 65 yaşından büyük ise son bilet fiyatı üzerinden %30 indirim uygulanır.

        */

import java.util.Scanner;

public class BiletRezervasyonApp {
    public static void main(String[] args) {
        //1- bilet rezervasyonu yapabilmek icin bir otobuse ihtiyacimiz var
        Bus bus=new Bus("38 AB 123");
        //3- bilet objesini olusturalim
        Ticket bilet=new Ticket();
        //7-uygulamayi baslatma
        start(bus,bilet);
    }

    private static void start(Bus bus, Ticket bilet) {
        Scanner scan=new Scanner(System.in);
        int select;//cıkıs icin 5 secin;
        do {
            //8- kullanicidan bilgileri almaya baslayalim
            System.out.println("--Bilet Rezervasyon Sistemine Hosgeldiniz--");
            System.out.println("Lütfen yaşınızı Giriniz: ");
            int age= scan.nextInt();

            System.out.println("Lütfen gidilecek mesafe bilgisini KM olarak giriniz");
            double distance= scan.nextDouble();

            System.out.println("Lütfen yolculuk tipini seçiniz: ");
            System.out.println("1. Tek Yön");
            System.out.println("2. Gidiş-Dönüş");
            int type= scan.nextInt();

            System.out.println("Koltuk no seçiniz : ");
            System.out.println("Tekli koltuk ücreti %20 daha fazladır.");
            System.out.println(bus.seats);//mevcut koltuk nolari: 1,2,4,5
            String seat= scan.next();
            //secilen koltuk no listede var mi, rezerve edilmiş mi
            boolean isReserved=!bus.seats.contains(seat);
            if (isReserved){
                System.out.println("Seçilen koltuk rezerve edilmistir. ");
            }
            //girilen degerler gecerli mi
            if (age>0 && distance>0 && (type==1||type==2) && !isReserved){
                //koltuk no rezerve olucak o zmn napalim listeden cıkarmamız
                bus.seats.remove(seat);
                //bileti olusturalim
                bilet.distance=distance;
                bilet.typeNo=type;
                bilet.seatNo=seat;
                bilet.getTotalPrice(age);
                //bileti yazdiralim
                bilet.printTicket(bus);
            }else {
                System.out.println("Geçersiz giriş yaptınız.");
            }
            System.out.println("Yeni işlem icin bir sayi girin, CIKIŞ icin 5 giriniz:");
            select= scan.nextInt();

        }while (select!=5);
        System.out.println("iyi günler dileriz ve tekrar bekleriz <3");
    }
}
