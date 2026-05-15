public class PengirimanDarat extends LayananPengiriman implements LacakKargo {
    private String jenisTruk;
    private String statusSaatIni;

    PengirimanDarat(String noResi, double beratBarang, double jarakTempuh, String jenisTruk) {
        super(noResi, beratBarang, jarakTempuh);
        this.jenisTruk = jenisTruk;
        this.statusSaatIni = "Menunggu Kurir";
    }
    
    @Override
    public double hitungOngkosKirim(){
        double tarifDasar;
        tarifDasar = (this.beratBarang * 5000) + (this.jarakTempuh * 2000);
        if (jenisTruk.equalsIgnoreCase("Tronton")){
            tarifDasar += 150000;
        }
        return tarifDasar;
    }

    @Override
    public void updateStatus(String status) {
        this.statusSaatIni = status;
    }

    @Override
    public String cekLokasiTerakhir() {
        return "Status Terakhir: " + this.statusSaatIni;
    }
}
