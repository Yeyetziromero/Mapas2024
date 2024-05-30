package com.example.mapas2024;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlLocalizacion extends SQLiteOpenHelper {

    // Define la creación de la tabla en una cadena separada para mayor claridad
    private static final String CREATE_TABLE = "CREATE TABLE ubicaciones (id INTEGER PRIMARY KEY AUTOINCREMENT, calle TEXT, latitud REAL, longitud REAL)";

    public SqlLocalizacion(Context contexto) {
        // Cambia el nombre de la base de datos a "Direcciones" y la versión a 1
        super(contexto, "Direcciones", null, 1);
    }

    public SqlLocalizacion(Ubicacion contexto, String ubicaciones, Object o, int i) {
        super(contexto, "ubicaciones", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Ejecuta la creación de la tabla cuando se crea la base de datos
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Implementa la actualización de la base de datos si es necesario
        // Aquí simplemente se elimina la tabla anterior y se crea una nueva
        db.execSQL("DROP TABLE IF EXISTS ubicaciones");
        onCreate(db);
    }
}
