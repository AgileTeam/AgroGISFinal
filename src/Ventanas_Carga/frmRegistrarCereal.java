/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmRegistrarCereal.java
 *
 * Created on 05/11/2011, 22:23:20
 */
package Ventanas_Carga;

import Clases_Modulo_Carga.CaracteristicasCereal;
import Clases_Modulo_Carga.*;
import Gestores_Vista.gestorRegistrarCereal;
import Gestores_Vista.gestorRegistrarEnvioAlTaller;
import Hibernate.GestorHibernate;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TimeZone;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Charito
 */
public class frmRegistrarCereal extends javax.swing.JInternalFrame {
GestorHibernate gestorH = new GestorHibernate();
gestorRegistrarCereal gestorR = new gestorRegistrarCereal();
gestorRegistrarEnvioAlTaller gestorE = new gestorRegistrarEnvioAlTaller();
    /** Creates new form frmRegistrarCereal */
    public frmRegistrarCereal() {
        initComponents();
        gestorRegistrarCereal gRegistroCereal = new gestorRegistrarCereal();
        gestorH.actualizarUsuario(labelusuario);
        
        cmbMesInicioSiembra.setModel(gRegistroCereal.rellenaComboMes());
        cmbMesFinSiembra.setModel(gRegistroCereal.rellenaComboMes());
        cmbMesInicioCosecha.setModel(gRegistroCereal.rellenaComboMes());
        cmbMesFinCosecha.setModel(gRegistroCereal.rellenaComboMes());
        cmbCaracteristica.setModel(gRegistroCereal.rellenaComboCaracteristica());
        
        
        //deshabilitar campos de fecha y hora
        txtFecha.setEnabled(false);
        txtFecha.setEditable(false);
        txtHora.setEditable(false);
        txtHora.setEnabled(false);
        //setear el campo de fecha con la del sistema
        GregorianCalendar gc=new GregorianCalendar();
        GregorianCalendar.getInstance();
        gc.setTimeZone(TimeZone.getTimeZone("GMT-3"));
        gc.get(Calendar.DAY_OF_WEEK);
        gc.get(Calendar.MONTH);
        gc.get(Calendar.YEAR);
        SimpleDateFormat formateador= new SimpleDateFormat("dd-MM-yyyy");
        txtFecha.setText(formateador.format(gc.getTime()));
        //setear el campo de hora con la del sistema
        GregorianCalendar calendario=new GregorianCalendar();
        GregorianCalendar.getInstance();
        gc.setTimeZone(TimeZone.getTimeZone("GMT-3"));
        calendario.get(Calendar.HOUR);
        calendario.get(Calendar.MINUTE);
        SimpleDateFormat formateadorHora=new SimpleDateFormat("HH:mm");
        txtHora.setText(formateadorHora.format(calendario.getTime()));
        
        
                      
        //Las siguientes lineas son para dar a la pantalla el tamaño requerido y luego centrarla en la pantalla.
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = kit.getScreenSize();
        int ancho = 730;
        int alto = 620;
        int posX = (int) ((tamanioPantalla.width - ancho) / 2);
//        int posY = (int) ((tamanioPantalla.height - alto) / 2);
        this.setSize(ancho, alto);
        this.setLocation(280, 5);
        
        
        //redimensionar columnas de la tabla
        tblCaracteristica.getColumnModel().getColumn(0).setPreferredWidth(120);
        tblCaracteristica.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblCaracteristica.getColumnModel().getColumn(2).setPreferredWidth(50);
        //centrar cabecera de la tabla
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tblCaracteristica.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(0);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelusuario = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreCereal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaCereal = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelCosecha = new javax.swing.JLabel();
        labelSiembra = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbMesInicioCosecha = new javax.swing.JComboBox();
        cmbMesFinCosecha = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cmbMesInicioSiembra = new javax.swing.JComboBox();
        cmbMesFinSiembra = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        cmbCaracteristica = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtValorHasta = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtValorDesde = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCaracteristica = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEliminarLocal = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cereal");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Salir.png"))); // NOI18N
        btnCancelar.setText("Salir");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel4.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Fecha");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(10, 13, 40, 15);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Hora");
        jPanel4.add(jLabel11);
        jLabel11.setBounds(190, 10, 50, 20);

        labelusuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelusuario.setText("Usuario");
        jPanel4.add(labelusuario);
        labelusuario.setBounds(580, 10, 50, 15);
        jPanel4.add(txtFecha);
        txtFecha.setBounds(50, 10, 80, 20);
        jPanel4.add(txtHora);
        txtHora.setBounds(220, 10, 80, 20);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/UsuarioLogueado.png"))); // NOI18N
        jPanel4.add(jLabel13);
        jLabel13.setBounds(640, 0, 30, 30);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Cereal", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 20, 80, 20);

        txtNombreCereal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreCerealKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombreCereal);
        txtNombreCereal.setBounds(110, 20, 160, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Descripción");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 90, 80, 15);

        areaCereal.setColumns(20);
        areaCereal.setRows(5);
        jScrollPane1.setViewportView(areaCereal);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(110, 50, 450, 96);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Tipo Temporada");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(70, 160, 110, 20);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Mes Comienzo");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(370, 190, 120, 20);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Mes Fin");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(410, 220, 90, 20);

        labelCosecha.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        labelCosecha.setText("Cosecha");
        jPanel1.add(labelCosecha);
        labelCosecha.setBounds(170, 160, 90, 20);

        labelSiembra.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        labelSiembra.setText("Siembra");
        jPanel1.add(labelSiembra);
        labelSiembra.setBounds(460, 160, 90, 20);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Tipo Temporada");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(360, 160, 110, 20);

        jPanel1.add(cmbMesInicioCosecha);
        cmbMesInicioCosecha.setBounds(170, 190, 100, 20);

        jPanel1.add(cmbMesFinCosecha);
        cmbMesFinCosecha.setBounds(170, 220, 100, 20);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Mes Comienzo");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(80, 190, 90, 20);

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("Mes Fin");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(120, 220, 50, 20);

        jPanel1.add(cmbMesInicioSiembra);
        cmbMesInicioSiembra.setBounds(460, 190, 100, 20);

        jPanel1.add(cmbMesFinSiembra);
        cmbMesFinSiembra.setBounds(460, 220, 100, 20);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Características Cereal", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        jPanel3.setLayout(null);

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("Característica");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(20, 30, 92, 20);

        jPanel3.add(cmbCaracteristica);
        cmbCaracteristica.setBounds(100, 30, 180, 20);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Valor Desde");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(300, 30, 90, 20);
        jPanel3.add(txtValorHasta);
        txtValorHasta.setBounds(550, 30, 90, 20);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Valor Hasta");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(480, 30, 90, 20);
        jPanel3.add(txtValorDesde);
        txtValorDesde.setBounds(370, 30, 90, 20);

        tblCaracteristica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Característica", "Valor Desde", "Valor Hasta"
            }
        ));
        jScrollPane2.setViewportView(tblCaracteristica);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(40, 110, 590, 110);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregar);
        btnAgregar.setBounds(280, 70, 100, 30);

        btnEliminarLocal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        btnEliminarLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarLocalActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminarLocal);
        btnEliminarLocal.setBounds(640, 150, 40, 30);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icononuevo.PNG"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    int respuesta = JOptionPane.showConfirmDialog(null, "¿Confirma que desea salir?");
    if (respuesta==0){
    dispose();
    }
}//GEN-LAST:event_btnCancelarActionPerformed

private void txtNombreCerealKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCerealKeyTyped
    char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
          
        }else{
           evt.consume();
              }
}//GEN-LAST:event_txtNombreCerealKeyTyped

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    gestorR.guardarCaracteristicas(tblCaracteristica, txtNombreCereal, labelCosecha, labelSiembra, cmbMesInicioCosecha, cmbMesFinCosecha, cmbMesInicioSiembra, cmbMesFinSiembra);
    JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente");  
}//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
       txtNombreCereal.setText("");
       areaCereal.setText("");
       txtValorDesde.setText("");
       txtValorHasta.setText("");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       DefaultTableModel modeloT = (DefaultTableModel) tblCaracteristica.getModel();
       int campo = gestorE.campoObligatorio(txtNombreCereal, txtValorDesde, txtValorHasta);
       if(campo==0){
       Object fila[]={cmbCaracteristica.getSelectedItem(), txtValorDesde.getText(), txtValorHasta.getText()};
       modeloT.addRow(fila);
       tblCaracteristica.setModel(modeloT);
       txtNombreCereal.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
       txtValorDesde.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
       txtValorHasta.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
       }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarLocalActionPerformed
        DefaultTableModel modeloT = (DefaultTableModel) tblCaracteristica.getModel();
        modeloT.removeRow(tblCaracteristica.getSelectedRow());
    }//GEN-LAST:event_btnEliminarLocalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaCereal;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarLocal;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cmbCaracteristica;
    private javax.swing.JComboBox cmbMesFinCosecha;
    private javax.swing.JComboBox cmbMesFinSiembra;
    private javax.swing.JComboBox cmbMesInicioCosecha;
    private javax.swing.JComboBox cmbMesInicioSiembra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCosecha;
    private javax.swing.JLabel labelSiembra;
    private javax.swing.JLabel labelusuario;
    private javax.swing.JTable tblCaracteristica;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtNombreCereal;
    private javax.swing.JTextField txtValorDesde;
    private javax.swing.JTextField txtValorHasta;
    // End of variables declaration//GEN-END:variables
}
