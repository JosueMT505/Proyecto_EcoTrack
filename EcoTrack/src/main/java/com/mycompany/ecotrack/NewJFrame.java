/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ecotrack;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Comparator;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jesua
 */
public class NewJFrame extends javax.swing.JFrame {
    private Sistema sistema;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(NewJFrame.class.getName());

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame(Sistema sistema) {
    initComponents();
    this.sistema = sistema;
    llenarTabla(); 
}
    
    public void llenarTabla() {
    DefaultTableModel modelo = (DefaultTableModel) tblResiduos.getModel();
    modelo.setRowCount(0);
    ListaCircularResiduos listaCircular = sistema.getListaResiduos();
    IteradorResiduos<Residuo> it = listaCircular.iterador();
    
    while (it.hasNext()) {
        Residuo r = it.next();
        Object[] fila = {
            r.getId(),
            r.getNombre(),
            r.getTipo(),
            r.getPeso(),
            r.getFechaRecoleccion().toString(),
            r.getZona(),
            r.getNivelPrioridadAmbiental() 
        };
        modelo.addRow(fila);
    }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        pestanas = new javax.swing.JTabbedPane();
        residuos = new javax.swing.JPanel();
        guardar = new javax.swing.JButton();
        ordenar = new javax.swing.JButton();
        btnCargarTXT = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        agregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResiduos = new javax.swing.JTable();
        reciclaje = new javax.swing.JPanel();
        lblCima = new javax.swing.JLabel();
        lblUltimo = new javax.swing.JLabel();
        lblContador = new javax.swing.JLabel();
        btnProcesar = new javax.swing.JButton();
        rutas = new javax.swing.JPanel();
        btnDespachar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblResumenRutas = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtReporteRutas = new javax.swing.JTextArea();
        estadisticas = new javax.swing.JPanel();
        lblNorte = new javax.swing.JLabel();
        lblSur = new javax.swing.JLabel();
        barNorte = new javax.swing.JProgressBar();
        barSur = new javax.swing.JProgressBar();
        barEste = new javax.swing.JProgressBar();
        barOeste = new javax.swing.JProgressBar();
        barCentro = new javax.swing.JProgressBar();
        lblEste = new javax.swing.JLabel();
        lblOeste = new javax.swing.JLabel();
        lblCentro = new javax.swing.JLabel();
        lblTotalCantidad = new javax.swing.JLabel();
        lblTotalPesoGlobal = new javax.swing.JLabel();
        txtAreaResumen = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pestanas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pestanasStateChanged(evt);
            }
        });

        guardar.setText("Guardar");
        guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        ordenar.setText("Ordenar Y Filtrar");
        ordenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordenarActionPerformed(evt);
            }
        });

        btnCargarTXT.setText("Cargar");
        btnCargarTXT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCargarTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarTXTActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        tblResiduos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Tipo", "Peso", "Fecha", "Zona", "Prioridad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblResiduos.setMaximumSize(new java.awt.Dimension(500, 140));
        jScrollPane1.setViewportView(tblResiduos);
        if (tblResiduos.getColumnModel().getColumnCount() > 0) {
            tblResiduos.getColumnModel().getColumn(0).setResizable(false);
            tblResiduos.getColumnModel().getColumn(1).setResizable(false);
            tblResiduos.getColumnModel().getColumn(2).setResizable(false);
            tblResiduos.getColumnModel().getColumn(3).setResizable(false);
            tblResiduos.getColumnModel().getColumn(4).setResizable(false);
            tblResiduos.getColumnModel().getColumn(5).setResizable(false);
            tblResiduos.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout residuosLayout = new javax.swing.GroupLayout(residuos);
        residuos.setLayout(residuosLayout);
        residuosLayout.setHorizontalGroup(
            residuosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, residuosLayout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(residuosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, residuosLayout.createSequentialGroup()
                        .addComponent(ordenar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(201, 201, 201))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, residuosLayout.createSequentialGroup()
                        .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnCargarTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        residuosLayout.setVerticalGroup(
            residuosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(residuosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(residuosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar)
                    .addComponent(btnCargarTXT)
                    .addComponent(guardar)
                    .addComponent(eliminar))
                .addGap(18, 18, 18)
                .addComponent(ordenar, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        pestanas.addTab("Gestión de Residuos", residuos);

        lblCima.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCima.setText("Siguiente a procesar:");

        lblUltimo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUltimo.setText("Último residuo apilado:");

        lblContador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblContador.setText("Residuos en espera:");

        btnProcesar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnProcesar.setText("PROCESAR AHORA");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout reciclajeLayout = new javax.swing.GroupLayout(reciclaje);
        reciclaje.setLayout(reciclajeLayout);
        reciclajeLayout.setHorizontalGroup(
            reciclajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reciclajeLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(lblCima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addComponent(lblUltimo)
                .addGap(105, 105, 105))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reciclajeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reciclajeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblContador)
                .addGap(236, 236, 236))
        );
        reciclajeLayout.setVerticalGroup(
            reciclajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reciclajeLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(reciclajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCima)
                    .addComponent(lblUltimo))
                .addGap(57, 57, 57)
                .addComponent(lblContador)
                .addGap(52, 52, 52)
                .addComponent(btnProcesar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
        );

        pestanas.addTab("Centro de Reciclaje", reciclaje);

        btnDespachar.setText("Despachar Vehículos");
        btnDespachar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDespacharActionPerformed(evt);
            }
        });

        tblResumenRutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Zona", "Utilidad", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblResumenRutas);
        if (tblResumenRutas.getColumnModel().getColumnCount() > 0) {
            tblResumenRutas.getColumnModel().getColumn(0).setResizable(false);
            tblResumenRutas.getColumnModel().getColumn(1).setResizable(false);
            tblResumenRutas.getColumnModel().getColumn(2).setResizable(false);
        }

        txtReporteRutas.setColumns(20);
        txtReporteRutas.setRows(5);
        jScrollPane3.setViewportView(txtReporteRutas);

        javax.swing.GroupLayout rutasLayout = new javax.swing.GroupLayout(rutas);
        rutas.setLayout(rutasLayout);
        rutasLayout.setHorizontalGroup(
            rutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rutasLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(rutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rutasLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rutasLayout.createSequentialGroup()
                        .addComponent(btnDespachar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))))
        );
        rutasLayout.setVerticalGroup(
            rutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rutasLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(rutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rutasLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDespachar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        pestanas.addTab("Rutas", rutas);

        estadisticas.setLayout(null);

        lblNorte.setText("peso");
        estadisticas.add(lblNorte);
        lblNorte.setBounds(30, 170, 80, 16);

        lblSur.setText("area");
        estadisticas.add(lblSur);
        lblSur.setBounds(30, 120, 70, 16);
        estadisticas.add(barNorte);
        barNorte.setBounds(30, 190, 206, 13);
        estadisticas.add(barSur);
        barSur.setBounds(30, 140, 206, 13);
        estadisticas.add(barEste);
        barEste.setBounds(350, 140, 206, 13);
        estadisticas.add(barOeste);
        barOeste.setBounds(350, 190, 206, 13);
        estadisticas.add(barCentro);
        barCentro.setBounds(200, 240, 206, 13);

        lblEste.setText("jLabel1");
        estadisticas.add(lblEste);
        lblEste.setBounds(350, 120, 90, 16);

        lblOeste.setText("jLabel2");
        estadisticas.add(lblOeste);
        lblOeste.setBounds(350, 170, 100, 16);

        lblCentro.setText("jLabel3");
        estadisticas.add(lblCentro);
        lblCentro.setBounds(200, 220, 110, 16);

        lblTotalCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalCantidad.setText("jLabel1");
        estadisticas.add(lblTotalCantidad);
        lblTotalCantidad.setBounds(220, 50, 150, 16);

        lblTotalPesoGlobal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalPesoGlobal.setText("jLabel1");
        lblTotalPesoGlobal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        estadisticas.add(lblTotalPesoGlobal);
        lblTotalPesoGlobal.setBounds(220, 80, 150, 16);

        txtAreaResumen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAreaResumen.setText("jLabel1");
        estadisticas.add(txtAreaResumen);
        txtAreaResumen.setBounds(90, 20, 410, 16);

        pestanas.addTab("Estadísticas", estadisticas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pestanas)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pestanas, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
        );

        pestanas.getAccessibleContext().setAccessibleName("Residuos");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        abrirVentanaAgregar();
    }//GEN-LAST:event_agregarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        int fila = tblResiduos.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un residuo para procesar.");
        return;
    }
    String id = tblResiduos.getValueAt(fila, 0).toString();
    Residuo rParaPila = sistema.getListaResiduos().buscarResiduo(id); 

    if (rParaPila != null) {
        int confirmar = JOptionPane.showConfirmDialog(this, 
            "¿Enviar " + rParaPila.getNombre() + " al Centro de Reciclaje?", 
            "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {
            if (sistema.getListaResiduos().eliminarResiduo(id)) {
                sistema.getResiduosParaProcesar().apilarResiduo(rParaPila); 
                try {
                    sistema.guardarEstado("datos.dat");
                    llenarTabla(); 
                    actualizarEstadoPila(); 
                    JOptionPane.showMessageDialog(this, "Residuo movido al Centro de Reciclaje.");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
                }
            }
        }
    }
    }//GEN-LAST:event_eliminarActionPerformed

    private void btnCargarTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarTXTActionPerformed
        JFileChooser selector = new JFileChooser();
        selector.setDialogTitle("Seleccione el archivo de residuos (.txt)");
        selector.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos de Texto", "txt"));
        int resultado = selector.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = selector.getSelectedFile();

            try (BufferedReader reader = new BufferedReader(new FileReader(archivoSeleccionado))) {
                String linea;
                int contador = 0;
                while ((linea = reader.readLine()) != null) {
                    if (linea.trim().isEmpty()) continue;
                    String[] partes = linea.split(",");
                    if (partes.length >= 6) {
                        Residuo nuevo = new Residuo(
                            partes[0].trim(),
                            partes[1].trim(),
                            partes[2].trim(),
                            Double.parseDouble(partes[3].trim()),
                            partes[4].trim(),
                            Integer.parseInt(partes[5].trim())
                        );
                        sistema.registrarResiduo(nuevo);
                        contador++;
                    }
                }
                sistema.guardarEstado("datos.dat");
                llenarTabla();
                JOptionPane.showMessageDialog(this, "Se importaron " + contador + " residuos y se sincronizó con el sistema.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al procesar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCargarTXTActionPerformed

    private void ordenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordenarActionPerformed
        abrirVentanaOrdenar();
    }//GEN-LAST:event_ordenarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        JFileChooser selector = new JFileChooser();
        selector.setDialogTitle("Guardar lista de residuos como TXT");
        selector.setSelectedFile(new java.io.File("residuos_exportados.txt"));

        int seleccion = selector.showSaveDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            java.io.File archivo = selector.getSelectedFile();
            try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter(archivo))) {
                IteradorResiduos<Residuo> it = sistema.getListaResiduos().iterador();
                while (it.hasNext()) {
                    Residuo r = it.next();
                    String linea = String.format("%s,%s,%s,%.2f,%s,%d",
                        r.getId(),
                        r.getNombre(),
                        r.getTipo(),
                        r.getPeso(),
                        r.getZona(),
                        r.getNivelPrioridadAmbiental()
                    );

                    writer.println(linea);
                }

                JOptionPane.showMessageDialog(this, "Datos exportados exitosamente a " + archivo.getName());

            } catch (java.io.IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar el archivo: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        PilaReciclaje<Residuo> pila = sistema.getResiduosParaProcesar();
    Residuo procesado = pila.desapilarResiduo(); 

    JOptionPane.showMessageDialog(this, "PROCESADO: " + procesado.getNombre() + 
                                  "\n¡El material ha sido enviado a reciclaje!");

    try {
        sistema.guardarEstado("datos.dat"); 
        actualizarEstadoPila(); 
    } catch (Exception e) {
        System.out.println("Error al guardar: " + e.getMessage());
    }
    }//GEN-LAST:event_btnProcesarActionPerformed

    private void pestanasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pestanasStateChanged
       if (pestanas.getSelectedIndex() == 1) {
    actualizarEstadoPila(); }                                 
    int index = pestanas.getSelectedIndex();
    if (index == 3) {
        actualizarMapaEstadisticas();
        mostrarResumenGlobal();}
    if (pestanas.getSelectedIndex() == 2) { 
        llenarTablaResumenRutas(); 
    }
    }//GEN-LAST:event_pestanasStateChanged

    private void btnDespacharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDespacharActionPerformed
      Comparator<RutaDespacho> comp = (r1, r2) -> Integer.compare(r2.utilidad, r1.utilidad);
    ColaPrioridad<RutaDespacho> cola = new ColaPrioridad<>(comp);

    String[] zonas = {"Norte", "Sur", "Este", "Oeste", "Centro"};
    for (String z : zonas) {
        int u = calcularUtilidadZona(z); 
        cola.agregarVehiculo(new RutaDespacho(z, u));
    }

    StringBuilder reporte = new StringBuilder("ORDEN DE DESPACHO (Prioridad por Foco Crítico):\n\n");
    int orden = 1;
    
    while (!cola.estaVacia()) {
        RutaDespacho ruta = cola.despacharVehiculo();
        String alerta = (ruta.utilidad < 0) ? " !!! FOCO CRÍTICO !!!" : " (Estable)";
        
        reporte.append(orden).append(". Zona: ").append(ruta.zona)
               .append(" | Utilidad: ").append(ruta.utilidad)
               .append(alerta).append("\n");
        orden++;
    }

    txtReporteRutas.setText(reporte.toString());            
    }//GEN-LAST:event_btnDespacharActionPerformed

    public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(() -> {
        Sistema sistemaPrueba;
        try {
            sistemaPrueba = Sistema.cargarEstado("datos.dat");
        } catch (Exception e) {
            sistemaPrueba = new Sistema();
        }
        new NewJFrame(sistemaPrueba).setVisible(true);
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JProgressBar barCentro;
    private javax.swing.JProgressBar barEste;
    private javax.swing.JProgressBar barNorte;
    private javax.swing.JProgressBar barOeste;
    private javax.swing.JProgressBar barSur;
    private javax.swing.JButton btnCargarTXT;
    private javax.swing.JButton btnDespachar;
    private javax.swing.JButton btnProcesar;
    private javax.swing.JButton eliminar;
    private javax.swing.JPanel estadisticas;
    private javax.swing.JButton guardar;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCentro;
    private javax.swing.JLabel lblCima;
    private javax.swing.JLabel lblContador;
    private javax.swing.JLabel lblEste;
    private javax.swing.JLabel lblNorte;
    private javax.swing.JLabel lblOeste;
    private javax.swing.JLabel lblSur;
    private javax.swing.JLabel lblTotalCantidad;
    private javax.swing.JLabel lblTotalPesoGlobal;
    private javax.swing.JLabel lblUltimo;
    private javax.swing.JButton ordenar;
    private javax.swing.JTabbedPane pestanas;
    private javax.swing.JPanel reciclaje;
    private javax.swing.JPanel residuos;
    private javax.swing.JPanel rutas;
    private javax.swing.JTable tblResiduos;
    private javax.swing.JTable tblResumenRutas;
    private javax.swing.JLabel txtAreaResumen;
    private javax.swing.JTextArea txtReporteRutas;
    // End of variables declaration//GEN-END:variables

   private void abrirVentanaAgregar() {
    JTextField txtNombre = new JTextField();
    String[] tipos = {"Plástico", "Vidrio", "Papel", "Orgánico", "Electrónico"};
    JComboBox<String> cbTipo = new JComboBox<>(tipos);
    String[] zonas = {"Norte", "Sur", "Este", "Oeste", "Centro"};
    JComboBox<String> cbZona = new JComboBox<>(zonas);
    
    JTextField txtPeso = new JTextField();
    JSpinner spPrioridad = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

    JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));
    panel.add(new JLabel("Nombre del Residuo:"));
    panel.add(txtNombre);
    panel.add(new JLabel("Tipo de Residuo:"));
    panel.add(cbTipo);
    panel.add(new JLabel("Zona de Recolección:"));
    panel.add(cbZona);
    panel.add(new JLabel("Peso (kg):"));
    panel.add(txtPeso);
    panel.add(new JLabel("Nivel de Prioridad (1-10):"));
    panel.add(spPrioridad);
    int result = JOptionPane.showConfirmDialog(this, panel, "Registrar Nuevo Residuo",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    if (result == JOptionPane.OK_OPTION) {
        try {
            String id = "R-" + (sistema.getListaResiduos().size() + 1);
            String nombre = txtNombre.getText().trim();
            String tipo = cbTipo.getSelectedItem().toString();
            String zona = cbZona.getSelectedItem().toString();
            if (nombre.isEmpty()) throw new Exception("El nombre no puede estar vacío.");
            double peso = Double.parseDouble(txtPeso.getText().trim());
            if (peso <= 0) throw new Exception("El peso debe ser mayor a 0.");
            int prioridad = (int) spPrioridad.getValue();
            Residuo nuevo = new Residuo(id, nombre, tipo, peso, zona, prioridad);
            sistema.registrarResiduo(nuevo);
            Persistencia.guardar(sistema, "datos.dat");
            llenarTabla();
            JOptionPane.showMessageDialog(this, "Residuo " + id + " agregado y guardado.");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: El peso debe ser un número.", "Error de formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
   }
   
   private void abrirVentanaOrdenar() {
    JCheckBox chkPeso = new JCheckBox("Peso (Mayor a Menor)");
    JCheckBox chkPrioridad = new JCheckBox("Prioridad (Mayor a Menor)");
    String[] tipos = {"Todos", "Plástico", "Vidrio", "Papel", "Orgánico", "Electrónico"};
    JComboBox<String> cbTipoFiltro = new JComboBox<>(tipos);
    JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));
    panel.add(new JLabel("Seleccione criterios de orden/filtro:"));
    panel.add(chkPeso);
    panel.add(chkPrioridad);
    panel.add(new JLabel("Filtrar por Tipo:"));
    panel.add(cbTipoFiltro);
    int result = JOptionPane.showConfirmDialog(this, panel, "Opciones de Ordenamiento",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    if (result == JOptionPane.OK_OPTION) {
        aplicarOrdenYFiltro(chkPeso.isSelected(), chkPrioridad.isSelected(), cbTipoFiltro.getSelectedItem().toString());
    }
}
   
   private void aplicarOrdenYFiltro(boolean porPeso, boolean porPrioridad, String tipoFiltro) {
    java.util.List<Residuo> listaTemp = new java.util.ArrayList<>();
    IteradorResiduos<Residuo> it = sistema.getListaResiduos().iterador();
    while (it.hasNext()) {
        Residuo r = it.next();
        if (tipoFiltro.equals("Todos") || r.getTipo().equalsIgnoreCase(tipoFiltro)) {
            listaTemp.add(r);
        }
    }
    if (porPrioridad) {
        listaTemp.sort(new ComparadorPrioridad()); 
    } else if (porPeso) {
        listaTemp.sort(new ComparadorPeso().reversed()); 
    } else {
        listaTemp.sort(new ComparadorTipo()); }
    mostrarResultadosEnTabla(listaTemp);
}

private void mostrarResultadosEnTabla(java.util.List<Residuo> lista) {
    DefaultTableModel modelo = (DefaultTableModel) tblResiduos.getModel();
    modelo.setRowCount(0);
    for (Residuo r : lista) {
        Object[] fila = { r.getId(), r.getNombre(), r.getTipo(), r.getPeso(), r.getFechaRecoleccion(), r.getZona(), r.getNivelPrioridadAmbiental() };
        modelo.addRow(fila);
    }
}

public void actualizarEstadoPila() {
    PilaReciclaje<Residuo> pila = sistema.getResiduosParaProcesar();

    if (pila.estaVacia()) {
        lblCima.setText("Siguiente a procesar: NINGUNO");
        lblUltimo.setText("Estado: Pila vacía");
        lblContador.setText("Residuos en espera: 0");
        btnProcesar.setEnabled(false);
    } else {
        Residuo cima = pila.verTope(); 
        
        lblCima.setText("Siguiente a procesar:  " + cima.getNombre() + " (" + cima.getId() + ")");
        lblUltimo.setText("Tipo: " + cima.getTipo() + " | Peso: " + cima.getPeso() + "kg");
        lblContador.setText("Residuos en espera: " + pila.size());
        btnProcesar.setEnabled(true);
    }
}

public void mostrarResumenGlobal() {
    int totalResiduos = 0;
    double pesoTotalGral = 0;
    int organicos = 0;
    int plasticos = 0;
    int papelCarton = 0;
    int vidrios = 0;
    int electronicos = 0;
    IteradorResiduos<Residuo> it = sistema.getListaResiduos().iterador();
   
    while (it.hasNext()) {
        Residuo r = it.next();
        totalResiduos++;
        pesoTotalGral += r.getPeso();
        switch (r.getTipo().toLowerCase()) {
            case "orgánico" -> organicos++;
            case "plástico" -> plasticos++;
            case "papel" -> papelCarton++;
            case "vidrio" -> vidrios++;
            case "electrónico" -> electronicos++;
        }
    }
    lblTotalCantidad.setText("Residuos Totales: " + totalResiduos);
    lblTotalPesoGlobal.setText("Peso Total Ciudad: " + String.format("%.2f", pesoTotalGral) + " kg");
    String detalle = "Desglose por categoría:\n" +
                     "- Plásticos: " + plasticos + "\n" +
                     "- Orgánicos: " + organicos + "\n" +
                     "- Vidrio: " + vidrios + "\n" +
                     "- Otros: " + (papelCarton + electronicos);
    txtAreaResumen.setText(detalle);
}

public void actualizarMapaEstadisticas() {
    double norte = 0, sur = 0, este = 0, oeste = 0, centro = 0;
    double pesoMaximoZona = 100.0;
    IteradorResiduos<Residuo> it = sistema.getListaResiduos().iterador();
    while (it.hasNext()) {
        Residuo r = it.next();
        switch (r.getZona().toLowerCase()) {
            case "norte" -> norte += r.getPeso();
            case "sur" -> sur += r.getPeso();
            case "este" -> este += r.getPeso();
            case "oeste" -> oeste += r.getPeso();
            case "centro" -> centro += r.getPeso();
        }
    }

    actualizarBarra(barNorte, lblNorte, "Norte", norte, pesoMaximoZona);
    actualizarBarra(barSur, lblSur, "Sur", sur, pesoMaximoZona);
    actualizarBarra(barEste, lblEste, "Este", este, pesoMaximoZona);
    actualizarBarra(barOeste, lblOeste, "Oeste", oeste, pesoMaximoZona);
    actualizarBarra(barCentro, lblCentro, "Centro", centro, pesoMaximoZona);
}

private void actualizarBarra(JProgressBar bar, JLabel lbl, String nombre, double peso, double max) {
    int porcentaje = (int) Math.min((peso / max) * 100, 100);
    bar.setValue(porcentaje);
    lbl.setText(nombre + ": " + peso + " kg");
    if (porcentaje > 80) bar.setForeground(java.awt.Color.RED);
    else if (porcentaje > 40) bar.setForeground(java.awt.Color.ORANGE);
    else bar.setForeground(java.awt.Color.GREEN);
}

public int calcularUtilidadZona(String zona) {
    int pendientes = 0;
    int procesados = 0;

    CircularDoublyLinkedList<Residuo> listaP = sistema.getListaResiduos().getListaInterna();
    for (int i = 0; i < listaP.size(); i++) {
        if (listaP.get(i).getZona().equalsIgnoreCase(zona)) {
            pendientes++;
        }
    }

    ArrayList<Residuo> listaE = sistema.getResiduosParaProcesar().getElementos();
    for (int i = 0; i < listaE.size(); i++) {
        if (listaE.get(i).getZona().equalsIgnoreCase(zona)) {
            procesados++;
        }
    }

    return procesados - pendientes;
}

public void llenarTablaResumenRutas() {
    DefaultTableModel modelo = (DefaultTableModel) tblResumenRutas.getModel();
    modelo.setRowCount(0); 

    String[] zonas = {"Norte", "Sur", "Este", "Oeste", "Centro"};

    for (String zona : zonas) {
        int u = calcularUtilidadZona(zona);
        
        String estado = (u < 0) ? "CRÍTICO" : "ESTABLE";

        Object[] fila = {zona, u, estado};
        modelo.addRow(fila);
    }
}
}
