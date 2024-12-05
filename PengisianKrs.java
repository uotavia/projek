import java.util.Scanner;
public class PengisianKrs {
    static String arrKolom[]={"NIM", "Nama", "Kode MK", "Nama Mata Kuliah", "SKS"};
    static int jmlBaris = 0;
    static String arrKrs [][] = new String[1][5];
    static int[] arrSks = new int[1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Sistem Pemantauan KRS Mahasiswa ===");
        System.out.println("1. Tambah data KRS \n2. Tampilkan daftar KRS mahasiswa");
        System.out.println("3. Analisis Data KRS \n4. Keluar");
        System.out.print("Pilih menu: ");
        String menu = sc.nextLine();

        switch (menu) {
            case "1":
                TambahKrs();
                break;
            case "2":
                TampilKrs();
                break;
            case "3":
                FilterKrs();
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
    static void TambahKrs(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n-- TAMBAH DATA KRS --");
        System.out.println("*masukkan nama 'batal123' jika ingin membatalkan aksi tambah.");
        System.out.print("Nama mahasiswa  : ");
        String nama = sc.nextLine();
        if (nama.equals("batal123")) {
            System.out.println();
            main(null);
        }
        System.out.print("NIM mahasiswa   : ");
        String nim = sc.nextLine();
        System.out.print("Kode mata kuliah: ");
        String jenis = sc.nextLine();
        System.out.print("Jumlah SKS (1-3): ");
        int tahun = sc.nextInt();

        
        //mengubah ukuran array
        if (jmlBaris == arrKrs.length) {
            String[][] tempArr = new String[arrKrs.length + 1][5];
            int[] tempTahun = new int[arrSks.length + 1]; 
            
            //salin data array lama
            for (int i = 0; i < arrKrs.length; i++) {
                tempArr[i] = arrKrs[i];
            }
            for (int i = 0; i < arrSks.length; i++) {
                tempTahun[i] = arrSks[i];
            }
            //ganti array
            arrKrs = tempArr; 
            arrSks = tempTahun;  
        }
        
        arrKrs[jmlBaris][0] = nama;
        arrKrs[jmlBaris][1] = nim;
        arrKrs[jmlBaris][2] = jenis;
        arrSks[jmlBaris] = tahun; 
    
        jmlBaris++; 
    
        System.out.println("Data berhasil ditambahkan!");
        main(null);

    }
    static void TampilKrs(){
        System.out.println("\n-- SEMUA KRS MAHASISWA --");
        if (jmlBaris == 0) {
            System.out.println("Tidak ada data KRS.\n");
        } else {

            for (int i = 0; i < jmlBaris; i++) {
                // for ()
                for (int j = 0; j < arrKolom.length; j++) {
                    System.out.print(arrKrs[i][j] + " | ");
                }
                System.out.print(arrSks[i]);
                System.out.println();
            }
        }
        main(null); 
    }
    static void FilterKrs(){
        
    }
}
