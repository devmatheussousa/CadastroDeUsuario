package dev.java10x.Usuarios;

import dev.java10x.Atividades.AtividadeModel;
import dev.java10x.Atividades.AtividadeRepository;
import dev.java10x.Atividades.AtividadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@RequiredArgsConstructor
@Service
public class UserService {

    private AtividadeRepository atividadeRepository;
    //Ultilizar injecao de pedencia via construtor quando nao tiver final
    //se tiver final ultiliza @RequidArgsConstructor
    private UserRepository userRepository;

    public UserService(UserRepository userRepository, AtividadeRepository atividadeRepository){
        this.userRepository = userRepository;
        this.atividadeRepository = atividadeRepository;
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
    public UserModel criarNovoUsuario(UserModel userModel){
        return userRepository.save(userModel);
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










}

