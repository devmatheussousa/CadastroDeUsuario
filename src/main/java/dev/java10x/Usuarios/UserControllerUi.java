package dev.java10x.Usuarios;

import dev.java10x.Usuarios.UserDTO;
import dev.java10x.Usuarios.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user/ui")
public class UserControllerUi{

    private final UserService userService;

    public UserControllerUi(UserService userService) {
        this.userService = userService;
    }

    // 1️⃣ Abre a página (SEM tabela)
    @GetMapping
    public String telaInicial() {
        return "listarUsuarios";
    }

    // 2️⃣ Clique no botão "Listar todos" (COM tabela)
    @GetMapping("/listar")
    public String mostrarUsuarios(Model model) {
        List<UserDTO> usuarios = userService.listarTodosUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("mostrarTabela", true); // 🔥 ISSO É O QUE FALTAVA
        return "listarUsuarios";
    }
}
