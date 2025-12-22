package dev.java10x.Usuarios;

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

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
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










}

