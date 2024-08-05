package br.com.futurodev.project_utilities.model.transport;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Classe para armazenar as informações de um endereço")
public record ViaCepDTO(

        @Schema(
                description = "CEP do endereço",
                example = "54090-234"
        )
        String cep,

        @Schema(
                description = "Logradouro do endereço",
                example = "Avenida A"
        )
        String logradouro,

        @Schema(
                description = "Complemento do endereço",
                example = "Bloco A"
        )
        String complemento,

        @Schema(
                description = "Bairro do endereço",
                example = "Bairro A"
        )
        String bairro,

        @Schema(
                description = "Localidade do endereço",
                example = "Pernambuco"
        )
        String localidade,

        @Schema(
                description = "Unidade federativa do endereço",
                example = "PE"
        )
        String uf
) {
}
