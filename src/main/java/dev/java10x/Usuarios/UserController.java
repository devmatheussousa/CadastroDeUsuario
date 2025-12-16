package dev.java10x.Usuarios;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/welcome")
    public String boasVinda(){
        return "Bem-vindo ao sistema de cadastro de usuários!";
    }

}
