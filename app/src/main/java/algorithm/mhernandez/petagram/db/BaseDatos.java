package algorithm.mhernandez.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import algorithm.mhernandez.petagram.pojo.Mascota;

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaContacto = " CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER" +
                ")";

        String queryCrearTablaRating = " CREATE TABLE " + ConstantesBaseDatos.TABLE_RATING + "(" +
                ConstantesBaseDatos.TABLE_RATING_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_RATING_ID_MASCOTA + " INTEGER , " +
                ConstantesBaseDatos.TABLE_RATING_LIKES + " INTEGER ," +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_RATING_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaRating);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_RATING);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryRaiting = "SELECT COUNT("+ConstantesBaseDatos.TABLE_RATING_LIKES+")" +
                    " FROM " + ConstantesBaseDatos.TABLE_RATING +
                    " WHERE " + ConstantesBaseDatos.TABLE_RATING_ID_MASCOTA + "=" + mascotaActual.getId();
            Cursor registrosLike = db.rawQuery(queryRaiting, null);

            if (registrosLike.moveToNext()) {
                mascotaActual.setRaiting(registrosLike.getInt(0));
            }else{
                mascotaActual.setRaiting(0);
            }

            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_RATING, null, contentValues);
        db.close();
    }

    public int obtenerRaitingMascota(Mascota mascota) {
        int raiting = 0;
        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_RATING_LIKES + ")" +
                " FROM " + ConstantesBaseDatos.TABLE_RATING +
                " WHERE " + ConstantesBaseDatos.TABLE_RATING_ID_MASCOTA + "=" + mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()) {
            raiting = registros.getInt(0);
        }

        db.close();

        return raiting;
    }
}
