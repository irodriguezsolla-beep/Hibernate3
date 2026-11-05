package Models;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "Nome", nullable = false, length = 50)
    private String Nome;

    @Column(name = "Nacemento")
    private Date Nacemento;

    @OneToOne
    @JoinColumn(name = "Id")
    private Pokedex pokedexEntry;

    @OneToMany
    @JoinColumn(name = "Id")
    private  Adestrador adestrador;

    public Pokemon() {}

    public Pokemon(String nome, Date nacemento, Pokedex pokedexEntry, Adestrador adestrador) {
        Nome = nome;
        Nacemento = nacemento;
        this.pokedexEntry = pokedexEntry;
        this.adestrador = adestrador;
    }

    public Pokemon(Long id, Adestrador adestrador, Pokedex pokedexEntry, Date nacemento, String nome) {
        Id = id;
        this.adestrador = adestrador;
        this.pokedexEntry = pokedexEntry;
        Nacemento = nacemento;
        Nome = nome;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Date getNacemento() {
        return Nacemento;
    }

    public void setNacemento(Date nacemento) {
        Nacemento = nacemento;
    }

    public Pokedex getPokedexEntry() {
        return pokedexEntry;
    }

    public void setPokedexEntry(Pokedex pokedexEntry) {
        this.pokedexEntry = pokedexEntry;
    }

    public Adestrador getAdestrador() {
        return adestrador;
    }

    public void setAdestrador(Adestrador adestrador) {
        this.adestrador = adestrador;
    }
}
