package dev.java10x.Atividades;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AtividadeService {

    private AtividadeRepository atividadeRepository;
    private AtividadeMapper atividadeMapper;

    public AtividadeService(AtividadeRepository atividadeRepository, AtividadeMapper atividadeMapper) {
        this.atividadeRepository = atividadeRepository;
        this.atividadeMapper = atividadeMapper;
    }

    //criar metodo lista todos
    public List<AtividadeDTO> listarTodasAtividades(){
       List<AtividadeModel> atividades = atividadeRepository.findAll();
        if(atividades.isEmpty()){
            return List.of(); //retorna uma lista vazia
        }
        return atividades.stream()
                .map(atividadeMapper::map) //mapeando cada atividade para um DTO
                .collect(Collectors.toList()); //retorna uma lista de DTO
    }

    //listar atividades por id
    public AtividadeDTO listarPorId(Long id){
        Optional<AtividadeModel> atividadesById = atividadeRepository.findById(id);
        return atividadesById.stream()
                .map(atividadeMapper::map) //mapeando a atividade para um DTO
                .findFirst().orElse(null); //retorna a atividade se encontrado, caso contrário retorna null
    }

    public AtividadeDTO criarNovaAtividade(AtividadeDTO dto){
        //convertendo o DTO para Model -> lembra caminho
        AtividadeModel atividadeModel = atividadeMapper.map(dto);
        //salvando a atividade no banco de dados
        atividadeModel = atividadeRepository.save(atividadeModel);
        //convertendo o Model para DTO -> lembra caminho invertido
        return atividadeMapper.map(atividadeModel);
    }

    //criar um novo método para salvar uma atividade
    public AtividadeDTO atualizarAtividade(Long id, AtividadeDTO atividadeDTO){
        Optional<AtividadeModel> atividadeModel = atividadeRepository.findById(id);
        if(atividadeModel.isPresent()){
            AtividadeModel atividadeAtualiza = atividadeMapper.map(atividadeDTO);
            atividadeAtualiza.setId(id);
            return atividadeMapper.map(atividadeRepository.save(atividadeAtualiza));
        }
        return null;
    }

    //deletar uma atividade
    public void deletarAtividadePorId(Long id){
        if(atividadeRepository.existsById(id)){
            atividadeRepository.deleteById(id);
        }else{
            throw new RuntimeException("Atividade não encontrada");
        }
    }
}
