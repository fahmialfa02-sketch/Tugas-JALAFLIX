public class PelangganReguler extends Pelanggan {
    public PelangganReguler(String kode, String nama, String noTelpon, int umur) throws UmurNegatifException {
        super(kode, nama, noTelpon, umur);
    }

    @Override
    public void cekAksesKatalog() {
        System.out.println(nama + " (Reguler) memiliki akses ke: Daftar Reguler");
    }
    
    // Polimorfisme: Override method nontonFilm untuk membatasi akses
    @Override
    public void nontonFilm(Film film) {
        if (film.getKategoriDaftar().equalsIgnoreCase("Reguler")) {
            super.nontonFilm(film);
        } else {
            System.out.println("Akses Ditolak: Pelanggan Reguler tidak dapat menonton film kategori " + film.getKategoriDaftar());
        }
    }
}
