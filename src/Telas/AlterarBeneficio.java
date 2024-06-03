
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Gabri
 */
public class AlterarBeneficio extends javax.swing.JFrame {

    /**
     * Creates new form AlterarBeneficio
     */
    public AlterarBeneficio() {
        initComponents();
    }
    public AlterarBeneficio(String ben,String tipo) {
        initComponents();
        txtNomeBeneficio.setText(ben);
        txtTipoBeneficio.setText(tipo);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNomeBeneficio = new javax.swing.JLabel();
        txtNomeBeneficio = new javax.swing.JTextField();
        lblTipoBeneficio = new javax.swing.JLabel();
        txtTipoBeneficio = new javax.swing.JTextField();
        btnAlterarBeneficio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar dados do benefício");
        getContentPane().setLayout(null);

        lblNomeBeneficio.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblNomeBeneficio.setText("Nome do benefício:");
        getContentPane().add(lblNomeBeneficio);
        lblNomeBeneficio.setBounds(20, 110, 130, 30);
        getContentPane().add(txtNomeBeneficio);
        txtNomeBeneficio.setBounds(150, 110, 130, 30);

        lblTipoBeneficio.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblTipoBeneficio.setText("Tipo do benefício:");
        getContentPane().add(lblTipoBeneficio);
        lblTipoBeneficio.setBounds(20, 150, 130, 30);
        getContentPane().add(txtTipoBeneficio);
        txtTipoBeneficio.setBounds(150, 150, 130, 30);

        btnAlterarBeneficio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAlterarBeneficio.setText("ALTERAR");
        btnAlterarBeneficio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarBeneficioActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterarBeneficio);
        btnAlterarBeneficio.setBounds(90, 200, 160, 50);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("ALTERAR BENEFÍCIO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 50, 180, 25);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/background.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 300, 300);

        setSize(new java.awt.Dimension(314, 307));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarBeneficioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarBeneficioActionPerformed
        String b, tp;
        b = txtNomeBeneficio.getText();
        tp = txtTipoBeneficio.getText();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/goldenbenefitspi", "root", "mysql123");

            
            PreparedStatement st = conectado.prepareStatement("update beneficio set tipo=? where nome_beneficio=?;");
            st.setString(1, tp);
            st.setString(2,b);

            st.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null, "Benefício alterado com sucesso");

            dispose();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex.getMessage());

        }
        
    }//GEN-LAST:event_btnAlterarBeneficioActionPerformed

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
            java.util.logging.Logger.getLogger(AlterarBeneficio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarBeneficio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarBeneficio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarBeneficio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarBeneficio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarBeneficio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblNomeBeneficio;
    private javax.swing.JLabel lblTipoBeneficio;
    private javax.swing.JTextField txtNomeBeneficio;
    private javax.swing.JTextField txtTipoBeneficio;
    // End of variables declaration//GEN-END:variables
}