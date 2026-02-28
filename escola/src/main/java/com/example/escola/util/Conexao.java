package com.example.escola.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {


    private static String URL = "jdbc:mysql://localhost:3306/escola";

    private static String USER = "root";

    private static String SENHA = "";


    public static Connection conectar() throws SQLException {

        return DriverManager.getConnection(URL, USER, SENHA);


    }
}
