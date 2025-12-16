package dev.java10x;
/*
    Definir a entidade User, representando um colaborador do sistema, contendo atributos como nome, department, position e technical skills.
     */

import jakarta.persistence.*;

@Entity //Anotação que indica que esta classe é uma entidade JPA
@Table(name = "tb_user_registration") //Anotação que define o nome da tabela no banco de dados
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //identificador único do usuário
    private String name; //nome ex: joão da silva
    private String department; //departamento ex: tecnologia da informação
    private String position; //posição ex: desenvolvedor júnior
    private String technicalSkills; //habilidades técnicas ex: Java, Spring Boot, SQL

    protected UserModel() {

    }

    public UserModel(String name, String department, String position, String technicalSkills) {
        this.name = name;
        this.department = department;
        this.position = position;
        this.technicalSkills = technicalSkills;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTechnicalSkills() {
        return technicalSkills;
    }

    public void setTechnicalSkills(String technicalSkills) {
        this.technicalSkills = technicalSkills;
    }
}
