/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lab8p2_darielsevilladiegoandino;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Principal extends javax.swing.JFrame {

    private ArrayList<Universo> universos = new ArrayList();

    private Dba database;

    public Principal() {
        initComponents();
        llenarListas();
    }

    public void llenarListas() {
        universos.clear();

        database = new Dba("./gintama.accdb");
        database.conectar();
        try {
            database.query.execute("SELECT * FROM universos");
            ResultSet rs = database.query.getResultSet();

            while (rs.next()) {

                universos.add(new Universo(rs.getString(3), rs.getInt(2), rs.getInt(1)));

            }

            rs = database.query.getResultSet();

            for (Universo universo : universos) {

                database.query.execute("SELECT * FROM seres a, universos b WHERE (a.universo = b.id and b.id =" + universo.getId() + ")");
                
                rs = database.query.getResultSet();
                
                while (rs.next()) {
                    boolean bool = true;
                    if(!rs.getString(5).equals("humano")) {
                        bool = false;
                    }
                    universo.getRegistrado().add(new Seres(rs.getString(6), rs.getInt(2), rs.getInt(1), rs.getInt(2), universo, bool));
                }
                
                
            }

            database.desconectar();
            DefaultComboBoxModel modeloUniversos = (DefaultComboBoxModel) cb_universos.getModel();
            modeloUniversos.removeAllElements();
            for (Universo u : universos) {
                modeloUniversos.addElement(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
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

        jMenu1 = new javax.swing.JMenu();
        wd_crud = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTF_Nombre = new javax.swing.JTextField();
        jTF_ID = new javax.swing.JTextField();
        jTF_Años = new javax.swing.JTextField();
        jCB_Raza = new javax.swing.JComboBox<>();
        jSpinner1 = new javax.swing.JSpinner();
        jB_Agregar = new javax.swing.JButton();
        jCB_Universo = new javax.swing.JComboBox<>();
        pn_principal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bt_modificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jl_elements = new javax.swing.JList<>();
        cb_universos = new javax.swing.JComboBox<>();
        bt_cargarUniverso = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jl_seres = new javax.swing.JList<>();
        pb_cargar = new javax.swing.JProgressBar();
        menuPrincipal = new javax.swing.JMenuBar();
        mi_seres = new javax.swing.JMenu();
        mi_cSeres = new javax.swing.JMenuItem();
        mi_universos = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mi_dUniversos = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jLabel2.setFont(new java.awt.Font("Burbank Big Cd Bd", 0, 48)); // NOI18N
        jLabel2.setText("CRUD");

        jLabel3.setText("Nombre");

        jLabel4.setText("ID");

        jLabel5.setText("Poder");

        jLabel6.setText("Años");

        jLabel7.setText("Universo");

        jLabel8.setText("Raza");

        jTF_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_NombreActionPerformed(evt);
            }
        });

        jTF_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_IDActionPerformed(evt);
            }
        });

        jTF_Años.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_AñosActionPerformed(evt);
            }
        });

        jCB_Raza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Humano", "Amanto" }));

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        jB_Agregar.setText("Agregar");
        jB_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_AgregarActionPerformed(evt);
            }
        });

        jCB_Universo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel3)
                .addGap(16, 16, 16)
                .addComponent(jTF_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel4)
                .addGap(19, 19, 19)
                .addComponent(jTF_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel5)
                .addGap(19, 19, 19)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel6)
                .addGap(23, 23, 23)
                .addComponent(jTF_Años, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel7)
                .addGap(14, 14, 14)
                .addComponent(jCB_Universo, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel8)
                .addGap(26, 26, 26)
                .addComponent(jCB_Raza, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(jB_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTF_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTF_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTF_Años, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jCB_Universo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jCB_Raza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jB_Agregar))
        );

        javax.swing.GroupLayout wd_crudLayout = new javax.swing.GroupLayout(wd_crud.getContentPane());
        wd_crud.getContentPane().setLayout(wd_crudLayout);
        wd_crudLayout.setHorizontalGroup(
            wd_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        wd_crudLayout.setVerticalGroup(
            wd_crudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pn_principal.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 204));
        jLabel1.setText("Control de Amantos");

        bt_modificar.setBackground(new java.awt.Color(102, 255, 204));
        bt_modificar.setForeground(new java.awt.Color(255, 255, 255));
        bt_modificar.setText("Modificar universo");
        bt_modificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jl_elements.setBackground(new java.awt.Color(255, 255, 255));
        jl_elements.setForeground(new java.awt.Color(0, 0, 0));
        jl_elements.setModel(new DefaultListModel());
        jScrollPane1.setViewportView(jl_elements);

        cb_universos.setBackground(new java.awt.Color(255, 255, 255));
        cb_universos.setForeground(new java.awt.Color(0, 0, 0));
        cb_universos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bt_cargarUniverso.setBackground(new java.awt.Color(102, 255, 204));
        bt_cargarUniverso.setForeground(new java.awt.Color(255, 255, 255));
        bt_cargarUniverso.setText("Cargar universo");
        bt_cargarUniverso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt_cargarUniverso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_cargarUniversoMouseClicked(evt);
            }
        });

        jl_seres.setBackground(new java.awt.Color(255, 255, 255));
        jl_seres.setForeground(new java.awt.Color(0, 0, 0));
        jl_seres.setModel(new DefaultListModel());
        jScrollPane2.setViewportView(jl_seres);

        javax.swing.GroupLayout pn_principalLayout = new javax.swing.GroupLayout(pn_principal);
        pn_principal.setLayout(pn_principalLayout);
        pn_principalLayout.setHorizontalGroup(
            pn_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_principalLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pn_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_universos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_principalLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pn_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_cargarUniverso, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(77, 77, 77)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(pn_principalLayout.createSequentialGroup()
                .addGroup(pn_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_principalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1))
                    .addGroup(pn_principalLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(pb_cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_principalLayout.setVerticalGroup(
            pn_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_principalLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_principalLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(pn_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_principalLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(bt_cargarUniverso, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(bt_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(cb_universos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pn_principalLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(pb_cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        mi_seres.setText("seres");

        mi_cSeres.setText("create");
        mi_cSeres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_cSeresActionPerformed(evt);
            }
        });
        mi_seres.add(mi_cSeres);

        menuPrincipal.add(mi_seres);

        mi_universos.setText("Universos");

        jMenuItem1.setText("Crear");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mi_universos.add(jMenuItem1);

        mi_dUniversos.setText("Delete");
        mi_universos.add(mi_dUniversos);

        menuPrincipal.add(mi_universos);

        setJMenuBar(menuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_cargarUniversoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_cargarUniversoMouseClicked
    
        Universo u = (Universo) cb_universos.getSelectedItem();
       
        DefaultListModel modelo = (DefaultListModel) jl_elements.getModel();
      
        modelo.removeAllElements();
        modelo.addElement(u.toString2());
        modelo = (DefaultListModel) jl_seres.getModel();
        modelo.removeAllElements();
        ProgressBar barra = new ProgressBar(pb_cargar, u, modelo);
        barra.start();

    }//GEN-LAST:event_bt_cargarUniversoMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        try {

            SecureRandom random = new SecureRandom();
            boolean bool = true;
            int id = random.nextInt(10000);
            while (bool) {
                int cont = 0;
                for (Universo universo : universos) {
                    if (universo.getId() == id) {
                        cont++;
                    }
                }
                
                if(cont == 0){
                    bool = false;
                }else{
                    id = random.nextInt(10000);
                }
            }
            database.conectar();
            database.query.execute("INSERT INTO universos VALUES ('"+ id + "','"+ 0 + "','" + JOptionPane.showInputDialog("Ingrese Nombre de Universo") + "')");
            database.commit();
            database.desconectar();
            llenarListas();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTF_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_NombreActionPerformed

    private void jTF_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_IDActionPerformed

    private void jTF_AñosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_AñosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_AñosActionPerformed

    private void jB_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_AgregarActionPerformed
        try {
            //Agregar
            String Nombre =jTF_Nombre.getText();
            int ID = jTF_ID.getHeight();
            int Poder = jSpinner1.getHeight();
            int Años = jTF_Años.getHeight();
            Universo Universo = (Universo) jCB_Universo.getSelectedItem();
            boolean Raza;
            if(jCB_Universo.getSelectedItem() == "Humano"){
                Raza = true;
            }else{
                Raza = false;
            }
            String race = "";
            if(Raza == true){
                race = "humano";
            }else{
                race = "amanto";
            }
            database.conectar();
            database.query.execute("INSERT INTO seres VALUES ('" + ID + "','"+ Poder +  "','"+ Años + "','" + Universo.getId() + "','" + race + "','" + Nombre +"')");
            database.query.execute("Update universos SET cantidad = " + (Universo.getCantSeres() + 1) + " WHERE id = " + Universo.getId());
            llenarListas();
            database.desconectar();
            wd_crud.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jB_AgregarActionPerformed

    private void mi_cSeresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_cSeresActionPerformed
        wd_crud.pack();
        wd_crud.setLocationRelativeTo(this);
        wd_crud.setVisible(true);
        jCB_Universo.setModel((DefaultComboBoxModel) cb_universos.getModel());
        
        // TODO add your handling code here:
    }//GEN-LAST:event_mi_cSeresActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cargarUniverso;
    private javax.swing.JButton bt_modificar;
    private javax.swing.JComboBox<String> cb_universos;
    private javax.swing.JButton jB_Agregar;
    private javax.swing.JComboBox<String> jCB_Raza;
    private javax.swing.JComboBox<String> jCB_Universo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTF_Años;
    private javax.swing.JTextField jTF_ID;
    private javax.swing.JTextField jTF_Nombre;
    private javax.swing.JList<String> jl_elements;
    private javax.swing.JList<String> jl_seres;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JMenuItem mi_cSeres;
    private javax.swing.JMenuItem mi_dUniversos;
    private javax.swing.JMenu mi_seres;
    private javax.swing.JMenu mi_universos;
    private javax.swing.JProgressBar pb_cargar;
    private javax.swing.JPanel pn_principal;
    private javax.swing.JFrame wd_crud;
    // End of variables declaration//GEN-END:variables
}
