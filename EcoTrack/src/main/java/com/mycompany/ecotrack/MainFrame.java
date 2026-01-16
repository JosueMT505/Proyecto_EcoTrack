package com.mycompany.ecotrack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;

public class MainFrame extends JFrame {

    private Sistema sistema;
    private JLabel lblInfo;

    private JButton btnAgregarResiduo;
    private JButton btnBuscarResiduo;
    private JButton btnEliminarResiduo;
    private JButton btnNavegarResiduos;

    private JButton btnRutasRecoleccion;
    private JButton btnCentroReciclaje;

    private JButton btnEstadisticas;
    private JButton btnGuardar;
    private JButton btnCargar;

    private JButton btnCerrarSesion;

    public MainFrame(Sistema sistema) {
        if (sistema == null) throw new IllegalArgumentException("El sistema no puede ser null");
        this.sistema = sistema;

        setTitle("EcoTrack | Menú Principal");
        setSize(820, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                intentarGuardarAlSalir();
            }
        });

        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 248, 250));
        panel.setLayout(null);
        add(panel);

        JLabel lblTitulo = new JLabel("EcoTrack - Menú Principal");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblTitulo.setForeground(new Color(46, 125, 50));
        lblTitulo.setBounds(25, 20, 500, 40);
        panel.add(lblTitulo);

        lblInfo = new JLabel();
        lblInfo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblInfo.setBounds(25, 60, 650, 25);
        panel.add(lblInfo);
        refrescarInfoSesion();

        JLabel lblResiduos = new JLabel("Gestión de Residuos (Lista Circular + Iterador)");
        lblResiduos.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblResiduos.setBounds(25, 105, 500, 25);
        panel.add(lblResiduos);

        JLabel lblRutas = new JLabel("Rutas y Centro de Reciclaje");
        lblRutas.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblRutas.setBounds(25, 260, 500, 25);
        panel.add(lblRutas);

        JLabel lblAvanzado = new JLabel("Ordenamiento / Estadísticas / Persistencia");
        lblAvanzado.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblAvanzado.setBounds(420, 105, 380, 25);
        panel.add(lblAvanzado);

        btnAgregarResiduo = crearBoton("Agregar Residuo");
        btnAgregarResiduo.setBounds(25, 145, 330, 45);
        panel.add(btnAgregarResiduo);

        btnBuscarResiduo = crearBoton("Buscar Residuo");
        btnBuscarResiduo.setBounds(25, 200, 330, 45);
        panel.add(btnBuscarResiduo);

        btnEliminarResiduo = crearBoton("Eliminar Residuo (ADMIN)");
        btnEliminarResiduo.setBounds(25, 315, 330, 45);
        panel.add(btnEliminarResiduo);

        btnNavegarResiduos = crearBoton("Navegar Residuos (Iterador)");
        btnNavegarResiduos.setBounds(25, 370, 330, 45);
        panel.add(btnNavegarResiduos);

        btnRutasRecoleccion = crearBoton("Rutas de Recolección (Cola Prioridad)");
        btnRutasRecoleccion.setBounds(25, 425, 330, 45);
        panel.add(btnRutasRecoleccion);

        btnCentroReciclaje = crearBoton("Centro de Reciclaje (Pila)");
        btnCentroReciclaje.setBounds(420, 425, 360, 45);
        panel.add(btnCentroReciclaje);

        btnEstadisticas = crearBoton("Estadísticas (Map)");
        btnEstadisticas.setBounds(420, 145, 360, 45);
        panel.add(btnEstadisticas);

        btnGuardar = crearBoton("Guardar Sistema");
        btnGuardar.setBounds(420, 200, 360, 45);
        panel.add(btnGuardar);

        btnCargar = crearBoton("Cargar Sistema");
        btnCargar.setBounds(420, 255, 360, 45);
        panel.add(btnCargar);

        btnCerrarSesion = new JButton("Cerrar sesión");
        btnCerrarSesion.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnCerrarSesion.setBounds(620, 30, 160, 38);
        btnCerrarSesion.setBackground(new Color(220, 53, 69));
        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setFocusPainted(false);
        panel.add(btnCerrarSesion);

        btnAgregarResiduo.addActionListener(e -> uiAgregarResiduo());
        btnBuscarResiduo.addActionListener(e -> uiBuscarResiduo());
        btnEliminarResiduo.addActionListener(e -> uiEliminarResiduo());
        btnNavegarResiduos.addActionListener(e -> uiNavegarResiduos());

        btnRutasRecoleccion.addActionListener(e -> uiRutas());
        btnCentroReciclaje.addActionListener(e -> uiCentroReciclaje());

        btnEstadisticas.addActionListener(e -> uiEstadisticasYOrdenamiento());
        btnGuardar.addActionListener(e -> uiGuardar());
        btnCargar.addActionListener(e -> uiCargar());

        btnCerrarSesion.addActionListener(e -> cerrarSesion());

        configurarPermisos();
    }

    private JButton crearBoton(String texto) {
        JButton b = new JButton(texto);
        b.setFont(new Font("Segoe UI", Font.BOLD, 14));
        b.setBackground(new Color(76, 175, 80));
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        return b;
    }

    private void configurarPermisos() {
        Rol rol = Sesion.getRol();

        if (rol == Rol.OPERADOR) {
            btnEliminarResiduo.setVisible(false);
            btnRutasRecoleccion.setVisible(false);
            btnCentroReciclaje.setVisible(false);
            btnEstadisticas.setVisible(false);
            btnGuardar.setVisible(false);
            btnCargar.setVisible(false);
            return;
        }

        if (rol == Rol.SUPERVISOR) {
            btnEliminarResiduo.setVisible(false);
            btnGuardar.setVisible(false);
            btnCargar.setVisible(false);
        }
    }

    private void refrescarInfoSesion() {
        lblInfo.setText("Usuario: " + Sesion.getUsuario() + " | Rol: " + Sesion.getRol());
    }

    private void uiAgregarResiduo() {
        String id = pedirTextoNoVacio("ID del residuo:");
        if (id == null) return;

        String nombre = pedirTextoNoVacio("Nombre del residuo:");
        if (nombre == null) return;

        String tipo = pedirTextoNoVacio("Tipo (orgánico, plástico, vidrio, etc.):");
        if (tipo == null) return;

        Double peso = pedirDouble("Peso (kg):");
        if (peso == null) return;

        String zona = pedirTextoNoVacio("ID de la zona:");
        if (zona == null) return;

        Integer prioridad = pedirEntero("Prioridad ambiental (1-10):");
        if (prioridad == null) return;

        Residuo r = new Residuo(id, nombre, tipo, peso, zona, prioridad);
        boolean ok = sistema.registrarResiduo(r);

        JOptionPane.showMessageDialog(
                this,
                ok ? "Residuo registrado." : "No se pudo registrar (¿ID repetido?).",
                ok ? "OK" : "Error",
                ok ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE
        );
    }

    private void uiBuscarResiduo() {
        String id = pedirTextoNoVacio("ID a buscar:");
        if (id == null) return;

        Residuo r = sistema.getListaResiduos().buscarResiduo(id);
        if (r == null) {
            JOptionPane.showMessageDialog(this, "No existe ese residuo.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(
                this,
                "Encontrado:\n" + r.toString() + "\nZona: " + r.getZona() + "\nFecha: " + r.getFechaRecoleccion(),
                "Residuo",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void uiEliminarResiduo() {
        String id = pedirTextoNoVacio("ID a eliminar:");
        if (id == null) return;

        boolean ok = sistema.getListaResiduos().eliminarResiduo(id);
        JOptionPane.showMessageDialog(
                this,
                ok ? "Residuo eliminado." : "No se encontró el residuo.",
                ok ? "OK" : "Info",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void uiNavegarResiduos() {
        if (sistema.getListaResiduos().estaVacia()) {
            JOptionPane.showMessageDialog(this, "No hay residuos registrados.", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        IteradorResiduos<Residuo> it = sistema.getListaResiduos().iterador();
        String mensaje = "Use Siguiente/Anterior para recorrer la lista circular.";

        while (true) {
            Object[] opciones = {"Siguiente", "Anterior", "Reiniciar", "Cerrar"};
            int op = JOptionPane.showOptionDialog(
                    this,
                    mensaje,
                    "Navegación (Iterador)",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            if (op == 0) {
                mensaje = it.hasNext() ? it.next().toString() : "(Fin) Reinicie para volver a recorrer.";
            } else if (op == 1) {
                mensaje = it.hasPrevious() ? it.previous().toString() : "(Fin) Reinicie para volver a recorrer.";
            } else if (op == 2) {
                it.reset();
                mensaje = "Iterador reiniciado.";
            } else {
                break;
            }
        }
    }

    private void uiRutas() {
        Object[] opciones = {"Registrar vehículo", "Ver siguiente", "Despachar", "Volver"};
        int op = JOptionPane.showOptionDialog(
                this,
                "Vehículos pendientes: " + sistema.cantidadVehiculosPendientes(),
                "Rutas de Recolección (Cola de Prioridad)",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (op == 0) {
            String id = pedirTextoNoVacio("ID del vehículo:");
            if (id == null) return;

            Double cap = pedirDouble("Capacidad máxima (volumen):");
            if (cap == null) return;

            String zona = pedirTextoNoVacio("Zona asignada (ID):");
            if (zona == null) return;

            sistema.registrarVehiculo(new VehiculoRecolector(id, cap, zona));
            JOptionPane.showMessageDialog(this, "Vehículo registrado.", "OK", JOptionPane.INFORMATION_MESSAGE);

        } else if (op == 1) {
            VehiculoRecolector v = sistema.verSiguienteVehiculo();
            JOptionPane.showMessageDialog(
                    this,
                    v == null ? "No hay vehículos en cola." : v.toString(),
                    "Siguiente",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } else if (op == 2) {
            VehiculoRecolector v = sistema.despacharVehiculo();
            if (v == null) {
                JOptionPane.showMessageDialog(this, "No hay vehículos en cola.", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            v.setEnRuta(true);
            JOptionPane.showMessageDialog(this, "Despachado:\n" + v.toString(), "OK", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void uiCentroReciclaje() {
        Object[] opciones = {"Recolectar residuo (mover a pila)", "Ver tope", "Procesar (desapilar)", "Estado", "Volver"};
        int op = JOptionPane.showOptionDialog(
                this,
                "Seleccione una acción:",
                "Centro de Reciclaje (Pila LIFO)",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (op == 0) {
            String id = pedirTextoNoVacio("ID del residuo a recolectar:");
            if (id == null) return;
            boolean ok = sistema.recolectarResiduo(id);
            JOptionPane.showMessageDialog(
                    this,
                    ok ? "Residuo enviado al centro (pila)." : "No existe ese residuo.",
                    ok ? "OK" : "Error",
                    ok ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE
            );
        } else if (op == 1) {
            try {
                Object tope = sistema.getResiduosParaProcesar().verTope();
                JOptionPane.showMessageDialog(this, tope.toString(), "Tope", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "La pila está vacía.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (op == 2) {
            try {
                Object proc = sistema.getResiduosParaProcesar().desapilarResiduo();
                JOptionPane.showMessageDialog(this, "Procesado:\n" + proc.toString(), "OK", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "La pila está vacía.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (op == 3) {
            JOptionPane.showMessageDialog(
                    this,
                    "En pila: " + sistema.getResiduosParaProcesar().size(),
                    "Estado",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    private void uiEstadisticasYOrdenamiento() {
        Estadisticas est = sistema.getEstadisticas();

        StringBuilder sb = new StringBuilder();
        sb.append("Peso total por tipo:\n");
        for (Map.Entry<String, Double> e : est.obtenerPesoTotalPorTipo().entrySet()) {
            sb.append("- ").append(e.getKey()).append(": ").append(String.format("%.2f", e.getValue())).append(" kg\n");
        }
        sb.append("\nZona con más residuos: ").append(est.zonaConMasResiduos()).append("\n");

        Object[] criterios = {"Prioridad ambiental", "Peso", "Tipo"};
        Object elegido = JOptionPane.showInputDialog(
                this,
                sb.toString() + "\nSeleccione criterio para ordenar y mostrar residuos:",
                "Estadísticas y Ordenamiento",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                criterios,
                criterios[0]
        );

        if (elegido == null) return;

        Comparator<Residuo> comp;
        if ("Peso".equals(elegido)) comp = new ComparadorPeso();
        else if ("Tipo".equals(elegido)) comp = new ComparadorTipo();
        else comp = new ComparadorPrioridad();

        sistema.setComparadorActivo(comp);
        String listadoOrdenado = obtenerListadoResiduosOrdenado(comp);

        JTextArea area = new JTextArea(listadoOrdenado);
        area.setEditable(false);
        area.setFont(new Font("Consolas", Font.PLAIN, 12));
        JScrollPane sp = new JScrollPane(area);
        sp.setPreferredSize(new Dimension(640, 320));

        JOptionPane.showMessageDialog(this, sp, "Residuos ordenados", JOptionPane.INFORMATION_MESSAGE);
    }

    private String obtenerListadoResiduosOrdenado(Comparator<Residuo> comp) {
        ArrayList<Residuo> aux = new ArrayList<>();
        CircularDoublyLinkedList<Residuo> base = obtenerListaBase();
        int n = base.size();
        for (int i = 0; i < n; i++) aux.addLast(base.get(i));

        for (int i = 0; i < aux.size(); i++) {
            for (int j = 0; j < aux.size() - 1; j++) {
                Residuo a = aux.get(j);
                Residuo b = aux.get(j + 1);
                if (comp.compare(a, b) > 0) {
                    aux.set(j, b);
                    aux.set(j + 1, a);
                }
            }
        }

        if (aux.isEmpty()) return "(Sin residuos)";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aux.size(); i++) {
            Residuo r = aux.get(i);
            sb.append(i + 1).append(") ").append(r.toString())
              .append(" | Zona: ").append(r.getZona())
              .append(" | Fecha: ").append(r.getFechaRecoleccion())
              .append("\n");
        }
        return sb.toString();
    }

    private CircularDoublyLinkedList<Residuo> obtenerListaBase() {
        CircularDoublyLinkedList<Residuo> copia = new CircularDoublyLinkedList<>();
        IteradorResiduos<Residuo> it = sistema.getListaResiduos().iterador();
        int n = sistema.getListaResiduos().size();
        for (int i = 0; i < n; i++) copia.addLast(it.next());
        return copia;
    }

    private void uiGuardar() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Guardar estado del sistema");
        int r = fc.showSaveDialog(this);
        if (r != JFileChooser.APPROVE_OPTION) return;

        File f = fc.getSelectedFile();
        try {
            sistema.guardarEstado(f.getAbsolutePath());
            JOptionPane.showMessageDialog(this, "Guardado en: " + f.getName(), "OK", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void uiCargar() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Cargar estado del sistema");
        int r = fc.showOpenDialog(this);
        if (r != JFileChooser.APPROVE_OPTION) return;

        File f = fc.getSelectedFile();
        try {
            this.sistema = Sistema.cargarEstado(f.getAbsolutePath());
            JOptionPane.showMessageDialog(this, "Cargado: " + f.getName(), "OK", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void intentarGuardarAlSalir() {
        if (Sesion.getRol() != Rol.ADMIN) return;

        int op = JOptionPane.showConfirmDialog(
                this,
                "¿Desea guardar el estado del sistema antes de salir?",
                "Guardar",
                JOptionPane.YES_NO_OPTION
        );
        if (op == JOptionPane.YES_OPTION) uiGuardar();
    }

    private String pedirTextoNoVacio(String prompt) {
        String s = JOptionPane.showInputDialog(this, prompt);
        if (s == null) return null;
        s = s.trim();
        if (s.isEmpty()) return null;
        return s;
    }

    private Double pedirDouble(String prompt) {
        String s = JOptionPane.showInputDialog(this, prompt);
        if (s == null) return null;
        try {
            return Double.parseDouble(s.trim());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Número inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private Integer pedirEntero(String prompt) {
        String s = JOptionPane.showInputDialog(this, prompt);
        if (s == null) return null;
        try {
            return Integer.parseInt(s.trim());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Número inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private void cerrarSesion() {
        Sesion.cerrarSesion();
        new LoginFrame().setVisible(true);
        dispose();
    }
}
