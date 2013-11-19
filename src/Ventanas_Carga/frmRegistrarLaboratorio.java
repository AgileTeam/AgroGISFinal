/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmRegistrarLaboratorio.java
 *
 * Created on 05/11/2011, 22:23:44
 */
package Ventanas_Carga;

import Clases_Modulo_Carga.EspecialidadLaboratorio;
import Clases_Modulo_Carga.Laboratorio;
import Clases_Modulo_Transporte.Barrio;
import Clases_Modulo_Transporte.Domicilio;
import Clases_Modulo_Transporte.Especialidad;
import Clases_Modulo_Transporte.TipoTelefono;
import Gestores_Clases.gestorEspecialidadLaboratorio;
import Gestores_Vista.gestorRegistroLaboratorio;
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
public class frmRegistrarLaboratorio extends javax.swing.JInternalFrame {
gestorRegistroLaboratorio gLaboratorio = new gestorRegistroLaboratorio();
gestorEspecialidadLaboratorio gestorE = new gestorEspecialidadLaboratorio();
GestorHibernate gestorH = new GestorHibernate();
boolean editar=false;
    /** Creates new form frmRegistrarLaboratorio */
    public frmRegistrarLaboratorio() {
        initComponents();
        
        panelEdicion.setVisible(false);
        panelDatosL.setVisible(true);
        jScrollPane2.setVisible(false);
        tblEditar.setVisible(false);
        panelContenedor.setVisible(true);
        
        for(int i=0;i<panelAgregar.getComponents().length;i++){
           panelAgregar.getComponent(i).setEnabled(true);
         }
         
        gLaboratorio.actualizarUsuario(labelusuario);
        cmbEspecialidad.setModel(gLaboratorio.rellenaComboEspecialidad());
        cmbTipoTel.setModel(gLaboratorio.rellenaComboTipoTelefono());
        cmbProvincia.setModel(gLaboratorio.rellenaComboTipoProvincia());
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
        tblLaboratorio.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblLaboratorio.getColumnModel().getColumn(1).setPreferredWidth(80);
        tblLaboratorio.getColumnModel().getColumn(2).setPreferredWidth(80);
        //centrar cabecera jtable
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tblLaboratorio.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(0);
        DefaultTableCellRenderer renderer1 = (DefaultTableCellRenderer) tblEditar.getTableHeader().getDefaultRenderer();
        renderer1.setHorizontalAlignment(0);

         
    //lineas para mejorar el aspecto de la pantalla    
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension tamanioPantalla = kit.getScreenSize();
    int ancho = 750;
    int alto = 570;
    int posX = (int) ((tamanioPantalla.width - ancho) / 2);
//    int posY = (int) ((tamanioPantalla.height - alto) / 2);
    this.setSize(ancho, alto);
    this.setLocation(260, 30);
       
    //Carga Provincia de acuerdo al Pais

        cmbProvincia.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                cmbDepartamento.setModel(gLaboratorio.rellenaComboDepartamento(cmbProvincia.getSelectedItem().toString()));
            }
        });
        cmbDepartamento.setModel(gLaboratorio.rellenaComboDepartamento(cmbProvincia.getSelectedItem().toString()));

        //Relleno Localidad de acuerdo al Departamento
        cmbDepartamento.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                cmbLocalidad.setModel(gLaboratorio.rellenaComboLocalidad(cmbDepartamento.getSelectedItem().toString()));
            }
        });
        cmbLocalidad.setModel(gLaboratorio.rellenaComboLocalidad(cmbDepartamento.getSelectedItem().toString()));
        //Carga Barrio de acuerdo a Localidad
        cmbLocalidad.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0){
            cmbBarrio.setModel(gLaboratorio.rellenaComboBarrio(cmbLocalidad.getSelectedItem().toString()));
        }
        }
        );
         cmbBarrio.setModel(gLaboratorio.rellenaComboBarrio(cmbLocalidad.getSelectedItem().toString()));
          
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
        jLabel11 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        labelusuario = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        panelContenedor = new javax.swing.JPanel();
        panelAgregar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLaboratorio = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnAgregarLab = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        panelEdicion = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEditar = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        panelDatosL = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        cmbEspecialidad = new javax.swing.JComboBox();
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
        jLabel17 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Laboratorio");

        jPanel2.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Fecha");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(20, 10, 60, 20);
        jPanel2.add(txtFecha);
        txtFecha.setBounds(60, 10, 80, 20);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Hora");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(210, 10, 60, 20);
        jPanel2.add(txtHora);
        txtHora.setBounds(240, 10, 80, 20);

        labelusuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelusuario.setText("Usuario");
        jPanel2.add(labelusuario);
        labelusuario.setBounds(620, 10, 50, 15);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/UsuarioLogueado.png"))); // NOI18N
        jPanel2.add(jLabel14);
        jLabel14.setBounds(670, 0, 30, 30);

        panelContenedor.setLayout(null);

        tblLaboratorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Especialidad", "Localidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLaboratorio.getTableHeader().setResizingAllowed(false);
        tblLaboratorio.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblLaboratorio);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N

        btnAgregarLab.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnAgregarLab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N
        btnAgregarLab.setText("Agregar");
        btnAgregarLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarLabActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAgregarLayout = new javax.swing.GroupLayout(panelAgregar);
        panelAgregar.setLayout(panelAgregarLayout);
        panelAgregarLayout.setHorizontalGroup(
            panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregarLayout.createSequentialGroup()
                .addGroup(panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAgregarLayout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(btnAgregarLab)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelAgregarLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelAgregarLayout.setVerticalGroup(
            panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregarLab, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAgregarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        panelContenedor.add(panelAgregar);
        panelAgregar.setBounds(80, 240, 570, 170);

        btnNuevo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icononuevo.PNG"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        panelContenedor.add(btnNuevo);
        btnNuevo.setBounds(170, 420, 100, 30);

        btnSalir.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        panelContenedor.add(btnSalir);
        btnSalir.setBounds(470, 420, 100, 30);

        panelEdicion.setLayout(null);

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aceptar.png"))); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        panelEdicion.add(btnAceptar);
        btnAceptar.setBounds(630, 110, 49, 30);

        tblEditar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Especialidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEditar.getTableHeader().setResizingAllowed(false);
        tblEditar.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblEditar);

        panelEdicion.add(jScrollPane2);
        jScrollPane2.setBounds(90, 50, 530, 140);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Laboratorios");
        panelEdicion.add(jLabel13);
        jLabel13.setBounds(300, 30, 100, 17);

        panelContenedor.add(panelEdicion);
        panelEdicion.setBounds(10, 0, 710, 220);

        btnEditar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        panelContenedor.add(btnEditar);
        btnEditar.setBounds(370, 420, 100, 30);

        panelDatosL.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Laboratorio", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panelDatosL.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Especialidad");
        panelDatosL.add(jLabel1);
        jLabel1.setBounds(360, 30, 130, 20);

        txtRazonSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonSocialKeyTyped(evt);
            }
        });
        panelDatosL.add(txtRazonSocial);
        txtRazonSocial.setBounds(90, 30, 210, 20);

        panelDatosL.add(cmbEspecialidad);
        cmbEspecialidad.setBounds(450, 30, 260, 20);

        txtCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCalleKeyTyped(evt);
            }
        });
        panelDatosL.add(txtCalle);
        txtCalle.setBounds(90, 60, 250, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Calle");
        panelDatosL.add(jLabel3);
        jLabel3.setBounds(50, 60, 90, 20);
        panelDatosL.add(txtNum);
        txtNum.setBounds(450, 60, 70, 20);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Número");
        panelDatosL.add(jLabel4);
        jLabel4.setBounds(390, 60, 110, 20);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Provincia");
        panelDatosL.add(jLabel6);
        jLabel6.setBounds(30, 90, 90, 20);

        panelDatosL.add(cmbProvincia);
        cmbProvincia.setBounds(90, 90, 200, 20);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Departamento");
        panelDatosL.add(jLabel7);
        jLabel7.setBounds(360, 90, 160, 20);

        panelDatosL.add(cmbDepartamento);
        cmbDepartamento.setBounds(450, 90, 190, 20);

        panelDatosL.add(cmbLocalidad);
        cmbLocalidad.setBounds(90, 130, 200, 20);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Localidad");
        panelDatosL.add(jLabel5);
        jLabel5.setBounds(30, 130, 110, 20);

        panelDatosL.add(cmbBarrio);
        cmbBarrio.setBounds(450, 130, 190, 20);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Barrio");
        panelDatosL.add(jLabel8);
        jLabel8.setBounds(410, 130, 140, 20);

        panelDatosL.add(cmbTipoTel);
        cmbTipoTel.setBounds(90, 160, 120, 20);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Tipo Teléfono");
        panelDatosL.add(jLabel9);
        jLabel9.setBounds(10, 160, 90, 20);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Teléfono");
        panelDatosL.add(jLabel10);
        jLabel10.setBounds(400, 160, 90, 20);

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        panelDatosL.add(txtTelefono);
        txtTelefono.setBounds(450, 160, 150, 20);
        panelDatosL.add(txtEmail);
        txtEmail.setBounds(90, 190, 240, 20);

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("E-Mail");
        panelDatosL.add(jLabel17);
        jLabel17.setBounds(50, 190, 70, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Nombre");
        panelDatosL.add(jLabel2);
        jLabel2.setBounds(40, 30, 100, 20);

        panelContenedor.add(panelDatosL);
        panelDatosL.setBounds(10, 0, 720, 240);

        btnGuardar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelContenedor.add(btnGuardar);
        btnGuardar.setBounds(270, 420, 100, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
    for(int i=0;i<panelAgregar.getComponents().length;i++){
           panelAgregar.getComponent(i).setEnabled(true);
     }
     for(int i=0;i<panelDatosL.getComponents().length;i++){
         panelDatosL.getComponent(i).setEnabled(true);
     }
     for(int i=0;i<panelEdicion.getComponents().length;i++){
           panelEdicion.getComponent(i).setEnabled(true);
     }
     
     txtCalle.setText("");
     txtEmail.setText("");
     txtRazonSocial.setText("");
     txtTelefono.setText("");
     txtNum.setText("");
     btnEditar.setEnabled(false);
     btnNuevo.setEnabled(false);
}//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarLabActionPerformed
    DefaultTableModel modeloTabla = (DefaultTableModel) tblLaboratorio.getModel();
    GestorHibernate gestorH = new GestorHibernate();
    int campo = gestorE.campoObligatorio(txtRazonSocial, txtCalle);
    if(campo==0){
    Object fila[]= {txtRazonSocial.getText(), cmbEspecialidad.getSelectedItem(), cmbLocalidad.getSelectedItem()};
    modeloTabla.addRow(fila);
    tblLaboratorio.setModel(modeloTabla);
   
    //Boton nuevo
    if(editar==false){
    Laboratorio laboratorio = new Laboratorio();
    laboratorio.setRazonSocial(txtRazonSocial.getText());
    laboratorio.setEspecialidad((EspecialidadLaboratorio) cmbEspecialidad.getSelectedItem());
    laboratorio.setTelefono(txtTelefono.getText());
    laboratorio.setTipoTel((TipoTelefono)cmbTipoTel.getSelectedItem());
    Domicilio domicilio = new Domicilio();
    domicilio.setCalle(txtCalle.getText());
    domicilio.setNumero(Integer.parseInt(txtNum.getText()));
    domicilio.setBarrio((Barrio)cmbBarrio.getSelectedItem());
    laboratorio.setDomicilio(domicilio);
    
    gestorH.guardarObjeto(laboratorio);}
    
    //Boton editar
    else{
    Iterator ite = gestorH.listarClase(Laboratorio.class).iterator();
    while(ite.hasNext()){
        Laboratorio l = (Laboratorio) ite.next();
        if(l.getRazonSocial().equalsIgnoreCase(txtRazonSocial.getText())){
         l.setRazonSocial(txtRazonSocial.getText());
         l.setEspecialidad((EspecialidadLaboratorio) cmbEspecialidad.getSelectedItem());
         l.setTelefono(txtTelefono.getText());
         l.setTipoTel((TipoTelefono)cmbTipoTel.getSelectedItem());
         Domicilio domicilio = new Domicilio();
         domicilio.setCalle(txtCalle.getText());
         domicilio.setNumero(Integer.parseInt(txtNum.getText()));
         domicilio.setBarrio((Barrio)cmbBarrio.getSelectedItem());
         l.setDomicilio(domicilio);
         gestorH.actualizarObjeto(l);
        }
    }
    
    }
    txtRazonSocial.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
    txtCalle.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
    }
    editar=false;
    }//GEN-LAST:event_btnAgregarLabActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        panelEdicion.setVisible(true);
        panelDatosL.setVisible(false);
        jScrollPane2.setVisible(true);
        tblEditar.setVisible(true);
        panelContenedor.setVisible(true);
        btnNuevo.setVisible(false);
        for(int i=0;i<panelAgregar.getComponents().length;i++){
           panelAgregar.getComponent(i).setEnabled(false);
         }
        DefaultTableModel modeloT = (DefaultTableModel) tblEditar.getModel();
        Iterator ite = gestorH.listarClase(Laboratorio.class).iterator();
        while(ite.hasNext()){
            Laboratorio p = (Laboratorio) ite.next();
            Object fila[] = {p.getRazonSocial(),p.getEspecialidad()};
            modeloT.addRow(fila);
            tblEditar.setModel(modeloT);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
       for(int i=0;i<panelAgregar.getComponents().length;i++){
           panelAgregar.getComponent(i).setEnabled(true);
         }
       for(int i=0;i<panelDatosL.getComponents().length;i++){
           panelDatosL.getComponent(i).setEnabled(true);
         }
       panelDatosL.setVisible(true);
       panelEdicion.setVisible(false);
       DefaultTableModel modeloT = (DefaultTableModel) tblEditar.getModel();
       int fila = tblEditar.getSelectedRow();
       Iterator ite = gestorH.listarClase(Laboratorio.class).iterator();
       while(ite.hasNext()){
           Laboratorio e = (Laboratorio) ite.next();
           if(e.getRazonSocial().equalsIgnoreCase(modeloT.getValueAt(fila,0).toString())){
               txtRazonSocial.setText(e.getRazonSocial());
               txtTelefono.setText(e.getTelefono());
               txtEmail.setText(e.geteMail());
               txtCalle.setText(e.getDomicilio().getCalle());
               txtNum.setText(String.valueOf(e.getDomicilio().getNumero()));
               cmbBarrio.setSelectedItem(e.getDomicilio().getBarrio());
               cmbLocalidad.setSelectedItem(e.getDomicilio().getBarrio().getLocalidad());
               cmbDepartamento.setSelectedItem(e.getDomicilio().getBarrio().getLocalidad().getDepartamento());
               cmbProvincia.setSelectedItem(e.getDomicilio().getBarrio().getLocalidad().getDepartamento().getProvincia());
               cmbEspecialidad.setSelectedItem(e.getEspecialidad());
           }
       }
       editar=true;
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    JOptionPane.showMessageDialog(null, "Los cambios se han guardado correctamente");
    btnNuevo.setVisible(true);
    btnEditar.setVisible(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregarLab;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cmbBarrio;
    private javax.swing.JComboBox cmbDepartamento;
    private javax.swing.JComboBox cmbEspecialidad;
    private javax.swing.JComboBox cmbLocalidad;
    private javax.swing.JComboBox cmbProvincia;
    private javax.swing.JComboBox cmbTipoTel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelusuario;
    private javax.swing.JPanel panelAgregar;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelDatosL;
    private javax.swing.JPanel panelEdicion;
    private javax.swing.JTable tblEditar;
    private javax.swing.JTable tblLaboratorio;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
