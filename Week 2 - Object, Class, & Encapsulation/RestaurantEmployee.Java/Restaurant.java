public class Restaurant {
    private String[] namaMakanan;
    private double[] hargaMakanan;
    private int[] stok;
    private int id = 0;

    public Restaurant() {
        namaMakanan = new String[10];
        hargaMakanan = new double[10];
        stok = new int[10];
    }

    // Getter : untuk mengambil nilai atribut secara aman
    public String getNamaMakanan(int index) {
        return namaMakanan[index];
    }

    public double getHargaMakanan(int index) {
        return hargaMakanan[index];
    }

    public int getStok(int index) {
        return stok[index];
    }

    // Setter : untuk mengambil nilai atribut dengan kontrol/validasi
    public void setNamaMakanan(int index, String nama) {
        namaMakanan[index] = nama;
    }

    public void setHargaMakanan(int index, double harga) {
        hargaMakanan[index] = harga;
    }

    public void setStok(int index, int stokBaru) {
        if (stokBaru >= 0) {
            stok[index] = stokBaru;
        } else {
            System.out.println("Stok tidak boleh negatif!");
        }
    }

    public void tambahMenuMakanan(String nama, double harga, int stokAwal) {

        if (stokAwal < 0) {
            System.out.println("Stok tidak boleh negatif!");
            return;
        }

        setNamaMakanan(id, nama);
        setHargaMakanan(id, harga);
        setStok(id, stokAwal);
        id++;
    }

    // Tampil Menu
    public void tampilMenuMakanan() {
        for (int i = 0; i < id; i++) {

            if (getStok(i) > 0) {
                System.out.println(
                    getNamaMakanan(i) + " [" + getStok(i) + "] Rp. " + getHargaMakanan(i)
                );
            } else {
                System.out.println(
                    getNamaMakanan(i) + " [0 = HABIS] Rp. " + getHargaMakanan(i)
                );
            }
        }
    }

    // Pemesanan
    public void pesanMakanan(String nama, int jumlah) {

        for (int i = 0; i < id; i++) {

            if (getNamaMakanan(i).equalsIgnoreCase(nama)) {

                if (getStok(i) >= jumlah) {
                    setStok(i, getStok(i) - jumlah);
                    System.out.println("Pesanan berhasil!\nTotal bayar : Rp. " + 
                        (getHargaMakanan(i) * jumlah));
                } else {
                    System.out.println("Stok tidak mencukupi!");
                }

                return;
            }
        }

        System.out.println("Menu tidak ditemukan!");
    }
}


