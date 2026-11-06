import Models.Adestrador;
import Models.Pokedex;
import Models.Pokemon;
import Services.AdestradorServices;
import Services.PokedexServices;
import  Services.PokemonServices;
import HibernateConfig.HibernateConfig;
import Services.PokemonServices;
import XML.toXML;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        PokedexServices service = new PokedexServices();
        AdestradorServices service2 = new AdestradorServices();
        PokemonServices service3 = new PokemonServices();

        // 1. Inserir 10 pokemons (usando crearPokedex)
        System.out.println("--- Insertando 12 Pokémons ---");

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
        service.crearPokedex("Gengar", 40.5, "Fantasma/Veneno");
        service.crearPokedex("Eevee", 6.5, "Normal");

        // Inserir 2 adestradores na taboa adestrador


        System.out.println("--- Insertando 2 adestradores ---");
        try {
            /* dataAsh = .parse("22/05/1997");
            Date dataMisty = sdf.parse("09/01/1998");
*/
            service2.crearAdestrador("Ash", null);
            service2.crearAdestrador("Misty", null);
            System.out.println("Os dous adestradores foron engadidos con éxito.");
        } catch (Exception e) {
            System.err.println("Erro ao engadir adestradores: " + e.getMessage());
        }
        //Inserir 12 pokemons na taboa de pokemon (6 para cada adestrador)
        System.out.println("--- Insertando 6 a cada entrenador ---");
        List<Pokedex> pokemons = service.listarPokedex();
        List<Adestrador> adestrador = service2.listarAdestrador();

        if (pokemons != null && adestrador != null && adestrador.size() >= 2) {
            for (int i = 0; i < pokemons.size(); i++) {
                Pokedex p = pokemons.get(i);
                Adestrador a;
                if (i < 6) {
                    a = adestrador.get(0);
                } else {
                    a = adestrador.get(1);
                }
                service3.crearPokemon(p.getNome(), null, p, a);
            }
        }
        System.out.println("--- Leer tabla Pokemon---");
        List<Pokemon> pokemon = service3.listarPokemon();
        if(pokemon != null){
            for(Pokemon p : pokemon){
                System.out.println(p);
            }
        }
    }



}