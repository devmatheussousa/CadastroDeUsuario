package dev.java10x.Atividades;

import org.springframework.stereotype.Service;

import java.util.List;

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




}
