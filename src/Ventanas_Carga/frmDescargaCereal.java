/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmDescargaCereal.java
 *
 * Created on 10/11/2011, 21:25:54
 */
package Ventanas_Carga;

import Clases_Modulo_Carga.*;

import Clases_Modulo_Transporte.Transportista;
import Clases_Modulo_Transporte.Vehiculo;
import Gestores_Vista.gestorDescargaCereal;
import Clases_Modulo_Viaje.*;
import Gestores_Clases.gestorBitacora;
import Hibernate.GestorHibernate;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TimeZone;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Charito
 */
public class frmDescargaCereal extends javax.swing.JInternalFrame {
gestorDescargaCereal gestorD = new gestorDescargaCereal();
GestorHibernate gestorH = new GestorHibernate();
    /** Creates new form frmDescargaCereal */
    public frmDescargaCereal() {
        initComponents();
        gestorH.actualizarUsuario(labelusuario);
        gestorD.rellenaTablaProductor(tblEstablecimiento);
        cmbSilo.setModel(gestorD.rellenaComboSilo());
        cmbCaracteristica.setModel(gestorD.rellenaComboCaracteristica());
        
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
        
        
        
        //redimensionar columnas de la tabla
        tblEstablecimiento.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblEstablecimiento.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblCaracteristica.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblCaracteristica.getColumnModel().getColumn(1).setPreferredWidth(50);
        
        
         //Las siguientes lineas son para dar a la pantalla el tamaño requerido y luego centrarla en la pantalla.
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = kit.getScreenSize();
        int ancho = 720;
        int alto = 620;
        int posX = (int) ((tamanioPantalla.width - ancho) / 2);
//        int posY = (int) ((tamanioPantalla.height - alto) / 2);
        this.setSize(ancho, alto);
        this.setLocation(posX, 10);        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        labelusuario = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstablecimiento = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtEstablecimiento = new javax.swing.JTextField();
        txtProductor = new javax.swing.JTextField();
        txtNumViaje = new javax.swing.JTextField();
        txtPesoNeto = new javax.swing.JTextField();
        txtTara = new javax.swing.JTextField();
        txtPesoTotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cmbSilo = new javax.swing.JComboBox();
        txtTransportista = new javax.swing.JTextField();
        txtVehiculo = new javax.swing.JTextField();
        txtDominio = new javax.swing.JTextField();
        txtTipoCereal = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        cmbCaracteristica = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCaracteristica = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnAgregarCaracteristica = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);
        setTitle("Descarga de Cereal");

        jPanel3.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Fecha");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(10, 8, 50, 20);
        jPanel3.add(txtFecha);
        txtFecha.setBounds(50, 10, 80, 20);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Hora");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(180, 10, 40, 20);
        jPanel3.add(txtHora);
        txtHora.setBounds(210, 10, 80, 20);

        labelusuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelusuario.setText("Usuario");
        jPanel3.add(labelusuario);
        labelusuario.setBounds(580, 10, 50, 15);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/UsuarioLogueado.png"))); // NOI18N
        jPanel3.add(jLabel12);
        jLabel12.setBounds(630, 0, 30, 30);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Descarga", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        jPanel1.setLayout(null);

        tblEstablecimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Establecimiento", "Productor", "Nro. de Viaje"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEstablecimiento.getTableHeader().setResizingAllowed(false);
        tblEstablecimiento.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblEstablecimiento);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(60, 30, 570, 120);

        btnAgregar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aceptar.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar);
        btnAgregar.setBounds(640, 70, 40, 30);

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("Productor");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(40, 160, 80, 20);

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setText("Establecimiento");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(330, 160, 130, 20);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Nº Viaje");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 190, 70, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Tipo Cereal");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 250, 110, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Transportista");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(340, 190, 120, 20);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Vehículo");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 220, 90, 20);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Dominio");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(370, 220, 80, 20);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Tara");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(70, 280, 50, 20);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Peso Total");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(250, 280, 100, 20);

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("Peso Neto");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(470, 280, 90, 20);

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setText("Silo Nº");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(270, 250, 70, 20);
        jPanel1.add(txtEstablecimiento);
        txtEstablecimiento.setBounds(430, 160, 200, 20);
        jPanel1.add(txtProductor);
        txtProductor.setBounds(100, 160, 200, 20);
        jPanel1.add(txtNumViaje);
        txtNumViaje.setBounds(100, 190, 100, 20);
        jPanel1.add(txtPesoNeto);
        txtPesoNeto.setBounds(540, 280, 100, 20);

        txtTara.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTaraKeyReleased(evt);
            }
        });
        jPanel1.add(txtTara);
        txtTara.setBounds(100, 280, 100, 20);

        txtPesoTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesoTotalKeyReleased(evt);
            }
        });
        jPanel1.add(txtPesoTotal);
        txtPesoTotal.setBounds(320, 280, 100, 20);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel4.setText("Tn.");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(640, 280, 34, 20);

        jLabel17.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel17.setText("Tn.");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(200, 280, 34, 20);

        jLabel18.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel18.setText("Tn.");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(420, 280, 34, 20);

        jPanel1.add(cmbSilo);
        cmbSilo.setBounds(320, 250, 100, 20);
        jPanel1.add(txtTransportista);
        txtTransportista.setBounds(430, 190, 200, 20);
        jPanel1.add(txtVehiculo);
        txtVehiculo.setBounds(100, 220, 200, 20);
        jPanel1.add(txtDominio);
        txtDominio.setBounds(430, 220, 90, 20);
        jPanel1.add(txtTipoCereal);
        txtTipoCereal.setBounds(100, 250, 100, 20);

        btnSalir.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Muestra Tomada", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        jPanel2.setLayout(null);

        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setText("Valor");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(70, 70, 80, 20);
        jPanel2.add(txtValor);
        txtValor.setBounds(110, 70, 91, 20);

        jLabel21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel21.setText("Característica");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(20, 30, 110, 20);

        jPanel2.add(cmbCaracteristica);
        cmbCaracteristica.setBounds(110, 30, 190, 20);

        tblCaracteristica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Característica", "Valor"
            }
        ));
        jScrollPane2.setViewportView(tblCaracteristica);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(310, 30, 370, 98);

        btnAgregarCaracteristica.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnAgregarCaracteristica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N
        btnAgregarCaracteristica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCaracteristicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(btnAgregarCaracteristica, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnAgregarCaracteristica, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(180, 40, 90, 80);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//evento salida
private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    int respuesta = JOptionPane.showConfirmDialog(null, "¿Confirma que desea salir?");
    if (respuesta==0){
    dispose();
    }
}//GEN-LAST:event_btnSalirActionPerformed

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    Iterator ite = gestorH.listarClase(TipoCereal.class).iterator();
    while(ite.hasNext()){
        TipoCereal tipo = (TipoCereal) ite.next();
        Iterator ite1 = gestorH.listarClase(Transportista.class).iterator();
        while(ite1.hasNext()){
            Transportista transportista = (Transportista) ite1.next();
            if(transportista.toString().equalsIgnoreCase(txtTransportista.getText()) && tipo.getNombreCereal().equalsIgnoreCase(txtTipoCereal.getText())){
                gestorD.guardarDescarga(tblCaracteristica, txtEstablecimiento, txtFecha, txtHora, txtNumViaje, tipo, txtPesoNeto, transportista, (Silo)cmbSilo.getSelectedItem());
            }
        }
    }
    Iterator ite1 = gestorH.listarClase(Vehiculo.class).iterator();
    while(ite1.hasNext()){
        Vehiculo v = (Vehiculo) ite1.next();
        if(v.getDominio().equalsIgnoreCase(txtDominio.getText())){
            v.setEstado("Disponible");
            gestorH.actualizarObjeto(v);
        }
    
    }
    Iterator ite2 = gestorH.listarClase(Viaje.class).iterator();
    while(ite2.hasNext()){
        Viaje vi = (Viaje) ite2.next();
        if(vi.getIdViaje() == (Long.parseLong(txtNumViaje.getText()))){
            vi.setEstado("Finalizado");
            gestorH.actualizarObjeto(vi);
            gestorBitacora gestorB = new gestorBitacora();
            gestorB.cargarBitacora(String.valueOf(vi.getIdViaje()), txtFecha.getText(), 14, labelusuario.getText());
        }
    
    }
    JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente");
}//GEN-LAST:event_btnGuardarActionPerformed

private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
    DefaultTableModel modeloT = (DefaultTableModel) tblEstablecimiento.getModel();
    int fila = tblEstablecimiento.getSelectedRow();
    txtProductor.setText(modeloT.getValueAt(fila, 1).toString());
    txtEstablecimiento.setText(modeloT.getValueAt(fila, 0).toString());
    txtNumViaje.setText(modeloT.getValueAt(fila, 2).toString());
    Iterator ite = gestorH.listarClase(Viaje.class).iterator();
    while(ite.hasNext()){
        Viaje viaje = (Viaje) ite.next();
        if(viaje.getIdViaje() == modeloT.getValueAt(fila, 2)){
            txtVehiculo.setText(viaje.getVehiculo().toString());
            txtTransportista.setText(viaje.getVehiculo().getTransportista().toString());
            txtDominio.setText(viaje.getVehiculo().getDominio().toString());
            txtTipoCereal.setText(viaje.getSolicitud().getTipoCereal().toString());
            txtTara.setText(String.valueOf(viaje.getVehiculo().getTara()));
        }
    }
}//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAgregarCaracteristicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCaracteristicaActionPerformed
        DefaultTableModel modeloTabla = (DefaultTableModel) tblCaracteristica.getModel();
        Object fila[]={cmbCaracteristica.getSelectedItem(), txtValor.getText()};
        modeloTabla.addRow(fila);
        tblCaracteristica.setModel(modeloTabla);
        txtValor.setText("");
    }//GEN-LAST:event_btnAgregarCaracteristicaActionPerformed

    private void txtTaraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTaraKeyReleased
    txtPesoNeto.setText(String.valueOf(Double.parseDouble(txtPesoTotal.getText()) - Double.parseDouble(txtTara.getText())));
    }//GEN-LAST:event_txtTaraKeyReleased

    private void txtPesoTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoTotalKeyReleased
    txtPesoNeto.setText(String.valueOf(Double.parseDouble(txtPesoTotal.getText()) - Double.parseDouble(txtTara.getText())));
    }//GEN-LAST:event_txtPesoTotalKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarCaracteristica;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cmbCaracteristica;
    private javax.swing.JComboBox cmbSilo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JLabel labelusuario;
    private javax.swing.JTable tblCaracteristica;
    private javax.swing.JTable tblEstablecimiento;
    private javax.swing.JTextField txtDominio;
    private javax.swing.JTextField txtEstablecimiento;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtNumViaje;
    private javax.swing.JTextField txtPesoNeto;
    private javax.swing.JTextField txtPesoTotal;
    private javax.swing.JTextField txtProductor;
    private javax.swing.JTextField txtTara;
    private javax.swing.JTextField txtTipoCereal;
    private javax.swing.JTextField txtTransportista;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextField txtVehiculo;
    // End of variables declaration//GEN-END:variables
}
