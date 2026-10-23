/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author LENOVO
 */
import model.*;
import Layanan.*;
import eksepsi.*;

public class Main {
    public static void main(String[] args) {
        KatalogPerpustakaan katalog = new KatalogPerpustakaan();
        
        katalog.tambahKoleksi(new BukuCetak("BK-001", "Java How to Program", 2022, 620, "rak A-12", false));
        katalog.tambahKoleksi(new BukuCetak("BK-002", "Basis Data Relasional", 2021, 410, "rak B-04", true)); // diperbaiki
        katalog.tambahKoleksi(new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026, "88", "Agustus", "rak M-1", true)); // edisi terbaru
        katalog.tambahKoleksi(new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026, "87", "Juli", "rak M-1", false));
        katalog.tambahKoleksi(new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024, 15, "unduh.polmed.ac.id/bd001"));
        katalog.tambahKoleksi(new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025, 8, "unduh.polmed.ac.id/bd002"));

        System.out.println("SEBELUM DIURUTKAN");
        katalog.cetakStatus();
        
        katalog.urut(new UrutLayakLaluJudul());
        System.out.println("SETELAH DIURUTKAN (Layak Pinjam -> Judul)");
        katalog.cetakStatus();

        System.out.println("TES PEMINJAMAN");
        Koleksi bukuLayak = katalog.getDaftar().get(0); 
        Koleksi bukuTidakLayak = katalog.getDaftar().get(5); 

        try {
            katalog.pinjam(bukuLayak);
        } catch (PustakaException ex) {
            System.out.println("GAGAL: " + ex.getMessage());
        }

        try {
            katalog.pinjam(bukuLayak);
        } catch (PustakaException ex) {
            System.out.println("GAGAL: " + ex.getMessage());
        }

        try {
            katalog.pinjam(bukuTidakLayak);
        } catch (PustakaException ex) {
            System.out.println("GAGAL: " + ex.getMessage());
        }
        
        System.out.println();

        EksporKatalog.ekspor(katalog.getDaftar(), "katalog.txt");
    }
}