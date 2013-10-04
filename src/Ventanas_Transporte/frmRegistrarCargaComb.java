/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas_Transporte;

import Clases_Modulo_Transporte.*;
import Gestores_Clases.gestorBitacora;
import Gestores_Vista.gestorRegistrarCargaComb;
import Gestores_Vista.gestorRegistrarTaller;
import Hibernate.GestorHibernate;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carolina
 */
public class frmRegistrarCargaComb extends javax.swing.JInternalFrame {
gestorRegistrarCargaComb gRegistro = new gestorRegistrarCargaComb();
GestorHibernate gestorH = new GestorHibernate();
gestorRegistrarTaller gTaller = new gestorRegistrarTaller();
Double total;
    /**
     * Creates new form frmRegistrarCargaComb
     */
    public frmRegistrarCargaComb() {
        initComponents();
        gestorH.actualizarUsuario(labelusuario);
        
        labelUnidades.setVisible(true);
        labelPrecioU.setVisible(true);
        labelLitros.setVisible(false);
        labelPrecioLitro.setVisible(false);
        
        txtFecha.setEditable(false);
        txtFecha.setEnabled(false);
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
        tblDetalleCarga.getColumnModel().getColumn(0).setPreferredWidth(40);
        tblDetalleCarga.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblDetalleCarga.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblDetalleCarga.getColumnModel().getColumn(3).setPreferredWidth(80);
        tblDetalleCarga.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblDetalleCarga.getColumnModel().getColumn(5).setPreferredWidth(50);
        //centrar cabecera jtable
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tblDetalleCarga.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(0);

        
        //borrar el icono del InternalFrame
        this.setFrameIcon(new ImageIcon("Imagenes/Aceptar.png"));
    
        //Las siguientes lineas son para dar a la pantalla el tamaño requerido y luego centrarla en la pantalla.
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = kit.getScreenSize();
        int ancho = 810;
        int alto = 540;
        int posX = (int) ((tamanioPantalla.width - ancho) / 2);
//        int posY = (int) ((tamanioPantalla.height - alto) / 2);
        this.setSize(ancho, alto);
        this.setLocation(posX, 30);
        
         cmbOrden.setModel(gRegistro.rellenaComboOrdenServicio());
         cmbProducto.setModel(gRegistro.rellenaComboProducto());
        
          cmbOrden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
            txtFechaEmision.setText(gRegistro.rellenaTxtFecha(cmbOrden.getSelectedItem().toString()));
        }
        }
        );
        txtFechaEmision.setText(gRegistro.rellenaTxtFecha(cmbOrden.getSelectedItem().toString()));
        
        cmbOrden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
            txtEstacion.setText(gRegistro.rellenaTxtEstacion((OrdenServicio)cmbOrden.getSelectedItem()));
        }
        }
        );
        txtEstacion.setText(gRegistro.rellenaTxtEstacion((OrdenServicio)cmbOrden.getSelectedItem()));
        
        cmbOrden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0){
            txtOperacion.setText(gRegistro.rellenaTxtOperacion((OrdenServicio)cmbOrden.getSelectedItem()));
            
            if(txtOperacion.getText().equalsIgnoreCase("Carga de Combustible")){
            labelLitros.setVisible(true);
            labelPrecioLitro.setVisible(true);
            labelUnidades.setVisible(false);
            labelPrecioU.setVisible(false);
                    
       }else{
            labelLitros.setVisible(false);
            labelPrecioLitro.setVisible(false);
            labelUnidades.setVisible(true);
            labelPrecioU.setVisible(true);
       }
            
            
            
            
        }
        }
        );
            txtOperacion.setText(gRegistro.rellenaTxtOperacion((OrdenServicio)cmbOrden.getSelectedItem()));
            
       DefaultTableModel modeloT = (DefaultTableModel) tblDetalleCarga.getModel();
       
  
       
       
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
        txtFecha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        labelusuario = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmbOrden = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtFechaEmision = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtOperacion = new javax.swing.JTextField();
        txtEstacion = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        calendarioFU = new datechooser.beans.DateChooserCombo();
        jLabel16 = new javax.swing.JLabel();
        cmbProducto = new javax.swing.JComboBox();
        labelLitros = new javax.swing.JLabel();
        txtLitrosCargados = new javax.swing.JTextField();
        labelPrecioLitro = new javax.swing.JLabel();
        txtPrecioLitro = new javax.swing.JTextField();
        labelmporte = new javax.swing.JLabel();
        txtImporteTotal = new javax.swing.JTextField();
        labelUnidades = new javax.swing.JLabel();
        labelPrecioU = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtNumComprobante = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtResponsable = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalleCarga = new javax.swing.JTable();
        btnEliminarDetalle = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnGuardar1 = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Carga de Combustible");

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Fecha");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 20, 50, 20);

        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        jPanel1.add(txtFecha);
        txtFecha.setBounds(70, 20, 80, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Hora");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(190, 20, 58, 20);
        jPanel1.add(txtHora);
        txtHora.setBounds(230, 20, 80, 20);

        labelusuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelusuario.setText("Carolina");
        jPanel1.add(labelusuario);
        labelusuario.setBounds(640, 20, 50, 15);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/UsuarioLogueado.png"))); // NOI18N
        jPanel1.add(jLabel13);
        jLabel13.setBounds(690, 10, 30, 30);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Orden", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        jPanel2.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Orden Nº");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(70, 20, 60, 20);

        jPanel2.add(cmbOrden);
        cmbOrden.setBounds(130, 20, 120, 20);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Fecha  Emisión");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(420, 20, 100, 20);
        jPanel2.add(txtFechaEmision);
        txtFechaEmision.setBounds(510, 20, 100, 20);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Estación de Servicio");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 50, 140, 20);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Operación");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(450, 50, 60, 20);
        jPanel2.add(txtOperacion);
        txtOperacion.setBounds(510, 50, 150, 20);
        jPanel2.add(txtEstacion);
        txtEstacion.setBounds(130, 50, 260, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(40, 50, 690, 90);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Carga", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        jPanel3.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Fecha Utilización");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(30, 30, 130, 20);
        jPanel3.add(calendarioFU);
        calendarioFU.setBounds(130, 30, 100, 20);

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setText("Producto");
        jPanel3.add(jLabel16);
        jLabel16.setBounds(330, 30, 110, 20);

        jPanel3.add(cmbProducto);
        cmbProducto.setBounds(390, 30, 260, 20);

        labelLitros.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelLitros.setText("Litros cargados");
        jPanel3.add(labelLitros);
        labelLitros.setBounds(40, 60, 110, 20);

        txtLitrosCargados.setText("0");
        txtLitrosCargados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLitrosCargadosActionPerformed(evt);
            }
        });
        txtLitrosCargados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLitrosCargadosKeyReleased(evt);
            }
        });
        jPanel3.add(txtLitrosCargados);
        txtLitrosCargados.setBounds(130, 60, 100, 20);

        labelPrecioLitro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelPrecioLitro.setText("Precio por litro:  $");
        jPanel3.add(labelPrecioLitro);
        labelPrecioLitro.setBounds(250, 60, 120, 20);

        txtPrecioLitro.setText("0");
        txtPrecioLitro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioLitroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioLitroKeyTyped(evt);
            }
        });
        jPanel3.add(txtPrecioLitro);
        txtPrecioLitro.setBounds(350, 60, 100, 20);

        labelmporte.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelmporte.setText("Importe Total: $ ");
        jPanel3.add(labelmporte);
        labelmporte.setBounds(490, 60, 110, 20);

        txtImporteTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtImporteTotalKeyTyped(evt);
            }
        });
        jPanel3.add(txtImporteTotal);
        txtImporteTotal.setBounds(580, 60, 100, 20);

        labelUnidades.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelUnidades.setText("Unidades");
        jPanel3.add(labelUnidades);
        labelUnidades.setBounds(60, 60, 80, 20);

        labelPrecioU.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        labelPrecioU.setText("Precio Unitario:  $");
        jPanel3.add(labelPrecioU);
        labelPrecioU.setBounds(250, 60, 120, 20);

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("N° de Comprobante de Venta");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(20, 100, 190, 20);

        txtNumComprobante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumComprobanteKeyTyped(evt);
            }
        });
        jPanel3.add(txtNumComprobante);
        txtNumComprobante.setBounds(190, 100, 100, 20);

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("Responsable de Venta");
        jPanel3.add(jLabel18);
        jLabel18.setBounds(350, 100, 160, 20);

        txtResponsable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtResponsableKeyTyped(evt);
            }
        });
        jPanel3.add(txtResponsable);
        txtResponsable.setBounds(480, 100, 200, 20);

        btnAgregar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel3.add(btnAgregar);
        btnAgregar.setBounds(300, 140, 110, 30);

        tblDetalleCarga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha ", "Orden N°", "Comprobante N°", "Operación", "Producto", "Importe Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetalleCarga.getTableHeader().setResizingAllowed(false);
        tblDetalleCarga.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblDetalleCarga);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(40, 180, 660, 110);

        btnEliminarDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        btnEliminarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDetalleActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminarDetalle);
        btnEliminarDetalle.setBounds(710, 220, 47, 30);

        txtTotal.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        jPanel3.add(txtTotal);
        txtTotal.setBounds(590, 290, 110, 20);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel7.setText("TOTAL  $");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(530, 290, 70, 20);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 140, 770, 330);

        btnNuevo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icononuevo.PNG"))); // NOI18N
        btnNuevo.setText("Nuevo");

        btnSalir.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnGuardar1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnGuardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.png"))); // NOI18N
        btnGuardar1.setText("Guardar");
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(220, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtPrecioLitroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioLitroKeyTyped
        char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '\b' /*
                 * corresponde a BACK_SPACE
                 */)) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_txtPrecioLitroKeyTyped

    private void txtImporteTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImporteTotalKeyTyped
        char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '\b' /*
                 * corresponde a BACK_SPACE
                 */)) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_txtImporteTotalKeyTyped

    private void txtNumComprobanteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumComprobanteKeyTyped
        char caracter = evt.getKeyChar();

        // Verificar si la tecla pulsada no es un digito
        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '\b' /*
                 * corresponde a BACK_SPACE
                 */)) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_txtNumComprobanteKeyTyped

    private void txtResponsableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtResponsableKeyTyped

        char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtResponsableKeyTyped

    private void btnEliminarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDetalleActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarDetalleActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    int respuesta = JOptionPane.showConfirmDialog(null, "¿Confirma que desea salir?");
    if (respuesta==0){
    dispose();
    }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
      DefaultTableModel modeloT = (DefaultTableModel) tblDetalleCarga.getModel();
      int campo = gTaller.campoObligatorio(txtLitrosCargados, txtPrecioLitro, txtNumComprobante, txtPrecioLitro, txtPrecioLitro);
      if(campo==0){
      Object fila []= {calendarioFU.getText(),cmbOrden.getSelectedItem(),txtNumComprobante.getText(),txtOperacion.getText(),cmbProducto.getSelectedItem(),txtImporteTotal.getText()};
      modeloT.addRow(fila);
      tblDetalleCarga.setModel(modeloT);
      for(int i=0; i<modeloT.getRowCount(); i++){
           total = total + (Double.parseDouble(modeloT.getValueAt(i,4).toString()));
           txtTotal.setText(total.toString());
       }
      txtLitrosCargados.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
      txtPrecioLitro.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
      txtResponsable.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
      txtNumComprobante.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
      }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtPrecioLitroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioLitroKeyReleased
      txtImporteTotal.setText(String.valueOf(Double.parseDouble(txtLitrosCargados.getText()) * Double.parseDouble(txtPrecioLitro.getText())));
    }//GEN-LAST:event_txtPrecioLitroKeyReleased

    private void txtLitrosCargadosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLitrosCargadosKeyReleased
      txtImporteTotal.setText(String.valueOf(Double.parseDouble(txtLitrosCargados.getText()) * Double.parseDouble(txtPrecioLitro.getText())));
    }//GEN-LAST:event_txtLitrosCargadosKeyReleased

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
     DefaultTableModel modelo = (DefaultTableModel) tblDetalleCarga.getModel();
     CargaCombustible carga= new CargaCombustible();
      carga.setFecha(modelo.getValueAt(0,0).toString());
      carga.setImporteTotal(Double.parseDouble(txtImporteTotal.getText()));
      carga.setOrdenServicio((OrdenServicio)cmbOrden.getSelectedItem());
      carga.setResponsableVenta(txtResponsable.getText());
      carga.setTipoOperacion(txtOperacion.getText());
      gestorH.guardarObjeto(carga);
      for(int i=0; i<modelo.getRowCount(); i++){
            DetalleCarga detalle = new DetalleCarga();
            detalle.setImporteTotal(Double.parseDouble(modelo.getValueAt(i,5).toString()));
            Iterator ite = gestorH.listarClase(TipoCombustible.class).iterator();
            while(ite.hasNext()){
                TipoCombustible tipo = (TipoCombustible) ite.next();
                if(tipo.getNombreTipoCombustible() == modelo.getValueAt(i, 4)){
                    detalle.setTipoCombustible(tipo);
                }
            }
            
            detalle.setCargaCombustible(carga);
            gestorH.guardarObjeto(detalle);
      }
      gestorBitacora gestorB = new gestorBitacora();
      gestorB.cargarBitacora(String.valueOf(carga.getIdCargaCombustible()), txtFecha.getText(), 8, labelusuario.getText(),"");
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void txtLitrosCargadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLitrosCargadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLitrosCargadosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminarDetalle;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private datechooser.beans.DateChooserCombo calendarioFU;
    private javax.swing.JComboBox cmbOrden;
    private javax.swing.JComboBox cmbProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelLitros;
    private javax.swing.JLabel labelPrecioLitro;
    private javax.swing.JLabel labelPrecioU;
    private javax.swing.JLabel labelUnidades;
    private javax.swing.JLabel labelmporte;
    private javax.swing.JLabel labelusuario;
    private javax.swing.JTable tblDetalleCarga;
    private javax.swing.JTextField txtEstacion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFechaEmision;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtImporteTotal;
    private javax.swing.JTextField txtLitrosCargados;
    private javax.swing.JTextField txtNumComprobante;
    private javax.swing.JTextField txtOperacion;
    private javax.swing.JTextField txtPrecioLitro;
    private javax.swing.JTextField txtResponsable;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
