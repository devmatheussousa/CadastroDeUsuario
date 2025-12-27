package dev.java10x.Atividades;

import dev.java10x.Usuarios.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/listar")
    public ResponseEntity<List<AtividadeDTO>> listarAtividades() {
        List<AtividadeDTO> atividades = atividadeService.listarTodasAtividades();
        return ResponseEntity.status(HttpStatus.OK).body(atividades);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<?> listarAtividadePorId(@PathVariable long id) {
        AtividadeDTO atividade = atividadeService.listarPorId(id);
        if (atividade != null) {
            return ResponseEntity.status(HttpStatus.OK).body(atividade);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atividade não encontrada");
    }

    //localhost/8080/atividades/criar -> metodo POST
    @PostMapping("/criar")
    public ResponseEntity<String> criarAtividade(@RequestBody AtividadeDTO atividadeDTO) {
        AtividadeDTO novaAtividade = atividadeService.criarNovaAtividade(atividadeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Atividade criada com sucesso: " + novaAtividade.getName() + " com ID: " + novaAtividade.getId());
    }


    //Esse end point é para atualizar uma atividade existente
    @PutMapping("/atualizar{id}")
    public ResponseEntity<?> atualizarAtividade(@PathVariable Long id, @RequestBody AtividadeDTO atualizarAtivida) {
        AtividadeDTO atividadeAtualizada = atividadeService.atualizarAtividade(id, atualizarAtivida);
        if (atividadeAtualizada != null) {
            return ResponseEntity.status(HttpStatus.OK).body(atividadeAtualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atividade não encontrada");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarAtividade(@PathVariable Long id) {
        if(atividadeService.listarPorId(id) != null){
            atividadeService.deletarAtividadePorId(id);
            return ResponseEntity.status(HttpStatus.OK).body("Atividade deletado com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atividade não encontrada");
        }
    }
}
