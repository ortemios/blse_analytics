package com.itmo.blse.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WinRatioDto {
    Double gameWinRatio;
    Double matchWinRatio;
}
