/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas_Viaje;

import Clases_Modulo_Cliente.Productor;
import Clases_Modulo_Carga.Puerto;
import Clases_Modulo_Transporte.Barrio;
import Gestores_Vista.gestorRegistrarViaje;
import Hibernate.GestorHibernate;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Carolina
 */
public class frmRegistrarViaje extends javax.swing.JInternalFrame {
gestorRegistrarViaje gViaje = new gestorRegistrarViaje();
GestorHibernate gestorH = new GestorHibernate();
    /**
     * Creates new form frmRegistrarViaje
     */
    public frmRegistrarViaje() {
        initComponents();
        txtFecha.setEditable(false);
        txtFecha.setEnabled(false);
        txtHora.setEditable(false);
        txtHora.setEnabled(false);
        txtNumViaje.setEditable(false);
        txtNumViaje.setEnabled(false);
        txtEstado.setEnabled(false);
        txtEstado.setEditable(false);
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

        //1) datos de puerto - 2) datos de establecimiento
   
        labelLocalidad.setVisible(true); //1 y 2
        txtLocalidad.setVisible(true); //1 y 2
        labelProductor.setVisible(true); //1 y 2
        txtProductor.setVisible(true); //1 y 2
        labelCereal.setVisible(true); //1 y 2
        cmbCereal.setVisible(true); //1 y 2
              
 
        //borrar el icono del InternalFrame
        this.setFrameIcon(new ImageIcon("Imagenes/Aceptar.png"));
        
        
        //Las siguientes lineas son para dar a la pantalla el tamaño requerido y luego centrarla en la pantalla.
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = kit.getScreenSize();
        int ancho = 725;
        int alto = 530;
        int posX = (int) ((tamanioPantalla.width - ancho) / 2);
//        int posY = (int) ((tamanioPantalla.height - alto) / 2);
        this.setSize(ancho, alto);
        this.setLocation(posX, 0);
        
        tblEstablecimiento.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblEstablecimiento.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblEstablecimiento.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblProductor.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblProductor.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblProductor.getColumnModel().getColumn(2).setPreferredWidth(50);
        
        
        cmbTipoViaje.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0){
           gViaje.ActualizarDatos(cmbTipoViaje.getSelectedItem().toString(), panelPuerto, panelEstablecimiento, labelPuerto, labelEstablecimiento, labelProvincia, labelDepto, tblEstablecimiento, tblPuerto, scpEstablecimiento, scpPuerto);
           }
        }
        );
          gViaje.ActualizarDatos(cmbTipoViaje.getSelectedItem().toString(), panelPuerto, panelEstablecimiento, labelPuerto, labelEstablecimiento, labelProvincia, labelDepto, tblEstablecimiento, tblPuerto, scpEstablecimiento, scpPuerto);
        
        DefaultTableModel modeloT = (DefaultTableModel) tblPuerto.getModel();
        Iterator ite = gestorH.listarClase(Puerto.class).iterator();
        while(ite.hasNext()){
            Puerto puerto = (Puerto) ite.next();
            Object fila[] = {puerto.getNombrePuerto(), puerto.getLocalidad()};
            modeloT.addRow(fila);
            tblPuerto.setModel(modeloT);
        }
        
        DefaultTableModel modeloT1 = (DefaultTableModel) tblProductor.getModel();
        Iterator ite1 = gestorH.listarClase(Productor.class).iterator();
        while(ite1.hasNext()){
            Productor prod = (Productor) ite1.next();
            Object fila[] = {prod.getNombre(), prod.getNumeroDocumento()};
            modeloT.addRow(fila);
            tblPuerto.setModel(modeloT1);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNumViaje = new javax.swing.JTextField();
        cmbTipoViaje = new javax.swing.JComboBox();
        txtSolicitante = new javax.swing.JTextField();
        calendarioViaje = new datechooser.beans.DateChooserCombo();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        panelPuerto = new javax.swing.JPanel();
        txtProductor = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        txtProvinciaT = new javax.swing.JTextField();
        txtToneladasE = new javax.swing.JTextField();
        labelLocalidad = new javax.swing.JLabel();
        labelDepto = new javax.swing.JLabel();
        txtDeptoT = new javax.swing.JTextField();
        txtLocalidad = new javax.swing.JTextField();
        labelProductor = new javax.swing.JLabel();
        labelCereal = new javax.swing.JLabel();
        scpEstablecimiento = new javax.swing.JScrollPane();
        tblEstablecimiento = new javax.swing.JTable();
        labelPuerto = new javax.swing.JLabel();
        labelEstablecimiento = new javax.swing.JLabel();
        labelProvincia = new javax.swing.JLabel();
        labelToneladasE = new javax.swing.JLabel();
        txtCerealT = new javax.swing.JTextField();
        txtTraslado = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        panelEstablecimiento = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductor = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtProductorEst = new javax.swing.JTextField();
        txtDepto = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtLocalidadEst = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtHas = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        cmbLote = new javax.swing.JComboBox();
        btnAgregarProductor = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLote = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnAgregarLote = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        txtRetiro = new javax.swing.JTextField();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Viaje");

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Fecha");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 60, 20);
        jPanel1.add(txtHora);
        txtHora.setBounds(190, 10, 70, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Hora");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(155, 10, 51, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Carolina");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(600, 0, 50, 30);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/UsuarioLogueado.png"))); // NOI18N
        jPanel1.add(jLabel13);
        jLabel13.setBounds(650, 0, 30, 30);
        jPanel1.add(txtFecha);
        txtFecha.setBounds(50, 10, 70, 20);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Viaje", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        jPanel9.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Número Viaje");
        jPanel9.add(jLabel4);
        jLabel4.setBounds(20, 30, 100, 20);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Estado");
        jPanel9.add(jLabel5);
        jLabel5.setBounds(240, 30, 70, 20);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Tipo Viaje");
        jPanel9.add(jLabel6);
        jLabel6.setBounds(470, 30, 90, 20);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Solicitante");
        jPanel9.add(jLabel7);
        jLabel7.setBounds(40, 60, 90, 20);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Fecha Realizacion");
        jPanel9.add(jLabel8);
        jLabel8.setBounds(350, 60, 130, 20);
        jPanel9.add(txtNumViaje);
        txtNumViaje.setBounds(100, 30, 82, 20);

        cmbTipoViaje.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Traslado a Puerto", "Traslado a Establecimiento", "Retiro" }));
        jPanel9.add(cmbTipoViaje);
        cmbTipoViaje.setBounds(530, 30, 140, 20);
        jPanel9.add(txtSolicitante);
        txtSolicitante.setBounds(100, 60, 190, 20);
        jPanel9.add(calendarioViaje);
        calendarioViaje.setBounds(460, 60, 90, 20);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("PENDIENTE");
        jPanel9.add(jLabel9);
        jLabel9.setBounds(290, 30, 90, 20);

        btnGuardar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");

        btnSalir.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Salir.png"))); // NOI18N
        btnSalir.setText("Salir");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPuerto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Traslado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panelPuerto.setLayout(null);
        panelPuerto.add(txtProductor);
        txtProductor.setBounds(110, 150, 180, 20);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aceptar.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        panelPuerto.add(btnAgregar);
        btnAgregar.setBounds(630, 70, 40, 30);
        panelPuerto.add(txtProvinciaT);
        txtProvinciaT.setBounds(110, 180, 180, 20);
        panelPuerto.add(txtToneladasE);
        txtToneladasE.setBounds(370, 210, 110, 20);

        labelLocalidad.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelLocalidad.setText("Localidad");
        panelPuerto.add(labelLocalidad);
        labelLocalidad.setBounds(400, 180, 90, 20);

        labelDepto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelDepto.setText("Departamento");
        panelPuerto.add(labelDepto);
        labelDepto.setBounds(20, 180, 100, 20);
        panelPuerto.add(txtDeptoT);
        txtDeptoT.setBounds(110, 180, 180, 20);
        panelPuerto.add(txtLocalidad);
        txtLocalidad.setBounds(470, 180, 180, 20);

        labelProductor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelProductor.setText("Productor");
        panelPuerto.add(labelProductor);
        labelProductor.setBounds(40, 150, 100, 20);

        labelCereal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelCereal.setText("Tipo de Cereal");
        panelPuerto.add(labelCereal);
        labelCereal.setBounds(20, 210, 110, 20);

        tblEstablecimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº Solicitud", "Productor", "Número de Documento"
            }
        ));
        scpEstablecimiento.setViewportView(tblEstablecimiento);

        panelPuerto.add(scpEstablecimiento);
        scpEstablecimiento.setBounds(60, 30, 560, 100);

        labelPuerto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelPuerto.setText("Puerto");
        panelPuerto.add(labelPuerto);
        labelPuerto.setBounds(420, 150, 70, 20);

        labelEstablecimiento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelEstablecimiento.setText("Establecimiento");
        panelPuerto.add(labelEstablecimiento);
        labelEstablecimiento.setBounds(370, 150, 110, 20);

        labelProvincia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelProvincia.setText("Provincia");
        panelPuerto.add(labelProvincia);
        labelProvincia.setBounds(50, 180, 80, 20);

        labelToneladasE.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelToneladasE.setText("Toneladas a Extraer");
        panelPuerto.add(labelToneladasE);
        labelToneladasE.setBounds(250, 210, 150, 20);
        panelPuerto.add(txtCerealT);
        txtCerealT.setBounds(110, 210, 110, 20);
        panelPuerto.add(txtTraslado);
        txtTraslado.setBounds(470, 150, 180, 20);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Silo Nº");
        panelPuerto.add(jLabel10);
        jLabel10.setBounds(520, 210, 70, 20);
        panelPuerto.add(jTextField2);
        jTextField2.setBounds(560, 210, 90, 20);

        panelEstablecimiento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Retiro", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panelEstablecimiento.setLayout(null);

        tblProductor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº Solicitud", "Productor", "Número de Documento"
            }
        ));
        jScrollPane2.setViewportView(tblProductor);

        panelEstablecimiento.add(jScrollPane2);
        jScrollPane2.setBounds(70, 30, 560, 92);

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setText("Establecimiento");
        panelEstablecimiento.add(jLabel16);
        jLabel16.setBounds(350, 130, 120, 20);

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("Localidad");
        panelEstablecimiento.add(jLabel17);
        jLabel17.setBounds(380, 160, 100, 20);

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("Departamento");
        panelEstablecimiento.add(jLabel18);
        jLabel18.setBounds(30, 160, 110, 20);
        panelEstablecimiento.add(txtProductorEst);
        txtProductorEst.setBounds(120, 130, 180, 20);
        panelEstablecimiento.add(txtDepto);
        txtDepto.setBounds(120, 160, 180, 20);

        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setText("Productor");
        panelEstablecimiento.add(jLabel19);
        jLabel19.setBounds(50, 130, 90, 20);

        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setText("Tipo Cereal");
        panelEstablecimiento.add(jLabel20);
        jLabel20.setBounds(40, 190, 80, 20);
        panelEstablecimiento.add(txtLocalidadEst);
        txtLocalidadEst.setBounds(450, 160, 180, 20);

        jLabel21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel21.setText("Hectáreas a Trillar");
        panelEstablecimiento.add(jLabel21);
        jLabel21.setBounds(10, 220, 130, 20);
        panelEstablecimiento.add(txtHas);
        txtHas.setBounds(120, 220, 100, 20);

        jLabel22.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel22.setText("Lote ");
        panelEstablecimiento.add(jLabel22);
        jLabel22.setBounds(80, 250, 70, 20);

        panelEstablecimiento.add(cmbLote);
        cmbLote.setBounds(120, 250, 100, 20);

        btnAgregarProductor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aceptar.png"))); // NOI18N
        btnAgregarProductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductorActionPerformed(evt);
            }
        });
        panelEstablecimiento.add(btnAgregarProductor);
        btnAgregarProductor.setBounds(640, 60, 40, 30);

        tblLote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lote", "Latitud", "Longitud"
            }
        ));
        jScrollPane3.setViewportView(tblLote);

        panelEstablecimiento.add(jScrollPane3);
        jScrollPane3.setBounds(280, 210, 410, 80);

        btnAgregarLote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarLote, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(btnAgregarLote, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        panelEstablecimiento.add(jPanel3);
        jPanel3.setBounds(220, 220, 60, 80);
        panelEstablecimiento.add(jTextField1);
        jTextField1.setBounds(120, 190, 100, 20);
        panelEstablecimiento.add(txtRetiro);
        txtRetiro.setBounds(450, 130, 180, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                            .addComponent(panelEstablecimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPuerto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(panelPuerto, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelEstablecimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
    DefaultTableModel modeloT = (DefaultTableModel) tblEstablecimiento.getModel();
    int fila = tblEstablecimiento.getSelectedRow();
    txtProductor.setText((String)modeloT.getValueAt(fila, 0));
    if(cmbTipoViaje.getSelectedItem().toString()=="Traslado a Establecimiento"){
        cmbEstablecimientoT.setModel(gViaje.CargarDatosEstablecimiento(txt));
    
    
    }
    
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAgregarProductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductorActionPerformed
    
    }//GEN-LAST:event_btnAgregarProductorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarLote;
    private javax.swing.JButton btnAgregarProductor;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private datechooser.beans.DateChooserCombo calendarioViaje;
    private javax.swing.JComboBox cmbLote;
    private javax.swing.JComboBox cmbTipoViaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
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
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelCereal;
    private javax.swing.JLabel labelDepto;
    private javax.swing.JLabel labelEstablecimiento;
    private javax.swing.JLabel labelLocalidad;
    private javax.swing.JLabel labelProductor;
    private javax.swing.JLabel labelProvincia;
    private javax.swing.JLabel labelPuerto;
    private javax.swing.JLabel labelToneladasE;
    private javax.swing.JPanel panelEstablecimiento;
    private javax.swing.JPanel panelPuerto;
    private javax.swing.JScrollPane scpEstablecimiento;
    private javax.swing.JTable tblEstablecimiento;
    private javax.swing.JTable tblLote;
    private javax.swing.JTable tblProductor;
    private javax.swing.JTextField txtCerealT;
    private javax.swing.JTextField txtDepto;
    private javax.swing.JTextField txtDeptoT;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHas;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtLocalidad;
    private javax.swing.JTextField txtLocalidadEst;
    private javax.swing.JTextField txtNumViaje;
    private javax.swing.JTextField txtProductor;
    private javax.swing.JTextField txtProductorEst;
    private javax.swing.JTextField txtProvinciaT;
    private javax.swing.JTextField txtRetiro;
    private javax.swing.JTextField txtSolicitante;
    private javax.swing.JTextField txtToneladasE;
    private javax.swing.JTextField txtTraslado;
    // End of variables declaration//GEN-END:variables
}
