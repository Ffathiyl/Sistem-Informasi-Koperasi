import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static SLinkedListObat SLObat = new SLinkedListObat();
    static List<Transaksi> transaksiList = new ArrayList<>();
    static Main main = new Main();
    public static void main(String[] args) {
        main.Menu();
    }

    public static void Menu(){
        boolean running = true;
        while (running) {
            System.out.println("---------------------------------------------------");
            System.out.println("--------              Apotek               --------");
            System.out.println("---------------------------------------------------");
            System.out.println("1. CRUD Obat");
            //System.out.println("2. Lihat Data Obat");
            //System.out.println("3. Search Obat");
            System.out.println("2. Transaksi");
            System.out.println("3. View Transaksi");
            System.out.println("4. Exit");
            System.out.print("Pilihan: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1 -> crudObat();
                case 2 -> transaksi();
                case 3 -> viewDataTransaksi();
                case 4 -> running = false;
                default -> System.out.println("Pilihan tidak valid");
            }
        }
    }

    public static void crudObat(){
        System.out.println("---------------------------------------------------");
        System.out.println("--------               OBAT                --------");
        System.out.println("---------------------------------------------------");
        System.out.println("1. Tambah Obat");
        System.out.println("2. Lihat Data Obat");
        System.out.println("3. Update Obat");
        System.out.println("4. Delete Obat");
        System.out.println("5. Kembali");
        System.out.print("Pilih : ");
        int choice = input.nextInt();
        switch (choice){
            case 1 : inputObat(); break;
            case 2 : SLObat.display(); crudObat(); break;
            case 3 : UpdateObat(); break;
            case 4 : System.out.println("Delete Obat"); break;
            case 5 : Menu(); break;
            default : System.out.println("Pilihan tidak tepat!");
        }
    }

    public static void inputObat() {
        System.out.println("ID Obat: " + SLObat.idObat());
        input.nextLine();
        System.out.print("Nama Obat: ");
        String nama = input.nextLine();
        System.out.print("Merk Obat: ");
        String merk = input.nextLine();
        System.out.print("Harga Obat: ");
        double harga = input.nextDouble();
        System.out.print("Stock Obat: ");
        int stock = input.nextInt();

        Obat obat = new Obat(SLObat.idObat(), nama, merk, harga, stock);
        NodeObat nodeObat = new NodeObat(obat);
        System.out.println("1. AddFirst");
        System.out.println("2. AddLast");
        System.out.print("Pilih : ");
        int choose = input.nextInt();
        input.nextLine();
        switch (choose) {
            case 1 -> SLObat.addFirst(nodeObat);
            case 2 -> SLObat.addLast(nodeObat);
        }
        crudObat();
    }

    public static void UpdateObat(){
        System.out.print("Masukkan ID obat yang akan dibeli: ");
        int idObat = input.nextInt();
        input.nextLine();

        NodeObat nodeObat = SLObat.searchID(idObat);
        if (nodeObat != null){
            Obat obat = nodeObat.getObat();
            System.out.println("Data Obat ");
            System.out.println(obat);

            System.out.print("Masukkan nama obat baru: ");
            String namaObatBaru = input.nextLine();
            obat.setNamaObat(namaObatBaru);

            System.out.print("Masukkan merk obat baru: ");
            String merkObatBaru = input.nextLine();
            obat.setMerkObat(merkObatBaru);

            System.out.print("Masukkan harga obat baru: ");
            double hargaObatBaru = input.nextDouble();
            obat.setHarga(hargaObatBaru);

            System.out.print("Masukkan stok obat baru: ");
            int stokObatBaru = input.nextInt();
            obat.setStock(stokObatBaru);

            System.out.println("Data obat berhasil diupdate.");
            System.out.println("Data Obat Baru:");
            System.out.println(obat);
        } else {
            System.out.println("Obat dengan ID " + idObat + " tidak ditemukan.");
        }
    }

    public static void searchObatByID() {
        System.out.print("ID Obat yang dicari : ");
        int idObat = input.nextInt();
        input.nextLine();

        NodeObat nodeObat = SLObat.searchID(idObat);
        if (nodeObat != null) {
            System.out.println(nodeObat.getObat());
        }
    }

    public static void Transaksi(){
        SLObat.display();
        System.out.print("Nama Pelanggan : ");
        String namaPelanggan = input.nextLine();
    }
    public static void transaksi() {
        input.nextLine();
        SLObat.display();

        System.out.print("Masukkan nama pelanggan: ");
        String namaPelanggan = input.nextLine();

        System.out.print("Masukkan ID obat yang akan dibeli: ");
        int idObat = input.nextInt();
        input.nextLine();

        NodeObat nodeObat = SLObat.searchID(idObat);
        if (nodeObat != null) {
            Obat obat = nodeObat.getObat();
            System.out.print("Masukkan jumlah yang akan dibeli: ");
            int jumlah = input.nextInt();
            input.nextLine();

            if (obat.getStock() >= jumlah) {
                obat.setStock(obat.getStock() - jumlah);

                double hargaTotal = obat.getHarga() * jumlah;
                Transaksi transaksi = new Transaksi(namaPelanggan, obat, jumlah, hargaTotal);
                transaksiList.add(transaksi);

                System.out.println("Transaksi berhasil!");
                System.out.println("Pelanggan: " + namaPelanggan);
                System.out.println("Obat: " + obat.getNamaObat());
                System.out.println("Jumlah yang dibeli: " + jumlah);
                System.out.println("Harga total: " + hargaTotal);
            } else {
                System.out.println("Stok obat tidak mencukupi");
            }
        } else {
            System.out.println("Obat tidak ditemukan");
        }
    }

    public static void viewDataTransaksi() {
        System.out.println("Data Transaksi:");
        if (transaksiList.isEmpty()) {
            System.out.println("Tidak ada transaksi yang dilakukan");
        } else {
            for (Transaksi transaksi : transaksiList) {
                System.out.println("Pelanggan: " + transaksi.getPelanggan());
                System.out.println("Obat: " + transaksi.getObat().getNamaObat());
                System.out.println("Jumlah yang dibeli: " + transaksi.getJumlah());
                System.out.println("Harga total: " + transaksi.getHargaTotal());
                System.out.println("-------------------------------------");
            }
        }
    }
}