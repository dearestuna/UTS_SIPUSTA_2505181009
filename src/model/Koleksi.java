/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public abstract class Koleksi {
    protected String kodeKoleksi;
    protected String judul;
    protected int tahunTerbit;
    protected boolean sedangDipinjam; 

    public Koleksi(String kodeKoleksi, String judul, int tahunTerbit) {
        this.kodeKoleksi = kodeKoleksi;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.sedangDipinjam = false;
    }

    public String getJudul() { return judul; }
    public String getKodeKoleksi() { return kodeKoleksi; }
    public int getTahunTerbit() { return tahunTerbit; }
    public boolean isSedangDipinjam() { return sedangDipinjam; }
    public void setSedangDipinjam(boolean status) { this.sedangDipinjam = status; }

    // Method abstract untuk kelayakan pinjam (Soal No. 1)
    public abstract boolean cekLayakPinjam();

    // Method deskripsi yang akan diperluas turunannya
    public String deskripsi() {
        return String.format("[%s] %s (%d)", kodeKoleksi, judul, tahunTerbit);
    }
}
