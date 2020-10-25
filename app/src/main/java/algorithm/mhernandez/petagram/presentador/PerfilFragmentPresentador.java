package algorithm.mhernandez.petagram.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import algorithm.mhernandez.petagram.db.ConstructorPerfil;
import algorithm.mhernandez.petagram.fragment.IPerfilFragment;
import algorithm.mhernandez.petagram.pojo.Perfil;

public class PerfilFragmentPresentador implements IPerfilFragmentPresentador{
    private IPerfilFragment iPerfilFragment;
    private Context context;
    private ConstructorPerfil constructorPerfil;
    private ArrayList<Perfil> perfils;

    public PerfilFragmentPresentador(IPerfilFragment iPerfilFragment, Context context) {
        this.iPerfilFragment = iPerfilFragment;
        this.context = context;
        obtenerDatosBD();
        //obtenerPerfilMedios();
        mostrarDatosRV();
    }

    @Override
    public void obtenerDatosBD() {
        constructorPerfil = new ConstructorPerfil(context);
        perfils = constructorPerfil.ObtenerDatos();
        mostrarDatosRV();
    }
    /*
    @Override
    public void obtenerPerfilMedios() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMedia = restApiAdapter.ConstruyeGsonDesererializadorMedia();
        EndPointsApi endPointsApi = restApiAdapter.establecerConexionApiInstagram(gsonMedia);
        Call<PerfilMediaResponse> perfilMediaResponseCall = endPointsApi.getPerfilMedia();

        perfilMediaResponseCall.enqueue(new Callback<PerfilMediaResponse>() {
            @Override
            public void onResponse(Call<PerfilMediaResponse> call, Response<PerfilMediaResponse> response) {
                PerfilMediaResponse perfilMediaResponse = response.body();
                perfils = perfilMediaResponse.getPerfilMedia();
            }

            @Override
            public void onFailure(Call<PerfilMediaResponse> call, Throwable t) {
                Toast.makeText(context,"Fallo conexion",Toast.LENGTH_SHORT).show();
                Log.e("Fallo la conexion", t.toString());
            }
        });
    }
     */
    /*
    @Override
    public void obtenerIdMedios() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndPointsApi endPointsApi = restApiAdapter.establecerConexionApiInstagram();
        Call<PerfilMediaResponse> perfilMediaResponseCall = endPointsApi.getPerfilMedia();

        perfilMediaResponseCall.enqueue(new Callback<PerfilMediaResponse>() {
            @Override
            public void onResponse(Call<PerfilMediaResponse> call, Response<PerfilMediaResponse> response) {
                PerfilMediaResponse perfilMediaResponse = response.body();
                perfils = perfilMediaResponse.getPerfilMedia();
            }

            @Override
            public void onFailure(Call<PerfilMediaResponse> call, Throwable t) {
                Toast.makeText(context,"Fallo conexion",Toast.LENGTH_SHORT).show();
                Log.e("Fallo la conexion", t.toString());
            }
        });
    }
     */

    @Override
    public void mostrarDatosRV() {
        iPerfilFragment.inicializarAdaptadorPerfil(iPerfilFragment.crearAdaptadorPerfil(perfils));
        iPerfilFragment.generarGridLayout();
    }
}
