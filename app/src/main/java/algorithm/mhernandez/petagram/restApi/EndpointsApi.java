package algorithm.mhernandez.petagram.restApi;

import algorithm.mhernandez.petagram.pojo.Perfil;
import algorithm.mhernandez.petagram.restApi.model.PerfilResponse;
import algorithm.mhernandez.petagram.restApi.model.UsuarioResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EndpointsApi {

    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_ID_TOKEN)
    Call<UsuarioResponse> registrarTokenID(@Field("token") String token, @Field("iduser") String iduser);


    /*
    @GET(ConstantesRestApi.URL_MEDIA_ID)
    Call<PerfilResponse> getMediaId();

    @GET(ConstantesRestApi.URL_MEDIA_USER)
    Call<PerfilResponse> getMediaUser();
    */
}

