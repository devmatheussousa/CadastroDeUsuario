package dev.java10x.Atividades;

public class AtividadeMapper {

    //caminho
    public AtividadeModel map(AtividadeDTO dto){
        AtividadeModel atividadeModel = new AtividadeModel();
        atividadeModel.setId(dto.getId());
        atividadeModel.setName(dto.getName());
        atividadeModel.setDescription(dto.getDescription());
        atividadeModel.setType(dto.getType());
        atividadeModel.setImgUrl(dto.getImgUrl());
        return atividadeModel;
    }


    //caminho inverso
    public AtividadeDTO map(AtividadeModel model){
        AtividadeDTO dto = new AtividadeDTO();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setDescription(model.getDescription());
        dto.setType(model.getType());
        dto.setImgUrl(model.getImgUrl());
        return dto;
    }
}
