package edu.fiuba.algo3.modelo.tipoTarjeta;

public class Comodin implements TipoTarjeta{

    private final String nombre;

    public Comodin(){
        this.nombre = "Comodin";
    }

    public String obtenerNombre(){return nombre;}

    @Override
    public boolean esBarco() {
        return true;
    }
    @Override
    public boolean esCanion() {
        return true;
    }
    @Override
    public boolean esGlobo() {
        return true;
    }


    @Override
    public boolean esIgual(TipoTarjeta unTipo) {
        return true;
    }
}
