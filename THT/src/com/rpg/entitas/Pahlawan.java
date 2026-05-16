package com.rpg.entitas;

import com.rpg.arena.Karakter; // import superclass Karakter
//pahlawan subclass karakter
public class Pahlawan extends Karakter {
    // atribut tambahan untuk pahlawan
    private int mana;
    private int level;

    public Pahlawan(String nama, int hp, int baseDamage, int mana, int level) {
        super(nama, hp, baseDamage); // panggil konstruktor superclass untuk inisialisasi atribut dasar
        this.mana = mana;
        this.level = level;
    }
    @Override
    public int serang() {
        return getBaseDamage() * level; // damage meningkat seiring level
    }
    //Overloading menggunakan nama skill dan biaya mana 
    public int serang(String namaSkill, int manaCost){
        if (this.mana >= manaCost) {
            this.mana -= manaCost; // kurangi mana sesuai biaya
            System.out.println(getNama() + " menggunakan skill " + namaSkill);
            return getBaseDamage() * level * 2; // skill memberikan damage lebih besar
        } else {
            System.out.println("Pesan Gagal! Mana tidak mencukupi.");
            return 0;
        }
    }
    @Override
    public void bertahan() { // override method bertahan untuk pahlawan
        this.isDefending = true; 
        System.out.println(getNama() + " Bersiaga!");
    }
    // implementasi method gunakanItem untuk pahlawan
    @Override
    public void gunakanItem() {
        this.hp += 30; //memulihkan HP saat menggunakan item
        System.out.println("HP pulih sekarang menjadi: " + this.hp);
    }
    @Override // override method tampilkanStatus untuk menampilkan status pahlawan
    public void tampilkanStatus() {
        System.out.println("HP: " + getHp());
        System.out.println("Mana: " + this.mana);
        System.out.println("Level: " + this.level);
    }


}
