package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.exception.ExcepcionPaisInvalido;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;

import static org.junit.jupiter.api.Assertions.*;

public class ColocarEjercitosEnPaisesTest {
    @Test
    public void test01JugadorColocaUnEjercitoEnPaisPropio(){
        Jugador unJugador = new Jugador();
        Pais unPais = new Pais("argentina");
        unPais.asignarJugador(unJugador);

        unJugador.colocarEjercitosEn(3, unPais);

        assertEquals(4, unPais.cantidadDeEjercitos());
    }
    @Test
    public void test02JugadorColocaUnEjercitoEnPaisPropioFichaEsLaCorrecta(){
        Jugador unJugador = new Jugador();
        Pais unPais = new Pais("argentina");
        unPais.asignarJugador(unJugador);

        unJugador.colocarEjercitosEn(3, unPais);

        assertEquals(unJugador.obtenerFicha(), unPais.obtenerFicha());
    }
    @Test
    public void test03JugadorColocaUnEjercitoEnPaisOcupadoPorOtroJugador(){
        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();
        Pais unPais = new Pais("argentina");
        unPais.asignarJugador(unJugador);

        unJugador.colocarEjercitosEn(3, unPais);

        assertThrows(ExcepcionPaisInvalido.class,()-> otroJugador.colocarEjercitosEn(2, unPais));
    }
    @Test
    public void test04JugadorColocaEjercitoEnPaisOcupadoPorOtroFichaEsLaCorrecta(){
        Jugador unJugador = new Jugador();

        Pais unPais = new Pais("argentina");
        unPais.asignarJugador(unJugador);

        unJugador.colocarEjercitosEn(3, unPais);

        assertEquals(unJugador.obtenerFicha(), unPais.obtenerFicha());

    }
    @Test
    public void test05JugadorColocaEjercitosEnPaisPropioVariasVecesCantidadDeFichasEsLaCorrecta(){
        Jugador unJugador = new Jugador();
        Pais unPais = new Pais("argentina");
        unPais.asignarJugador(unJugador);

        unJugador.colocarEjercitosEn(3, unPais);
        unJugador.colocarEjercitosEn(2, unPais);
        unJugador.colocarEjercitosEn(1, unPais);

        assertEquals(7, unPais.cantidadDeEjercitos());
    }
}
