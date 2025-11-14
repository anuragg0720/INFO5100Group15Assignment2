package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import model.Business;
import model.Supplier;
import model.Product;

public class SimulationPanel extends javax.swing.JPanel {

    private JPanel workArea;
    private Business business;

    public SimulationPanel(JPanel workArea, Business business) {
        this.workArea = workArea;
        this.business = business;
        initComponents();
    }

    private void runSimulation() {
        double totalRevenue = 0.0;
        for (Supplier s : business.getSupplierDirectory().getSuppliers()) {
            for (Product p : s.getProductCatalog().getProducts()) {
                int quantity = p.getBelowTargetCount() + p.getAboveTargetCount() + 1;
                double simRevenue = quantity * p.getTargetPrice();
                p.setRevenueAfter(simRevenue);
                totalRevenue += simRevenue;
            }
        }
        txtResult.setText(String.format(
            "Total simulated revenue based on current target prices: %.2f",
            totalRevenue
        ));
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        btnRun = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResult = new javax.swing.JTextArea();

        setLayout(new BorderLayout(10, 10));

        javax.swing.JPanel topPanel = new javax.swing.JPanel(new BorderLayout(10, 10));

        btnBack.setText("Back");
        btnBack.addActionListener(evt -> goBack());
        topPanel.add(btnBack, BorderLayout.WEST);

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblTitle.setText("Run Revenue Simulation");
        topPanel.add(lblTitle, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);

        txtResult.setColumns(20);
        txtResult.setRows(5);
        txtResult.setEditable(false);
        jScrollPane1.setViewportView(txtResult);
        add(jScrollPane1, BorderLayout.CENTER);

        javax.swing.JPanel bottomPanel = new javax.swing.JPanel();
        btnRun.setText("Run Simulation");
        btnRun.addActionListener(evt -> runSimulation());
        bottomPanel.add(btnRun);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void goBack() {
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.previous(workArea);
    }

    private javax.swing.JButton btnBack;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JButton btnRun;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtResult;
}
