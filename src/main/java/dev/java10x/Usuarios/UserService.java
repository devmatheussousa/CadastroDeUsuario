package dev.java10x.Usuarios;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return userRepository.findAll();
    }









}

