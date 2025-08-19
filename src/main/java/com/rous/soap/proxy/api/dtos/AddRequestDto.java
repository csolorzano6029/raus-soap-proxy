package com.rous.soap.proxy.api.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddRequestDto {

  @NotNull
  Integer a;

  @NotNull
  Integer b;
}
