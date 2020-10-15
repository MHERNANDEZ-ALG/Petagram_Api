package algorithm.mhernandez.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import algorithm.mhernandez.petagram.R;
import algorithm.mhernandez.petagram.pojo.Mascota;

public class ContructorMascotas {
    private static final int LIKE = 1;
    Context context;

    public ContructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> ObtenerDatos() {

        BaseDatos db = new BaseDatos(context);
        insertarVariosDatos(db);
        return db.obtenerTodasLasMascotas();
    }

    public void insertarVariosDatos(BaseDatos db) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Anna");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.anna_gato);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Aron");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.aron_perro);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Dante");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dante_perro);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Droid");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.droid_gato);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Shen");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.shen_perro);
        db.insertarMascota(contentValues);
    }

    public void raitearMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_RATING_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_RATING_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerRaitingMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerRaitingMascota(mascota);
    }

}
