/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmRegistroTransportista.java
 *
 * Created on 14/10/2011, 14:45:59
 */
package Ventanas_Transporte;


import Hibernate.GestorHibernate;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Clases_Modulo_Transporte.*;
import Gestores_Clases.*;
import java.awt.event.ActionListener;
import Gestores_Vista.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TimeZone;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableCellRenderer;


/**
 *
 * @author Charito
 */
public class frmRegistroTransportista extends javax.swing.JInternalFrame{

    gestorBarrio gBarrio = new gestorBarrio();
    gestorCondicionContratacion gCondicion = new gestorCondicionContratacion();
    gestorDepartamento gdepto = new gestorDepartamento();
    gestorLocalidad gLocalidad = new gestorLocalidad();
    gestorPais gPais = new gestorPais();
    gestorProvincia gProvincia = new gestorProvincia();
    gestorTipoDocumento gtipoDoc = new gestorTipoDocumento();
    gestorTipoTelefono gTipoTel = new gestorTipoTelefono();
    gestorRegistroTransportista gRegistro = new gestorRegistroTransportista();
    gestorRegistrarProductor gProductor = new gestorRegistrarProductor();
    GestorHibernate gestorH = new GestorHibernate();
    boolean editar=false;
    
    public frmRegistroTransportista() {
        initComponents();    
        panelTabla.setVisible(false);
        panelDatosP.setVisible(true);
        jScrollPane4.setVisible(false);
        tblModificaT.setVisible(false);
        panelTransportista.setVisible(true);
        btnGuardar.setEnabled(false);
        btnEmitirFicha.setEnabled(false);
        
        for(int i=0;i<panelContratacion.getComponents().length;i++){
           panelContratacion.getComponent(i).setEnabled(false);
         }
        
        for(int i=0;i<panelDatosU.getComponents().length;i++){
           panelDatosU.getComponent(i).setEnabled(false);
         }
        
        for(int i=0;i<panelDatosP.getComponents().length;i++){
           panelDatosP.getComponent(i).setEnabled(false);
         }
        
        for(int i=0;i<panelBotonesI.getComponents().length;i++){
           panelBotonesI.getComponent(i).setEnabled(false);
       }
       for(int i=0;i<panelBotonesD.getComponents().length;i++){
           panelBotonesD.getComponent(i).setEnabled(false);
       }
        
        gBarrio.actualizarUsuario(labelusuario);
        cmbPais.setModel(gPais.getComboModelPais());
        cmbMarcaCamion.setModel(gRegistro.rellenaComboMarca());
        //Las siguientes lineas son para dar a la pantalla el tamaño requerido y luego centrarla en la pantalla.
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = kit.getScreenSize();
        int ancho = 1020;
        int alto = 620;
        this.setSize(ancho, alto);
        this.setLocation(70, 0);
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(buttonAcoplado);
        grupo.add(buttonCamion);
        grupo.add(buttonCamionAcoplado);
        buttonCamion.setSelected(true);
        txtNumero.setText("0");
        txtPiso.setText("0");
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
        
        
        //redimensionar columnas de las tabla
        tblVehiculo.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblVehiculo.getColumnModel().getColumn(1).setPreferredWidth(120);
        tblVehiculo.getColumnModel().getColumn(2).setPreferredWidth(120);
        tblVehiculo.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblVehiculo.getColumnModel().getColumn(4).setPreferredWidth(80);
        tblModificaT.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblModificaT.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblModificaT.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblModificaT.getColumnModel().getColumn(3).setPreferredWidth(50);
        
        //centrar cabecera jtable
        DefaultTableCellRenderer renderer2 = (DefaultTableCellRenderer) tblVehiculo.getTableHeader().getDefaultRenderer();
        renderer2.setHorizontalAlignment(0);
        DefaultTableCellRenderer renderer3 = (DefaultTableCellRenderer) tblModificaT.getTableHeader().getDefaultRenderer();
        renderer3.setHorizontalAlignment(0);
    
        //Carga Tipo Tel
        cmbTipoTel.setModel(gRegistro.rellenaComboTipoTel());
        
        //Carga Tipo Contratacion
        cmbTipoContratacion.setModel(gRegistro.rellenaComboTipoContratacion());
        
        //Carga Tipo Documento
        cmbTipoDoc.setModel(gRegistro.rellenaComboTipoDoc());
        
        //Carga Anio compra
        
        cmbAnioCamion.setModel(gRegistro.rellenaComboAnio());
        cmbAnioAcoplado.setModel(gRegistro.rellenaComboAnio());
        
        //Carga Marca Acoplado
        cmbMarcaAcoplado.setModel(gRegistro.rellenaComboMarca());
        
        //Carga Provincia de acuerdo al Pais
        cmbPais.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0){
            cmbProvincia.setModel(gRegistro.rellenaCombo(cmbPais.getSelectedItem().toString()));
        }
        }
        );
        cmbProvincia.setModel(gRegistro.rellenaCombo(cmbPais.getSelectedItem().toString()));
        //Relleno Departamento de acuerdo a la Provincia
        cmbProvincia.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                cmbDepto.setModel(gRegistro.rellenaComboDepartamento(cmbProvincia.getSelectedItem().toString()));
            }
        });
        cmbDepto.setModel(gRegistro.rellenaComboDepartamento(cmbProvincia.getSelectedItem().toString()));
       
        //Relleno Localidad de acuerdo al Departamento
        cmbDepto.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                cmbLocalidad.setModel(gRegistro.rellenaComboLocalidad(cmbDepto.getSelectedItem().toString()));
            }
        });
        cmbLocalidad.setModel(gRegistro.rellenaComboLocalidad(cmbDepto.getSelectedItem().toString()));
        //Carga Barrio de acuerdo a Localidad
        cmbLocalidad.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0){
            cmbBarrio.setModel(gRegistro.rellenaComboBarrio(cmbLocalidad.getSelectedItem().toString()));
        }
        }
        );
         cmbBarrio.setModel(gRegistro.rellenaComboBarrio(cmbLocalidad.getSelectedItem().toString()));
         
         //Deshabilito Componentes Vehiculo
         gRegistro.deshabilitarCombo(cmbAnioAcoplado, cmbAnioCamion, cmbEjesAcoplado, cmbMarcaAcoplado, cmbMarcaCamion, cmbModeloCamion);
         gRegistro.deshabilitarTxt(txtAnchoAcoplado, txtDominioAcoplado, txtLargoAcplado, txtSerieAcoplado, txtTaraAcoplado, txtAnchoCamion, txtDominioCamion, txtKilometros, txtLargoCamion, txtTaraCamion);
//         btnAceptarCamion.setEnabled(true);
    
         cmbMarcaCamion.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0){
            cmbModeloCamion.setModel(gRegistro.rellenaComboModelo(cmbMarcaCamion.getSelectedItem().toString()));
        }
        }
        );
        cmbModeloCamion.setModel(gRegistro.rellenaComboModelo(cmbMarcaCamion.getSelectedItem().toString()));
         
       
         
         
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        labelusuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelTransportista = new javax.swing.JPanel();
        panelDatosU = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtDepto = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtPiso = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cmbProvincia = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        cmbLocalidad = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        cmbPais = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        cmbBarrio = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        cmbDepto = new javax.swing.JComboBox();
        panelBotonesI = new javax.swing.JPanel();
        btnAgregarDepartamento = new javax.swing.JButton();
        btnAgregarPais = new javax.swing.JButton();
        btnAgregarBarrio = new javax.swing.JButton();
        panelBotonesD = new javax.swing.JPanel();
        btnAgregarProvincia = new javax.swing.JButton();
        btnAgregarLocalidad = new javax.swing.JButton();
        tblPrueba = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelContratacion = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        cmbTipoContratacion = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtCUIL = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        calendarioFin = new datechooser.beans.DateChooserCombo();
        calendarioIngreso = new datechooser.beans.DateChooserCombo();
        jPanel8 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        btnBuscarTransportista = new javax.swing.JButton();
        panelTabla = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblModificaT = new javax.swing.JTable();
        btnAceptarTransp = new javax.swing.JButton();
        panelDatosP = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbTipoDoc = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbEstadoCivil = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        cmbTipoTel = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        calendarioNacimiento = new datechooser.beans.DateChooserCombo();
        panelVehiculo = new javax.swing.JPanel();
        panelAcoplado = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        cmbMarcaAcoplado = new javax.swing.JComboBox();
        jLabel39 = new javax.swing.JLabel();
        cmbEjesAcoplado = new javax.swing.JComboBox();
        jLabel40 = new javax.swing.JLabel();
        cmbAnioAcoplado = new javax.swing.JComboBox();
        jLabel41 = new javax.swing.JLabel();
        txtDominioAcoplado = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtTaraAcoplado = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtLargoAcplado = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtSerieAcoplado = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txtAnchoAcoplado = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        buttonCamion = new javax.swing.JRadioButton();
        buttonAcoplado = new javax.swing.JRadioButton();
        buttonCamionAcoplado = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVehiculo = new javax.swing.JTable();
        btnEliminarVehiculo = new javax.swing.JButton();
        btnAgregarCamionAcoplado = new javax.swing.JButton();
        btnAgregarCamion = new javax.swing.JButton();
        btnAgregarAcoplado = new javax.swing.JButton();
        btnEditarVehiculo = new javax.swing.JButton();
        panelCamion1 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        cmbModeloCamion = new javax.swing.JComboBox();
        jLabel50 = new javax.swing.JLabel();
        cmbMarcaCamion = new javax.swing.JComboBox();
        jLabel51 = new javax.swing.JLabel();
        cmbAnioCamion = new javax.swing.JComboBox();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txtKilometros = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        txtDominioCamion = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        txtLargoCamion = new javax.swing.JTextField();
        txtTaraCamion = new javax.swing.JTextField();
        txtAnchoCamion = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEmitirFicha = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);
        setTitle("Transportista");
        setPreferredSize(new java.awt.Dimension(1021, 50));

        jPanel4.setPreferredSize(new java.awt.Dimension(1001, 400));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Fecha");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Hora");

        labelusuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelusuario.setText("Usuario");

        panelTransportista.setLayout(null);

        panelDatosU.setLayout(null);

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("Calle");
        panelDatosU.add(jLabel13);
        jLabel13.setBounds(10, 10, 40, 20);

        txtCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCalleKeyTyped(evt);
            }
        });
        panelDatosU.add(txtCalle);
        txtCalle.setBounds(50, 10, 240, 20);

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setText("Número");
        panelDatosU.add(jLabel14);
        jLabel14.setBounds(330, 10, 50, 20);

        txtNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroActionPerformed(evt);
            }
        });
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroKeyTyped(evt);
            }
        });
        panelDatosU.add(txtNumero);
        txtNumero.setBounds(380, 10, 60, 20);

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("Piso");
        panelDatosU.add(jLabel15);
        jLabel15.setBounds(475, 10, 30, 20);
        panelDatosU.add(txtDepto);
        txtDepto.setBounds(630, 10, 50, 20);

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setText("Depto");
        panelDatosU.add(jLabel16);
        jLabel16.setBounds(590, 10, 40, 20);

        txtPiso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPisoKeyTyped(evt);
            }
        });
        panelDatosU.add(txtPiso);
        txtPiso.setBounds(510, 10, 50, 20);

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("País");
        panelDatosU.add(jLabel17);
        jLabel17.setBounds(70, 40, 40, 20);

        panelDatosU.add(cmbProvincia);
        cmbProvincia.setBounds(440, 50, 190, 20);

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("Provincia");
        panelDatosU.add(jLabel18);
        jLabel18.setBounds(380, 50, 60, 20);

        panelDatosU.add(cmbLocalidad);
        cmbLocalidad.setBounds(440, 90, 190, 20);

        jLabel19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel19.setText("Departamento");
        panelDatosU.add(jLabel19);
        jLabel19.setBounds(20, 80, 100, 20);

        panelDatosU.add(cmbPais);
        cmbPais.setBounds(100, 40, 190, 20);

        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setText("Localidad");
        panelDatosU.add(jLabel20);
        jLabel20.setBounds(380, 90, 60, 20);

        panelDatosU.add(cmbBarrio);
        cmbBarrio.setBounds(100, 120, 190, 20);

        jLabel21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel21.setText("Barrio");
        panelDatosU.add(jLabel21);
        jLabel21.setBounds(60, 120, 50, 20);

        panelDatosU.add(cmbDepto);
        cmbDepto.setBounds(100, 80, 190, 20);

        btnAgregarDepartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N

        btnAgregarPais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N

        btnAgregarBarrio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N

        javax.swing.GroupLayout panelBotonesILayout = new javax.swing.GroupLayout(panelBotonesI);
        panelBotonesI.setLayout(panelBotonesILayout);
        panelBotonesILayout.setHorizontalGroup(
            panelBotonesILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesILayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBotonesILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarPais, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarDepartamento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarBarrio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelBotonesILayout.setVerticalGroup(
            panelBotonesILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesILayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btnAgregarPais, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        panelDatosU.add(panelBotonesI);
        panelBotonesI.setBounds(290, 30, 60, 120);

        btnAgregarProvincia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N

        btnAgregarLocalidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N

        javax.swing.GroupLayout panelBotonesDLayout = new javax.swing.GroupLayout(panelBotonesD);
        panelBotonesD.setLayout(panelBotonesDLayout);
        panelBotonesDLayout.setHorizontalGroup(
            panelBotonesDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesDLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBotonesDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarLocalidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProvincia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelBotonesDLayout.setVerticalGroup(
            panelBotonesDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesDLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnAgregarProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        panelDatosU.add(panelBotonesD);
        panelBotonesD.setBounds(630, 30, 60, 100);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPrueba.setViewportView(jTable1);

        panelDatosU.add(tblPrueba);
        tblPrueba.setBounds(100, -130, 660, 130);

        panelTransportista.add(panelDatosU);
        panelDatosU.setBounds(140, 210, 720, 150);

        panelContratacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de contratación", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panelContratacion.setLayout(null);

        jLabel22.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel22.setText("Tipo de Contratación");
        panelContratacion.add(jLabel22);
        jLabel22.setBounds(10, 20, 150, 20);
        panelContratacion.add(cmbTipoContratacion);
        cmbTipoContratacion.setBounds(130, 20, 120, 20);

        jLabel23.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel23.setText("Fecha de Ingreso");
        panelContratacion.add(jLabel23);
        jLabel23.setBounds(280, 20, 130, 20);

        jLabel24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel24.setText("CUIL");
        panelContratacion.add(jLabel24);
        jLabel24.setBounds(100, 50, 60, 20);

        txtCUIL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCUILKeyTyped(evt);
            }
        });
        panelContratacion.add(txtCUIL);
        txtCUIL.setBounds(130, 50, 160, 20);

        jLabel25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel25.setText("Fecha de Salida");
        panelContratacion.add(jLabel25);
        jLabel25.setBounds(500, 20, 110, 20);
        panelContratacion.add(calendarioFin);
        calendarioFin.setBounds(590, 20, 100, 20);
        panelContratacion.add(calendarioIngreso);
        calendarioIngreso.setBounds(380, 20, 100, 20);

        panelTransportista.add(panelContratacion);
        panelContratacion.setBounds(170, 370, 700, 80);

        jPanel8.setLayout(null);

        jLabel26.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel26.setText("Buscar Transportista");
        jPanel8.add(jLabel26);
        jLabel26.setBounds(60, 0, 190, 30);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel13);
        jPanel13.setBounds(580, 70, 100, 70);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel14);
        jPanel14.setBounds(580, 70, 100, 70);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel15);
        jPanel15.setBounds(580, 70, 100, 70);

        btnBuscarTransportista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar.png"))); // NOI18N
        btnBuscarTransportista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTransportistaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnBuscarTransportista, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(btnBuscarTransportista, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel19);
        jPanel19.setBounds(190, 0, 100, 40);

        panelTransportista.add(jPanel8);
        jPanel8.setBounds(310, 0, 300, 40);

        panelTabla.setLayout(null);

        tblModificaT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº Documento", "Apellido y Nombre", "Modelo Vehículo", "Dominio Vehículo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblModificaT);

        panelTabla.add(jScrollPane4);
        jScrollPane4.setBounds(60, 10, 580, 130);

        btnAceptarTransp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aceptar.png"))); // NOI18N
        btnAceptarTransp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarTranspActionPerformed(evt);
            }
        });
        panelTabla.add(btnAceptarTransp);
        btnAceptarTransp.setBounds(650, 60, 49, 30);

        panelTransportista.add(panelTabla);
        panelTabla.setBounds(140, 50, 710, 150);

        panelDatosP.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Apellido");
        panelDatosP.add(jLabel5);
        jLabel5.setBounds(10, 10, 100, 20);

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });
        panelDatosP.add(txtApellido);
        txtApellido.setBounds(130, 10, 240, 20);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Nombres");
        panelDatosP.add(jLabel6);
        jLabel6.setBounds(390, 10, 70, 20);

        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });
        panelDatosP.add(txtNombres);
        txtNombres.setBounds(450, 10, 240, 20);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Tipo Documento");
        panelDatosP.add(jLabel7);
        jLabel7.setBounds(10, 40, 100, 20);

        panelDatosP.add(cmbTipoDoc);
        cmbTipoDoc.setBounds(130, 40, 120, 20);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Numero Documento");
        panelDatosP.add(jLabel8);
        jLabel8.setBounds(330, 40, 120, 20);

        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyTyped(evt);
            }
        });
        panelDatosP.add(txtDocumento);
        txtDocumento.setBounds(450, 40, 120, 20);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Fecha de Nacimiento");
        panelDatosP.add(jLabel9);
        jLabel9.setBounds(10, 70, 120, 20);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Estado Civil");
        panelDatosP.add(jLabel10);
        jLabel10.setBounds(380, 70, 70, 20);

        cmbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Soltero", "Casado", "Viudo" }));
        panelDatosP.add(cmbEstadoCivil);
        cmbEstadoCivil.setBounds(450, 70, 120, 20);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Tipo Teléfono");
        panelDatosP.add(jLabel11);
        jLabel11.setBounds(10, 100, 80, 20);

        panelDatosP.add(cmbTipoTel);
        cmbTipoTel.setBounds(130, 100, 120, 20);

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Número Teléfono");
        panelDatosP.add(jLabel12);
        jLabel12.setBounds(350, 100, 100, 20);

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        panelDatosP.add(txtTelefono);
        txtTelefono.setBounds(450, 100, 170, 20);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        panelDatosP.add(jPanel7);
        jPanel7.setBounds(-20, -50, 700, 40);
        panelDatosP.add(calendarioNacimiento);
        calendarioNacimiento.setBounds(130, 70, 120, 20);

        panelTransportista.add(panelDatosP);
        panelDatosP.setBounds(130, 50, 740, 180);

        jTabbedPane1.addTab("Transportista", panelTransportista);

        panelVehiculo.setLayout(null);

        panelAcoplado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del acoplado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panelAcoplado.setLayout(null);

        jLabel38.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel38.setText("Marca");
        panelAcoplado.add(jLabel38);
        jLabel38.setBounds(60, 40, 50, 20);

        panelAcoplado.add(cmbMarcaAcoplado);
        cmbMarcaAcoplado.setBounds(100, 40, 130, 20);

        jLabel39.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel39.setText("Ejes");
        panelAcoplado.add(jLabel39);
        jLabel39.setBounds(250, 40, 60, 20);

        cmbEjesAcoplado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "3", "4" }));
        panelAcoplado.add(cmbEjesAcoplado);
        cmbEjesAcoplado.setBounds(290, 40, 90, 20);

        jLabel40.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel40.setText("Año de Compra");
        panelAcoplado.add(jLabel40);
        jLabel40.setBounds(10, 70, 90, 20);

        panelAcoplado.add(cmbAnioAcoplado);
        cmbAnioAcoplado.setBounds(100, 70, 100, 20);

        jLabel41.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel41.setText("Dominio");
        panelAcoplado.add(jLabel41);
        jLabel41.setBounds(230, 70, 70, 20);
        panelAcoplado.add(txtDominioAcoplado);
        txtDominioAcoplado.setBounds(290, 70, 100, 20);

        jLabel42.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel42.setText("Serie");
        panelAcoplado.add(jLabel42);
        jLabel42.setBounds(250, 100, 70, 20);
        panelAcoplado.add(txtTaraAcoplado);
        txtTaraAcoplado.setBounds(100, 100, 100, 20);

        jLabel43.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel43.setText("Largo");
        panelAcoplado.add(jLabel43);
        jLabel43.setBounds(60, 130, 40, 20);
        panelAcoplado.add(txtLargoAcplado);
        txtLargoAcplado.setBounds(100, 130, 100, 20);

        jLabel44.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel44.setText("mts");
        panelAcoplado.add(jLabel44);
        jLabel44.setBounds(390, 130, 30, 20);

        jLabel45.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel45.setText("Ancho");
        panelAcoplado.add(jLabel45);
        jLabel45.setBounds(250, 130, 50, 20);
        panelAcoplado.add(txtSerieAcoplado);
        txtSerieAcoplado.setBounds(290, 100, 100, 20);

        jLabel46.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel46.setText("mts");
        panelAcoplado.add(jLabel46);
        jLabel46.setBounds(200, 130, 30, 20);

        jLabel47.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel47.setText("Tara");
        panelAcoplado.add(jLabel47);
        jLabel47.setBounds(70, 100, 50, 20);
        panelAcoplado.add(txtAnchoAcoplado);
        txtAnchoAcoplado.setBounds(290, 130, 100, 20);

        jLabel27.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel27.setText("Tn");
        panelAcoplado.add(jLabel27);
        jLabel27.setBounds(200, 100, 30, 20);

        panelVehiculo.add(panelAcoplado);
        panelAcoplado.setBounds(517, 60, 418, 190);

        jPanel11.setLayout(null);

        jLabel35.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel35.setText("Tipo de Vehículo");
        jPanel11.add(jLabel35);
        jLabel35.setBounds(10, 10, 140, 20);

        buttonCamion.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        buttonCamion.setText("Camión");
        buttonCamion.setContentAreaFilled(false);
        buttonCamion.setFocusPainted(false);
        buttonCamion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCamionActionPerformed(evt);
            }
        });
        jPanel11.add(buttonCamion);
        buttonCamion.setBounds(130, 10, 93, 22);

        buttonAcoplado.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        buttonAcoplado.setText("Acoplado");
        buttonAcoplado.setContentAreaFilled(false);
        buttonAcoplado.setFocusPainted(false);
        buttonAcoplado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAcopladoActionPerformed(evt);
            }
        });
        jPanel11.add(buttonAcoplado);
        buttonAcoplado.setBounds(220, 10, 80, 22);

        buttonCamionAcoplado.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        buttonCamionAcoplado.setText("Camión y Acoplado");
        buttonCamionAcoplado.setContentAreaFilled(false);
        buttonCamionAcoplado.setFocusPainted(false);
        buttonCamionAcoplado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCamionAcopladoActionPerformed(evt);
            }
        });
        jPanel11.add(buttonCamionAcoplado);
        buttonCamionAcoplado.setBounds(310, 10, 120, 22);

        panelVehiculo.add(jPanel11);
        jPanel11.setBounds(309, 11, 535, 43);

        tblVehiculo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dominio Camión", "Marca", "Modelo", "Dominio Acoplado", "Serie"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVehiculo.getTableHeader().setResizingAllowed(false);
        tblVehiculo.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblVehiculo);

        panelVehiculo.add(jScrollPane1);
        jScrollPane1.setBounds(220, 310, 570, 130);

        btnEliminarVehiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        panelVehiculo.add(btnEliminarVehiculo);
        btnEliminarVehiculo.setBounds(800, 380, 40, 30);

        btnAgregarCamionAcoplado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N
        btnAgregarCamionAcoplado.setText("Agregar");
        btnAgregarCamionAcoplado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCamionAcopladoActionPerformed(evt);
            }
        });
        panelVehiculo.add(btnAgregarCamionAcoplado);
        btnAgregarCamionAcoplado.setBounds(460, 270, 110, 30);

        btnAgregarCamion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N
        btnAgregarCamion.setText("Agregar");
        btnAgregarCamion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCamionActionPerformed(evt);
            }
        });
        panelVehiculo.add(btnAgregarCamion);
        btnAgregarCamion.setBounds(460, 270, 110, 30);

        btnAgregarAcoplado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N
        btnAgregarAcoplado.setText("Agregar");
        btnAgregarAcoplado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAcopladoActionPerformed(evt);
            }
        });
        panelVehiculo.add(btnAgregarAcoplado);
        btnAgregarAcoplado.setBounds(460, 270, 110, 30);

        btnEditarVehiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        btnEditarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarVehiculoActionPerformed(evt);
            }
        });
        panelVehiculo.add(btnEditarVehiculo);
        btnEditarVehiculo.setBounds(800, 340, 40, 30);

        panelCamion1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del camión", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panelCamion1.setLayout(null);

        jLabel49.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel49.setText("Marca");
        panelCamion1.add(jLabel49);
        jLabel49.setBounds(50, 40, 50, 20);

        panelCamion1.add(cmbModeloCamion);
        cmbModeloCamion.setBounds(330, 40, 130, 20);

        jLabel50.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel50.setText("Modelo");
        panelCamion1.add(jLabel50);
        jLabel50.setBounds(280, 40, 60, 20);

        panelCamion1.add(cmbMarcaCamion);
        cmbMarcaCamion.setBounds(100, 40, 130, 20);

        jLabel51.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel51.setText("Año de Compra");
        panelCamion1.add(jLabel51);
        jLabel51.setBounds(10, 70, 90, 20);

        panelCamion1.add(cmbAnioCamion);
        cmbAnioCamion.setBounds(100, 70, 100, 20);

        jLabel52.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel52.setText("Kilómetros");
        panelCamion1.add(jLabel52);
        jLabel52.setBounds(260, 70, 80, 20);

        jLabel53.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel53.setText("Dominio");
        panelCamion1.add(jLabel53);
        jLabel53.setBounds(50, 100, 60, 20);

        txtKilometros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKilometrosKeyTyped(evt);
            }
        });
        panelCamion1.add(txtKilometros);
        txtKilometros.setBounds(330, 70, 100, 20);

        jLabel54.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel54.setText("Largo");
        panelCamion1.add(jLabel54);
        jLabel54.setBounds(60, 130, 40, 20);
        panelCamion1.add(txtDominioCamion);
        txtDominioCamion.setBounds(100, 100, 100, 20);

        jLabel55.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel55.setText("Ancho");
        panelCamion1.add(jLabel55);
        jLabel55.setBounds(280, 130, 60, 20);

        jLabel56.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel56.setText("Tara");
        panelCamion1.add(jLabel56);
        jLabel56.setBounds(290, 100, 60, 20);
        panelCamion1.add(txtLargoCamion);
        txtLargoCamion.setBounds(100, 130, 100, 20);
        panelCamion1.add(txtTaraCamion);
        txtTaraCamion.setBounds(330, 100, 100, 20);
        panelCamion1.add(txtAnchoCamion);
        txtAnchoCamion.setBounds(330, 130, 100, 20);

        jLabel57.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel57.setText("mts");
        panelCamion1.add(jLabel57);
        jLabel57.setBounds(430, 130, 30, 20);

        jLabel58.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel58.setText("mts");
        panelCamion1.add(jLabel58);
        jLabel58.setBounds(200, 130, 30, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Tn");
        panelCamion1.add(jLabel3);
        jLabel3.setBounds(430, 100, 30, 20);

        panelVehiculo.add(panelCamion1);
        panelCamion1.setBounds(40, 60, 471, 190);

        jTabbedPane1.addTab("Vehículo", panelVehiculo);

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/UsuarioLogueado.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 509, Short.MAX_VALUE)
                .addComponent(labelusuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(95, 95, 95))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)))
                    .addComponent(jLabel48)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(labelusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNuevo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icononuevo.PNG"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
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

        btnEmitirFicha.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnEmitirFicha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/emitir ficha.png"))); // NOI18N
        btnEmitirFicha.setText("Emitir Ficha");

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Salir.png"))); // NOI18N
        btnCancelar.setText("Salir");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(333, 333, 333)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmitirFicha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1011, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmitirFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    int campo = gRegistro.campoObligatorio(txtApellido, txtNombres, txtDocumento, txtCalle, txtNumero, txtCUIL, txtCUIL, txtCUIL);
    GestorHibernate gestorH = new GestorHibernate();
    if(campo==0){
    gestorBitacora gestorB = new gestorBitacora();
    if(editar==false){
    if(tblVehiculo.getRowCount()!=0){
    
    Transportista transportista= new Transportista();

    transportista.setApellido(txtApellido.getText());
    transportista.setFechaNacimiento(calendarioNacimiento.getText());
    transportista.setNombre(txtNombres.getText());
    transportista.setNumeroDocumento(txtDocumento.getText());
    transportista.setCondicionContratacion((CondicionContratacion)cmbTipoContratacion.getSelectedItem());
    transportista.setCuil(txtCUIL.getText());
    transportista.setEstadoCivil((String)cmbEstadoCivil.getSelectedItem());
    transportista.setFechaIngreso(calendarioNacimiento.getText());
    transportista.setFechaSalida(calendarioFin.getText());
    transportista.setTipoDocumento((TipoDocumento)cmbTipoDoc.getSelectedItem());
    Domicilio domicilio = gProductor.guardarDomicilio(cmbBarrio.getSelectedItem().toString(), txtCalle.getText(),txtDepto.getText(), txtNumero.getText(), txtPiso.getText());

    gestorH.guardarObjeto(domicilio);
    transportista.setDomicilio(domicilio);
    gestorH.guardarObjeto(transportista);
    DefaultTableModel modeloT = (DefaultTableModel) tblVehiculo.getModel();
    for (int i =0; i<tblVehiculo.getRowCount(); i++){
        Iterator ite5 = gestorH.listarClase(Vehiculo.class).iterator();
        while(ite5.hasNext()){
            Vehiculo vehiculo = (Vehiculo) ite5.next();
            if(vehiculo.getDominio().equalsIgnoreCase(((String) modeloT.getValueAt(i, 0)))){
            vehiculo.setTransportista(transportista);}
            gestorB.cargarBitacora(vehiculo.getDominio(), txtFecha.getText(), 5, labelusuario.getText(), "Ficha de Personal");
        }
          
        

    }
   
    gestorB.cargarBitacora(transportista.getNumeroDocumento(), txtFecha.getText(), 4, labelusuario.getText(), "Ficha de Personal");
    }

    else{
        JOptionPane.showMessageDialog(null, "No posee un vehiculo asociado.\n Registre un vehiculo");
    }
    }
    //EDITAR TRANSPORTISTA
    else{
    if(tblVehiculo.getRowCount()!=0){
    Iterator ite3 = gestorH.listarClase(Transportista.class).iterator();
    while(ite3.hasNext()){
        Transportista t = (Transportista) ite3.next();
        if(t.getNumeroDocumento().equalsIgnoreCase(txtDocumento.getText())){
        t.setApellido(txtApellido.getText());
        t.setFechaNacimiento(calendarioNacimiento.getText());
        t.setNombre(txtNombres.getText());
        t.setNumeroDocumento(txtDocumento.getText());
        t.setCondicionContratacion((CondicionContratacion)cmbTipoContratacion.getSelectedItem());
        t.setCuil(txtCUIL.getText());
        t.setEstadoCivil((String)cmbEstadoCivil.getSelectedItem());
        t.setFechaIngreso(calendarioNacimiento.getText());
        t.setFechaSalida(calendarioFin.getText());
        t.setTipoDocumento((TipoDocumento)cmbTipoDoc.getSelectedItem());
        Domicilio domicilio = gProductor.guardarDomicilio(cmbBarrio.getSelectedItem().toString(), txtCalle.getText(),txtDepto.getText(), txtNumero.getText(), txtPiso.getText());
        gestorH.guardarObjeto(domicilio);
        t.setDomicilio(domicilio);
        gestorH.actualizarObjeto(t);
        DefaultTableModel modeloT = (DefaultTableModel) tblVehiculo.getModel();
        for (int i =0; i<tblVehiculo.getRowCount(); i++){
        Iterator ite4 = gestorH.listarClase(Vehiculo.class).iterator();
        while(ite4.hasNext()){
            Vehiculo v = (Vehiculo) ite4.next();
            if(v.getDominio().equalsIgnoreCase(((String) modeloT.getValueAt(i, 0)))){
            v.setTransportista(t);
        }
        }
       }       
    }
        
    }
    }

    else{
        JOptionPane.showMessageDialog(null, "No posee un vehiculo asociado.\n Registre un vehiculo");
    }  
    
    }
    } 
   
}//GEN-LAST:event_btnGuardarActionPerformed

private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    int respuesta = JOptionPane.showConfirmDialog(null, "¿Confirma que desea salir?");
    if (respuesta==0){
    dispose();
    }
}//GEN-LAST:event_btnCancelarActionPerformed

private void buttonCamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCamionActionPerformed
     gRegistro.habilitar(txtAnchoCamion, txtDominioCamion, txtKilometros, txtLargoCamion, txtTaraCamion, cmbAnioCamion, cmbMarcaCamion, cmbModeloCamion);
     gRegistro.deshabilitar(txtAnchoAcoplado, txtDominioAcoplado, txtLargoAcplado, txtLargoAcplado, txtSerieAcoplado, cmbAnioAcoplado, cmbEjesAcoplado, cmbMarcaAcoplado);
//     btnAceptarCamion.setVisible(true);
     btnAgregarCamion.setVisible(true);
     btnAgregarCamionAcoplado.setVisible(false);
     btnAgregarAcoplado.setVisible(false);
}//GEN-LAST:event_buttonCamionActionPerformed

private void buttonAcopladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAcopladoActionPerformed
    gRegistro.habilitar(txtAnchoAcoplado, txtDominioAcoplado, txtLargoAcplado, txtTaraAcoplado, txtSerieAcoplado, cmbAnioAcoplado, cmbEjesAcoplado, cmbMarcaAcoplado);
    gRegistro.deshabilitar(txtAnchoCamion, txtDominioCamion, txtKilometros, txtLargoCamion, txtTaraCamion, cmbAnioCamion, cmbMarcaCamion, cmbModeloCamion);
    btnAgregarCamion.setVisible(false);
//    btnAceptarCamion.setVisible(false);
    btnAgregarCamionAcoplado.setVisible(false);
    btnAgregarAcoplado.setVisible(true);
}//GEN-LAST:event_buttonAcopladoActionPerformed

private void buttonCamionAcopladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCamionAcopladoActionPerformed
     gRegistro.habilitar(txtAnchoAcoplado, txtDominioAcoplado, txtLargoAcplado, txtTaraAcoplado, txtSerieAcoplado, cmbAnioAcoplado, cmbEjesAcoplado, cmbMarcaAcoplado);
     gRegistro.habilitar(txtAnchoCamion, txtDominioCamion, txtKilometros, txtLargoCamion, txtTaraCamion, cmbAnioCamion, cmbMarcaCamion, cmbModeloCamion);
     btnAgregarCamion.setVisible(false);
//     btnAceptarCamion.setVisible(false);
     btnAgregarCamionAcoplado.setVisible(true);
     btnAgregarAcoplado.setVisible(false);
}//GEN-LAST:event_buttonCamionAcopladoActionPerformed

private void btnAgregarCamionAcopladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCamionAcopladoActionPerformed
    int campo = gRegistro.campoObligatorioCA(txtAnchoAcoplado, txtAnchoCamion, txtDominioAcoplado, txtDominioCamion, txtLargoAcplado, txtLargoCamion, txtSerieAcoplado, txtTaraAcoplado, txtTaraCamion, txtKilometros);
    if(campo==0){
    DefaultTableModel modeloTabla = (DefaultTableModel) tblVehiculo.getModel();
    GestorHibernate gestorH= new GestorHibernate();
    //NUEVO VEHICULO Y ACOPLADO
    if(editar==false){
   
    Vehiculo vehiculo = new Vehiculo();
    vehiculo.setAncho((Double.parseDouble(txtAnchoCamion.getText())));
    vehiculo.setAnioCompra((AnioCompra)cmbAnioCamion.getSelectedItem());
    vehiculo.setCantidadKms((Double.parseDouble (txtKilometros.getText())));
    vehiculo.setDominio(txtDominioCamion.getText());
    vehiculo.setLargo(Double.parseDouble(txtLargoCamion.getText()));
    vehiculo.setModelo((Modelo)cmbModeloCamion.getSelectedItem());
    vehiculo.setTara(Double.parseDouble(txtTaraCamion.getText()));
    vehiculo.setEstado("Disponible");
    gestorH.guardarObjeto(vehiculo);
    Acoplado acoplado = new Acoplado();
    acoplado.setAncho(Double.parseDouble(txtAnchoAcoplado.getText()));
    acoplado.setAnioCompra((AnioCompra)cmbAnioAcoplado.getSelectedItem());
    acoplado.setDominio(txtDominioAcoplado.getText());
    acoplado.setLargo(Double.parseDouble(txtLargoAcplado.getText()));
    acoplado.setMarca((Marca)cmbMarcaAcoplado.getSelectedItem());
    acoplado.setSerie(txtSerieAcoplado.getText());
    acoplado.setVehiculo(vehiculo);
    gestorH.guardarObjeto(acoplado);
    }
    //EDITAR VEHICULO Y ACOPLADO
    else{
    Vehiculo veh = null;
    Iterator ite = gestorH.listarClase(Vehiculo.class).iterator();
    while(ite.hasNext()){
        Vehiculo v = (Vehiculo) ite.next();
        if(v.getDominio().equalsIgnoreCase(txtDominioCamion.getText())){
            v.setAncho((Double.parseDouble(txtAnchoCamion.getText())));
            v.setAnioCompra((AnioCompra)cmbAnioCamion.getSelectedItem());
            v.setCantidadKms((Double.parseDouble (txtKilometros.getText())));
            v.setDominio(txtDominioCamion.getText());
            v.setLargo(Double.parseDouble(txtLargoCamion.getText()));
            v.setModelo((Modelo)cmbModeloCamion.getSelectedItem());
            v.setTara(Double.parseDouble(txtTaraCamion.getText()));
            gestorH.actualizarObjeto(v);
            veh = v;
        }
    }
    Iterator ite2 = gestorH.listarClase(Acoplado.class).iterator();
    while(ite2.hasNext()){
        Acoplado ac = (Acoplado) ite2.next();
        if(ac.getDominio().equalsIgnoreCase(txtDominioAcoplado.getText())){
            ac.setAncho(Double.parseDouble(txtAnchoAcoplado.getText()));
            ac.setAnioCompra((AnioCompra)cmbAnioAcoplado.getSelectedItem());
            ac.setDominio(txtDominioAcoplado.getText());
            ac.setLargo(Double.parseDouble(txtLargoAcplado.getText()));
            ac.setMarca((Marca)cmbMarcaAcoplado.getSelectedItem());
            ac.setSerie(txtSerieAcoplado.getText());
            ac.setVehiculo(veh);
            gestorH.actualizarObjeto(ac);
        
        }
    }    
    }
    Object fila[]= {txtDominioCamion.getText(), cmbMarcaCamion.getSelectedItem(), cmbModeloCamion.getSelectedItem(), txtDominioAcoplado.getText(), txtSerieAcoplado.getText()};
    modeloTabla.addRow(fila);
    tblVehiculo.setModel(modeloTabla);
    txtTaraCamion.setText("");
    txtAnchoCamion.setText("");
    txtDominioCamion.setText("");
    txtKilometros.setText("");
    txtLargoCamion.setText("");
    txtAnchoAcoplado.setText("");
    txtDominioAcoplado.setText("");
    txtSerieAcoplado.setText("");
    txtLargoAcplado.setText("");
    txtTaraAcoplado.setText("");
    }
//    btnAceptarCamion.setEnabled(true);
}//GEN-LAST:event_btnAgregarCamionAcopladoActionPerformed

private void btnEditarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarVehiculoActionPerformed
    DefaultTableModel modeloTabla = (DefaultTableModel) tblVehiculo.getModel();
    int fila= tblVehiculo.getSelectedRow();
    Vehiculo v= gRegistro.editar((String) modeloTabla.getValueAt(fila, 0));
    txtAnchoCamion.setText(String.valueOf(v.getAncho()));
    txtDominioCamion.setText(v.getDominio());
    txtKilometros.setText(String.valueOf(v.getCantidadKms()));
    txtLargoCamion.setText(String.valueOf(v.getLargo()));
    txtTaraCamion.setText(String.valueOf(v.getTara()));
    cmbAnioCamion.setSelectedItem(v.getAnioCompra());
    cmbModeloCamion.setSelectedItem(v.getModelo());
    Modelo mod= v.getModelo();
    Marca marca = mod.getMarca();
    cmbMarcaCamion.setSelectedItem(marca);
    modeloTabla.removeRow(tblVehiculo.getSelectedRow());
    Iterator ite = gestorH.listarClase(Acoplado.class).iterator();
    while(ite.hasNext()){
        Acoplado a = (Acoplado) ite.next();
        if(a.getVehiculo().getDominio().equalsIgnoreCase(v.getDominio())){
            cmbMarcaAcoplado.setSelectedItem(a.getMarca());
            cmbEjesAcoplado.setSelectedItem(a.getEjes());
            cmbAnioAcoplado.setSelectedItem(a.getAnioCompra());
            txtDominioAcoplado.setText(a.getDominio());
            txtTaraAcoplado.setText(String.valueOf(a.getTara()));
            txtSerieAcoplado.setText(a.getSerie());
            txtLargoAcplado.setText(String.valueOf(a.getLargo()));
            txtAnchoAcoplado.setText(String.valueOf(a.getAncho()));
        }
    }
}//GEN-LAST:event_btnEditarVehiculoActionPerformed

private void btnBuscarTransportistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTransportistaActionPerformed
       panelDatosP.setVisible(false);
       panelTabla.setVisible(true);
       jScrollPane4.setVisible(true);
       tblModificaT.setVisible(true);
       for(int i=0;i<panelContratacion.getComponents().length;i++){
           panelContratacion.getComponent(i).setEnabled(false);
       }
       for(int i=0;i<panelDatosU.getComponents().length;i++){
           panelDatosU.getComponent(i).setEnabled(false);
       }
       for(int i=0;i<panelBotonesI.getComponents().length;i++){
           panelBotonesI.getComponent(i).setEnabled(false);
       }
       for(int i=0;i<panelBotonesD.getComponents().length;i++){
           panelBotonesD.getComponent(i).setEnabled(false);
       }
       DefaultTableModel modeloT = (DefaultTableModel) tblModificaT.getModel();
       Iterator ite = gestorH.listarClase(Vehiculo.class).iterator();
       while(ite.hasNext()){
           Vehiculo v = (Vehiculo) ite.next();
           Object fila[]= {v.getTransportista().getNumeroDocumento(), v.getTransportista().getApellido() +" " +  v.getTransportista().getNombre(), v.getModelo(),v.getDominio()};
           modeloT.addRow(fila);
           tblModificaT.setModel(modeloT);       
       }
       btnNuevo.setEnabled(false);
}//GEN-LAST:event_btnBuscarTransportistaActionPerformed

private void btnAgregarAcopladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAcopladoActionPerformed
    int campo = gRegistro.campoObligatorioCOA(txtAnchoAcoplado, txtDominioAcoplado, txtLargoAcplado, txtSerieAcoplado, txtTaraAcoplado);
    int bandera = 0;
    if(campo==0){
    DefaultTableModel modeloTabla = (DefaultTableModel) tblVehiculo.getModel();
    GestorHibernate gestorH = new GestorHibernate();
    //ACOPLADO NUEVO
    Iterator ite = gestorH.listarClase(Acoplado.class).iterator();
    while(ite.hasNext()){
        Acoplado a = (Acoplado) ite.next();
        if(a.getDominio().equalsIgnoreCase(txtDominioAcoplado.getText())){
            bandera=1;
        }
    }
    //ACOPLADO NUEVO
    if(bandera == 0){
    Vehiculo vehiculo = gRegistro.editar(txtDominioCamion.getText());
    Acoplado acoplado = new Acoplado();
    acoplado.setAncho(Double.parseDouble(txtAnchoAcoplado.getText()));
    acoplado.setAnioCompra((AnioCompra)cmbAnioAcoplado.getSelectedItem());
    acoplado.setDominio(txtDominioAcoplado.getText());
    acoplado.setLargo(Double.parseDouble(txtLargoAcplado.getText()));
    acoplado.setMarca((Marca)cmbMarcaAcoplado.getSelectedItem());
    acoplado.setVehiculo(vehiculo);
    acoplado.setSerie(txtSerieAcoplado.getText());
    gestorH.guardarObjeto(acoplado);
    }
    
    //ACOPLADO MODIFICADO
    else{
    Vehiculo vehiculo = gRegistro.editar(txtDominioCamion.getText());
    Iterator ite1 = gestorH.listarClase(Acoplado.class).iterator();
    while(ite1.hasNext()){
        Acoplado ac = (Acoplado) ite1.next();
        if(ac.getDominio().equalsIgnoreCase(txtDominioAcoplado.getText())){
            ac.setAncho(Double.parseDouble(txtAnchoAcoplado.getText()));
            ac.setAnioCompra((AnioCompra)cmbAnioAcoplado.getSelectedItem());
            ac.setDominio(txtDominioAcoplado.getText());
            ac.setLargo(Double.parseDouble(txtLargoAcplado.getText()));
            ac.setMarca((Marca)cmbMarcaAcoplado.getSelectedItem());
            ac.setVehiculo(vehiculo);
            ac.setSerie(txtSerieAcoplado.getText());
            gestorH.actualizarObjeto(ac);
        }
    }
    
    }

    Object fila[]= {txtDominioCamion.getText(), cmbMarcaCamion.getSelectedItem(), cmbModeloCamion.getSelectedItem(), txtDominioAcoplado.getText(), txtSerieAcoplado.getText()};
    modeloTabla.addRow(fila);
    tblVehiculo.setModel(modeloTabla);
    txtTaraCamion.setText("");
    txtAnchoCamion.setText("");
    txtDominioCamion.setText("");
    txtKilometros.setText("");
    txtLargoCamion.setText("");
    txtAnchoAcoplado.setText("");
    txtDominioAcoplado.setText("");
    txtSerieAcoplado.setText("");
    txtLargoAcplado.setText("");
    txtTaraAcoplado.setText("");
//    btnAceptarCamion.setEnabled(true);
    
    }
}//GEN-LAST:event_btnAgregarAcopladoActionPerformed

private void btnAgregarCamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCamionActionPerformed
    int campo = gRegistro.campoObligatorioCOA(txtAnchoCamion, txtDominioCamion, txtKilometros, txtLargoCamion, txtTaraCamion);
    if(campo==0){
    DefaultTableModel modeloTabla = (DefaultTableModel) tblVehiculo.getModel();
    GestorHibernate gestorH = new GestorHibernate();
    //NUEVO VEHICULO
    if(editar==false){
   
    Vehiculo vehiculo = new Vehiculo();
    vehiculo.setAncho((Double.parseDouble(txtAnchoCamion.getText())));
    vehiculo.setAnioCompra((AnioCompra)cmbAnioCamion.getSelectedItem());
    vehiculo.setCantidadKms((Double.parseDouble (txtKilometros.getText())));
    vehiculo.setDominio(txtDominioCamion.getText());
    vehiculo.setLargo(Double.parseDouble(txtLargoCamion.getText()));
    vehiculo.setModelo((Modelo)cmbModeloCamion.getSelectedItem());
    vehiculo.setTara(Double.parseDouble(txtTaraCamion.getText()));
    vehiculo.setEstado("Disponible");
    gestorH.guardarObjeto(vehiculo);
      }
    //VEHICULO EDITADO
    else{
    Iterator ite = gestorH.listarClase(Vehiculo.class).iterator();
    while(ite.hasNext()){
        Vehiculo v = (Vehiculo) ite.next();
        if(v.getDominio().equalsIgnoreCase(txtDominioCamion.getText())){
             v.setAncho((Double.parseDouble(txtAnchoCamion.getText())));
             v.setAnioCompra((AnioCompra)cmbAnioCamion.getSelectedItem());
             v.setCantidadKms((Double.parseDouble (txtKilometros.getText())));
             v.setDominio(txtDominioCamion.getText());
             v.setLargo(Double.parseDouble(txtLargoCamion.getText()));
             v.setModelo((Modelo)cmbModeloCamion.getSelectedItem());
             v.setTara(Double.parseDouble(txtTaraCamion.getText()));
             gestorH.actualizarObjeto(v);
        }
    }
      
     } 
    
    Object fila[]= {txtDominioCamion.getText(), cmbMarcaCamion.getSelectedItem(), cmbModeloCamion.getSelectedItem(), "No posee", "No posee"};
    modeloTabla.addRow(fila);
    tblVehiculo.setModel(modeloTabla);
    txtTaraCamion.setText("");
    txtAnchoCamion.setText("");
    txtDominioCamion.setText("");
    txtKilometros.setText("");
    txtLargoCamion.setText("");
//    btnAceptarCamion.setEnabled(true);
    
    }
}//GEN-LAST:event_btnAgregarCamionActionPerformed

private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
    char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
          
        }else{
           evt.consume();
              }
}//GEN-LAST:event_txtApellidoKeyTyped

private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
    char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
          
        }else{
           evt.consume();
              }
}//GEN-LAST:event_txtNombresKeyTyped

private void txtDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyTyped
    char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
}//GEN-LAST:event_txtDocumentoKeyTyped

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

private void txtCalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCalleKeyTyped
    char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
          
        }else{
           evt.consume();
              }
}//GEN-LAST:event_txtCalleKeyTyped

private void txtNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyTyped
    char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
}//GEN-LAST:event_txtNumeroKeyTyped

private void txtPisoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPisoKeyTyped
char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
}//GEN-LAST:event_txtPisoKeyTyped

private void txtCUILKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCUILKeyTyped
    char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '\b' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
}//GEN-LAST:event_txtCUILKeyTyped

    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroActionPerformed

    private void txtKilometrosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKilometrosKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKilometrosKeyTyped

    private void btnAceptarTranspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarTranspActionPerformed
    for(int i=0;i<panelContratacion.getComponents().length;i++){
           panelContratacion.getComponent(i).setEnabled(true);
       }
       for(int i=0;i<panelDatosU.getComponents().length;i++){
           panelDatosU.getComponent(i).setEnabled(true);
       }
       
       for(int i=0;i<panelBotonesI.getComponents().length;i++){
           panelBotonesI.getComponent(i).setEnabled(true);
       }
       for(int i=0;i<panelBotonesD.getComponents().length;i++){
           panelBotonesD.getComponent(i).setEnabled(true);
       }
        
    int bandera = 0;
    DefaultTableModel modeloT = (DefaultTableModel) tblModificaT.getModel();
    DefaultTableModel modeloV = (DefaultTableModel) tblVehiculo.getModel();
       int fila = tblModificaT.getSelectedRow();
       Iterator ite = gestorH.listarClase(Vehiculo.class).iterator();
       while(ite.hasNext()){
           Vehiculo e = (Vehiculo) ite.next();
           if(e.getDominio().equalsIgnoreCase(modeloT.getValueAt(fila,3).toString())){
               txtApellido.setText(e.getTransportista().getApellido());
               txtNombres.setText(e.getTransportista().getNombre());
               txtDocumento.setText(e.getTransportista().getNumeroDocumento());
               cmbEstadoCivil.setSelectedItem(e.getTransportista().getEstadoCivil());
               txtCalle.setText(e.getTransportista().getDomicilio().getCalle());
               txtNumero.setText(String.valueOf(e.getTransportista().getDomicilio().getNumero()));
               cmbBarrio.setSelectedItem(e.getTransportista().getDomicilio().getBarrio());
               cmbLocalidad.setSelectedItem(e.getTransportista().getDomicilio().getBarrio().getLocalidad());
               cmbDepto.setSelectedItem(e.getTransportista().getDomicilio().getBarrio().getLocalidad().getDepartamento());
               cmbProvincia.setSelectedItem(e.getTransportista().getDomicilio().getBarrio().getLocalidad().getDepartamento().getProvincia());
               cmbTipoContratacion.setSelectedItem(e.getTransportista().getCondicionContratacion().toString());
               txtCUIL.setText(e.getTransportista().getCuil());
               calendarioIngreso.setText(e.getTransportista().getFechaIngreso());
               calendarioFin.setText(e.getTransportista().getFechaSalida());
               calendarioNacimiento.setText(e.getTransportista().getFechaNacimiento());
               Iterator ite1 = gestorH.listarClase(Acoplado.class).iterator();
               while(ite1.hasNext()){
                   Acoplado a = (Acoplado) ite1.next();
                   if(a.getVehiculo().getDominio().equalsIgnoreCase(e.getDominio())){
                       Object fila1[] = {e.getDominio(),e.getModelo().getMarca(),e.getModelo(),a.getDominio(),a.getSerie()};
                       modeloV.addRow(fila1);
                       tblVehiculo.setModel(modeloV);
                       bandera=1;
                   }
               }
               if(bandera==0){
               Object filatable[]={e.getDominio(), e.getModelo().getMarca(), e.getModelo(), "NO POSEE", "NO POSEE"};
               modeloV.addRow(filatable);
               tblVehiculo.setModel(modeloV);
               }
               
           }
          
       }
       editar=true;
       btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnAceptarTranspActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        for(int i=0;i<panelContratacion.getComponents().length;i++){
           panelContratacion.getComponent(i).setEnabled(true);
         }
        
        for(int i=0;i<panelDatosU.getComponents().length;i++){
           panelDatosU.getComponent(i).setEnabled(true);
         }
        
        for(int i=0;i<panelDatosP.getComponents().length;i++){
           panelDatosP.getComponent(i).setEnabled(true);
         }
        
        for(int i=0;i<panelBotonesI.getComponents().length;i++){
           panelBotonesI.getComponent(i).setEnabled(true);
       }
       for(int i=0;i<panelBotonesD.getComponents().length;i++){
           panelBotonesD.getComponent(i).setEnabled(true);
       }
        btnGuardar.setEnabled(true);
        btnEmitirFicha.setEnabled(true);
       
    }//GEN-LAST:event_btnNuevoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarTransp;
    private javax.swing.JButton btnAgregarAcoplado;
    private javax.swing.JButton btnAgregarBarrio;
    private javax.swing.JButton btnAgregarCamion;
    private javax.swing.JButton btnAgregarCamionAcoplado;
    private javax.swing.JButton btnAgregarDepartamento;
    private javax.swing.JButton btnAgregarLocalidad;
    private javax.swing.JButton btnAgregarPais;
    private javax.swing.JButton btnAgregarProvincia;
    private javax.swing.JButton btnBuscarTransportista;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditarVehiculo;
    private javax.swing.JButton btnEliminarVehiculo;
    private javax.swing.JButton btnEmitirFicha;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JRadioButton buttonAcoplado;
    private javax.swing.JRadioButton buttonCamion;
    private javax.swing.JRadioButton buttonCamionAcoplado;
    private datechooser.beans.DateChooserCombo calendarioFin;
    private datechooser.beans.DateChooserCombo calendarioIngreso;
    private datechooser.beans.DateChooserCombo calendarioNacimiento;
    private javax.swing.JComboBox cmbAnioAcoplado;
    private javax.swing.JComboBox cmbAnioCamion;
    private javax.swing.JComboBox cmbBarrio;
    private javax.swing.JComboBox cmbDepto;
    private javax.swing.JComboBox cmbEjesAcoplado;
    private javax.swing.JComboBox cmbEstadoCivil;
    private javax.swing.JComboBox cmbLocalidad;
    private javax.swing.JComboBox cmbMarcaAcoplado;
    private javax.swing.JComboBox cmbMarcaCamion;
    private javax.swing.JComboBox cmbModeloCamion;
    private javax.swing.JComboBox cmbPais;
    private javax.swing.JComboBox cmbProvincia;
    private javax.swing.JComboBox cmbTipoContratacion;
    private javax.swing.JComboBox cmbTipoDoc;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelusuario;
    private javax.swing.JPanel panelAcoplado;
    private javax.swing.JPanel panelBotonesD;
    private javax.swing.JPanel panelBotonesI;
    private javax.swing.JPanel panelCamion1;
    private javax.swing.JPanel panelContratacion;
    private javax.swing.JPanel panelDatosP;
    private javax.swing.JPanel panelDatosU;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JPanel panelTransportista;
    private javax.swing.JPanel panelVehiculo;
    private javax.swing.JTable tblModificaT;
    private javax.swing.JScrollPane tblPrueba;
    private javax.swing.JTable tblVehiculo;
    private javax.swing.JTextField txtAnchoAcoplado;
    private javax.swing.JTextField txtAnchoCamion;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCUIL;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtDepto;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtDominioAcoplado;
    private javax.swing.JTextField txtDominioCamion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtKilometros;
    private javax.swing.JTextField txtLargoAcplado;
    private javax.swing.JTextField txtLargoCamion;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPiso;
    private javax.swing.JTextField txtSerieAcoplado;
    private javax.swing.JTextField txtTaraAcoplado;
    private javax.swing.JTextField txtTaraCamion;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
