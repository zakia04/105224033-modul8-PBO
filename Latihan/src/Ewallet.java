public class Ewallet extends Pembayaran implements Keamanan {
    private String nomorHP;

    Ewallet(String namaPembayar, double nominal, String nomorHP) {
        super(namaPembayar, nominal);
        this.nomorHP = nomorHP;
    }

    @Override
    public void prosesPembayaran() {
        System.out.println("Total Tagihan: " + this.nominal);
    }

    @Override
    public boolean autentikasi() {
        System.out.println("Autentikasi berhasil!");
        return true;
    }

    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.println("Nomor HP     : " + nomorHP);
    }

    
}
