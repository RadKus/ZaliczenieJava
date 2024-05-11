public class PrzesylkaPocztowa {
    private String adresat;
    private String adres;
    private String numerID;
    private boolean priorytet;
    private double waga;
    private int status;

    public PrzesylkaPocztowa(String adresat, String adres, String numerID, boolean priorytet, double waga, int status) {
        this.adresat = adresat;
        this.adres = adres;
        this.numerID = numerID;
        this.priorytet = priorytet;
        this.waga = waga;
        this.status = 1;
    }

    public String getAdresat() {
        return adresat;
    }

    public String getAdres() {
        return adres;
    }

    public String getNumerID() {
        return numerID;
    }

    public boolean isPriorytet() {
        return priorytet;
    }

    public double getWaga() {
        return waga;
    }

    public int getStatus() {
        return status;

    }


    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "PrzesylkaPocztowa{" +
                "adresat='" + adresat + '\'' +
                ", adres='" + adres + '\'' +
                ", numerID='" + numerID + '\'' +
                ", priorytet=" + priorytet +
                ", waga=" + waga +
                ", status=" + status +
                '}';
    }
    public void wyswietl() {
        System.out.println("Dane przesyłki ");
        System.out.println("Adresat: " + adresat);
        System.out.println("Adres " + adres);
        System.out.println("Identyfikator: " + numerID);
        System.out.println("Priorytet " + (priorytet? "Tak" : "Nie"));
        System.out.println("Waga " + waga);
        System.out.println("Status " + status);
    }

    public static zwrocPelnyStatus () {
        if (status == 1) {
            System.out.println("nadana");
        } else if (status == 2) {
            System.out.println("w drodze");
        } else if (status == 3) {
            System.out.println("w doręczeniu");
        } else System.out.println("dostarczona");
    }

    public void ustawNastepnyStatus() {
        if (status < 5 && status > 0) {
            status ++;
            System.out.println("Aktualny status przesyłki" + zwrocPelnyStatus());
        } else System.out.println("Nie można zmienić statusu - przesyłka jest już dostarczona.");
    }

    public double obliczCene() {
    double cena = 0;
    if (waga <= 0.5) {
        cena = 7.80d;
    } else if (waga <= 1) {
        cena = 8.30d;
    } else if (waga <= 2) {
        cena = 15.60;
    } else {
        cena = 15.6 + (waga - 2) * waga;
    }
    if (priorytet) {
        cena+= 3.0;
    }
    return cena;
    }

}
