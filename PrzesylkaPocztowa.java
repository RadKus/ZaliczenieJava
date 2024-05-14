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
        //nie ma takiej potrzeby, wystarczy System.out.println(toString());
        System.out.println("Dane przesyłki ");
        System.out.println("Adresat: " + adresat);
        System.out.println("Adres " + adres);
        System.out.println("Identyfikator: " + numerID);
        System.out.println("Priorytet " + (priorytet? "Tak" : "Nie"));
        System.out.println("Waga " + waga);
        System.out.println("Status " + status);
    }

    //ta metoda nie powinna byc statyczna tylko powinna byc powiazana z obiektem na ktorym jest wolana
    //dodatkowo statusy 1,2,3 to sa magiczne liczby, to powinny byc albo 1) atrybuty private static final o wymownych nazwach
    // 2) odrebna klasa Enum ktora bedzie przechowywac inta jako wew. atrybut
    public static zwrocPelnyStatus () {
        if (status == 1) {
            System.out.println("nadana");
        } else if (status == 2) {
            System.out.println("w drodze");
        } else if (status == 3) {
            System.out.println("w doręczeniu");
        } else System.out.println("dostarczona");
    }

    //jw.
    //dodatkowo bardzo dobra praktyka w tego typu metodach jest zwrocenie nowego statusu
    //blok else daj po klamrach bedzie czytelniej
    //metoda zwrocPelnyStatus() jest voidem nie wiem czy dobra praktyka jest posiadanie voida w system out println
    public void ustawNastepnyStatus() {
        if (status < 5 && status > 0) {
            status ++;
            System.out.println("Aktualny status przesyłki" + zwrocPelnyStatus());
        } else System.out.println("Nie można zmienić statusu - przesyłka jest już dostarczona.");
    }

    //nie czytalem opisu zadania ale korzystanie z double/float do obliczania ceny to nie najlepszy pomysl jakos ze jest
    //tzw floating point np 0.1111 + 0.2222 != 0.3333 lepiej korzystac albo z BigDecimal albo wszystko traktowac jako grosze i pozniej tylko dzielic wynik / 100 i zaokraglic do 2 miejsc po przecinku
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
