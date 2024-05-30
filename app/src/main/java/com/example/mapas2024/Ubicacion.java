package com.example.mapas2024;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Ubicacion extends AppCompatActivity {

    private TextView vRegistros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion2);

        vRegistros = findViewById(R.id.activity_tvubicaciones);
        mostrarUbicaciones();
    }

    private void mostrarUbicaciones() {
        SqlLocalizacion lugar = new SqlLocalizacion(this, "ubicaciones", null, 1);
        SQLiteDatabase db = lugar.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM ubicaciones", null);

        if (c.moveToFirst()) {
            do {
                int id = c.getInt(0);
                String calle = c.getString(1);
                double latitud = c.getDouble(2);
                double longitud = c.getDouble(3);

                vRegistros.append("ID: " + id + "\n" +
                        "Direccion: " + calle + "\n" +
                        "Latitud: " + latitud + "\n" +
                        "Longitud: " + longitud + "\n\n\n");
            } while (c.moveToNext());
        }

        c.close();
        db.close();
    }
}
