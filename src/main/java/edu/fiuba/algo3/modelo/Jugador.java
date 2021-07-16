package edu.fiuba.algo3.modelo;

public class Jugador {
    private final Ficha ficha;
    private final MazoTarjetasPais listaTarjetas;

    public Jugador(){
        this.ficha = new Ficha();
        this.listaTarjetas = new MazoTarjetasPais();
    }

    public void obtenerTarjeta(TarjetaPais unaTarjeta){
        listaTarjetas.agregarTarjeta(unaTarjeta);
    }

    public void colocarEjercitosEn(Integer unaCantidadDeEjercitos, Pais unPais){
        unPais.colocarEjercitos(unaCantidadDeEjercitos, this.ficha);
    }
    public Ficha obtenerFicha(){
        return this.ficha;
    }

}
