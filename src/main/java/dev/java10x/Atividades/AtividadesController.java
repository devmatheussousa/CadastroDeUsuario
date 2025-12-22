package dev.java10x.Atividades;

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

    @GetMapping
    public List<AtividadeModel> listarAtividades(){
        return atividadeService.listarTodasAtividades();
    }

    //localhost/8080/atividades/criar -> metodo POST
    @PostMapping("/criar")
    public String criarAtividade(){
        return "Atividade criada";
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
