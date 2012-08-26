/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmRegistrarRetiroCereal.java
 *
 * Created on 05/11/2011, 22:24:13
 */
package Ventanas_Carga;


import Clases_Modulo_Carga.MuestraTomada;
import Clases_Modulo_Carga.Retiro;
import Clases_Modulo_Carga.SolicitudRetiro;
import Clases_Modulo_Transporte.OrdenServicio;
import Clases_Modulo_Transporte.Vehiculo;
import Clases_Modulo_Viaje.Viaje;
import Gestores_Vista.gestorFecha;
import Gestores_Vista.gestorRegistrarRetiro;
import Hibernate.GestorHibernate;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author Charito
 */
public class frmRegistrarRetiroCereal extends javax.swing.JInternalFrame {
GestorHibernate gestorH = new GestorHibernate();
    /** Creates new form frmRegistrarRetiroCereal */
    public frmRegistrarRetiroCereal() {
        initComponents();      
        
        txtFecha.setEnabled(false);
        txtFecha.setEditable(false);
        txtHora.setEditable(false);
        txtHora.setEnabled(false);
        
        calendarioDSolicitud.setEnabled(false);
        calendarioHSolicitud.setEnabled(false);
        txtNumSolicitud.setEnabled(false);
        cmbProductor.setEnabled(false);
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
        SimpleDateFormat formateadorHora=new SimpleDateFormat("hh:mm");
        txtHora.setText(formateadorHora.format(calendario.getTime()));
        
       
        //Las siguientes lineas son para dar a la pantalla el tamaño requerido y luego centrarla en la pantalla.
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = kit.getScreenSize();
        int ancho = 820;
        int alto = 635;
        int posX = (int) ((tamanioPantalla.width - ancho) / 2);
//        int posY = (int) ((tamanioPantalla.height - alto) / 2);
        this.setSize(ancho, alto);
        this.setLocation(posX, 0);
        
         //redimensionar columnas de la tabla
        tblSolicitud.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblSolicitud.getColumnModel().getColumn(1).setPreferredWidth(100);  
        tblSolicitud.getColumnModel().getColumn(2).setPreferredWidth(100); 
        tblSolicitud.getColumnModel().getColumn(3).setPreferredWidth(70); 


        
//        cmb.setEditable(true);
//        AutoCompleteDecorator.decorate(this.cmb);

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
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtTara = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblVehiculo = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        txtTransportista = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtVehiculo = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtNumeroSolicitud = new javax.swing.JTextField();
        txtToneladas = new javax.swing.JTextField();
        txtFechaSolicitud = new javax.swing.JTextField();
        txtPesoNeto = new javax.swing.JTextField();
        txtPesoTotal = new javax.swing.JTextField();
        btnAceptarVehiculo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSolicitud = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnAceptarSolicitud1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnBuscarSolicitud = new javax.swing.JButton();
        ckFecha = new javax.swing.JCheckBox();
        ckNumSolicitud = new javax.swing.JCheckBox();
        ckProductor = new javax.swing.JCheckBox();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        calendarioHSolicitud = new datechooser.beans.DateChooserCombo();
        calendarioDSolicitud = new datechooser.beans.DateChooserCombo();
        jPanel12 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtNumSolicitud = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        cmbProductor = new javax.swing.JComboBox();
        btnAceptarTodos1 = new javax.swing.JButton();
        btnCancelarTodos = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);
        setTitle("Retiro de Cereal");

        jPanel3.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Fecha");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(10, 10, 60, 20);
        jPanel3.add(txtFecha);
        txtFecha.setBounds(50, 10, 90, 20);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Hora");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(180, 10, 40, 20);
        jPanel3.add(txtHora);
        txtHora.setBounds(210, 10, 70, 20);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Usuario");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(680, 10, 50, 15);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/UsuarioLogueado.png"))); // NOI18N
        jPanel3.add(jLabel12);
        jLabel12.setBounds(730, 0, 30, 30);

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vehiculo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14)))); // NOI18N
        jPanel5.setLayout(null);

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("Toneladas");
        jPanel5.add(jLabel17);
        jLabel17.setBounds(240, 20, 100, 20);

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("Solicitud N°");
        jPanel5.add(jLabel18);
        jLabel18.setBounds(20, 20, 80, 20);
        jPanel5.add(txtTara);
        txtTara.setBounds(70, 180, 120, 20);

        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setText("Fecha Solicitud");
        jPanel5.add(jLabel19);
        jLabel19.setBounds(470, 20, 110, 20);

        tblVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vehiculo", "Capacidad de Vehiculo (Tn)", "Transportista"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVehiculo.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblVehiculo);

        jPanel5.add(jScrollPane3);
        jScrollPane3.setBounds(20, 50, 690, 90);

        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setText("Vehiculo");
        jPanel5.add(jLabel20);
        jLabel20.setBounds(20, 150, 70, 20);
        jPanel5.add(txtTransportista);
        txtTransportista.setBounds(460, 150, 250, 20);

        jLabel21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel21.setText("Transportista");
        jPanel5.add(jLabel21);
        jLabel21.setBounds(370, 150, 100, 20);
        jPanel5.add(txtVehiculo);
        txtVehiculo.setBounds(70, 150, 220, 20);

        jLabel22.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel22.setText("Tara ");
        jPanel5.add(jLabel22);
        jLabel22.setBounds(40, 180, 50, 20);

        jLabel23.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel23.setText("Peso Total");
        jPanel5.add(jLabel23);
        jLabel23.setBounds(270, 180, 90, 20);

        jLabel24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel24.setText("Peso Neto");
        jPanel5.add(jLabel24);
        jLabel24.setBounds(530, 180, 90, 20);
        jPanel5.add(txtNumeroSolicitud);
        txtNumeroSolicitud.setBounds(90, 20, 80, 20);
        jPanel5.add(txtToneladas);
        txtToneladas.setBounds(300, 20, 140, 20);
        jPanel5.add(txtFechaSolicitud);
        txtFechaSolicitud.setBounds(570, 20, 140, 20);
        jPanel5.add(txtPesoNeto);
        txtPesoNeto.setBounds(590, 180, 120, 20);
        jPanel5.add(txtPesoTotal);
        txtPesoTotal.setBounds(330, 180, 120, 20);

        btnAceptarVehiculo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnAceptarVehiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aceptar.png"))); // NOI18N
        btnAceptarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarVehiculoActionPerformed(evt);
            }
        });
        jPanel5.add(btnAceptarVehiculo);
        btnAceptarVehiculo.setBounds(720, 90, 49, 30);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setText("Kgs.");
        jPanel5.add(jLabel1);
        jLabel1.setBounds(710, 180, 30, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setText("Kgs.");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(190, 180, 30, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel3.setText("Kgs.");
        jPanel5.add(jLabel3);
        jLabel3.setBounds(450, 180, 30, 20);

        tblSolicitud.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Solicitud N°", "Productor", "Fecha de solicitud", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSolicitud.getTableHeader().setResizingAllowed(false);
        tblSolicitud.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblSolicitud);

        btnGuardar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnAceptarSolicitud1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnAceptarSolicitud1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aceptar.png"))); // NOI18N
        btnAceptarSolicitud1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarSolicitud1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Solicitudes Pendientes por", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel1.setLayout(null);

        btnBuscarSolicitud.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnBuscarSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btnBuscarSolicitud.setText("Buscar");
        btnBuscarSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarSolicitudActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarSolicitud);
        btnBuscarSolicitud.setBounds(380, 110, 104, 30);

        ckFecha.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        ckFecha.setText("Fecha Emision");
        jPanel1.add(ckFecha);
        ckFecha.setBounds(10, 30, 110, 23);

        ckNumSolicitud.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        ckNumSolicitud.setText("Numero Solicitud");
        jPanel1.add(ckNumSolicitud);
        ckNumSolicitud.setBounds(10, 50, 130, 23);

        ckProductor.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        ckProductor.setText("Productor");
        jPanel1.add(ckProductor);
        ckProductor.setBounds(10, 70, 100, 23);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel10.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Desde");
        jPanel10.add(jLabel7);
        jLabel7.setBounds(30, 20, 60, 20);

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("Hasta");
        jPanel10.add(jLabel13);
        jLabel13.setBounds(30, 50, 60, 20);
        jPanel10.add(calendarioHSolicitud);
        calendarioHSolicitud.setBounds(70, 50, 90, 20);
        jPanel10.add(calendarioDSolicitud);
        calendarioDSolicitud.setBounds(70, 20, 90, 20);

        jPanel1.add(jPanel10);
        jPanel10.setBounds(140, 20, 200, 90);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nº Solicitud", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel12.setLayout(null);

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setText("Nº");
        jPanel12.add(jLabel14);
        jLabel14.setBounds(30, 40, 50, 20);
        jPanel12.add(txtNumSolicitud);
        txtNumSolicitud.setBounds(50, 40, 120, 20);

        jPanel1.add(jPanel12);
        jPanel12.setBounds(340, 20, 200, 90);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel13.setLayout(null);

        jPanel13.add(cmbProductor);
        cmbProductor.setBounds(20, 40, 200, 20);

        jPanel1.add(jPanel13);
        jPanel13.setBounds(540, 20, 240, 90);

        btnAceptarTodos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/plus.png"))); // NOI18N
        btnAceptarTodos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarTodos1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptarTodos1);
        btnAceptarTodos1.setBounds(20, 100, 30, 30);

        btnCancelarTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        btnCancelarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarTodosActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelarTodos);
        btnCancelarTodos.setBounds(60, 100, 30, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAceptarSolicitud1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(303, 303, 303)
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnAceptarSolicitud1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    int respuesta = JOptionPane.showConfirmDialog(null, "Confirma que desea cancelar la operación?");
    if (respuesta==0){
    dispose();
    }
}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarVehiculoActionPerformed
        DefaultTableModel modeloTabla = (DefaultTableModel) tblVehiculo.getModel();
        GestorHibernate gestorH = new GestorHibernate();
        int fila = tblVehiculo.getSelectedRow();
        Iterator ite = gestorH.listarClase(Vehiculo.class).iterator();
        while(ite.hasNext()){
            Vehiculo vehiculo=  (Vehiculo) ite.next();
            if(vehiculo.getDominio().equals(modeloTabla.getValueAt(fila, 0))&& vehiculo.getCarga()>=Double.parseDouble(txtToneladas.getText())){
                txtVehiculo.setText(vehiculo.getDominio());
                txtTransportista.setText(vehiculo.getTransportista().toString());
                txtTara.setText(String.valueOf(vehiculo.getTara()));
            }
        }
    }//GEN-LAST:event_btnAceptarVehiculoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        GestorHibernate gestorH = new GestorHibernate();
        Retiro retiro = new Retiro();
        retiro.setPesoNeto(Double.parseDouble(txtTara.getText()));
        retiro.setPesoTotal(Double.parseDouble(txtPesoTotal.getText()));
        Iterator ite1 = gestorH.listarClase(Vehiculo.class).iterator();
        while(ite1.hasNext()){
            Vehiculo vehiculo = (Vehiculo) ite1.next();
            if(vehiculo.getDominio().equals(txtVehiculo.getText())){
                retiro.setVehiculo(vehiculo);
            }
        }
        Iterator ite2 = gestorH.listarClase(SolicitudRetiro.class).iterator();
        while(ite2.hasNext()){
            SolicitudRetiro solicitud = (SolicitudRetiro) ite2.next();
            if(solicitud.getNumeroSolicitud()== Long.parseLong(txtNumeroSolicitud.getText())){
                retiro.setSolicitud(solicitud);
            }
        }
        gestorH.guardarObjeto(retiro);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAceptarSolicitud1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarSolicitud1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarSolicitud1ActionPerformed

    private void btnBuscarSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSolicitudActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha1 = sdf.parse(calendarioDSolicitud.getText(), new ParsePosition(0));
        Date fecha3 = sdf.parse(calendarioHSolicitud.getText(), new ParsePosition(0));
        DefaultTableModel modeloT = (DefaultTableModel) tblSolicitud.getModel();
        //Verifico que este seleccionada la opcion de fecha
        if (calendarioDSolicitud.isEnabled()) {
            //Creo el objeto orden
            Iterator ite = gestorH.listarClase(SolicitudRetiro.class).iterator();
            while (ite.hasNext()) {
                int banderaFecha = 0;
                SolicitudRetiro solicitud = (SolicitudRetiro) ite.next();
                //Verifico que la muestra no este en la tabla previamente cargada
                for (int i = 0; i < modeloT.getRowCount(); i++) {
                    if (solicitud.getNumeroSolicitud() == modeloT.getValueAt(i, 0)) {
                        banderaFecha = 1;
                    }
                }
                //La orden no esta cargada
                if (banderaFecha == 0) {
                    Date fecha2 = sdf.parse(solicitud.getFechaSolicitud(), new ParsePosition(0));
                    if ((fecha2.after(fecha1)) && (fecha1.before(fecha3)) && solicitud.getEstado()=="Pendiente") {
                            //Guardo el objeto solicitud en la tabla
                            Object fila[] = {solicitud.getNumeroSolicitud(), solicitud.getProductor(), solicitud.getFechaSolicitud(), solicitud.getEstado()};
                            modeloT.addRow(fila);
                            tblSolicitud.setModel(modeloT);
                        }
                    }

                }
            }
        
         //Verifico que este seleccionada la opcion de fnumero de solicitud
        if (txtNumSolicitud.isEnabled()) {
            //Creo el objeto orden
            Iterator ite = gestorH.listarClase(SolicitudRetiro.class).iterator();
            while (ite.hasNext()) {
                int banderaFecha = 0;
                SolicitudRetiro solicitud = (SolicitudRetiro) ite.next();
                //Verifico que la muestra no este en la tabla previamente cargada
                for (int i = 0; i < modeloT.getRowCount(); i++) {
                    if (solicitud.getNumeroSolicitud() == modeloT.getValueAt(i, 0)) {
                        banderaFecha = 1;
                    }
                }
                //La orden no esta cargada
                if (banderaFecha == 0) {
                    Date fecha2 = sdf.parse(solicitud.getFechaSolicitud(), new ParsePosition(0));
                    if (Long.parseLong(txtNumSolicitud.getText())== solicitud.getNumeroSolicitud() && solicitud.getEstado()=="Pendiente") {
                            //Guardo el objeto solicitud en la tabla
                            Object fila[] = {solicitud.getNumeroSolicitud(), solicitud.getProductor(), solicitud.getFechaSolicitud(), solicitud.getEstado()};
                            modeloT.addRow(fila);
                            tblSolicitud.setModel(modeloT);
                        }
                    }

                }
            }
        
         //Verifico que este seleccionada la opcion de productor
        if (cmbProductor.isEnabled()) {
            //Creo el objeto orden
            Iterator ite = gestorH.listarClase(SolicitudRetiro.class).iterator();
            while (ite.hasNext()) {
                int banderaFecha = 0;
                SolicitudRetiro solicitud = (SolicitudRetiro) ite.next();
                //Verifico que la muestra no este en la tabla previamente cargada
                for (int i = 0; i < modeloT.getRowCount(); i++) {
                    if (solicitud.getNumeroSolicitud() == modeloT.getValueAt(i, 0)) {
                        banderaFecha = 1;
                    }
                }
                //La orden no esta cargada
                if (banderaFecha == 0) {
                    Date fecha2 = sdf.parse(solicitud.getFechaSolicitud(), new ParsePosition(0));
                    if (Long.parseLong(cmbProductor.getSelectedItem().toString()) == solicitud.getNumeroSolicitud() && solicitud.getEstado()=="Pendiente") {
                            //Guardo el objeto solicitud en la tabla
                            Object fila[] = {solicitud.getNumeroSolicitud(), solicitud.getProductor(), solicitud.getFechaSolicitud(), solicitud.getEstado()};
                            modeloT.addRow(fila);
                            tblSolicitud.setModel(modeloT);
                        }
                    }

                }
            }
    }//GEN-LAST:event_btnBuscarSolicitudActionPerformed

    private void btnAceptarTodos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarTodos1ActionPerformed
         if (ckFecha.isSelected()) {
            calendarioDSolicitud.setEnabled(true);
            calendarioHSolicitud.setEnabled(true);
        }
           if (ckNumSolicitud.isSelected()) {
            txtNumSolicitud.setEnabled(true);
        }
            if (ckProductor.isSelected()) {
            cmbProductor.setEnabled(true);
        }
    }//GEN-LAST:event_btnAceptarTodos1ActionPerformed

    private void btnCancelarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarTodosActionPerformed
        calendarioDSolicitud.setEnabled(false);
        calendarioHSolicitud.setEnabled(false);
        txtNumSolicitud.setEnabled(false);
        cmbProductor.setEnabled(false);
    }//GEN-LAST:event_btnCancelarTodosActionPerformed
   



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarSolicitud1;
    private javax.swing.JButton btnAceptarTodos1;
    private javax.swing.JButton btnAceptarVehiculo;
    private javax.swing.JButton btnBuscarSolicitud;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarTodos;
    private javax.swing.JButton btnGuardar;
    private datechooser.beans.DateChooserCombo calendarioDSolicitud;
    private datechooser.beans.DateChooserCombo calendarioHSolicitud;
    private javax.swing.JCheckBox ckFecha;
    private javax.swing.JCheckBox ckNumSolicitud;
    private javax.swing.JCheckBox ckProductor;
    private javax.swing.JComboBox cmbProductor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblSolicitud;
    private javax.swing.JTable tblVehiculo;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFechaSolicitud;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtNumSolicitud;
    private javax.swing.JTextField txtNumeroSolicitud;
    private javax.swing.JTextField txtPesoNeto;
    private javax.swing.JTextField txtPesoTotal;
    private javax.swing.JTextField txtTara;
    private javax.swing.JTextField txtToneladas;
    private javax.swing.JTextField txtTransportista;
    private javax.swing.JTextField txtVehiculo;
    // End of variables declaration//GEN-END:variables
}
