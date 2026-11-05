import Models.Adestrador;
import Models.Pokedex;
import Services.AdestradorServices;
import Services.PokedexServices;
import HibernateConfig.HibernateConfig;
import XML.toXML;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        PokedexServices service = new PokedexServices();
        AdestradorServices service2 = new AdestradorServices();

        // 1. Inserir 10 pokemons (usando crearPokedex)
        System.out.println("--- Insertando 10 Pokémons ---");
        service.crearPokedex("Bulbasaur", 6.9, "Planta/Veneno");
        service.crearPokedex("Charmander", 8.5, "Fogo");
        service.crearPokedex("Squirtle", 9.0, "Água");
        service.crearPokedex("Pikachu", 6.0, "Elétrico");
        service.crearPokedex("Jigglypuff", 5.5, "Normal/Fada");
        service.crearPokedex("Meowth", 4.2, "Normal");
        service.crearPokedex("Psyduck", 19.6, "Água");
        service.crearPokedex("Machop", 19.5, "Lutador");
        service.crearPokedex("Geodude", 20.0, "Pedra/Terra");
        service.crearPokedex("Snorlax", 460.0, "Normal");

        // Inserir 2 adestradores na taboa adestrador
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("--- Insertando 2 adestradores ---");
        try {
            Date dataAsh = sdf.parse("22/05/1997");
            Date dataMisty = sdf.parse("09/01/1998");

            service2.crearAdestrador("Ash", dataAsh);
            service2.crearAdestrador("Misty", dataMisty);
            System.out.println("Os dous adestradores foron engadidos con éxito.");
        } catch (Exception e) {
            System.err.println("Erro ao engadir adestradores: " + e.getMessage());
        }

        // 2. Listar pokemons na pokedex (usando listarPokedex)
        System.out.println("--- Listando Pokémons (1) ---");
        List<Pokedex> pokemons = service.listarPokedex();
        if (pokemons != null) {
            for (Pokedex p : pokemons) {
                System.out.println(p);
            }
        }

        // 3. Listar Adrestradores (usando listarAdestrador)
        System.out.println("--- Listando adestrador ---");
        List<Adestrador> adestrador = service2.listarAdestrador();
        if (adestrador != null) {
            for (Adestrador a : adestrador) {
                System.out.println(a);
            }
        }

        // 4. Modificar dous adestradores
        System.out.println("--- Modificando Adestradores ---");
        if (adestrador != null) {
            for (Adestrador a : adestrador) {
                try {
                    Date dataRojo = sdf.parse("30/06/2005");
                    service2.updateAdestrador(a.getId(), a.getNome(), dataRojo);
                } catch (Exception e) {
                    System.err.println("Erro ao modificar adestradores: " + e.getMessage());
                }
            }
        }

        // 5. Modificar duas entradas na pokedex
        System.out.println("--- Modificando Pokemons ---");
        if (pokemons != null) {
            double peso2 = 0;
            for (Pokedex p : pokemons) {
                peso2 = p.getPeso() * 2;
                service.updatePokedex(p.getId(), p.getNome(), peso2, p.getMisc());
            }
        }

        // 6. Listar pokemons na pokedex actualizados dende a BD
        System.out.println("--- Listando Pokémons (2) ---");
        pokemons = service.listarPokedex(); // Re-consultar a BD para ver as modificacións
        if (pokemons != null) {
            for (Pokedex p : pokemons) {
                System.out.println(p);
            }
        }

        // 7. Listar Adrestradores actualizados dende a BD
        System.out.println("--- Listando adestrador(2) ---");
        adestrador = service2.listarAdestrador(); // Re-consultar a BD para ver as modificacións
        if (adestrador != null) {
            for (Adestrador a : adestrador) {
                System.out.println(a);
            }
        }
        toXML.Adestrador(adestrador,"Adestrador.xml");
        toXML.Pokedex(pokemons,"Pokedex.xml");

        //9. Eliminar
        if (pokemons != null) {
            for (Pokedex p : pokemons) {
               service.eliminarPokedex(p.getId());
            }
        }
        if (adestrador != null) {
            for (Adestrador a : adestrador) {
                service2.eliminarAdestrador(a.getId());
            }
        }
    }
}