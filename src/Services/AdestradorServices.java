package Services;

import HibernateConfig.HibernateConfig;
import Models.Adestrador;
import Models.Pokedex;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

public class AdestradorServices {
    public void crearAdestrador(String Nome, Date Nacemento){
        try(Session session= HibernateConfig.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Adestrador cAdestrador = new Adestrador();
            cAdestrador.setNome(Nome);
            cAdestrador.setNacemento(Nacemento);
            session.save(cAdestrador);
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAdestrador(Long id, String Nome, Date Nacemento){
        try(Session session= HibernateConfig.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            Adestrador updateAdestrador = session.get(Adestrador.class, id);
            if (updateAdestrador != null ) {
                updateAdestrador.setNome(Nome);
                updateAdestrador.setNacemento(Nacemento);
                session.update(updateAdestrador);

            }else{
                System.out.println("Adestrador no encontrado");
            }
            transaction.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    public Adestrador lerAdestrador(String Nome) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(Adestrador.class, Nome);
        } catch (Exception e) {
            System.out.println("Erro ao ler o Adestrador: " + e.getMessage());
            return null;
        }
    }

    public void actualizarAdestrador(Adestrador adestrador) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(adestrador);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Adestrador no encontrado: " + e.getMessage());
        }
    }

    public void eliminarAdestrador(Long Id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Adestrador adestrador = session.get(Adestrador.class, Id);
            if (adestrador != null) {
                session.delete(adestrador);
            } else {
                System.out.println("non se atopou o adestrador");
            }
            transaction.commit();
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
    }
    //createQuery()
    public List<Adestrador> listarAdestrador() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Adestrador", Adestrador.class).getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao lista-los Adestrador " + e.getMessage());
            return null;
        }
    }
    public void eliminarAdestradorNombre(String Nome, Date Nacemento) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            List<Adestrador> adestradorList = session.createQuery("from Adestrador where Nome = :Nome and Nacemento = :Nacemento", Adestrador.class)
                    .setParameter("Nome", Nome)
                    .setParameter("Nacemento", Nacemento)
                    .getResultList();

            if (!adestradorList.isEmpty()) {
                Adestrador adestrador = adestradorList.get(0);
                session.delete(adestrador);
                System.out.println("Adestrador: " + Nome + " eliminado correctamente.");
            } else {
                System.out.println("Non se atopou o adestrado co nome " + Nome +".");
            }

            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
