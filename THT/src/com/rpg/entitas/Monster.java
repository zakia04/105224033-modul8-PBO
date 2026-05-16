package com.rpg.entitas;
import com.rpg.arena.Karakter; //mengimpor kelas karakter dari package arena
//subclass monster mewarisi kelas karakter
public class Monster extends Karakter {
    private String jenisMonster; //atribut tambahan untuk jenis monster
    //konstruktor untuk inisialisasi atribut monster
    public Monster(String nama, int hp, int baseDamage, String jenisMonster) {
        super(nama, hp, baseDamage); //memanggil konstruktor dari superclass karakter
        this.jenisMonster = jenisMonster;
    }
    @Override //override method bertahan untuk monster
    public void bertahan(){
        this.hp += 15; //monster memulihkan HP sebesar 15 saat bertahan
        System.out.println("Monster memulihkan HP!");
    }
    @Override //override method serang untuk monster
    public int serang(){ //mengembalikan nilai baseDamage
        return getBaseDamage();
    }
    @Override //override method gunakanItem untuk monster
    public void gunakanItem(){ //karena tdk bisa menggunakna item jdi hanya mencetak pesan
        System.out.println("Monster tidak bisa menggunakan item!");
    }

    @Override // implementasi dari abstract metode karakter, menampilkan nama, hp , jenis monster
    public void tampilkanStatus(){
        System.out.println("Nama: " + getNama());
        System.out.println("HP: " + getHp());
        System.out.println("Jenis Monster: " + this.jenisMonster);
    }



}
