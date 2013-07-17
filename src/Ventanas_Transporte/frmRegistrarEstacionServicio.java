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
    /** Creates new form frmRegistrarEstacionServicio */
    public frmRegistrarEstacionServicio() {
        initComponents();
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

        
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = kit.getScreenSize();
        int ancho = 650;
        int alto = 535;
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

        jPanel1 = new javax.swing.JPanel();
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
        jSeparator1 = new javax.swing.JSeparator();
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
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstacion = new javax.swing.JTable();
        btnEliminarEstacion = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnGuardarEstacion = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();

        setIconifiable(true);
        setMaximizable(true);
        setTitle("Estacion de Servicio");

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Razón Social");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 100, 20);

        txtRazonSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonSocialKeyTyped(evt);
            }
        });
        jPanel1.add(txtRazonSocial);
        txtRazonSocial.setBounds(90, 10, 210, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Condición IVA");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(340, 10, 100, 20);

        jPanel1.add(cmbCondicion);
        cmbCondicion.setBounds(420, 10, 130, 20);

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Proveedor de Combustible");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(270, 40, 160, 20);

        jPanel1.add(cmbProveedor);
        cmbProveedor.setBounds(420, 40, 190, 20);

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("CUIT");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(50, 40, 50, 20);
        jPanel1.add(txtCUIT);
        txtCUIT.setBounds(90, 40, 130, 20);

        txtCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCalleKeyTyped(evt);
            }
        });
        jPanel1.add(txtCalle);
        txtCalle.setBounds(90, 90, 250, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Calle");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 90, 50, 20);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(20, 70, 590, 10);

        txtNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumKeyTyped(evt);
            }
        });
        jPanel1.add(txtNum);
        txtNum.setBounds(420, 90, 50, 20);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Número");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(370, 90, 50, 20);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Provincia");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 120, 60, 20);

        jPanel1.add(cmbProvincia);
        cmbProvincia.setBounds(90, 120, 200, 20);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Departamento");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(340, 120, 90, 20);

        jPanel1.add(cmbDepartamento);
        cmbDepartamento.setBounds(420, 120, 190, 20);

        jPanel1.add(cmbLocalidad);
        cmbLocalidad.setBounds(90, 150, 200, 20);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Localidad");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 150, 80, 20);

        jPanel1.add(cmbBarrio);
        cmbBarrio.setBounds(420, 150, 190, 20);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Barrio");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(380, 150, 60, 20);

        jPanel1.add(cmbTipoTel);
        cmbTipoTel.setBounds(90, 180, 120, 20);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Tipo Teléfono");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 180, 80, 20);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Teléfono");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(370, 180, 60, 20);

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono);
        txtTelefono.setBounds(420, 180, 150, 20);
        jPanel1.add(txtEmail);
        txtEmail.setBounds(90, 210, 240, 20);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("E-Mail");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(50, 210, 40, 20);

        btnNuevo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N
        btnNuevo.setText("Agregar");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(250, 230, 120, 40);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(0, -8, 620, 10);

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnGuardarEstacion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarEstacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminarEstacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnEliminarEstacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
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
    gestorH.guardarObjeto(estacion);
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
    }//GEN-LAST:event_btnNuevoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel labelUsuario;
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
