package com.rpg.main;
//mengimpor kelas Monster dan Pahlawan dari package entitas
import com.rpg.entitas.Monster;
import com.rpg.entitas.Pahlawan;

import java.util.*; // Import Scanner untuk input pengguna

public class GameEngine {
    public static void main(String[] args){
        //scanner untuk input nama pahlawan
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nama pahlawan: ");
        String namaPahlawan = input.nextLine();

        Monster[] list = new Monster[3]; // Array untuk menyimpan 3 monster dengan jenis yg berbeda
        list[0] = new Monster("Mara", 100, 20, "Rendah");
        list[1] = new Monster("Tonberry", 150, 30, "Sedang");
        list[2] = new Monster("Bahamut", 200, 50, "Tinggi");
        //inisisasi objek pahlawan
        Pahlawan hero = new Pahlawan(namaPahlawan, 100, 20,50, 1);
        //outer loop untuk memanggil monster 1 per satu
        for (int i = 0; i < list.length; i++) {
            Monster monsterSaatIni = list[i]; 
            System.out.println("\nMonster baru muncul: " + monsterSaatIni.getNama() + "!");

            // inner loop sebagai Battle Loop selama HP > 0 
            while (hero.getHp() > 0 && monsterSaatIni.getHp() > 0) {
                //menampilan status HP kedua pihak
                System.out.println("\n" + hero.getNama() + " HP: " + hero.getHp());
                System.out.println(monsterSaatIni.getNama() + " HP: " + monsterSaatIni.getHp());
                //menampilkan opsi aksi untuk pahlawan
                System.out.println("Pilih Aksi:");
                System.out.println("1. Serang");
                System.out.println("2. Skill (Mana: 20)");
                System.out.println("3. Bertahan / Heal");
                System.out.print("Pilihan: ");
                int pilihan = input.nextInt();

                int damageDealt = 0; //variable untuk menampung damage pahlawan

                // Switch case untuk opsi aksi 
                switch (pilihan) {
                    case 1:
                        // serangan dasar dan hasilnya dikirim ke monster
                        damageDealt = hero.serang();
                        monsterSaatIni.terimaDamage(damageDealt);
                        System.out.println(hero.getNama() + " menyerang dan memberikan " + damageDealt + " damage!");
                        break;
                    case 2:
                        //metode overloading untuk skill dengan nama dan mana cost
                        damageDealt = hero.serang("Tebasan Maut", 20);
                        if (damageDealt > 0) {
                            monsterSaatIni.terimaDamage(damageDealt);
                            System.out.println("Skill berhasil! Memberikan " + damageDealt + " damage!");
                        }
                        break;
                    case 3:
                        //bertahan atau memulihkan HP dengan menggunakan item
                        hero.bertahan();
                        hero.gunakanItem();
                        break; 
                    default:
                        System.out.println("Aksi tidak valid!");
                        break;                
                    }

                // giliran Monster membalas jika HP > 0
                if (monsterSaatIni.getHp() > 0) {
                    int damageMonster = monsterSaatIni.serang();
                    hero.terimaDamage(damageMonster);
                    System.out.println(monsterSaatIni.getNama() + " membalas dengan " + damageMonster + " damage!");
                } else {
                    System.out.println(monsterSaatIni.getNama() + " telah dikalahkan!");
                }
            }

            // jika pahlawan kalah di tengah jalan, hentikan for loop
            if (hero.getHp() <= 0) break;
        }

        // penentuan akhir permainan 
        if (hero.getHp() > 0) { //jika HP pahlawan > 0 setelah melawan semua monster
            System.out.println("\nSelamat! " + hero.getNama() + " berhasil menamatkan Dungeon.");
        } else {
            System.out.println("\nGAME OVER!" + hero.getNama() + " telah gugur.");
        }

        input.close(); //menutup scanner
    }
}    


