public class KartuKredit extends Pembayaran implements Keamanan {
    private String nomorKartu;

    KartuKredit(String namaPembayar, double nominal, String nomorKartu) {
        super(namaPembayar, nominal);
        this.nomorKartu = nomorKartu;
    }

    @Override    
    public void prosesPembayaran(){
        double admin = 0.02 * this.nominal;
        System.out.println("Total Tagihan: " + (admin + this.nominal));
    }
    @Override
    public boolean autentikasi() {
        System.out.println("Autentikasi PIN berhasil!");
        return true;
    }

    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.println("Nomor Kartu  : " + nomorKartu);
    }
}
