package untar.java.tugas1;

public class TestProductTableModel {
    public static void main(String[] args) {
        ProductTableModel model = new ProductTableModel();

        // Tambah beberapa produk
        model.addProduct(new ProductModel("001", "Baju", 25, 70000.0));
        model.addProduct(new ProductModel("002", "Celana", 10, 120000.0));

        // Cek data via getValueAt
        for (int row = 0; row < model.getRowCount(); row++) {
            for (int col = 0; col < model.getColumnCount(); col++) {
                System.out.print(model.getValueAt(row, col) + "\t");
            }
            System.out.println();
        }
    }
}