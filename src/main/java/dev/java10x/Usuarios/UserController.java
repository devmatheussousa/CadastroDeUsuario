package dev.java10x.Usuarios;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    //Mock de rota de boas-vindas e retorno de mensagem

    private final UserService userService;

    /*
    CRUD - Create, Read, Update, Delete
     */

    //adicionar Usuario (POST - Create)
    @PostMapping("/criar")
    //O @RequestBody e usado quando eu quero que o utilizador mande para min algo que vai compor o corpo da requisição (JSON)
    //@RequestBody - para pegar o valor do corpo da requisição (JSON)
    //vamos pegar esse JSON serializado e transformar num objeto UserModel e salvar no banco de dados
    public ResponseEntity<String> criarUsuario(@RequestBody UserDTO userDTO) {
        UserDTO novoUser = userService.criarNovoUsuario(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario criado com sucesso: " + novoUser.getName() + " com (id): " + novoUser.getId());
    }

    //Mostrar todos os Usuarios (GET - Read)
    @GetMapping("/todos")
    public ResponseEntity<List<UserDTO>> mostrarUsuarios() {
        List<UserDTO> usuarios = userService.listarTodosUsuarios();
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }

    //Mostrar usuario por id (GET - Read)
    //@PathVariable - para pegar o valor da variável de caminho, quando eu quero que o usuário mande para min algo que vai compor a rota (URL)
    //transforma o meu Long id como parte da minha rota ou URI {id} <- @PathVariable
    @GetMapping("/todos/{id}")
    public ResponseEntity<UserDTO> buscarUsuarioPorId(@PathVariable Long id) {
        UserDTO buscarPorId = userService.listarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(buscarPorId);
    }

    //Alterar dados do Usuario (PUT - Update)
    //Passa os dois argumentos, o id para buscar o usuario e o userAtualizado para atualizar os dados do usuario
    //O put vai atualizar toda a estrutura do usuário, ou seja, se eu passar apenas um campo ele vai atualizar apenas aquele campo vai ser atualizado
    //e se eu passar todos os campos ele vai atualizar todos os campos caso eu não passe todos os campo os campo que eu não passar ele vai ficar com null
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<UserDTO> atualizarUsuario(@PathVariable Long id, @RequestBody UserDTO userAtualizado) {
        UserDTO atualizarUser = userService.atualizarUsuario(id, userAtualizado);
        return ResponseEntity.status(HttpStatus.OK).body(atualizarUser);
    }

    //Deletar Usuario (DELETE - Delete)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarUsuarioPorId(@PathVariable Long id) {
        if (userService.listarPorId(id) != null) {
            userService.deletarUsuarioPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario com id: " + id + " deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro usuario com id: " + id + " não foi encontrado para deletar!");
        }
    }

}
