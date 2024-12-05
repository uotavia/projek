import java.util.Scanner;
public class PengisianKrs {
    static String arrKolom[]={"NIM \t", "Nama\t", "Kode MK", "Nama Mata Kuliah\t", "SKS\t"};
    static int jmlBaris = 0;
    static String arrKrs [][] = new String[1][4];
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
                FilterKrs(sc);
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
        }
        System.out.println();
    }
    static void TambahKrs(){
        int jmlSks = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n-- TAMBAH DATA KRS --");
        System.out.println("*masukkan NIM 'batal123' jika ingin membatalkan aksi tambah.");
        System.out.print("NIM mahasiswa   : ");
        String nim = sc.nextLine();
        if (nim.equals("batal123")) {
            System.out.println();
            main(null);
        }
        System.out.print("Nama mahasiswa  : ");
        String nama = sc.nextLine();
        boolean lagi = true;
        while (lagi) {
            System.out.print("Kode mata kuliah: ");
            String kode = sc.nextLine();
            System.out.print("Nama mata kuliah: ");
            String namaMK = sc.nextLine();
            System.out.print("Jumlah SKS (1-3): ");
            int sks = sc.nextInt(); sc.nextLine();
            if (sks>3||sks<0) {
                System.out.println("! jumlah SKS yang anda masukkan belum sesuai. \nMasukkan ulang jumlah SKS!");
                System.out.print("Jumlah SKS (1-3): ");
                sks = sc.nextInt(); sc.nextLine();
            }
            
            //mengubah ukuran array
            if (jmlBaris == arrKrs.length) {
                String[][] tempArr = new String[arrKrs.length + 1][4];
                int[] tempSks = new int[arrSks.length + 1]; 
                
                //salin data array lama
                for (int i = 0; i < arrKrs.length; i++) {
                    tempArr[i] = arrKrs[i];
                }
                for (int i = 0; i < arrSks.length; i++) {
                    tempSks[i] = arrSks[i];
                }
                //ganti array
                arrKrs = tempArr; 
                arrSks = tempSks;  
            }
                
            arrKrs[jmlBaris][0] = nim;
            arrKrs[jmlBaris][1] = nama;
            arrKrs[jmlBaris][2] = kode;
            arrKrs[jmlBaris][3] = namaMK;
            arrSks[jmlBaris] = sks; 
            jmlSks+=sks;

            System.out.print("Tambah mata kuliah lain? (y/t): ");
            String yt = sc.nextLine();
            if (yt.equalsIgnoreCase("y")) {
                jmlBaris++;
                lagi = true;
            }else if (yt.equalsIgnoreCase("t")) {
                break;
            }
        }
        jmlBaris++; 

        System.out.println("Data berhasil ditambahkan!");
        System.out.println("Total SKS yang diambil: "+jmlSks);
        System.out.println();
        main(null);
    }
    static void TampilKrs(){
        System.out.println("\n-- SEMUA KRS MAHASISWA --");
        if (jmlBaris == 0) {
            System.out.println("Tidak ada data KRS.");
        } else {
            for (int y = 0; y < arrKolom.length; y++){
                System.out.print(arrKolom[y]+ "|");
            }
            System.out.println();
            for (int i = 0; i < jmlBaris; i++) {
                for (int j = 0; j < arrKolom.length-1; j++) {
                    System.out.print(arrKrs[i][j] + "\t\t | ");
                }
                System.out.print(arrSks[i]);
                System.out.println();
            }
        }
        System.out.println();
        main(null); 
    }
    static void FilterKrs(Scanner sc){
        System.out.println("=== Analisis Data SKS === ");
        boolean ditemukan = false;
        System.out.print("Masukkan jenis SKS yang ingin dianalisis: ");
        String JenisDicari = sc.nextLine();

        for(int i = 0; i < jmlBaris; i++){
            if(arrKrs[i][2].equalsIgnoreCase(JenisDicari)){
                System.out.println("Nama: " + arrKrs[i][0] + " | NIM: " + arrKrs[i][1] + " | Jenis: " + arrKrs[i][2] + " | SKS: " + arrSks[i]);
                ditemukan = true;
            }


        }

        if (!ditemukan) {
            System.out.println("Tidak ada data dengan jenis tersebut.");
            
        }
        
        
    }
}
