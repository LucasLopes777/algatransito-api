package com.algaworks.algatransito.api.controller;

import com.algaworks.algatransito.api.assembler.AutuacaoAssempler;
import com.algaworks.algatransito.api.model.AutuacaoRepresentationModel;
import com.algaworks.algatransito.api.model.input.AutuacaoInput;
import com.algaworks.algatransito.domain.Service.RegistroAutuacaoService;
import com.algaworks.algatransito.domain.Service.RegistroVeiculoService;
import com.algaworks.algatransito.domain.model.Autuacao;
import com.algaworks.algatransito.domain.model.Veiculo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos/{veiculoId}/autuacoes")
public class AutuacaoController {

    private final AutuacaoAssempler autuacaoAssempler;
    private final RegistroAutuacaoService registroAutuacaoService;
    private final RegistroVeiculoService registroVeiculoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutuacaoRepresentationModel registrar(@PathVariable Long veiculoId,
                                                 @Valid @RequestBody AutuacaoInput autuacaoInput) {

        Autuacao novaAutuacao = autuacaoAssempler.toEntity(autuacaoInput);
        Autuacao autuacaoRegistrada = registroAutuacaoService.registrar(veiculoId, novaAutuacao);

        return autuacaoAssempler.toModel(autuacaoRegistrada);
    }

    @GetMapping
    public List<AutuacaoRepresentationModel> listar(@PathVariable Long veiculoId) {
        Veiculo veiculos = registroVeiculoService.buscar(veiculoId);

        return autuacaoAssempler.toCollectionModel(veiculos.getAutuacoes());
    }
}
