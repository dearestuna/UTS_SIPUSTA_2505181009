/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Layanan;

/**
 *
 * @author LENOVO
 */
import model.Koleksi;
import java.util.Comparator;

public class UrutLayakLaluJudul implements Comparator<Koleksi> {
    @Override
    public int compare(Koleksi k1, Koleksi k2) {
        boolean layak1 = k1.cekLayakPinjam();
        boolean layak2 = k2.cekLayakPinjam();
        
        // Prioritaskan yang layak pinjam (true lebih dulu dari false)
        if (layak1 && !layak2) return -1;
        if (!layak1 && layak2) return 1;
        
        // Jika sama-sama layak atau sama-sama tidak, urutkan berdasarkan judul abjad
        return k1.getJudul().compareToIgnoreCase(k2.getJudul());
    }
}
