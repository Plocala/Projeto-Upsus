package org.acme.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Paciente extends Pessoa {
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 50, nullable = false)
    private String nomeMae;
    @Column(length = 3000,nullable = false)
    private String anotacao;
    @Column(nullable = false)
    private LocalDate dataNascimento;
    @Column(length = 20, nullable = false)
    private String cartaoSus;
    @Column(nullable = false)
    private boolean sexo;
    @Column(nullable = false)
    private LocalDate dataUltimaConsulta;
    @OneToMany(mappedBy = "paciente")
    private List<Exame> exames = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "tarefa_id")
    private List<Tarefa> tarefas = new ArrayList<>();
    
    private List<Condicao> condicoes = new ArrayList<>();


    public List<Condicao> getCondicoes() {
        return condicoes;
    }

    public void setCondicoes(List<Condicao> condicoes) {
        this.condicoes = condicoes;
    }

    @Column(length = 20, nullable = false)
    private String obs;



    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public List<Exame> getExame() {
        return exames;
    }

    public void setExame(List<Exame> exames) {
        this.exames = exames;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(String anotacao) {
        this.anotacao = anotacao;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCartaoSus() {
        return cartaoSus;
    }

    public void setCartaoSus(String cartaoSus) {
        this.cartaoSus = cartaoSus;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataUltimaConsulta() {
        return dataUltimaConsulta;
    }

    public void setDataUltimaConsulta(LocalDate dataUltimaConsulta) {
        this.dataUltimaConsulta = dataUltimaConsulta;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

}