public class PengirimanUdara extends LayananPengiriman implements Asuransi, LacakKargo {
    private String noPenerbangan;
    private String statusSaatIni;
    private double nilaiBarang;

    PengirimanUdara(String noResi, double beratBarang, double jarakTempuh, String noPenerbangan, double nilaiBarang) {
        super(noResi, beratBarang, jarakTempuh);
        this.noPenerbangan = noPenerbangan;
        this.statusSaatIni = "Menunggu Jadwal Penerbangan";
        this.nilaiBarang = nilaiBarang;
    }

    @Override
    double hitungOngkosKirim(){
        return (this.beratBarang * 25000) + (this.jarakTempuh * 5000);
    }

    public double getNilaiBarang(){
        return this.nilaiBarang;
    }
    @Override
    public double hitungPremi(double nilaiBarang) {
        return nilaiBarang * 0.03;
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
