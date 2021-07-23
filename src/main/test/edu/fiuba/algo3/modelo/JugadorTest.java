package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.exception.ExcepcionActivacionTarjetaInvalido;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Pais;
import edu.fiuba.algo3.modelo.juego.TarjetaPais;
import edu.fiuba.algo3.modelo.tipoTarjeta.Canion;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    @Test
    public void test01CreoDosJugadoresYTienenFichasDistintas(){
        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();
    
        assertNotEquals(unJugador.obtenerFicha(), otroJugador.obtenerFicha());
        assertFalse(unJugador.obtenerFicha().esIgualA(otroJugador.obtenerFicha()));
    }

    @Test
    public void test02ActivarTarjetaPaisCorrectamente()throws ExcepcionActivacionTarjetaInvalido{
        Jugador unJugador = new Jugador();
        TarjetaPais tarjetaPais = new TarjetaPais(new Canion(), "Brasil");

        tarjetaPais.obtenerPais().asignarJugador(unJugador);
        tarjetaPais.activarTarjeta(unJugador);

        assertEquals(3,tarjetaPais.obtenerPais().cantidadDeEjercitos());
    }
    @Test
    public void test03ActivarTarjetaDePaisQueNoSePosee(){
        Jugador unJugador = new Jugador();
        Jugador otroJugador = new Jugador();
        TarjetaPais tarjetaPais = new TarjetaPais(new Canion(), "Brasil");

        tarjetaPais.obtenerPais().asignarJugador(otroJugador);

        assertThrows(ExcepcionActivacionTarjetaInvalido.class, () -> {tarjetaPais.activarTarjeta(unJugador);});
    }

    @Test
    public void test04ActivarTarjetaDePaisYaActivada()throws ExcepcionActivacionTarjetaInvalido{
        Jugador unJugador = new Jugador();
        TarjetaPais tarjetaPais = new TarjetaPais(new Canion(), "Brasil");

        tarjetaPais.obtenerPais().asignarJugador(unJugador);
        tarjetaPais.activarTarjeta(unJugador);

        assertThrows(ExcepcionActivacionTarjetaInvalido.class, () -> {tarjetaPais.activarTarjeta(unJugador);});
    }
    @Test
    public void test05JugadorHacePrimerCanjeYRecibeCuatroEjercitos(){
        ArrayList<TarjetaPais> tarjetasCanje = new ArrayList<TarjetaPais>();
        Jugador unJugador = new Jugador();
        TarjetaPais tarjetaPais1 = new TarjetaPais(new Canion(), "Brasil");
        TarjetaPais tarjetaPais2 = new TarjetaPais(new Canion(), "Inglaterra");
        TarjetaPais tarjetaPais3 = new TarjetaPais(new Canion(), "España");
        unJugador.obtenerTarjeta(tarjetaPais1);
        unJugador.obtenerTarjeta(tarjetaPais2);
        unJugador.obtenerTarjeta(tarjetaPais3);
        assertEquals(4,unJugador.realizarCanje(tarjetasCanje));
    }
    @Test
    public void test06JugadorHaceSegundoCanjeYRecibeSieteEjercitos(){
        ArrayList<TarjetaPais> tarjetasCanje = new ArrayList<TarjetaPais>();
        Jugador unJugador = new Jugador();
        TarjetaPais tarjetaPais1 = new TarjetaPais(new Canion(), "Brasil");
        TarjetaPais tarjetaPais2 = new TarjetaPais(new Canion(), "Inglaterra");
        TarjetaPais tarjetaPais3 = new TarjetaPais(new Canion(), "España");
        unJugador.obtenerTarjeta(tarjetaPais1);
        unJugador.obtenerTarjeta(tarjetaPais2);
        unJugador.obtenerTarjeta(tarjetaPais3);
        unJugador.realizarCanje(tarjetasCanje);
        unJugador.obtenerTarjeta(tarjetaPais1);
        unJugador.obtenerTarjeta(tarjetaPais2);
        unJugador.obtenerTarjeta(tarjetaPais3);
        assertEquals(7,unJugador.realizarCanje(tarjetasCanje));
    }
    @Test
    public void test07JugadorHaceTresOMasCanjesYRecibeDiezEjercitos(){
        Jugador unJugador = new Jugador();
        ArrayList<TarjetaPais> tarjetasCanje = new ArrayList<TarjetaPais>();

        TarjetaPais tarjetaPais1 = new TarjetaPais(new Canion(), "Brasil");
        TarjetaPais tarjetaPais2 = new TarjetaPais(new Canion(), "Inglaterra");
        TarjetaPais tarjetaPais3 = new TarjetaPais(new Canion(), "España");
        unJugador.obtenerTarjeta(tarjetaPais1);
        unJugador.obtenerTarjeta(tarjetaPais2);
        unJugador.obtenerTarjeta(tarjetaPais3);
        unJugador.realizarCanje(tarjetasCanje);
        unJugador.obtenerTarjeta(tarjetaPais1);
        unJugador.obtenerTarjeta(tarjetaPais2);
        unJugador.obtenerTarjeta(tarjetaPais3);
        unJugador.realizarCanje(tarjetasCanje);
        unJugador.obtenerTarjeta(tarjetaPais1);
        unJugador.obtenerTarjeta(tarjetaPais2);
        unJugador.obtenerTarjeta(tarjetaPais3);
        assertEquals(10,unJugador.realizarCanje(tarjetasCanje));
    }
    @Test
    public void test08JugadorHaceCuartoCanjeYRecibeQuinceEjercitos(){
        Jugador unJugador = new Jugador();
        ArrayList<TarjetaPais> tarjetasCanje = new ArrayList<TarjetaPais>();
        TarjetaPais tarjetaPais1 = new TarjetaPais(new Canion(), "Brasil");
        TarjetaPais tarjetaPais2 = new TarjetaPais(new Canion(), "Inglaterra");
        TarjetaPais tarjetaPais3 = new TarjetaPais(new Canion(), "España");
        unJugador.obtenerTarjeta(tarjetaPais1);
        unJugador.obtenerTarjeta(tarjetaPais2);
        unJugador.obtenerTarjeta(tarjetaPais3);
        unJugador.realizarCanje(tarjetasCanje);
        unJugador.obtenerTarjeta(tarjetaPais1);
        unJugador.obtenerTarjeta(tarjetaPais2);
        unJugador.obtenerTarjeta(tarjetaPais3);
        unJugador.realizarCanje(tarjetasCanje);
        unJugador.obtenerTarjeta(tarjetaPais1);
        unJugador.obtenerTarjeta(tarjetaPais2);
        unJugador.obtenerTarjeta(tarjetaPais3);
        unJugador.realizarCanje(tarjetasCanje);
        unJugador.obtenerTarjeta(tarjetaPais1);
        unJugador.obtenerTarjeta(tarjetaPais2);
        unJugador.obtenerTarjeta(tarjetaPais3);
        assertEquals(15,unJugador.realizarCanje(tarjetasCanje));
    }
    @Test
    public void test09JugadorHaceQuintoCanjeYRecibeVeinteEjercitos(){
        Jugador unJugador = new Jugador();
        ArrayList<TarjetaPais> tarjetasCanje = new ArrayList<TarjetaPais>();
        TarjetaPais tarjetaPais1 = new TarjetaPais(new Canion(), "Brasil");
        TarjetaPais tarjetaPais2 = new TarjetaPais(new Canion(), "Inglaterra");
        TarjetaPais tarjetaPais3 = new TarjetaPais(new Canion(), "España");
        unJugador.obtenerTarjeta(tarjetaPais1);
        unJugador.obtenerTarjeta(tarjetaPais2);
        unJugador.obtenerTarjeta(tarjetaPais3);
        unJugador.realizarCanje(tarjetasCanje);
        unJugador.obtenerTarjeta(tarjetaPais1);
        unJugador.obtenerTarjeta(tarjetaPais2);
        unJugador.obtenerTarjeta(tarjetaPais3);
        unJugador.realizarCanje(tarjetasCanje);
        unJugador.obtenerTarjeta(tarjetaPais1);
        unJugador.obtenerTarjeta(tarjetaPais2);
        unJugador.obtenerTarjeta(tarjetaPais3);
        unJugador.realizarCanje(tarjetasCanje);
        unJugador.obtenerTarjeta(tarjetaPais1);
        unJugador.obtenerTarjeta(tarjetaPais2);
        unJugador.obtenerTarjeta(tarjetaPais3);
        unJugador.realizarCanje(tarjetasCanje);
        unJugador.obtenerTarjeta(tarjetaPais1);
        unJugador.obtenerTarjeta(tarjetaPais2);
        unJugador.obtenerTarjeta(tarjetaPais3);
        assertEquals(20,unJugador.realizarCanje(tarjetasCanje));
    }
    @Test
    public void test10JugadorHacePrimerCanjeYColocaLosNuevosEjercitosCorrectamente(){
        Jugador unJugador = new Jugador();
        Pais unPais = new Pais("Argentina");
        ArrayList<TarjetaPais> tarjetasCanje = new ArrayList<TarjetaPais>();

        unPais.asignarJugador(unJugador);
        TarjetaPais tarjetaPais1 = new TarjetaPais(new Canion(), "Brasil");
        TarjetaPais tarjetaPais2 = new TarjetaPais(new Canion(), "Inglaterra");
        TarjetaPais tarjetaPais3 = new TarjetaPais(new Canion(), "España");
        unJugador.obtenerTarjeta(tarjetaPais1);
        unJugador.obtenerTarjeta(tarjetaPais2);
        unJugador.obtenerTarjeta(tarjetaPais3);
        unJugador.colocarEjercitosCanje(unJugador.realizarCanje(tarjetasCanje), unPais);
        assertEquals(5, unPais.cantidadDeEjercitos());
    }
    @Test
    public void test11JugadorHaceAtaquesDelJuego(){
        Pais pais = new Pais("Argentina");
        Pais unPais = new Pais("Brasil");
        Jugador jugador = new Jugador();
        Jugador unJugador = new Jugador();

        pais.asignarJugador(jugador);
        unPais.asignarJugador(unJugador);
        pais.sonLimitrofesEntre(unPais);
        pais.colocarEjercitos(5, jugador.obtenerFicha());

        ArrayList<Pais> paisesEnemigos= new ArrayList<>();

        paisesEnemigos.add(unPais);

        HashMap<String, ArrayList<Pais>> hash = new HashMap<>();

        hash.put(pais.obtenerNombre(), paisesEnemigos);
        jugador.hacerAtaques(pais, hash.get(pais.obtenerNombre()));
    }
    @Test
    public void test12(){
        Jugador jugador = new Jugador();
        ArrayList<TarjetaPais> tarjetasCanje = new ArrayList<TarjetaPais>();

        jugador.colocarEjercitosDeCanje(2, tarjetasCanje);
    }
}
