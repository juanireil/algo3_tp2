package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class VistaInicial extends VBox{
    public VistaInicial() {
        super();
        Label labelArchivo = new Label("Bienvenido a A.L.T.E.G.O.");
        labelArchivo.setFont(new Font("Arial", 18));
        labelArchivo.setTextFill(Color.web("#ffd700"));

        Image logo = new Image("file:" + "multimedia/logoTEG.jpg", 200, 200, true, true);
        ImageView imagenVista = new ImageView(logo);

        TextField texto = new TextField();
        texto.setPromptText("Ingrese la cantidad de jugadores");

        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        botonJugar.setStyle("-fx-background-color:#27AE60;" +
                "-fx-font-size: 18;" +
                "-fx-font-famiy: sans-serif;"
        );
        botonJugar.setOnAction(actionEvent -> {
            Juego juego = new Juego(Integer.parseInt(texto.getText()));
            juego.iniciarJuego();
            System.out.println(juego.obtenerPaises());
        });

        HBox contenedorHorizontal = new HBox(botonJugar);
        contenedorHorizontal.setAlignment(Pos.CENTER);

        VBox contenedorPrincipal = new VBox(labelArchivo, imagenVista, texto, contenedorHorizontal);
        contenedorPrincipal.setSpacing(30);
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.setPadding(new Insets(25));
        contenedorPrincipal.setStyle("-fx-background-color:#504d4c");
        this.getChildren().add(contenedorPrincipal);

    }
}