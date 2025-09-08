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

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720, 520);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initUI() {
        // Form Input
        JPanel formPanel = new JPanel(new GridLayout(2, 4, 10, 5));

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

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(formPanel, BorderLayout.CENTER);
        topPanel.add(btnAdd, BorderLayout.EAST);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InventoryApp::new);
    }
}
