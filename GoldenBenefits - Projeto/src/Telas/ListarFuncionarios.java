
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Gabri
 */
public class ListarFuncionarios extends javax.swing.JFrame {

    /**
     * Creates new form ListarFuncionarios
     */
    public ListarFuncionarios() {
        initComponents();
    }

    private void carregarDados() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/goldenbenefitspi", "root", "mysql123");

            PreparedStatement st = conectado.prepareStatement("SELECT * FROM funcionario");
            ResultSet funcionario = st.executeQuery();
            DefaultTableModel tblModelo = (DefaultTableModel) tblListarFuncionario.getModel();
            tblModelo.setRowCount(0);
            while (funcionario.next()) {
                Object linha[] = {
                    funcionario.getString("nome_funcionario_id"),
                    funcionario.getString("fk_nome_empresa"),
                    funcionario.getString("departamento"),
                    funcionario.getString("cargo"),};
                tblModelo.addRow(linha);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Entrar em contato com o suporte e informe o erro: " + ex.getMessage());

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblListarFuncionario = new javax.swing.JTable();
        lblFuncionario = new javax.swing.JLabel();
        cmbEmpresa = new javax.swing.JComboBox<>();
        lblNomeEmpresa = new javax.swing.JLabel();
        txtNomeFun = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar funcionários");
        getContentPane().setLayout(null);

        tblListarFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Empresa", "Departamento", "Cargo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblListarFuncionario);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 140, 570, 360);

        lblFuncionario.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblFuncionario.setText("Nome funcionário:");
        getContentPane().add(lblFuncionario);
        lblFuncionario.setBounds(260, 80, 130, 40);

        cmbEmpresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Apple", "Bradesco", "PizzaTime", "Goldenbenefits" }));
        cmbEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEmpresaActionPerformed(evt);
            }
        });
        getContentPane().add(cmbEmpresa);
        cmbEmpresa.setBounds(110, 90, 130, 27);

        lblNomeEmpresa.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblNomeEmpresa.setText("Empresa:");
        getContentPane().add(lblNomeEmpresa);
        lblNomeEmpresa.setBounds(40, 80, 70, 40);
        getContentPane().add(txtNomeFun);
        txtNomeFun.setBounds(390, 90, 140, 27);

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(540, 80, 100, 40);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("LISTAGEM DE FUNCIONÁRIOS");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 30, 260, 25);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/background.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 660, 540);

        setSize(new java.awt.Dimension(673, 547));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEmpresaActionPerformed
        String nempresa;
        nempresa = cmbEmpresa.getSelectedItem().toString();
        if (nempresa.equals("Todos")) {
            carregarDados();
            return;
        }

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/goldenbenefitspi", "root", "mysql123");

            PreparedStatement st = conectado.prepareStatement("SELECT * FROM funcionario WHERE fk_nome_empresa = ?");
            st.setString(1, nempresa);
            ResultSet funcionario = st.executeQuery();
            DefaultTableModel tblModelo = (DefaultTableModel) tblListarFuncionario.getModel();
            tblModelo.setRowCount(0);
            while (funcionario.next()) {
                Object linha[] = {
                    funcionario.getString("nome_funcionario_id"),
                    funcionario.getString("fk_nome_empresa"),
                    funcionario.getString("departamento"),
                    funcionario.getString("cargo"),};
                tblModelo.addRow(linha);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Entr em contato com o suporte e informe o erro: " + ex.getMessage());

        }


    }//GEN-LAST:event_cmbEmpresaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String nf;
        nf = txtNomeFun.getText();

        if (nf.equals("")) {
            carregarDados();
            return;
        }

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/goldenbenefitspi", "root", "mysql123");

            PreparedStatement st = conectado.prepareStatement("SELECT * FROM funcionario WHERE nome_funcionario_id = ?");
            st.setString(1, nf);
            ResultSet nfuncionario = st.executeQuery();
            DefaultTableModel tblModelo = (DefaultTableModel) tblListarFuncionario.getModel();
            tblModelo.setRowCount(0);
            while (nfuncionario.next()) {
                Object linha[] = {
                    nfuncionario.getString("nome_funcionario_id"),
                    nfuncionario.getString("fk_nome_empresa"),
                    nfuncionario.getString("departamento"),
                    nfuncionario.getString("cargo")
                };
                tblModelo.addRow(linha);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Entr em contato com o suporte e informe o erro: " + ex.getMessage());

        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListarFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarFuncionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cmbEmpresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFuncionario;
    private javax.swing.JLabel lblNomeEmpresa;
    private javax.swing.JTable tblListarFuncionario;
    private javax.swing.JTextField txtNomeFun;
    // End of variables declaration//GEN-END:variables
}
