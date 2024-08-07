package br.com.futurodev.jwt_sample.model.transport;

import jakarta.validation.constraints.NotBlank;

public record LoginForm(@NotBlank String username, @NotBlank String password) {
}
