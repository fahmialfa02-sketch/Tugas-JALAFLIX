public class PelangganGold extends Pelanggan {
    public PelangganGold(String kode, String nama, String noTelpon, int umur) throws UmurNegatifException {
        super(kode, nama, noTelpon, umur);
    }

    @Override
    public void cekAksesKatalog() {
        System.out.println(nama + " (Gold) memiliki akses ke: Daftar Reguler & Daftar New");
    }

    @Override
    public void nontonFilm(Film film) {
        if (film.getKategoriDaftar().equalsIgnoreCase("Reguler") || film.getKategoriDaftar().equalsIgnoreCase("New")) {
            super.nontonFilm(film);
        } else {
            System.out.println("Akses Ditolak: Pelanggan Gold tidak dapat menonton Original Series.");
        }
    }
}
