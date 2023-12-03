package aracSigortaApp;

import java.util.Scanner;

/* Tarife dönemi:Aralık 2023,Haziran 2023
         1.dönem :Haziran 2023               2.dönem:Aralık 2023
         otomobil: 2000                       otomobil: 2500
         kamyon:   3000                       kamyon:   3500
         otobüs: tip1: 4000 tip2: 5000        otobüs: tip1: 4500 tip2: 5500
         motosiklet: 1500                     motosiklet: 1750
*/
public class Arac {
    public String type;//otobus
    public int prim;//tarife doneme gore prim

    //5. prim hesaplama
    public void hesaplaPrim(int donem){
        //tipine gore hesaplama
        switch (this.type){
            case "otomobil":
                this.prim=donem==1?2000:2500;
                break;
            case "kamyon":
                this.prim=donem==1?3000:3500;
                break;
            case "otobüs":
                hesaplaOtobusPrim(donem);
                break;
            case "motosiklet":
                this.prim=donem==1?1500:1700;
                break;
            default:
                System.out.println("hatali giris!");
                this.prim=0;
                break;

        }

    }

    public void hesaplaOtobusPrim(int donem) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Otobüs tipini seciniz");
        System.out.println("1. 18-30 arasi koltuk sayisi");
        System.out.println("2. 31 ve uzeri koltuk sayisi");
        int otobusTipi= scan.nextInt();
        switch (otobusTipi){
            case 1:
                this.prim=donem==1?4000:4500;
                break;
            case 2:
                this.prim=donem==1?5000:5500;
                break;
            default:
                System.out.println("hatali giris!");
                this.prim=0;
                break;
        }

    }
}


