package findArmStrongNumber;

public class armStrongNumberApp {
    public static void main(String[] args) {

        //Proje konusu girilen N sayinin bir Armstrong sayisi olup olmadigini bulan bir program yazalim
        /*Armstrong Sayısı
        N haneli bir sayının basamaklarının n’inci üstlerinin toplamı, sayının kendisine eşitse, böyle sayılara Armstrong sayı denir.

        Örneğin 407 sayısını ele alalım. (4^3)+ (0^3)+(7^3) = 64+0+343 = 407 sonucunu verir. Bu da 407 sayısının armstrong bir sayı olduğunu gösterir.

        1342 sayısına da bakalım. (1^4)+(3^4)+(4^4)+(2^4) =1+81+256+16=354 sayısı 1342’ye eşit olmadığı için armstrong sayı olmaz.

        1634=1^4+6^4+3^4+4^4=1+1296+81+256=1634

        54748=5^5+4^5+7^5+4^5+8^5=3125+1024+16807+1024+32768=54748

        Örnek Çıktı
        Sayı Giriniz : 407
        407 bir Armstrong Sayıdır.
        Sayı Giriniz : 303
        303 bir Armstrong Sayı Değildir. */


        //Sayinin Kac Basakmakli ? n sayisi elde et
        //Sayinin her bir basamagina nasil ulasirim?
        //Us alma islemini nasil yaparimm?

        //407/10=40.7
        //40/10=4.0
        //4/10=0.4
        //0 / 10=0

        /*int number=403427;
        int digitCount =0;
        int tempNumber =number;

        do {
            tempNumber=tempNumber / 10;
            System.out.println(tempNumber);
            digitCount++;

        }while (tempNumber!=0);
            System.out.println(digitCount);

        }*/


    }
}

