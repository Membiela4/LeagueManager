package com.example.leaguemanager2.test;

import com.example.leaguemanager2.dao.TeamDAO;
import com.example.leaguemanager2.modelDomain.Team;
import com.example.leaguemanager2.utils.Connect;

import java.io.*;
import java.sql.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class Test4 {


        public static void main(String[] args) {

            Connection conexion;
            conexion= Connect.getConnect();
            PreparedStatement consulta = null;

            try {

                // Leer la imagen
                File imagenArchivo = new File("C:\\Users\\david\\OneDrive\\Escritorio\\Programacion\\LeagueManager\\src\\main\\resources\\com\\example\\leaguemanager2\\images\\iconoEquipo.png");
                InputStream imagenStream = new FileInputStream(imagenArchivo);
                byte[] imagenBytes = new byte[(int) imagenArchivo.length()];
                imagenStream.read(imagenBytes);
                imagenStream.close();

                // Crear un objeto Blob
                Blob imagenBlob = conexion.createBlob();

                // Escribir los datos de la imagen en el objeto Blob
                OutputStream imagenOut = imagenBlob.setBinaryStream(1);
                imagenOut.write(imagenBytes);
                imagenOut.close();

                // Preparar la consulta SQL
                consulta = conexion.prepareStatement("INSERT INTO team (team_name,abbreviation,icon,num_players) VALUES (?,?,?,?)");
                consulta.setBlob(3, imagenBlob);
                consulta.setString(1, "Valencia");
                consulta.setString(2,"VAL");
                consulta.setInt(4,0);

                // Ejecutar la consulta SQL
                consulta.executeUpdate();

                System.out.println("La imagen se ha guardado correctamente en la base de datos.");

            } catch (SQLException e) {
                System.out.println("Error al conectarse a la base de datos: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error al leer o escribir la imagen: " + e.getMessage());
            } finally {
                try {
                    if (consulta != null) {
                        consulta.close();
                    }
                    if (conexion != null) {
                        conexion.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }


