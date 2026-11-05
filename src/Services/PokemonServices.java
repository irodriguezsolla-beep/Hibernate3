package Services;

import HibernateConfig.HibernateConfig;
import Models.Adestrador;
import Models.Pokedex;
import Models.Pokemon;
import org.hibernate.Session;
import org.hibernate.Transaction;


//session
public void crearPokemon(String Nome,Date nacemento, Pokedex pokedexEntry, Adestrador adestrador){
    try(Session session= HibernateConfig.getSessionFactory().openSession()){
        Transaction transaction = session.beginTransaction();
        Pokedex NePokemon = new Pokemon().getPokedexEntry();
        NePokemon.setNome(Nome);
        NePokemon.setNacemento(nacemento);
        NePokemon.setMisc(pokedexEntry);
        session.save(NPokemon);
        transaction.commit();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

public void updatePokedex(Long id, String Nome, double Peso,String Misc){
    try(Session session= HibernateConfig.getSessionFactory().openSession()){
        Transaction transaction = session.beginTransaction();
        Pokedex updatePokedex = session.get(Pokedex.class, id);
        if (updatePokedex != null ) {
            updatePokedex.setNome(Nome);
            updatePokedex.setPeso(Peso);
            updatePokedex.setMisc(Misc);
            session.update(updatePokedex);

        }else{
            System.out.println("Pokemon no encontrado");
        }
        transaction.commit();
    } catch (Exception e) {
        throw new RuntimeException(e);

    }
}

public Pokedex lerPokedex(String Nome) {
    try (Session session = HibernateConfig.getSessionFactory().openSession()) {
        return session.get(Pokedex.class, Nome);
    } catch (Exception e) {
        System.out.println("Erro ao ler o Pokemon: " + e.getMessage());
        return null;
    }
}

public void actualizarPokedex(Pokedex pokedex) {
    try (Session session = HibernateConfig.getSessionFactory().openSession()) {
        Transaction transaction = session.beginTransaction();
        session.update(pokedex);
        transaction.commit();
    } catch (Exception e) {
        System.out.println("Pokemon no encontrado: " + e.getMessage());
    }
}

public void eliminarPokedex(Long Id) {
    try (Session session = HibernateConfig.getSessionFactory().openSession()) {
        Transaction transaction = session.beginTransaction();
        Pokedex pokemon = session.get(Pokedex.class, Id);
        if (pokemon != null) {
            session.delete(pokemon);
        } else {
            System.out.println("non se atopou o pokemon");
        }
        transaction.commit();
    } catch (Exception e) {
        System.out.println( e.getMessage());
    }
}
//createQuery()
public List<Pokedex> listarPokedex() {
    try (Session session = HibernateConfig.getSessionFactory().openSession()) {
        return session.createQuery("from Pokedex", Pokedex.class).getResultList();
    } catch (Exception e) {
        System.out.println("Erro ao lista-los pokemons: " + e.getMessage());
        return null;
    }
}
public void eliminarPokemonNombre(String Nome, double Peso , String Misc) {
    try (Session session = HibernateConfig.getSessionFactory().openSession()) {
        Transaction transaction = session.beginTransaction();
        List<Pokedex> pokedexList = session.createQuery("from Pokedex where Nome = :Nome and Peso = :Peso and Misc = :Misc", Pokedex.class)
                .setParameter("Nome", Nome)
                .setParameter("Peso", Peso)
                .setParameter("Misc", Misc)
                .getResultList();

        if (!pokedexList.isEmpty()) {
            Pokedex pokemon = pokedexList.get(0);
            session.delete(pokemon);
            System.out.println("Pokemon: " + Nome + " eliminado correctamente.");
        } else {
            System.out.println("Non se atopou o Pokemon co nome " + Nome +".");
        }

        transaction.commit();
    } catch (Exception e) {
        System.out.println("Non quero eliminar ningun gatiño Y.Y: " + e.getMessage());
    }
}{
}
