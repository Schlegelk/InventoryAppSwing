package untar.java.tugas1;

public class TestProductModel {
    public static void main(String[] args) {
        ProductModel p = new ProductModel("001", "Baju", 25, 70000.0);

        System.out.println("Kode   : " + p.getCode());
        System.out.println("Nama   : " + p.getName());
        System.out.println("Qty    : " + p.getQty());
        System.out.println("Harga  : " + p.getPrice());
    }
}
