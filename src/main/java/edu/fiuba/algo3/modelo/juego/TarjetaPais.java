package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.exception.ExcepcionActivacionTarjetaInvalido;
import edu.fiuba.algo3.modelo.tipoTarjeta.TipoTarjeta;

public class TarjetaPais {

    private final TipoTarjeta tipo;
    private final Pais pais;
    private boolean estaActivada;

    public TarjetaPais(TipoTarjeta unTipo, String unPais) {
        this.pais = new Pais(unPais);
        this.tipo = unTipo;
        this.estaActivada = false;
    }
    public TipoTarjeta obtenerTipo(){ return  this.tipo;}

    public Pais obtenerPais(){
        return this.pais;
    }

    public boolean esDelMismoTipo(TarjetaPais unaTarjeta){
        return (this.tipo.esIgual(unaTarjeta.obtenerTipo()));
    }

    public boolean paisEsDe(Jugador unJugador){
        return (this.pais.obtenerFicha().esIgualA(unJugador.obtenerFicha()));
    }

    public void activarTarjeta(Jugador jugador){
        if (this.obtenerPais().obtenerFicha().esIgualA(jugador.obtenerFicha()) && (!this.estaActivada)){
            jugador.colocarEjercitosEn(2,this.obtenerPais());
            this.estaActivada = true;
        }
        else{
            throw new ExcepcionActivacionTarjetaInvalido("El pais no esta en posesion del jugador o la tarjeta ya fue activada");
        }
    }
}
