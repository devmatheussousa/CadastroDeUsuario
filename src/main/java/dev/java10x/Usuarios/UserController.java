package dev.java10x.Usuarios;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    //Mock de rota de boas vindas e retorno de mensagem

    private final UserService userService;

    /*
    CRUD - Create, Read, Update, Delete
     */

    //adicionar Usuario (POST - Create)
    @PostMapping("/criar")
    //O @RequestBody e usado quando eu quero que o usuario mande para min algo que vai compor o corpo da requisição (JSON)
    //@RequestBody - para pegar o valor do corpo da requisição (JSON)
    //vamos pegar esse JSON serializado e transformar em um objeto UserModel e salvar no banco de dados
    public UserModel criarUsuario(@RequestBody UserModel userModel){
        return userService.criarNovoUsuario(userModel);
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
    //@PathVariable - para pegar o valor da variável de caminho, quando eu quero que o usuario mande para min algo que vai compor a rota (URL)
    //transforma o meu Long id como parte da minha rota ou URI {id} <- @PathVariable
    @GetMapping("/todos/{id}")
    public String buscarUsuarioPorId(@PathVariable Long id){
        return userService.listarPorId(id).toString(); //toString() - para converter o objeto em uma string
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
