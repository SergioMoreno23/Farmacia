/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

import MySql.conexion;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.util.JRLoader;
//import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Sergio
 */
public class Productos extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    private TableRowSorter Buscar;
    public Productos() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
      
          
        visualizar();
       // rsscalelabel.RSScaleLabel.setScaleLabel(btnAgregar,"src/iconos/btnAgregarProducto.png");
       // rsscalelabel.RSScaleLabel.setScaleLabel(btnEditar,"src/iconos/btnEditarProducto.png");
        //rsscalelabel.RSScaleLabel.setScaleLabel(btnEliminar,"src/iconos/btnEliminarProducto.png");
    }
     conexion cn = new conexion();
    Connection con = cn.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    String SQL;
    DefaultTableModel model;
     SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
    //ACA INICIAN TODOS LOS METODOS UTLIZADOS*************************************************************************************************************************************************++
    //Metodo para visualizar la tabla productos###################################################################################
    public void visualizar(){
        try {
            String [] titulos={"Clave", "Descripcion", "Gramos", "Contenido", "Tipo", "Precio Proveedor", "Precio Publico", "Stock"};
            String [] registros = new String[8];
            String SQL="SELECT id_producto,descripcion,gramos,contenido,tipo,precio_proveedor,precio_publico,stock FROM productos WHERE id_producto>10";
                       
            model = new DefaultTableModel(null,titulos);
            Statement st =con.createStatement();
            ResultSet rs = st.executeQuery(SQL);          
            while(rs.next()){
                registros[0]=rs.getString("id_producto");
                registros[1]=rs.getString("descripcion");
                registros[2]=rs.getString("gramos");
                registros[3]=rs.getString("contenido");
                registros[4]=rs.getString("tipo");
                registros[5]=rs.getString("precio_proveedor");
                registros[6]=rs.getString("precio_publico");
                registros[7]=rs.getString("stock");
                model.addRow(registros);  
            }
               
            TablaProductos.setModel(model);
         
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //METODO PARA FILTAR EN LA TABLA PRODUCTOS#####################################################
    public void BuscarProducto(){
        int Columna=1;
    
        Buscar.setRowFilter(RowFilter.regexFilter(txtBuscarProducto.getText(),Columna));
    }
    
    
    //METODO PARA SELECCIONAR FILA ANTES DE AGREGAR UN NUEVO PRODUCTO#####################################
     public void SeleccionarAgregar(){
     int FilaSelect = TablaProductos.getSelectedRow();
        if(FilaSelect >=0){
    
            SDeditarproducto.setVisible(true);
       SDeditarproducto.setSize(610, 468);
       SDeditarproducto.setModal(true);
       SDeditarproducto.setLocationRelativeTo(null);
        
        }
        else
        {
              JOptionPane.showMessageDialog(null,"SELECCIONA EL PRODUCTO QUE QUIERES MODIFICAR");
        }
    }
    
    //METODO PARA SELECCIONAR UNA FILAANTES DE EDITAR##########################################################3
    public void SeleccionarEditar(){
     int FilaSelect = TablaProductos.getSelectedRow();
        if(FilaSelect >=0){
            
            txtEdit_Clave.setText(TablaProductos.getValueAt(FilaSelect, 0).toString());
            txtEdit_Nombre.setText(TablaProductos.getValueAt(FilaSelect, 1).toString());
            txtEdit_Gramos.setText(TablaProductos.getValueAt(FilaSelect, 2).toString());
            txtEdit_Tipo.setSelectedItem(TablaProductos.getValueAt(FilaSelect, 4).toString());
            txtEdit_PrecioProveedor.setText(TablaProductos.getValueAt(FilaSelect, 5).toString());
            txtEdit_PrecioPublico.setText(TablaProductos.getValueAt(FilaSelect, 6).toString());
            txtEdit_Contenido.setText(TablaProductos.getValueAt(FilaSelect, 3).toString());
 
SDeditarproducto.setVisible(true);
       SDeditarproducto.setSize(610, 558);
       SDeditarproducto.setModal(true);
       SDeditarproducto.setLocationRelativeTo(null);  
        
        }
        else
        {
              JOptionPane.showMessageDialog(null,"SELECCIONA EL PRODUCTO QUE QUIERES MODIFICAR");
        }
    }
    
    //METODO PARA SELECCIONAR UNA FILA ANTES DE ELIMINAR#############################################################
//public void ExportarFaltantes(){
//     try {
//        JasperReport reporte = null;
//            String path="src\\Reportes\\ExportarInv.jasper";
//            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
//            JasperPrint print = JasperFillManager.fillReport(path,null,con);
//            JasperViewer view = new JasperViewer(print, false);
//            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//            view.setVisible(true);
//        } catch (JRException ex) {
//            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
//        }     
//   
//}

//METODO PARA SELECCIONAR UNA FILA ANTES DE ACTUALIZAR INVENTARIO###########################################################

public void ActualizarInventario(){
int FilaSelect = TablaProductos.getSelectedRow();
        if(FilaSelect >=0){
        txtIgualacion_Clave.setText(TablaProductos.getValueAt(FilaSelect, 0).toString());
         txtIgualacion_Nombre.setText(TablaProductos.getValueAt(FilaSelect, 1).toString());
         txtIgualacion_stock_sistema.setText(TablaProductos.getValueAt(FilaSelect, 7).toString());
         SDigualaioninventario.setVisible(true);
       SDigualaioninventario.setSize(510, 540);
       SDigualaioninventario.setModal(true);
       SDigualaioninventario.setLocationRelativeTo(null);  
        }
        else
        {
              JOptionPane.showMessageDialog(null,"SELECCIONA EL PRODUCTO QUE QUIERES ACTUALIZAR EL INVENTARIO");
        }
}
//METODO PARA SELECCIONAR EL PRODUCNTO QUE DESEA AGREGAR ENTRADAS######################################################################################
public void EntradasProdutos(){
int FilaSelect = TablaProductos.getSelectedRow();
        if(FilaSelect >=0){
             String pasofecha  = "";                
                    Date sistFecha=new Date();
                    pasofecha = (formatofecha.format(sistFecha));
         txtEntrada_Clave.setText(TablaProductos.getValueAt(FilaSelect, 0).toString());
         txtEntrada_Nombre.setText(TablaProductos.getValueAt(FilaSelect, 1).toString());
          txtEntrada_Fecha.setText(pasofecha);
         
       SDentradas.setVisible(true);
       SDentradas.setSize(510, 540);
       SDentradas.setModal(true);
       SDentradas.setLocationRelativeTo(null);  
        }
        else
        {
              JOptionPane.showMessageDialog(null,"SELECCIONA EL PRODUCTO PARA AGREGAR LAS ENTRADAS");
        }
}

//METODO PARA CONVENTIR EN MAYUSCULAS LA PRIMERA LETRA DEL TEXBOX##################################################################################
public void Mayus(){
String mayuscula = txtBuscarProducto.getText();
String mayuscula1 = txtEdit_Nombre.getText();

String mayuscula3 = txtAgregar_Nombre.getText();


       if(mayuscula.length()>0){
            char primer=mayuscula.charAt(0);
            mayuscula=Character.toUpperCase(primer)+mayuscula.substring(1,mayuscula.length());  
            txtBuscarProducto.setText(mayuscula);   
       } if(mayuscula1.length()>0){
             char primer1=mayuscula1.charAt(0);
             mayuscula1=Character.toUpperCase(primer1)+mayuscula1.substring(1,mayuscula1.length());
             txtEdit_Nombre.setText(mayuscula1);        
       }if(mayuscula3.length()>0){
         char primer3=mayuscula3.charAt(0);
             mayuscula3=Character.toUpperCase(primer3)+mayuscula3.substring(1,mayuscula3.length());
             txtAgregar_Nombre.setText(mayuscula3);
         }
          
}


//METODO PARA MODIFICAR EL STOCK EN LA TABLA DE PORDUCTOS######################################################################################

public void EditarStock(){
 try {
         SQL="UPDATE productos SET stock = stock + ? WHERE id_producto=?";
        ps = con.prepareStatement(SQL);
         
         ps.setString(1, txtEntrada_Entradas.getText());
         ps.setString(2, txtEntrada_Clave.getText());
          int res = ps.executeUpdate();
                if(res>0){
                     
                     visualizar();
                     SDigualaioninventario.dispose();
                }else{
                JOptionPane.showMessageDialog(null,"VERIFICA QUE LA CLABE DEL PRODUCTO ESTE CORRECTO");
                }
        
    } catch (SQLException ex) {
        Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
    }
}
//METODO PARA IGUALAR EL INVENTARIO###########################################################################################################################
public void Igualar(){

           
    try {
         SQL="UPDATE productos SET stock = ? WHERE id_producto=?";
        ps = con.prepareStatement(SQL);
         
         ps.setString(1, txtIgualacion_stock_fisico.getText());
         ps.setString(2, txtIgualacion_Clave.getText());
          int res = ps.executeUpdate();
                if(res>0){
                     
                     visualizar();
                     SDigualaioninventario.dispose();
                }else{
                JOptionPane.showMessageDialog(null,"VERIFICA QUE LA CLABE DEL PRODUCTO ESTE CORRECTO");
                }
        
    } catch (SQLException ex) {
        Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
    }

}
//METODO PARA  EDITAR UN PRODUCTO EN LA BASE DE DATOS##########################################################################################################
public void EditarProducto(){
try {
            SQL="UPDATE productos SET descripcion=?, gramos=?, contenido=?, tipo=?, precio_proveedor=?, precio_publico=? WHERE id_producto=? ";
            ps = con.prepareStatement(SQL);
            
            
            ps.setString(1, txtEdit_Nombre.getText());
            ps.setString(2, txtEdit_Gramos.getText());
            ps.setString(3, txtEdit_Contenido.getText());
            ps.setString(4, txtEdit_Tipo.getSelectedItem().toString());           
            ps.setString(5, txtEdit_PrecioProveedor.getText());
            ps.setString(6, txtEdit_PrecioPublico.getText());
             ps.setString(7, txtEdit_Clave.getText());
            
            int res = ps.executeUpdate();
                if(res>0){
                     Limpiar();
                     visualizar();
                     SDeditarproducto.dispose();
                }else{
                JOptionPane.showMessageDialog(null,"VERIFICA QUE LA CLABE DEL PRODUCTO ESTE CORRECTO");
                }
            } 
        
        catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }             
}

//METODO PARA INSERTAR ENTRADAS #############################################################################################

    public void InsertarEntradas(){
    try {
   
            SQL="INSERT INTO entradas (id_producto,fecha_registro,entradas) VALUES (?,?,?) ";
            ps = con.prepareStatement(SQL);
            
            ps.setString(1, txtEntrada_Clave.getText());
            ps.setString(2, txtEntrada_Fecha.getText());
            ps.setString(3, txtEntrada_Entradas.getText());
            
            
            int res = ps.executeUpdate();
                if(res>0){
                     Limpiar();
                     visualizar();
                     SDentradas.dispose();
                }else{
                JOptionPane.showMessageDialog(null,"ERROR AL AGREGAR UN NUEVO PRODUCTO");
                }
            } 
        
        catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
//METODO PARA INSERTAR EN IGUALACION DE PRODUCTO#############################################################################################################
public void InsertarIgualacion(){
        try {           
             String pasofecha  = "";                
                    Date sistFecha=new Date();
                    pasofecha = (formatofecha.format(sistFecha));
                    
            SQL="INSERT INTO igualacion_inventario (id_producto,stock_sistema,stock_fisico,fechas) VALUES (?,?,?,?)";
            ps = con.prepareStatement(SQL);
            int FilaSelect = TablaProductos.getSelectedRow();
            ps.setString(1,txtIgualacion_Clave.getText());
            ps.setString(2, txtIgualacion_stock_sistema.getText());
            ps.setString(3, txtIgualacion_stock_fisico.getText());
             ps.setString(4, pasofecha);
            int res = ps.executeUpdate();
            Limpiar();
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
}


//METODO PARA AGREGAR UN PRODUCTO NUEVO A LA BASE DE DATOS####################################################################################################
public void AgregarProducto(){
try {
   
            SQL="INSERT INTO productos (id_producto,descripcion,gramos,contenido,tipo,precio_proveedor,precio_publico,stock) VALUES (?,?,?,?,?,?,?,?) ";
            ps = con.prepareStatement(SQL);
            
            ps.setString(1, txtAgregar_Clave.getText());
            ps.setString(2, txtAgregar_Nombre.getText());
            ps.setString(3, txtAgregar_Gramos.getText());
            ps.setString(4, txtAgregar_Contenido.getText());
            ps.setString(5, txtAgregar_Tipo.getSelectedItem().toString());           
            ps.setString(6, txtAgregar_PrecioProveedor.getText());
            ps.setString(7, txtAgregar_PrecioPublico.getText());           
             ps.setString(8, txtAgregar_PrimerasEntradas.getText());
            
            int res = ps.executeUpdate();
                if(res>0){
                     Limpiar();
                     visualizar();
                     SDagregarproducto.dispose();
                }else{
                JOptionPane.showMessageDialog(null,"ERROR AL AGREGAR UN NUEVO PRODUCTO");
                }
            } 
        
        catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        } 
}

//METODO PARA LIMPIAR LOS TEXBOX#############################################################################################
public void Limpiar(){
txtEdit_Clave.setText("");
txtEdit_Nombre.setText("");
txtEdit_Contenido.setText("");
txtEdit_Gramos.setText("");
txtEdit_PrecioProveedor.setText("");
txtEdit_PrecioPublico.setText("");
txtEdit_Tipo.setSelectedIndex(0);

txtAgregar_Clave.setText("");
txtAgregar_Nombre.setText("");
txtAgregar_Contenido.setText("");
txtAgregar_Gramos.setText("");
txtAgregar_PrecioProveedor.setText("");
txtAgregar_PrecioPublico.setText("");
txtAgregar_Tipo.setSelectedIndex(0);

txtBuscarProducto.setText("");

txtIgualacion_Clave.setText("");
txtIgualacion_stock_sistema.setText("0");
txtIgualacion_stock_fisico.setText("0");
txtIgualacion_Nombre.setText("El Producto se igualo Correctamente");



}




    //ACA TERMINAN TODOS LOS METODOS UTILIZADOS******************************************************************************************************************************************
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SDagregarproducto = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtAgregar_Clave = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAgregar_Nombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAgregar_Gramos = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAgregar_Contenido = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtAgregar_PrecioProveedor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtAgregar_PrecioPublico = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtAgregar_PrimerasEntradas = new javax.swing.JTextField();
        txtAgregar_Fecha = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnSD_Agregar = new javax.swing.JButton();
        txtAgregar_Tipo = new javax.swing.JComboBox<>();
        SDeditarproducto = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtEdit_Clave = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtEdit_Nombre = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtEdit_Gramos = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtEdit_Contenido = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtEdit_PrecioProveedor = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtEdit_PrecioPublico = new javax.swing.JTextField();
        btnSDedit = new javax.swing.JButton();
        txtEdit_Tipo = new javax.swing.JComboBox<>();
        SDigualaioninventario = new javax.swing.JDialog();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtIgualacion_Clave = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtIgualacion_stock_sistema = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtIgualacion_stock_fisico = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtIgualacion_Nombre = new javax.swing.JLabel();
        SDexportarinventario = new javax.swing.JDialog();
        SDentradas = new javax.swing.JDialog();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txtEntrada_Entradas = new javax.swing.JTextField();
        txtEntrada_Clave = new javax.swing.JTextField();
        txtEntrada_Fecha = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btnEntrada_Insertar = new javax.swing.JButton();
        txtEntrada_Nombre = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtBuscarProducto = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JLabel();
        btnAgregarProducto = new javax.swing.JLabel();
        btnEditarProducto = new javax.swing.JLabel();
        btnEditar = new javax.swing.JLabel();
        btnProductos_Faltantes = new javax.swing.JLabel();
        btnFaltantes = new javax.swing.JLabel();
        btnExportarInventario = new javax.swing.JLabel();
        btnExportarInv = new javax.swing.JLabel();
        btnIgualarInventario = new javax.swing.JLabel();
        btnIgualarInv = new javax.swing.JLabel();
        btnEntradas = new javax.swing.JLabel();
        btnEntradaProducto = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(51, 51, 255));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Producto Nuevo");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtAgregar_Clave.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Clave:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Nombre:");

        txtAgregar_Nombre.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtAgregar_Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAgregar_NombreKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Gramos:");

        txtAgregar_Gramos.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Contenido:");

        txtAgregar_Contenido.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("Tipo:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Precio Proveedor:");

        txtAgregar_PrecioProveedor.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Precio Publico:");

        txtAgregar_PrecioPublico.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Primeras entradas:");

        txtAgregar_PrimerasEntradas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtAgregar_Fecha.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Fecha de Primera Entrada");

        btnSD_Agregar.setBackground(new java.awt.Color(0, 0, 255));
        btnSD_Agregar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSD_Agregar.setForeground(new java.awt.Color(255, 255, 255));
        btnSD_Agregar.setText("Agregar");
        btnSD_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSD_AgregarActionPerformed(evt);
            }
        });

        txtAgregar_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona...", "----------SOLIDOS----------", "Polvos", "Granulados", "Cápsulas", "Comprimidos", "Sellos", "Tabletas", "----------SEMI-SOLIDAS----------", "Pomadas", "Pastas", "Cremas", "Geles", "Implantes", "----------LIQUIDAS---------", " Soluciones", " Suspensiones", " Emulsiones", "Jarabes", " Elixires", " Lociones", "Inyectables" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtAgregar_Contenido, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtAgregar_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtAgregar_Gramos, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtAgregar_PrecioProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSD_Agregar))
                            .addComponent(txtAgregar_Fecha)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(txtAgregar_Clave, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addComponent(txtAgregar_PrecioPublico, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                                    .addComponent(txtAgregar_Tipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(txtAgregar_PrimerasEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(128, 128, 128))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAgregar_Clave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAgregar_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtAgregar_Tipo)
                    .addComponent(txtAgregar_Gramos, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAgregar_PrecioProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAgregar_Contenido, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAgregar_PrimerasEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAgregar_PrecioPublico, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(4, 4, 4)
                .addComponent(txtAgregar_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSD_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SDagregarproductoLayout = new javax.swing.GroupLayout(SDagregarproducto.getContentPane());
        SDagregarproducto.getContentPane().setLayout(SDagregarproductoLayout);
        SDagregarproductoLayout.setHorizontalGroup(
            SDagregarproductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        SDagregarproductoLayout.setVerticalGroup(
            SDagregarproductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(51, 51, 255));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Editar Producto");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtEdit_Clave.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Clave:");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setText("Nombre:");

        txtEdit_Nombre.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtEdit_Nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdit_NombreKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText("Gramos:");

        txtEdit_Gramos.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Contenido:");

        txtEdit_Contenido.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setText("Tipo:");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setText("Precio Proveedor:");

        txtEdit_PrecioProveedor.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setText("Precio Publico:");

        txtEdit_PrecioPublico.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btnSDedit.setBackground(new java.awt.Color(0, 0, 255));
        btnSDedit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSDedit.setForeground(new java.awt.Color(255, 255, 255));
        btnSDedit.setText("Editar");
        btnSDedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSDeditActionPerformed(evt);
            }
        });

        txtEdit_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona...", "----------SOLIDOS----------", "Polvos", "Granulados", "Cápsulas", "Comprimidos", "Sellos", "Tabletas", "----------SEMI-SOLIDAS----------", "Pomadas", "Pastas", "Cremas", "Geles", "Implantes", "----------LIQUIDAS---------", " Soluciones", " Suspensiones", " Emulsiones", "Jarabes", " Elixires", " Lociones", "Inyectables" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSDedit)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(txtEdit_Gramos, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)
                                    .addComponent(txtEdit_Clave, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel19)
                                        .addComponent(txtEdit_PrecioProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(txtEdit_PrecioPublico, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel15)
                                            .addComponent(txtEdit_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                                            .addComponent(jLabel18)
                                            .addComponent(txtEdit_Tipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEdit_Contenido, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(128, 128, 128))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEdit_Clave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEdit_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEdit_Gramos, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(txtEdit_Tipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEdit_PrecioPublico, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEdit_PrecioProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEdit_Contenido, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSDedit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SDeditarproductoLayout = new javax.swing.GroupLayout(SDeditarproducto.getContentPane());
        SDeditarproducto.getContentPane().setLayout(SDeditarproductoLayout);
        SDeditarproductoLayout.setHorizontalGroup(
            SDeditarproductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        SDeditarproductoLayout.setVerticalGroup(
            SDeditarproductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(0, 0, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Actualizar Inventario");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(22, 22, 22))
        );

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Clave del producto:");

        txtIgualacion_Clave.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtIgualacion_Clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIgualacion_ClaveActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Stock en el Sistema:");

        txtIgualacion_stock_sistema.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtIgualacion_stock_sistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIgualacion_stock_sistemaActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Stock en la farmacia:");

        txtIgualacion_stock_fisico.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtIgualacion_stock_fisico.setText("0");
        txtIgualacion_stock_fisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIgualacion_stock_fisicoActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtIgualacion_Nombre.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtIgualacion_Nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtIgualacion_Nombre.setText("Nombre del Producto");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel23)
                        .addComponent(txtIgualacion_stock_fisico, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22)
                        .addComponent(txtIgualacion_stock_sistema, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21)
                        .addComponent(txtIgualacion_Clave, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
            .addComponent(txtIgualacion_Nombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtIgualacion_Nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIgualacion_Clave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIgualacion_stock_sistema, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIgualacion_stock_fisico, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout SDigualaioninventarioLayout = new javax.swing.GroupLayout(SDigualaioninventario.getContentPane());
        SDigualaioninventario.getContentPane().setLayout(SDigualaioninventarioLayout);
        SDigualaioninventarioLayout.setHorizontalGroup(
            SDigualaioninventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SDigualaioninventarioLayout.setVerticalGroup(
            SDigualaioninventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout SDexportarinventarioLayout = new javax.swing.GroupLayout(SDexportarinventario.getContentPane());
        SDexportarinventario.getContentPane().setLayout(SDexportarinventarioLayout);
        SDexportarinventarioLayout.setHorizontalGroup(
            SDexportarinventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        SDexportarinventarioLayout.setVerticalGroup(
            SDexportarinventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jPanel12.setBackground(new java.awt.Color(0, 0, 255));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Nueva Entrada");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(28, 28, 28))
        );

        txtEntrada_Entradas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtEntrada_Clave.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtEntrada_Fecha.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel25.setText("Clave de Producto:");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel26.setText("Entradas:");

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel27.setText("Fecha de Entradas:");

        btnEntrada_Insertar.setBackground(new java.awt.Color(0, 51, 255));
        btnEntrada_Insertar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnEntrada_Insertar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrada_Insertar.setText("Confirmar");
        btnEntrada_Insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrada_InsertarActionPerformed(evt);
            }
        });

        txtEntrada_Nombre.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtEntrada_Nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEntrada_Nombre.setText("Clave de Producto:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26)
                    .addComponent(jLabel25)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnEntrada_Insertar)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEntrada_Clave, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                            .addComponent(txtEntrada_Entradas)
                            .addComponent(txtEntrada_Fecha))))
                .addGap(32, 32, 32))
            .addComponent(txtEntrada_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(txtEntrada_Nombre)
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEntrada_Clave, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEntrada_Entradas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEntrada_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEntrada_Insertar)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SDentradasLayout = new javax.swing.GroupLayout(SDentradas.getContentPane());
        SDentradas.getContentPane().setLayout(SDentradasLayout);
        SDentradasLayout.setHorizontalGroup(
            SDentradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SDentradasLayout.setVerticalGroup(
            SDentradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TablaProductos.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Clave", "Descripcion", "Gramos", "Contenido", "Tipo", "Precio Proveeedor", "Precio Publico", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaProductos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        TablaProductos.setRowHeight(40);
        jScrollPane1.setViewportView(TablaProductos);
        if (TablaProductos.getColumnModel().getColumnCount() > 0) {
            TablaProductos.getColumnModel().getColumn(0).setMinWidth(100);
            TablaProductos.getColumnModel().getColumn(0).setPreferredWidth(100);
            TablaProductos.getColumnModel().getColumn(0).setMaxWidth(100);
            TablaProductos.getColumnModel().getColumn(1).setMinWidth(350);
            TablaProductos.getColumnModel().getColumn(1).setPreferredWidth(350);
            TablaProductos.getColumnModel().getColumn(1).setMaxWidth(350);
            TablaProductos.getColumnModel().getColumn(2).setPreferredWidth(100);
            TablaProductos.getColumnModel().getColumn(3).setPreferredWidth(100);
            TablaProductos.getColumnModel().getColumn(4).setPreferredWidth(150);
            TablaProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            TablaProductos.getColumnModel().getColumn(6).setPreferredWidth(100);
            TablaProductos.getColumnModel().getColumn(7).setPreferredWidth(85);
        }

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRO DE PRODUCTOS");

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btnCerrar_login.png"))); // NOI18N
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(191, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(37, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(21, 21, 21))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        txtBuscarProducto.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarProductoActionPerformed(evt);
            }
        });
        txtBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarProductoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscarProducto)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        btnAgregar.setBackground(new java.awt.Color(204, 255, 255));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btnAgregarProducto.png"))); // NOI18N
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });

        btnAgregarProducto.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnAgregarProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgregarProducto.setText("Agregar");
        btnAgregarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarProductoMouseClicked(evt);
            }
        });

        btnEditarProducto.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnEditarProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEditarProducto.setText("Editar");
        btnEditarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarProductoMouseClicked(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btnEditarProducto.png"))); // NOI18N
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
        });

        btnProductos_Faltantes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnProductos_Faltantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btnFaltantes.png"))); // NOI18N
        btnProductos_Faltantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductos_FaltantesMouseClicked(evt);
            }
        });

        btnFaltantes.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnFaltantes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFaltantes.setText("Faltantes");
        btnFaltantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFaltantesMouseClicked(evt);
            }
        });

        btnExportarInventario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExportarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btnExportarInventario.png"))); // NOI18N
        btnExportarInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportarInventarioMouseClicked(evt);
            }
        });

        btnExportarInv.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnExportarInv.setText("Exportar Inventario");

        btnIgualarInventario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnIgualarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btnIgualarInventario.png"))); // NOI18N
        btnIgualarInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIgualarInventarioMouseClicked(evt);
            }
        });

        btnIgualarInv.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnIgualarInv.setText("Actualizar Inventario");
        btnIgualarInv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIgualarInvMouseClicked(evt);
            }
        });

        btnEntradas.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnEntradas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEntradas.setText("Entradas");
        btnEntradas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnEntradasMouseDragged(evt);
            }
        });
        btnEntradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntradasMouseClicked(evt);
            }
        });

        btnEntradaProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEntradaProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/btnEntradas.png"))); // NOI18N
        btnEntradaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntradaProductoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarProducto)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEntradas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEntradaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFaltantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProductos_Faltantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnIgualarInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIgualarInv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExportarInv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExportarInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnProductos_Faltantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFaltantes, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEntradaProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEntradas))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIgualarInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnExportarInventario)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnExportarInv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnIgualarInv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarProductoActionPerformed
        
    }//GEN-LAST:event_txtBuscarProductoActionPerformed

    private void txtBuscarProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoKeyTyped
       txtBuscarProducto.addKeyListener(new KeyAdapter() {
           public void keyReleased (final KeyEvent e){  
               String cadena =  (txtBuscarProducto.getText());
               txtBuscarProducto.setText(cadena);
               BuscarProducto();
               Mayus();
           }
    
});
       Buscar = new TableRowSorter(TablaProductos.getModel());
       TablaProductos.setRowSorter(Buscar);
    }//GEN-LAST:event_txtBuscarProductoKeyTyped

    private void txtBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProductoKeyReleased

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        SDagregarproducto.setVisible(true);
       SDagregarproducto.setSize(610, 558);
       SDagregarproducto.setModal(true);
       SDagregarproducto.setLocationRelativeTo(null);  
            
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnAgregarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarProductoMouseClicked
     SDagregarproducto.setVisible(true);
       SDagregarproducto.setSize(610, 558);
       SDagregarproducto.setModal(true);
       SDagregarproducto.setLocationRelativeTo(null);  
       // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarProductoMouseClicked

    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseClicked
        SeleccionarEditar(); 
      
    }//GEN-LAST:event_btnEditarMouseClicked

    private void btnEditarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarProductoMouseClicked
       SeleccionarEditar();
      
    }//GEN-LAST:event_btnEditarProductoMouseClicked

    private void txtEdit_NombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdit_NombreKeyTyped
    Mayus();        // TODO add your handling code here:
    }//GEN-LAST:event_txtEdit_NombreKeyTyped

    private void txtAgregar_NombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgregar_NombreKeyTyped
    Mayus();        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgregar_NombreKeyTyped

    private void btnProductos_FaltantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductos_FaltantesMouseClicked
//ExportarFaltantes();
    }//GEN-LAST:event_btnProductos_FaltantesMouseClicked

    private void btnFaltantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFaltantesMouseClicked
       //ExportarFaltantes();
    }//GEN-LAST:event_btnFaltantesMouseClicked

    private void btnIgualarInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIgualarInventarioMouseClicked
        // TODO add your handling code here:
        ActualizarInventario();
    }//GEN-LAST:event_btnIgualarInventarioMouseClicked

    private void btnIgualarInvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIgualarInvMouseClicked
        ActualizarInventario();        // TODO add your handling code here:
    }//GEN-LAST:event_btnIgualarInvMouseClicked

    private void btnSDeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSDeditActionPerformed
        EditarProducto();   
       
        
// TODO add your handling code here:
    }//GEN-LAST:event_btnSDeditActionPerformed

    private void btnEntradaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntradaProductoMouseClicked
        EntradasProdutos();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntradaProductoMouseClicked

    private void btnEntradasMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntradasMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntradasMouseDragged

    private void btnEntradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntradasMouseClicked
        EntradasProdutos();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntradasMouseClicked

    private void btnSD_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSD_AgregarActionPerformed
        if(txtAgregar_Tipo.getSelectedItem().toString()=="Selecciona..." || txtAgregar_Tipo.getSelectedItem().toString()=="----------SOLIDOS----------" || txtAgregar_Tipo.getSelectedItem().toString()=="----------SEMI-SOLIDAS----------" || txtAgregar_Tipo.getSelectedItem().toString()=="----------LIQUIDAS---------"){
        JOptionPane.showMessageDialog(null, "SELECCIONE UN TIPO DE MEDICAMENTO");
        }else{
         AgregarProducto();
        }
       
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSD_AgregarActionPerformed

    private void txtIgualacion_ClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIgualacion_ClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIgualacion_ClaveActionPerformed

    private void txtIgualacion_stock_sistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIgualacion_stock_sistemaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIgualacion_stock_sistemaActionPerformed

    private void txtIgualacion_stock_fisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIgualacion_stock_fisicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIgualacion_stock_fisicoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Igualar();
        InsertarIgualacion();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEntrada_InsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrada_InsertarActionPerformed
   
EntradasProdutos();
 EditarStock();
 InsertarEntradas();
// TODO add your handling code here:
    }//GEN-LAST:event_btnEntrada_InsertarActionPerformed

    private void btnExportarInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportarInventarioMouseClicked
     //  try {
//            // TODO add your handling code here:
//            JasperReport reporte = null;
//            String path="src\\Reportes\\ExportarInv.jasper";
//            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
//            JasperPrint print = JasperFillManager.fillReport(path,null,con);
//            JasperViewer view = new JasperViewer(print, false);
//            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//            view.setVisible(true);
//        } catch (JRException ex) {
//            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnExportarInventarioMouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel28MouseClicked

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
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog SDagregarproducto;
    private javax.swing.JDialog SDeditarproducto;
    private javax.swing.JDialog SDentradas;
    private javax.swing.JDialog SDexportarinventario;
    private javax.swing.JDialog SDigualaioninventario;
    private javax.swing.JTable TablaProductos;
    private javax.swing.JLabel btnAgregar;
    private javax.swing.JLabel btnAgregarProducto;
    private javax.swing.JLabel btnEditar;
    private javax.swing.JLabel btnEditarProducto;
    private javax.swing.JLabel btnEntradaProducto;
    private javax.swing.JButton btnEntrada_Insertar;
    private javax.swing.JLabel btnEntradas;
    private javax.swing.JLabel btnExportarInv;
    private javax.swing.JLabel btnExportarInventario;
    private javax.swing.JLabel btnFaltantes;
    private javax.swing.JLabel btnIgualarInv;
    private javax.swing.JLabel btnIgualarInventario;
    private javax.swing.JLabel btnProductos_Faltantes;
    private javax.swing.JButton btnSD_Agregar;
    private javax.swing.JButton btnSDedit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAgregar_Clave;
    private javax.swing.JTextField txtAgregar_Contenido;
    private javax.swing.JTextField txtAgregar_Fecha;
    private javax.swing.JTextField txtAgregar_Gramos;
    private javax.swing.JTextField txtAgregar_Nombre;
    private javax.swing.JTextField txtAgregar_PrecioProveedor;
    private javax.swing.JTextField txtAgregar_PrecioPublico;
    private javax.swing.JTextField txtAgregar_PrimerasEntradas;
    private javax.swing.JComboBox<String> txtAgregar_Tipo;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtEdit_Clave;
    private javax.swing.JTextField txtEdit_Contenido;
    private javax.swing.JTextField txtEdit_Gramos;
    private javax.swing.JTextField txtEdit_Nombre;
    private javax.swing.JTextField txtEdit_PrecioProveedor;
    private javax.swing.JTextField txtEdit_PrecioPublico;
    private javax.swing.JComboBox<String> txtEdit_Tipo;
    private javax.swing.JTextField txtEntrada_Clave;
    private javax.swing.JTextField txtEntrada_Entradas;
    private javax.swing.JTextField txtEntrada_Fecha;
    private javax.swing.JLabel txtEntrada_Nombre;
    private javax.swing.JTextField txtIgualacion_Clave;
    private javax.swing.JLabel txtIgualacion_Nombre;
    private javax.swing.JTextField txtIgualacion_stock_fisico;
    private javax.swing.JTextField txtIgualacion_stock_sistema;
    // End of variables declaration//GEN-END:variables
}
