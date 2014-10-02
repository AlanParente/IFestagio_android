package com.example.estagio;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;


public abstract class ConnectionPost {
	private static final String DATABASE_URL = "jdbc:postgresql://localhost/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "ifestagio";
    
    public ConnectionPost getConnection() {
        ConnectionPost con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con =  (ConnectionPost) DriverManager.getConnection(DATABASE_URL, USERNAME,
                    PASSWORD);
        } catch (Exception e) {
            System.out.println("Não foi possível se conectar ao banco.");
            e.printStackTrace();
        }
        return con;
       }

       public void closeConnection(Connection conn, Statement stat, ResultSet resul) {
        try {
            close(conn, stat, resul);
        } catch (Exception e) {
            System.out.println("Não foi possível se encerrar conexão com o banco.");
            e.printStackTrace();
        }
       }

       public void closeConnection(ConnectionPost conec, Statement stat) {
        try {
            close((Connection) conec, stat, null);
        } catch (Exception e) {
            System.out.println("Não foi possível se encerrar conexão com o banco.");
            e.printStackTrace();
        }
       }

       public void closeConnection(ConnectionPost conec) {
        try {
            close((Connection) conec, null, null);
        } catch (Exception e) {
            System.out.println("Não foi possível se encerrar conexão com o banco.");
            e.printStackTrace();
        }
       }

       private void close(Connection conn, Statement stat, ResultSet resul) {

        try {
            if (resul != null) {
            	resul.close();
            }
            if (stat != null) {
            	stat.close();
            }
            if (conn != null) {
            	conn.close();
            }
        } catch (Exception e) {
            System.out.println("Não foi possível se encerrar conexão com o banco.");
            e.printStackTrace();
        }
       }


}
