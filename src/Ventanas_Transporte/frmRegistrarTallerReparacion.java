/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas_Transporte;

import Clases_Modulo_Transporte.*;
import Gestores_Vista.gestorRegistrarTaller;
import Gestores_Vista.gestorRegistroTransportista;
import Hibernate.GestorHibernate;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Carolina
 */
public class frmRegistrarTallerReparacion extends javax.swing.JInternalFrame {
gestorRegistrarTaller gestorT = new gestorRegistrarTaller();
GestorHibernate gestorH = new GestorHibernate();
gestorRegistroTransportista  gRegistro = new gestorRegistroTransportista();
boolean editar=false;
    /**
     * Creates new form frmRegistrarTallerReparacion
     */
    public frmRegistrarTallerReparacion() {
        initComponents();
        
        panelContenedor.setVisible(true);
        panelDatosT.setVisible(true);
        jScrollPane1.setVisible(false);
        tblEdicion.setVisible(false);
        panelEdicion.setVisible(false);
        
        for(int i=0;i<panelAgregar.getComponents().length;i++){
           panelAgregar.getComponent(i).setEnabled(true);
         }
        
        
        gestorH.actualizarUsuario(labelusuario);
        cmbProvincia.setModel(gestorT.rellenaCombo());
        cmbTipoTel.setModel(gestorT.rellenaComboTipoTel());
        cmbCondicion.setModel(gestorT.rellenaComboCondicionIva());
        
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
        tblTaller.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblTaller.getColumnModel().getColumn(1).setPreferredWidth(40);
        tblTaller.getColumnModel().getColumn(2).setPreferredWidth(100);
        
        //centrar cabecera jtable
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tblTaller.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(0);
        DefaultTableCellRenderer renderer1 = (DefaultTableCellRenderer) tblEdicion.getTableHeader().getDefaultRenderer();
        renderer1.setHorizontalAlignment(0);    
        
        //estableccr tamaño de ventana
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = kit.getScreenSize();
        int ancho = 700;
        int alto = 600;
        this.setSize(ancho, alto);
        this.setLocation(290, 30);
        
        cmbEspecialidad.setModel(gestorT.rellenaComboEspecialidad());
        cmbProvincia.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                cmbDepartamento.setModel(gestorT.rellenaComboDepartamento(cmbProvincia.getSelectedItem().toString()));
            }
        });
        cmbDepartamento.setModel(gestorT.rellenaComboDepartamento(cmbProvincia.getSelectedItem().toString()));

        //Relleno Localidad de acuerdo al Departamento
        cmbDepartamento.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                cmbLocalidad.setModel(gestorT.rellenaComboLocalidad(cmbDepartamento.getSelectedItem().toString()));
            }
        });
        cmbLocalidad.setModel(gestorT.rellenaComboLocalidad(cmbDepartamento.getSelectedItem().toString()));
        //Carga Barrio de acuerdo a Localidad
        cmbLocalidad.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0){
            cmbBarrio.setModel(gestorT.rellenaComboBarrio(cmbLocalidad.getSelectedItem().toString()));
        }
        }
        );
         cmbBarrio.setModel(gestorT.rellenaComboBarrio(cmbLocalidad.getSelectedItem().toString()));
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        panelAgregar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTaller = new javax.swing.JTable();
        btnNuevoTaller = new javax.swing.JButton();
        btnEliminarTaller = new javax.swing.JButton();
        panelEdicion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEdicion = new javax.swing.JTable();
        btnAceptarTaller = new javax.swing.JButton();
        panelDatosT = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cmbEspecialidad = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtNombreTaller = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cmbCondicion = new javax.swing.JComboBox();
        txtRazonSocial = new javax.swing.JTextField();
        txtCUIT = new javax.swing.JTextField();
        txtCalle = new javax.swing.JTextField();
        txtNum = new javax.swing.JTextField();
        cmbProvincia = new javax.swing.JComboBox();
        cmbDepartamento = new javax.swing.JComboBox();
        cmbLocalidad = new javax.swing.JComboBox();
        cmbBarrio = new javax.swing.JComboBox();
        cmbTipoTel = new javax.swing.JComboBox();
        txtTelefono = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardarTaller = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        labelusuario = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();

        setIconifiable(true);
        setMaximizable(true);
        setTitle("Taller Reparacion");

        panelContenedor.setLayout(null);

        panelAgregar.setLayout(null);

        tblTaller.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTaller.getTableHeader().setResizingAllowed(false);
        tblTaller.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblTaller);

        panelAgregar.add(jScrollPane2);
        jScrollPane2.setBounds(80, 50, 493, 92);

        btnNuevoTaller.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnNuevoTaller.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N
        btnNuevoTaller.setText("Agregar");
        btnNuevoTaller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoTallerActionPerformed(evt);
            }
        });
        panelAgregar.add(btnNuevoTaller);
        btnNuevoTaller.setBounds(280, 10, 93, 30);

        btnEliminarTaller.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        btnEliminarTaller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTallerActionPerformed(evt);
            }
        });
        panelAgregar.add(btnEliminarTaller);
        btnEliminarTaller.setBounds(580, 80, 40, 30);

        panelContenedor.add(panelAgregar);
        panelAgregar.setBounds(20, 320, 647, 159);

        panelEdicion.setLayout(null);

        tblEdicion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CUIT", "Razón Social"
            }
        ));
        jScrollPane1.setViewportView(tblEdicion);

        panelEdicion.add(jScrollPane1);
        jScrollPane1.setBounds(90, 50, 452, 170);

        btnAceptarTaller.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aceptar.png"))); // NOI18N
        btnAceptarTaller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarTallerActionPerformed(evt);
            }
        });
        panelEdicion.add(btnAceptarTaller);
        btnAceptarTaller.setBounds(550, 110, 49, 30);

        panelContenedor.add(panelEdicion);
        panelEdicion.setBounds(10, 30, 670, 250);

        panelDatosT.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Taller", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panelDatosT.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Especialidad");
        panelDatosT.add(jLabel5);
        jLabel5.setBounds(120, 30, 110, 20);

        panelDatosT.add(cmbEspecialidad);
        cmbEspecialidad.setBounds(200, 30, 280, 20);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Nombre ");
        panelDatosT.add(jLabel4);
        jLabel4.setBounds(40, 90, 110, 20);
        panelDatosT.add(txtNombreTaller);
        txtNombreTaller.setBounds(100, 90, 280, 20);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Condición IVA");
        panelDatosT.add(jLabel6);
        jLabel6.setBounds(390, 90, 120, 20);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("CUIT");
        panelDatosT.add(jLabel7);
        jLabel7.setBounds(390, 120, 70, 20);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Razón Social");
        panelDatosT.add(jLabel8);
        jLabel8.setBounds(10, 120, 120, 20);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Calle");
        panelDatosT.add(jLabel9);
        jLabel9.setBounds(50, 150, 80, 20);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Número");
        panelDatosT.add(jLabel10);
        jLabel10.setBounds(370, 150, 80, 20);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Provincia");
        panelDatosT.add(jLabel11);
        jLabel11.setBounds(30, 180, 110, 20);

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Departamento");
        panelDatosT.add(jLabel12);
        jLabel12.setBounds(340, 180, 130, 20);

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("Localidad");
        panelDatosT.add(jLabel13);
        jLabel13.setBounds(30, 210, 130, 20);

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setText("Barrio");
        panelDatosT.add(jLabel14);
        jLabel14.setBounds(380, 210, 100, 20);

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("Tipo Teléfono");
        panelDatosT.add(jLabel15);
        jLabel15.setBounds(10, 240, 120, 20);

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setText("Teléfono");
        panelDatosT.add(jLabel16);
        jLabel16.setBounds(370, 240, 110, 20);

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("E-mail");
        panelDatosT.add(jLabel17);
        jLabel17.setBounds(50, 270, 70, 20);

        panelDatosT.add(cmbCondicion);
        cmbCondicion.setBounds(490, 90, 130, 20);

        txtRazonSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonSocialKeyTyped(evt);
            }
        });
        panelDatosT.add(txtRazonSocial);
        txtRazonSocial.setBounds(100, 120, 210, 20);
        panelDatosT.add(txtCUIT);
        txtCUIT.setBounds(430, 120, 130, 20);

        txtCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCalleKeyTyped(evt);
            }
        });
        panelDatosT.add(txtCalle);
        txtCalle.setBounds(100, 150, 250, 20);

        txtNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumKeyTyped(evt);
            }
        });
        panelDatosT.add(txtNum);
        txtNum.setBounds(430, 150, 60, 20);

        panelDatosT.add(cmbProvincia);
        cmbProvincia.setBounds(100, 180, 200, 20);

        panelDatosT.add(cmbDepartamento);
        cmbDepartamento.setBounds(430, 180, 190, 20);

        panelDatosT.add(cmbLocalidad);
        cmbLocalidad.setBounds(100, 210, 200, 20);

        panelDatosT.add(cmbBarrio);
        cmbBarrio.setBounds(430, 210, 190, 20);

        panelDatosT.add(cmbTipoTel);
        cmbTipoTel.setBounds(100, 240, 120, 20);

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        panelDatosT.add(txtTelefono);
        txtTelefono.setBounds(430, 240, 150, 20);
        panelDatosT.add(txtEmail);
        txtEmail.setBounds(100, 270, 240, 20);

        panelContenedor.add(panelDatosT);
        panelDatosT.setBounds(20, 10, 650, 310);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icononuevo.PNG"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardarTaller.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnGuardarTaller.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btnGuardarTaller.setText("Guardar");
        btnGuardarTaller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTallerActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardarTaller, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarTaller, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelContenedor.add(jPanel1);
        jPanel1.setBounds(120, 470, 450, 40);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Fecha");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Hora");

        labelusuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelusuario.setText("Usuario");

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/UsuarioLogueado.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
                .addComponent(labelusuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelusuario))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel48)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelContenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRazonSocialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSocialKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtRazonSocialKeyTyped

    private void txtCalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCalleKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
        } else {
        evt.consume();
        }
    }//GEN-LAST:event_txtCalleKeyTyped

    private void txtNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumKeyTyped
        char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '\b' /*
                 * corresponde a BACK_SPACE
                 */)) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_txtNumKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '\b' /*
                 * corresponde a BACK_SPACE
                 */)) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void btnNuevoTallerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoTallerActionPerformed
    int campo = gestorT.campoObligatorio(txtRazonSocial, txtCUIT, txtCalle, txtNum);
    if(campo == 0){        
    boolean mail = gRegistro.isEmail(txtEmail.getText());
    System.out.println(mail);
    if(mail==true){
    GestorHibernate gestorH = new GestorHibernate();
    TallerReparacion taller = new TallerReparacion();
    Iterator ite = gestorH.listarClase(Especialidad.class).iterator();
    while(ite.hasNext()){
        Especialidad e = (Especialidad) ite.next();
        if(e.equals((Especialidad)cmbEspecialidad.getSelectedItem())){
            taller.setEspecialidad(e);
        }
    } 
    taller.setCondicionIva((CondicionIva) cmbCondicion.getSelectedItem());
    taller.setEmail(txtEmail.getText());
    taller.setRazonSocial(txtRazonSocial.getText());
    taller.setNumeroTelefono((txtTelefono.getText()));
    taller.setCuit(txtCUIT.getText());
    taller.setTipoTelefono((TipoTelefono) cmbTipoTel.getSelectedItem());
    Domicilio domicilio = new Domicilio();
    domicilio.setCalle(txtCalle.getText());
    domicilio.setNumero(Integer.parseInt(txtNum.getText()));
    domicilio.setBarrio((Barrio) cmbBarrio.getSelectedItem());
    taller.setDomicilio(domicilio);
    if(editar==false){
    gestorH.guardarObjeto(taller);
    }else{
    gestorH.actualizarObjeto(taller);
    }
    DefaultTableModel modeloTabla = (DefaultTableModel) tblTaller.getModel();
    Object fila[]={txtRazonSocial.getText(), txtCUIT.getText(), cmbLocalidad.getSelectedItem()};
    modeloTabla.addRow(fila);
    tblTaller.setModel(modeloTabla);
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
    }//GEN-LAST:event_btnNuevoTallerActionPerformed

    private void btnEliminarTallerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTallerActionPerformed
    int fila = tblTaller.getSelectedRow();
    Iterator ite = gestorH.listarClase(TallerReparacion.class).iterator();
    while(ite.hasNext()){
        TallerReparacion taller = (TallerReparacion) ite.next();
        if(taller.getRazonSocial().equalsIgnoreCase(tblTaller.getValueAt(fila, 0).toString())){
            gestorH.eliminarObjeto(taller);
        }
    }
    DefaultTableModel modeloTabla = (DefaultTableModel) tblTaller.getModel();
    modeloTabla.removeRow(tblTaller.getSelectedRow());
    }//GEN-LAST:event_btnEliminarTallerActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        panelDatosT.setVisible(false);
        jScrollPane1.setVisible(true);
        tblEdicion.setVisible(true);
        panelEdicion.setVisible(true);
        
        for(int i=0;i<panelAgregar.getComponents().length;i++){
           panelAgregar.getComponent(i).setEnabled(false);
         }
        DefaultTableModel modeloT = (DefaultTableModel) tblEdicion.getModel();
        Iterator ite = gestorH.listarClase(TallerReparacion.class).iterator();
        while(ite.hasNext()){
            TallerReparacion p = (TallerReparacion) ite.next();
            Object fila[] = {p.getCuit(),p.getRazonSocial()};
            modeloT.addRow(fila);
            tblEdicion.setModel(modeloT);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
     txtCUIT.setText("");
     txtCalle.setText("");
     txtEmail.setText("");
     txtNombreTaller.setText("");
     txtRazonSocial.setText("");
     txtTelefono.setText("");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Confirma que desea salir?");
        if (respuesta == 0) {
            dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardarTallerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTallerActionPerformed
        JOptionPane.showMessageDialog(null, "Los datos se han guardado correctamente");
    }//GEN-LAST:event_btnGuardarTallerActionPerformed

    private void btnAceptarTallerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarTallerActionPerformed
       DefaultTableModel modeloT = (DefaultTableModel) tblEdicion.getModel();
       int fila = tblEdicion.getSelectedRow();
       Iterator ite = gestorH.listarClase(TallerReparacion.class).iterator();
       while(ite.hasNext()){
           TallerReparacion e = (TallerReparacion) ite.next();
           if(e.getCuit().equalsIgnoreCase(modeloT.getValueAt(fila,0).toString())){
               txtRazonSocial.setText(e.getRazonSocial());
               txtCUIT.setText(e.getCuit());
               txtTelefono.setText(e.getNumeroTelefono());
               txtEmail.setText(e.getEmail());
               txtCalle.setText(e.getDomicilio().getCalle());
               txtNum.setText(String.valueOf(e.getDomicilio().getNumero()));
               cmbBarrio.setSelectedItem(e.getDomicilio().getBarrio());
               cmbLocalidad.setSelectedItem(e.getDomicilio().getBarrio().getLocalidad());
               cmbDepartamento.setSelectedItem(e.getDomicilio().getBarrio().getLocalidad().getDepartamento());
               cmbProvincia.setSelectedItem(e.getDomicilio().getBarrio().getLocalidad().getDepartamento().getProvincia());
               cmbCondicion.setSelectedItem(e.getCondicionIva());
           }
       }
       editar=true;
    }//GEN-LAST:event_btnAceptarTallerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarTaller;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminarTaller;
    private javax.swing.JButton btnGuardarTaller;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevoTaller;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cmbBarrio;
    private javax.swing.JComboBox cmbCondicion;
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelusuario;
    private javax.swing.JPanel panelAgregar;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JPanel panelDatosT;
    private javax.swing.JPanel panelEdicion;
    private javax.swing.JTable tblEdicion;
    private javax.swing.JTable tblTaller;
    private javax.swing.JTextField txtCUIT;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtNombreTaller;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
