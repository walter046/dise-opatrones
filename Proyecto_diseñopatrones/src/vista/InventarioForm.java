package vista;


public class InventarioForm extends javax.swing.JFrame {
    
    

    public InventarioForm() {
        initComponents();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbtnagregarPro = new javax.swing.JButton();
        jtxtcantidadPro = new javax.swing.JTextField();
        jtxtNombrepro = new javax.swing.JTextField();
        jtxtdescrpcionPro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnagregarPro.setText("AGREGAR");
        jbtnagregarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnagregarProActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnagregarPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 210, 40));

        jtxtcantidadPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtcantidadProActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtcantidadPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 170, 40));

        jtxtNombrepro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNombreproActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtNombrepro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 170, 40));

        jtxtdescrpcionPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtdescrpcionProActionPerformed(evt);
            }
        });
        jPanel1.add(jtxtdescrpcionPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 170, 40));

        jLabel1.setText("Cantidad:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel3.setText("Descripcion:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtNombreproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNombreproActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNombreproActionPerformed

    private void jtxtdescrpcionProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtdescrpcionProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtdescrpcionProActionPerformed

    private void jtxtcantidadProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtcantidadProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtcantidadProActionPerformed

    private void jbtnagregarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnagregarProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnagregarProActionPerformed

    public static void main(String args[]) {
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new InventarioForm().setVisible(true); // ← CORREGIDO AQUÍ
        }
    });
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JButton jbtnagregarPro;
    public javax.swing.JTextField jtxtNombrepro;
    public javax.swing.JTextField jtxtcantidadPro;
    public javax.swing.JTextField jtxtdescrpcionPro;
    // End of variables declaration//GEN-END:variables
}

