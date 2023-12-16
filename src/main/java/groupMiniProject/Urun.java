package groupMiniProject;
public class Urun {
    /*
     Calisan bir fabrikada uygulanan bir sistem olan depo uygulamasidir.
	 *
	 * 1-) burada oncelikle urunun tanimlamasi  yapilir.
	 id
	 urunIsmi
	 uretici
	 miktar
	 birim ve
	 raf (6 adet fields mevcut)

    */
    int id = 0;
    String urunIsmi;
    String uretici;
    int miktar = 0;
    String birim;
    String raf=null;

    public Urun(int id, String urunIsmi, String uretici, int miktar, String birim, String raf) {
        this.id = id;
        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.miktar = miktar;
        this.birim = birim;
        this.raf = raf;
    }
    public Urun(){

    }
    @Override
    public String toString() {
        return "Urun{" +
                "id=" + id +
                ", urunIsmi='" + urunIsmi + '\'' +
                ", uretici='" + uretici + '\'' +
                ", miktar=" + miktar +
                ", birim='" + birim + '\'' +
                ", raf='" + raf + '\'' +
                '}';
    }
    /*Getter kısmı*/
    public int getId() {
        return id;
    }

    public String getUrunIsmi() {
        return urunIsmi;
    }

    public String getUretici() {
        return uretici;
    }

    public int getMiktar() {
        return miktar;
    }

    public String getBirim() {
        return birim;
    }

    public String getRaf() {
        return raf;
    }


    /*Setter kısmı*/
    public void setId(int id) {
        this.id = id;
    }

    public void setUrunIsmi(String urunIsmi) {
        this.urunIsmi = urunIsmi;
    }

    public void setUretici(String uretici) {
        this.uretici = uretici;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }
}
