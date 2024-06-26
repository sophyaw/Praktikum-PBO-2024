package PetShop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Barang {
    protected String nama;
    protected double harga;

    public Barang(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String namaBaru) {
        this.nama = namaBaru;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double hargaBaru) {
        this.harga = hargaBaru;
    }
}

class MakananHewan extends Barang {
    private String jenisHewan;

    public MakananHewan(String namaMakanan, double harga, String jenisHewan) {
        super(namaMakanan, harga);
        this.jenisHewan = jenisHewan;
    }

    public String getJenisHewan() {
        return jenisHewan;
    }

    public void setJenisHewan(String jenisHewan2) {
        this.jenisHewan = jenisHewan2;
    }

    @Override
    public String toString() {
        return "Makanan Hewan - Nama: " + getNama() + ", Harga: " + getHarga() + ", Jenis Hewan: " + jenisHewan;
    }
}

class Suplemen extends Barang {
    private String jenisHewan;

    public Suplemen(String namaSuplemen, double harga, String jenisHewan) {
        super(namaSuplemen, harga);
        this.jenisHewan = jenisHewan;
    }

    public String getJenisHewan() {
        return jenisHewan;
    }

    public void setJenisHewan(String jenisHewan2) {
        this.jenisHewan = jenisHewan2;
    }

    @Override
    public String toString() {
        return "Suplemen - Nama: " + getNama() + ", Harga: " + getHarga() + ", Jenis Hewan: " + jenisHewan;
    }
}

class AksesorisHewan extends Barang {
    private String jenisHewan;

    public AksesorisHewan(String namaAksesoris, double harga, String jenisHewan) {
        super(namaAksesoris, harga);
        this.jenisHewan = jenisHewan;
    }

    public String getJenisHewan() {
        return jenisHewan;
    }

    public void setJenisHewan(String jenisHewan2) {
        this.jenisHewan = jenisHewan2;
    }

    @Override
    public String toString() {
        return "Aksesoris Hewan - Nama: " + getNama() + ", Harga: " + getHarga() + ", Jenis Hewan: " + jenisHewan;
    }
}

public class PetShop {
    private static final List<Barang> daftarBarang = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            clearScreen();
            System.out.println("------------------------------------------");
            System.out.println("|    SELAMAT DATANG DI MOZAA PET SHOP    |");
            System.out.println("------------------------------------------");
            System.out.println("|                  MENU                  |");
            System.out.println("------------------------------------------");
            System.out.println("| 1. INPUT DAFTAR BARANG                 |");
            System.out.println("| 2. MENAMPILKAN DAFTAR BARANG           |");
            System.out.println("| 3. UPDATE DAFTAR BARANG                |");
            System.out.println("| 4. DELETE DAFTAR BARANG                |");
            System.out.println("| 5. EXIT                                |");
            System.out.println("------------------------------------------");
            System.out.print("Pilih Menu : ");
            int menu;
            while (true) {
                try {
                    menu = Integer.parseInt(scanner.nextLine());
                    if (menu <= 0) {
                        throw new NumberFormatException();
                    }
                    break; 
                    } 
                catch (NumberFormatException e) {
                    System.out.println("SILAHKAN PILIH MENU YANG TERSEDIA");
                    System.out.print("Pilih Menu : ");
                }
            }
            switch (menu) {
                case 1:
                    menuInput();
                    break;
                case 2:
                    tampilkanBarang();
                    break;
                case 3:
                    UpdateBarang();
                    break;
                case 4:
                    deleteBarang();
                    break;
                case 5:
                    clearScreen();
                    System.out.println("~ ~           THANK YOU           ~ ~");
                    System.out.println("~ ~       BY MOZAA PET SHOP       ~ ~");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("MENU TIDAK TERSEDIA");
                    scanner.nextLine();
            }
        }
    }

    private static void menuInput() {
        clearScreen();
        System.out.println("----------------------------");
        System.out.println("|      MOZAA PET SHOP      |");
        System.out.println("----------------------------");
        System.out.println("| 1. BARANG UMUM           |");
        System.out.println("| 2. MAKANAN HEWAN         |");
        System.out.println("| 3. SUPLEMEN              |");
        System.out.println("| 4. AKSESORIS             |");
        System.out.println("| 5. BACK TO MENU          |");
        System.out.println("----------------------------");
        System.out.print("Pilih Jenis Barang : ");
        int jenis;
            while (true) {
                try {
                    jenis = Integer.parseInt(scanner.nextLine());
                    if (jenis <= 0) {
                        throw new NumberFormatException(); 
                    }
                    break; 
                    } 
                catch (NumberFormatException e) {
                    System.out.println("SILAHKAN PILIH JENIS BARANG YANG TERSEDIA");
                    System.out.print("Pilih Jenis Barang : ");
                }
            }
        switch (jenis) {
            case 1:
                TambahBarang();
                break;
            case 2:
                TambahMakanan();
                break;
            case 3:
                TambahSuplemen();
                break;
            case 4:
                TambahAksesoris();
                break;
            case 5:
                return;
            default:
                System.out.println("PILIHAN TIDAK TERSEDIA");
                scanner.nextLine();
        }
    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error while clearing the screen: " + e.getMessage());
        }
    }
    
    private static void TambahBarang() {
        clearScreen();
        String nama;
        double harga;
        System.out.print("Nama Barang   : ");
        nama = scanner.nextLine().toUpperCase();
        while (true) {
            System.out.print("Harga Barang  : ");
            if (scanner.hasNextDouble()){
                harga = scanner.nextDouble();
                scanner.nextLine();            
                if (harga >= 10000) {
                    break;
                } else {
                    System.out.println("HARGA MINIMAL 10000");
                }
            } else {
                System.out.println("HARGA HARUS BERUPA ANGKA");
                scanner.nextLine();
            }
        }
        Barang barang = new Barang(nama, harga){};
        daftarBarang.add(barang);
        System.out.println("-------------------------------");
        System.out.println("BARANG BERHASIL DITAMBAHKAN");
        scanner.nextLine();
    }
    
    private static void TambahMakanan() {
        clearScreen();
        String nama , jenisHewan;
        double harga;
        System.out.print("Nama Makanan   : ");
        nama = scanner.nextLine().toUpperCase();
        while (true) {
            System.out.print("Harga Makanan  : ");
            if (scanner.hasNextDouble()){
                harga = scanner.nextDouble();
                scanner.nextLine();            
                if (harga >= 10000) {
                    break;
                } else {
                    System.out.println("HARGA MINIMAL 10000");
                }
            } else {
                System.out.println("HARGA HARUS BERUPA ANGKA");
                scanner.nextLine();
            }
        }            
        System.out.print("Jenis Hewan    : ");
        jenisHewan = scanner.nextLine().toUpperCase();
        MakananHewan makananHewan = new MakananHewan(nama, harga, jenisHewan);
        daftarBarang.add(makananHewan);
        System.out.println("--------------------------------------");
        System.out.println("MAKANAN HEWAN BERHASIL DITAMBAHKAN");
        scanner.nextLine();
    }
    
    private static void TambahSuplemen() {
        clearScreen();
        String nama, jenisHewan;
        double harga;
        System.out.print("Nama Suplemen   : ");
        nama = scanner.nextLine().toUpperCase();
        while (true) {
            System.out.print("Harga Suplemen  : ");
            if (scanner.hasNextDouble()){
                harga = scanner.nextDouble();
                scanner.nextLine();            
                if (harga >= 10000) {
                    break;
                } else {
                    System.out.println("HARGA MINIMAL 10000");
                }
            } else {
                System.out.println("HARGA HARUS BERUPA ANGKA");
                scanner.nextLine();
            }
        }
        System.out.print("Jenis Hewan     : ");
        jenisHewan = scanner.nextLine().toUpperCase();
        Suplemen suplemen = new Suplemen(nama, harga, jenisHewan);
        daftarBarang.add(suplemen);
        System.out.println("---------------------------------");
        System.out.println("SUPLEMEN BERHASIL DITAMBAHKAN");
        scanner.nextLine();
    }

    private static void TambahAksesoris() {
        clearScreen();
        String nama, jenisHewan;
        double harga;
        System.out.print("Nama Aksesoris  : ");
        nama = scanner.nextLine().toUpperCase();
        while (true) {
            System.out.print("Harga Aksesoris : ");
            if (scanner.hasNextDouble()){
                harga = scanner.nextDouble();
                scanner.nextLine();            
                if (harga >= 10000) {
                    break;
                } else {
                    System.out.println("HARGA MINIMAL 10000");
                }
            } else {
                System.out.println("HARGA HARUS BERUPA ANGKA");
                scanner.nextLine();
            }
        }
        System.out.print("Jenis Hewan     : ");
        jenisHewan = scanner.nextLine().toUpperCase();
        AksesorisHewan aksesorisHewan = new AksesorisHewan(nama, harga, jenisHewan);
        daftarBarang.add(aksesorisHewan);
        System.out.println("---------------------------------");
        System.out.println("AKSESORIS BERHASIL DITAMBAHKAN");
        scanner.nextLine();
    }

    private static void tampilkanBarang() {
        clearScreen();
        if (daftarBarang.isEmpty()) {
            System.out.println("MAAF, BARANG BELUM TERSEDIA");
        } else {
            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.println("|                                     MOZAA PET SHOP                                       |");
            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.printf("| %-2s | %-17s | %-20s | %-20s | %-17s |%n", "NO", "JENIS BARANG", "JENIS HEWAN", "NAMA", "HARGA");
            System.out.println("--------------------------------------------------------------------------------------------");
    
            int counter = 1;
            for (Barang barang : daftarBarang) {
                String jenis = "";
                String jenisHewan = "";
                if (barang instanceof MakananHewan) {
                    jenis = "MAKANAN";
                    jenisHewan = ((MakananHewan) barang).getJenisHewan();
                } else if (barang instanceof Suplemen) {
                    jenis = "SUPLEMEN";
                    jenisHewan = ((Suplemen) barang).getJenisHewan();
                } else if (barang instanceof AksesorisHewan) {
                    jenis = "AKSESORIS";
                    jenisHewan = ((AksesorisHewan) barang).getJenisHewan();
                } else {
                    jenis = "BARANG UMUM";
                    jenisHewan = "UMUM";
                }
    
                System.out.printf("| %-2d | %-17s | %-20s | %-20s | %-17.2f |%n", counter++, jenis, jenisHewan, barang.getNama(), barang.getHarga());
                System.out.println("--------------------------------------------------------------------------------------------");
            }
        }
        scanner.nextLine();
    }
    
    private static void UpdateBarang() {
        clearScreen();
        if (daftarBarang.isEmpty()) {
            System.out.println("MAAF, BARANG BELUM TERSEDIA");
            scanner.nextLine();
            return;
        }
        tampilkanBarang();
        double harga;
        int nomorToUpdate;
    
        while (true) {
            System.out.print("Update Barang Nomor    : ");
            String input = scanner.nextLine();
            try {
                nomorToUpdate = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("MASUKKAN NOMOR YANG VALID");
                continue;
            }
            if (nomorToUpdate < 1 || nomorToUpdate > daftarBarang.size()) {
                System.out.println("NOMOR BARANG TIDAK TERSEDIA");
                continue;
            } else {
                break;
            }
        }
        Barang barangToUpdate = daftarBarang.get(nomorToUpdate - 1);
        
        String namaBarang = "";
        if (barangToUpdate instanceof MakananHewan) {
            namaBarang = "Nama Makanan Terbaru   : ";
        } else if (barangToUpdate instanceof Suplemen) {
            namaBarang = "Nama Suplemen Terbaru  : ";
        } else if (barangToUpdate instanceof AksesorisHewan) {
            namaBarang = "Nama Aksesoris Terbaru : ";
        } else {
            namaBarang = "Nama Barang Terbaru    : ";
        }
    
        System.out.print(namaBarang);
        String namaBaru = scanner.nextLine().toUpperCase();
        barangToUpdate.setNama(namaBaru);
    
        while (true) {
            System.out.print("Harga Terbaru          : ");
            if (scanner.hasNextDouble()) {
                harga = scanner.nextDouble();
                scanner.nextLine();
                if (harga >= 10000) {
                    barangToUpdate.setHarga(harga);
                    break;
                } else {
                    System.out.println("HARGA MINIMAL 10000");
                }
            } else {
                System.out.println("HARGA HARUS BERUPA ANGKA");
                scanner.nextLine();
            }
        }
    
        if (barangToUpdate instanceof MakananHewan || barangToUpdate instanceof Suplemen || barangToUpdate instanceof AksesorisHewan) {
            System.out.print("Jenis Hewan Terbaru    : ");
            String jenisHewan = scanner.nextLine().toUpperCase();
            if (barangToUpdate instanceof MakananHewan) {
                ((MakananHewan) barangToUpdate).setJenisHewan(jenisHewan);
            } else if (barangToUpdate instanceof Suplemen) {
                ((Suplemen) barangToUpdate).setJenisHewan(jenisHewan);
            } else {
                ((AksesorisHewan) barangToUpdate).setJenisHewan(jenisHewan);
            }
        }
        System.out.println("--------------------------------------");
        System.out.println("BARANG BERHASIL DIUPDATE");
        scanner.nextLine();
    }
    
    private static void deleteBarang() {
        clearScreen();
        if (daftarBarang.isEmpty()) {
            System.out.println("MAAF, BARANG BELUM TERSEDIA");
            scanner.nextLine();
            return;
        }
        tampilkanBarang();
        int nomorToDelete;
        while (true) {
            System.out.print("Hapus Barang Nomor : ");
            String input = scanner.nextLine();
            try {
                nomorToDelete = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("MASUKKAN NOMOR YANG VALID");
                continue;
            }
    
            if (nomorToDelete < 1 || nomorToDelete > daftarBarang.size()) {
                System.out.println("NOMOR BARANG TIDAK TERSEDIA");
                continue;
            } else {
                break;
            }
        } 
        Barang barangToDelete = daftarBarang.remove(nomorToDelete - 1);
        System.out.println("[" + barangToDelete.getNama() + "]" + " BERHASIL DIHAPUS");
        scanner.nextLine();
    }
}
