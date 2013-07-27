/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmRegistrarEstacionServicio.java
 *
 * Created on 30/10/2011, 21:58:15
 */
package Ventanas_Transporte;

import Clases_Modulo_Transporte.Barrio;
import Clases_Modulo_Transporte.CondicionIva;
import Clases_Modulo_Transporte.Domicilio;
import Clases_Modulo_Transporte.EstacionDeServicio;
import Clases_Modulo_Transporte.ProveedorCombustible;
import Clases_Modulo_Transporte.TipoTelefono;
import Gestores_Vista.gestorRegistrarEstacionServicio;
import Gestores_Vista.gestorRegistrarTaller;
import Gestores_Vista.gestorRegistroTransportista;
import Hibernate.GestorHibernate;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class frmRegistrarEstacionServicio extends javax.swing.JInternalFrame {
gestorRegistrarEstacionServicio gEstacion = new gestorRegistrarEstacionServicio();
GestorHibernate gestorH = new GestorHibernate();
gestorRegistroTransportista gRegistro = new gestorRegistroTransportista();
gestorRegistrarTaller gTaller = new gestorRegistrarTaller();
boolean editar=false;
    /** Creates new form frmRegistrarEstacionServicio */
    public frmRegistrarEstacionServicio() {
        initComponents();
        
        panelContenedor.setVisible(true);
        panelDatosE.setVisible(true);
        jScrollPane2.setVisible(false);
        tblEdicion.setVisible(false);
        panelEdicion.setVisible(false);
        
        for(int i=0;i<panelAgregar.getComponents().length;i++){
           panelAgregar.getComponent(i).setEnabled(true);
         }
     
        gestorH.actualizarUsuario(labelUsuario);
        
        cmbProvincia.setModel(gEstacion.rellenaCombo());
        cmbTipoTel.setModel(gEstacion.rellenaComboTipoTel());
        cmbProveedor.setModel(gEstacion.rellenaComboProveedor());
        cmbCondicion.setModel(gEstacion.rellenaComboCondicionIva());
        
        
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
        tblEstacion.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblEstacion.getColumnModel().getColumn(1).setPreferredWidth(40);
        tblEstacion.getColumnModel().getColumn(2).setPreferredWidth(100);
        
        //centrar cabecera jtable
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tblEstacion.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(0);
        DefaultTableCellRenderer renderer1 = (DefaultTableCellRenderer) tblEdicion.getTableHeader().getDefaultRenderer();
        renderer1.setHorizontalAlignment(0);
        
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = kit.getScreenSize();
        int ancho = 700;
        int alto = 550;
        this.setSize(ancho, alto);
        this.setLocation(280, 65);
        
        cmbProvincia.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                cmbDepartamento.setModel(gEstacion.rellenaComboDepartamento(cmbProvincia.getSelectedItem().toString()));
            }
        });
        cmbDepartamento.setModel(gEstacion.rellenaComboDepartamento(cmbProvincia.getSelectedItem().toString()));

        //Relleno Localidad de acuerdo al Departamento
        cmbDepartamento.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                cmbLocalidad.setModel(gEstacion.rellenaComboLocalidad(cmbDepartamento.getSelectedItem().toString()));
            }
        });
        cmbLocalidad.setModel(gEstacion.rellenaComboLocalidad(cmbDepartamento.getSelectedItem().toString()));
        //Carga Barrio de acuerdo a Localidad
        cmbLocalidad.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0){
            cmbBarrio.setModel(gEstacion.rellenaComboBarrio(cmbLocalidad.getSelectedItem().toString()));
        }
        }
        );
         cmbBarrio.setModel(gEstacion.rellenaComboBarrio(cmbLocalidad.getSelectedItem().toString()));
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
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        panelContenedor = new javax.swing.JPanel();
        panelDatosE = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbCondicion = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        cmbProveedor = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        txtCUIT = new javax.swing.JTextField();
        txtCalle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbProvincia = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cmbDepartamento = new javax.swing.JComboBox();
        cmbLocalidad = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cmbBarrio = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cmbTipoTel = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        btnGuardarEstacion = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnEditarEstacion = new javax.swing.JButton();
        panelAgregar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstacion = new javax.swing.JTable();
        btnEliminarEstacion = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        panelEdicion = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEdicion = new javax.swing.JTable();
        btnAceptarTransp = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);
        setTitle("Estacion de Servicio");

        jPanel3.setLayout(null);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Fecha");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(10, 13, 40, 15);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Hora");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(210, 10, 40, 20);

        labelUsuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelUsuario.setText("Usuario");
        jPanel3.add(labelUsuario);
        labelUsuario.setBounds(500, 10, 50, 15);
        jPanel3.add(txtFecha);
        txtFecha.setBounds(60, 10, 80, 20);
        jPanel3.add(txtHora);
        txtHora.setBounds(250, 10, 80, 20);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/UsuarioLogueado.png"))); // NOI18N
        jPanel3.add(jLabel17);
        jLabel17.setBounds(550, 0, 30, 30);

        panelContenedor.setLayout(null);

        panelDatosE.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Estacion de Servicio", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panelDatosE.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Razón Social");
        panelDatosE.add(jLabel1);
        jLabel1.setBounds(10, 30, 100, 20);

        txtRazonSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonSocialKeyTyped(evt);
            }
        });
        panelDatosE.add(txtRazonSocial);
        txtRazonSocial.setBounds(90, 30, 210, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Condición IVA");
        panelDatosE.add(jLabel2);
        jLabel2.setBounds(340, 30, 100, 20);

        panelDatosE.add(cmbCondicion);
        cmbCondicion.setBounds(420, 30, 130, 20);

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Proveedor de Combustible");
        panelDatosE.add(jLabel12);
        jLabel12.setBounds(270, 60, 160, 20);

        panelDatosE.add(cmbProveedor);
        cmbProveedor.setBounds(420, 60, 190, 20);

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("CUIT");
        panelDatosE.add(jLabel13);
        jLabel13.setBounds(50, 60, 50, 20);
        panelDatosE.add(txtCUIT);
        txtCUIT.setBounds(90, 60, 130, 20);

        txtCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCalleKeyTyped(evt);
            }
        });
        panelDatosE.add(txtCalle);
        txtCalle.setBounds(90, 90, 250, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Calle");
        panelDatosE.add(jLabel3);
        jLabel3.setBounds(50, 90, 50, 20);

        txtNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumKeyTyped(evt);
            }
        });
        panelDatosE.add(txtNum);
        txtNum.setBounds(420, 90, 50, 20);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Número");
        panelDatosE.add(jLabel4);
        jLabel4.setBounds(370, 90, 50, 20);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Provincia");
        panelDatosE.add(jLabel6);
        jLabel6.setBounds(30, 120, 60, 20);

        panelDatosE.add(cmbProvincia);
        cmbProvincia.setBounds(90, 120, 200, 20);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Departamento");
        panelDatosE.add(jLabel7);
        jLabel7.setBounds(340, 120, 90, 20);

        panelDatosE.add(cmbDepartamento);
        cmbDepartamento.setBounds(420, 120, 190, 20);

        panelDatosE.add(cmbLocalidad);
        cmbLocalidad.setBounds(90, 150, 200, 20);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Localidad");
        panelDatosE.add(jLabel5);
        jLabel5.setBounds(30, 150, 80, 20);

        panelDatosE.add(cmbBarrio);
        cmbBarrio.setBounds(420, 150, 190, 20);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Barrio");
        panelDatosE.add(jLabel8);
        jLabel8.setBounds(380, 150, 60, 20);

        panelDatosE.add(cmbTipoTel);
        cmbTipoTel.setBounds(90, 180, 120, 20);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Tipo Teléfono");
        panelDatosE.add(jLabel9);
        jLabel9.setBounds(10, 180, 80, 20);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Teléfono");
        panelDatosE.add(jLabel10);
        jLabel10.setBounds(370, 180, 60, 20);

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        panelDatosE.add(txtTelefono);
        txtTelefono.setBounds(420, 180, 150, 20);
        panelDatosE.add(txtEmail);
        txtEmail.setBounds(90, 210, 240, 20);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("E-Mail");
        panelDatosE.add(jLabel11);
        jLabel11.setBounds(50, 210, 40, 20);
        panelDatosE.add(jSeparator2);
        jSeparator2.setBounds(0, -8, 620, 10);

        panelContenedor.add(panelDatosE);
        panelDatosE.setBounds(30, 10, 640, 240);

        btnGuardarEstacion.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnGuardarEstacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btnGuardarEstacion.setText("Guardar");
        btnGuardarEstacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEstacionActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnEditarEstacion.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnEditarEstacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        btnEditarEstacion.setText("Editar");
        btnEditarEstacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarEstacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarEstacion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarEstacion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarEstacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarEstacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelContenedor.add(jPanel5);
        jPanel5.setBounds(180, 400, 332, 42);

        tblEstacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Razón Social", "CUIT", "Localidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEstacion.getTableHeader().setResizingAllowed(false);
        tblEstacion.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblEstacion);

        btnEliminarEstacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        btnEliminarEstacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEstacionActionPerformed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N
        btnNuevo.setText("Agregar");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAgregarLayout = new javax.swing.GroupLayout(panelAgregar);
        panelAgregar.setLayout(panelAgregarLayout);
        panelAgregarLayout.setHorizontalGroup(
            panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregarLayout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarEstacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(panelAgregarLayout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(btnNuevo)
                .addContainerGap())
        );
        panelAgregarLayout.setVerticalGroup(
            panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregarLayout.createSequentialGroup()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAgregarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEliminarEstacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        panelContenedor.add(panelAgregar);
        panelAgregar.setBounds(30, 250, 640, 150);

        panelEdicion.setLayout(null);

        tblEdicion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CUIT", "Razón Social"
            }
        ));
        jScrollPane2.setViewportView(tblEdicion);

        panelEdicion.add(jScrollPane2);
        jScrollPane2.setBounds(100, 20, 430, 150);

        btnAceptarTransp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aceptar.png"))); // NOI18N
        btnAceptarTransp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarTranspActionPerformed(evt);
            }
        });
        panelEdicion.add(btnAceptarTransp);
        btnAceptarTransp.setBounds(540, 70, 49, 30);

        panelContenedor.add(panelEdicion);
        panelEdicion.setBounds(20, 20, 670, 250);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 79, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnEliminarEstacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEstacionActionPerformed
    int fila = tblEstacion.getSelectedRow();
    Iterator ite = gestorH.listarClase(EstacionDeServicio.class).iterator();
    while(ite.hasNext()){
        EstacionDeServicio estacion = (EstacionDeServicio) ite.next();
        if(estacion.getRazonSocial().equalsIgnoreCase(tblEstacion.getValueAt(fila, 0).toString())){
            gestorH.eliminarObjeto(estacion);
        }
    }
    DefaultTableModel modeloTabla = (DefaultTableModel) tblEstacion.getModel();
    modeloTabla.removeRow(tblEstacion.getSelectedRow());
}//GEN-LAST:event_btnEliminarEstacionActionPerformed

private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    int respuesta = JOptionPane.showConfirmDialog(null, "Confirma que desea salir?");
    if (respuesta==0){
    dispose();
    }
}//GEN-LAST:event_btnSalirActionPerformed

private void txtRazonSocialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSocialKeyTyped
    char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
          
        }else{
           evt.consume();
              }
}//GEN-LAST:event_txtRazonSocialKeyTyped

private void txtCalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCalleKeyTyped
char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
          
        }else{
           evt.consume();
              }
}//GEN-LAST:event_txtCalleKeyTyped

private void txtNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumKeyTyped
    char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
}//GEN-LAST:event_txtNumKeyTyped

private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
    char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
}//GEN-LAST:event_txtTelefonoKeyTyped

private void btnGuardarEstacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEstacionActionPerformed
    JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente");
}//GEN-LAST:event_btnGuardarEstacionActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
    int campo = gTaller.campoObligatorio(txtRazonSocial, txtCUIT, txtCalle, txtNum);
    if(campo == 0){
    boolean mail = gRegistro.isEmail(txtEmail.getText());
    System.out.println(mail);
    if(mail==true){
    GestorHibernate gestorH = new GestorHibernate();
    EstacionDeServicio estacion = new EstacionDeServicio();
    estacion.setCondicionIva((CondicionIva) cmbCondicion.getSelectedItem());
    estacion.setEmail(txtEmail.getText());
    estacion.setProveedor((ProveedorCombustible) cmbProveedor.getSelectedItem());
    estacion.setRazonSocial(txtRazonSocial.getText());
    estacion.setTelefono(txtTelefono.getText());
    estacion.setCUIT(txtCUIT.getText());
    estacion.setTipoTelefono((TipoTelefono) cmbTipoTel.getSelectedItem());
    Domicilio domicilio = new Domicilio();
    domicilio.setCalle(txtCalle.getText());
    domicilio.setNumero(Integer.parseInt(txtNum.getText()));
    domicilio.setBarrio((Barrio) cmbBarrio.getSelectedItem());
    estacion.setDomicilio(domicilio);
    if(editar==false){
    gestorH.guardarObjeto(estacion);
    }
    else{
    gestorH.actualizarObjeto(estacion);
    }
    DefaultTableModel modeloTabla = (DefaultTableModel) tblEstacion.getModel();
    Object fila[]={txtRazonSocial.getText(), txtCUIT.getText(), cmbLocalidad.getSelectedItem()};
    modeloTabla.addRow(fila);
    tblEstacion.setModel(modeloTabla);
    txtRazonSocial.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
    txtCUIT.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
    txtCalle.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
    txtNum.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
    }
    else{
        JOptionPane.showMessageDialog(null, "Ingrese un email valido");
    }
    }
    editar=false;
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarEstacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEstacionActionPerformed
        panelDatosE.setVisible(false);
        jScrollPane2.setVisible(true);
        tblEdicion.setVisible(true);
        panelEdicion.setVisible(true);
        for(int i=0;i<panelAgregar.getComponents().length;i++){
           panelAgregar.getComponent(i).setEnabled(false);
         }
        DefaultTableModel modeloT = (DefaultTableModel) tblEdicion.getModel();
        Iterator ite = gestorH.listarClase(EstacionDeServicio.class).iterator();
        while(ite.hasNext()){
            EstacionDeServicio p = (EstacionDeServicio) ite.next();
            Object fila[] = {p.getCUIT(),p.getRazonSocial()};
            modeloT.addRow(fila);
            tblEdicion.setModel(modeloT);
        }
    }//GEN-LAST:event_btnEditarEstacionActionPerformed

    private void btnAceptarTranspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarTranspActionPerformed
       DefaultTableModel modeloT = (DefaultTableModel) tblEdicion.getModel();
       int fila = tblEdicion.getSelectedRow();
       Iterator ite = gestorH.listarClase(EstacionDeServicio.class).iterator();
       while(ite.hasNext()){
           EstacionDeServicio e = (EstacionDeServicio) ite.next();
           if(e.getCUIT().equalsIgnoreCase(modeloT.getValueAt(fila,0).toString())){
               txtRazonSocial.setText(e.getRazonSocial());
               txtCUIT.setText(e.getCUIT());
               txtTelefono.setText(e.getTelefono());
               txtEmail.setText(e.getEmail());
               txtCalle.setText(e.getDomicilio().getCalle());
               txtNum.setText(String.valueOf(e.getDomicilio().getNumero()));
               cmbBarrio.setSelectedItem(e.getDomicilio().getBarrio());
               cmbLocalidad.setSelectedItem(e.getDomicilio().getBarrio().getLocalidad());
               cmbDepartamento.setSelectedItem(e.getDomicilio().getBarrio().getLocalidad().getDepartamento());
               cmbProvincia.setSelectedItem(e.getDomicilio().getBarrio().getLocalidad().getDepartamento().getProvincia());
               cmbProveedor.setSelectedItem(e.getProveedor());
           }
       }
       editar=true;
    }//GEN-LAST:event_btnAceptarTranspActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarTransp;
    private javax.swing.JButton btnEditarEstacion;
    private javax.swing.JButton btnEliminarEstacion;
    private javax.swing.JButton btnGuardarEstacion;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cmbBarrio;
    private javax.swing.JComboBox cmbCondicion;
    private javax.swing.JComboBox cmbDepartamento;
    private javax.swing.JComboBox cmbLocalidad;
    private javax.swing.JComboBox cmbProveedor;
    private javax.swing.JComboBox cmbProvincia;
    private javax.swing.JComboBox cmbTipoTel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel panelAgregar;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelDatosE;
    private javax.swing.JPanel panelEdicion;
    private javax.swing.JTable tblEdicion;
    private javax.swing.JTable tblEstacion;
    private javax.swing.JTextField txtCUIT;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
