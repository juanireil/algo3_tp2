package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.MostrarObjetivosEventHandler;
import edu.fiuba.algo3.controlador.PaisAtacanteEventHandler;
import edu.fiuba.algo3.controlador.ReagruparEventHandler;
import edu.fiuba.algo3.modelo.Juego;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.HashMap;

public class VistaEtapaAtaque extends StackPane {
    private final SeleccionarVista vista;
    private Label jugadorActual;
    private Label proximoJugador;
    private Label informacion;
    private VistaPais paisAtacante = null;

    public VistaEtapaAtaque(Mapa mapa, String nombreJugadorActual, String nombreSiguienteJugador, String colorJugadorActual, Juego juego, SeleccionarVista seleccionarVista){
        this.vista = seleccionarVista;
        HBox datosTurno = this.datosTurno(nombreJugadorActual, nombreSiguienteJugador, colorJugadorActual);
        HBox contenedorBotones2 = this.botonesTurno(juego);
        BorderPane contenedor = new BorderPane();
        contenedor.setTop(datosTurno);
        contenedor.setBottom(contenedorBotones2);
        contenedor.setLayoutY(10);
        BorderPane.setMargin(datosTurno, new Insets(0, 0, 0, 300));
        BorderPane.setMargin(contenedorBotones2, new Insets(0, 0, 0, 370));

        HashMap<String, VistaPais> paises = mapa.obtenerPaises();
        for(String nombre: paises.keySet()){
            VistaPais pais = paises.get(nombre);
            PaisAtacanteEventHandler paisAtacanteEventHandler = new PaisAtacanteEventHandler(pais, this, juego);
            pais.setOnMouseClicked(paisAtacanteEventHandler);
            contenedor.getChildren().add(pais);
        }

        ObservableList lista = this.getChildren();
        lista.addAll(mapa, contenedor);
        this.setStyle("-fx-background-color: #504d4c");
        setMargin(mapa, new Insets(15,0,0,55));
    }

    private HBox botonesTurno(Juego juego) {
        Button botonReagrupar = new Button();
        botonReagrupar.setText("Reagrupar");
        botonReagrupar.setStyle(new CargarEstiloBotones("#FFC300").ObtenerEstilo());
        ReagruparEventHandler reagruparEventHandler = new ReagruparEventHandler(juego, this.vista);
        botonReagrupar.setOnAction(reagruparEventHandler);
        Button botonObjetivo = new Button();
        botonObjetivo.setText("Ver Objetivo");
        botonObjetivo.setStyle(new CargarEstiloBotones("#229954").ObtenerEstilo());
        MostrarObjetivosEventHandler mostrarObjetivosEventHandler = new MostrarObjetivosEventHandler(vista, juego);
        botonObjetivo.setOnAction(mostrarObjetivosEventHandler);
        HBox contenedor = new HBox(botonReagrupar, botonObjetivo);
        contenedor.setSpacing(20);
        return contenedor;
    }


    private HBox datosTurno(String nombreJugadorActual, String nombreSiguienteJugador, String colorJugadorActual) {

        Label informacion = new Label();
        informacion.setText("Seleccione el pais con el que va a atacar");
        informacion.setTextFill(Color.WHITE);

        Label datoJugador = new Label();
        datoJugador.setText("Jugador:"+ nombreJugadorActual);
        datoJugador.setTextFill(Color.WHITE);

        Label datColor = new Label();
        datColor.setText("Color:"+ colorJugadorActual);
        datColor.setTextFill(Color.WHITE);

        Label proximoJugador = new Label();
        proximoJugador.setText("Siguiente jugador:"+ nombreSiguienteJugador);
        proximoJugador.setTextFill(Color.WHITE);

        this.jugadorActual = datoJugador;
        this.proximoJugador = proximoJugador;
        this.informacion = informacion;
        HBox datosTurno = new HBox(informacion, datoJugador, datColor, proximoJugador);
        datosTurno.setSpacing(20);
        return datosTurno;
    }

    public void paisAtacanteElegido(VistaPais pais){
        this.informacion.setText("PAIS ATACANTE ELEGIDO ELIGE AL QUE QUIERE ATACAR");
        this.paisAtacante = pais;
    }
    public VistaPais obtenerPaisAtacante(){
        return this.paisAtacante;
    }

    public void ataqueRealizado(){
        informacion.setText("Seleccione el pais con el que va a atacar");
        paisAtacante = null;
    }

}
