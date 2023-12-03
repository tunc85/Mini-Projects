package taxiMeterApp;

import java.util.Scanner;

public class TaxiMeterApp {
    public static void main(String[] args) {
        /* Taksimetre tutarını hesaplayıp ekrana yazdıran programı yazın.

                Taksimetre kilometre başına 2.20 TL tutmaktadır.
        Kısa mesafe tutarı 20 TL'dir. 20 TL altında ki ücretlerde yine 20 TL alınacaktır.
        Taksimetre açılış ücreti 10 TL'dir.*/

        Scanner scan= new Scanner(System.in); // // kullanicidan bir veri alalim
        System.out.println("***Welcome to TaxiMeterApp***"); // hosgeldin mesaji
        System.out.println("Please enter kilometer of your destination.");//Kullanicidan istedigimiz veri(km)

        double km= scan.nextInt(); // kullanicinin girdigi km degiskenine yuklecek
        double price=10 +(km*2.20);//  double price=10 > taksimetre acilis // km*  km basi 2.20 tl
        // price = (price <20) ? 20 : price; seklindede yapabilirdik.
        if (price<20) // eger ucret 20 lira altindaysa,
            price = 20;{//20 return et.

        }
        System.out.println("Calculated amount: " + price);
        System.out.println("***Have a nice trip***");






    }
}
