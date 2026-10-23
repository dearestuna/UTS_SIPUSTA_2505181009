/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */

public class Majalah extends Koleksi implements Terarsip {
    private String edisi;
    private String bulanTerbit;
    private String nomorRak;
    private boolean edisiTerbaru;

    public Majalah(String kode, String judul, int tahun, String edisi, String bulan, String rak, boolean terbaru) {
        super(kode, judul, tahun);
        this.edisi = edisi;
        this.bulanTerbit = bulan;
        this.nomorRak = rak;
        this.edisiTerbaru = terbaru;
    }

    @Override
    public boolean cekLayakPinjam() {
        return !edisiTerbaru; // Layak apabila bukan edisi terbaru
    }

    @Override
    public String nomorRak() { return nomorRak; }

    @Override
    public String lokasiLantai() {
        return "Lantai 2"; 
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + String.format(" - Majalah: Edisi %s (%s). %s. Terbaru: %b", 
                edisi, bulanTerbit, ringkasanArsip(), edisiTerbaru);
    }
}
