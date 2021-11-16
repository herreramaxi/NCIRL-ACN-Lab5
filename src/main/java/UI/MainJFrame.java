/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Model.TCPConnection;
import Model.TimeProtocolService;
import Model.TimeServiceResult;
import Model.UDPConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.Timer;

/**
 *
 * @author Maximiliano Herrera
 */
public class MainJFrame extends javax.swing.JFrame {

    private final Timer _timer;
    private final int DELAY_BETWEEN_REQUESTS = 4500;
    private final TimeProtocolService _tcpService;
    private final TimeProtocolService _udpService;
    private final String TIME_SERVER_HOST = "time.nist.gov";
    private final int TIME_SERVER_PORT = 37;

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        _tcpService = new TimeProtocolService(new TCPConnection(TIME_SERVER_HOST, TIME_SERVER_PORT));
        _udpService = new TimeProtocolService(new UDPConnection(TIME_SERVER_HOST, TIME_SERVER_PORT));

        initComponents();
        
        jTextFieldDateTime.setEditable(false);
        jTextFieldDateTime1.setEditable(false);
        jTextFieldSecondsSince1900.setEditable(false);
        jTextFieldHexa.setEditable(false); 
        jRadioButtonUDP.setSelected(true);
        
        GetDateTime(_udpService);
        
        _timer = new Timer(DELAY_BETWEEN_REQUESTS, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonGet.setEnabled(true);
                jButtonGet.setText("Get");
            }
        });
        _timer.setRepeats(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextFieldDateTime = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonGet = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDateTime1 = new javax.swing.JTextField();
        jRadioButtonTCP = new javax.swing.JRadioButton();
        jRadioButtonUDP = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldSecondsSince1900 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldHexa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Time protocol app");

        jLabel1.setText("Date time:");

        jButtonGet.setText("Get");
        jButtonGet.setToolTipText("There is a delay of 4 second to protect server time.nist.gov from denial-of-service attack");
        jButtonGet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGetActionPerformed(evt);
            }
        });

        jLabel2.setText("Source:");

        jTextFieldDateTime1.setText("time.nist.gov");

        buttonGroup1.add(jRadioButtonTCP);
        jRadioButtonTCP.setText("TCP");

        buttonGroup1.add(jRadioButtonUDP);
        jRadioButtonUDP.setText("UDP");

        jLabel4.setText("Seconds since 1900:");

        jLabel5.setText("Package - Hexa:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldDateTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButtonTCP))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButtonUDP)))
                                .addGap(18, 18, 18)
                                .addComponent(jButtonGet))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldHexa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                                .addComponent(jTextFieldSecondsSince1900, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGet)
                    .addComponent(jRadioButtonUDP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDateTime1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jRadioButtonTCP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldSecondsSince1900, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldHexa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GetDateTime(TimeProtocolService service) {
        TimeServiceResult result = service.GetDateTime();
        
        System.out.printf("Time protocol by %s: %s\n", service.getServiceProtocol(), result.getFormatedDateTime());
        
        jTextFieldDateTime.setText(result.getFormatedDateTime());
        jTextFieldSecondsSince1900.setText(String.valueOf(result.getSeconds()));
        jTextFieldHexa.setText(String.valueOf(result.getHexa()));
    }

    private void jButtonGetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGetActionPerformed
        JButton button = ((JButton) evt.getSource());
        button.setEnabled(false);
        button.setText("Waiting...");
        _timer.start();
        
        if (jRadioButtonTCP.isSelected()) {
            GetDateTime(_tcpService);
        } else {
            GetDateTime(_udpService);
        }
    }//GEN-LAST:event_jButtonGetActionPerformed

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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonGet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioButtonTCP;
    private javax.swing.JRadioButton jRadioButtonUDP;
    private javax.swing.JTextField jTextFieldDateTime;
    private javax.swing.JTextField jTextFieldDateTime1;
    private javax.swing.JTextField jTextFieldHexa;
    private javax.swing.JTextField jTextFieldSecondsSince1900;
    // End of variables declaration//GEN-END:variables
}
