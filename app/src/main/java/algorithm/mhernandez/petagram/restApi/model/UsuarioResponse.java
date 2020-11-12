package algorithm.mhernandez.petagram.restApi.model;

public class UsuarioResponse {
    private String id;
    private String token;
    private String iduser = "_artattic_";

    public UsuarioResponse(String id, String token, String iduser){
        this.id = id;
        this.token = token;
        this.iduser = iduser;
    }

    public UsuarioResponse() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }
}
