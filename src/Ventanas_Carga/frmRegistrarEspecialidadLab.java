/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas_Carga;

import Clases_Modulo_Carga.EspecialidadLaboratorio;
import Gestores_Clases.gestorEspecialidadLaboratorio;
import Gestores_Vista.gestorRegistrarUsuario;
import Hibernate.GestorHibernate;
import java.awt.*;
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
public class frmRegistrarEspecialidadLab extends javax.swing.JInternalFrame {
gestorEspecialidadLaboratorio gestorE = new gestorEspecialidadLaboratorio();
GestorHibernate gestorH = new GestorHibernate();
gestorRegistrarUsuario gestoru = new gestorRegistrarUsuario();
long idEspecialidad;
    /**
     * Creates new form frmRegistrarEspecialidadLab
     */
    public frmRegistrarEspecialidadLab() {
        initComponents();
        gestorH.actualizarUsuario(labelusuario);
        txtFecha.setEnabled(false);
        txtFecha.setEditable(false);
        txtHora.setEditable(false);
        txtHora.setEnabled(false);
        txtCodEsp.setEnabled(false);
        txtNombreEsp.setEnabled(false);
        areaDescripcion.setEnabled(false);
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
        tblEspecialidad.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblEspecialidad.getColumnModel().getColumn(1).setPreferredWidth(50);
        
        //centrar cabecera jtable
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tblEspecialidad.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(0);

        
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension tamanioPantalla = kit.getScreenSize();
    int ancho = 550;
    int alto = 500;
//    int posX = (int) ((tamanioPantalla.width - ancho) / 2);
//    int posY = (int) ((tamanioPantalla.height - alto) / 2);
    this.setSize(ancho, alto);
    this.setLocation(340, 60);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        labelusuario = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreEsp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaDescripcion = new javax.swing.JTextArea();
        btnAgregarEsp = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCodEsp = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnAceptarEdicion = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEspecialidad = new javax.swing.JTable();
        btnEliminarPais = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnEditarPais = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Especialidad");

        jPanel3.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Fecha");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(10, 13, 50, 15);
        jPanel3.add(txtFecha);
        txtFecha.setBounds(50, 10, 80, 20);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Hora");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(200, 10, 40, 20);
        jPanel3.add(txtHora);
        txtHora.setBounds(230, 10, 80, 20);

        labelusuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelusuario.setText("Usuario");
        jPanel3.add(labelusuario);
        labelusuario.setBounds(420, 10, 50, 15);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/UsuarioLogueado.png"))); // NOI18N
        jPanel3.add(jLabel12);
        jLabel12.setBounds(470, 0, 30, 30);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Nombre Especialidad");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 40, 140, 20);
        jPanel1.add(txtNombreEsp);
        txtNombreEsp.setBounds(160, 40, 330, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Descripción");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 110, 110, 15);

        areaDescripcion.setColumns(20);
        areaDescripcion.setRows(5);
        jScrollPane1.setViewportView(areaDescripcion);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(160, 70, 330, 100);

        btnAgregarEsp.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnAgregarEsp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N
        btnAgregarEsp.setText("Agregar");
        btnAgregarEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEspActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarEsp);
        btnAgregarEsp.setBounds(200, 180, 93, 30);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Código Especialidad");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 10, 130, 20);
        jPanel1.add(txtCodEsp);
        txtCodEsp.setBounds(160, 10, 80, 20);

        btnAceptarEdicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aceptar.png"))); // NOI18N
        btnAceptarEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarEdicionActionPerformed(evt);
            }
        });

        tblEspecialidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Especialidad", "Nombre Especialidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEspecialidad.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblEspecialidad);

        btnEliminarPais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        btnEliminarPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPaisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptarEdicion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarPais, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAceptarEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarPais, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        btnSalir.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnEditarPais.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnEditarPais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        btnEditarPais.setText("Editar");
        btnEditarPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPaisActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(btnEditarPais, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarPais, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarEdicionActionPerformed
        txtCodEsp.setEnabled(true);
        txtNombreEsp.setEnabled(true);
        areaDescripcion.setEnabled(true);
        DefaultTableModel modeloT = (DefaultTableModel) tblEspecialidad.getModel();
        int fila = tblEspecialidad.getSelectedRow();
        txtCodEsp.setText((String) modeloT.getValueAt(fila, 0));
        txtNombreEsp.setText((String) modeloT.getValueAt(fila,1));
        Iterator ite = gestorH.listarClase(EspecialidadLaboratorio.class).iterator();
        while (ite.hasNext()) {
            EspecialidadLaboratorio e = (EspecialidadLaboratorio) ite.next();
            if (e.getCodigoEspecialidad().equalsIgnoreCase(txtCodEsp.getText())) {
                idEspecialidad = e.getIdEspecialidadLaboratorio();
            }
        }
        modeloT.removeRow(fila);
    }//GEN-LAST:event_btnAceptarEdicionActionPerformed

    private void btnEditarPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPaisActionPerformed
        btnNuevo.setEnabled(false);
        txtCodEsp.setEnabled(false);
        txtNombreEsp.setEnabled(false);
        areaDescripcion.setEnabled(false);
        btnAceptarEdicion.setEnabled(true);
    }//GEN-LAST:event_btnEditarPaisActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        btnEditarPais.setEnabled(false);
        txtCodEsp.setEnabled(true);
        txtNombreEsp.setEnabled(true);
        areaDescripcion.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        int bandera1 = gestoru.CampoObligatorio(txtCodEsp);
        int bandera2 = gestoru.CampoObligatorio(txtNombreEsp);
        if(bandera1==0 && bandera2==0){
        
        if (btnEditarPais.isEnabled()) {
            JOptionPane.showMessageDialog(null, "Los cambios se han guardado correctamente");            
        } else {
            gestorE.guardarEspecialidadLaboratorio(tblEspecialidad);
            JOptionPane.showMessageDialog(null, "Los cambios se han guardado correctamente");            
        }

        }
        else{
        JOptionPane.showMessageDialog(null, "Campo Obligatorio");        
        }
                    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAgregarEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEspActionPerformed
    int campo = gestorE.campoObligatorio(txtNombreEsp, txtCodEsp);
    DefaultTableModel modeloT = (DefaultTableModel) tblEspecialidad.getModel();
    if(campo == 0){    
    Object fila[]={txtCodEsp.getText(), txtNombreEsp.getText()};
    modeloT.addRow(fila);
    tblEspecialidad.setModel(modeloT);
    gestorE.actualizarEspecialidad(idEspecialidad, txtNombreEsp, txtCodEsp);
    txtNombreEsp.setText("");
    txtCodEsp.setText("");
    txtCodEsp.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
    txtNombreEsp.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
    }
    }//GEN-LAST:event_btnAgregarEspActionPerformed

    private void btnEliminarPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPaisActionPerformed
        DefaultTableModel modeloT = (DefaultTableModel) tblEspecialidad.getModel();
        int fila = tblEspecialidad.getSelectedRow();
        EspecialidadLaboratorio esp = new EspecialidadLaboratorio();
        esp.setCodigoEspecialidad((String) modeloT.getValueAt(fila, 0));
        Iterator ite = gestorH.listarClase(EspecialidadLaboratorio.class).iterator();
        while (ite.hasNext()) {
            EspecialidadLaboratorio e = (EspecialidadLaboratorio) ite.next();
            if (e.getCodigoEspecialidad().equalsIgnoreCase(esp.getCodigoEspecialidad())) {
                gestorH.eliminarObjeto(e);
            }
        }
        modeloT.removeRow(tblEspecialidad.getSelectedRow());


                    }//GEN-LAST:event_btnEliminarPaisActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    int respuesta = JOptionPane.showConfirmDialog(null, "Confirma que desea salir?");
    if (respuesta==0){
    dispose();
    }
    }//GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDescripcion;
    private javax.swing.JButton btnAceptarEdicion;
    private javax.swing.JButton btnAgregarEsp;
    private javax.swing.JButton btnEditarPais;
    private javax.swing.JButton btnEliminarPais;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelusuario;
    private javax.swing.JTable tblEspecialidad;
    private javax.swing.JTextField txtCodEsp;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtNombreEsp;
    // End of variables declaration//GEN-END:variables
}
