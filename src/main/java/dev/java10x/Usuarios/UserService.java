package dev.java10x.Usuarios;

import dev.java10x.Atividades.AtividadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
     public List<UserModel> listarTodosUsuarios(){
        //verificar se a lista está vazia
        if(userRepository.findAll().isEmpty()){
            return List.of(); //retorna uma lista vazia
        }
        return userRepository.findAll();
    }

    //listar Usuario por id
    //criar um mét-odo para listar um usuário por id
    public UserModel listarPorId(Long id){
        Optional<UserModel> userById = userRepository.findById(id);
        return userById.orElse(null); //retorna o usuário se encontrado, caso contrário retorna null
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
     * @param userAtualizado
     * @return
     *
     * vamos criar uma logica simples depois vamos refatorar para algo mais robusto
     */
    public UserModel atualizarUsuario(Long id, UserModel userAtualizado){
        if(userRepository.existsById(id)){
            userAtualizado.setId(id);
            return  userRepository.save(userAtualizado);
        }
        return null;
    }










}

