package dev.java10x.Atividades;

import dev.java10x.Usuarios.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Localhost:8080 -> estamos querendo criar rotas pro meu servidor
@RestController // Isso é uma classe de controller, que vai receber requisições do usuario e devolver respostas
@RequestMapping("/atividades") // Isso é a rota que o usuario vai acessar para fazer requisições
// ele vai mapear as requisições para os metodos da classe
@RequiredArgsConstructor
public class AtividadesController {

    private final AtividadeService atividadeService;
    private final UserService userService;

    @GetMapping
    public List<AtividadeModel> listarAtividades(){
        return atividadeService.listarTodasAtividades();
    }

    @GetMapping("/todos/{id}")
    public AtividadeModel listarAtividadePorId(@PathVariable long id){
        return atividadeService.listarPorId(id);
    }

    //localhost/8080/atividades/criar -> metodo POST
    @PostMapping("/criar")
    public AtividadeModel criarAtividade(@RequestBody AtividadeModel atividadeModel){
        return atividadeService.salvarAtividade(atividadeModel);
    }


    @PutMapping("/atualizar")
    public String atualizarAtividade(){
        return "Atividade atualizada";
    }

    @DeleteMapping
    public String deletarAtividade(){
        return "Atividade deletada";
    }

}
