package Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "nome", nullable = false, length = 50)
    private String Nome;

    @Column(name = "nacemento")
    private Date Nacemento;

    @OneToOne
    @JoinColumn(name = "pokedexEntry")
    private Pokedex pokedexEntry;

    @ManyToOne
    @JoinColumn(name = "adestrador")
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
