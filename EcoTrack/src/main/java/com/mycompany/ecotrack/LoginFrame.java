package com.mycompany.ecotrack;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginFrame() {
        setTitle("EcoTrack | Login");
        setSize(520, 360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 248, 250));
        panel.setLayout(null);
        add(panel);

        JLabel lblTitulo = new JLabel("EcoTrack", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblTitulo.setForeground(new Color(46, 125, 50));
        lblTitulo.setBounds(0, 25, 520, 40);
        panel.add(lblTitulo);

        JLabel lblSub = new JLabel("Gestión de Residuos", SwingConstants.CENTER);
        lblSub.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSub.setBounds(0, 65, 520, 25);
        panel.add(lblSub);

        JLabel lblUser = new JLabel("Usuario:");
        lblUser.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblUser.setBounds(110, 120, 100, 25);
        panel.add(lblUser);

        txtUsuario = new JTextField();
        txtUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtUsuario.setBounds(210, 120, 200, 32);
        panel.add(txtUsuario);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblPass.setBounds(110, 170, 100, 25);
        panel.add(lblPass);

        txtPassword = new JPasswordField();
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtPassword.setBounds(210, 170, 200, 32);
        panel.add(txtPassword);

        btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnLogin.setBounds(170, 235, 200, 42);
        btnLogin.setBackground(new Color(76, 175, 80));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        panel.add(btnLogin);

        btnLogin.addActionListener(e -> login());
    }

    private void login() {
        String user = txtUsuario.getText();
        String pass = new String(txtPassword.getPassword());

        if (user.equals("admin") && pass.equals("admin")) {
            Sesion.iniciarSesion("admin", Rol.ADMIN);
        } else if (user.equals("operador") && pass.equals("123")) {
            Sesion.iniciarSesion("operador", Rol.OPERADOR);
        } else if (user.equals("supervisor") && pass.equals("456")) {
            Sesion.iniciarSesion("supervisor", Rol.SUPERVISOR);
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Usuario o contraseña incorrectos",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        Sistema sistema = new Sistema(); // modelo compartido con la UI
        new MainFrame(sistema).setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}
