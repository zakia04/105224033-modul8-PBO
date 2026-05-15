import java.util.ArrayList;
public class Main {
    public static void main(String[] args){
        ArrayList<Pembayaran> daftar = new ArrayList<>();
        daftar.add(new KartuKredit("Zakia", 100000, "1234-5678"));
        daftar.add(new Ewallet("Zakia", 500000, "08123456789"));

        for (Pembayaran i : daftar) {
            i.tampilkanDetail();
            if (i instanceof Keamanan){
                ((Keamanan) i).autentikasi();
                i.prosesPembayaran();
            }
            System.out.println();

        }
    }


}
