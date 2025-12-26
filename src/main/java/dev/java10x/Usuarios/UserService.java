package dev.java10x.Usuarios;

import dev.java10x.Atividades.AtividadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@RequiredArgsConstructor
@Service
public class UserService {

    //Ultilizar injecao de pedencia via construtor quando nao tiver final
    //se tiver final ultiliza @RequidArgsConstructor
    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    //Lista todos meus Usuario
    //criar um método para listar todos os usuários
     public List<UserDTO> listarTodosUsuarios(){
        List<UserModel> users = userRepository.findAll(); //buscando todos os usuários no banco de dados
        //verificar se a lista está vazia
        if(users.isEmpty()){
            return List.of(); //retorna uma lista vazia
        }
        return users.stream()
                .map(userMapper::map) //mapeando cada usuário para um DTO
                .collect(Collectors.toList()); //retorna uma lista de DTO
    }

    //listar Usuario por id
    //criar um mét-odo para listar um usuário por id
    public UserDTO listarPorId(Long id){
        Optional<UserModel> userById = userRepository.findById(id); //Optional e como se fosse uma lista, pode ser vazio ou conter um valor
        return userById.stream()
                .map(userMapper::map) //mapeando o usuário para um DTO
                .findFirst().orElse(null); //retorna o usuário se encontrado, caso contrário retorna null
    }

    //criar um novo usuário
    //criar um mét.odo para criar um novo usuário
    public UserDTO criarNovoUsuario(UserDTO dto){
        //convertendo o DTO para Model -> lembra caminho
        UserModel userModel = userMapper.map(dto);
        //salvando o usuário no banco de dados
        userModel = userRepository.save(userModel);
        //convertendo o Model para DTO -> lembra caminho invertido
        return userMapper.map(userModel);
    }

    //deletar um usuário por id
    //criar um mét.odo para deletar um usuário por id
    public void deletarUsuarioPorId(Long id){
        //verificar se o usuário existe
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }else{
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    //Atualizar ninja

    /**
     * Para Atualiza o ninja primeiro devemos passar o id para ele buscar no nosso banco se existe um usuario com esse id
     * mas devemos passar outro parametro parecido JSON que é o usuario vai atualizar com os novos dados no caso e o UserModel userAtualizado
     * Se o usuario existe ele vai atualizar os dados com os novos dados que foram passados setando os novos dados no usuario
     * @param id
     * @param dtoAtualizado
     * @return
     *
     * vamos criar uma logica simples depois vamos refatorar para algo mais robusto
     */
    public UserDTO atualizarUsuario(Long id, UserDTO dtoAtualizado){
        Optional<UserModel> userExistente = userRepository.findById(id);
        if(userExistente.isPresent()){
            UserModel userAtualizado =  userMapper.map(dtoAtualizado); //convertendo o DTO para Model
            userAtualizado.setId(id); //setando o id do usuário atualizado para o id do usuário existente
            return userMapper.map(userRepository.save(userAtualizado)); //salvando o usuário atualizado no banco de dados e convertendo para DTO
        }
        return null;
    }










}

