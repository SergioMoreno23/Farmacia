/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

import MySql.conexion;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//import static farmacia.Login.DESEDE_ENCRYPTION_SCHEME;
//import static farmacia.Login.UNICODE_FORMAT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.swing.RowFilter;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Osvaldo
 */
public class Usuarios extends javax.swing.JFrame {
    conexion cn = new conexion();
    Connection con = cn.getConnection();
     DefaultTableModel model;
     private TableRowSorter Buscar;
     
     
     PreparedStatement ps;
    ResultSet rs;
    String SQL;
    TableRowSorter trs;
     SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
     
     
    public static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    public KeySpec ks;
    public SecretKeyFactory skf;
    public Cipher cipher;
    byte[] arrayBytes;
    public String myEncryptionKey;
    public String myEncryptionScheme;
    SecretKey key;

    public Usuarios() throws Exception{
        
            initComponents();
            visualizar();
            visualizarCa();
        myEncryptionKey = "ThisIsSpartaThisIsSparta";
        myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
        arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        ks = new DESedeKeySpec(arrayBytes);
        skf = SecretKeyFactory.getInstance(myEncryptionScheme);
        cipher = Cipher.getInstance(myEncryptionScheme);
        key = skf.generateSecret(ks);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SDadmin_agregar = new javax.swing.JDialog();
        JP_Agregar_admin = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtAgregar_Usuario = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtAgregar_Nombre = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtAgregar_Fecha = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtAgregar_Telefono = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtAgregar_Apellido = new javax.swing.JTextField();
        btnSD_Agregar = new javax.swing.JButton();
        txt_Admin_Contra = new javax.swing.JPasswordField();
        SD_Editar_Admin = new javax.swing.JDialog();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        btnSDedit = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtEdit_Fecha = new javax.swing.JTextField();
        txtEdit_Nombre = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtEdit_Apellido = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtEdit_Telefono = new javax.swing.JTextField();
        txtEdit_Rol = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        LB_usuario = new javax.swing.JLabel();
        txt_Edit_Contra = new javax.swing.JPasswordField();
        SD_Cajero_Agregar = new javax.swing.JDialog();
        JP_Agregar_admin1 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtAgregar_Usuario_Ca = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtAgregar_Nombre_Ca = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtAgregar_Fecha_Ca = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtAgregar_Telefono_Ca = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtAgregar_Apellido_Ca = new javax.swing.JTextField();
        btnSD_Agregar_Ca = new javax.swing.JButton();
        txt_Agregar_Contra_Ca = new javax.swing.JPasswordField();
        SD_Cajero_Editar = new javax.swing.JDialog();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        btnSDedit_Ca = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtEdit_Fecha_Ca = new javax.swing.JTextField();
        txtEdit_Nombre_Ca = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtEdit_Apellido_Ca = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtEdit_Telefono_Ca = new javax.swing.JTextField();
        txtEdit_Rol_Ca = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        LB_usuario_Ca = new javax.swing.JLabel();
        txt_Edit_Contra_Ca = new javax.swing.JPasswordField();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_Admin = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txt_buscar_Admin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        LB_Agregar_Admin = new javax.swing.JLabel();
        lb_Agregar_Admin = new javax.swing.JLabel();
        LB_Editar = new javax.swing.JLabel();
        Lb_Editar_Admin = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAdmin_Cerrar = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table_Cajero = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_buscar_Cajero = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        LB_Agregar_Cajero = new javax.swing.JLabel();
        LB_Agregar_Ca = new javax.swing.JLabel();
        LB_Editar_Cajero = new javax.swing.JLabel();
        Lb_Editar_Ca = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnCajero_Cerrar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        JP_Agregar_admin.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(51, 51, 255));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Agregar Admistrador");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtAgregar_Usuario.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Usuario");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Nombre");

        txtAgregar_Nombre.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtAgregar_Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAgregar_NombreKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Fecha de nacimiento");

        txtAgregar_Fecha.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Teléfono");

        txtAgregar_Telefono.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setText("Contraseña");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Apellidos");

        txtAgregar_Apellido.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btnSD_Agregar.setBackground(new java.awt.Color(0, 0, 255));
        btnSD_Agregar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSD_Agregar.setForeground(new java.awt.Color(255, 255, 255));
        btnSD_Agregar.setText("Agregar");
        btnSD_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSD_AgregarActionPerformed(evt);
            }
        });

        txt_Admin_Contra.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txt_Admin_Contra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Admin_Contra.setToolTipText("");
        txt_Admin_Contra.setAlignmentY(1.0F);

        javax.swing.GroupLayout JP_Agregar_adminLayout = new javax.swing.GroupLayout(JP_Agregar_admin);
        JP_Agregar_admin.setLayout(JP_Agregar_adminLayout);
        JP_Agregar_adminLayout.setHorizontalGroup(
            JP_Agregar_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Agregar_adminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_Agregar_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_Agregar_adminLayout.createSequentialGroup()
                        .addGroup(JP_Agregar_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtAgregar_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(JP_Agregar_adminLayout.createSequentialGroup()
                        .addGroup(JP_Agregar_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(txtAgregar_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(txtAgregar_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(JP_Agregar_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JP_Agregar_adminLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txt_Admin_Contra, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11)
                            .addComponent(txtAgregar_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtAgregar_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(JP_Agregar_adminLayout.createSequentialGroup()
                .addGroup(JP_Agregar_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JP_Agregar_adminLayout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(btnSD_Agregar)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JP_Agregar_adminLayout.setVerticalGroup(
            JP_Agregar_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Agregar_adminLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JP_Agregar_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JP_Agregar_adminLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAgregar_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JP_Agregar_adminLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAgregar_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(JP_Agregar_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JP_Agregar_adminLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAgregar_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JP_Agregar_adminLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAgregar_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP_Agregar_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_Agregar_adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAgregar_Telefono)
                    .addComponent(txt_Admin_Contra))
                .addGap(34, 34, 34)
                .addComponent(btnSD_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SDadmin_agregarLayout = new javax.swing.GroupLayout(SDadmin_agregar.getContentPane());
        SDadmin_agregar.getContentPane().setLayout(SDadmin_agregarLayout);
        SDadmin_agregarLayout.setHorizontalGroup(
            SDadmin_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JP_Agregar_admin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        SDadmin_agregarLayout.setVerticalGroup(
            SDadmin_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JP_Agregar_admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(51, 51, 255));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Editar Administrador");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSDedit.setBackground(new java.awt.Color(0, 0, 255));
        btnSDedit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSDedit.setForeground(new java.awt.Color(255, 255, 255));
        btnSDedit.setText("Editar");
        btnSDedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSDeditActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setText("Contraseña");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setText("Fecha de nacimiento");

        txtEdit_Fecha.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtEdit_Nombre.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtEdit_Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdit_NombreKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setText("Nombre");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel22.setText("Apellidos");

        txtEdit_Apellido.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel23.setText("Teléfono");

        txtEdit_Telefono.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtEdit_Rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------TIPO DE ROLES----------", "Administrador", "Cajero", " " }));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel24.setText("Rol");

        LB_usuario.setFont(new java.awt.Font("Arial", 2, 24)); // NOI18N
        LB_usuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txt_Edit_Contra.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txt_Edit_Contra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Edit_Contra.setToolTipText("");
        txt_Edit_Contra.setAlignmentY(1.0F);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(LB_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(txtEdit_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(txtEdit_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(txtEdit_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(txtEdit_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(txt_Edit_Contra, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(txtEdit_Rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(btnSDedit)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LB_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEdit_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEdit_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEdit_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEdit_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Edit_Contra)
                    .addComponent(txtEdit_Rol, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSDedit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout SD_Editar_AdminLayout = new javax.swing.GroupLayout(SD_Editar_Admin.getContentPane());
        SD_Editar_Admin.getContentPane().setLayout(SD_Editar_AdminLayout);
        SD_Editar_AdminLayout.setHorizontalGroup(
            SD_Editar_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        SD_Editar_AdminLayout.setVerticalGroup(
            SD_Editar_AdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        JP_Agregar_admin1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(51, 51, 255));

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Agregar Cajero");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtAgregar_Usuario_Ca.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel27.setText("Usuario");

        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel28.setText("Nombre");

        txtAgregar_Nombre_Ca.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtAgregar_Nombre_Ca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAgregar_Nombre_CaKeyTyped(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel29.setText("Fecha de nacimiento");

        txtAgregar_Fecha_Ca.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel30.setText("Teléfono");

        txtAgregar_Telefono_Ca.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel32.setText("Contraseña");

        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel33.setText("Apellidos");

        txtAgregar_Apellido_Ca.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btnSD_Agregar_Ca.setBackground(new java.awt.Color(0, 0, 255));
        btnSD_Agregar_Ca.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSD_Agregar_Ca.setForeground(new java.awt.Color(255, 255, 255));
        btnSD_Agregar_Ca.setText("Agregar");
        btnSD_Agregar_Ca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSD_Agregar_CaMouseClicked(evt);
            }
        });
        btnSD_Agregar_Ca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSD_Agregar_CaActionPerformed(evt);
            }
        });

        txt_Agregar_Contra_Ca.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txt_Agregar_Contra_Ca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Agregar_Contra_Ca.setToolTipText("");
        txt_Agregar_Contra_Ca.setAlignmentY(1.0F);

        javax.swing.GroupLayout JP_Agregar_admin1Layout = new javax.swing.GroupLayout(JP_Agregar_admin1);
        JP_Agregar_admin1.setLayout(JP_Agregar_admin1Layout);
        JP_Agregar_admin1Layout.setHorizontalGroup(
            JP_Agregar_admin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Agregar_admin1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_Agregar_admin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_Agregar_admin1Layout.createSequentialGroup()
                        .addGroup(JP_Agregar_admin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(txtAgregar_Usuario_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(JP_Agregar_admin1Layout.createSequentialGroup()
                        .addGroup(JP_Agregar_admin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(txtAgregar_Apellido_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)
                            .addComponent(txtAgregar_Telefono_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(JP_Agregar_admin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JP_Agregar_admin1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(JP_Agregar_admin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addComponent(txtAgregar_Nombre_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29)
                                    .addComponent(txtAgregar_Fecha_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32)))
                            .addGroup(JP_Agregar_admin1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Agregar_Contra_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(JP_Agregar_admin1Layout.createSequentialGroup()
                .addGroup(JP_Agregar_admin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JP_Agregar_admin1Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(btnSD_Agregar_Ca)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JP_Agregar_admin1Layout.setVerticalGroup(
            JP_Agregar_admin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_Agregar_admin1Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JP_Agregar_admin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JP_Agregar_admin1Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAgregar_Usuario_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JP_Agregar_admin1Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAgregar_Nombre_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(JP_Agregar_admin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JP_Agregar_admin1Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAgregar_Fecha_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JP_Agregar_admin1Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAgregar_Apellido_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JP_Agregar_admin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_Agregar_admin1Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Agregar_Contra_Ca))
                    .addGroup(JP_Agregar_admin1Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAgregar_Telefono_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnSD_Agregar_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SD_Cajero_AgregarLayout = new javax.swing.GroupLayout(SD_Cajero_Agregar.getContentPane());
        SD_Cajero_Agregar.getContentPane().setLayout(SD_Cajero_AgregarLayout);
        SD_Cajero_AgregarLayout.setHorizontalGroup(
            SD_Cajero_AgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JP_Agregar_admin1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        SD_Cajero_AgregarLayout.setVerticalGroup(
            SD_Cajero_AgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JP_Agregar_admin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jPanel15.setBackground(new java.awt.Color(51, 51, 255));

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Editar Cajero");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSDedit_Ca.setBackground(new java.awt.Color(0, 0, 255));
        btnSDedit_Ca.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSDedit_Ca.setForeground(new java.awt.Color(255, 255, 255));
        btnSDedit_Ca.setText("Editar");
        btnSDedit_Ca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSDedit_CaMouseClicked(evt);
            }
        });
        btnSDedit_Ca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSDedit_CaActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel34.setText("Contraseña");

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel35.setText("Fecha de nacimiento");

        txtEdit_Fecha_Ca.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtEdit_Nombre_Ca.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtEdit_Nombre_Ca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdit_Nombre_CaKeyTyped(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel36.setText("Nombre");

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel38.setText("Apellidos");

        txtEdit_Apellido_Ca.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel39.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel39.setText("Teléfono");

        txtEdit_Telefono_Ca.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtEdit_Rol_Ca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------TIPO DE ROLES----------", "Administrador", "Cajero", " " }));

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel40.setText("Rol");

        LB_usuario_Ca.setFont(new java.awt.Font("Arial", 2, 24)); // NOI18N
        LB_usuario_Ca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txt_Edit_Contra_Ca.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        txt_Edit_Contra_Ca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Edit_Contra_Ca.setToolTipText("");
        txt_Edit_Contra_Ca.setAlignmentY(1.0F);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LB_usuario_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(txtEdit_Telefono_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34)
                            .addComponent(txt_Edit_Contra_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel40)
                                    .addComponent(txtEdit_Rol_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtEdit_Fecha_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(txtEdit_Nombre_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(txtEdit_Apellido_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(btnSDedit_Ca)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LB_usuario_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEdit_Nombre_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEdit_Apellido_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEdit_Telefono_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEdit_Fecha_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_Edit_Contra_Ca))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEdit_Rol_Ca)))
                .addGap(18, 18, 18)
                .addComponent(btnSDedit_Ca, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SD_Cajero_EditarLayout = new javax.swing.GroupLayout(SD_Cajero_Editar.getContentPane());
        SD_Cajero_Editar.getContentPane().setLayout(SD_Cajero_EditarLayout);
        SD_Cajero_EditarLayout.setHorizontalGroup(
            SD_Cajero_EditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        SD_Cajero_EditarLayout.setVerticalGroup(
            SD_Cajero_EditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Frame_Usuario");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        Table_Admin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Usuario", "Nombre", "Apellido", "Fecha de nacimiento", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Table_Admin.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(Table_Admin);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        txt_buscar_Admin.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_buscar_Admin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_buscar_AdminKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Nombre de Administrador:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txt_buscar_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_buscar_Admin)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        LB_Agregar_Admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LB_Agregar_Admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btnAgregarProducto.png"))); // NOI18N
        LB_Agregar_Admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LB_Agregar_AdminMouseClicked(evt);
            }
        });

        lb_Agregar_Admin.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lb_Agregar_Admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Agregar_Admin.setText("Agregar");
        lb_Agregar_Admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_Agregar_AdminMouseClicked(evt);
            }
        });

        LB_Editar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LB_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btnEditarProducto.png"))); // NOI18N
        LB_Editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LB_EditarMouseClicked(evt);
            }
        });

        Lb_Editar_Admin.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Lb_Editar_Admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lb_Editar_Admin.setText("Editar ");
        Lb_Editar_Admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Lb_Editar_AdminMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_Agregar_Admin, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(LB_Agregar_Admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Lb_Editar_Admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LB_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(LB_Editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Lb_Editar_Admin))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(LB_Agregar_Admin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_Agregar_Admin)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de Administradores");

        btnAdmin_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btnCerrar_login.png"))); // NOI18N
        btnAdmin_Cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdmin_CerrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdmin_Cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnAdmin_Cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1136, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Administrador", jPanel2);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        Table_Cajero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(Table_Cajero);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Nombre de Cajero:");

        txt_buscar_Cajero.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_buscar_Cajero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_buscar_CajeroKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addContainerGap(723, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(txt_buscar_Cajero, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(8, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(65, 65, 65))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(txt_buscar_Cajero)
                    .addGap(25, 25, 25)))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        LB_Agregar_Cajero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LB_Agregar_Cajero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btnAgregarProducto.png"))); // NOI18N
        LB_Agregar_Cajero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LB_Agregar_CajeroMouseClicked(evt);
            }
        });

        LB_Agregar_Ca.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        LB_Agregar_Ca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LB_Agregar_Ca.setText("Agregar");
        LB_Agregar_Ca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LB_Agregar_CaMouseClicked(evt);
            }
        });

        LB_Editar_Cajero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LB_Editar_Cajero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btnEditarProducto.png"))); // NOI18N
        LB_Editar_Cajero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LB_Editar_CajeroMouseClicked(evt);
            }
        });

        Lb_Editar_Ca.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Lb_Editar_Ca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lb_Editar_Ca.setText("Editar ");
        Lb_Editar_Ca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Lb_Editar_CaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LB_Agregar_Ca, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(LB_Agregar_Cajero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Lb_Editar_Ca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LB_Editar_Cajero, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(LB_Editar_Cajero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Lb_Editar_Ca))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(LB_Agregar_Cajero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LB_Agregar_Ca)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(0, 0, 255));

        btnCajero_Cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btnCerrar_login.png"))); // NOI18N
        btnCajero_Cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCajero_CerrarMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Registro de Cajeros");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCajero_Cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(btnCajero_Cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1136, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
        );

        jPanel7.getAccessibleContext().setAccessibleDescription("Buscar");

        jTabbedPane4.addTab("Cajero", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Metodo para encriptar la contraseña ############################################################################################################
      public String encrypt(String unencryptedString) {
        String encryptedString = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            encryptedString = new String(Base64.encodeBase64(encryptedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedString;
    }

      
//Metodo para desencriptar la contraseña ############################################################################################################     
    public String decrypt(String encryptedString) {
        String decryptedText = null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedText = Base64.decodeBase64(encryptedString.getBytes());
            byte[] plainText = cipher.doFinal(encryptedText);
            decryptedText = new String(plainText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedText;
    }
    
    
//Metodo para visualizar la tabla de administradores############################################################################################################
    public void visualizar(){
        try {
            String [] titulos={"Usuario", "Nombre", "Apellido", "Fecha de nacimiento", "Teléfono"};
            String [] registros = new String[8];
            String SQL="SELECT usuario,nombre,apellido,f_nacimiento,telefono FROM usuario WHERE rol = 'Administrador'";
                       
            model = new DefaultTableModel(null,titulos);
            Statement st =con.createStatement();
            ResultSet rs = st.executeQuery(SQL);          
            while(rs.next()){
                registros[0]=rs.getString("usuario");
                registros[1]=rs.getString("nombre");
                registros[2]=rs.getString("apellido");
                registros[3]=rs.getString("f_nacimiento");
                registros[4]=rs.getString("telefono");
                model.addRow(registros);  
            }
               
            Table_Admin.setModel(model);
         
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
//METODO PARA INSERTAR UN NUEVO USUARIO############################################################################################################################
    
    public void InsertarRol(){
     try {
      if (txtAgregar_Nombre.getText().length() > 0 && txtAgregar_Usuario.getText().length() > 0 
              && txtAgregar_Apellido.getText().length() > 0 && txtAgregar_Fecha.getText().length() >0 && 
              txtAgregar_Telefono.getText().length() >0 && txt_Admin_Contra.getText().length() > 0){   
            SQL="INSERT INTO usuario (usuario,nombre,apellido,f_nacimiento,telefono,contraseña,rol) VALUES (?,?,?,?,?,?,?) ";
            ps = con.prepareStatement(SQL);
            
            ps.setString(1, txtAgregar_Usuario.getText());
            ps.setString(2, txtAgregar_Nombre.getText());
            ps.setString(3, txtAgregar_Apellido.getText());
            ps.setString(4, txtAgregar_Fecha.getText());
            ps.setString(5, txtAgregar_Telefono.getText());
            String target = txt_Admin_Contra.getText();
            String encrypted = encrypt(target);
            ps.setString(6, encrypted);
            ps.setString(7, "Administrador"); 
            //ps.setString(7, txtAgregar_Rol.getSelectedItem().toString());        
            
//                System.out.println("String To Encrypt: " + target);
//                System.out.println("Encrypted String: " + encrypted);   
                
            ps.executeUpdate();
//                if(res>0){
 visualizar();
                     LimpiarJtext();
                     SDadmin_agregar.dispose();
                    
                     //JOptionPane.showMessageDialog(null,"REGISTRO EXITOSO");
                     
//                }else{
//                JOptionPane.showMessageDialog(null,"NO SE PUDO REALIZAR EL PROCESO","ADVERTENCIA!" ,JOptionPane.WARNING_MESSAGE);
//                }
            } else {
            
            JOptionPane.showMessageDialog(null,"REVISAR LOS CAMPOS VACIOS","ADVERTENCIA!" ,JOptionPane.WARNING_MESSAGE);
            }
     } 
        
        catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
//METODO PARA LIMPIAR LOS JTEXTFIELD#############################################################################################################
    
    public void LimpiarJtext(){
       txtAgregar_Nombre.setText("");
       txtAgregar_Apellido.setText("");
       txtAgregar_Usuario.setText("");
       txtAgregar_Fecha.setText("");
       txt_Admin_Contra.setText("");
       txtAgregar_Telefono.setText("");
       LB_usuario.setText("");
       txtEdit_Nombre.setText("");
       txtEdit_Apellido.setText("");
       txt_Edit_Contra.setText("");
       txtEdit_Fecha.setText("");
       txtEdit_Telefono.setText("");
    }
    
    
//METODO PARA SELECCIONAR UNA FILAANTES DE EDITAR############################################################################################################
    public void SeleccionarEditar(){
     int FilaSelect = Table_Admin.getSelectedRow();
        if(FilaSelect >=0){
            
            LB_usuario.setText(Table_Admin.getValueAt(FilaSelect, 0).toString());
            txtEdit_Nombre.setText(Table_Admin.getValueAt(FilaSelect, 1).toString());
            txtEdit_Apellido.setText(Table_Admin.getValueAt(FilaSelect, 2).toString());
            txtEdit_Fecha.setText(Table_Admin.getValueAt(FilaSelect, 3).toString());
            txtEdit_Telefono.setText(Table_Admin.getValueAt(FilaSelect, 4).toString());
            //txtEdit_Password.setText(Table_Admin.getValueAt(FilaSelect, 5).toString());
            //txtEdit_Rol.setSelectedItem(Table_Admin.getValueAt(FilaSelect, 6).toString());
 
       SD_Editar_Admin.setVisible(true);
       SD_Editar_Admin.setSize(615, 450);
       SD_Editar_Admin.setModal(true);
       SD_Editar_Admin.setLocationRelativeTo(null);  
        
        }
        else
        {
              JOptionPane.showMessageDialog(null,"SELECCIONA EL USUARIO QUE QUIERES MODIFICAR");
        }
    }
    
    
//METODO PARA  EDITAR ADMINISTRADOR EN LA BASE DE DATOS##########################################################################################################
public void EditarAdmin(){
try {
            if (txt_Edit_Contra.getText().length()!=0){
                
                System.out.println("Entro al IF"); 
            SQL="UPDATE usuario SET  nombre=?, apellido=?, f_nacimiento=?, telefono=?, contraseña=?, rol=? WHERE usuario=? ";
            ps = con.prepareStatement(SQL);
            
            ps.setString(1, txtEdit_Nombre.getText());
            ps.setString(2, txtEdit_Apellido.getText());
            ps.setString(3, txtEdit_Fecha.getText().toString());           
            ps.setString(4, txtEdit_Telefono.getText());
            String target = txt_Edit_Contra.getText();
            String encrypted = encrypt(target);
            ps.setString(5, encrypted);
            ps.setString(6, txtEdit_Rol.getSelectedItem().toString());
            ps.setString(7, LB_usuario.getText());
            
            int res = ps.executeUpdate();
                if(res>0){
                     LimpiarJtext();
                     visualizar();
                     SD_Editar_Admin.dispose();
                }else{
                JOptionPane.showMessageDialog(null,"VERIFICA QUE EL USUARIO ESTE CORRECTO");
                }
            }   else {
                
                System.out.println("Entro al ELSE"); 
            SQL="UPDATE usuario SET  nombre=?, apellido=?, f_nacimiento=?, telefono=?, rol=? WHERE usuario=? ";
            ps = con.prepareStatement(SQL);
            
           
            ps.setString(1, txtEdit_Nombre.getText());
            ps.setString(2, txtEdit_Apellido.getText());
            ps.setString(3, txtEdit_Fecha.getText().toString());           
            ps.setString(4, txtEdit_Telefono.getText()); 
            ps.setString(5, txtEdit_Rol.getSelectedItem().toString());
            ps.setString(6, LB_usuario.getText());
            
            int res = ps.executeUpdate();
                if(res>0){
                     LimpiarJtext();
                     visualizar();
                     SD_Editar_Admin.dispose();
                }else{
                JOptionPane.showMessageDialog(null,"VERIFICA QUE EL USUARIO ESTE CORRECTO");
                }
            
            
            }
       } 
        
        catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }             
}
    
 //METODO PARA FILTAR EN LA TABLA ADMINISTRADORES ##################################################################################################
    
public void BuscarAdmin(){
        int Columna=1;
    
        Buscar.setRowFilter(RowFilter.regexFilter(txt_buscar_Admin.getText(),Columna));
    }   

//METODO PARA FILTAR EN LA TABLA CAJEROS ###############################################################################################################################################
    
public void BuscarCajero(){
        int Columna=1;
    
        Buscar.setRowFilter(RowFilter.regexFilter(txt_buscar_Cajero.getText(),Columna));
    }   


//METODO PARA CONVENTIR EN MAYUSCULAS LA PRIMERA LETRA DEL TEXBOX###############################################################################################################################
public void Mayus(){
String mayuscula = txt_buscar_Admin.getText();
String mayuscula1 = txtEdit_Nombre.getText();
String mayuscula3 = txtAgregar_Nombre.getText();

String mayuscula6= txt_buscar_Cajero.getText();
String mayuscula4 = txtAgregar_Nombre_Ca.getText();
String mayuscula5 = txtEdit_Nombre_Ca.getText();



       if(mayuscula.length()>0){
            char primer=mayuscula.charAt(0);
            mayuscula=Character.toUpperCase(primer)+mayuscula.substring(1,mayuscula.length());  
            txt_buscar_Admin.setText(mayuscula);   
       } if(mayuscula1.length()>0){
             char primer1=mayuscula1.charAt(0);
             mayuscula1=Character.toUpperCase(primer1)+mayuscula1.substring(1,mayuscula1.length());
             txtEdit_Nombre.setText(mayuscula1);        
       }if(mayuscula3.length()>0){
         char primer3=mayuscula3.charAt(0);
             mayuscula3=Character.toUpperCase(primer3)+mayuscula3.substring(1,mayuscula3.length());
             txtAgregar_Nombre.setText(mayuscula3);
         }if(mayuscula4.length()>0){
         char primer4=mayuscula4.charAt(0);
             mayuscula4=Character.toUpperCase(primer4)+mayuscula4.substring(1,mayuscula4.length());
             txtAgregar_Nombre_Ca.setText(mayuscula4);
         }if(mayuscula5.length()>0){
         char primer5=mayuscula5.charAt(0);
             mayuscula5=Character.toUpperCase(primer5)+mayuscula5.substring(1,mayuscula5.length());
             txtEdit_Nombre_Ca.setText(mayuscula5);
         }if(mayuscula6.length()>0){
         char primer6=mayuscula6.charAt(0);
             mayuscula6=Character.toUpperCase(primer6)+mayuscula6.substring(1,mayuscula6.length());
             txt_buscar_Cajero.setText(mayuscula6);
         }
         
}


//Aquí empiezan los metodos de CAJERO *********************************************************************************************************************
    
    
//Metodo para visualizar la tabla de Cajeros ################################################################################################################################
    public void visualizarCa(){
        try {
            String [] titulos={"Usuario", "Nombre", "Apellido", "Fecha de nacimiento", "Telefono"};
            String [] registros = new String[8];
            String SQL="SELECT usuario,nombre,apellido,f_nacimiento,telefono FROM usuario WHERE rol = 'Cajero'";
                       
            model = new DefaultTableModel(null,titulos);
            Statement st =con.createStatement();
            ResultSet rs = st.executeQuery(SQL);          
            while(rs.next()){
                registros[0]=rs.getString("usuario");
                registros[1]=rs.getString("nombre");
                registros[2]=rs.getString("apellido");
                registros[3]=rs.getString("f_nacimiento");
                registros[4]=rs.getString("telefono");
                model.addRow(registros);  
            }
               
            Table_Cajero.setModel(model);
         
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//METODO PARA INSERTAR UN NUEVO USUARIO################################################################################################################################################
    
    public void InsertarCa(){
     try {
             if (txtAgregar_Nombre_Ca.getText().length() > 0 && txtAgregar_Usuario_Ca.getText().length() > 0 
              && txtAgregar_Apellido_Ca.getText().length() > 0 && txtAgregar_Fecha_Ca.getText().length() >0 && 
              txtAgregar_Telefono_Ca.getText().length() >0 && txt_Agregar_Contra_Ca.getText().length() > 0){  
            SQL="INSERT INTO usuario (usuario,nombre,apellido,f_nacimiento,telefono,contraseña,rol) VALUES (?,?,?,?,?,?,?) ";
            ps = con.prepareStatement(SQL);
            
            ps.setString(1, txtAgregar_Usuario_Ca.getText());
            ps.setString(2, txtAgregar_Nombre_Ca.getText());
            ps.setString(3, txtAgregar_Apellido_Ca.getText());
            ps.setString(4, txtAgregar_Fecha_Ca.getText());
            ps.setString(5, txtAgregar_Telefono_Ca.getText());
            String target = txt_Agregar_Contra_Ca.getText();
            String encrypted = encrypt(target);
            ps.setString(6, encrypted);
            ps.setString(7, "Cajero"); 
            //ps.setString(7, txtAgregar_Rol.getSelectedItem().toString());        
            
//                System.out.println("String To Encrypt: " + target);
//                System.out.println("Encrypted String: " + encrypted);   
                
            int res = ps.executeUpdate();
                if(res>0){
                     LimpiarJtextCa();
                     SD_Cajero_Agregar.dispose();
                     visualizarCa();
                     JOptionPane.showMessageDialog(null,"REGISTRO EXITOSO");
                     
                }else{
                JOptionPane.showMessageDialog(null,"NO SE PUDO REALIZAR EL PROCESO","ADVERTENCIA!" ,JOptionPane.WARNING_MESSAGE);
                }
            } else {
            
            JOptionPane.showMessageDialog(null,"REVISAR LOS CAMPOS VACIOS","ADVERTENCIA!" ,JOptionPane.WARNING_MESSAGE);
            }
     }
        catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }    
    
    
//METODO PARA LIMPIAR LOS JTEXTFIELD CAJERO#############################################################################################################
    
    public void LimpiarJtextCa(){
       txtAgregar_Nombre_Ca.setText("");
       txtAgregar_Apellido_Ca.setText("");
       txtAgregar_Usuario_Ca.setText("");
       txtAgregar_Fecha_Ca.setText("");
       txt_Agregar_Contra_Ca.setText("");
       txtAgregar_Telefono_Ca.setText("");
       LB_usuario_Ca.setText("");
       txtEdit_Nombre_Ca.setText("");
       txtEdit_Apellido_Ca.setText("");
       txt_Edit_Contra_Ca.setText("");
       txtEdit_Fecha_Ca.setText("");
       txtEdit_Telefono_Ca.setText("");
    }
    
    
//METODO PARA SELECCIONAR UNA FILAANTES DE EDITAR###################################################################################################################################
    public void SeleccionarEditarCa(){
     int FilaSelect = Table_Cajero.getSelectedRow();
        if(FilaSelect >=0){
            
            LB_usuario_Ca.setText(Table_Cajero.getValueAt(FilaSelect, 0).toString());
            txtEdit_Nombre_Ca.setText(Table_Cajero.getValueAt(FilaSelect, 1).toString());
            txtEdit_Apellido_Ca.setText(Table_Cajero.getValueAt(FilaSelect, 2).toString());
            txtEdit_Fecha_Ca.setText(Table_Cajero.getValueAt(FilaSelect, 3).toString());
            txtEdit_Telefono_Ca.setText(Table_Cajero.getValueAt(FilaSelect, 4).toString());
            //txtEdit_Password.setText(Table_Admin.getValueAt(FilaSelect, 5).toString());
            //txtEdit_Rol.setSelectedItem(Table_Admin.getValueAt(FilaSelect, 6).toString());
 
       SD_Cajero_Editar.setVisible(true);
       SD_Cajero_Editar.setSize(615, 450);
       SD_Cajero_Editar.setModal(true);
       SD_Cajero_Editar.setLocationRelativeTo(null);  
        
        }
        else
        {
              JOptionPane.showMessageDialog(null,"SELECCIONA EL USUARIO QUE QUIERES MODIFICAR");
        }
    }
    
    
//METODO PARA  EDITAR CAJERO EN LA BASE DE DATOS##########################################################################################################
public void EditarCajero(){
try {
            if (txt_Edit_Contra_Ca.getText().length()!=0){
                
                System.out.println("Entro al IF"); 
            SQL="UPDATE usuario SET  nombre=?, apellido=?, f_nacimiento=?, telefono=?, contraseña=?, rol=? WHERE usuario=? ";
            ps = con.prepareStatement(SQL);
            
            ps.setString(1, txtEdit_Nombre_Ca.getText());
            ps.setString(2, txtEdit_Apellido_Ca.getText());
            ps.setString(3, txtEdit_Fecha_Ca.getText().toString());           
            ps.setString(4, txtEdit_Telefono_Ca.getText());
            String target = txt_Edit_Contra_Ca.getText();
            String encrypted = encrypt(target);
            ps.setString(5, encrypted);
            ps.setString(6, txtEdit_Rol_Ca.getSelectedItem().toString());
            ps.setString(7, LB_usuario_Ca.getText());
            
            int res = ps.executeUpdate();
                if(res>0){
                     LimpiarJtextCa();
                     visualizarCa();
                     SD_Cajero_Editar.dispose();
                }else{
                JOptionPane.showMessageDialog(null,"VERIFICA QUE EL USUARIO ESTE CORRECTO");
                }
            }   else {
                
                System.out.println("Entro al ELSE"); 
            SQL="UPDATE usuario SET  nombre=?, apellido=?, f_nacimiento=?, telefono=?, rol=? WHERE usuario=? ";
            ps = con.prepareStatement(SQL);
            
           
            ps.setString(1, txtEdit_Nombre_Ca.getText());
            ps.setString(2, txtEdit_Apellido_Ca.getText());
            ps.setString(3, txtEdit_Fecha_Ca.getText().toString());           
            ps.setString(4, txtEdit_Telefono_Ca.getText()); 
            ps.setString(5, txtEdit_Rol_Ca.getSelectedItem().toString());
            ps.setString(6, LB_usuario_Ca.getText());
            
            int res = ps.executeUpdate();
                if(res>0){
                     LimpiarJtextCa();
                     visualizarCa();
                     SD_Cajero_Editar.dispose();
                }else{
                JOptionPane.showMessageDialog(null,"VERIFICA QUE EL USUARIO ESTE CORRECTO");
                }
            
            
            }
       } 
        
        catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }             
}
    
    
    
    
    
    

    
    
    
    
    
    private void btnCajero_CerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCajero_CerrarMouseClicked
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCajero_CerrarMouseClicked

    private void btnAdmin_CerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdmin_CerrarMouseClicked
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdmin_CerrarMouseClicked

    private void txtAgregar_NombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgregar_NombreKeyTyped
           // TODO add your handling code here:
    }//GEN-LAST:event_txtAgregar_NombreKeyTyped

    private void btnSD_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSD_AgregarActionPerformed

           InsertarRol();
           
    }//GEN-LAST:event_btnSD_AgregarActionPerformed

    private void LB_Agregar_AdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LB_Agregar_AdminMouseClicked
        SDadmin_agregar.setVisible(true);
       SDadmin_agregar.setSize(615, 400);
       SDadmin_agregar.setModal(true);
       SDadmin_agregar.setLocationRelativeTo(null);  
    }//GEN-LAST:event_LB_Agregar_AdminMouseClicked

    private void btnSDeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSDeditActionPerformed
       EditarAdmin();
    }//GEN-LAST:event_btnSDeditActionPerformed

    private void txtEdit_NombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdit_NombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdit_NombreKeyTyped

    private void LB_EditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LB_EditarMouseClicked
        SeleccionarEditar();
    }//GEN-LAST:event_LB_EditarMouseClicked

    private void LB_Agregar_CajeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LB_Agregar_CajeroMouseClicked
       SD_Cajero_Agregar.setVisible(true);
       SD_Cajero_Agregar.setSize(615, 400);
       SD_Cajero_Agregar.setModal(true);
       SD_Cajero_Agregar.setLocationRelativeTo(null);  
    }//GEN-LAST:event_LB_Agregar_CajeroMouseClicked

    private void LB_Editar_CajeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LB_Editar_CajeroMouseClicked
        SeleccionarEditarCa();
    }//GEN-LAST:event_LB_Editar_CajeroMouseClicked

    private void txtAgregar_Nombre_CaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgregar_Nombre_CaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgregar_Nombre_CaKeyTyped

    private void btnSD_Agregar_CaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSD_Agregar_CaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSD_Agregar_CaActionPerformed

    private void btnSD_Agregar_CaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSD_Agregar_CaMouseClicked
       InsertarCa();
    }//GEN-LAST:event_btnSD_Agregar_CaMouseClicked

    private void btnSDedit_CaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSDedit_CaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSDedit_CaActionPerformed

    private void txtEdit_Nombre_CaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdit_Nombre_CaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdit_Nombre_CaKeyTyped

    private void btnSDedit_CaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSDedit_CaMouseClicked
       EditarCajero();
    }//GEN-LAST:event_btnSDedit_CaMouseClicked

    private void LB_Agregar_CaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LB_Agregar_CaMouseClicked
      SD_Cajero_Agregar.setVisible(true);
       SD_Cajero_Agregar.setSize(615, 400);
       SD_Cajero_Agregar.setModal(true);
       SD_Cajero_Agregar.setLocationRelativeTo(null); 
    }//GEN-LAST:event_LB_Agregar_CaMouseClicked

    private void lb_Agregar_AdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_Agregar_AdminMouseClicked
       SDadmin_agregar.setVisible(true);
       SDadmin_agregar.setSize(615, 400);
       SDadmin_agregar.setModal(true);
       SDadmin_agregar.setLocationRelativeTo(null);  
    }//GEN-LAST:event_lb_Agregar_AdminMouseClicked

    private void Lb_Editar_AdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lb_Editar_AdminMouseClicked
        SeleccionarEditar();
    }//GEN-LAST:event_Lb_Editar_AdminMouseClicked

    private void Lb_Editar_CaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lb_Editar_CaMouseClicked
      SeleccionarEditarCa();
    }//GEN-LAST:event_Lb_Editar_CaMouseClicked

    private void txt_buscar_AdminKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscar_AdminKeyTyped
       txt_buscar_Admin.addKeyListener(new KeyAdapter() {
           @Override
           public void keyReleased (final KeyEvent e){  
               String cadena =  (txt_buscar_Admin.getText());
               txt_buscar_Admin.setText(cadena);
               BuscarAdmin();
               Mayus();
               visualizar();
                     }
       });
       Buscar = new TableRowSorter(Table_Admin.getModel());
       Table_Admin.setRowSorter(Buscar);
       
    }//GEN-LAST:event_txt_buscar_AdminKeyTyped


    
    private void txt_buscar_CajeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscar_CajeroKeyTyped
      txt_buscar_Cajero.addKeyListener(new KeyAdapter() {
           public void keyReleased (final KeyEvent e){  
               String cadena =  (txt_buscar_Cajero.getText());
               txt_buscar_Cajero.setText(cadena);
               BuscarCajero();
               Mayus();
           }
    
});
       Buscar = new TableRowSorter(Table_Cajero.getModel());
       Table_Cajero.setRowSorter(Buscar);
        
    }//GEN-LAST:event_txt_buscar_CajeroKeyTyped

     
 
    
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
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Usuarios().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JP_Agregar_admin;
    private javax.swing.JPanel JP_Agregar_admin1;
    private javax.swing.JLabel LB_Agregar_Admin;
    private javax.swing.JLabel LB_Agregar_Ca;
    private javax.swing.JLabel LB_Agregar_Cajero;
    private javax.swing.JLabel LB_Editar;
    private javax.swing.JLabel LB_Editar_Cajero;
    private javax.swing.JLabel LB_usuario;
    private javax.swing.JLabel LB_usuario_Ca;
    private javax.swing.JLabel Lb_Editar_Admin;
    private javax.swing.JLabel Lb_Editar_Ca;
    private javax.swing.JDialog SD_Cajero_Agregar;
    private javax.swing.JDialog SD_Cajero_Editar;
    private javax.swing.JDialog SD_Editar_Admin;
    private javax.swing.JDialog SDadmin_agregar;
    private javax.swing.JTable Table_Admin;
    private javax.swing.JTable Table_Cajero;
    private javax.swing.JLabel btnAdmin_Cerrar;
    private javax.swing.JLabel btnCajero_Cerrar;
    private javax.swing.JButton btnSD_Agregar;
    private javax.swing.JButton btnSD_Agregar_Ca;
    private javax.swing.JButton btnSDedit;
    private javax.swing.JButton btnSDedit_Ca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JLabel lb_Agregar_Admin;
    private javax.swing.JTextField txtAgregar_Apellido;
    private javax.swing.JTextField txtAgregar_Apellido_Ca;
    private javax.swing.JTextField txtAgregar_Fecha;
    private javax.swing.JTextField txtAgregar_Fecha_Ca;
    private javax.swing.JTextField txtAgregar_Nombre;
    private javax.swing.JTextField txtAgregar_Nombre_Ca;
    private javax.swing.JTextField txtAgregar_Telefono;
    private javax.swing.JTextField txtAgregar_Telefono_Ca;
    private javax.swing.JTextField txtAgregar_Usuario;
    private javax.swing.JTextField txtAgregar_Usuario_Ca;
    private javax.swing.JTextField txtEdit_Apellido;
    private javax.swing.JTextField txtEdit_Apellido_Ca;
    private javax.swing.JTextField txtEdit_Fecha;
    private javax.swing.JTextField txtEdit_Fecha_Ca;
    private javax.swing.JTextField txtEdit_Nombre;
    private javax.swing.JTextField txtEdit_Nombre_Ca;
    private javax.swing.JComboBox<String> txtEdit_Rol;
    private javax.swing.JComboBox<String> txtEdit_Rol_Ca;
    private javax.swing.JTextField txtEdit_Telefono;
    private javax.swing.JTextField txtEdit_Telefono_Ca;
    private javax.swing.JPasswordField txt_Admin_Contra;
    private javax.swing.JPasswordField txt_Agregar_Contra_Ca;
    private javax.swing.JPasswordField txt_Edit_Contra;
    private javax.swing.JPasswordField txt_Edit_Contra_Ca;
    private javax.swing.JTextField txt_buscar_Admin;
    private javax.swing.JTextField txt_buscar_Cajero;
    // End of variables declaration//GEN-END:variables
}