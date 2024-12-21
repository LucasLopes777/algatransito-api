package com.algaworks.algatransito.api.model;

import com.algaworks.algatransito.domain.model.StatusVeiculo;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class VeiculoRepresentationModel {

    private Long id;
    private ProprietarioResumoRepresentationModel proprietario;
    private String marca;
    private String modelo;
    private String placa;
    private StatusVeiculo status;
    private OffsetDateTime dataCadastro;
    private OffsetDateTime dataApreensao;


}
