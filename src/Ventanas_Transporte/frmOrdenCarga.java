/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/

/*
* frmOrdenCarga.java
*
* Created on 25/09/2011, 11:57:56
*/
package Ventanas_Transporte;


import Clases_Modulo_Transporte.*;
import Gestores_Clases.gestorBitacora;
import Gestores_Vista.gestorRegistrarOrden;
import Hibernate.GestorHibernate;
import javax.swing.UIManager;
import de.javasoft.plaf.synthetica.SyntheticaGreenDreamLookAndFeel;
import ireport.GestorDeReportes;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class frmOrdenCarga extends javax.swing.JInternalFrame {
gestorRegistrarOrden gestorO = new gestorRegistrarOrden();
GestorHibernate gestorH = new GestorHibernate();
    /** Creates new form frmOrdenCarga */
    public frmOrdenCarga() {
        initComponents();
        gestorH.actualizarUsuario(labelUsuario);
        txtFechaCarga.setEditable(false);
        txtFechaCarga.setEnabled(false);
        txtHoraCarga.setEditable(false);
        txtHoraCarga.setEnabled(false);
        //setear el campo de fecha con la del sistema
        GregorianCalendar gc=new GregorianCalendar();
        GregorianCalendar.getInstance();
        gc.setTimeZone(TimeZone.getTimeZone("GMT-3"));
        gc.get(Calendar.DAY_OF_WEEK);
        gc.get(Calendar.MONTH);
        gc.get(Calendar.YEAR);
        SimpleDateFormat formateador= new SimpleDateFormat("dd-MM-yyyy");
        txtFechaCarga.setText(formateador.format(gc.getTime()));
        //setear el campo de hora con la del sistema
        GregorianCalendar calendario=new GregorianCalendar();
        GregorianCalendar.getInstance();
        gc.setTimeZone(TimeZone.getTimeZone("GMT-3"));
        calendario.get(Calendar.HOUR);
        calendario.get(Calendar.MINUTE);
        SimpleDateFormat formateadorHora=new SimpleDateFormat("HH:mm");
        txtHoraCarga.setText(formateadorHora.format(calendario.getTime()));
         
        DefaultTableModel modeloT = (DefaultTableModel) tblTransportista.getModel();
        Iterator ite = gestorH.listarClase(Transportista.class).iterator();
        while(ite.hasNext()){
            Transportista trans = (Transportista) ite.next();
            Object fila[] = {trans, trans.getNumeroDocumento()};
            modeloT.addRow(fila);
            tblTransportista.setModel(modeloT);
        }
        cmbEstacionServicio.setModel(gestorO.rellenaComboEstacion());
        cmbOperacion.setModel(gestorO.rellenaComboTipoOperacion());
        
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
        
        cmbEstacionServicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
            txtProveedor.setText(gestorO.rellenaTxtProveedorCombustible((EstacionDeServicio)cmbEstacionServicio.getSelectedItem()));
        }
        }
        );
        txtProveedor.setText(gestorO.rellenaTxtProveedorCombustible((EstacionDeServicio)cmbEstacionServicio.getSelectedItem()));
        
        cmbEstacionServicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
            txtDomicilio.setText(gestorO.rellenaTxtDomicilioEstacion((EstacionDeServicio)cmbEstacionServicio.getSelectedItem()));
        }
        }
        );
            txtDomicilio.setText(gestorO.rellenaTxtDomicilioEstacion((EstacionDeServicio)cmbEstacionServicio.getSelectedItem()));
        
       cmbEstacionServicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
            txtLocalidad.setText(gestorO.rellenaTxtLocalidadEstacion((EstacionDeServicio)cmbEstacionServicio.getSelectedItem()));
        }
        }
        );
            txtLocalidad.setText(gestorO.rellenaTxtLocalidadEstacion((EstacionDeServicio)cmbEstacionServicio.getSelectedItem()));
            
         cmbEstacionServicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
            txtDeptoEstacion.setText(gestorO.rellenaTxtDepartamentoEstacion((EstacionDeServicio)cmbEstacionServicio.getSelectedItem()));
        }
        }
        );
            txtDeptoEstacion.setText(gestorO.rellenaTxtDepartamentoEstacion((EstacionDeServicio)cmbEstacionServicio.getSelectedItem()));
       
        cmbEstacionServicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
            txtProvincia.setText(gestorO.rellenaTxtProvinciaEstacion((EstacionDeServicio)cmbEstacionServicio.getSelectedItem()));
        }
        }
        );
            txtProvincia.setText(gestorO.rellenaTxtProvinciaEstacion((EstacionDeServicio)cmbEstacionServicio.getSelectedItem()));
            
        //borrar el icono del InternalFrame
        this.setFrameIcon(new ImageIcon("Imagenes/Aceptar.png"));
        
        //redimensionar columnas tabla
        tblTransportista.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblTransportista.getColumnModel().getColumn(1).setPreferredWidth(50);
        //centrar cabecera jtable
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tblTransportista.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(0);

        
    //Las siguientes lineas son para dar a la pantalla el tamaño requerido y luego centrarla en la pantalla.
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = kit.getScreenSize();
        int ancho = 750;
        int alto = 565;
        int posX = (int) ((tamanioPantalla.width - ancho) / 2);
// int posY = (int) ((tamanioPantalla.height - alto) / 2);
        this.setSize(ancho, alto);
        this.setLocation(300, 30);
    
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
        txtFechaCarga = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtHoraCarga = new javax.swing.JTextField();
        labelUsuario = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransportista = new javax.swing.JTable();
        btnAgregarTransportista = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        labelTransportista = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        cmbVehiculo = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        txtAnioCompra = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDominio = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cmbEstacionServicio = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDomicilio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtLocalidad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtDeptoEstacion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtProvincia = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cmbOperacion = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnEmitirOrden = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Orden Carga de Combustible");

        jPanel1.setLayout(null);
        jPanel1.add(txtFechaCarga);
        txtFechaCarga.setBounds(260, 20, 80, 20);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Fecha");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 20, 70, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Hora");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(230, 20, 60, 20);
        jPanel1.add(txtHoraCarga);
        txtHoraCarga.setBounds(60, 20, 80, 20);

        labelUsuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelUsuario.setText("Carolina");
        jPanel1.add(labelUsuario);
        labelUsuario.setBounds(620, 10, 50, 40);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Transportista", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        jPanel2.setLayout(null);

        tblTransportista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transportista", "Número Documento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTransportista.getTableHeader().setResizingAllowed(false);
        tblTransportista.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblTransportista);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(120, 30, 452, 120);

        btnAgregarTransportista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aceptar.png"))); // NOI18N
        btnAgregarTransportista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTransportistaActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregarTransportista);
        btnAgregarTransportista.setBounds(580, 70, 40, 30);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Transportista:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(250, 160, 110, 17);

        labelTransportista.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelTransportista.setText("Jose Torrea");
        jPanel2.add(labelTransportista);
        labelTransportista.setBounds(350, 160, 110, 17);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(40, 190, 600, 10);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Vehículo");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(70, 200, 110, 20);

        jPanel2.add(cmbVehiculo);
        cmbVehiculo.setBounds(130, 200, 200, 20);

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setText("Año de Compra");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(40, 230, 100, 20);
        jPanel2.add(txtAnioCompra);
        txtAnioCompra.setBounds(130, 230, 100, 20);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Dominio");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(410, 200, 60, 20);
        jPanel2.add(txtDominio);
        txtDominio.setBounds(470, 200, 100, 20);
        jPanel2.add(txtEstado);
        txtEstado.setBounds(470, 230, 170, 20);

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("Estado");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(420, 230, 50, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(30, 50, 680, 270);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Proveedor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        jPanel3.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Estación de Servicio");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(10, 30, 130, 20);

        jPanel3.add(cmbEstacionServicio);
        cmbEstacionServicio.setBounds(130, 30, 180, 20);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Proveedor Combustible");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(330, 30, 140, 20);
        jPanel3.add(txtProveedor);
        txtProveedor.setBounds(470, 30, 100, 20);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Dirección");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(70, 60, 70, 20);
        jPanel3.add(txtDomicilio);
        txtDomicilio.setBounds(130, 60, 230, 20);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Localidad");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(410, 60, 60, 20);
        jPanel3.add(txtLocalidad);
        txtLocalidad.setBounds(470, 60, 190, 20);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Departamento");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(40, 90, 100, 20);
        jPanel3.add(txtDeptoEstacion);
        txtDeptoEstacion.setBounds(130, 90, 230, 20);

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Provincia");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(410, 90, 60, 20);
        jPanel3.add(txtProvincia);
        txtProvincia.setBounds(470, 90, 190, 20);

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("Operación");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(60, 120, 60, 20);

        cmbOperacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Carga Combustible", "Compra Insumos" }));
        jPanel3.add(cmbOperacion);
        cmbOperacion.setBounds(130, 120, 180, 20);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(30, 330, 680, 150);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/UsuarioLogueado.png"))); // NOI18N
        jPanel1.add(jLabel13);
        jLabel13.setBounds(670, 10, 30, 30);

        btnSalir.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnEmitirOrden.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnEmitirOrden.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aceptar.png"))); // NOI18N
        btnEmitirOrden.setText("Emitir Orden");
        btnEmitirOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmitirOrdenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(btnEmitirOrden)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEmitirOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    int respuesta = JOptionPane.showConfirmDialog(null, "¿Confirma que desea cancelar la operación?");
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
        DetalleConsumo detalle = new DetalleConsumo();
        CargaCombustible carga = new CargaCombustible();
        Iterator ite = gestorH.listarClase(TipoServicio.class).iterator();
        while(ite.hasNext()){
             TipoServicio tipoSer = (TipoServicio) ite.next();
           if (tipoSer.getIdTipoServicio() == 0) {
               orden.setTipoServicio(tipoSer);
           }
        }
        orden.setFecha(txtFechaCarga.getText());
        orden.setHora(txtHoraCarga.getText());
        orden.setVehiculo((Vehiculo)cmbVehiculo.getSelectedItem());
        orden.setEstado("Pendiente");
        orden.setHabilita("1");
        gestorH.guardarObjeto(orden);
        carga.setEstacionServicio((EstacionDeServicio)cmbEstacionServicio.getSelectedItem());
        carga.setTipo((TipoOperacionEstacionServicio)cmbOperacion.getSelectedItem());
        carga.setOrdenServicio(orden);
        gestorH.guardarObjeto(carga);
        detalle.setCargaCombustible(carga);
        detalle.setOrdenServicio(orden);
        gestorH.guardarObjeto(detalle);
        gestorBitacora gestorB = new gestorBitacora();
        gestorB.cargarBitacora(String.valueOf(orden.getNumeroOrden()), txtHoraCarga.getText(), 6, labelUsuario.getText());
        
        //Prueba Nueva Orden
         String arc="C:/Reportes AgroGIS/NuevaOrdenServicio.jasper";
         GestorDeReportes gestorReportes = new GestorDeReportes(arc);
         gestorReportes.setColeccionDeDatos(gestorH.listarAtributosVarios(orden));
         gestorReportes.imprimir();
    }//GEN-LAST:event_btnEmitirOrdenActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarTransportista;
    private javax.swing.JButton btnEmitirOrden;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cmbEstacionServicio;
    private javax.swing.JComboBox cmbOperacion;
    private javax.swing.JComboBox cmbVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelTransportista;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JTable tblTransportista;
    private javax.swing.JTextField txtAnioCompra;
    private javax.swing.JTextField txtDeptoEstacion;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtDominio;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFechaCarga;
    private javax.swing.JTextField txtHoraCarga;
    private javax.swing.JTextField txtLocalidad;
    private javax.swing.JTextField txtProveedor;
    private javax.swing.JTextField txtProvincia;
    // End of variables declaration//GEN-END:variables
}
