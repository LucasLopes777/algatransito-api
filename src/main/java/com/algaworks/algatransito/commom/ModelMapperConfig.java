package com.algaworks.algatransito.commom;

import com.algaworks.algatransito.api.model.VeiculoRepresentationModel;
import com.algaworks.algatransito.domain.model.Veiculo;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){

        var modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Veiculo.class, VeiculoRepresentationModel.class)
                .addMappings(mapping -> mapping.map(Veiculo::getPlaca, VeiculoRepresentationModel::setPlaca));

        return  new ModelMapper();
    };

}
