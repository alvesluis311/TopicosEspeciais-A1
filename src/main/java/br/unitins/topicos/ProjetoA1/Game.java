package br.unitins.topicos.ProjetoA1;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "games")
public class Game {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String genero;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private String plataforma;

    @ManyToOne
    @JoinColumn(name = "developer", nullable = false)
    private Developer developer;

    @Column(nullable = false)
    private LocalDate dataLancamento;
    
    public Game() {
    }

    public Game(GameDTO gameDTO, Developer developer) {

        System.out.println("Developer no construtor: " + developer.getId());

        this.nome = gameDTO.nome();
        this.genero = gameDTO.genero();
        this.preco = gameDTO.preco();
        this.plataforma = gameDTO.plataforma();
        this.dataLancamento = gameDTO.dataLancamento();
        this.developer = developer;
    }

    public void setDados(GameDTO gameDTO, Developer developer) {

        this.nome = gameDTO.nome();
        this.genero = gameDTO.genero();
        this.preco = gameDTO.preco();
        this.plataforma = gameDTO.plataforma();
        this.dataLancamento = gameDTO.dataLancamento();
        this.developer = developer;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
}
