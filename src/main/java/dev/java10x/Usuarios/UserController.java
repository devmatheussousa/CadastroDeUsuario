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
    public UserDTO criarUsuario(@RequestBody UserDTO userDTO){
        return userService.criarNovoUsuario(userDTO);
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
    //Passa os dois argumentos, o id para buscar o usuario e o userAtualizado para atualizar os dados do usuario
    //O put vai atulizar toda a estrutura do usuario, ou seja, se eu passar apenas um campo ele vai atualizar apenas aquele campo vai ser atualizado
    //e se eu passar todos os campos ele vai atualizar todos os campos caso eu nao passe todos os campo os campo que eu nao passar ele vai ficar com null
    @PutMapping("/atualizar/{id}")
    public UserModel atualizarUsuario(@PathVariable Long id, @RequestBody UserModel userAtualizado){
        return userService.atualizarUsuario(id, userAtualizado);
    }

    //Deletar Usuario (DELETE - Delete)
    @DeleteMapping("/deletar/{id}")
    public void deletarUsuarioPorId(@PathVariable Long id){
        userService.deletarUsuarioPorId(id);
    }

}
