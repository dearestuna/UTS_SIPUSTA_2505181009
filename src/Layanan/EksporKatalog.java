
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
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;

public class EksporKatalog {
    public static void ekspor(List<Koleksi> daftar, String namaFile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(namaFile))) {
            writer.printf("%-10s | %-30s | %-5s | %s%n", "KODE", "JUDUL", "TAHUN", "STATUS LAYAK");
            writer.println("-".repeat(75));
            for (Koleksi k : daftar) {
                writer.printf("%-10s | %-30s | %-5d | %b%n",
                    k.getKodeKoleksi(), 
                    k.getJudul().length() > 30 ? k.getJudul().substring(0, 27) + "..." : k.getJudul(), 
                    k.getTahunTerbit(), 
                    k.cekLayakPinjam());
            }
            System.out.println("Berhasil mengekspor data ke file: " + namaFile);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis berkas: " + e.getMessage());
        }
    }
}
