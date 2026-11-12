import FileServices.FileServices;
import Models.Adestrador;
import Models.Pokedex;
import Models.Pokemon;
import Services.AdestradorServices;
import Services.PokedexServices;
import  Services.PokemonServices;
import java.time.LocalDate;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
        Date dataAsh = new GregorianCalendar(1997, Calendar.MAY, 22).getTime();
        Date dataMisty = new GregorianCalendar(1998, Calendar.JANUARY, 9).getTime();

        service2.crearAdestrador("Ash", dataAsh);
        service2.crearAdestrador("Misty", dataMisty);

        //Inserir 12 pokemons na taboa de pokemon (6 para cada adestrador)
        System.out.println("--- Insertando 6 a cada entrenador ---");
        List<Pokedex> pokedex = service.listarPokedex();
        List<Adestrador> adestrador = service2.listarAdestrador();

        if (pokedex != null && adestrador != null && adestrador.size() >= 2) {

            for (int i = 0; i < pokedex.size(); i++) {
                Pokedex p = pokedex.get(i);
                Adestrador a;
                if (i < 6) {
                    a = adestrador.get(0);
                } else {
                    a = adestrador.get(1);
                }
                service3.crearPokemon(p.getNome(), null, p, a);
            }
        }
        //leer tablas
        System.out.println("--- Leer tabla Pokemon1---");
        List<Pokemon> pokemon = service3.listarPokemon();
        if(pokemon != null){
            for(Pokemon p : pokemon){
                System.out.println(p);
            }
        }
        System.out.println("--- Leer tabla Adestrador1---");
        if(adestrador != null){
            for(Adestrador a : adestrador){
                System.out.println(a);
            }
        }

        System.out.println("--- Leer tabla Pokedex1---");
        if(pokedex != null){
            for(Pokedex p : pokedex){
                System.out.println(p);
            }
        }

        //Exportar nun arquivo duas entradas da pokedex serializadas.
        System.out.println("--- Exportar nun arquivo duas entradas da pokedex serializadas---");
        for(int i = 0; i<2; i++){
            FileServices.SerialPokedex(pokedex.get(i));
        }

        System.out.println("--Exportar en XML duas entradas de adestrador--");
        FileServices.Adestrador(adestrador,"Adestrador.xml");

        System.out.println("--Modificar duas entradas na pokedex--");
        if(pokedex != null){
            for(int i = 0; i<2; i++){
                double npeso = pokedex.get(i).getPeso() * 2;
                service.updatePokedex(pokedex.get(i).getId(),pokedex.get(i).getNome(),npeso,pokedex.get(i).getMisc());
            }
        }

        System.out.println("--Modificar dous adestradores--");
        if(adestrador != null){
            Date ndate = new GregorianCalendar(2000, Calendar.MAY, 22).getTime();
            for(Adestrador a : adestrador){
                service2.updateAdestrador(a.getId(),a.getNome(),ndate);
            }
        }

        System.out.println("--Modificar 4 pokemons--");
        if(pokemon != null){
            for(int i = 0; i<4; i++){
                String nNome = pokemon.get(i).getNome()+"-perdido";
                service3.updatePokemon(pokemon.get(i).getId(),nNome,null,pokemon.get(i).getPokedexEntry(),pokemon.get(i).getAdestrador());

            }
        }

        //leer tablas
        System.out.println("--- Leer tabla Pokemon2---");
        if(pokemon != null){
            for(Pokemon p : pokemon){
                System.out.println(p);
            }
        }
        System.out.println("--- Leer tabla Adestrador2---");
        if(adestrador != null){
            for(Adestrador a : adestrador){
                System.out.println(a);
            }
        }

        System.out.println("--- Leer tabla Pokedex2---");
        if(pokedex != null){
            for(Pokedex p : pokedex){
                System.out.println(p);
            }
        }

        System.out.println("--- Importar os datos serializados---");
        List<Pokedex> pokedex2 = FileServices.DeserializaPokedex("serial-Pokedex");

        System.out.println("--- Modifica-las entradas da pokédex coos datos serializados---");

        if(pokedex2 != null){
            for(Pokedex p: pokedex2){
                service.updatePokedex(p.getId(), p.getNome(),p.getPeso(),p.getMisc());
            }
        }

        System.out.println("--- Importar os datos xml---");
        List<Adestrador> adestrador2 = FileServices.importarAdestrador("Adestrador.xml");

        System.out.println("--- Modifica-las entradas de adestradores coos datos do arquivo---");
        if(adestrador2!= null){
            for(Adestrador a: adestrador2){
                service2.updateAdestrador(a.getId(),a.getNome(),a.getNacemento());
            }
        }

        List<Pokedex> pokedex3 = service.listarPokedex();
        List<Adestrador> adestrador3 = service2.listarAdestrador();
        List<Pokemon> pokemon3 = service3.listarPokemon();

        System.out.println("--- Leer tabla Pokemon3---");
        if(pokemon3 != null){
            for(Pokemon p : pokemon3){
                System.out.println(p);
            }
        }
        System.out.println("--- Leer tabla Adestrador3---");
        if(adestrador3 != null){
            for(Adestrador a : adestrador3){
                System.out.println(a);
            }
        }

        System.out.println("--- Leer tabla Pokedex3---");
        if(pokedex3 != null){
            for(Pokedex p : pokedex3){
                System.out.println(p);
            }
        }

        System.out.println("---Eliminar pokemons---");
        if(pokemon3 != null){
            for(Pokemon p : pokemon3){
               service3.eliminarPokemon(p.getId());
            }
        }
        System.out.println("--- Eliminar Adestradores---");
        if(adestrador3 != null){
            for(Adestrador a : adestrador3){
                service2.eliminarAdestrador(a.getId());
            }
        }

        System.out.println("--- Eliminar  Pokedex---");
        if(pokedex3 != null){
            for(Pokedex p : pokedex3){
                service.eliminarPokedex(p.getId());
            }
        }

    }
}