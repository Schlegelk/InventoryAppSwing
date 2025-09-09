package untar.java.tugas1;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ProductTableModel extends AbstractTableModel {
    private final ArrayList<ProductModel> products;
    private final String[] columnNames = {"Kode", "Nama", "Qty", "Harga"};

    public ProductTableModel() {
        products = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return products.size();
    }
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProductModel p = products.get(rowIndex);
        switch (columnIndex) {
            case 0: return p.getCode();
            case 1: return p.getName();
            case 2: return p.getQty();
            case 3: return p.getPrice();
            default: return null;
        }
    }
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    // Method untuk tambah produk
    public void addProduct(ProductModel p) {
        products.add(p);
        int row = products.size() - 1;
        fireTableRowsInserted(row, row);
    }

    // Method untuk hapus produk
    public void removeProduct(int index) {
        if (index >= 0 && index < products.size()) {
            products.remove(index);
            fireTableRowsDeleted(index, index);
        }
    }

    public ArrayList<ProductModel> getProducts() {
        return products;
    }
}
