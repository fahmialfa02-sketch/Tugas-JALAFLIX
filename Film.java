public class Film {
    private String judul;
    private GenreFilm genre;
    private int tahun;
    private int kategoriUmur;
    private String sinopsis;
    private String kategoriDaftar; // "Reguler", "New", "Original Series"

    public Film(String judul, GenreFilm genre, int tahun, int kategoriUmur, String sinopsis, String kategoriDaftar) throws TahunTooOldException {
        if (tahun < 1800) {
            throw new TahunTooOldException("Tahun rilis film tidak boleh di bawah 1800!");
        }
        this.judul = judul;
        this.genre = genre;
        this.tahun = tahun;
        this.kategoriUmur = kategoriUmur;
        this.sinopsis = sinopsis;
        this.kategoriDaftar = kategoriDaftar;
    }

    public String getJudul() { return judul; }
    public String getKategoriDaftar() { return kategoriDaftar; }
    
    public void infoFilm() {
        System.out.println(judul + " (" + tahun + ") - " + genre + " | Kategori: " + kategoriDaftar);
    }
}