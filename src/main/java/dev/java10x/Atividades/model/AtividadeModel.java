package dev.java10x.Atividades.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_atividade")
public class AtividadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único da atividade
    private String name; // e.g., "Implementar login"
    private String description; // e.g., "Criar a funcionalidade de login usando Spring Security"
    private String type; // e.g., "Tarefa", "Bug", "Melhoria"
    private String status; // e.g., "Pendente", "Em andamento", "Concluído"

    protected AtividadeModel() {
    }

    public AtividadeModel(String name, String description, String status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
