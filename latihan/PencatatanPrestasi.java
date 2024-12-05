import java.util.Scanner;

public class PencatatanPrestasi {
    //static final int MAX_DATA = 100; // Maksimum jumlah data
    static String[][] dataPrestasi = new String[100][6]; // Tambah kolom untuk golongan
    static int jumlahData = 0; // Jumlah data yang telah dimasukkan

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            tampilkanMenu();
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1 -> tambahData(scanner);
                case 2 -> tampilkanSemuaPrestasi();
                case 3 -> analisisPrestasi(scanner);
                case 4 -> System.out.println("Program selesai. Terima kasih!");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 4);
    }

    // Fungsi untuk menampilkan menu utama
    public static void tampilkanMenu() {
        System.out.println("\n=== PENCATATAN PRESTASI MAHASISWA ===");
        System.out.println("1. Tambah Data Prestasi");
        System.out.println("2. Tampilkan Semua Prestasi");
        System.out.println("3. Analisis Prestasi Berdasarkan Jenis");
        System.out.println("4. Keluar");
        System.out.print("Pilih menu: ");
    }

    // Fungsi untuk menambah data prestasi
    public static void tambahData(Scanner scanner) {
        if (jumlahData < 100) {
            System.out.print("Masukkan Nama Mahasiswa: ");
            dataPrestasi[jumlahData][0] = scanner.nextLine();

            System.out.print("Masukkan NIM Mahasiswa: ");
            dataPrestasi[jumlahData][1] = scanner.nextLine();

            System.out.print("Masukkan Jenis Prestasi (Juara 1/Juara 2): ");
            dataPrestasi[jumlahData][2] = scanner.nextLine();

            System.out.print("Masukkan Tingkat Prestasi (Lokal/Nasional/Internasional): ");
            dataPrestasi[jumlahData][3] = scanner.nextLine();

            System.out.print("Masukkan Tahun Prestasi (2010 - 2024): ");
            int tahun = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            if (tahun >= 2010 && tahun <= 2024) {
                dataPrestasi[jumlahData][4] = String.valueOf(tahun);

                // Tentukan golongan berdasarkan tingkat prestasi
                dataPrestasi[jumlahData][5] = tentukanGolongan(dataPrestasi[jumlahData][3]);

                jumlahData++;
                System.out.println("Data prestasi berhasil ditambahkan.");
            } else {
                System.out.println("Tahun tidak valid. Data tidak ditambahkan.");
            }
        } else {
            System.out.println("Data penuh! Tidak dapat menambah data lagi.");
        }
    }

    // Fungsi untuk menentukan golongan berdasarkan tingkat prestasi
    public static String tentukanGolongan(String tingkat) {
        return switch (tingkat.toLowerCase()) {
            case "internasional" -> "A";
            case "nasional" -> "B";
            case "lokal" -> "C";
            default -> "Tidak diketahui";
        };
    }

    // Fungsi untuk menampilkan semua data prestasi
    public static void tampilkanSemuaPrestasi() {
        if (jumlahData == 0) {
            System.out.println("Belum ada data prestasi.");
        } else {
            System.out.println("=== DAFTAR SEMUA PRESTASI ===");
            for (int i = 0; i < jumlahData; i++) {
                System.out.println("Nama: " + dataPrestasi[i][0] +
                                   " | NIM: " + dataPrestasi[i][1] +
                                   " | Jenis: " + dataPrestasi[i][2] +
                                   " | Tingkat: " + dataPrestasi[i][3] +
                                   " | Tahun: " + dataPrestasi[i][4] +
                                   " | Golongan: " + dataPrestasi[i][5]);
            }
        }
    }

    // Fungsi untuk analisis prestasi berdasarkan jenis
    public static void analisisPrestasi(Scanner scanner) {
        System.out.print("Masukkan Jenis Prestasi yang ingin dianalisis: ");
        String jenisDicari = scanner.nextLine();
        System.out.println("=== ANALISIS PRESTASI ===");
        boolean ditemukan = false;

        for (int i = 0; i < jumlahData; i++) {
            if (dataPrestasi[i][2].equalsIgnoreCase(jenisDicari)) {
                System.out.println("Nama: " + dataPrestasi[i][0] +
                                   " | NIM: " + dataPrestasi[i][1] +
                                   " | Jenis: " + dataPrestasi[i][2] +
                                   " | Tingkat: " + dataPrestasi[i][3] +
                                   " | Tahun: " + dataPrestasi[i][4] +
                                   " | Golongan: " + dataPrestasi[i][5]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada data dengan jenis tersebut.");
        }
    }
}
