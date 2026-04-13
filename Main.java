public class Main {
    public static void main(String[] args) {
        try {
            // 1. Membuat Objek Film
            Film f1 = new Film("The Matrix", GenreFilm.SCIFI, 1999, 13, "Hacker Neo discovers...", "Reguler");
            Film f2 = new Film("Avatar 2", GenreFilm.ACTION, 2022, 13, "Return to Pandora...", "New");
            Film f3 = new Film("JalaFlix Exclusive", GenreFilm.DRAMA, 2023, 18, "Only on JalaFlix", "Original Series");
            
            // Tes Exception Tahun (Uncomment untuk test)
            // Film fError = new Film("Old Movie", GenreFilm.DRAMA, 1799, 13, "...", "Reguler");

            // 2. Membuat Objek Pelanggan
            Pelanggan pReguler = new PelangganReguler("P001", "Budi", "08123", 20);
            Pelanggan pGold = new PelangganGold("P002", "Siti", "08124", 25);
            Pelanggan pPlatinum = new PelangganPlatinum("P003", "Andi", "08125", 30);
            
            // Tes Exception Umur (Uncomment untuk test)
            // Pelanggan pError = new PelangganReguler("P004", "ErrorUser", "081", -5);

            System.out.println("\n--- TES AKSES KATALOG ---");
            pReguler.cekAksesKatalog();
            pGold.cekAksesKatalog();
            pPlatinum.cekAksesKatalog();

            System.out.println("\n--- TES NONTON FILM ---");
            pReguler.nontonFilm(f1); // Sukses
            pReguler.nontonFilm(f2); // Gagal (Daftar New)
            
            pGold.nontonFilm(f2); // Sukses
            pGold.nontonFilm(f3); // Gagal (Original Series)

            pPlatinum.nontonFilm(f3); // Sukses

            System.out.println("\n--- TES HISTORY (Max 10) ---");
            // Simulasi Budi menonton banyak film agar history > 10
            for(int i = 1; i <= 12; i++) {
                pPlatinum.nontonFilm(f1);
            }
            pPlatinum.tampilkanHistory(); // Hanya akan menampilkan 10 film terakhir

        } catch (UmurNegatifException | TahunTooOldException e) {
            System.err.println("Terjadi Error: " + e.getMessage());
        }
    }
}