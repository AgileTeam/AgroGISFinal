/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmOrdenTaller.java
 *
 * Created on 25/09/2011, 13:20:44
 */
package Ventanas_Transporte;

import Clases_Modulo_Seguridad.Usuario;
import Clases_Modulo_Transporte.*;
import Gestores_Clases.gestorBitacora;
import Gestores_Vista.gestorRegistrarOrden;
import Hibernate.GestorHibernate;
import ireport.GestorDeReportes;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TimeZone;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Charito
 */

public class frmOrdenTaller extends javax.swing.JInternalFrame {
    GestorHibernate gestorH = new GestorHibernate();
    gestorRegistrarOrden gestorO = new gestorRegistrarOrden();
    /** Creates new form frmOrdenTaller */
    public frmOrdenTaller() {
        initComponents();
    
        gestorH.actualizarUsuario(labelUsuario);
        txtFecha.setEnabled(false);
        txtHora.setEnabled(false);
        txtFecha.setEditable(false);
        txtHora.setEditable(false);
        
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
        
        //redimensionar columnas tabla
        tblTransportista.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblTransportista.getColumnModel().getColumn(1).setPreferredWidth(50);
        //centrar cabecera jtable
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tblTransportista.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(0);

        
        
        
        //borrar el icono del InternalFrame
       this.setFrameIcon(new ImageIcon("Imagenes/Aceptar.png")); 
        
     //Las siguientes lineas son para dar a la pantalla el tamaño requerido y luego centrarla en la pantalla.
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = kit.getScreenSize();
        int ancho = 730;
        int alto = 628;
        int posX = (int) ((tamanioPantalla.width - ancho) / 2);
//        int posY = (int) ((tamanioPantalla.height - alto) / 2);
        this.setSize(ancho, alto);
        this.setLocation(posX, 0);
  

         DefaultTableModel modeloT = (DefaultTableModel) tblTransportista.getModel();
        Iterator ite = gestorH.listarClase(Transportista.class).iterator();
        while(ite.hasNext()){
            Transportista trans = (Transportista) ite.next();
            Object fila[] = {trans, trans.getNumeroDocumento()};
            modeloT.addRow(fila);
            tblTransportista.setModel(modeloT);
        }
        cmbTalleres.setModel(gestorO.rellenaComboTaller());
        cmbMotivo.setModel(gestorO.rellenaComboMotivo());
        
        
        cmbVehiculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
            txtDominio.setText(gestorO.rellenaTxtDominio((Vehiculo)cmbVehiculo.getSelectedItem()));
        }
        }
        );
         txtDominio.setText(gestorO.rellenaTxtDominio((Vehiculo)cmbVehiculo.getSelectedItem()));
         
        cmbVehiculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
            txtAnioCompra.setText(gestorO.rellenaTxtAnio((Vehiculo)cmbVehiculo.getSelectedItem()));
        }
        }
        );
         txtAnioCompra.setText(gestorO.rellenaTxtAnio((Vehiculo)cmbVehiculo.getSelectedItem()));
         
        cmbVehiculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
            txtEstado.setText(gestorO.rellenaTxtEstado((Vehiculo)cmbVehiculo.getSelectedItem()));
        }
        }
        );
        txtEstado.setText(gestorO.rellenaTxtEstado((Vehiculo)cmbVehiculo.getSelectedItem()));
        
        cmbTalleres.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
            txtEspecialidad.setText(gestorO.rellenaTxtEspecialidad((TallerReparacion)cmbTalleres.getSelectedItem()));
        }
        }
        );
        txtEspecialidad.setText(gestorO.rellenaTxtEspecialidad((TallerReparacion)cmbTalleres.getSelectedItem()));
        
         cmbTalleres.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
            txtDomicilio.setText(gestorO.rellenaTxtDomicilio((TallerReparacion)cmbTalleres.getSelectedItem()));
        }
        }
        );
        txtDomicilio.setText(gestorO.rellenaTxtDomicilio((TallerReparacion)cmbTalleres.getSelectedItem()));
        
        cmbTalleres.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
            txtLocalidad.setText(gestorO.rellenaTxtLocalidad((TallerReparacion)cmbTalleres.getSelectedItem()));
        }
        }
        );
        txtLocalidad.setText(gestorO.rellenaTxtLocalidad((TallerReparacion)cmbTalleres.getSelectedItem()));
    
         cmbTalleres.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
            txtDepartamento.setText(gestorO.rellenaTxtDepartamento((TallerReparacion)cmbTalleres.getSelectedItem()));
        }
        }
        );
         txtDepartamento.setText(gestorO.rellenaTxtDepartamento((TallerReparacion)cmbTalleres.getSelectedItem()));
         
         cmbTalleres.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
            txtProvincia.setText(gestorO.rellenaTxtProvincia((TallerReparacion)cmbTalleres.getSelectedItem()));
        }
        }
        );
         txtProvincia.setText(gestorO.rellenaTxtProvincia((TallerReparacion)cmbTalleres.getSelectedItem()));
   
        
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransportista = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDominio = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        cmbVehiculo = new javax.swing.JComboBox();
        btnAgregarTransportista = new javax.swing.JButton();
        labelTransportista = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtAnioCompra = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cmbTalleres = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtEspecialidad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtLocalidad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtDepartamento = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtProvincia = new javax.swing.JTextField();
        txtDomicilio = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaObservaciones = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        cmbMotivo = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnEmitirOrden = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Reparacion");

        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Transportista", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        jPanel2.setLayout(null);

        tblTransportista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transportista", "Número Documento"
            }
        ));
        jScrollPane1.setViewportView(tblTransportista);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(120, 30, 452, 100);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Vehículo");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(70, 180, 90, 20);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Dominio");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(410, 180, 60, 20);
        jPanel2.add(txtDominio);
        txtDominio.setBounds(470, 180, 100, 20);

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setText("Año de Compra");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(40, 210, 100, 20);

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("Estado");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(420, 210, 50, 20);
        jPanel2.add(txtEstado);
        txtEstado.setBounds(470, 210, 170, 20);

        jPanel2.add(cmbVehiculo);
        cmbVehiculo.setBounds(130, 180, 200, 20);

        btnAgregarTransportista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aceptar.png"))); // NOI18N
        btnAgregarTransportista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTransportistaActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregarTransportista);
        btnAgregarTransportista.setBounds(580, 70, 40, 30);

        labelTransportista.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel2.add(labelTransportista);
        labelTransportista.setBounds(350, 140, 230, 20);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Transportista:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(250, 140, 120, 20);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(40, 170, 600, 10);
        jPanel2.add(txtAnioCompra);
        txtAnioCompra.setBounds(130, 210, 100, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 50, 700, 250);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Proveedor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        jPanel3.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Taller de Reparación");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(10, 30, 120, 20);

        cmbTalleres.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "El Guri" }));
        jPanel3.add(cmbTalleres);
        cmbTalleres.setBounds(130, 30, 210, 20);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Especialidad");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(390, 30, 80, 20);
        jPanel3.add(txtEspecialidad);
        txtEspecialidad.setBounds(470, 30, 190, 20);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Domicilio");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(70, 60, 70, 20);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Localidad");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(410, 60, 70, 20);
        jPanel3.add(txtLocalidad);
        txtLocalidad.setBounds(470, 60, 190, 20);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Departamento");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(40, 90, 100, 20);
        jPanel3.add(txtDepartamento);
        txtDepartamento.setBounds(130, 90, 200, 20);

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Provincia");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(410, 90, 80, 20);
        jPanel3.add(txtProvincia);
        txtProvincia.setBounds(470, 90, 190, 20);
        jPanel3.add(txtDomicilio);
        txtDomicilio.setBounds(130, 60, 230, 20);
        jPanel3.add(jSeparator2);
        jSeparator2.setBounds(30, 130, 630, 10);

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("Observaciones");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(40, 190, 90, 15);

        areaObservaciones.setColumns(20);
        areaObservaciones.setRows(3);
        jScrollPane2.setViewportView(areaObservaciones);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(130, 170, 310, 60);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Motivo");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(80, 140, 80, 20);

        jPanel3.add(cmbMotivo);
        cmbMotivo.setBounds(130, 140, 200, 20);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 300, 700, 250);

        jPanel4.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Fecha");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(10, 13, 40, 15);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Hora");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(200, 10, 50, 20);

        labelUsuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelUsuario.setText("Usuario");
        jPanel4.add(labelUsuario);
        labelUsuario.setBounds(600, 10, 50, 20);
        jPanel4.add(txtHora);
        txtHora.setBounds(230, 10, 80, 20);
        jPanel4.add(txtFecha);
        txtFecha.setBounds(50, 10, 80, 20);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/UsuarioLogueado.png"))); // NOI18N
        jPanel4.add(jLabel16);
        jLabel16.setBounds(650, 0, 30, 30);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(10, 10, 700, 40);

        btnEmitirOrden.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnEmitirOrden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aceptar.png"))); // NOI18N
        btnEmitirOrden.setText("Emitir Orden");
        btnEmitirOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirOrdenActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(btnEmitirOrden)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEmitirOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    int respuesta = JOptionPane.showConfirmDialog(null, "¿Confirma que desea salir?");
    if (respuesta==0){
    dispose();
    }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarTransportistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTransportistaActionPerformed
        DefaultTableModel modeloT = (DefaultTableModel) tblTransportista.getModel();
        int fila= tblTransportista.getSelectedRow();
        labelTransportista.setText(modeloT.getValueAt(fila, 0).toString());
        cmbVehiculo.setModel(gestorO.rellenaComboVehiculo((Transportista)modeloT.getValueAt(fila,0)));
    }//GEN-LAST:event_btnAgregarTransportistaActionPerformed

    private void btnEmitirOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmitirOrdenActionPerformed
        OrdenServicio orden = new OrdenServicio();
        DetalleReparacion detalle = new DetalleReparacion();
        EnvioTaller envio = new EnvioTaller();
      
        Iterator ite = gestorH.listarClase(TipoServicio.class).iterator();
        while(ite.hasNext()){
             TipoServicio tipoSer = (TipoServicio) ite.next();
           if (tipoSer.getIdTipoServicio() == 1) {
               orden.setTipoServicio(tipoSer);
           }
        }
        
        
        Iterator iteuser = gestorH.listarClase(Usuario.class).iterator();
        while(iteuser.hasNext()){
             Usuario user = (Usuario) iteuser.next();
           if (user.isEstado() == true) {
               orden.setResponsable(user.getNombreUsuario());
           }
        }
        
        orden.setFecha(txtFecha.getText());
        orden.setHora(txtHora.getText());
        orden.setVehiculo((Vehiculo)cmbVehiculo.getSelectedItem());
        orden.setEstado("Pendiente");
        orden.setMotivo((Motivo)cmbMotivo.getSelectedItem());
        orden.setObservaciones(areaObservaciones.getText());
        orden.setHabilita("1");
        gestorH.guardarObjeto(orden);
        envio.setTaller((TallerReparacion)cmbTalleres.getSelectedItem());
        envio.setOrdenServicio(orden);
        gestorH.guardarObjeto(envio);
//        detalle.setEnvioTaller(envio);
//        detalle.setOrden(orden);
//        gestorH.guardarObjeto(detalle);
        
        gestorBitacora gestorB = new gestorBitacora();
        gestorB.cargarBitacora(String.valueOf(orden.getNumeroOrden()), txtFecha.getText(), 7, labelUsuario.getText(), "Orden Taller");
       
    String arc="C:/Reportes AgroGIS/OrdenServicio.jasper";
    GestorDeReportes gestorReportes = new GestorDeReportes(arc);
    gestorReportes.setColeccionDeDatos(gestorH.listarClaseFitradaPorInteger(OrdenServicio.class,"numeroOrden",orden.getNumeroOrden()));
    gestorReportes.imprimir();
    }//GEN-LAST:event_btnEmitirOrdenActionPerformed
 





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaObservaciones;
    private javax.swing.JButton btnAgregarTransportista;
    private javax.swing.JButton btnEmitirOrden;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cmbMotivo;
    private javax.swing.JComboBox cmbTalleres;
    private javax.swing.JComboBox cmbVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelTransportista;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JTable tblTransportista;
    private javax.swing.JTextField txtAnioCompra;
    private javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtDominio;
    private javax.swing.JTextField txtEspecialidad;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtLocalidad;
    private javax.swing.JTextField txtProvincia;
    // End of variables declaration//GEN-END:variables

}