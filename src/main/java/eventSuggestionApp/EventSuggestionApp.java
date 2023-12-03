package eventSuggestionApp;

import java.util.Scanner;

public class EventSuggestionApp {
    public static void main(String[] args) {
        /*Kullanıcının girdiği sıcaklık durumuna göre aşağıda ki etkinlikleri öneren programı yazınız.

                Sıcaklık 5'den küçük ise "Kayak" yapmayı öner.
        Sıcaklık 5 ve 15 arasında ise "Tiyatro" etkinliğini öner.
        Sıcaklık 15 ve 25 arasında ise "Mangal" etkinliğini öner.
        Sıcaklık 25'ten büyük ise "Yüzme" etkinliğini öner.*/

        Scanner scan= new Scanner(System.in);//Kullanicidan veri alalim
        System.out.println("***Welcome to Event Recommendation App***");
        System.out.print("Please Enter Temperature Here : "); // dereceyi kullanici bunun onune yazacak
        int heat = scan.nextInt(); // yazilan deger Tempature: "sayi" seklinde print edilecek.
        String event= ""; // bos bir string event olusturduk icerigini assagida dolduracagiz.

        if (heat<5){ //eger sıcaklık 5 dereceden az ise
           event= "Ski";

        } else if (heat >=5 && heat <15) { //  sıcaklık 5(dahil)'ten kucuk degilse
            event="Theatre";
            
        } else if (heat>=15 && heat<25) { //   sicaklik 5 ve 15(dahil) derece arasinda degilse
            event="Barbecue";

        } else { // eger hicbiri degilse
            event="Swimming";


        }
        System.out.println("Recommended Activity: "+ event); // aciklayici bir sekilde cikti onerisi.

        scan.close();//scanneri kapat




    }//main sonu
}//class sonu
