package dev.java10x.Atividades;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtividadeService {

    private AtividadeRepository atividadeRepository;

    public AtividadeService(AtividadeRepository atividadeRepository){
        this.atividadeRepository = atividadeRepository;
    }

    //criar metodo lista todos
    public List<AtividadeModel> listarTodasAtividades(){
        //verificar se a lista está vazia
        if(atividadeRepository.findAll().isEmpty()){
            return List.of(); //retorna uma lista vazia
        }
        return atividadeRepository.findAll();
    }

    //listar atividades por id
    public AtividadeModel listarPorId(long id){
        Optional<AtividadeModel> atividadesById = atividadeRepository.findById(id);
        return atividadesById.orElse(null); //retorna a atividade se encontrado, caso contrário retorna null
    }

    //criar um novo método para salvar uma atividade
    public AtividadeModel salvarAtividade(AtividadeModel atividadeModel){
        return atividadeRepository.save(atividadeModel);
    }

    //deletar um atividade
    public void deletarAtividadePorId(Long id){
        if(atividadeRepository.existsById(id)){
            atividadeRepository.deleteById(id);
        }else{
            throw new RuntimeException("Atividade não encontrada");
        }
    }




}
