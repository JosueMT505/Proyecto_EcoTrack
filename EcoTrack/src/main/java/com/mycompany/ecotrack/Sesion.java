/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ecotrack;

public class Sesion {
    private static String usuario;
    private static Rol rol;

    public static void iniciarSesion(String user, Rol r) {
        usuario = user;
        rol = r;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static Rol getRol() {
        return rol;
    }

    public static void cerrarSesion() {
        usuario = null;
        rol = null;
    }
}
