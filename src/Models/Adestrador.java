package Models;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Adestrador")
public class Adestrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "Nome", nullable = false, length = 50)
    private String Nome;

    @Column(name = "Nacemento")
    private Date Nacemento;

    @OneToMany(mappedBy = "adestrador")
    private List<Pokemon> pokemons;

    public Adestrador(){}
    public Adestrador(Long id, String nome, Date nacemento) {
        Id = id;
        Nome = nome;
        Nacemento = nacemento;
    }

    public Adestrador(String nome, Date nacemento) {
        Nome = nome;
        Nacemento = nacemento;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getNacemento() {
        return Nacemento;
    }

    public void setNacemento(Date nacemento) {
        Nacemento = nacemento;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    @Override
    public String toString() {
        return "Adestrador{" +
                "Id=" + Id +
                ", Nome='" + Nome + '\'' +
                ", Nacemento=" + Nacemento +
                '}';
    }
}
