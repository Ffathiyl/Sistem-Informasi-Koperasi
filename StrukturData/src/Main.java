import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static SLinkedListObat SLObat = new SLinkedListObat();
    static QueueTransaksi Transaksi = new QueueTransaksi();

    public static void main(String[] args) {
        Menu();
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

            if (input.hasNextInt()) {
                int choice = input.nextInt();
                switch (choice) {
                    case 1 -> crudObat();
                    case 2 -> Transaksi();
                    case 3 -> Transaksi.display();
                    case 4 -> running = false;
                    default -> System.out.println("Pilihan tidak valid");
                }
            } else {
                System.out.println("Inputan tidak valid!\nHanya Integer");
                input.nextLine();
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
        if (input.hasNextInt()) {
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> inputObat();
                case 2 -> {
                    SLObat.display();
                    crudObat();
                }
                case 3 -> UpdateObat();
                case 4 -> System.out.println("Delete Obat");
                case 5 -> Menu();
                default -> System.out.println("Pilihan tidak tepat!");
            }
        } else {
            System.out.println("Inputan tidak valid!\nHanya Integer");
            input.nextLine();
            crudObat();
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
        if (input.hasNextInt()) {
            int choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1 -> SLObat.addFirst(nodeObat);
                case 2 -> SLObat.addLast(nodeObat);
            }
            crudObat();
        } else {
            System.out.println("Inputan tidak valid!\nHanya Integer");
            input.nextLine();
            crudObat();
        }
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
        crudObat();
    }

    public static void Transaksi(){
        input.nextLine();
        SLObat.display();
        System.out.print("Nama Pelanggan : ");
        String namaPelanggan = input.nextLine();

        System.out.println("Masukkan ID obat yang akan dibeli");
        if (input.hasNextInt()) {
            int idObat = input.nextInt();
            input.nextLine();

            NodeObat nodeObat = SLObat.searchID(idObat);
            if (nodeObat != null) {
                Obat obat = nodeObat.getObat();
                System.out.println("Jumlah yang akan dibeli");
                int jumlah = input.nextInt();
                if (jumlah > 0) {
                    input.nextLine();

                    if (obat.getStock() >= jumlah) {
                        obat.setStock(obat.getStock() - jumlah);

                        double hargatotal = obat.getHarga() * jumlah;
                        Transaksi transaksi = new Transaksi(namaPelanggan, obat, jumlah, hargatotal);
                        NodeTransaksi nodeTransaksi = new NodeTransaksi(transaksi);
                        Transaksi.enqueue(nodeTransaksi);
                        System.out.println("Transaksi berhasil!");
                        System.out.println("Pelanggan: " + namaPelanggan);
                        System.out.println("Obat: " + obat.getNamaObat());
                        System.out.println("Jumlah yang dibeli: " + jumlah);
                        System.out.println("Harga total: " + hargatotal);
                    } else {
                        System.out.println("Stock tidak mencukupi");
                    }
                } else {
                    System.out.println("Harus lebih besar dari 0");
                }
            } else {
                System.out.println("Obat tidak ditemukan!");
            }
        } else {
            System.out.println("Inputan tidak valid!\nHanya Integer");
            input.nextLine();
        }
    }
}