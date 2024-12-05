import java.util.Scanner;
public class siakad {
    static String arrKolom[]={"Nama", "Nim", "Jenis", "Tingkat", "Tahun"};
    static int jmlBaris = 0;
    static String arrPrestasi [][] = new String[1][5];
    static int[] arrTahun = new int[1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== PENCATATAN PRESTASI MAHASISWA ===");
        System.out.println("1. Tambah data prestasi \n2. Tampilkan semua prestasi");
        System.out.println("3. Filter prestasi \n4. Keluar");
        System.out.print("Pilih menu: ");
        String menu = sc.nextLine();

        switch (menu) {
            case "1":
                TambahPrestasi();
                break;
            case "2":
                TampilPrestasi();
                break;
            case "3":
                FilterPrestasi();
                break;
            case "4": break;
            default:
                System.out.print("Menu yang anda masukkan salah \n1. Kembali\n2. Keluar\nInput pilihan: ");
                String salah = sc.nextLine();
                switch (salah) {
                    case "1":
                        System.out.println();
                        main(args);
                        break;
                    case "2": break;
                    default:
                        System.out.println("Menu yang anda masukkan salah!");
                        break;
                }
                break;
        }
    }
    static void TambahPrestasi() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n-- TAMBAH PRESTASI MAHASISWA --");
        System.out.println("*masukkan nama 'batal123' jika ingin membatalkan aksi tambah.");
        System.out.print("Masukkan nama mahasiswa: ");
        String nama = sc.nextLine();
        if (nama.equals("batal123")) {
            System.out.println();
            main(null);
        }
        System.out.print("Masukkan NIM mahasiswa : ");
        String nim = sc.nextLine();
        System.out.print("Masukkan jenis prestasi: ");
        String jenis = sc.nextLine();
        System.out.print("Masukkan tingkat prestasi (Lokal/Nasional/Internasional): ");
        String tingkat = sc.nextLine();
        System.out.print("Masukkan tahun prestasi (2010-2024)\t\t\t: ");
        int tahun = sc.nextInt();

        
        //mengubah ukuran array
        if (jmlBaris == arrPrestasi.length) {
            String[][] tempArr = new String[arrPrestasi.length + 1][5];
            int[] tempTahun = new int[arrTahun.length + 1]; 
            
            //salin data array lama
            for (int i = 0; i < arrPrestasi.length; i++) {
                tempArr[i] = arrPrestasi[i];
            }
            for (int i = 0; i < arrTahun.length; i++) {
                tempTahun[i] = arrTahun[i];
            }
            //ganti array
            arrPrestasi = tempArr; 
            arrTahun = tempTahun;  
        }
        
        arrPrestasi[jmlBaris][0] = nama;
        arrPrestasi[jmlBaris][1] = nim;
        arrPrestasi[jmlBaris][2] = jenis;
        arrPrestasi[jmlBaris][3] = tingkat;
        arrTahun[jmlBaris] = tahun; 
    
        jmlBaris++; 
    
        System.out.println("Data berhasil ditambahkan!");
        main(null);
    }
    

    static void TampilPrestasi(){
        System.out.println("\n-- SEMUA PRESTASI MAHASISWA --");
        if (jmlBaris == 0) {
            System.out.println("Tidak ada data prestasi.\n");
        } else {
            for (int i = 0; i < jmlBaris; i++) {
                for (int j = 0; j < arrKolom.length; j++) {
                    System.out.print(arrKolom[j] + ": " + arrPrestasi[i][j] + " | ");
                }
                System.out.print(arrTahun[i]);
                System.out.println();
            }
        }
        main(null); 
    }
    static void FilterPrestasi(){
        System.out.println("belum tersedia");
    }
}