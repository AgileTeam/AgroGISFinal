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
import Gestores_Vista.gestorRegistroLaboratorio;
import Hibernate.GestorHibernate;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Charito
 */
public class frmRegistrarLaboratorio extends javax.swing.JInternalFrame {
gestorRegistroLaboratorio gLaboratorio = new gestorRegistroLaboratorio();
    /** Creates new form frmRegistrarLaboratorio */
    public frmRegistrarLaboratorio() {
        initComponents();
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
        jPanel1 = new javax.swing.JPanel();
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
        jPanel3 = new javax.swing.JPanel();
        btnAgregarLab = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        btnAgregarDepto = new javax.swing.JButton();
        btnAgregarBarrio = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        btnAgregarProv = new javax.swing.JButton();
        btnAgregarLocal = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLaboratorio = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Laboratorio");

        jPanel2.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Fecha");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(30, 10, 50, 20);
        jPanel2.add(txtFecha);
        txtFecha.setBounds(70, 10, 102, 20);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Hora");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(220, 10, 40, 20);
        jPanel2.add(txtHora);
        txtHora.setBounds(250, 10, 70, 20);

        labelusuario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        labelusuario.setText("Usuario");
        jPanel2.add(labelusuario);
        labelusuario.setBounds(570, 10, 50, 15);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/UsuarioLogueado.png"))); // NOI18N
        jPanel2.add(jLabel14);
        jLabel14.setBounds(630, 0, 30, 30);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Laboratorio", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Especialidad");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(370, 30, 130, 20);

        txtRazonSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonSocialKeyTyped(evt);
            }
        });
        jPanel1.add(txtRazonSocial);
        txtRazonSocial.setBounds(90, 30, 210, 20);

        jPanel1.add(cmbEspecialidad);
        cmbEspecialidad.setBounds(450, 30, 190, 20);

        txtCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCalleKeyTyped(evt);
            }
        });
        jPanel1.add(txtCalle);
        txtCalle.setBounds(90, 70, 250, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Calle");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 70, 90, 20);
        jPanel1.add(txtNum);
        txtNum.setBounds(450, 70, 50, 20);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Número");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(400, 70, 110, 20);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Provincia");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 110, 90, 20);

        jPanel1.add(cmbProvincia);
        cmbProvincia.setBounds(90, 110, 200, 20);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Departamento");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(370, 110, 160, 20);

        jPanel1.add(cmbDepartamento);
        cmbDepartamento.setBounds(450, 110, 190, 20);

        jPanel1.add(cmbLocalidad);
        cmbLocalidad.setBounds(90, 150, 200, 20);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Localidad");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 150, 110, 20);

        jPanel1.add(cmbBarrio);
        cmbBarrio.setBounds(450, 150, 190, 20);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Barrio");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(410, 150, 140, 20);

        jPanel1.add(cmbTipoTel);
        cmbTipoTel.setBounds(90, 190, 120, 20);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Tipo Teléfono");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 190, 90, 20);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Teléfono");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(400, 190, 90, 20);

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono);
        txtTelefono.setBounds(450, 190, 150, 20);
        jPanel1.add(txtEmail);
        txtEmail.setBounds(90, 230, 240, 20);

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("E-Mail");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(50, 230, 70, 20);

        btnAgregarLab.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnAgregarLab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N
        btnAgregarLab.setText("Agregar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregarLab)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregarLab, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(290, 260, 120, 40);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 30, 100, 20);

        btnAgregarDepto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N

        btnAgregarBarrio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarDepto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarBarrio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnAgregarDepto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel17);
        jPanel17.setBounds(600, 80, 100, 140);

        btnAgregarProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N

        btnAgregarLocal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_mas.png"))); // NOI18N

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarProv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarLocal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnAgregarProv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAgregarLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel18);
        jPanel18.setBounds(250, 80, 100, 140);

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
    int respuesta = JOptionPane.showConfirmDialog(null, "Confirma que desea cancelar la operación?");
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

private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    DefaultTableModel modeloTabla = (DefaultTableModel) tblLaboratorio.getModel();
    GestorHibernate gestorH = new GestorHibernate();
    Object fila[]= {txtRazonSocial.getText(), cmbEspecialidad.getSelectedItem(), cmbLocalidad.getSelectedItem()};
    modeloTabla.addRow(fila);
    tblLaboratorio.setModel(modeloTabla);
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
    gestorH.guardarObjeto(laboratorio);
}//GEN-LAST:event_btnGuardarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarBarrio;
    private javax.swing.JButton btnAgregarDepto;
    private javax.swing.JButton btnAgregarLab;
    private javax.swing.JButton btnAgregarLocal;
    private javax.swing.JButton btnAgregarProv;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelusuario;
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
