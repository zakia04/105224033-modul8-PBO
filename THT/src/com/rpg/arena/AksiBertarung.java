package com.rpg.arena;
// Interface untuk aksi bertarung yang akan diimplementasikan oleh Pahlawan dann juga Monster
public interface AksiBertarung {
    public int serang(); //returnnya berupa nilai damage (int)
    public void bertahan(); //metode untuk bertahan
    public void gunakanItem(); //metode menggunakna item
}
