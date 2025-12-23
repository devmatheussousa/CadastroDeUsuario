package dev.java10x.Usuarios;

import dev.java10x.Atividades.AtividadeModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String department;
    private String position;
    private String technicalSkills;
    private String level;
    private AtividadeModel atividade;
}
