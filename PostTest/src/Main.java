import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<LayananPengiriman> daftar = new ArrayList<>();
        daftar.add(new PengirimanDarat("DRT-001", 50.0, 100.0, "tronton"));
        daftar.add(new PengirimanUdara("UDR-999", 10.0, 800.0, "GA-123",   5000000.0));
        ((LacakKargo) daftar.get(0)).updateStatus("Sedang di jalan tol Cipali");
        ((LacakKargo) daftar.get(1)).updateStatus("Transit di Bandara Soekarno-Hatta");

        for(LayananPengiriman i : daftar){
            System.out.println();
            i.cetakResi();
            if(i instanceof LacakKargo){
                System.out.println(((LacakKargo) i).cekLokasiTerakhir());
            }

            double ongkir = i.hitungOngkosKirim();
            double totalTagihan = ongkir;

            if(i instanceof Asuransi){
                Asuransi As = (Asuransi) i;
                As.cetakPolis();

                double nilaiBarang = ((PengirimanUdara) i).getNilaiBarang();
                double premi = As.hitungPremi(nilaiBarang);

                totalTagihan = ongkir + premi;
                System.out.println("Ongkos Kirim   : Rp"+ ongkir);
                System.out.println("Premi Asuransi : Rp" + premi);
            } else {
                System.out.println("Ongkos Kirim   : Rp" + ongkir);
            }
            System.out.println("Total Tagihan  : Rp" + totalTagihan);
        }
        System.out.println();
    }

}
