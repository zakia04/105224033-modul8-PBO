package com.rpg.arena;
//abstract class untuk karakter yang akan mengimplementasikan aksi bertarung (serang, bertahan, gunakanitem)
public abstract class Karakter implements AksiBertarung {
    //atribut menggunakan acces modifier protected agar bisa diakses oleh kelas turunannya (Pahlawan dan Monster)
    protected String nama;
    protected int hp;
    protected int baseDamage;
    protected boolean isDefending;
    //konstruktor untuk inisialisasi atribut karakter
    public Karakter(String nama, int hp, int baseDamage) {
        this.nama = nama;
        this.hp = hp;
        this.baseDamage = baseDamage;
    }
    //meotode menerima damahge dari lawan
    public void terimaDamage(int damage) {
        if (isDefending){ // Jika sedang bertahan, damage yang diterima berkurang setengah
            this.hp -= damage/2;
            this.isDefending = false; // Setelah menerima serangan, pertahanan kembali normal
        } else{ 
            this.hp -= damage;
        }
        //memastikan HP tidak boleh dibawah nol
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    //getter
    public String getNama() {
        return nama;
    }
    public int getHp() {
        return hp;
    }
    public int getBaseDamage() {
        return baseDamage;
    }
    public boolean isDefending() {
        return isDefending;
    }
    //setter
    public void setNama(String nama) {
        this.nama = nama;
    }   
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }
    public void setDefending(boolean defending) {
        isDefending = defending;
    }
    //metode abstrak untuk menampilkan status karakter, akan diimplementasikan di kelas turunannya
    public abstract void tampilkanStatus();
}
