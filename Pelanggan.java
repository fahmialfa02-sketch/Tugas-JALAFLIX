import java.util.LinkedList;

public abstract class Pelanggan implements LayananPelanggan {
    protected String kodePelanggan;
    protected String nama;
    protected String noTelpon;
    protected int umur;
    protected boolean statusAktif;
    protected LinkedList<Film> history; // Menggunakan LinkedList agar mudah hapus data terlama

    public Pelanggan(String kodePelanggan, String nama, String noTelpon, int umur) throws UmurNegatifException {
        if (umur < 0) {
            throw new UmurNegatifException("Umur tidak boleh negatif!");
        }
        this.kodePelanggan = kodePelanggan;
        this.nama = nama;
        this.noTelpon = noTelpon;
        this.umur = umur;
        this.statusAktif = true;
        this.history = new LinkedList<>();
    }

    // Method Abstrak wajib diimplementasikan anak-anaknya
    public abstract void cekAksesKatalog();

    @Override
    public void nontonFilm(Film film) {
        if (!statusAktif) {
            System.out.println("Maaf, status keanggotaan Anda tidak aktif.");
            return;
        }

        System.out.println(this.nama + " sedang menonton: " + film.getJudul());
        
        // Logika membatasi history maksimal 10
        if (history.size() >= 10) {
            history.removeFirst(); // Menghapus film terlama (FIFO)
        }
        history.addLast(film); // Menambahkan film terbaru
    }

    @Override
    public void tampilkanHistory() {
        System.out.println("--- History Tontonan " + this.nama + " ---");
        if (history.isEmpty()) {
            System.out.println("Belum ada history tontonan.");
        } else {
            for (int i = 0; i < history.size(); i++) {
                System.out.println((i + 1) + ". " + history.get(i).getJudul());
            }
        }
    }
}