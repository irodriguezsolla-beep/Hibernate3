package Services;

import HibernateConfig.HibernateConfig;
import Models.Adestrador;
import Models.Pokedex;
import Models.Pokemon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.util.List;

public class PokemonServices{
    //session
    public void crearPokemon(String Nome, Date nacemento, Pokedex pokedexEntry, Adestrador adestrador) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokemon NePokemon = new Pokemon();
            NePokemon.setNome(Nome);
            NePokemon.setNacemento(nacemento);
            NePokemon.setPokedexEntry(pokedexEntry);
            NePokemon.setAdestrador(adestrador);
            session.save(NePokemon);
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePokemon(Long id, String Nome, Date nacemento, Pokedex pokedexEntry, Adestrador adestrador) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokemon updatePokemon = session.get(Pokemon.class, id);
            if (updatePokemon != null) {
                updatePokemon.setNome(Nome);
                updatePokemon.setNacemento(nacemento);
                updatePokemon.setPokedexEntry(pokedexEntry);
                updatePokemon.setAdestrador(adestrador);
                session.update(updatePokemon);

            } else {
                System.out.println("Pokemon no encontrado");
            }
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    public Pokemon lerPokemon(String Nome) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Pokemon.class, Nome);
        } catch (Exception e) {
            System.out.println("Erro ao ler o Pokemon: " + e.getMessage());
            return null;
        }
    }

    public void actualizarPokemon(Pokemon Pokemon) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(Pokemon);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Pokemon no encontrado: " + e.getMessage());
        }
    }

    public void eliminarPokemon(Long Id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Pokemon pokemon = session.get(Pokemon.class, Id);
            if (pokemon != null) {
                session.delete(pokemon);
            } else {
                System.out.println("non se atopou o pokemon");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //createQuery()
    public List<Pokemon> listarPokemon() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Pokemon", Pokemon.class).getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao lista-los pokemons: " + e.getMessage());
            return null;
        }
    }

    public void eliminarPokemonNombre(String nome) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Pokemon> pokemonList = (List<Pokemon>) session.createQuery("from Pokemon where Nome = :Nome",Pokemon.class)
                    .setParameter("Nome", nome)
                    .getResultList();

            if (!pokemonList.isEmpty()) {
                Pokemon pokemon = pokemonList.getFirst();
                session.delete(pokemon);
                System.out.println("Pokemon: " + nome + " eliminado correctamente.");
            } else {
                System.out.println("Non se atopou o Pokemon co nome " + nome + ".");
            }

            transaction.commit();
        } catch (Exception e) {
            System.out.println("Non quero eliminar ningun gatiño Y.Y: " + e.getMessage());
        }
    }
}