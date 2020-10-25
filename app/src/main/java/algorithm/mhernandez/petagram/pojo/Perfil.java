package algorithm.mhernandez.petagram.pojo;

public class Perfil {
    private String id;
    private String nombre;
    private String urlfoto;
    private int foto;
    private int raiting;

    public Perfil(int raiting, int foto){
        //this.nombre    = nombre;
        this.foto   = foto;
        this.raiting = raiting;
    }

    public Perfil() {

    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }
}