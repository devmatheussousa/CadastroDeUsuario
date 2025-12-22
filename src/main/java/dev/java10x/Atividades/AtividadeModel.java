package dev.java10x.Atividades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.Usuarios.UserModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_atividade_registration")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AtividadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único da atividade

    @Column(name = "name")
    private String name; // e.g., "Implementar login"

    @Column(name = "description", length = 1000)
    private String description; // e.g., "Criar a funcionalidade de login usando Spring Security"

    @Column(name = "type")
    private String type; // e.g., "Tarefa", "Bug", "Melhoria"

    @Column(name = "img_url")
    private String imgUrl;

    //uma atividade pode ter muitos usuários associados a ela
    @OneToMany(mappedBy = "atividade", cascade = CascadeType.ALL) //Relacionamento um-para-muitos com AtividadeModel
    @JsonIgnore // Ignora a serialização da lista de usuários para evitar loops infinitos
    List<UserModel> user; // Lista de usuários associados a esta atividade
    //mappedBy mapeia o atributo "atividade" na classe UserModel
}
