package com.example.tlenguajes2023.configuracion;

public class ConfigDB
{
    // Configuracion de los parametros de la base de datos local en sqlite
    //Nombre de la base de datos
    public static final String namebd = "DBTLeng";

    // Tablas de las bases de datos
    public static final String tblpersonas = "PERSONAS";

    // Campos de la tabla personas
    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";
    public static final String genero = "genero";
    public static final String direccion = "direccion";
    public static final String edad = "edad";
    public static final String correo = "correo";

    // Creacion de objetos DDL - CREATE - DROP - ALTER
    public static final String CreateTBPesonas = "CREATE TABLE PERSONAS (id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT," +
            "apellidos TEXT, genero TEXT, direccion TEXT, edad INTEGER, correo TEXT)";

    public static final String DropTBPersonas = "DROP TABLE IF EXISTS PERSONAS";

    // Creacion de objetos DML para poder seleccionar informacion de la base de datos
    public static final String SelectTBPersonas = "SELECT * FROM " + ConfigDB.tblpersonas;

    public static final String Empty = "";

}
