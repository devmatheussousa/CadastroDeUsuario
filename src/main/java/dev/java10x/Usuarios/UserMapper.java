package dev.java10x.Usuarios;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    //caminho
    public UserModel map(UserDTO userDTO){
        UserModel userModel = new UserModel();
        userModel.setId(userDTO.getId());
        userModel.setName(userDTO.getName());
        userModel.setEmail(userDTO.getEmail());
        userModel.setDepartment(userDTO.getDepartment());
        userModel.setPosition(userDTO.getPosition());
        userModel.setTechnicalSkills(userDTO.getTechnicalSkills());
        userModel.setLevel(userDTO.getLevel());
        userModel.setAtividade(userDTO.getAtividade());
        return userModel;
    }

    //caminho inverso
    public UserDTO map(UserModel userModel){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userModel.getId());
        userDTO.setName(userModel.getName());
        userDTO.setEmail(userModel.getEmail());
        userDTO.setDepartment(userModel.getDepartment());
        userDTO.setPosition(userModel.getPosition());
        userDTO.setTechnicalSkills(userModel.getTechnicalSkills());
        userDTO.setLevel(userModel.getLevel());
        userDTO.setAtividade(userModel.getAtividade());
        return userDTO;
    }
}
