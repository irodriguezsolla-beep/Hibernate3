package Models;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "pokedex")
public class Pokedex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "nome", nullable = false, length = 50)
    private String Nome;

    @Column(name = "peso", precision = 10, scale = 2)
    private double Peso;

    @Column(name = "misc")
    private String Misc;
    @OneToOne(mappedBy = "pokedexEntry")
    private Pokemon pokemon;
    public Pokedex(){}
    public Pokedex(Long id, String nome, double peso, String misc) {
        Id = id;
        Nome = nome;
        Peso = peso;
        Misc = misc;
    }

    public Pokedex(String misc, double peso, String nome) {
        Misc = misc;
        Peso = peso;
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

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double peso) {
        Peso = peso;
    }

    public String getMisc() {
        return Misc;
    }

    public void setMisc(String misc) {
        Misc = misc;
    }

    @Override
    public String toString() {
        return "Pokedex{" +
                "Id=" + Id +
                ", Nome='" + Nome + '\'' +
                ", Peso=" + Peso +
                ", Misc='" + Misc + '\'' +
                '}';
    }

    public void setNacemento(Date nacemento) {
    }
}
