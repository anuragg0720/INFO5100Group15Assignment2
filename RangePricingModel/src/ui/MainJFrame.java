package ui;

import java.awt.CardLayout;
import javax.swing.JFrame;
import model.Business;
import model.DataGenerator;

public class MainJFrame extends javax.swing.JFrame {

    private Business business;

    public MainJFrame() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        business = new Business();
        DataGenerator.populate(business);
        showDashboard();
    }

    private void showDashboard() {
        DashboardPanel panel = new DashboardPanel(workArea, business);
        workArea.add("DashboardPanel", panel);
        ((CardLayout) workArea.getLayout()).show(workArea, "DashboardPanel");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        splitPane = new javax.swing.JSplitPane();
        controlPanel = new javax.swing.JPanel();
        btnBrowse = new javax.swing.JButton();
        btnAdjust = new javax.swing.JButton();
        btnSimulate = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        workArea = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Range Pricing Application - INFO 5100");

        splitPane.setDividerLocation(220);
        splitPane.setContinuousLayout(true);

        controlPanel.setLayout(new java.awt.GridLayout(8, 1, 5, 5));

        btnBrowse.setText("Browse Performance");
        btnBrowse.addActionListener(evt -> openBrowse());
        controlPanel.add(btnBrowse);

        btnAdjust.setText("Adjust Target Prices");
        btnAdjust.addActionListener(evt -> openAdjust());
        controlPanel.add(btnAdjust);

        btnSimulate.setText("Run Simulation");
        btnSimulate.addActionListener(evt -> openSimulation());
        controlPanel.add(btnSimulate);

        btnReport.setText("Final Report");
        btnReport.addActionListener(evt -> openReport());
        controlPanel.add(btnReport);

        splitPane.setLeftComponent(controlPanel);

        workArea.setLayout(new java.awt.CardLayout());
        splitPane.setRightComponent(workArea);

        getContentPane().setLayout(new java.awt.BorderLayout());
        getContentPane().add(splitPane, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private void openBrowse() {
        BrowsePerformancePanel panel = new BrowsePerformancePanel(workArea, business);
        workArea.add("BrowsePerformancePanel", panel);
        ((CardLayout) workArea.getLayout()).show(workArea, "BrowsePerformancePanel");
    }

    private void openAdjust() {
        AdjustPricePanel panel = new AdjustPricePanel(workArea, business);
        workArea.add("AdjustPricePanel", panel);
        ((CardLayout) workArea.getLayout()).show(workArea, "AdjustPricePanel");
    }

    private void openSimulation() {
        SimulationPanel panel = new SimulationPanel(workArea, business);
        workArea.add("SimulationPanel", panel);
        ((CardLayout) workArea.getLayout()).show(workArea, "SimulationPanel");
    }

    private void openReport() {
        ReportPanel panel = new ReportPanel(workArea, business);
        workArea.add("ReportPanel", panel);
        ((CardLayout) workArea.getLayout()).show(workArea, "ReportPanel");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new MainJFrame().setVisible(true);
        });
    }

    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnAdjust;
    private javax.swing.JButton btnSimulate;
    private javax.swing.JButton btnReport;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JPanel workArea;
}
