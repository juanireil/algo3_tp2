package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.canje.Canje;
import edu.fiuba.algo3.modelo.canje.PrimerCanje;
import edu.fiuba.algo3.modelo.objetivo.Objetivo;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Jugador {
    private final Ficha ficha;
    private final MazoTarjetasPais listaTarjetas;
    private Canje canje;
    private String nombre;
    private String nombreColor;
    private Objetivo objetivoJugador;

    public Jugador() {

        this.ficha = new Ficha();
        this.listaTarjetas = new MazoTarjetasPais();
        this.canje = new PrimerCanje();
    }

    public void agregarTarjeta(TarjetaPais unaTarjeta) {
        listaTarjetas.agregarTarjeta(unaTarjeta);
    }

    public void colocarEjercitosEn(Integer unaCantidadDeEjercitos, Pais unPais) {
        unPais.colocarEjercitos(unaCantidadDeEjercitos, this.ficha);
    }

    public void establecerObjetivo(Objetivo unObj){
        this.objetivoJugador = unObj;
    }

    public Ficha obtenerFicha() {
        return this.ficha;
    }

    public void colocarEjercitosCanje(Integer cantidadDeEjercitos, Pais pais) {
        pais.colocarEjercitos(cantidadDeEjercitos, this.obtenerFicha());
    }

    public int canjearTarjetas(ArrayList<TarjetaPais> tarjetas) {
        int ejercitosAgregar;
        ejercitosAgregar = canje.realizarCanje(tarjetas);
        this.canje = this.canje.actualizarCanje();
        return ejercitosAgregar;
    }

    public ArrayList<TarjetaPais> ocuparPaises() {
        ArrayList<TarjetaPais> tarjetas = this.listaTarjetas.obtenerTarjetas();
        this.listaTarjetas.vaciar();
        for (TarjetaPais tarjeta : tarjetas) {
            tarjeta.obtenerPais().asignarJugador(this);
        }
        return tarjetas;
    }
    public TarjetaPais obtenerTarjeta(String nombreTarjeta){
        return this.listaTarjetas.obtenerTarjeta(nombreTarjeta);
    }
    public void activarTarjetaPais(TarjetaPais unaTarjetaPais) {
        unaTarjetaPais.activarTarjeta(this);
    }

    public boolean tieneFicha(Ficha unaficha) {
        return this.ficha.esIgualA(unaficha);
    }

    public ArrayList<TarjetaPais> obtenerTarjetas() {
        return listaTarjetas.obtenerTarjetas();
    }

    public void establecerNombre(String nombre) {
        this.nombre = nombre;
    }

    public final void establecerColorFicha(Color unColor) {

        this.ficha.establecerColor(unColor);
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public void nombreColor(String unColor) {
        this.nombreColor = unColor;
    }

    public String color() {
        return this.nombreColor;
    }

    public Objetivo objetivo(){
        return this.objetivoJugador;
    }

    public boolean objetivoCumplido() {
        return this.objetivoJugador.estaCumplido();
    }
}
