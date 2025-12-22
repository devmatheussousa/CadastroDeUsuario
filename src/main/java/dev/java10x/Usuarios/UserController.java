package dev.java10x.Usuarios;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    //Mock de rota de boas vindas e retorno de mensagem

    private UserService userService;

    /*
    CRUD - Create, Read, Update, Delete
     */

    //adicionar Usuario (POST - Create)
    @PostMapping("/criar")
    public String criarUsuario(){
        return "Usuario criado";
    }

    //procurar Usuario por id (GET - Read)
    @GetMapping("/buscar")
    public String buscarUsuario(){
        return "Usuario encontrado";
    }

    //Mostrar todos os Usuarios (GET - Read)
    @GetMapping("/todos")
    public List<UserModel> mostrarUsuarios(){
        return userService.listarTodosUsuarios();
    }

    //Mostrar usuario por id (GET - Read)
    @GetMapping("/todos/id")
    public String buscarUsuarioPorId(){
        return "Usuario encontrado por id";
    }

    //Alterar dados do Usuario (PUT - Update)
    @PutMapping("/atualizar")
    public String atualizarUsuario(){
        return "Usuario atualizado";
    }

    //Deletar Usuario (DELETE - Delete)
    @DeleteMapping("/deletar/id")
    public String deletarUsuarioPorId(){
        return "Usuario deletado por id com sucesso";
    }

}
