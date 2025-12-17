package dev.java10x.Atividades.model;

import dev.java10x.Usuarios.UserModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_atividade_registration")
public class AtividadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único da atividade

    private String name; // e.g., "Implementar login"

    private String description; // e.g., "Criar a funcionalidade de login usando Spring Security"

    private String type; // e.g., "Tarefa", "Bug", "Melhoria"


    //uma atividade pode ter muitos usuários associados a ela
    @OneToMany(mappedBy = "atividade",cascade = CascadeType.ALL) //Relacionamento um-para-muitos com AtividadeModel
    List<UserModel> user; // Lista de usuários associados a esta atividade

    protected AtividadeModel() {
    }

    public AtividadeModel(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
