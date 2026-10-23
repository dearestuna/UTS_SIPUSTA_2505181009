/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */

public class BerkasDigital extends Koleksi {
    private int ukuranMB;
    private String tautanUnduh;

    public BerkasDigital(String kode, String judul, int tahun, int ukuranMB, String tautanUnduh) {
        super(kode, judul, tahun);
        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
    }

    @Override
    public boolean cekLayakPinjam() {
        return true; // Selalu layak
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + String.format(" - Digital: %d MB, Link: %s", ukuranMB, tautanUnduh);
    }
}