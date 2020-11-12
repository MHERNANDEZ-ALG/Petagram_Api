package algorithm.mhernandez.petagram.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import algorithm.mhernandez.petagram.restApi.ConstantesRestApi;
import algorithm.mhernandez.petagram.restApi.EndpointsApi;
import algorithm.mhernandez.petagram.restApi.deserializador.PerfilDeserializador;
import algorithm.mhernandez.petagram.restApi.model.PerfilResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {
    public EndpointsApi establecerConexionRestApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(EndpointsApi.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PerfilResponse.class, new PerfilDeserializador());
        return gsonBuilder.create();
    }
}
