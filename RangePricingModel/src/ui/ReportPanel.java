package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Business;
import model.Supplier;
import model.Product;

public class ReportPanel extends javax.swing.JPanel {

    private JPanel workArea;
    private Business business;

    public ReportPanel(JPanel workArea, Business business) {
        this.workArea = workArea;
        this.business = business;
        initComponents();
        populateReport();
    }

    private void populateReport() {
        DefaultTableModel model = (DefaultTableModel) tblReport.getModel();
        model.setRowCount(0);
        for (Supplier s : business.getSupplierDirectory().getSuppliers()) {
            for (Product p : s.getProductCatalog().getProducts()) {
                Object[] row = new Object[8];
                row[0] = s.getName();
                row[1] = p.getName();
                row[2] = p.getTargetPrice();
                row[3] = p.getBelowTargetCount();
                row[4] = p.getAboveTargetCount();
                row[5] = String.format("%.2f", p.getRevenueBefore());
                row[6] = String.format("%.2f", p.getRevenueAfter());
                row[7] = p.getRevenueAfter() - p.getRevenueBefore();
                model.addRow(row);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReport = new javax.swing.JTable();

        setLayout(new BorderLayout(10, 10));

        javax.swing.JPanel topPanel = new javax.swing.JPanel(new BorderLayout(10, 10));

        btnBack.setText("Back");
        btnBack.addActionListener(evt -> goBack());
        topPanel.add(btnBack, BorderLayout.WEST);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblTitle.setText("Final Product Performance Report");
        topPanel.add(lblTitle, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);

        tblReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Supplier", "Product", "Target Price (After)",
                "Below Target", "Above Target",
                "Revenue Before", "Revenue After", "Delta"
            }
        ) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        jScrollPane1.setViewportView(tblReport);
        add(jScrollPane1, BorderLayout.CENTER);
    }

    private void goBack() {
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.previous(workArea);
    }

    private javax.swing.JButton btnBack;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReport;
}
