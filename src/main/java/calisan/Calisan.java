package calisan;

public class Calisan {
// burada calisan class'imin degiskenlerini olusturdum herhangi bir deger atamasi yapmadim, cunku atamalari ben yapacagim.
    public int no;
    public int tecrube;
    public String isim;
    public String soyIsim;
    public double maas ;

    public Calisan(int no, int tecrube, String isim, String soyIsim, double maas) { //calisan icin parametreli bir constructor olusturdum
        //ve yukaridaki degiskenlerimin icine yuklenmesini sakladim.
        this.no = no;
        this.tecrube = tecrube;
        this.isim = isim;
        this.soyIsim = soyIsim;
        this.maas = maas;
    }

    public Calisan() { // hem parametreli hemde parametresiz bir calisan class 'i isimize yarayabilir.

    }

    public void calisanBilgileriniGoster(){ // calisanin bilgilerini gosterecek olan, degiskenlerimi kullanarak yazdirma islemi yapacak olan bir constructor olusturdum
        System.out.println("******Calisan Bilgileri******");
        System.out.println("NO       :"+no);
        System.out.println("Isim     :"+isim);
        System.out.println("SoyIsim  :"+soyIsim);
        System.out.println("Maas     :"+maas);
        System.out.println("Tecrube  :"+tecrube);

    }

    public void zamYap(int zamDegeri){ // zam degeri olusturma constructoru
        System.out.println("Maasiniza  +"+ zamDegeri + "TL zam yapildi");
        System.out.println("Suanki guncel maasiniz :" + (maas+zamDegeri)+"TL");
        return;
    }

    public void formatAt(String isletimSistemi,String kim){ // format atma constructoru
        System.out.println(kim + "suanda "+ isletimSistemi + "isletim sistemine format atiyor.");
    }


}
