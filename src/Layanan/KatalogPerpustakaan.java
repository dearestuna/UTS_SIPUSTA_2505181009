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
import eksepsi.*;
import java.util.*;

public class KatalogPerpustakaan {
    private List<Koleksi> daftarKoleksi = new ArrayList<>();

    public void tambahKoleksi(Koleksi k) {
        daftarKoleksi.add(k);
    }

    public List<Koleksi> getDaftar() {
        return daftarKoleksi;
    }

    // Soal 3: Polimorfik tanpa instanceof
    public void cetakStatus() {
        System.out.println("=== STATUS KOLEKSI PERPUSTAKAAN ===");
        for (Koleksi k : daftarKoleksi) {
            System.out.println(k.deskripsi() + " | Status Layak: " + (k.cekLayakPinjam() ? "YA" : "TIDAK"));
        }
        System.out.println();
    }

    // Soal 4: Method urut menerima Comparator
    public void urut(Comparator<Koleksi> c) {
        daftarKoleksi.sort(c);
    }

    // Soal 5: Method pinjam dengan custom exceptions
    public void pinjam(Koleksi k) throws PustakaException {
        if (k.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException(
                "Maaf, koleksi '" + k.getJudul() + "' saat ini sedang dipinjam oleh orang lain."
            );
        }
        if (!k.cekLayakPinjam()) {
            throw new KoleksiTidakLayakException(
                "Koleksi '" + k.getJudul() + "' tidak dapat dipinjam (sedang diperbaiki atau edisi terbaru)."
            );
        }
        k.setSedangDipinjam(true);
        System.out.println("SUKSES: Berhasil meminjam '" + k.getJudul() + "'");
    }
}
