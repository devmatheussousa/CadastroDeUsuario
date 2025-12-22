package dev.java10x.Usuarios;
/*
    Definir a entidade User, representando um colaborador do sistema, contendo atributos como nome, department, position e technical skills.
     */

import dev.java10x.Atividades.AtividadeModel;
import jakarta.persistence.*;
import lombok.*;

@Entity //Anotação que indica que esta classe é uma entidade JPA
@Table(name = "tb_user_registration") //Anotação que define o nome da tabela no banco de dados
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //identificador único do usuário

    private String name; //nome ex: joão da silva

    @Column(unique = true)
    private String email; //email ex:

    private String department; //departamento ex: tecnologia da informação

    private String position; //posição ex: desenvolvedor júnior

    private String technicalSkills; //habilidades técnicas ex: Java, Spring Boot, SQL

    // Muitos usuários podem estar associados a uma única atividade
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "atividades_id") //Foreing Key ou chave estrangeira para a tabela de atividades
    private AtividadeModel atividade;



}
