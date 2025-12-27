package dev.java10x.Atividades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.Usuarios.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtividadeDTO {
    private Long id;
    private String name;
    private String description;
    private String type;
    private String imgUrl;
    List<UserModel> user;
}
