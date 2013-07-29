/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas_Transporte;

import Clases_Modulo_Transporte.Especialidad;
import Clases_Modulo_Transporte.TallerReparacion;
import Gestores_Clases.gestorEspecialidadTaller;
import Gestores_Clases.gestorPais;
import Hibernate.GestorHibernate;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
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
 * @author Carolina
 */
public class frmRegistrarEspTaller extends javax.swing.JInternalFrame {
GestorHibernate gestorH = new GestorHibernate();
gestorEspecialidadTaller gestorE= new gestorEspecialidadTaller();
gestorPais gestorEs = new gestorPais();
long idEsp;
    /**
     * Creates new form frmRegistrarEspTaller
     */
    public frmRegistrarEspTaller() {
        initComponents();
        
        gestorH.actualizarUsuario(labelUsuario);
        txtFecha.setEnabled(false);
        txtFecha.setEditable(false);
        txtHora.setEditable(false);
        txtHora.setEnabled(false);
        btnAceptarEdicion.setEnabled(false);
        txtPais.setEnabled(false);
        
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
        
        //centrar cabecera jtable
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tblPais.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(0);

        
          //lineas para mejorar el aspecto de la pantalla    
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = kit.getScreenSize();
        int ancho = 510;
        int alto = 380;
//    int posX = (int) ((tamanioPantalla.width - ancho) / 2);
//    int posY = (int) ((tamanioPantalla.height - alto) / 2);
        this.setSize(ancho, alto);
        this.setLocation(380, 120);
        DefaultTableModel modeloT = (DefaultTableModel) tblPais.getModel();
        Iterator ite = gestorH.listarClase(Especialidad.class).iterator();
        while(ite.hasNext()){
            Especialidad p = (Especialidad) ite.next();
            Object fila[] = {p.getNombreEspecialidad()};
            modeloT.addRow(fila);
            tblPais.setModel(modeloT);
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

        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        labelUsuario = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPais = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPais = new javax.swing.JTable();
        btnAceptarEdicion = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        btnAgregarEspecialidad = new javax.swing.JButton();
        btnEliminarEspecialidad = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEditarEspecialidad = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

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
        jLabel10.setBounds(180, 10, 40, 20);
        jPanel3.add(txtHora);
        txtHora.setBounds(210, 10, 80, 20);

        labelUsuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelUsuario.setText("Usuario");
        jPanel3.add(labelUsuario);
        labelUsuario.setBounds(390, 10, 50, 15);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/UsuarioLogueado.png"))); // NOI18N
        jPanel3.add(jLabel12);
        jLabel12.setBounds(450, 0, 30, 30);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Nombre Especialidad");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 20, 180, 20);
        jPanel1.add(txtPais);
        txtPais.setBounds(140, 20, 200, 20);

        tblPais.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblPais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Especialidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPais.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblPais);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(90, 60, 250, 130);

        btnAceptarEdicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aceptar.png"))); // NOI18N
        btnAceptarEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarEdicionActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptarEdicion);
        btnAceptarEdicion.setBounds(350, 90, 40, 30);

        btnAgregarEspecialidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N
        btnAgregarEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEspecialidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btnAgregarEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel17);
        jPanel17.setBounds(340, -40, 60, 110);

        btnEliminarEspecialidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete.png"))); // NOI18N
        btnEliminarEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEspecialidadActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarEspecialidad);
        btnEliminarEspecialidad.setBounds(350, 130, 40, 30);

        btnNuevo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icononuevo.PNG"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditarEspecialidad.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnEditarEspecialidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        btnEditarEspecialidad.setText("Editar");
        btnEditarEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarEspecialidadActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarEdicionActionPerformed
        txtPais.setEnabled(true);
        DefaultTableModel modeloT = (DefaultTableModel) tblPais.getModel();
        int fila = tblPais.getSelectedRow();
        txtPais.setText((String) modeloT.getValueAt(fila, 0));
        Iterator ite = gestorH.listarClase(Especialidad.class).iterator();
        while (ite.hasNext()) {
            Especialidad p = (Especialidad) ite.next();
            if (p.getNombreEspecialidad().equalsIgnoreCase(txtPais.getText())) {
                idEsp = p.getIdEspecialidad();
            }
        }
        modeloT.removeRow(fila);
    }//GEN-LAST:event_btnAceptarEdicionActionPerformed

    private void btnAgregarEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEspecialidadActionPerformed
        int campo = gestorEs.campoObligatorio(txtPais);
        if(campo == 0){
        DefaultTableModel modeloT = (DefaultTableModel) tblPais.getModel();
        Object fila[] = {txtPais.getText()};
        modeloT.addRow(fila);
        tblPais.setModel(modeloT);
        gestorE.actualizarEspecialidad(idEsp, txtPais);
        txtPais.setText("");
        txtPais.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
         }
    }//GEN-LAST:event_btnAgregarEspecialidadActionPerformed

    private void btnEliminarEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEspecialidadActionPerformed
        DefaultTableModel modeloT = (DefaultTableModel) tblPais.getModel();
        int bandera=0;
        int fila = tblPais.getSelectedRow();
        Especialidad e = new Especialidad();
        e.setNombreEspecialidad((String) modeloT.getValueAt(fila, 0));
        Iterator ite = gestorH.listarClase(Especialidad.class).iterator();
        while (ite.hasNext()) {
            Especialidad p = (Especialidad) ite.next();
            if (p.getNombreEspecialidad().equalsIgnoreCase(e.getNombreEspecialidad())) {
                Iterator ite2 = gestorH.listarClase(TallerReparacion.class).iterator();
                while(ite2.hasNext()){
                    TallerReparacion taller = (TallerReparacion) ite2.next();
                    if(taller.getEspecialidad().equals(p)){
                        bandera=1;
                    }
                }
                if(bandera == 0){
                gestorH.eliminarObjeto(p);}
                else{
                JOptionPane.showMessageDialog(null, "No es posible eliminar la especialidad seleccionada");
                }
            }
        }
        modeloT.removeRow(tblPais.getSelectedRow());
    }//GEN-LAST:event_btnEliminarEspecialidadActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        btnEditarEspecialidad.setEnabled(false);
        txtPais.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEspecialidadActionPerformed
        btnNuevo.setEnabled(false);
        txtPais.setEnabled(false);
        btnAceptarEdicion.setEnabled(true);
    }//GEN-LAST:event_btnEditarEspecialidadActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (btnEditarEspecialidad.isEnabled()) {
            JOptionPane.showMessageDialog(null, "Los cambios se han guardado correctamente");
        } else {
            gestorE.guardarEspecialidad(tblPais);
            JOptionPane.showMessageDialog(null, "Los cambios se han guardado correctamente");
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Confirma que desea salir?");
        if (respuesta == 0) {
            dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarEdicion;
    private javax.swing.JButton btnAgregarEspecialidad;
    private javax.swing.JButton btnEditarEspecialidad;
    private javax.swing.JButton btnEliminarEspecialidad;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JTable tblPais;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtPais;
    // End of variables declaration//GEN-END:variables
}
