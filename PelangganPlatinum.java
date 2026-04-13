public class PelangganPlatinum extends Pelanggan {
    public PelangganPlatinum(String kode, String nama, String noTelpon, int umur) throws UmurNegatifException {
        super(kode, nama, noTelpon, umur);
    }

    @Override
    public void cekAksesKatalog() {
        System.out.println(nama + " (Platinum) memiliki akses ke: Semua Daftar (Reguler, New, Original Series)");
    }

    @Override
    public void nontonFilm(Film film) {
        // Platinum bebas nonton apa saja
        super.nontonFilm(film);
    }
}