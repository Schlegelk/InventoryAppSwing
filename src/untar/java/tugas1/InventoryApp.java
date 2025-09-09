package untar.java.tugas1;

import javax.swing.*;
import java.awt.*;

public class InventoryApp extends JFrame {
    private final ProductTableModel tableModel;
    private JTable table;

    private JTextField txtCode;
    private JTextField txtName;
    private JTextField txtPrice;
    private JTextField txtQty;

    private JButton btnAdd;
    private JButton btnRemove;

    public InventoryApp() {
        super("Inventory App (Memory Only)");

        tableModel = new ProductTableModel();

        initUI();
        initActions();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720, 520);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initUI() {
        // Form Input
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 5));

        txtCode = new JTextField();
        txtName = new JTextField();
        txtQty = new JTextField();
        txtPrice = new JTextField();

        formPanel.add(new JLabel("Kode:"));
        formPanel.add(txtCode);
        formPanel.add(new JLabel("Nama:"));
        formPanel.add(txtName);
        formPanel.add(new JLabel("Qty:"));
        formPanel.add(txtQty);
        formPanel.add(new JLabel("Harga:"));
        formPanel.add(txtPrice);

        // Tombol Tambah
        btnAdd = new JButton("Tambah");
        JPanel addPanel = new JPanel();
        addPanel.add(btnAdd);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(formPanel, BorderLayout.CENTER);
        topPanel.add(addPanel, BorderLayout.SOUTH);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Tabel
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Tombol Hapus
        btnRemove = new JButton("Hapus Produk Terpilih");
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btnRemove);

        // Layout Frame
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void initActions() {
        // Action Tombol Tambah
        btnAdd.addActionListener(e -> {
            String code = txtCode.getText().trim();
            String name = txtName.getText().trim();
            String qtyTxt = txtQty.getText().trim();
            String priceTxt = txtPrice.getText().trim();

            // Validasi input kosong
            if (code.isEmpty() || name.isEmpty() || qtyTxt.isEmpty() || priceTxt.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int qty;
            double price;
            try {
                qty = Integer.parseInt(qtyTxt);
                price = Double.parseDouble(priceTxt);
                if (qty < 0 || price < 0) {
                    JOptionPane.showMessageDialog(this, "Qty dan Harga harus >= 0", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Qty harus integer dan Harga harus angka!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Buat produk baru
            ProductModel p = new ProductModel(code, name, qty, price);
            tableModel.addProduct(p);

            // Reset form
            txtCode.setText("");
            txtName.setText("");
            txtQty.setText("");
            txtPrice.setText("");
            txtCode.requestFocusInWindow();
        });

        // Action tombol hapus
        btnRemove.addActionListener(e -> {
            int viewRow = table.getSelectedRow();
            if (viewRow == -1) {
                JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus!", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            int modelRow = table.convertRowIndexToModel(viewRow);

            int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus produk ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                tableModel.removeProduct(modelRow);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InventoryApp::new);
    }
}
