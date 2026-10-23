/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class BukuCetak extends Koleksi implements Terarsip {
    private int jumlahHalaman;
    private String nomorRak;
    private boolean sedangDiperbaiki;

    public BukuCetak(String kode, String judul, int tahun, int jmlHal, String rak, boolean diperbaiki) {
        super(kode, judul, tahun);
        this.jumlahHalaman = jmlHal;
        this.nomorRak = rak;
        this.sedangDiperbaiki = diperbaiki;
    }

    @Override
    public boolean cekLayakPinjam() {
        return !sedangDiperbaiki; // Layak jika tidak sedang diperbaiki
    }

    @Override
    public String nomorRak() { return nomorRak; }

    @Override
    public String lokasiLantai() {
        return "Lantai 1"; 
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + String.format(" - Buku Cetak: %d hal. %s. Perbaikan: %b", 
                jumlahHalaman, ringkasanArsip(), sedangDiperbaiki);
    }
}
