package ui;

import javax.swing.JPanel;
import model.Business;

public class DashboardPanel extends javax.swing.JPanel {

    private JPanel workArea;
    private Business business;

    public DashboardPanel(JPanel workArea, Business business) {
        this.workArea = workArea;
        this.business = business;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        lblTitle.setAlignmentX(0.5f);
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24));
        lblTitle.setText("Range Pricing Simulation Portal");
        add(lblTitle);

        lblSubtitle.setAlignmentX(0.5f);
        lblSubtitle.setFont(new java.awt.Font("Segoe UI", 0, 14));
        lblSubtitle.setText("Use the left navigation to browse performance, adjust prices, run simulations, and generate reports.");
        add(lblSubtitle);
    }

    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblSubtitle;
}
