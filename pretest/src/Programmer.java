class Programmer extends Karyawan {
    private double gajiPokok;
    Programmer(String nama, double gajiPokok) {
        super(nama);
        this.gajiPokok = gajiPokok;
    }

    public String getNama() {
        return nama;
    }
    public double getGajiPokok() {
        return gajiPokok;
    }

    @Override
    double hitungGaji() {
        return gajiPokok;
    }
}
